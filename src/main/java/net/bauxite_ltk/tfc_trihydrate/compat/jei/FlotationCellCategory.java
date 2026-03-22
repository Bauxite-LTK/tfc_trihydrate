package net.bauxite_ltk.tfc_trihydrate.compat.jei;

import blusunrize.immersiveengineering.common.util.compat.jei.IERecipeCategory;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.crafting.FlotationCellRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.FluidType;

import java.util.Arrays;

public class FlotationCellCategory extends IERecipeCategory<FlotationCellRecipe> {

    private final IDrawableStatic tankOverlay;

    public FlotationCellCategory(IGuiHelper helper) {
        super(helper, JEIRecipeTypes.FLOTATION_CELL, "block.tfc_trihydrate.flotation_cell");
        ResourceLocation background = ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID,"textures/gui/flotation_cell_recipe.png");
        setBackground(helper.createDrawable(background, 0, 0, 113, 63));
        setIcon(TFCTHMultiblockLogic.FLOTATION_CELL.iconStack());
        tankOverlay = helper.createDrawable(background, 179, 33, 16, 47);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FlotationCellRecipe recipe, IFocusGroup focuses)
    {

        int oreTankSize = Math.max(FluidType.BUCKET_VOLUME/5, recipe.inputOre.getAmount());
        builder.addSlot(RecipeIngredientRole.INPUT, 10, 3)
                .setFluidRenderer(oreTankSize, false, 16, 47)
                .setOverlay(tankOverlay, 0, 0)
                .addIngredients(ForgeTypes.FLUID_STACK, recipe.inputOre.getMatchingFluidStacks())
                .addRichTooltipCallback(JEIHelper.fluidTooltipCallback);

        int addTankSize = Math.max(FluidType.BUCKET_VOLUME/100, recipe.inputAdd.getAmount());
        builder.addSlot(RecipeIngredientRole.INPUT, 45, 10)
                .setFluidRenderer(addTankSize, false, 4, 34)
                .setOverlay(tankOverlay, 0, 0)
                .addIngredients(ForgeTypes.FLUID_STACK, recipe.inputAdd.getMatchingFluidStacks())
                .addRichTooltipCallback(JEIHelper.fluidTooltipCallback);

        int concentrateTankSize = Math.max(FluidType.BUCKET_VOLUME/10, recipe.outputConcentrate.getAmount());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 85, 3)
                .setFluidRenderer(concentrateTankSize, false, 16, 25)
                .setOverlay(tankOverlay, 0, 0)
                .addIngredient(ForgeTypes.FLUID_STACK, recipe.outputConcentrate)
                .addRichTooltipCallback(JEIHelper.fluidTooltipCallback);

        if(recipe.outputTailing!=null&&!recipe.outputTailing.isEmpty())
        {
            int tailingTankSize = Math.max(FluidType.BUCKET_VOLUME/10, recipe.outputTailing.getAmount());
            builder.addSlot(RecipeIngredientRole.OUTPUT, 85, 35)
                    .setFluidRenderer(tailingTankSize, false, 16, 25)
                    .setOverlay(tankOverlay, 0, 0)
                    .addIngredient(ForgeTypes.FLUID_STACK, recipe.outputTailing)
                    .addRichTooltipCallback(JEIHelper.fluidTooltipCallback);
        }
    }
}
