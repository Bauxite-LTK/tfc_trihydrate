package net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic;


import blusunrize.immersiveengineering.api.energy.AveragingEnergyStorage;
import blusunrize.immersiveengineering.api.fluid.FluidUtils;
import blusunrize.immersiveengineering.api.multiblocks.blocks.component.ComparatorManager;
import blusunrize.immersiveengineering.api.multiblocks.blocks.component.IClientTickableComponent;
import blusunrize.immersiveengineering.api.multiblocks.blocks.component.IServerTickableComponent;
import blusunrize.immersiveengineering.api.multiblocks.blocks.component.RedstoneControl;
import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IInitialMultiblockContext;
import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IMultiblockContext;
import blusunrize.immersiveengineering.api.multiblocks.blocks.logic.IMultiblockLogic;
import blusunrize.immersiveengineering.api.multiblocks.blocks.logic.IMultiblockState;
import blusunrize.immersiveengineering.api.multiblocks.blocks.util.*;

import blusunrize.immersiveengineering.api.utils.CapabilityReference;
import blusunrize.immersiveengineering.common.blocks.multiblocks.process.MultiblockProcessor;
import blusunrize.immersiveengineering.common.blocks.multiblocks.process.ProcessContext;
import blusunrize.immersiveengineering.common.fluids.ArrayFluidHandler;
import blusunrize.immersiveengineering.common.util.IESounds;
import blusunrize.immersiveengineering.common.util.Utils;
import blusunrize.immersiveengineering.common.util.inventory.SlotwiseItemHandler;
import blusunrize.immersiveengineering.common.util.inventory.WrappingItemHandler;
import blusunrize.immersiveengineering.common.util.sound.MultiblockSound;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.process.TFCTHMultiblockProcessInMachine;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.shapes.ThickenerShapes;
import net.bauxite_ltk.tfc_trihydrate.crafting.ThickenerRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.item.ItemStack;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ThickenerLogic implements
        IMultiblockLogic<ThickenerLogic.State>,
        IServerTickableComponent<ThickenerLogic.State>,
        IClientTickableComponent<ThickenerLogic.State> {
    public static final BlockPos MASTER_OFFSET = new BlockPos(4, 0, 4);
    public static final BlockPos REDSTONE_POS = new BlockPos(4, 1, 8);
    private static final MultiblockFace ITEM_OUTPUT_OFFSET = new MultiblockFace(9, 0, 4, RelativeBlockFace.RIGHT);
    private static final MultiblockFace FLUID_OUTPUT_OFFSET = new MultiblockFace(9, 4, 4, RelativeBlockFace.RIGHT);
    private static final MultiblockFace INPUT_FLUID_OFFSET = new MultiblockFace(-1, 4, 4, RelativeBlockFace.LEFT);
    private static final CapabilityPosition OUTPUT_CAP = CapabilityPosition.opposing(ITEM_OUTPUT_OFFSET);
    private static final CapabilityPosition OUTPUT_FLUID_CAP = CapabilityPosition.opposing(FLUID_OUTPUT_OFFSET);
    private static final CapabilityPosition INPUT_FLUID_CAP = CapabilityPosition.opposing(INPUT_FLUID_OFFSET);
    private static final CapabilityPosition ENERGY_INPUT = new CapabilityPosition(4, 7, 4, RelativeBlockFace.UP);

    public static final int NUM_SLOTS = 1;
    public static final int OUTPUT_SLOT = 0;
    public static final int TANK_CAPACITY = 128 * FluidType.BUCKET_VOLUME;
    public static final int ENERGY_CAPACITY = 48000;



    public State createInitialState(IInitialMultiblockContext<State> capabilitySource) {
        return new State(capabilitySource);
    }


    private int tankLastTick = 0;
    private int outputTankLastTick = 0;
    @Override
    public void tickServer(IMultiblockContext<State> context) {
        final State state = context.getState();
        final boolean active = state.processor.tickServer(state, context.getLevel(), state.rsState.isEnabled(context));
        boolean updateFlag = false;
        if(active!=state.active || tankLastTick!=state.tanks.input.getFluidAmount())
        {
            updateFlag = true;
            state.active = active;
            tankLastTick = state.tanks.input.getFluidAmount();
            context.markMasterDirty();
            context.requestMasterBESync();
        }
        enqueueProcesses(state, context.getLevel().getRawLevel());
        if(context.getLevel().shouldTickModulo(4))
            handleItemOutput(context);
        boolean output = false;
        int totalAmount = context.getState().tanks.output.getFluidAmount() + state.tanks.input.getFluidAmount();
        if(totalAmount>=129000){
            output = FluidUtils.multiblockFluidOutput(
                    state.fluidOutput, state.tanks.output,
                    -1, -1,null
            );
        }
        if((output || outputTankLastTick!=state.tanks.output.getFluidAmount()) && !updateFlag ) {
            updateFlag = true;
            context.markMasterDirty();
            context.requestMasterBESync();
        }
    }

    private void enqueueProcesses(State state, Level level) {

        final FluidStack inputFluid = state.tanks.input.getFluid();


        if(state.energy.getEnergyStored() <= 0||state.processor.getQueueSize() >= state.processor.getMaxQueueSize())
            return;
        ThickenerRecipe recipe = ThickenerRecipe.findRecipe(level, inputFluid);
        if(recipe==null){
            return;
        }
        TFCTHMultiblockProcessInMachine<ThickenerRecipe> process = new TFCTHMultiblockProcessInMachine<>(recipe);
        process.setInputTanks(0);
        state.processor.addProcessToQueue(process, level, false);
    }

    private void handleItemOutput(IMultiblockContext<State> ctx)
    {
        final State state = ctx.getState();
        final ItemStack fullOutputStack = state.inventory.getStackInSlot(OUTPUT_SLOT);
        if(fullOutputStack.isEmpty())
            return;
        ItemStack stack = fullOutputStack.copyWithCount(1);
        final ItemStack remaining = Utils.insertStackIntoInventory(state.itemOutput, stack, false);
        if(remaining.isEmpty())
        {
            fullOutputStack.shrink(1);
            ctx.markMasterDirty();
        }
    }

    @Override
    public void tickClient(IMultiblockContext<State> context) {
        final State state = context.getState();
        if(state.active)
            state.agitatorAngle = (state.agitatorAngle+1.5f)%360;
        if(!state.isPlayingSound.getAsBoolean())
        {
            final Vec3 soundPos = context.getLevel().toAbsolute(new Vec3(4.5, 4, 4.5));
            state.isPlayingSound = MultiblockSound.startSound(
                    () -> state.active, context.isValid(), soundPos, IESounds.fermenter, 0.5f
            );
        }
    }

    @Override
    public <T> LazyOptional<T> getCapability(IMultiblockContext<ThickenerLogic.State> ctx, CapabilityPosition position, Capability<T> cap)
    {
        final ThickenerLogic.State state = ctx.getState();
        if(cap==ForgeCapabilities.ENERGY&&ENERGY_INPUT.equalsOrNullFace(position))
            return state.energyCap.cast(ctx);
        else if(cap==ForgeCapabilities.FLUID_HANDLER){
            if(OUTPUT_FLUID_CAP.equalsOrNullFace(position)){
                return state.fluidOutputCap.cast(ctx);
            }
            else if(INPUT_FLUID_CAP.equalsOrNullFace(position)){
                return state.fluidInputCap.cast(ctx);
            }
        }
        else if(cap==ForgeCapabilities.ITEM_HANDLER)
        {
            if(OUTPUT_CAP.equals(position))
                return state.itemOutputCap.cast(ctx);
            else if(OUTPUT_CAP.equals(position))
                return state.itemOutputCap.cast(ctx);
        }
        return LazyOptional.empty();
    }

    @Override
    public void dropExtraItems(State state, Consumer<ItemStack> drop) {
        MBInventoryUtils.dropItems(state.inventory, drop);
    }


    @Override
    public Function<BlockPos, VoxelShape> shapeGetter(ShapeType forType)
    {
        return ThickenerShapes.SHAPE_GETTER;
    }

    public static ComparatorManager<State> makeComparator()
    {
        return ComparatorManager.makeSimple(
                state -> Utils.calcRedstoneFromInventory(OUTPUT_SLOT, state.getInventory()), REDSTONE_POS
        );
    }



    public static class State implements IMultiblockState, ProcessContext.ProcessContextInMachine<ThickenerRecipe>
    {
        private final AveragingEnergyStorage energy = new AveragingEnergyStorage(ENERGY_CAPACITY);

        private boolean active;
        private float agitatorAngle = 0;

        public final RedstoneControl.RSState rsState = RedstoneControl.RSState.enabledByDefault();
        public final MultiblockProcessor.InMachineProcessor<ThickenerRecipe> processor;
        private final SlotwiseItemHandler inventory;
        public final ThickenerTanks tanks = new ThickenerTanks();


        private final IFluidTank[] tankArray = {tanks.input, tanks.output};
        private final CapabilityReference<IItemHandler> itemOutput;
        private final CapabilityReference<IFluidHandler> fluidOutput;
        private final StoredCapability<IEnergyStorage> energyCap;
        private final StoredCapability<IItemHandler> itemOutputCap;
        private final StoredCapability<IFluidHandler> fluidInputCap;
        private final StoredCapability<IFluidHandler> fluidOutputCap;
        private BooleanSupplier isPlayingSound = () -> false;

        public State(IInitialMultiblockContext<State> ctx)
        {
            final Runnable markDirty = ctx.getMarkDirtyRunnable();
            this.inventory = SlotwiseItemHandler.makeWithGroups(List.of(
                    new SlotwiseItemHandler.IOConstraintGroup(SlotwiseItemHandler.IOConstraint.OUTPUT, 1)
            ), markDirty);
            this.itemOutput = ctx.getCapabilityAt(ForgeCapabilities.ITEM_HANDLER, ITEM_OUTPUT_OFFSET);
            this.fluidOutput = ctx.getCapabilityAt(ForgeCapabilities.FLUID_HANDLER, FLUID_OUTPUT_OFFSET);
            this.processor = new MultiblockProcessor.InMachineProcessor<>(
                    1, 0, 1, markDirty, ThickenerRecipe.RECIPES::getById
            );
            this.energyCap = new StoredCapability<>(energy);
            this.itemOutputCap = new StoredCapability<>(new WrappingItemHandler(
                    getInventory(), false, true, new WrappingItemHandler.IntRange(OUTPUT_SLOT, OUTPUT_SLOT+1)
            ));
            this.fluidInputCap = new StoredCapability<>(new ArrayFluidHandler(
                    false, true, markDirty, tanks.input
            ));
            this.fluidOutputCap = new StoredCapability<>(ArrayFluidHandler.drainOnly(tanks.output, markDirty));

        }

        @Override
        public void writeSaveNBT(CompoundTag nbt)
        {
            nbt.put("energy", energy.serializeNBT());
            nbt.put("inventory", inventory.serializeNBT());
            nbt.put("tanks", tanks.toNBT());
            nbt.put("processor", processor.toNBT());
        }

        @Override
        public void readSaveNBT(CompoundTag nbt) {
            energy.deserializeNBT(nbt.get("energy"));
            inventory.deserializeNBT(nbt.getCompound("inventory"));
            processor.fromNBT(
                    nbt.get("processor"),
                    TFCTHMultiblockProcessInMachine::new
            );
            tanks.readNBT(nbt.getCompound("tanks"));
        }

        @Override
        public void writeSyncNBT(CompoundTag nbt)
        {
            nbt.putBoolean("active", active);
            nbt.put("tanks", tanks.toNBT());
        }

        @Override
        public void readSyncNBT(CompoundTag nbt)
        {
            active = nbt.getBoolean("active");
            tanks.readNBT(nbt.getCompound("tanks"));
        }

        @Override
        public AveragingEnergyStorage getEnergy() { return energy; }

        @Override
        public IItemHandlerModifiable getInventory()
        {
            return inventory;
        }

        @Override
        public int[] getOutputSlots()
        {
            return new int[]{OUTPUT_SLOT};
        }

        @Override
        public IFluidTank[] getInternalTanks()
        {
            return tankArray;
        }

        @Override
        public int[] getOutputTanks()
        {
            return new int[]{1};
        }

        public float getAgitatorAngle(){
            return agitatorAngle;
        }

        public boolean shouldRenderActive()
        {
            return active;
        }
        
    }


    public record ThickenerTanks(FluidTank input, FluidTank output)
    {

        public ThickenerTanks()
        {
            this(new FluidTank(TANK_CAPACITY), new FluidTank(TANK_CAPACITY));
        }

        public Tag toNBT()
        {
            CompoundTag tag = new CompoundTag();
            tag.put("in", input.writeToNBT(new CompoundTag()));
            tag.put("out", output.writeToNBT(new CompoundTag()));
            return tag;
        }

        public void readNBT(CompoundTag tag)
        {
            input.readFromNBT(tag.getCompound("in"));
            output.readFromNBT(tag.getCompound("out"));
        }
    }
}
