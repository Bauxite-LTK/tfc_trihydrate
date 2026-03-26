package net.bauxite_ltk.tfc_trihydrate.container;

import net.bauxite_ltk.tfc_trihydrate.component.mold.AdvancedVessel;
import net.bauxite_ltk.tfc_trihydrate.item.AdvancedVesselItem;
import net.dries007.tfc.common.component.food.FoodCapability;
import net.dries007.tfc.common.component.food.FoodTraits;
import net.dries007.tfc.common.component.heat.HeatCapability;
import net.dries007.tfc.common.component.heat.HeatComponent;
import net.dries007.tfc.common.container.ItemStackContainer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

public class AdvancedVesselInventoryContainer extends ItemStackContainer {

    public static AdvancedVesselInventoryContainer create(ItemStack stack, InteractionHand hand, int slot, Inventory playerInv, int windowId)
    {
        return new AdvancedVesselInventoryContainer(stack, hand, slot, playerInv, windowId).init(playerInv);
    }

    @Nullable
    private final AdvancedVessel vessel;

    private AdvancedVesselInventoryContainer(ItemStack stack, InteractionHand hand, int slot, Inventory playerInv, int windowId)
    {
        super(TFCTHContainerTypes.ADVANCED_VESSEL_INVENTORY.get(), windowId, playerInv, stack, hand, slot);

        vessel = AdvancedVessel.get(stack);
    }

    @Override
    public boolean stillValid(Player player)
    {
        return vessel != null && vessel.isInventory() && super.stillValid(player);
    }


    @Override
    public void setCarried(ItemStack stack)
    {
        if (vessel != null) vessel.onTake(stack);
        super.setCarried(stack);
    }

    @Override
    protected boolean moveStack(ItemStack stack, int slotIndex)
    {
        return switch (typeOf(slotIndex))
        {
            case MAIN_INVENTORY, HOTBAR -> !moveItemStackTo(stack, 0, AdvancedVesselItem.SLOTS, false);
            case CONTAINER ->
            {
                // Remove the preserved trait, pre-emptively, if the stack were to be transferred out. If any remains, then re-apply it.
                FoodCapability.removeTrait(stack, FoodTraits.PRESERVED);
                boolean result = !moveItemStackTo(stack, containerSlots, slots.size(), false);
                if (result)
                {
                    FoodCapability.applyTrait(stack, FoodTraits.PRESERVED);
                }
                yield result;
            }
        };
    }


    @Override
    protected void addContainerSlots()
    {
        if (vessel != null)
        {
            // ItemHandlerCopySlot does not call extractItem when Slot#remove is called (e.g. when Q is pressed while hovering a slot)
            // remove is marked final in said class, so we're giving up slot item caching for the more correct implementation for vessels
            addSlot(new SlotItemHandler(vessel, 0, 62, 17));
            addSlot(new SlotItemHandler(vessel, 1, 80, 17));
            addSlot(new SlotItemHandler(vessel, 2, 98, 17));
            addSlot(new SlotItemHandler(vessel, 3, 62, 35));
            addSlot(new SlotItemHandler(vessel, 4, 80, 35));
            addSlot(new SlotItemHandler(vessel, 5, 98, 35));
            addSlot(new SlotItemHandler(vessel, 6, 62, 53));
            addSlot(new SlotItemHandler(vessel, 7, 80, 53));
            addSlot(new SlotItemHandler(vessel, 8, 98, 53));
        }
    }
}
