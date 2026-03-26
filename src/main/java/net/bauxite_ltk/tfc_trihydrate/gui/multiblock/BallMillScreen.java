package net.bauxite_ltk.tfc_trihydrate.gui.multiblock;

import blusunrize.immersiveengineering.client.gui.IEContainerScreen;
import blusunrize.immersiveengineering.client.gui.info.EnergyInfoArea;
import blusunrize.immersiveengineering.client.gui.info.FluidInfoArea;
import blusunrize.immersiveengineering.client.gui.info.InfoArea;
import com.google.common.collect.ImmutableList;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;
import java.util.List;

public class BallMillScreen extends IEContainerScreen<BallMillMenu> {
    private static final ResourceLocation TEXTURE = makeTextureLocation("ball_mill");
    private static final ResourceLocation TANK = ResourceLocation.fromNamespaceAndPath(
            TFCTrihydrate.MODID,"ball_mill/tank_overlay");

    public BallMillScreen(BallMillMenu container, Inventory inventoryPlayer, Component title) {
        super(container, inventoryPlayer, title, TEXTURE);
    }

    @Nonnull
    @Override
    protected List<InfoArea> makeInfoAreas()
    {
        return ImmutableList.of(
                new FluidInfoArea(menu.tanks.input(), new Rect2i(leftPos+10, topPos+12, 16, 47), 20, 51, TANK),
                new FluidInfoArea(menu.tanks.output(), new Rect2i(leftPos+118, topPos+12, 16, 47), 20, 51, TANK),
                new EnergyInfoArea(leftPos+158, topPos+12, menu.energy)
        );
    }

    public static ResourceLocation makeTextureLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID, "textures/gui/"+name+".png");
    }
}
