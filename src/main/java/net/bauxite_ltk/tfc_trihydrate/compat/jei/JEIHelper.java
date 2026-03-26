package net.bauxite_ltk.tfc_trihydrate.compat.jei;
import blusunrize.immersiveengineering.api.crafting.cache.CachedRecipeList;
import blusunrize.immersiveengineering.common.util.compat.jei.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotRichTooltipCallback;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.*;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.crafting.BallMillRecipe;
import net.bauxite_ltk.tfc_trihydrate.crafting.FlotationCellRecipe;
import net.bauxite_ltk.tfc_trihydrate.crafting.HydrocycloneRecipe;
import net.bauxite_ltk.tfc_trihydrate.crafting.ThickenerRecipe;
import net.bauxite_ltk.tfc_trihydrate.gui.multiblock.BallMillScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.multiblock.FlotationCellScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.multiblock.HydrocycloneScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.multiblock.ThickenerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@JeiPlugin
public class JEIHelper implements IModPlugin
{
    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID,"main");
    //public static final ResourceLocation JEI_GUI = IEApi.ieLoc("textures/gui/jei_elements.png");
    public static IDrawableStatic slotDrawable;
    public static IRecipeSlotRichTooltipCallback fluidTooltipCallback = new IEFluidTooltipCallback();

    @Override
    public ResourceLocation getPluginUid()
    {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry)
    {
        //Recipes
        IGuiHelper guiHelper = registry.getJeiHelpers().getGuiHelper();
        registry.addRecipeCategories(
                new BallMillCategory(guiHelper),
                new FlotationCellCategory(guiHelper),
                new HydrocycloneCategory(guiHelper),
                new ThickenerCategory(guiHelper)
        );

        slotDrawable = guiHelper.getSlotDrawable();
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        registration.addRecipes(net.bauxite_ltk.tfc_trihydrate.compat.jei.JEIRecipeTypes.BALL_MILL, getRecipes(BallMillRecipe.RECIPES));
        registration.addRecipes(JEIRecipeTypes.FLOTATION_CELL, getRecipes(FlotationCellRecipe.RECIPES));
        registration.addRecipes(JEIRecipeTypes.HYDROCYCLONE, getRecipes(HydrocycloneRecipe.RECIPES));
        registration.addRecipes(JEIRecipeTypes.THICKENER, getRecipes(ThickenerRecipe.RECIPES));

    }

    private <T extends Recipe<?>> List<RecipeHolder<T>> getRecipes(CachedRecipeList<T> cachedList)
    {
        return getFiltered(cachedList, $ -> true);
    }

    private <T extends Recipe<?>> List<RecipeHolder<T>> getFiltered(CachedRecipeList<T> cachedList, Predicate<T> include)
    {
        return getFilteredAndSorted(cachedList, include, null);
    }

    private <T extends Recipe<?>> List<RecipeHolder<T>> getFilteredAndSorted(CachedRecipeList<T> cachedList, Predicate<T> include, @Nullable Comparator<RecipeHolder<T>> sorting)
    {
        Stream<RecipeHolder<T>> ret = cachedList.getRecipes(Minecraft.getInstance().level).stream()
                .filter(h -> include.test(h.value()));
        if(sorting!=null)
            ret = ret.sorted(sorting);
        return ret.toList();
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration)
    {
        registration.addRecipeCatalyst(TFCTHMultiblockLogic.BALL_MILL.iconStack(), net.bauxite_ltk.tfc_trihydrate.compat.jei.JEIRecipeTypes.BALL_MILL);
        registration.addRecipeCatalyst(TFCTHMultiblockLogic.FLOTATION_CELL.iconStack(), JEIRecipeTypes.FLOTATION_CELL);
        registration.addRecipeCatalyst(TFCTHMultiblockLogic.HYDROCYCLONE.iconStack(), JEIRecipeTypes.HYDROCYCLONE);
        registration.addRecipeCatalyst(TFCTHMultiblockLogic.THICKENER.iconStack(), JEIRecipeTypes.THICKENER);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration)
    {
        registration.addRecipeClickArea(BallMillScreen.class, 36, 57, 72, 13, JEIRecipeTypes.BALL_MILL);
        registration.addRecipeClickArea(FlotationCellScreen.class, 153, 59, 16, 14, JEIRecipeTypes.FLOTATION_CELL);
        registration.addRecipeClickArea(HydrocycloneScreen.class, 96, 38, 17, 13, JEIRecipeTypes.HYDROCYCLONE);
        registration.addRecipeClickArea(ThickenerScreen.class, 153, 59, 16, 14, JEIRecipeTypes.THICKENER);

    }
}
