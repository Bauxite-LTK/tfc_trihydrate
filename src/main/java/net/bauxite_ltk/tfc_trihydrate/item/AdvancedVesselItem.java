package net.bauxite_ltk.tfc_trihydrate.item;

import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.capabilities.TFCTHItemCapabilities;
import net.bauxite_ltk.tfc_trihydrate.component.TFCTHComponents;
import net.bauxite_ltk.tfc_trihydrate.component.mold.AdvancedVessel;
import net.bauxite_ltk.tfc_trihydrate.component.mold.AdvancedVesselComponent;
import net.bauxite_ltk.tfc_trihydrate.container.TFCTHContainerProviders;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.blocks.TooltipBlock;
import net.dries007.tfc.common.component.TFCComponents;
import net.dries007.tfc.common.component.heat.HeatCapability;
import net.dries007.tfc.common.component.heat.HeatComponent;
import net.dries007.tfc.common.component.heat.IHeat;
import net.dries007.tfc.common.component.mold.VesselComponent;
import net.dries007.tfc.common.component.size.ItemSizeManager;
import net.dries007.tfc.common.component.size.Size;
import net.dries007.tfc.common.container.TFCContainerProviders;
import net.dries007.tfc.common.items.TFCItems;
import net.dries007.tfc.config.TFCConfig;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.data.FluidHeat;
import net.dries007.tfc.util.tooltip.Tooltips;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class AdvancedVesselItem extends Item {
    public static final int SLOTS = 9;

    public AdvancedVesselItem(Properties properties) {
        super(properties
                .component(TFCTHComponents.ADVANCED_VESSEL, AdvancedVesselComponent.EMPTY)
                .component(TFCComponents.HEAT, HeatComponent.of(HeatCapability.POTTERY_HEAT_CAPACITY))
        );

    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        final AdvancedVessel advancedVessel = AdvancedVessel.get(stack);
        if (advancedVessel != null) {
            for(ItemStack itemStack : advancedVessel.contents()){
                IHeat inputHeat =  HeatCapability.get(itemStack);
                if(inputHeat!=null && inputHeat.getTemperature()!=0){
                    HeatCapability.addTemp(inputHeat,inputHeat.getTemperature()+1,0.9f);
                }
            }
        }
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        final AdvancedVessel advancedVessel = AdvancedVessel.get(stack);
        if (advancedVessel != null) {
            for(ItemStack itemStack : advancedVessel.contents()){
                IHeat inputHeat =  HeatCapability.get(itemStack);
                if(inputHeat!=null && inputHeat.getTemperature()!=0){
                    HeatCapability.addTemp(inputHeat,inputHeat.getTemperature()+1,0.9f);
                }
            }
        }
        return super.onEntityItemUpdate(stack, entity);
    }

    private final AdvancedVessel.ContainerInfo containerInfo = new AdvancedVessel.ContainerInfo() {
        @Override
        public boolean canContainFluid(Fluid input)
        {
            return FluidHeat.get(input) != null;
        }

        @Override
        public int fluidCapacity()
        {
            return TFCConfig.SERVER.smallVesselCapacity.get();
        }

        @Override
        public boolean canContainItem(ItemStack stack)
        {
            return ItemSizeManager.get(stack).getSize(stack).isEqualOrSmallerThan(Size.LARGE)
                    && stack.getTags().noneMatch((itemTagKey -> itemTagKey.equals(TFCTags.Items.VESSELS))
            );
        }

        @Override
        public int slotCapacity()
        {
            return 4;
        }
    };

    public AdvancedVessel.ContainerInfo containerInfo()
    {
        return containerInfo;
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction action, Player player)
    {
        final AdvancedVessel advancedVessel = AdvancedVessel.get(stack);
        if (advancedVessel != null &&
                advancedVessel.isInventory() &&
                TFCConfig.SERVER.enableSmallVesselInventoryInteraction.get() &&
                !player.isCreative() &&
                action == ClickAction.SECONDARY)
        {
            for (int i = SLOTS - 1; i >= 0; i--)
            {
                final ItemStack simulate = advancedVessel.extractItem(i, 64, true);
                if (!simulate.isEmpty())
                {
                    final ItemStack extracted = advancedVessel.extractItem(i, 64, false);
                    final ItemStack leftover = slot.safeInsert(extracted);
                    if (!leftover.isEmpty())
                    {
                        // We can't simulate the `safeInsert` above, so we have to revert whatever leftover was obtained here
                        // Insert should be safe, because the previous extract extracted a full stack, and so should leave the slot empty
                        advancedVessel.insertItem(i, leftover, false);

                        // Update slots, if we're in a crafting menu, to update output slots. See #2378
                        player.containerMenu.slotsChanged(slot.container);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack carried, Slot slot, ClickAction action, Player player, SlotAccess carriedSlot)
    {
        final AdvancedVessel advancedVessel = AdvancedVessel.get(stack);
        if (advancedVessel != null &&
                advancedVessel.isInventory() &&
                TFCConfig.SERVER.enableSmallVesselInventoryInteraction.get() &&
                !player.isCreative() &&
                action == ClickAction.SECONDARY &&
                slot.allowModification(player))
        {
            if (!carried.isEmpty())
            {
                boolean slotsChanged = false;
                final ItemStack oldCarried = carried.copy();
                for (int i = 0; i < SLOTS; i++)
                {
                    final ItemStack leftover = advancedVessel.insertItem(i, carried, false);
                    if (leftover.getCount() != oldCarried.getCount() || slotsChanged)
                    {
                        slotsChanged = true;
                        carriedSlot.set(leftover);
                        carried = leftover;
                    }
                    if (carried.isEmpty())
                    {
                        break;
                    }
                }
                if (slotsChanged)
                {
                    // Update slots, if we're in a crafting menu, to update output slots. See #2378
                    player.containerMenu.slotsChanged(slot.container);
                    return true;
                }
            }
            else
            {
                for (int i = SLOTS - 1; i >= 0; i--)
                {
                    final ItemStack current = advancedVessel.getStackInSlot(i);
                    if (!current.isEmpty())
                    {
                        carriedSlot.set(advancedVessel.extractItem(i, 64, false));

                        // Update slots, if we're in a crafting menu, to update output slots. See #2378
                        player.containerMenu.slotsChanged(slot.container);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand)
    {
        TFCTrihydrate.LOGGER.info("Advanced Item Use");
        final ItemStack stack = player.getItemInHand(hand);
        if (!player.isShiftKeyDown() && !level.isClientSide() && player instanceof ServerPlayer serverPlayer)
        {
            TFCTrihydrate.LOGGER.info("Advanced Vessel pass");
            final AdvancedVessel advancedVessel = AdvancedVessel.get(stack);
            if (advancedVessel != null)
            {
                TFCTrihydrate.LOGGER.info("Advanced Vessel is not null");
                if (advancedVessel.isInventory())
                {
                    if (advancedVessel.getTemperature() > 0)
                    {
                        player.displayClientMessage(Component.translatable("tfc.tooltip.small_vessel.inventory_too_hot"), true);
                    }
                    else
                    {
                        TFCTrihydrate.LOGGER.info("Advanced Vessel try to open screen");
                        TFCTHContainerProviders.ADVANCED_VESSEL.openScreen(serverPlayer, hand);
                    }
                }
                else if (advancedVessel.isMolten())
                {
                    TFCContainerProviders.MOLD_LIKE_ALLOY.openScreen(serverPlayer, hand);
                }
                else if (advancedVessel.getTemperature() > 0 && !advancedVessel.hasFluidContent())
                {
                    player.displayClientMessage(Component.translatable("tfc.tooltip.small_vessel.inventory_too_hot"), true);
                }
                else
                {
                    player.displayClientMessage(Component.translatable("tfc.tooltip.small_vessel.alloy_solid"), true);
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag)
    {
        final @Nullable AdvancedVessel advancedVessel = AdvancedVessel.get(stack);
        if (advancedVessel != null && !advancedVessel.isEmpty()) // Only show the 'contents' label if we actually have contents
        {
            if (advancedVessel.isInventory())
            {
                if (!TFCConfig.CLIENT.displayItemContentsAsImages.get())
                {
                    tooltip.add(Component.translatable("tfc.tooltip.small_vessel.contents").withStyle(ChatFormatting.DARK_GREEN));
                    Helpers.addInventoryTooltipInfo(advancedVessel.contents(), tooltip);
                }
            }
            else
            {
                tooltip.add(Component.translatable("tfc.tooltip.small_vessel.contents").withStyle(ChatFormatting.DARK_GREEN));
                tooltip.add(Tooltips.fluidUnitsAndCapacityOf(advancedVessel.getFluidInTank(0).getHoverName(), advancedVessel.getFluidInTank(0).getAmount(), containerInfo.fluidCapacity())
                        .append(Tooltips.moltenOrSolid(advancedVessel.isMolten())));
                if (!Helpers.isEmpty(advancedVessel.contents()))
                {
                    tooltip.add(Component.translatable("tfc.tooltip.small_vessel.still_has_unmelted_items").withStyle(ChatFormatting.RED));
                }
            }
        }
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack)
    {
        if (TFCConfig.CLIENT.displayItemContentsAsImages.get())
        {
            final AdvancedVessel advancedVessel = AdvancedVessel.get(stack);
            if (advancedVessel != null && advancedVessel.isInventory())
            {
                return TooltipBlock.buildInventoryTooltip(advancedVessel.contents(), 3, 3);
            }
        }
        return Optional.empty();
    }

    @Override
    public int getMaxStackSize(ItemStack stack)
    {
        return 1;
    }
}
