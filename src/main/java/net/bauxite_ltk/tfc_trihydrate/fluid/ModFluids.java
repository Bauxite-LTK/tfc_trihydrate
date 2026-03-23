package net.bauxite_ltk.tfc_trihydrate.fluid;

import com.google.common.base.Suppliers;
import net.bauxite_ltk.tfc_trihydrate.block.ModBlocks;
import net.bauxite_ltk.tfc_trihydrate.item.ModItems;
import net.dries007.tfc.common.fluids.MixingFluid;
import net.dries007.tfc.common.fluids.MoltenFluid;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.*;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate.MODID;


public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, MODID);

    public static final FluidHolder<BaseFlowingFluid> SIMPLE_FLOTATION_SOLUTION = register(
            "simple_flotation_solution",
            properties -> properties
                    .block(ModBlocks.SIMPLE_FLOTATION_SOLUTION)
                    .bucket(ModItems.SIMPLE_FLOTATION_SOLUTION_BUCKET),
            waterLike()
                    .descriptionId("fluid.tfc_trihydrate.simple_flotation_solution"),
            BaseFlowingFluid.Source::new,
            BaseFlowingFluid.Flowing::new
    );

    public static final FluidHolder<BaseFlowingFluid> SODIUM_ETHYL_XANTHATE = register(
            "sodium_ethyl_xanthate",
            properties -> properties
                    .block(ModBlocks.SODIUM_ETHYL_XANTHATE)
                    .bucket(ModItems.SODIUM_ETHYL_XANTHATE_BUCKET),
            waterLike()
                    .descriptionId("fluid.tfc_trihydrate.sodium_ethyl_xanthate"),
            BaseFlowingFluid.Source::new,
            BaseFlowingFluid.Flowing::new
    );


    public static final FluidHolder<BaseFlowingFluid> LIME_SLURRY = register(
            "lime_slurry",
            properties -> properties
                    .block(ModBlocks.LIME_SLURRY)
                    .bucket(ModItems.LIME_SLURRY_BUCKET),
            waterLike()
                    .descriptionId("fluid.tfc_trihydrate.lime_slurry"),
            MixingFluid.Source::new,
            MixingFluid.Flowing::new
    );


    public static final FluidHolder<BaseFlowingFluid> HEMATITE_SLURRY =
            registerOreSlurry("hematite",
                    ModBlocks.HEMATITE_SLURRY,
                    ModItems.HEMATITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> LIMONITE_SLURRY =
            registerOreSlurry(
            "limonite",
                    ModBlocks.LIMONITE_SLURRY,
                    ModItems.LIMONITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> MAGNETITE_SLURRY =
            registerOreSlurry(
            "magnetite",
                    ModBlocks.MAGNETITE_SLURRY,
                    ModItems.MAGNETITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> NATIVE_COPPER_SLURRY =
            registerOreSlurry(
            "native_copper",
                    ModBlocks.NATIVE_COPPER_SLURRY,
                    ModItems.NATIVE_COPPER_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> NATIVE_SILVER_SLURRY =
            registerOreSlurry(
            "native_silver",
                    ModBlocks.NATIVE_SILVER_SLURRY,
                    ModItems.NATIVE_SILVER_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> NATIVE_GOLD_SLURRY =
            registerOreSlurry(
            "native_gold",
                    ModBlocks.NATIVE_GOLD_SLURRY,
                    ModItems.NATIVE_GOLD_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> MALACHITE_SLURRY =
            registerOreSlurry(
            "malachite",
                    ModBlocks.MALACHITE_SLURRY,
                    ModItems.MALACHITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TETRAHEDRITE_SLURRY =
            registerOreSlurry(
            "tetrahedrite",
                    ModBlocks.TETRAHEDRITE_SLURRY,
                    ModItems.TETRAHEDRITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> GARNIERITE_SLURRY =
            registerOreSlurry(
            "garnierite",
                    ModBlocks.GARNIERITE_SLURRY,
                    ModItems.GARNIERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CASSITERITE_SLURRY =
            registerOreSlurry(
            "cassiterite",
                    ModBlocks.CASSITERITE_SLURRY,
                    ModItems.CASSITERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> SPHALERITE_SLURRY =
            registerOreSlurry(
            "sphalerite",
                    ModBlocks.SPHALERITE_SLURRY,
                    ModItems.SPHALERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> BISMUTHINITE_SLURRY =
            registerOreSlurry(
            "bismuthinite",
                    ModBlocks.BISMUTHINITE_SLURRY,
                    ModItems.BISMUTHINITE_SLURRY_BUCKET);


    public static final FluidHolder<BaseFlowingFluid> PROCESSED_HEMATITE_SLURRY =
            registerOreSlurry(
                    "processed_hematite",
                    ModBlocks.PROCESSED_HEMATITE_SLURRY,
                    ModItems.PROCESSED_HEMATITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_LIMONITE_SLURRY =
            registerOreSlurry("processed_limonite",
                    ModBlocks.PROCESSED_LIMONITE_SLURRY,
                    ModItems.PROCESSED_LIMONITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_MAGNETITE_SLURRY =
            registerOreSlurry("processed_magnetite",
                    ModBlocks.PROCESSED_MAGNETITE_SLURRY,
                    ModItems.PROCESSED_MAGNETITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_NATIVE_COPPER_SLURRY =
            registerOreSlurry("processed_native_copper",
                    ModBlocks.PROCESSED_NATIVE_COPPER_SLURRY,
                    ModItems.PROCESSED_NATIVE_COPPER_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_NATIVE_SILVER_SLURRY =
            registerOreSlurry("processed_native_silver",
                    ModBlocks.PROCESSED_NATIVE_SILVER_SLURRY,
                    ModItems.PROCESSED_NATIVE_SILVER_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_NATIVE_GOLD_SLURRY =
            registerOreSlurry("processed_native_gold",
                    ModBlocks.PROCESSED_NATIVE_GOLD_SLURRY,
                    ModItems.PROCESSED_NATIVE_GOLD_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_MALACHITE_SLURRY =
            registerOreSlurry("processed_malachite",
                    ModBlocks.PROCESSED_MALACHITE_SLURRY,
                    ModItems.PROCESSED_MALACHITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_TETRAHEDRITE_SLURRY =
            registerOreSlurry("processed_tetrahedrite",
                    ModBlocks.PROCESSED_TETRAHEDRITE_SLURRY,
                    ModItems.PROCESSED_TETRAHEDRITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_GARNIERITE_SLURRY =
            registerOreSlurry("processed_garnierite",
                    ModBlocks.PROCESSED_GARNIERITE_SLURRY,
                    ModItems.PROCESSED_GARNIERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_CASSITERITE_SLURRY =
            registerOreSlurry("processed_cassiterite",
                    ModBlocks.PROCESSED_CASSITERITE_SLURRY,
                    ModItems.PROCESSED_CASSITERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_SPHALERITE_SLURRY =
            registerOreSlurry("processed_sphalerite",
                    ModBlocks.PROCESSED_SPHALERITE_SLURRY,
                    ModItems.PROCESSED_SPHALERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> PROCESSED_BISMUTHINITE_SLURRY =
            registerOreSlurry("processed_bismuthinite",
                    ModBlocks.PROCESSED_BISMUTHINITE_SLURRY,
                    ModItems.PROCESSED_BISMUTHINITE_SLURRY_BUCKET);




    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_HEMATITE_SLURRY =
            registerOreSlurry(
                    "concentrate_hematite",
                    ModBlocks.CONCENTRATE_HEMATITE_SLURRY,
                    ModItems.CONCENTRATE_HEMATITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_LIMONITE_SLURRY =
            registerOreSlurry("concentrate_limonite",
                    ModBlocks.CONCENTRATE_LIMONITE_SLURRY,
                    ModItems.CONCENTRATE_LIMONITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_MAGNETITE_SLURRY =
            registerOreSlurry("concentrate_magnetite",
                    ModBlocks.CONCENTRATE_MAGNETITE_SLURRY,
                    ModItems.CONCENTRATE_MAGNETITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_NATIVE_COPPER_SLURRY =
            registerOreSlurry("concentrate_native_copper",
                    ModBlocks.CONCENTRATE_NATIVE_COPPER_SLURRY,
                    ModItems.CONCENTRATE_NATIVE_COPPER_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_NATIVE_SILVER_SLURRY =
            registerOreSlurry("concentrate_native_silver",
                    ModBlocks.CONCENTRATE_NATIVE_SILVER_SLURRY,
                    ModItems.CONCENTRATE_NATIVE_SILVER_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_NATIVE_GOLD_SLURRY =
            registerOreSlurry("concentrate_native_gold",
                    ModBlocks.CONCENTRATE_NATIVE_GOLD_SLURRY,
                    ModItems.CONCENTRATE_NATIVE_GOLD_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_MALACHITE_SLURRY =
            registerOreSlurry("concentrate_malachite",
                    ModBlocks.CONCENTRATE_MALACHITE_SLURRY,
                    ModItems.CONCENTRATE_MALACHITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_TETRAHEDRITE_SLURRY =
            registerOreSlurry("concentrate_tetrahedrite",
                    ModBlocks.CONCENTRATE_TETRAHEDRITE_SLURRY,
                    ModItems.CONCENTRATE_TETRAHEDRITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_GARNIERITE_SLURRY =
            registerOreSlurry("concentrate_garnierite",
                    ModBlocks.CONCENTRATE_GARNIERITE_SLURRY,
                    ModItems.CONCENTRATE_GARNIERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_CASSITERITE_SLURRY =
            registerOreSlurry("concentrate_cassiterite",
                    ModBlocks.CONCENTRATE_CASSITERITE_SLURRY,
                    ModItems.CONCENTRATE_CASSITERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_SPHALERITE_SLURRY =
            registerOreSlurry("concentrate_sphalerite",
                    ModBlocks.CONCENTRATE_SPHALERITE_SLURRY,
                    ModItems.CONCENTRATE_SPHALERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> CONCENTRATE_BISMUTHINITE_SLURRY =
            registerOreSlurry("concentrate_bismuthinite",
                    ModBlocks.CONCENTRATE_BISMUTHINITE_SLURRY,
                    ModItems.CONCENTRATE_BISMUTHINITE_SLURRY_BUCKET);




    public static final FluidHolder<BaseFlowingFluid> TAILING_HEMATITE_SLURRY =
            registerOreSlurry(
                    "tailing_hematite",
                    ModBlocks.TAILING_HEMATITE_SLURRY,
                    ModItems.TAILING_HEMATITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_LIMONITE_SLURRY =
            registerOreSlurry("tailing_limonite",
                    ModBlocks.TAILING_LIMONITE_SLURRY,
                    ModItems.TAILING_LIMONITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_MAGNETITE_SLURRY =
            registerOreSlurry("tailing_magnetite",
                    ModBlocks.TAILING_MAGNETITE_SLURRY,
                    ModItems.TAILING_MAGNETITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_NATIVE_COPPER_SLURRY =
            registerOreSlurry("tailing_native_copper",
                    ModBlocks.TAILING_NATIVE_COPPER_SLURRY,
                    ModItems.TAILING_NATIVE_COPPER_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_NATIVE_SILVER_SLURRY =
            registerOreSlurry("tailing_native_silver",
                    ModBlocks.TAILING_NATIVE_SILVER_SLURRY,
                    ModItems.TAILING_NATIVE_SILVER_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_NATIVE_GOLD_SLURRY =
            registerOreSlurry("tailing_native_gold",
                    ModBlocks.TAILING_NATIVE_GOLD_SLURRY,
                    ModItems.TAILING_NATIVE_GOLD_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_MALACHITE_SLURRY =
            registerOreSlurry("tailing_malachite",
                    ModBlocks.TAILING_MALACHITE_SLURRY,
                    ModItems.TAILING_MALACHITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_TETRAHEDRITE_SLURRY =
            registerOreSlurry("tailing_tetrahedrite",
                    ModBlocks.TAILING_TETRAHEDRITE_SLURRY,
                    ModItems.TAILING_TETRAHEDRITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_GARNIERITE_SLURRY =
            registerOreSlurry("tailing_garnierite",
                    ModBlocks.TAILING_GARNIERITE_SLURRY,
                    ModItems.TAILING_GARNIERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_CASSITERITE_SLURRY =
            registerOreSlurry("tailing_cassiterite",
                    ModBlocks.TAILING_CASSITERITE_SLURRY,
                    ModItems.TAILING_CASSITERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_SPHALERITE_SLURRY =
            registerOreSlurry("tailing_sphalerite",
                    ModBlocks.TAILING_SPHALERITE_SLURRY,
                    ModItems.TAILING_SPHALERITE_SLURRY_BUCKET);

    public static final FluidHolder<BaseFlowingFluid> TAILING_BISMUTHINITE_SLURRY =
            registerOreSlurry("tailing_bismuthinite",
                    ModBlocks.TAILING_BISMUTHINITE_SLURRY,
                    ModItems.TAILING_BISMUTHINITE_SLURRY_BUCKET);



    private static FluidType.Properties waterLike()
    {
        return FluidType.Properties.create()
                .adjacentPathType(PathType.WATER)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .canConvertToSource(false)
                .canDrown(true)
                .canExtinguish(true)
                .canHydrate(true)
                .canPushEntity(true)
                .canSwim(true)
                .supportsBoating(true);
    }

    private static FluidType.Properties lavaLike()
    {
        return FluidType.Properties.create()
                .adjacentPathType(PathType.LAVA)
                .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                .lightLevel(15)
                .density(3000)
                .viscosity(6000)
                .temperature(1300)
                .canConvertToSource(false)
                .canDrown(false)
                .canExtinguish(false)
                .canHydrate(false)
                .canPushEntity(false)
                .canSwim(false)
                .supportsBoating(false);
    }



    public static < L extends LiquidBlock, I extends Item>
    FluidHolder<BaseFlowingFluid> registerOreSlurry(
            String oreName, DeferredBlock<L> liquidBlock, DeferredItem<I> bucketItem)
    {
        return register(
                oreName + "_slurry",
                properties -> properties
                        .block(liquidBlock)
                        .bucket(bucketItem),
                waterLike()
                        .descriptionId("fluid.tfc_trihydrate." + oreName + "_slurry"),
                MixingFluid.Source::new,
                MixingFluid.Flowing::new);
    }

    private static <F extends FlowingFluid> FluidHolder<F> register(String name, Consumer<BaseFlowingFluid.Properties> builder, FluidType.Properties typeProperties, Function<BaseFlowingFluid.Properties, F> sourceFactory, Function<BaseFlowingFluid.Properties, F> flowingFactory)
    {
        // Names `metal/foo` to `metal/flowing_foo`
        final int index = name.lastIndexOf('/');
        final String flowingName = index == -1 ? "flowing_" + name : name.substring(0, index) + "/flowing_" + name.substring(index + 1);

        return registerFluid(FLUID_TYPES, FLUIDS, name, name, flowingName, builder, () -> new FluidType(typeProperties), sourceFactory, flowingFactory);
    }

    public static <F extends FlowingFluid> FluidHolder<F> registerFluid(
            DeferredRegister<FluidType> fluidTypes,
            DeferredRegister<Fluid> fluids,
            String typeName,
            String sourceName,
            String flowingName,
            Consumer<BaseFlowingFluid.Properties> builder,
            Supplier<FluidType> typeFactory,
            Function<BaseFlowingFluid.Properties, F> sourceFactory,
            Function<BaseFlowingFluid.Properties, F> flowingFactory)
    {
        // The type need a reference to both source and flowing
        // In addition, the properties' builder cannot be invoked statically, as it has hard references to registry objects, which may not be populated based on class load order - it must be invoked at registration time.
        // So, first we prepare the source and flowing registry objects, referring to the properties box (which will be opened during registration, which is ok)
        // Then, we populate the properties box lazily, (since it's a mutable lazy), so the properties inside are only constructed when the box is opened (again, during registration)
        final Mutable<Supplier<BaseFlowingFluid.Properties>> typeBox = new MutableObject<>();
        final DeferredHolder<Fluid, F> source = fluids.register(sourceName, () -> sourceFactory.apply(typeBox.getValue().get()));
        final DeferredHolder<Fluid, F> flowing = fluids.register(flowingName, () -> flowingFactory.apply(typeBox.getValue().get()));

        final DeferredHolder<FluidType, FluidType> fluidType = fluidTypes.register(typeName, typeFactory);

        typeBox.setValue(Suppliers.memoize(() -> {
            final BaseFlowingFluid.Properties lazyProperties = new BaseFlowingFluid.Properties(fluidType, source, flowing);
            builder.accept(lazyProperties);
            return lazyProperties;
        }));

        return new FluidHolder<>(fluidType, flowing, source);
    }

    public static void init(IEventBus modEventBus){
        FLUID_TYPES.register(modEventBus);
        FLUIDS.register(modEventBus);

    }

}
