package net.bauxite_ltk.tfc_trihydrate.gui.menus;

import blusunrize.immersiveengineering.api.energy.IMutableEnergyStorage;
import blusunrize.immersiveengineering.api.energy.MutableEnergyStorage;
import blusunrize.immersiveengineering.common.gui.IEContainerMenu;
import blusunrize.immersiveengineering.common.gui.IESlot;
import blusunrize.immersiveengineering.common.gui.sync.GenericContainerData;
import blusunrize.immersiveengineering.common.gui.sync.GenericDataSerializers;
import blusunrize.immersiveengineering.common.gui.sync.GetterAndSetter;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.logic.HydrocycloneLogic;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class HydrocycloneMenu extends IEContainerMenu {
    public final IMutableEnergyStorage energy;
    public final HydrocycloneLogic.HydrocycloneTanks tanks;
    public final GetterAndSetter<Float> guiProgress;

    public static HydrocycloneMenu makeServer(
            MenuType<?> type, int id, Inventory invPlayer, MultiblockMenuContext<HydrocycloneLogic.State> ctx
    )
    {
        final HydrocycloneLogic.State state = ctx.mbContext().getState();
        return new HydrocycloneMenu(
                multiblockCtx(type, id, ctx),
                invPlayer, state.getInventory(),
                state.getEnergy(), state.tanks,
                GetterAndSetter.getterOnly(state::getRecipeProgress)
        );
    }

    public static HydrocycloneMenu makeClient(MenuType<?> type, int id, Inventory invPlayer)
    {
        return new HydrocycloneMenu(
                clientCtx(type, id),
                invPlayer,
                new ItemStackHandler(HydrocycloneLogic.NUM_SLOTS),
                new MutableEnergyStorage(HydrocycloneLogic.ENERGY_CAPACITY),
                new HydrocycloneLogic.HydrocycloneTanks(),
                GetterAndSetter.standalone(0f)
        );
    }


    protected HydrocycloneMenu(
            MenuContext ctx,
            Inventory inventoryPlayer,
            IItemHandler inv,
            IMutableEnergyStorage energy,
            HydrocycloneLogic.HydrocycloneTanks tanks,
            GetterAndSetter<Float> guiProgress) {
        super(ctx);
        this.energy = energy;
        this.tanks = tanks;
        this.guiProgress = guiProgress;

        this.addSlot(new IESlot.NewOutput(inv, 0, 121, 50));

        ownSlotCount = 1;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 9; j++)
                addSlot(new Slot(inventoryPlayer, j+i*9+9, 8+j*18, 85+i*18));
        for(int i = 0; i < 9; i++)
            addSlot(new Slot(inventoryPlayer, i, 8+i*18, 143));
        addGenericData(GenericContainerData.energy(energy));
        addGenericData(GenericContainerData.fluid(tanks.input()));
        addGenericData(GenericContainerData.fluid(tanks.output()));
        addGenericData(new GenericContainerData<>(GenericDataSerializers.FLOAT, guiProgress));

    }
}
