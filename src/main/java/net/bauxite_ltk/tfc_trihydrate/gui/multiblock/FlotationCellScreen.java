package net.bauxite_ltk.tfc_trihydrate.gui.multiblock;

import blusunrize.immersiveengineering.client.gui.IEContainerScreen;
import blusunrize.immersiveengineering.client.gui.info.EnergyInfoArea;
import blusunrize.immersiveengineering.client.gui.info.FluidInfoArea;
import blusunrize.immersiveengineering.client.gui.info.InfoArea;
import com.google.common.collect.ImmutableList;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.gui.info.FlotationCellAddFluidInfoArea;
import net.bauxite_ltk.tfc_trihydrate.gui.info.SeparateMultiTankArea;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;
import java.util.List;

public class FlotationCellScreen extends IEContainerScreen<FlotationCellMenu> {
    private static final ResourceLocation TEXTURE = makeTextureLocation("flotation_cell");
    private static final ResourceLocation TANK = ResourceLocation.fromNamespaceAndPath(
            TFCTrihydrate.MODID,"flotation_cell/tank_overlay");
    private static final ResourceLocation SMALL_TANK = ResourceLocation.fromNamespaceAndPath(
            TFCTrihydrate.MODID,"flotation_cell/small_tank_overlay");
    private static final ResourceLocation BIG_TANK = ResourceLocation.fromNamespaceAndPath(
            TFCTrihydrate.MODID,"flotation_cell/big_tank_overlay");
    public static final ResourceLocation ADD_TANK = ResourceLocation.fromNamespaceAndPath(
            TFCTrihydrate.MODID,"flotation_cell/add_tank_overlay");

    public FlotationCellScreen(FlotationCellMenu container, Inventory inventoryPlayer, Component title) {
        super(container, inventoryPlayer, title, TEXTURE);
    }

    @Nonnull
    @Override
    protected List<InfoArea> makeInfoAreas()
    {
        return ImmutableList.of(
                new FluidInfoArea(menu.tanks.inputOre(), new Rect2i(leftPos+10, topPos+12, 16, 47), 20, 51, TANK),
                new SeparateMultiTankArea(
                        List.of(menu.tanks.outputTailing(),
                                menu.tanks.inputOre(),
                                menu.tanks.outputConcentrate()),
                        new Rect2i(leftPos+43, topPos+22, 70, 47),
                        70, 51, BIG_TANK),
                new FlotationCellAddFluidInfoArea(menu.tanks.inputAdd(), new Rect2i(leftPos+76, topPos+17, 4, 34), -14, -6,32,58, ADD_TANK),
                new FluidInfoArea(menu.tanks.overflow(), new Rect2i(leftPos+131, topPos+12, 16, 25), 20, 29, SMALL_TANK),
                new FluidInfoArea(menu.tanks.outputTailing(), new Rect2i(leftPos+131, topPos+44, 16, 25), 20, 29, SMALL_TANK),
                new EnergyInfoArea(leftPos+158, topPos+12, menu.energy)
        );
    }

    public static ResourceLocation makeTextureLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TFCTrihydrate.MODID, "textures/gui/"+name+".png");
    }
}
