package net.bauxite_ltk.tfc_trihydrate.gui.menus;

import blusunrize.immersiveengineering.client.gui.IEContainerScreen;
import blusunrize.immersiveengineering.client.gui.info.EnergyInfoArea;
import blusunrize.immersiveengineering.client.gui.info.FluidInfoArea;
import blusunrize.immersiveengineering.client.gui.info.InfoArea;
import com.google.common.collect.ImmutableList;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.gui.components.SeparateMultiTankArea;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;
import java.util.List;

public class ThickenerScreen extends IEContainerScreen<ThickenerMenu> {
    private static final ResourceLocation TEXTURE = makeTextureLocation("thickener");

    public ThickenerScreen(ThickenerMenu container, Inventory inventoryPlayer, Component title) {
        super(container, inventoryPlayer, title, TEXTURE);
    }

    @Nonnull
    @Override
    protected List<InfoArea> makeInfoAreas()
    {
        return ImmutableList.of(
                new FluidInfoArea(menu.tanks.input(), new Rect2i(leftPos+14, topPos+18, 16, 47),177,31, 20, 51, TEXTURE),
                new FluidInfoArea(menu.tanks.output(), new Rect2i(leftPos+131, topPos+12, 16, 25),177,0, 20, 29, TEXTURE),
                new SeparateMultiTankArea(List.of(menu.tanks.input(),menu.tanks.output()), new Rect2i(leftPos+43, topPos+24, 70, 24),177,83, 70, 24, TEXTURE),
                new EnergyInfoArea(leftPos+158, topPos+12, menu.energy)
        );
    }

    public static ResourceLocation makeTextureLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID, "textures/gui/"+name+".png");
    }

}
