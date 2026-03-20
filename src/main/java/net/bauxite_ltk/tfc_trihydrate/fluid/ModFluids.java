package net.bauxite_ltk.tfc_trihydrate.fluid;

import com.google.common.base.Suppliers;

import net.bauxite_ltk.tfc_trihydrate.block.ModBlocks;
import net.bauxite_ltk.tfc_trihydrate.item.ModItems;
import net.dries007.tfc.common.fluids.ExtendedFluidType;
import net.dries007.tfc.common.fluids.FluidRegistryObject;
import net.dries007.tfc.common.fluids.FluidTypeClientProperties;
import net.dries007.tfc.common.fluids.MixingFluid;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate.MODID;


public class ModFluids {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, MODID);

    public static final ResourceLocation WATER_STILL = ResourceLocation.fromNamespaceAndPath("minecraft","block/water_still");
    public static final ResourceLocation BUBBLE_STILL = ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","block/bubble_still");
    public static final ResourceLocation WATER_FLOW = ResourceLocation.fromNamespaceAndPath("minecraft","block/water_flow");
    public static final ResourceLocation WATER_OVERLAY = ResourceLocation.fromNamespaceAndPath("minecraft","block/water_overlay");
    public static final ResourceLocation UNDERWATER_LOCATION = ResourceLocation.fromNamespaceAndPath("minecraft","textures/misc/underwater.png");

    public static final ResourceLocation THICKY_WATER_STILL = ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","block/thicky_water_still");
    public static final ResourceLocation THICKY_WATER_FLOW = ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","block/thicky_water_flow");

    public static final ResourceLocation DARK_THICKY_WATER_STILL = ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","block/dark_thicky_water_still");
    public static final ResourceLocation DARK_THICKY_WATER_FLOW = ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","block/dark_thicky_water_flow");

    private static final ResourceLocation MOLTEN_STILL = ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","block/molten_still");
    private static final ResourceLocation MOLTEN_FLOW = ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","block/molten_flow");


    public static final FluidRegistryObject<MixingFluid> SIMPLE_FLOTATION_SOLUTION = register(
            "simple_flotation_solution",
            properties -> properties
                    .block(ModBlocks.SIMPLE_FLOTATION_SOLUTION)
                    .bucket(ModItems.SIMPLE_FLOTATION_SOLUTION_BUCKET),
            waterLike()
                    .descriptionId("fluid.tfc_trihydrate.simple_flotation_solution"),
            new FluidTypeClientProperties(0xFF93bcb2, BUBBLE_STILL, BUBBLE_STILL, null, null),
            MixingFluid.Source::new,
            MixingFluid.Flowing::new
    );

    public static final FluidRegistryObject<MixingFluid> SODIUM_ETHYL_XANTHATE = register(
            "sodium_ethyl_xanthate",
            properties -> properties
                    .block(ModBlocks.SODIUM_ETHYL_XANTHATE)
                    .bucket(ModItems.SODIUM_ETHYL_XANTHATE_BUCKET),
            waterLike()
                    .descriptionId("fluid.tfc_trihydrate.sodium_ethyl_xanthate"),
            new FluidTypeClientProperties(0xFFf4ad00, WATER_STILL, WATER_FLOW, null, null),
            MixingFluid.Source::new,
            MixingFluid.Flowing::new
    );


    public static final FluidRegistryObject<ForgeFlowingFluid> LIME_SLURRY = register(
            "lime_slurry",
            properties -> properties
                    .block(ModBlocks.LIME_SLURRY)
                    .bucket(ModItems.LIME_SLURRY_BUCKET),
            waterLike()
                    .descriptionId("fluid.tfc_trihydrate.lime_slurry"),
            new FluidTypeClientProperties(0xFFb4b3a9, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null),
            MixingFluid.Source::new,
            MixingFluid.Flowing::new
    );


    public static final FluidRegistryObject<ForgeFlowingFluid> HEMATITE_SLURRY =
            registerOreSlurry("hematite",
                    ModBlocks.HEMATITE_SLURRY,
                    ModItems.HEMATITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFf18579, MOLTEN_STILL, MOLTEN_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> LIMONITE_SLURRY =
            registerOreSlurry(
            "limonite",
                    ModBlocks.LIMONITE_SLURRY,
                    ModItems.LIMONITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFc1975c, MOLTEN_STILL, MOLTEN_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> MAGNETITE_SLURRY =
            registerOreSlurry(
            "magnetite",
                    ModBlocks.MAGNETITE_SLURRY,
                    ModItems.MAGNETITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF979ba8, MOLTEN_STILL, MOLTEN_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> NATIVE_COPPER_SLURRY =
            registerOreSlurry(
            "native_copper",
                    ModBlocks.NATIVE_COPPER_SLURRY,
                    ModItems.NATIVE_COPPER_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFe2b198, MOLTEN_STILL, MOLTEN_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> NATIVE_SILVER_SLURRY =
            registerOreSlurry(
            "native_silver",
                    ModBlocks.NATIVE_SILVER_SLURRY,
                    ModItems.NATIVE_SILVER_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFe4e0dc, MOLTEN_STILL, MOLTEN_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> NATIVE_GOLD_SLURRY =
            registerOreSlurry(
            "native_gold",
                    ModBlocks.NATIVE_GOLD_SLURRY,
                    ModItems.NATIVE_GOLD_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFf9f4a1, MOLTEN_STILL, MOLTEN_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> MALACHITE_SLURRY =
            registerOreSlurry(
            "malachite",
                    ModBlocks.MALACHITE_SLURRY,
                    ModItems.MALACHITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF65a7a2, MOLTEN_STILL, MOLTEN_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TETRAHEDRITE_SLURRY =
            registerOreSlurry(
            "tetrahedrite",
                    ModBlocks.TETRAHEDRITE_SLURRY,
                    ModItems.TETRAHEDRITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF95948b, MOLTEN_STILL, MOLTEN_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> GARNIERITE_SLURRY =
            registerOreSlurry(
            "garnierite",
                    ModBlocks.GARNIERITE_SLURRY,
                    ModItems.GARNIERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFa1bd90, MOLTEN_STILL, MOLTEN_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CASSITERITE_SLURRY =
            registerOreSlurry(
            "cassiterite",
                    ModBlocks.CASSITERITE_SLURRY,
                    ModItems.CASSITERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF8d8059, MOLTEN_STILL, MOLTEN_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> SPHALERITE_SLURRY =
            registerOreSlurry(
            "sphalerite",
                    ModBlocks.SPHALERITE_SLURRY,
                    ModItems.SPHALERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFc1d1db, MOLTEN_STILL, MOLTEN_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> BISMUTHINITE_SLURRY =
            registerOreSlurry(
            "bismuthinite",
                    ModBlocks.BISMUTHINITE_SLURRY,
                    ModItems.BISMUTHINITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF4f572e, MOLTEN_STILL, MOLTEN_FLOW, null, null)
                    );


    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_HEMATITE_SLURRY =
            registerOreSlurry(
                    "processed_hematite",
                    ModBlocks.PROCESSED_HEMATITE_SLURRY,
                    ModItems.PROCESSED_HEMATITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFf18579, WATER_STILL, WATER_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_LIMONITE_SLURRY =
            registerOreSlurry("processed_limonite",
                    ModBlocks.PROCESSED_LIMONITE_SLURRY,
                    ModItems.PROCESSED_LIMONITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFc1975c, WATER_STILL, WATER_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_MAGNETITE_SLURRY =
            registerOreSlurry("processed_magnetite",
                    ModBlocks.PROCESSED_MAGNETITE_SLURRY,
                    ModItems.PROCESSED_MAGNETITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF979ba8, WATER_STILL, WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_NATIVE_COPPER_SLURRY =
            registerOreSlurry("processed_native_copper",
                    ModBlocks.PROCESSED_NATIVE_COPPER_SLURRY,
                    ModItems.PROCESSED_NATIVE_COPPER_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFe2b198, WATER_STILL, WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_NATIVE_SILVER_SLURRY =
            registerOreSlurry("processed_native_silver",
                    ModBlocks.PROCESSED_NATIVE_SILVER_SLURRY,
                    ModItems.PROCESSED_NATIVE_SILVER_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFe4e0dc, WATER_STILL, WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_NATIVE_GOLD_SLURRY =
            registerOreSlurry("processed_native_gold",
                    ModBlocks.PROCESSED_NATIVE_GOLD_SLURRY,
                    ModItems.PROCESSED_NATIVE_GOLD_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFf9f4a1, WATER_STILL, WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_MALACHITE_SLURRY =
            registerOreSlurry("processed_malachite",
                    ModBlocks.PROCESSED_MALACHITE_SLURRY,
                    ModItems.PROCESSED_MALACHITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF65a7a2, WATER_STILL, WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_TETRAHEDRITE_SLURRY =
            registerOreSlurry("processed_tetrahedrite",
                    ModBlocks.PROCESSED_TETRAHEDRITE_SLURRY,
                    ModItems.PROCESSED_TETRAHEDRITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF95948b, WATER_STILL, WATER_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_GARNIERITE_SLURRY =
            registerOreSlurry("processed_garnierite",
                    ModBlocks.PROCESSED_GARNIERITE_SLURRY,
                    ModItems.PROCESSED_GARNIERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFa1bd90, WATER_STILL, WATER_FLOW, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_CASSITERITE_SLURRY =
            registerOreSlurry("processed_cassiterite",
                    ModBlocks.PROCESSED_CASSITERITE_SLURRY,
                    ModItems.PROCESSED_CASSITERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF8d8059, WATER_STILL, WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_SPHALERITE_SLURRY =
            registerOreSlurry("processed_sphalerite",
                    ModBlocks.PROCESSED_SPHALERITE_SLURRY,
                    ModItems.PROCESSED_SPHALERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFc1d1db, WATER_STILL, WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> PROCESSED_BISMUTHINITE_SLURRY =
            registerOreSlurry("processed_bismuthinite",
                    ModBlocks.PROCESSED_BISMUTHINITE_SLURRY,
                    ModItems.PROCESSED_BISMUTHINITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF4f572e, WATER_STILL, WATER_FLOW, null, null)
                    );




    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_HEMATITE_SLURRY =
            registerOreSlurry(
                    "concentrate_hematite",
                    ModBlocks.CONCENTRATE_HEMATITE_SLURRY,
                    ModItems.CONCENTRATE_HEMATITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFf18579, BUBBLE_STILL, BUBBLE_STILL, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_LIMONITE_SLURRY =
            registerOreSlurry("concentrate_limonite",
                    ModBlocks.CONCENTRATE_LIMONITE_SLURRY,
                    ModItems.CONCENTRATE_LIMONITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFc1975c, BUBBLE_STILL, BUBBLE_STILL, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_MAGNETITE_SLURRY =
            registerOreSlurry("concentrate_magnetite",
                    ModBlocks.CONCENTRATE_MAGNETITE_SLURRY,
                    ModItems.CONCENTRATE_MAGNETITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF979ba8, BUBBLE_STILL, BUBBLE_STILL, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_NATIVE_COPPER_SLURRY =
            registerOreSlurry("concentrate_native_copper",
                    ModBlocks.CONCENTRATE_NATIVE_COPPER_SLURRY,
                    ModItems.CONCENTRATE_NATIVE_COPPER_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFe2b198, BUBBLE_STILL, BUBBLE_STILL, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_NATIVE_SILVER_SLURRY =
            registerOreSlurry("concentrate_native_silver",
                    ModBlocks.CONCENTRATE_NATIVE_SILVER_SLURRY,
                    ModItems.CONCENTRATE_NATIVE_SILVER_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFe4e0dc, BUBBLE_STILL, BUBBLE_STILL, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_NATIVE_GOLD_SLURRY =
            registerOreSlurry("concentrate_native_gold",
                    ModBlocks.CONCENTRATE_NATIVE_GOLD_SLURRY,
                    ModItems.CONCENTRATE_NATIVE_GOLD_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFf9f4a1, BUBBLE_STILL, BUBBLE_STILL, null, null)

                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_MALACHITE_SLURRY =
            registerOreSlurry("concentrate_malachite",
                    ModBlocks.CONCENTRATE_MALACHITE_SLURRY,
                    ModItems.CONCENTRATE_MALACHITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF65a7a2, BUBBLE_STILL, BUBBLE_STILL, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_TETRAHEDRITE_SLURRY =
            registerOreSlurry("concentrate_tetrahedrite",
                    ModBlocks.CONCENTRATE_TETRAHEDRITE_SLURRY,
                    ModItems.CONCENTRATE_TETRAHEDRITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF95948b, BUBBLE_STILL, BUBBLE_STILL, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_GARNIERITE_SLURRY =
            registerOreSlurry("concentrate_garnierite",
                    ModBlocks.CONCENTRATE_GARNIERITE_SLURRY,
                    ModItems.CONCENTRATE_GARNIERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFa1bd90, BUBBLE_STILL, BUBBLE_STILL, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_CASSITERITE_SLURRY =
            registerOreSlurry("concentrate_cassiterite",
                    ModBlocks.CONCENTRATE_CASSITERITE_SLURRY,
                    ModItems.CONCENTRATE_CASSITERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF8d8059, BUBBLE_STILL, BUBBLE_STILL, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_SPHALERITE_SLURRY =
            registerOreSlurry("concentrate_sphalerite",
                    ModBlocks.CONCENTRATE_SPHALERITE_SLURRY,
                    ModItems.CONCENTRATE_SPHALERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFc1d1db, BUBBLE_STILL, BUBBLE_STILL, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> CONCENTRATE_BISMUTHINITE_SLURRY =
            registerOreSlurry("concentrate_bismuthinite",
                    ModBlocks.CONCENTRATE_BISMUTHINITE_SLURRY,
                    ModItems.CONCENTRATE_BISMUTHINITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF4f572e, BUBBLE_STILL, BUBBLE_STILL, null, null)
                    );




    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_HEMATITE_SLURRY =
            registerOreSlurry(
                    "tailing_hematite",
                    ModBlocks.TAILING_HEMATITE_SLURRY,
                    ModItems.TAILING_HEMATITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFf18579, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_LIMONITE_SLURRY =
            registerOreSlurry("tailing_limonite",
                    ModBlocks.TAILING_LIMONITE_SLURRY,
                    ModItems.TAILING_LIMONITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFc1975c, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_MAGNETITE_SLURRY =
            registerOreSlurry("tailing_magnetite",
                    ModBlocks.TAILING_MAGNETITE_SLURRY,
                    ModItems.TAILING_MAGNETITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF979ba8, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_NATIVE_COPPER_SLURRY =
            registerOreSlurry("tailing_native_copper",
                    ModBlocks.TAILING_NATIVE_COPPER_SLURRY,
                    ModItems.TAILING_NATIVE_COPPER_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFe2b198, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_NATIVE_SILVER_SLURRY =
            registerOreSlurry("tailing_native_silver",
                    ModBlocks.TAILING_NATIVE_SILVER_SLURRY,
                    ModItems.TAILING_NATIVE_SILVER_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFe4e0dc, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_NATIVE_GOLD_SLURRY =
            registerOreSlurry("tailing_native_gold",
                    ModBlocks.TAILING_NATIVE_GOLD_SLURRY,
                    ModItems.TAILING_NATIVE_GOLD_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFf9f4a1, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_MALACHITE_SLURRY =
            registerOreSlurry("tailing_malachite",
                    ModBlocks.TAILING_MALACHITE_SLURRY,
                    ModItems.TAILING_MALACHITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF65a7a2, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_TETRAHEDRITE_SLURRY =
            registerOreSlurry("tailing_tetrahedrite",
                    ModBlocks.TAILING_TETRAHEDRITE_SLURRY,
                    ModItems.TAILING_TETRAHEDRITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF95948b, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_GARNIERITE_SLURRY =
            registerOreSlurry("tailing_garnierite",
                    ModBlocks.TAILING_GARNIERITE_SLURRY,
                    ModItems.TAILING_GARNIERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFa1bd90, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_CASSITERITE_SLURRY =
            registerOreSlurry("tailing_cassiterite",
                    ModBlocks.TAILING_CASSITERITE_SLURRY,
                    ModItems.TAILING_CASSITERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF8d8059, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_SPHALERITE_SLURRY =
            registerOreSlurry("tailing_sphalerite",
                    ModBlocks.TAILING_SPHALERITE_SLURRY,
                    ModItems.TAILING_SPHALERITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFFc1d1db, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );

    public static final FluidRegistryObject<ForgeFlowingFluid> TAILING_BISMUTHINITE_SLURRY =
            registerOreSlurry("tailing_bismuthinite",
                    ModBlocks.TAILING_BISMUTHINITE_SLURRY,
                    ModItems.TAILING_BISMUTHINITE_SLURRY_BUCKET,
                    new FluidTypeClientProperties(0xFF4f572e, THICKY_WATER_STILL, THICKY_WATER_FLOW, null, null)
                    );



    private static FluidType.Properties waterLike()
    {
        return FluidType.Properties.create()
                .adjacentPathType(BlockPathTypes.WATER)
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
                .adjacentPathType(BlockPathTypes.LAVA)
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
    FluidRegistryObject<ForgeFlowingFluid> registerOreSlurry(
            String oreName, RegistryObject<L> liquidBlock, RegistryObject<I> bucketItem, FluidTypeClientProperties fluidTypeClientProperties)
    {
        return register(
                oreName + "_slurry",
                properties -> properties
                        .block(liquidBlock)
                        .bucket(bucketItem),
                waterLike()
                        .descriptionId("fluid.tfc_trihydrate." + oreName + "_slurry"),
                fluidTypeClientProperties,
                MixingFluid.Source::new,
                MixingFluid.Flowing::new);
    }

    private static <F extends FlowingFluid> FluidRegistryObject<F> register(String name, Consumer<ForgeFlowingFluid.Properties> builder, FluidType.Properties typeProperties, FluidTypeClientProperties clientProperties, Function<ForgeFlowingFluid.Properties, F> sourceFactory, Function<ForgeFlowingFluid.Properties, F> flowingFactory)
    {
        // Names `metal/foo` to `metal/flowing_foo`
        final int index = name.lastIndexOf('/');
        final String flowingName = index == -1 ? "flowing_" + name : name.substring(0, index) + "/flowing_" + name.substring(index + 1);

        return RegistrationHelpers.registerFluid(FLUID_TYPES, FLUIDS, name, name, flowingName, builder, () -> new ExtendedFluidType(typeProperties, clientProperties), sourceFactory, flowingFactory);
    }

    public static void init(IEventBus modEventBus){
        FLUID_TYPES.register(modEventBus);
        FLUIDS.register(modEventBus);

    }

}
