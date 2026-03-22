package net.bauxite_ltk.tfc_trihydrate.crafting;

import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class TFCTHRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
            ForgeRegistries.RECIPE_SERIALIZERS, TFCTrihydrate.MODID
    );

    static {
        BallMillRecipe.SERIALIZER = RECIPE_SERIALIZERS.register(
                "ball_mill", BallMillRecipeSerializer::new
        );

        FlotationCellRecipe.SERIALIZER = RECIPE_SERIALIZERS.register(
                "flotation_cell", FlotationCellRecipeSerializer::new
        );

        HydrocycloneRecipe.SERIALIZER = RECIPE_SERIALIZERS.register(
                "hydrocyclone", HydrocycloneRecipeSerializer::new
        );

        ThickenerRecipe.SERIALIZER = RECIPE_SERIALIZERS.register(
                "thickener", ThickenerRecipeSerializer::new
        );
    }

    public static void init(IEventBus modEventBus){
        RECIPE_SERIALIZERS.register(modEventBus);
    }
}
