package net.bauxite_ltk.tfc_trihydrate.event;

import net.bauxite_ltk.tfc_trihydrate.Config;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.block.multiblock.TFCTHMultiblockLogic;
import net.bauxite_ltk.tfc_trihydrate.container.TFCTHContainerProviders;
import net.bauxite_ltk.tfc_trihydrate.container.TFCTHContainerTypes;
import net.bauxite_ltk.tfc_trihydrate.effect.ModEffects;
import net.bauxite_ltk.tfc_trihydrate.gui.*;
import net.bauxite_ltk.tfc_trihydrate.gui.item.AdvancedVesselInventoryScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.multiblock.BallMillScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.multiblock.FlotationCellScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.multiblock.HydrocycloneScreen;
import net.bauxite_ltk.tfc_trihydrate.gui.multiblock.ThickenerScreen;
import net.bauxite_ltk.tfc_trihydrate.render.BallMillRender;
import net.bauxite_ltk.tfc_trihydrate.render.FlotationCellRender;
import net.bauxite_ltk.tfc_trihydrate.render.TFCTHDynamicModel;
import net.bauxite_ltk.tfc_trihydrate.render.ThickenerRender;
import net.dries007.tfc.client.screen.SmallVesselInventoryScreen;
import net.dries007.tfc.common.container.TFCContainerTypes;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.AdvancementEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.function.Supplier;

@EventBusSubscriber(modid = TFCTrihydrate.MODID, value = Dist.CLIENT)
public class ModEvents {

    @SubscribeEvent
    public static void addFearEvent(PlayerTickEvent.Post playerTickEvent){
        Player player = playerTickEvent.getEntity();
        int y = playerTickEvent.getEntity().getOnPos().getY();
        boolean isInIronAge = false;
        if(player instanceof ServerPlayer serverPlayer){
            AdvancementHolder iron_age_advancement = player.getServer().getAdvancements().get(
                    ResourceLocation.fromNamespaceAndPath("tfc","story/iron_age")
            );
            if(iron_age_advancement!=null){
                isInIronAge = serverPlayer.getAdvancements().getOrStartProgress(iron_age_advancement).isDone();
            }
            else{
                throw new RuntimeException("advancement not exist");
            }
            if(y < -10){
                if(!isInIronAge){
                    player.addEffect(new MobEffectInstance(ModEffects.FEAR_EFFECT,200,1));
                    player.displayClientMessage(Component.translatable("tfc_trihydrate.message.fear2"),true);
                }
                else {
                    player.displayClientMessage(Component.translatable("tfc_trihydrate.message.fear"),true);
                }
            }
            else if(y < 30){
                if(!isInIronAge){
                    player.addEffect(new MobEffectInstance(ModEffects.FEAR_EFFECT,200, 0));
                    player.displayClientMessage(Component.translatable("tfc_trihydrate.message.fear"),true);
                }
                else{
                    //player.displayClientMessage(Component.translatable("tfc_trihydrate.message.fearless"),true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void resetJavalinAttackRange(PlayerTickEvent.Post playerTickEvent){
        Player player = playerTickEvent.getEntity();
        ItemStack holdingItem = player.getMainHandItem();
        if(holdingItem.is(Tags.Items.TOOLS_SPEAR)){
            player.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).addOrUpdateTransientModifier(
                    new AttributeModifier(
                            ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID,"spear_range"),
                            0.5,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                    )
            );
        }
        else{
            player.getAttribute(Attributes.ENTITY_INTERACTION_RANGE).removeModifier(ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID,"spear_range"));
        }
    }

    @SubscribeEvent
    public static void detectIronAgeAdvancement(AdvancementEvent.AdvancementEarnEvent event){
        AdvancementHolder advancement = event.getAdvancement();
        if(advancement.id().equals(ResourceLocation.fromNamespaceAndPath("tfc","story/iron_age"))){
            event.getEntity().sendSystemMessage(Component.translatable("tfc_trihydrate.message.fearless"));
        }
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
        ModEvents.registerBERenderNoContext(event, type.get(), render);
    }

    private static <T extends BlockEntity>
    void registerBERenderNoContext(
            EntityRenderersEvent.RegisterRenderers event, BlockEntityType<? extends T> type, Supplier<BlockEntityRenderer<T>> render
    )
    {
        event.registerBlockEntityRenderer(type, $ -> render.get());
    }

    @SubscribeEvent
    public static void registerModelLoaders(ModelEvent.RegisterGeometryLoaders event)
    {
        BallMillRender.BARREL = new TFCTHDynamicModel(BallMillRender.NAME);
        FlotationCellRender.BLADE = new TFCTHDynamicModel(FlotationCellRender.NAME);
        ThickenerRender.AGITATOR = new TFCTHDynamicModel(ThickenerRender.NAME);

    }

    @SubscribeEvent
    public static void registerContainersAndScreens(RegisterMenuScreensEvent event)
    {
        event.register(TFCTHMenuTypes.BALL_MILL.getType(), BallMillScreen::new);
        event.register(TFCTHMenuTypes.FLOTATION_CELL.getType(), FlotationCellScreen::new);
        event.register(TFCTHMenuTypes.HYDROCYCLONE.getType(), HydrocycloneScreen::new);
        event.register(TFCTHMenuTypes.THICKENER.getType(), ThickenerScreen::new);
        event.register(TFCTHContainerTypes.ADVANCED_VESSEL_INVENTORY.get(), AdvancedVesselInventoryScreen::new);

    }

    @SubscribeEvent
    public static void onConfigReloading(ModConfigEvent.Reloading event){
        Config.MACHINES.populateAPI();
    }
}
