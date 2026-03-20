package net.bauxite_ltk.tfc_trihydrate.tag;

import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

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
