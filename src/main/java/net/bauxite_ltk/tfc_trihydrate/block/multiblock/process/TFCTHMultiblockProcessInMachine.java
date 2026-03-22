package net.bauxite_ltk.tfc_trihydrate.block.multiblock.process;

import blusunrize.immersiveengineering.api.crafting.MultiblockRecipe;
import blusunrize.immersiveengineering.api.multiblocks.blocks.env.IMultiblockLevel;
import blusunrize.immersiveengineering.common.blocks.multiblocks.process.MultiblockProcessInMachine;
import blusunrize.immersiveengineering.common.blocks.multiblocks.process.ProcessContext;
import net.bauxite_ltk.tfc_trihydrate.crafting.TFCTHMultiblockRecipe;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.IFluidHandler;


import java.util.function.BiFunction;

public class TFCTHMultiblockProcessInMachine<R extends MultiblockRecipe>
        extends MultiblockProcessInMachine<R> {


    public TFCTHMultiblockProcessInMachine(ResourceLocation recipeId, BiFunction<Level, ResourceLocation, R> getRecipe, int... inputSlots) {
        super(recipeId, getRecipe, inputSlots);
    }

    public TFCTHMultiblockProcessInMachine(R recipe, int... inputSlots) {
        super(recipe, inputSlots);
    }

    public TFCTHMultiblockProcessInMachine(BiFunction<Level, ResourceLocation, R> getRecipe, CompoundTag data) {
        super(getRecipe, data);
    }



    @Override
    protected boolean canOutputFluid(ProcessContext.ProcessContextInMachine<R> context, FluidStack output)
    {
        IFluidTank[] tanks = context.getInternalTanks();
        int[] outputTanks = context.getOutputTanks();
        for(int iOutputTank : outputTanks){
            if(tanks[iOutputTank].getFluidAmount() == tanks[iOutputTank].getCapacity()){
                return false;
            }
        }

        for(int iOutputTank : outputTanks) {
            if (tanks[iOutputTank].fill(output, IFluidHandler.FluidAction.SIMULATE) == output.getAmount()){
                return true;
            }
        }
        return false;
    }

}
