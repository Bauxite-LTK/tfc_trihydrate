package net.bauxite_ltk.tfc_trihydrate.gui.multiblock;

import blusunrize.immersiveengineering.client.gui.IEContainerScreen;
import blusunrize.immersiveengineering.client.gui.info.EnergyInfoArea;
import blusunrize.immersiveengineering.client.gui.info.FluidInfoArea;
import blusunrize.immersiveengineering.client.gui.info.InfoArea;
import com.google.common.collect.ImmutableList;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;
import java.util.List;

public class HydrocycloneScreen extends IEContainerScreen<HydrocycloneMenu> {
    private static final ResourceLocation TEXTURE = makeTextureLocation("hydrocyclone");
    private static final ResourceLocation TANK = ResourceLocation.fromNamespaceAndPath(
            TFCTrihydrate.MODID,"hydrocyclone/tank_overlay");
    private static final ResourceLocation SMALL_TANK = ResourceLocation.fromNamespaceAndPath(
            TFCTrihydrate.MODID,"hydrocyclone/small_tank_overlay");
    private static final ResourceLocation PROGRESS = ResourceLocation.fromNamespaceAndPath(
            TFCTrihydrate.MODID,"hydrocyclone/progress");

    public HydrocycloneScreen(HydrocycloneMenu container, Inventory inventoryPlayer, Component title) {
        super(container, inventoryPlayer, title, TEXTURE);
    }

    @Nonnull
    @Override
    protected List<InfoArea> makeInfoAreas()
    {
        return ImmutableList.of(
                new FluidInfoArea(menu.tanks.input(), new Rect2i(leftPos+17, topPos+17, 16, 47), 20, 51, TANK),
                new FluidInfoArea(menu.tanks.output(), new Rect2i(leftPos+121, topPos+12, 16, 25), 20, 29, SMALL_TANK),
                new EnergyInfoArea(leftPos+152, topPos+17, menu.energy)
        );
    }

    public static ResourceLocation makeTextureLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID, "textures/gui/"+name+".png");
    }

    @Override
    protected void drawContainerBackgroundPre(@Nonnull GuiGraphics graphics, float f, int mx, int my)
    {
        float process = menu.guiProgress.get();
        TFCTrihydrate.LOGGER.info("progress:{}", process);
        if(process > 0)
        {
            int w = (int)Math.max(1, process*50);
            graphics.blitSprite(PROGRESS, 31, 50, 0, 0, leftPos+63, topPos+17, 31, w);
        }
    }
}
