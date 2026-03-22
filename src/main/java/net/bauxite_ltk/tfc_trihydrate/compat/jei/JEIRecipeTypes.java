package net.bauxite_ltk.tfc_trihydrate.compat.jei;

import blusunrize.immersiveengineering.api.crafting.IERecipeTypes;
import mezz.jei.api.recipe.RecipeType;
import net.bauxite_ltk.tfc_trihydrate.crafting.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;


public class JEIRecipeTypes {
    public static final RecipeType<BallMillRecipe> BALL_MILL = create(TFCTHRecipeType.BALL_MILL);
    public static final RecipeType<FlotationCellRecipe> FLOTATION_CELL = create(TFCTHRecipeType.FLOTATION_CELL);
    public static final RecipeType<HydrocycloneRecipe> HYDROCYCLONE = create(TFCTHRecipeType.HYDROCYCLONE);
    public static final RecipeType<ThickenerRecipe> THICKENER = create(TFCTHRecipeType.THICKENER);


    private static <T extends Recipe<?>>
    RecipeType<T> create(IERecipeTypes.TypeWithClass<T> type)
    {
        return new RecipeType<>(type.type().getId(), type.recipeClass());
    }
}
