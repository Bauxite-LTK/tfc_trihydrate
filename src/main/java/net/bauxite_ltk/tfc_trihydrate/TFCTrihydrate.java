package net.bauxite_ltk.tfc_trihydrate;

import net.bauxite_ltk.tfc_trihydrate.block.ModBlocks;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblocks;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockBuilder;
import net.bauxite_ltk.tfc_trihydrate.crafting.TFCTHRecipeSerializers;
import net.bauxite_ltk.tfc_trihydrate.crafting.TFCTHRecipeType;
import net.bauxite_ltk.tfc_trihydrate.effect.ModEffects;
import net.bauxite_ltk.tfc_trihydrate.fluid.ModFluids;
import net.bauxite_ltk.tfc_trihydrate.gui.TFCTHMenuTypes;
import net.bauxite_ltk.tfc_trihydrate.item.ModItems;
import net.minecraft.world.item.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TFCTrihydrate.MODID)
public class TFCTrihydrate {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tfc_trihydrate";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "tfc_trihydrate" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "tfc_trihydrate" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "tfc_trihydrate" namespace
    ///public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a new Block with the id "tfc_trihydrate:example_block", combining the namespace and path
    ///public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.registerSimpleBlock("example_block", BlockBehaviour.Properties.of().mapColor(MapColor.STONE));
    // Creates a new BlockItem with the id "tfc_trihydrate:example_block", combining the namespace and path
    ///public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    // Creates a new food item with the id "tfc_trihydrate:example_id", nutrition 1 and saturation 2
    ///public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.registerSimpleItem("example_item", new Item.Properties().food(new FoodProperties.Builder()
    ///        .alwaysEdible().nutrition(1).saturationModifier(2f).build()));







    // Creates a creative tab with the id "tfc_trihydrate:example_tab" for the example item, that is placed after the combat tab
///    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
///            .title(Component.translatable("itemGroup.tfc_trihydrate")) //The language key for the title of your CreativeModeTab
///            .withTabsBefore(CreativeModeTabs.COMBAT)
///            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
///            .displayItems((parameters, output) -> {
///                output.accept(EXAMPLE_ITEM.get());
///                output.accept(EXAMPLE_BLOCK_ITEM.get());
///                output.accept(LTK_TOOL.get());// Add the example item to the tab. For your own tabs, this method is preferred over the event
///            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public TFCTrihydrate(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        TFCTHRecipeSerializers.init(modEventBus);
        // Register the Deferred Register to the mod event bus so blocks get registered
        ModBlocks.init(modEventBus);
        ModItems.init(modEventBus);
        ModEffects.init(modEventBus);
        ModFluids.init(modEventBus);
        ModCreativeTabs.init(modEventBus);

        TFCTHMultiblocks.init();
        TFCTHMultiblockLogic.init(modEventBus);
        TFCTHMultiblockBuilder.handleModBusRegistrations(modEventBus);

        TFCTHRecipeType.init(modEventBus);
        TFCTHMenuTypes.init(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (TFCTrihydrate) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);

        //populateAPI();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM TFC:TH COMMON SETUP");
        populateAPI();
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            //event.accept(ModItems.LTK_TOOL);
        }
    }


    public static void populateAPI(){
        Config.MACHINES.populateAPI();
    }




    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

}
