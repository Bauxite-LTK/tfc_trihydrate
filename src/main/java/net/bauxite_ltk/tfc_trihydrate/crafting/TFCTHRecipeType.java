package net.bauxite_ltk.tfc_trihydrate.crafting;

import blusunrize.immersiveengineering.api.crafting.IERecipeTypes;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TFCTHRecipeType {
    private static final DeferredRegister<RecipeType<?>> REGISTER = DeferredRegister.create(
            Registries.RECIPE_TYPE, TFCTrihydrate.MODID
    );

    public static final IERecipeTypes.TypeWithClass<BallMillRecipe> BALL_MILL = register("ball_mill", BallMillRecipe.class);
    public static final IERecipeTypes.TypeWithClass<FlotationCellRecipe> FLOTATION_CELL = register("flotation_cell", FlotationCellRecipe.class);
    public static final IERecipeTypes.TypeWithClass<HydrocycloneRecipe> HYDROCYCLONE = register("hydrocyclone", HydrocycloneRecipe.class);
    public static final IERecipeTypes.TypeWithClass<ThickenerRecipe> THICKENER = register("thickener", ThickenerRecipe.class);



    private static <T extends Recipe<?>>
    IERecipeTypes.TypeWithClass<T> register(String name, Class<T> type)
    {
        RegistryObject<RecipeType<T>> regObj = REGISTER.register(name, () -> new RecipeType<>()
        {
        });
        return new IERecipeTypes.TypeWithClass<>(regObj, type);
    }

    public static void init(IEventBus modBus)
    {
        REGISTER.register(modBus);
    }

    public record TypeWithClass<T extends Recipe<?>>(
            RegistryObject<RecipeType<T>> type, Class<T> recipeClass
    ) implements Supplier<RecipeType<T>>
    {
        public RecipeType<T> get()
        {
            return type.get();
        }
    }
}
