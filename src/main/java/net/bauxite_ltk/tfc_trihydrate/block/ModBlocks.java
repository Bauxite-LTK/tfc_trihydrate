package net.bauxite_ltk.tfc_trihydrate.block;

import net.bauxite_ltk.tfc_trihydrate.fluid.ModFluids;
import net.bauxite_ltk.tfc_trihydrate.item.TFCTHItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate.MODID;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredBlock<LiquidBlock> SIMPLE_FLOTATION_SOLUTION = registerNoItem("fluid/simple_flotation_solution", () -> new LiquidBlock(ModFluids.SIMPLE_FLOTATION_SOLUTION.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> SODIUM_ETHYL_XANTHATE = registerNoItem("fluid/sodium_ethyl_xanthate", () -> new LiquidBlock(ModFluids.SODIUM_ETHYL_XANTHATE.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> LIME_SLURRY = registerNoItem("fluid/lime_slurry", () -> new LiquidBlock(ModFluids.LIME_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));

    public static final DeferredBlock<LiquidBlock> HEMATITE_SLURRY = registerNoItem("fluid/hematite_slurry", () -> new LiquidBlock(ModFluids.HEMATITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> LIMONITE_SLURRY = registerNoItem("fluid/limonite_slurry", () -> new LiquidBlock(ModFluids.LIMONITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> MAGNETITE_SLURRY = registerNoItem("fluid/magnetite_slurry", () -> new LiquidBlock(ModFluids.MAGNETITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> NATIVE_COPPER_SLURRY = registerNoItem("fluid/native_copper_slurry", () -> new LiquidBlock(ModFluids.NATIVE_COPPER_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> NATIVE_SILVER_SLURRY = registerNoItem("fluid/native_silver_slurry", () -> new LiquidBlock(ModFluids.NATIVE_SILVER_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> NATIVE_GOLD_SLURRY = registerNoItem("fluid/native_gold_slurry", () -> new LiquidBlock(ModFluids.NATIVE_GOLD_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> MALACHITE_SLURRY = registerNoItem("fluid/malachite_slurry", () -> new LiquidBlock(ModFluids.MALACHITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TETRAHEDRITE_SLURRY = registerNoItem("fluid/tetrahedrite_slurry", () -> new LiquidBlock(ModFluids.TETRAHEDRITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> GARNIERITE_SLURRY = registerNoItem("fluid/garnierite_slurry", () -> new LiquidBlock(ModFluids.GARNIERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CASSITERITE_SLURRY = registerNoItem("fluid/cassiterite_slurry", () -> new LiquidBlock(ModFluids.CASSITERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> SPHALERITE_SLURRY = registerNoItem("fluid/sphalerite_slurry", () -> new LiquidBlock(ModFluids.SPHALERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> BISMUTHINITE_SLURRY = registerNoItem("fluid/bismuthinite_slurry", () -> new LiquidBlock(ModFluids.BISMUTHINITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));


    public static final DeferredBlock<LiquidBlock> PROCESSED_HEMATITE_SLURRY = registerNoItem("fluid/processed_hematite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_HEMATITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_LIMONITE_SLURRY = registerNoItem("fluid/processed_limonite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_LIMONITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_MAGNETITE_SLURRY = registerNoItem("fluid/processed_magnetite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_MAGNETITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_NATIVE_COPPER_SLURRY = registerNoItem("fluid/processed_native_copper_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_NATIVE_COPPER_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_NATIVE_SILVER_SLURRY = registerNoItem("fluid/processed_native_silver_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_NATIVE_SILVER_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_NATIVE_GOLD_SLURRY = registerNoItem("fluid/processed_native_gold_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_NATIVE_GOLD_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_MALACHITE_SLURRY = registerNoItem("fluid/processed_malachite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_MALACHITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_TETRAHEDRITE_SLURRY = registerNoItem("fluid/processed_tetrahedrite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_TETRAHEDRITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_GARNIERITE_SLURRY = registerNoItem("fluid/processed_garnierite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_GARNIERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_CASSITERITE_SLURRY = registerNoItem("fluid/processed_cassiterite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_CASSITERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_SPHALERITE_SLURRY = registerNoItem("fluid/processed_sphalerite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_SPHALERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> PROCESSED_BISMUTHINITE_SLURRY = registerNoItem("fluid/processed_bismuthinite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_BISMUTHINITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));

    public static final DeferredBlock<LiquidBlock> CONCENTRATE_HEMATITE_SLURRY = registerNoItem("fluid/concentrate_hematite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_HEMATITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_LIMONITE_SLURRY = registerNoItem("fluid/concentrate_limonite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_LIMONITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_MAGNETITE_SLURRY = registerNoItem("fluid/concentrate_magnetite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_MAGNETITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_NATIVE_COPPER_SLURRY = registerNoItem("fluid/concentrate_native_copper_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_NATIVE_COPPER_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_NATIVE_SILVER_SLURRY = registerNoItem("fluid/concentrate_native_silver_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_NATIVE_SILVER_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_NATIVE_GOLD_SLURRY = registerNoItem("fluid/concentrate_native_gold_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_NATIVE_GOLD_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_MALACHITE_SLURRY = registerNoItem("fluid/concentrate_malachite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_MALACHITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_TETRAHEDRITE_SLURRY = registerNoItem("fluid/concentrate_tetrahedrite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_TETRAHEDRITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_GARNIERITE_SLURRY = registerNoItem("fluid/concentrate_garnierite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_GARNIERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_CASSITERITE_SLURRY = registerNoItem("fluid/concentrate_cassiterite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_CASSITERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_SPHALERITE_SLURRY = registerNoItem("fluid/concentrate_sphalerite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_SPHALERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> CONCENTRATE_BISMUTHINITE_SLURRY = registerNoItem("fluid/concentrate_bismuthinite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_BISMUTHINITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));

    public static final DeferredBlock<LiquidBlock> TAILING_HEMATITE_SLURRY = registerNoItem("fluid/tailing_hematite_slurry", () -> new LiquidBlock(ModFluids.TAILING_HEMATITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_LIMONITE_SLURRY = registerNoItem("fluid/tailing_limonite_slurry", () -> new LiquidBlock(ModFluids.TAILING_LIMONITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_MAGNETITE_SLURRY = registerNoItem("fluid/tailing_magnetite_slurry", () -> new LiquidBlock(ModFluids.TAILING_MAGNETITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_NATIVE_COPPER_SLURRY = registerNoItem("fluid/tailing_native_copper_slurry", () -> new LiquidBlock(ModFluids.TAILING_NATIVE_COPPER_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_NATIVE_SILVER_SLURRY = registerNoItem("fluid/tailing_native_silver_slurry", () -> new LiquidBlock(ModFluids.TAILING_NATIVE_SILVER_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_NATIVE_GOLD_SLURRY = registerNoItem("fluid/tailing_native_gold_slurry", () -> new LiquidBlock(ModFluids.TAILING_NATIVE_GOLD_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_MALACHITE_SLURRY = registerNoItem("fluid/tailing_malachite_slurry", () -> new LiquidBlock(ModFluids.TAILING_MALACHITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_TETRAHEDRITE_SLURRY = registerNoItem("fluid/tailing_tetrahedrite_slurry", () -> new LiquidBlock(ModFluids.TAILING_TETRAHEDRITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_GARNIERITE_SLURRY = registerNoItem("fluid/tailing_garnierite_slurry", () -> new LiquidBlock(ModFluids.TAILING_GARNIERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_CASSITERITE_SLURRY = registerNoItem("fluid/tailing_cassiterite_slurry", () -> new LiquidBlock(ModFluids.TAILING_CASSITERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_SPHALERITE_SLURRY = registerNoItem("fluid/tailing_sphalerite_slurry", () -> new LiquidBlock(ModFluids.TAILING_SPHALERITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));
    public static final DeferredBlock<LiquidBlock> TAILING_BISMUTHINITE_SLURRY = registerNoItem("fluid/tailing_bismuthinite_slurry", () -> new LiquidBlock(ModFluids.TAILING_BISMUTHINITE_SLURRY.getFlowing(), BlockBehaviour.Properties.ofFullCopy(Blocks.WATER).noLootTable()));


    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        TFCTHItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> registerNoItem(String name, Supplier<T> block)
    {
        return BLOCKS.register(name, block);
    }

    public static void init(IEventBus modEventBus){
        BLOCKS.register(modEventBus);
    }
}
