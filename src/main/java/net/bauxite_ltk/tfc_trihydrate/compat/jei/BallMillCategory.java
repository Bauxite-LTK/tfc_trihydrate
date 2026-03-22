package net.bauxite_ltk.tfc_trihydrate.compat.jei;

import blusunrize.immersiveengineering.common.util.compat.jei.IERecipeCategory;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.crafting.BallMillRecipe;
import net.bauxite_ltk.tfc_trihydrate.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fluids.FluidType;

import java.util.Arrays;

public class BallMillCategory extends IERecipeCategory<BallMillRecipe> {

    private final IDrawableStatic tankOverlay;

    public BallMillCategory(IGuiHelper helper) {
        super(helper, JEIRecipeTypes.BALL_MILL, "block.tfc_trihydrate.ball_mill");
        ResourceLocation background = ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID,"textures/gui/ball_mill.png");
        setBackground(helper.createDrawable(background, 6, 9, 155-5, 73-8));
        setIcon(TFCTHMultiblockLogic.BALL_MILL.iconStack());
        tankOverlay = helper.createDrawable(background, 179, 33, 16, 47);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BallMillRecipe recipe, IFocusGroup focuses)
    {
        builder.addSlot(RecipeIngredientRole.INPUT, 31, 10)
                .addItemStacks(Arrays.asList(recipe.inputItem.getMatchingStacks()));
        IRecipeSlotBuilder outputBuilder = builder.addSlot(RecipeIngredientRole.OUTPUT, 132, 44);
        if(recipe.inputFluid!=null)
        {
            int tankSize = Math.max(FluidType.BUCKET_VOLUME, recipe.inputFluid.getAmount());
            builder.addSlot(RecipeIngredientRole.INPUT, 4, 3)
                    .setFluidRenderer(tankSize, false, 16, 47)
                    .setOverlay(tankOverlay, 0, 0)
                    .addIngredients(ForgeTypes.FLUID_STACK, recipe.inputFluid.getMatchingFluidStacks())
                    .addRichTooltipCallback(JEIHelper.fluidTooltipCallback);
        }

        if(!recipe.outputItem.get().isEmpty())
            outputBuilder.addItemStack(recipe.outputItem.get());
        if(recipe.outputFluid!=null&&!recipe.outputFluid.isEmpty())
        {
            int tankSize = Math.max(FluidType.BUCKET_VOLUME, recipe.outputFluid.getAmount());
            builder.addSlot(RecipeIngredientRole.OUTPUT, 112, 3)
                    .setFluidRenderer(tankSize, false, 16, 47)
                    .setOverlay(tankOverlay, 0, 0)
                    .addIngredient(ForgeTypes.FLUID_STACK, recipe.outputFluid)
                    .addRichTooltipCallback(JEIHelper.fluidTooltipCallback);
        }
    }


    @Override
    public void draw(BallMillRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IDrawable background = this.getBackground();
        int bWidth = background.getWidth();
        int bHeight = background.getHeight();
        Font font = Minecraft.getInstance().font;


        int time = recipe.getTotalProcessTime()/5;
        int energy = recipe.getTotalProcessEnergy() / time;

        guiGraphics.pose().pushPose();
        {
            guiGraphics.pose().translate(-8, 0, 0);

            String text0 = I18n.get("desc.tfc_trihydrate.info.thread_ift", Helper.fDecimal(energy), 8);
            guiGraphics.drawString(font, text0, bWidth / 2 - font.width(text0) / 2, bHeight - (font.lineHeight * 2), -1, false);

            String text1 = I18n.get("desc.immersiveengineering.info.ticks", Helper.fDecimal(time));
            guiGraphics.drawString(font, text1, bWidth / 2 - font.width(text1) / 2, bHeight - font.lineHeight, -1, false);
        }
        guiGraphics.pose().popPose();
    }
}
