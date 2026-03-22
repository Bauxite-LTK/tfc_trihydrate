package net.bauxite_ltk.tfc_trihydrate;


import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockProperties;
import net.bauxite_ltk.tfc_trihydrate.fluid.ModFluids;
import net.bauxite_ltk.tfc_trihydrate.gui.TFCTHMenuTypes;
import net.bauxite_ltk.tfc_trihydrate.gui.menus.BallMillScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.menus.FlotationCellScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.menus.HydrocycloneScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.menus.ThickenerScreen;
import net.bauxite_ltk.tfc_trihydrate.render.BallMillRender;
import net.bauxite_ltk.tfc_trihydrate.render.FlotationCellRender;
import net.bauxite_ltk.tfc_trihydrate.render.TFCTHDynamicModel;
import net.bauxite_ltk.tfc_trihydrate.render.ThickenerRender;
import net.bauxite_ltk.tfc_trihydrate.tag.ModTags;
import net.dries007.tfc.TerraFirmaCraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.model.DynamicFluidContainerModel;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Objects;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TFCTrihydrate.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TFCTrihydrateClient {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {


        MenuScreens.register(TFCTHMenuTypes.BALL_MILL.getType(), BallMillScreen::new);
        MenuScreens.register(TFCTHMenuTypes.FLOTATION_CELL.getType(), FlotationCellScreen::new);
        MenuScreens.register(TFCTHMenuTypes.HYDROCYCLONE.getType(), HydrocycloneScreen::new);
        MenuScreens.register(TFCTHMenuTypes.THICKENER.getType(), ThickenerScreen::new);
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event){
        for (Fluid fluid : BuiltInRegistries.FLUID)
        {
            if (Objects.requireNonNull(BuiltInRegistries.FLUID.getKey(fluid)).getNamespace().equals(TFCTrihydrate.MODID))
            {
                event.register(new DynamicFluidContainerModel.Colors(), fluid.getBucket());
            }
        }
    }


    @SubscribeEvent
    public static void registerModelLoaders(ModelEvent.RegisterGeometryLoaders event)
    {
        BallMillRender.BARREL = new TFCTHDynamicModel(BallMillRender.NAME);
        FlotationCellRender.BLADE = new TFCTHDynamicModel(FlotationCellRender.NAME);
        ThickenerRender.AGITATOR = new TFCTHDynamicModel(ThickenerRender.NAME);


    }


    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers event)
    {
        registerBERenderNoContext(event, TFCTHMultiblockLogic.BALL_MILL.masterBE(), BallMillRender::new);
        registerBERenderNoContext(event, TFCTHMultiblockLogic.FLOTATION_CELL.masterBE(), FlotationCellRender::new);
        registerBERenderNoContext(event, TFCTHMultiblockLogic.THICKENER.masterBE(), ThickenerRender::new);
    }

    private static <T extends BlockEntity>
    void registerBERenderNoContext(
            EntityRenderersEvent.RegisterRenderers event, Supplier<BlockEntityType<? extends T>> type, Supplier<BlockEntityRenderer<T>> render
    )
    {
        TFCTrihydrateClient.registerBERenderNoContext(event, type.get(), render);
    }

    private static <T extends BlockEntity>
    void registerBERenderNoContext(
            EntityRenderersEvent.RegisterRenderers event, BlockEntityType<? extends T> type, Supplier<BlockEntityRenderer<T>> render
    )
    {
        event.registerBlockEntityRenderer(type, $ -> render.get());
    }

}
