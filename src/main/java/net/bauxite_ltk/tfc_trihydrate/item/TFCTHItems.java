package net.bauxite_ltk.tfc_trihydrate.item;

import net.bauxite_ltk.tfc_trihydrate.fluid.ModFluids;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate.MODID;

public class TFCTHItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

//    public static final DeferredItem<Item> LTK_TOOL = ITEMS.register("ltk_tool",
//            () -> new CustomSwordItem(
//                    CustomTiers.LTK,
//                    new Item.Properties()
//                            .rarity(Rarity.UNCOMMON)
//                            .stacksTo(1)
//                            .attributes(
//                                    SwordItem.createAttributes(CustomTiers.LTK, 3, -2.4f)
//                            )
//            )
//    );
    public static  final DeferredItem<Item> ADVANCED_VESSEL = ITEMS.register("ceramic/advanced_vessel", ()-> new AdvancedVesselItem(new Item.Properties()));
    public static  final DeferredItem<Item> UNFIRED_ADVANCED_VESSEL = ITEMS.registerSimpleItem("ceramic/unfired_advanced_vessel");

    public static final DeferredItem<Item> HEMATITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/hematite");
    public static final DeferredItem<Item> HEMATITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/hematite");
    public static final DeferredItem<Item> HEMATITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/hematite");
    public static final DeferredItem<Item> HEMATITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/hematite");
    public static final DeferredItem<Item> HEMATITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/hematite");
    public static final DeferredItem<Item> HEMATITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/hematite");
    public static final DeferredItem<Item> HEMATITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/hematite");


    public static final DeferredItem<Item> MAGNETITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/magnetite");
    public static final DeferredItem<Item> MAGNETITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/magnetite");
    public static final DeferredItem<Item> MAGNETITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/magnetite");
    public static final DeferredItem<Item> MAGNETITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/magnetite");
    public static final DeferredItem<Item> MAGNETITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/magnetite");
    public static final DeferredItem<Item> MAGNETITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/magnetite");
    public static final DeferredItem<Item> MAGNETITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/magnetite");

    public static final DeferredItem<Item> LIMONITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/limonite");
    public static final DeferredItem<Item> LIMONITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/limonite");
    public static final DeferredItem<Item> LIMONITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/limonite");
    public static final DeferredItem<Item> LIMONITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/limonite");
    public static final DeferredItem<Item> LIMONITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/limonite");
    public static final DeferredItem<Item> LIMONITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/limonite");
    public static final DeferredItem<Item> LIMONITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/limonite");


    public static final DeferredItem<Item> NATIVE_COPPER_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/native_copper");
    public static final DeferredItem<Item> NATIVE_COPPER_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/native_copper");
    public static final DeferredItem<Item> NATIVE_COPPER_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/native_copper");
    public static final DeferredItem<Item> NATIVE_COPPER_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/native_copper");
    public static final DeferredItem<Item> NATIVE_COPPER_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/native_copper");
    public static final DeferredItem<Item> NATIVE_COPPER_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/native_copper");
    public static final DeferredItem<Item> NATIVE_COPPER_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/native_copper");


    public static final DeferredItem<Item> NATIVE_SILVER_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/native_silver");
    public static final DeferredItem<Item> NATIVE_SILVER_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/native_silver");
    public static final DeferredItem<Item> NATIVE_SILVER_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/native_silver");
    public static final DeferredItem<Item> NATIVE_SILVER_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/native_silver");
    public static final DeferredItem<Item> NATIVE_SILVER_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/native_silver");
    public static final DeferredItem<Item> NATIVE_SILVER_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/native_silver");
    public static final DeferredItem<Item> NATIVE_SILVER_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/native_silver");

    
    public static final DeferredItem<Item> NATIVE_GOLD_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/native_gold");
    public static final DeferredItem<Item> NATIVE_GOLD_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/native_gold");
    public static final DeferredItem<Item> NATIVE_GOLD_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/native_gold");
    public static final DeferredItem<Item> NATIVE_GOLD_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/native_gold");
    public static final DeferredItem<Item> NATIVE_GOLD_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/native_gold");
    public static final DeferredItem<Item> NATIVE_GOLD_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/native_gold");
    public static final DeferredItem<Item> NATIVE_GOLD_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/native_gold");

    public static final DeferredItem<Item> MALACHITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/malachite");
    public static final DeferredItem<Item> MALACHITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/malachite");
    public static final DeferredItem<Item> MALACHITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/malachite");
    public static final DeferredItem<Item> MALACHITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/malachite");
    public static final DeferredItem<Item> MALACHITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/malachite");
    public static final DeferredItem<Item> MALACHITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/malachite");
    public static final DeferredItem<Item> MALACHITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/malachite");

    public static final DeferredItem<Item> TETRAHEDRITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/tetrahedrite");
    public static final DeferredItem<Item> TETRAHEDRITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/tetrahedrite");
    public static final DeferredItem<Item> TETRAHEDRITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/tetrahedrite");
    public static final DeferredItem<Item> TETRAHEDRITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/tetrahedrite");
    public static final DeferredItem<Item> TETRAHEDRITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/tetrahedrite");
    public static final DeferredItem<Item> TETRAHEDRITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/tetrahedrite");
    public static final DeferredItem<Item> TETRAHEDRITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/tetrahedrite");

    public static final DeferredItem<Item> CASSITERITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/cassiterite");
    public static final DeferredItem<Item> CASSITERITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/cassiterite");
    public static final DeferredItem<Item> CASSITERITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/cassiterite");
    public static final DeferredItem<Item> CASSITERITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/cassiterite");
    public static final DeferredItem<Item> CASSITERITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/cassiterite");
    public static final DeferredItem<Item> CASSITERITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/cassiterite");
    public static final DeferredItem<Item> CASSITERITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/cassiterite");

    public static final DeferredItem<Item> SPHALERITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/sphalerite");
    public static final DeferredItem<Item> SPHALERITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/sphalerite");
    public static final DeferredItem<Item> SPHALERITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/sphalerite");
    public static final DeferredItem<Item> SPHALERITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/sphalerite");
    public static final DeferredItem<Item> SPHALERITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/sphalerite");
    public static final DeferredItem<Item> SPHALERITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/sphalerite");
    public static final DeferredItem<Item> SPHALERITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/sphalerite");

    public static final DeferredItem<Item> BISMUTHINITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/bismuthinite");
    public static final DeferredItem<Item> BISMUTHINITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/bismuthinite");
    public static final DeferredItem<Item> BISMUTHINITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/bismuthinite");
    public static final DeferredItem<Item> BISMUTHINITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/bismuthinite");
    public static final DeferredItem<Item> BISMUTHINITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/bismuthinite");
    public static final DeferredItem<Item> BISMUTHINITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/bismuthinite");
    public static final DeferredItem<Item> BISMUTHINITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/bismuthinite");

    public static final DeferredItem<Item> GARNIERITE_CRYSTAL_CHUNK = ITEMS.registerSimpleItem("crystal_chunk/garnierite");
    public static final DeferredItem<Item> GARNIERITE_CONCENTRATE = ITEMS.registerSimpleItem("concentrate/garnierite");
    public static final DeferredItem<Item> GARNIERITE_PURE_COARSE_POWDER = ITEMS.registerSimpleItem("pure_coarse_powder/garnierite");
    public static final DeferredItem<Item> GARNIERITE_ORE_CHUNK = ITEMS.registerSimpleItem("ore_chunk/garnierite");
    public static final DeferredItem<Item> GARNIERITE_COARSE_POWDER = ITEMS.registerSimpleItem("coarse_powder/garnierite");
    public static final DeferredItem<Item> GARNIERITE_POOR_ORE_CHUNK = ITEMS.registerSimpleItem("poor_ore_chunk/garnierite");
    public static final DeferredItem<Item> GARNIERITE_DIRTY_COARSE_POWDER = ITEMS.registerSimpleItem("dirty_coarse_powder/garnierite");
    
    public static final DeferredItem<Item> SIMPLE_FLOTATION_SOLUTION_BUCKET =
            ITEMS.register("bucket/simple_flotation_solution",
                    () -> new BucketItem(
                            ModFluids.SIMPLE_FLOTATION_SOLUTION.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> SODIUM_ETHYL_XANTHATE_BUCKET =
            ITEMS.register("bucket/sodium_ethyl_xanthate",
                    () -> new BucketItem(
                            ModFluids.SODIUM_ETHYL_XANTHATE.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> LIME_SLURRY_BUCKET =
            ITEMS.register("bucket/lime_slurry",
                    () -> new BucketItem(
                            ModFluids.LIME_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );


    public static final DeferredItem<Item> HEMATITE_SLURRY_BUCKET =
            ITEMS.register("bucket/hematite_slurry",
                    () -> new BucketItem(
                            ModFluids.HEMATITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> LIMONITE_SLURRY_BUCKET =
            ITEMS.register("bucket/limonite_slurry",
                    () -> new BucketItem(
                            ModFluids.LIMONITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> MAGNETITE_SLURRY_BUCKET =
            ITEMS.register("bucket/magnetite_slurry",
                    () -> new BucketItem(
                            ModFluids.MAGNETITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> NATIVE_COPPER_SLURRY_BUCKET =
            ITEMS.register("bucket/native_copper_slurry",
                    () -> new BucketItem(
                            ModFluids.NATIVE_COPPER_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> NATIVE_SILVER_SLURRY_BUCKET =
            ITEMS.register("bucket/native_silver_slurry",
                    () -> new BucketItem(
                            ModFluids.NATIVE_SILVER_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> NATIVE_GOLD_SLURRY_BUCKET =
            ITEMS.register("bucket/native_gold_slurry",
                    () -> new BucketItem(
                            ModFluids.NATIVE_GOLD_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> MALACHITE_SLURRY_BUCKET =
            ITEMS.register("bucket/malachite_slurry",
                    () -> new BucketItem(
                            ModFluids.MALACHITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TETRAHEDRITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tetrahedrite_slurry",
                    () -> new BucketItem(
                            ModFluids.TETRAHEDRITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> GARNIERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/garnierite_slurry",
                    () -> new BucketItem(
                            ModFluids.GARNIERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CASSITERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/cassiterite_slurry",
                    () -> new BucketItem(
                            ModFluids.CASSITERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> SPHALERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/sphalerite_slurry",
                    () -> new BucketItem(
                            ModFluids.SPHALERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> BISMUTHINITE_SLURRY_BUCKET =
            ITEMS.register("bucket/bismuthinite_slurry",
                    () -> new BucketItem(
                            ModFluids.BISMUTHINITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_HEMATITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_hematite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_HEMATITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_LIMONITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_limonite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_LIMONITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_MAGNETITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_magnetite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_MAGNETITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_NATIVE_COPPER_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_native_copper_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_NATIVE_COPPER_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_NATIVE_SILVER_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_native_silver_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_NATIVE_SILVER_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_NATIVE_GOLD_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_native_gold_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_NATIVE_GOLD_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_MALACHITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_malachite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_MALACHITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_TETRAHEDRITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_tetrahedrite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_TETRAHEDRITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_GARNIERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_garnierite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_GARNIERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_CASSITERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_cassiterite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_CASSITERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_SPHALERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_sphalerite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_SPHALERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> PROCESSED_BISMUTHINITE_SLURRY_BUCKET =
            ITEMS.register("bucket/processed_bismuthinite_slurry",
                    () -> new BucketItem(
                            ModFluids.PROCESSED_BISMUTHINITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );



    public static final DeferredItem<Item> CONCENTRATE_HEMATITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_hematite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_HEMATITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_LIMONITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_limonite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_LIMONITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_MAGNETITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_magnetite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_MAGNETITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_NATIVE_COPPER_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_native_copper_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_NATIVE_COPPER_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_NATIVE_SILVER_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_native_silver_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_NATIVE_SILVER_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_NATIVE_GOLD_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_native_gold_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_NATIVE_GOLD_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_MALACHITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_malachite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_MALACHITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_TETRAHEDRITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_tetrahedrite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_TETRAHEDRITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_GARNIERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_garnierite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_GARNIERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_CASSITERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_cassiterite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_CASSITERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_SPHALERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_sphalerite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_SPHALERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> CONCENTRATE_BISMUTHINITE_SLURRY_BUCKET =
            ITEMS.register("bucket/concentrate_bismuthinite_slurry",
                    () -> new BucketItem(
                            ModFluids.CONCENTRATE_BISMUTHINITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );




    public static final DeferredItem<Item> TAILING_HEMATITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_hematite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_HEMATITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_LIMONITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_limonite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_LIMONITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_MAGNETITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_magnetite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_MAGNETITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_NATIVE_COPPER_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_native_copper_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_NATIVE_COPPER_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_NATIVE_SILVER_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_native_silver_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_NATIVE_SILVER_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_NATIVE_GOLD_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_native_gold_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_NATIVE_GOLD_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_MALACHITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_malachite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_MALACHITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_TETRAHEDRITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_tetrahedrite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_TETRAHEDRITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_GARNIERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_garnierite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_GARNIERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_CASSITERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_cassiterite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_CASSITERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_SPHALERITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_sphalerite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_SPHALERITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );

    public static final DeferredItem<Item> TAILING_BISMUTHINITE_SLURRY_BUCKET =
            ITEMS.register("bucket/tailing_bismuthinite_slurry",
                    () -> new BucketItem(
                            ModFluids.TAILING_BISMUTHINITE_SLURRY.getSource(),
                            new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    )
            );


    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }



}
