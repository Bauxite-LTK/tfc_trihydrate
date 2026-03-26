package net.bauxite_ltk.tfc_trihydrate.container;

import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.dries007.tfc.common.container.ItemStackContainer;
import net.dries007.tfc.common.container.SmallVesselInventoryContainer;
import net.dries007.tfc.common.container.TFCContainerTypes;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class TFCTHContainerTypes {
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(Registries.MENU, TFCTrihydrate.MODID);

    public static final TFCContainerTypes.Id<AdvancedVesselInventoryContainer> ADVANCED_VESSEL_INVENTORY = registerItem("advanced_vessel_inventory", AdvancedVesselInventoryContainer::create);


    private static <C extends ItemStackContainer> TFCContainerTypes.Id<C> registerItem(String name, ItemStackContainer.Factory<C> factory)
    {
        return new TFCContainerTypes.Id<>(RegistrationHelpers.registerItemStackContainer(CONTAINERS, name, factory));
    }

    public static void init(IEventBus modEventBus){
        CONTAINERS.register(modEventBus);
    }
}
