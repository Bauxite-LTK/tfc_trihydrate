package net.bauxite_ltk.tfc_trihydrate.crafting;

import blusunrize.immersiveengineering.api.crafting.FluidTagInput;
import blusunrize.immersiveengineering.api.crafting.IERecipeSerializer;
import blusunrize.immersiveengineering.api.crafting.MultiblockRecipe;

import blusunrize.immersiveengineering.api.crafting.cache.CachedRecipeList;
import com.google.common.collect.Lists;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.registries.RegistryObject;


import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ThickenerRecipe extends MultiblockRecipe {
    public static RegistryObject<IERecipeSerializer<ThickenerRecipe>> SERIALIZER;
    public static final CachedRecipeList<ThickenerRecipe> RECIPES = new CachedRecipeList<>(TFCTHRecipeType.THICKENER);

    public final FluidStack outputFluid;
    @Nonnull
    public Lazy<ItemStack> outputItem;

    public final FluidTagInput inputFluid;



    protected <T extends Recipe<?>> ThickenerRecipe(ResourceLocation id,  FluidStack outputFluid, @Nonnull Lazy<ItemStack> outputItem,
                                                    FluidTagInput inputFluid, int energy) {

        super(LAZY_EMPTY, TFCTHRecipeType.THICKENER, id);
        this.outputFluid = outputFluid;
        this.inputFluid = inputFluid;
        this.outputItem = outputItem;

        this.outputList = Lazy.of(() -> NonNullList.of(ItemStack.EMPTY, this.outputItem.get()));
        this.fluidInputList = Lists.newArrayList(this.inputFluid);
        this.fluidOutputList = Lists.newArrayList(this.outputFluid);

    }

    @Override
    protected IERecipeSerializer<?> getIESerializer() {
        return SERIALIZER.get();
    }


    public static ThickenerRecipe findRecipe(Level level, FluidStack inputFluid)
    {
        if(inputFluid.isEmpty())
            return null;
        for(ThickenerRecipe recipe : RECIPES.getRecipes(level)){
            if(recipe.inputFluid.test(inputFluid)){
                return recipe;
            }
        }
        return null;
    }

    @Override
    public int getMultipleProcessTicks() {
        return 0;
    }
}
