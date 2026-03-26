package net.bauxite_ltk.tfc_trihydrate.gui.item;

import net.bauxite_ltk.tfc_trihydrate.container.AdvancedVesselInventoryContainer;
import net.dries007.tfc.client.screen.TFCContainerScreen;
import net.dries007.tfc.common.container.SmallVesselInventoryContainer;
import net.dries007.tfc.util.Helpers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AdvancedVesselInventoryScreen extends TFCContainerScreen<AdvancedVesselInventoryContainer> {

    public static final ResourceLocation ADVANCED_VESSEL_INVENTORY = ResourceLocation.fromNamespaceAndPath("tfc_trihydrate","textures/gui/advanced_vessel.png");
    public AdvancedVesselInventoryScreen(AdvancedVesselInventoryContainer container, Inventory playerInventory, Component name) {
        super(container, playerInventory, name, ADVANCED_VESSEL_INVENTORY);
    }
}
