package net.bauxite_ltk.tfc_trihydrate.event;

import net.bauxite_ltk.tfc_trihydrate.tag.ModTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "tfc_trihydrate", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TFCTrihydrateEvents {


    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {

        Player player = event.getEntity();
        ItemStack crafting = event.getCrafting();
        Container container = event.getInventory();
        AbstractContainerMenu menu = player.containerMenu;

        ItemStack itemStack = event.getCrafting();
        if(itemStack.getTags().anyMatch(tag -> tag.equals(ModTags.Items.CRYSTAL_CHUNKS))){
            player.playSound(SoundEvents.SHROOMLIGHT_BREAK);
            player.playSound(SoundEvents.AMETHYST_BLOCK_BREAK, 0.5f,1f);
            player.playSound(SoundEvents.AMETHYST_BLOCK_BREAK,0.5f,1f);
            player.playSound(SoundEvents.AMETHYST_BLOCK_BREAK,0.5f,1f);
        }
        else if(itemStack.getTags().anyMatch(tag -> tag.equals(ModTags.Items.ORE_CHUNKS))){
            player.playSound(SoundEvents.SHROOMLIGHT_BREAK);
        }
        else if(itemStack.getTags().anyMatch(tag -> tag.equals(ModTags.Items.POOR_ORE_CHUNKS))) {
            player.playSound(SoundEvents.NETHER_ORE_BREAK);
        }
    }
}
