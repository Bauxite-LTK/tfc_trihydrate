package net.bauxite_ltk.tfc_trihydrate.compat.jei;

import blusunrize.immersiveengineering.common.fluids.PotionFluid;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotRichTooltipCallback;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
import net.minecraft.network.chat.Component;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TFCTHTooltipCallback implements IRecipeSlotRichTooltipCallback {

    @Override
    public void onRichTooltip(IRecipeSlotView recipeSlotView, ITooltipBuilder tooltip)
    {
        Optional<FluidStack> maybeFluid = recipeSlotView.getDisplayedIngredient(ForgeTypes.FLUID_STACK);
        if(maybeFluid.isEmpty())
            return;
        FluidStack ingredient = maybeFluid.get();
        if(ingredient.getFluid() instanceof PotionFluid potion)
        {
            List<Component> fluidInfo = new ArrayList<>();
            potion.addInformation(ingredient, fluidInfo::add);

            tooltip.addAll(fluidInfo);
        }
    }

}
