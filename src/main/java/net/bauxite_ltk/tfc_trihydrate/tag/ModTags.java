package net.bauxite_ltk.tfc_trihydrate.tag;

import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.util.Ores;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ModTags {
    public static class Fluids{
        public static final TagKey<Fluid> SIMPLE_FLOTATION_SOLUTION = createTag("simple_flotation_slurry");
        public static final TagKey<Fluid> HEMATITE_ORE_SLURRY = createTag("ore_slurry/hematite" + Ores.HEMATITE.name());
        public static final TagKey<Fluid> LIMONITE_ORE_SLURRY = createTag("ore_slurry/" + Ores.LIMONITE.name());
        public static final TagKey<Fluid> MAGNETITE_ORE_SLURRY = createTag("ore_slurry/" + Ores.MAGNETITE.name());
        public static final TagKey<Fluid> NATIVE_COPPER_ORE_SLURRY = createTag("ore_slurry/" + Ores.NATIVE_COPPER.name());
        public static final TagKey<Fluid> NATIVE_SILVER_ORE_SLURRY = createTag("ore_slurry/" + Ores.NATIVE_SILVER.name());
        public static final TagKey<Fluid> NATIVE_GOLD_ORE_SLURRY = createTag("ore_slurry/" + Ores.NATIVE_GOLD.name());
        public static final TagKey<Fluid> MALACHITE_ORE_SLURRY = createTag("ore_slurry/" + Ores.MALACHITE.name());
        public static final TagKey<Fluid> TETRAHEDRITE_ORE_SLURRY = createTag("ore_slurry/" + Ores.TETRAHEDRITE.name());
        public static final TagKey<Fluid> GARNIERITE_ORE_SLURRY = createTag("ore_slurry/" + Ores.GARNIERITE.name());
        public static final TagKey<Fluid> CASSITERITE_ORE_SLURRY = createTag("ore_slurry/" + Ores.CASSITERITE.name());
        public static final TagKey<Fluid> SPHALERITE_ORE_SLURRY = createTag("ore_slurry/" + Ores.SPHALERITE.name());
        public static final TagKey<Fluid> BISMUTHINITE_ORE_SLURRY = createTag("ore_slurry/" + Ores.BISMUTHINITE.name());
        
        public static final TagKey<Fluid> PROCESSED_HEMATITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.HEMATITE.name());
        public static final TagKey<Fluid> PROCESSED_LIMONITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.LIMONITE.name());
        public static final TagKey<Fluid> PROCESSED_MAGNETITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.MAGNETITE.name());
        public static final TagKey<Fluid> PROCESSED_NATIVE_COPPER_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.NATIVE_COPPER.name());
        public static final TagKey<Fluid> PROCESSED_NATIVE_SILVER_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.NATIVE_SILVER.name());
        public static final TagKey<Fluid> PROCESSED_NATIVE_GOLD_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.NATIVE_GOLD.name());
        public static final TagKey<Fluid> PROCESSED_MALACHITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.MALACHITE.name());
        public static final TagKey<Fluid> PROCESSED_TETRAHEDRITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.TETRAHEDRITE.name());
        public static final TagKey<Fluid> PROCESSED_GARNIERITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.GARNIERITE.name());
        public static final TagKey<Fluid> PROCESSED_CASSITERITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.CASSITERITE.name());
        public static final TagKey<Fluid> PROCESSED_SPHALERITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.SPHALERITE.name());
        public static final TagKey<Fluid> PROCESSED_BISMUTHINITE_ORE_SLURRY = createTag("processed_ore_slurry/" + Ores.BISMUTHINITE.name());


        public static final TagKey<Fluid> CONCENTRATE_HEMATITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.HEMATITE.name());
        public static final TagKey<Fluid> CONCENTRATE_LIMONITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.LIMONITE.name());
        public static final TagKey<Fluid> CONCENTRATE_MAGNETITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.MAGNETITE.name());
        public static final TagKey<Fluid> CONCENTRATE_NATIVE_COPPER_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.NATIVE_COPPER.name());
        public static final TagKey<Fluid> CONCENTRATE_NATIVE_SILVER_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.NATIVE_SILVER.name());
        public static final TagKey<Fluid> CONCENTRATE_NATIVE_GOLD_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.NATIVE_GOLD.name());
        public static final TagKey<Fluid> CONCENTRATE_MALACHITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.MALACHITE.name());
        public static final TagKey<Fluid> CONCENTRATE_TETRAHEDRITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.TETRAHEDRITE.name());
        public static final TagKey<Fluid> CONCENTRATE_GARNIERITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.GARNIERITE.name());
        public static final TagKey<Fluid> CONCENTRATE_CASSITERITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.CASSITERITE.name());
        public static final TagKey<Fluid> CONCENTRATE_SPHALERITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.SPHALERITE.name());
        public static final TagKey<Fluid> CONCENTRATE_BISMUTHINITE_ORE_SLURRY = createTag("concentrate_ore_slurry/" + Ores.BISMUTHINITE.name());
        
        public static final TagKey<Fluid> TAILING_HEMATITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.HEMATITE.name());
        public static final TagKey<Fluid> TAILING_LIMONITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.LIMONITE.name());
        public static final TagKey<Fluid> TAILING_MAGNETITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.MAGNETITE.name());
        public static final TagKey<Fluid> TAILING_NATIVE_COPPER_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.NATIVE_COPPER.name());
        public static final TagKey<Fluid> TAILING_NATIVE_SILVER_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.NATIVE_SILVER.name());
        public static final TagKey<Fluid> TAILING_NATIVE_GOLD_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.NATIVE_GOLD.name());
        public static final TagKey<Fluid> TAILING_MALACHITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.MALACHITE.name());
        public static final TagKey<Fluid> TAILING_TETRAHEDRITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.TETRAHEDRITE.name());
        public static final TagKey<Fluid> TAILING_GARNIERITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.GARNIERITE.name());
        public static final TagKey<Fluid> TAILING_CASSITERITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.CASSITERITE.name());
        public static final TagKey<Fluid> TAILING_SPHALERITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.SPHALERITE.name());
        public static final TagKey<Fluid> TAILING_BISMUTHINITE_ORE_SLURRY = createTag("tailing_ore_slurry/" + Ores.BISMUTHINITE.name());




        private static TagKey<Fluid> createTag(String name){
            return FluidTags.create(ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID, name));
        }
    }



    public static class Blocks{
        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> CRYSTAL_CHUNKS = createTag("crystal_chunks");
        public static final TagKey<Item> CONCENTRATES = createTag("concentrates");
        public static final TagKey<Item> ORE_CHUNKS = createTag("ore_chunks");
        public static final TagKey<Item> PURE_COARSE_POWDERS = createTag("pure_coarse_powders");
        public static final TagKey<Item> COARSE_POWDERS = createTag("coarse_powders");
        public static final TagKey<Item> POOR_ORE_CHUNKS = createTag("poor_ore_chunks");
        public static final TagKey<Item> DIRTY_COARSE_POWDERS = createTag("dirty_coarse_powders");

        private static TagKey<Item> createTag(String name){
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID, name));
        }
    }
}
