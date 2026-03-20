package net.bauxite_ltk.tfc_trihydrate;

import net.dries007.tfc.common.blocks.rock.Ore;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


import static net.bauxite_ltk.tfc_trihydrate.item.ModItems.*;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TFCTrihydrate.MODID);
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tfc_trihydrate")) //The language key for the title of your CreativeModeTab
            .icon(() -> TFCItems.GRADED_ORES.get(Ore.HEMATITE).get(Ore.Grade.RICH).get().getDefaultInstance())
            .displayItems((parameters, output) -> {

                output.accept(TFCItems.GRADED_ORES.get(Ore.HEMATITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.HEMATITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.HEMATITE).get(Ore.Grade.POOR).get());
                output.accept(HEMATITE_CRYSTAL_CHUNK.get());
                output.accept(HEMATITE_ORE_CHUNK.get());
                output.accept(HEMATITE_POOR_ORE_CHUNK.get());
                output.accept(HEMATITE_PURE_COARSE_POWDER.get());
                output.accept(HEMATITE_COARSE_POWDER.get());
                output.accept(HEMATITE_DIRTY_COARSE_POWDER.get());


                output.accept(TFCItems.GRADED_ORES.get(Ore.LIMONITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.LIMONITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.LIMONITE).get(Ore.Grade.POOR).get());
                output.accept(LIMONITE_CRYSTAL_CHUNK.get());
                output.accept(LIMONITE_ORE_CHUNK.get());
                output.accept(LIMONITE_POOR_ORE_CHUNK.get());
                output.accept(LIMONITE_PURE_COARSE_POWDER.get());
                output.accept(LIMONITE_COARSE_POWDER.get());
                output.accept(LIMONITE_DIRTY_COARSE_POWDER.get());


                output.accept(TFCItems.GRADED_ORES.get(Ore.MAGNETITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.MAGNETITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.MAGNETITE).get(Ore.Grade.POOR).get());
                output.accept(MAGNETITE_CRYSTAL_CHUNK.get());
                output.accept(MAGNETITE_ORE_CHUNK.get());
                output.accept(MAGNETITE_POOR_ORE_CHUNK.get());
                output.accept(MAGNETITE_PURE_COARSE_POWDER.get());
                output.accept(MAGNETITE_COARSE_POWDER.get());
                output.accept(MAGNETITE_DIRTY_COARSE_POWDER.get());


                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_COPPER).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_COPPER).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_COPPER).get(Ore.Grade.POOR).get());
                output.accept(NATIVE_COPPER_CRYSTAL_CHUNK.get());
                output.accept(NATIVE_COPPER_ORE_CHUNK.get());
                output.accept(NATIVE_COPPER_POOR_ORE_CHUNK.get());
                output.accept(NATIVE_COPPER_PURE_COARSE_POWDER.get());
                output.accept(NATIVE_COPPER_COARSE_POWDER.get());
                output.accept(NATIVE_COPPER_DIRTY_COARSE_POWDER.get());


                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_SILVER).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_SILVER).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_SILVER).get(Ore.Grade.POOR).get());
                output.accept(NATIVE_SILVER_CRYSTAL_CHUNK.get());
                output.accept(NATIVE_SILVER_ORE_CHUNK.get());
                output.accept(NATIVE_SILVER_POOR_ORE_CHUNK.get());
                output.accept(NATIVE_SILVER_PURE_COARSE_POWDER.get());
                output.accept(NATIVE_SILVER_COARSE_POWDER.get());
                output.accept(NATIVE_SILVER_DIRTY_COARSE_POWDER.get());

                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_GOLD).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_GOLD).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.NATIVE_GOLD).get(Ore.Grade.POOR).get());
                output.accept(NATIVE_GOLD_CRYSTAL_CHUNK.get());
                output.accept(NATIVE_GOLD_ORE_CHUNK.get());
                output.accept(NATIVE_GOLD_POOR_ORE_CHUNK.get());
                output.accept(NATIVE_GOLD_PURE_COARSE_POWDER.get());
                output.accept(NATIVE_GOLD_COARSE_POWDER.get());
                output.accept(NATIVE_GOLD_DIRTY_COARSE_POWDER.get());

                output.accept(TFCItems.GRADED_ORES.get(Ore.MALACHITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.MALACHITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.MALACHITE).get(Ore.Grade.POOR).get());
                output.accept(MALACHITE_CRYSTAL_CHUNK.get());
                output.accept(MALACHITE_ORE_CHUNK.get());
                output.accept(MALACHITE_POOR_ORE_CHUNK.get());
                output.accept(MALACHITE_PURE_COARSE_POWDER.get());
                output.accept(MALACHITE_COARSE_POWDER.get());
                output.accept(MALACHITE_DIRTY_COARSE_POWDER.get());

                output.accept(TFCItems.GRADED_ORES.get(Ore.TETRAHEDRITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.TETRAHEDRITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.TETRAHEDRITE).get(Ore.Grade.POOR).get());
                output.accept(TETRAHEDRITE_CRYSTAL_CHUNK.get());
                output.accept(TETRAHEDRITE_ORE_CHUNK.get());
                output.accept(TETRAHEDRITE_POOR_ORE_CHUNK.get());
                output.accept(TETRAHEDRITE_PURE_COARSE_POWDER.get());
                output.accept(TETRAHEDRITE_COARSE_POWDER.get());
                output.accept(TETRAHEDRITE_DIRTY_COARSE_POWDER.get());


                output.accept(TFCItems.GRADED_ORES.get(Ore.GARNIERITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.GARNIERITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.GARNIERITE).get(Ore.Grade.POOR).get());
                output.accept(GARNIERITE_CRYSTAL_CHUNK.get());
                output.accept(GARNIERITE_ORE_CHUNK.get());
                output.accept(GARNIERITE_POOR_ORE_CHUNK.get());
                output.accept(GARNIERITE_PURE_COARSE_POWDER.get());
                output.accept(GARNIERITE_COARSE_POWDER.get());
                output.accept(GARNIERITE_DIRTY_COARSE_POWDER.get());


                output.accept(TFCItems.GRADED_ORES.get(Ore.CASSITERITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.CASSITERITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.CASSITERITE).get(Ore.Grade.POOR).get());
                output.accept(CASSITERITE_CRYSTAL_CHUNK.get());
                output.accept(CASSITERITE_ORE_CHUNK.get());
                output.accept(CASSITERITE_POOR_ORE_CHUNK.get());
                output.accept(CASSITERITE_PURE_COARSE_POWDER.get());
                output.accept(CASSITERITE_COARSE_POWDER.get());
                output.accept(CASSITERITE_DIRTY_COARSE_POWDER.get());


                output.accept(TFCItems.GRADED_ORES.get(Ore.SPHALERITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.SPHALERITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.SPHALERITE).get(Ore.Grade.POOR).get());
                output.accept(SPHALERITE_CRYSTAL_CHUNK.get());
                output.accept(SPHALERITE_ORE_CHUNK.get());
                output.accept(SPHALERITE_POOR_ORE_CHUNK.get());
                output.accept(SPHALERITE_PURE_COARSE_POWDER.get());
                output.accept(SPHALERITE_COARSE_POWDER.get());
                output.accept(SPHALERITE_DIRTY_COARSE_POWDER.get());

                output.accept(TFCItems.GRADED_ORES.get(Ore.BISMUTHINITE).get(Ore.Grade.RICH).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.BISMUTHINITE).get(Ore.Grade.NORMAL).get());
                output.accept(TFCItems.GRADED_ORES.get(Ore.BISMUTHINITE).get(Ore.Grade.POOR).get());
                output.accept(BISMUTHINITE_CRYSTAL_CHUNK.get());
                output.accept(BISMUTHINITE_ORE_CHUNK.get());
                output.accept(BISMUTHINITE_POOR_ORE_CHUNK.get());
                output.accept(BISMUTHINITE_PURE_COARSE_POWDER.get());
                output.accept(BISMUTHINITE_COARSE_POWDER.get());
                output.accept(BISMUTHINITE_DIRTY_COARSE_POWDER.get());


                
                
                
                output.accept(HEMATITE_CONCENTRATE.get());
                output.accept(LIMONITE_CONCENTRATE.get());
                output.accept(MAGNETITE_CONCENTRATE.get());
                output.accept(NATIVE_COPPER_CONCENTRATE.get());
                output.accept(NATIVE_SILVER_CONCENTRATE.get());
                output.accept(NATIVE_GOLD_CONCENTRATE.get());
                output.accept(MALACHITE_CONCENTRATE.get());
                output.accept(TETRAHEDRITE_CONCENTRATE.get());
                output.accept(GARNIERITE_CONCENTRATE.get());
                output.accept(CASSITERITE_CONCENTRATE.get());
                output.accept(SPHALERITE_CONCENTRATE.get());
                output.accept(BISMUTHINITE_CONCENTRATE.get());



                output.accept(HEMATITE_SLURRY_BUCKET.get());
                output.accept(LIMONITE_SLURRY_BUCKET.get());
                output.accept(MAGNETITE_SLURRY_BUCKET.get());
                output.accept(NATIVE_COPPER_SLURRY_BUCKET.get());
                output.accept(NATIVE_SILVER_SLURRY_BUCKET.get());
                output.accept(NATIVE_GOLD_SLURRY_BUCKET.get());
                output.accept(MALACHITE_SLURRY_BUCKET.get());
                output.accept(TETRAHEDRITE_SLURRY_BUCKET.get());
                output.accept(GARNIERITE_SLURRY_BUCKET.get());
                output.accept(CASSITERITE_SLURRY_BUCKET.get());
                output.accept(SPHALERITE_SLURRY_BUCKET.get());
                output.accept(BISMUTHINITE_SLURRY_BUCKET.get());

                output.accept(PROCESSED_HEMATITE_SLURRY_BUCKET.get());
                output.accept(PROCESSED_LIMONITE_SLURRY_BUCKET.get());
                output.accept(PROCESSED_MAGNETITE_SLURRY_BUCKET.get());
                output.accept(PROCESSED_NATIVE_COPPER_SLURRY_BUCKET.get());
                output.accept(PROCESSED_NATIVE_SILVER_SLURRY_BUCKET.get());
                output.accept(PROCESSED_NATIVE_GOLD_SLURRY_BUCKET.get());
                output.accept(PROCESSED_MALACHITE_SLURRY_BUCKET.get());
                output.accept(PROCESSED_TETRAHEDRITE_SLURRY_BUCKET.get());
                output.accept(PROCESSED_GARNIERITE_SLURRY_BUCKET.get());
                output.accept(PROCESSED_CASSITERITE_SLURRY_BUCKET.get());
                output.accept(PROCESSED_SPHALERITE_SLURRY_BUCKET.get());
                output.accept(PROCESSED_BISMUTHINITE_SLURRY_BUCKET.get());


                output.accept(CONCENTRATE_HEMATITE_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_LIMONITE_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_MAGNETITE_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_NATIVE_COPPER_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_NATIVE_SILVER_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_NATIVE_GOLD_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_MALACHITE_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_TETRAHEDRITE_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_GARNIERITE_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_CASSITERITE_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_SPHALERITE_SLURRY_BUCKET.get());
                output.accept(CONCENTRATE_BISMUTHINITE_SLURRY_BUCKET.get());

                output.accept(TAILING_HEMATITE_SLURRY_BUCKET.get());
                output.accept(TAILING_LIMONITE_SLURRY_BUCKET.get());
                output.accept(TAILING_MAGNETITE_SLURRY_BUCKET.get());
                output.accept(TAILING_NATIVE_COPPER_SLURRY_BUCKET.get());
                output.accept(TAILING_NATIVE_SILVER_SLURRY_BUCKET.get());
                output.accept(TAILING_NATIVE_GOLD_SLURRY_BUCKET.get());
                output.accept(TAILING_MALACHITE_SLURRY_BUCKET.get());
                output.accept(TAILING_TETRAHEDRITE_SLURRY_BUCKET.get());
                output.accept(TAILING_GARNIERITE_SLURRY_BUCKET.get());
                output.accept(TAILING_CASSITERITE_SLURRY_BUCKET.get());
                output.accept(TAILING_SPHALERITE_SLURRY_BUCKET.get());
                output.accept(TAILING_BISMUTHINITE_SLURRY_BUCKET.get());

                output.accept(SIMPLE_FLOTATION_SOLUTION_BUCKET.get());
                output.accept(SODIUM_ETHYL_XANTHATE_BUCKET.get());
                output.accept(LIME_SLURRY_BUCKET.get());

                //output.accept(LTK_TOOL.get());// Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

    public static void init(IEventBus modEventBus){
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
