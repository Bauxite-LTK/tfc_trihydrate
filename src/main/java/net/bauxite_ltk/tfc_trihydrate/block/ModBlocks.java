package net.bauxite_ltk.tfc_trihydrate.block;

import net.bauxite_ltk.tfc_trihydrate.fluid.ModFluids;
import net.bauxite_ltk.tfc_trihydrate.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate.MODID;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,MODID);

    public static final RegistryObject<LiquidBlock> SIMPLE_FLOTATION_SOLUTION = registerNoItem("fluid/simple_flotation_solution", () -> new LiquidBlock(ModFluids.SIMPLE_FLOTATION_SOLUTION.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> SODIUM_ETHYL_XANTHATE = registerNoItem("fluid/sodium_ethyl_xanthate", () -> new LiquidBlock(ModFluids.SODIUM_ETHYL_XANTHATE.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> LIME_SLURRY = registerNoItem("fluid/lime_slurry", () -> new LiquidBlock(ModFluids.LIME_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<LiquidBlock> HEMATITE_SLURRY = registerNoItem("fluid/hematite_slurry", () -> new LiquidBlock(ModFluids.HEMATITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> LIMONITE_SLURRY = registerNoItem("fluid/limonite_slurry", () -> new LiquidBlock(ModFluids.LIMONITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> MAGNETITE_SLURRY = registerNoItem("fluid/magnetite_slurry", () -> new LiquidBlock(ModFluids.MAGNETITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> NATIVE_COPPER_SLURRY = registerNoItem("fluid/native_copper_slurry", () -> new LiquidBlock(ModFluids.NATIVE_COPPER_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> NATIVE_SILVER_SLURRY = registerNoItem("fluid/native_silver_slurry", () -> new LiquidBlock(ModFluids.NATIVE_SILVER_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> NATIVE_GOLD_SLURRY = registerNoItem("fluid/native_gold_slurry", () -> new LiquidBlock(ModFluids.NATIVE_GOLD_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> MALACHITE_SLURRY = registerNoItem("fluid/malachite_slurry", () -> new LiquidBlock(ModFluids.MALACHITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TETRAHEDRITE_SLURRY = registerNoItem("fluid/tetrahedrite_slurry", () -> new LiquidBlock(ModFluids.TETRAHEDRITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> GARNIERITE_SLURRY = registerNoItem("fluid/garnierite_slurry", () -> new LiquidBlock(ModFluids.GARNIERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CASSITERITE_SLURRY = registerNoItem("fluid/cassiterite_slurry", () -> new LiquidBlock(ModFluids.CASSITERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> SPHALERITE_SLURRY = registerNoItem("fluid/sphalerite_slurry", () -> new LiquidBlock(ModFluids.SPHALERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> BISMUTHINITE_SLURRY = registerNoItem("fluid/bismuthinite_slurry", () -> new LiquidBlock(ModFluids.BISMUTHINITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));


    public static final RegistryObject<LiquidBlock> PROCESSED_HEMATITE_SLURRY = registerNoItem("fluid/processed_hematite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_HEMATITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_LIMONITE_SLURRY = registerNoItem("fluid/processed_limonite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_LIMONITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_MAGNETITE_SLURRY = registerNoItem("fluid/processed_magnetite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_MAGNETITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_NATIVE_COPPER_SLURRY = registerNoItem("fluid/processed_native_copper_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_NATIVE_COPPER_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_NATIVE_SILVER_SLURRY = registerNoItem("fluid/processed_native_silver_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_NATIVE_SILVER_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_NATIVE_GOLD_SLURRY = registerNoItem("fluid/processed_native_gold_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_NATIVE_GOLD_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_MALACHITE_SLURRY = registerNoItem("fluid/processed_malachite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_MALACHITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_TETRAHEDRITE_SLURRY = registerNoItem("fluid/processed_tetrahedrite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_TETRAHEDRITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_GARNIERITE_SLURRY = registerNoItem("fluid/processed_garnierite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_GARNIERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_CASSITERITE_SLURRY = registerNoItem("fluid/processed_cassiterite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_CASSITERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_SPHALERITE_SLURRY = registerNoItem("fluid/processed_sphalerite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_SPHALERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> PROCESSED_BISMUTHINITE_SLURRY = registerNoItem("fluid/processed_bismuthinite_slurry", () -> new LiquidBlock(ModFluids.PROCESSED_BISMUTHINITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<LiquidBlock> CONCENTRATE_HEMATITE_SLURRY = registerNoItem("fluid/concentrate_hematite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_HEMATITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_LIMONITE_SLURRY = registerNoItem("fluid/concentrate_limonite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_LIMONITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_MAGNETITE_SLURRY = registerNoItem("fluid/concentrate_magnetite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_MAGNETITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_NATIVE_COPPER_SLURRY = registerNoItem("fluid/concentrate_native_copper_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_NATIVE_COPPER_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_NATIVE_SILVER_SLURRY = registerNoItem("fluid/concentrate_native_silver_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_NATIVE_SILVER_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_NATIVE_GOLD_SLURRY = registerNoItem("fluid/concentrate_native_gold_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_NATIVE_GOLD_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_MALACHITE_SLURRY = registerNoItem("fluid/concentrate_malachite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_MALACHITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_TETRAHEDRITE_SLURRY = registerNoItem("fluid/concentrate_tetrahedrite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_TETRAHEDRITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_GARNIERITE_SLURRY = registerNoItem("fluid/concentrate_garnierite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_GARNIERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_CASSITERITE_SLURRY = registerNoItem("fluid/concentrate_cassiterite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_CASSITERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_SPHALERITE_SLURRY = registerNoItem("fluid/concentrate_sphalerite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_SPHALERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> CONCENTRATE_BISMUTHINITE_SLURRY = registerNoItem("fluid/concentrate_bismuthinite_slurry", () -> new LiquidBlock(ModFluids.CONCENTRATE_BISMUTHINITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<LiquidBlock> TAILING_HEMATITE_SLURRY = registerNoItem("fluid/tailing_hematite_slurry", () -> new LiquidBlock(ModFluids.TAILING_HEMATITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_LIMONITE_SLURRY = registerNoItem("fluid/tailing_limonite_slurry", () -> new LiquidBlock(ModFluids.TAILING_LIMONITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_MAGNETITE_SLURRY = registerNoItem("fluid/tailing_magnetite_slurry", () -> new LiquidBlock(ModFluids.TAILING_MAGNETITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_NATIVE_COPPER_SLURRY = registerNoItem("fluid/tailing_native_copper_slurry", () -> new LiquidBlock(ModFluids.TAILING_NATIVE_COPPER_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_NATIVE_SILVER_SLURRY = registerNoItem("fluid/tailing_native_silver_slurry", () -> new LiquidBlock(ModFluids.TAILING_NATIVE_SILVER_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_NATIVE_GOLD_SLURRY = registerNoItem("fluid/tailing_native_gold_slurry", () -> new LiquidBlock(ModFluids.TAILING_NATIVE_GOLD_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_MALACHITE_SLURRY = registerNoItem("fluid/tailing_malachite_slurry", () -> new LiquidBlock(ModFluids.TAILING_MALACHITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_TETRAHEDRITE_SLURRY = registerNoItem("fluid/tailing_tetrahedrite_slurry", () -> new LiquidBlock(ModFluids.TAILING_TETRAHEDRITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_GARNIERITE_SLURRY = registerNoItem("fluid/tailing_garnierite_slurry", () -> new LiquidBlock(ModFluids.TAILING_GARNIERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_CASSITERITE_SLURRY = registerNoItem("fluid/tailing_cassiterite_slurry", () -> new LiquidBlock(ModFluids.TAILING_CASSITERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_SPHALERITE_SLURRY = registerNoItem("fluid/tailing_sphalerite_slurry", () -> new LiquidBlock(ModFluids.TAILING_SPHALERITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));
    public static final RegistryObject<LiquidBlock> TAILING_BISMUTHINITE_SLURRY = registerNoItem("fluid/tailing_bismuthinite_slurry", () -> new LiquidBlock(ModFluids.TAILING_BISMUTHINITE_SLURRY.source(), BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));


    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block)
    {
        return BLOCKS.register(name, block);
    }

    public static void init(IEventBus modEventBus){
        BLOCKS.register(modEventBus);
    }
}
