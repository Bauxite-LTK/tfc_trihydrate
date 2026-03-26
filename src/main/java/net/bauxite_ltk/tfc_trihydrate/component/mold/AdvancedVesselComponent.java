package net.bauxite_ltk.tfc_trihydrate.component.mold;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.dries007.tfc.common.component.CachedMut;
import net.dries007.tfc.common.component.item.ItemComponent;

import net.dries007.tfc.common.recipes.HeatingRecipe;
import net.dries007.tfc.util.FluidAlloy;
import net.dries007.tfc.util.Helpers;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record AdvancedVesselComponent(
        List<ItemStack> itemContent,
        List<CachedMut<HeatingRecipe>> cachedRecipes,
        FluidAlloy fluidContent
) {
    public static final int SLOTS = 9;
    public static final AdvancedVesselComponent EMPTY = new AdvancedVesselComponent(
            Collections.nCopies(SLOTS, ItemStack.EMPTY),
            Collections.nCopies(SLOTS, CachedMut.empty()),
            FluidAlloy.empty()
    );

    public static final Codec<AdvancedVesselComponent> CODEC = RecordCodecBuilder.create(i -> i.group(
            ItemStack.OPTIONAL_CODEC.listOf(SLOTS, SLOTS).fieldOf("items").forGetter(c -> c.itemContent),
            FluidAlloy.CODEC.fieldOf("fluid").forGetter(c -> c.fluidContent)
    ).apply(i, AdvancedVesselComponent::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, AdvancedVesselComponent> STREAM_CODEC = StreamCodec.composite(
            ItemStack.OPTIONAL_STREAM_CODEC.apply(ByteBufCodecs.list(SLOTS)), c -> c.itemContent,
            FluidAlloy.STREAM_CODEC, c -> c.fluidContent,
            AdvancedVesselComponent::new
    );

    private AdvancedVesselComponent(List<ItemStack> itemContent, FluidAlloy fluidContent)
    {
        this(itemContent, Helpers.immutableCopies(SLOTS, CachedMut::unloaded), fluidContent);
    }

    AdvancedVesselComponent copyMut()
    {
        return new AdvancedVesselComponent(new ArrayList<>(itemContent), new ArrayList<>(cachedRecipes), fluidContent.copy());
    }

    AdvancedVesselComponent with(int slot, ItemStack stack)
    {
        return new AdvancedVesselComponent(
                Helpers.immutableSwap(itemContent, stack, slot), // Copy and swap in the target slot
                Helpers.immutableSwap(cachedRecipes, CachedMut.unloaded(), slot), // Copy and invalidate in the target slot
                fluidContent // No need for a copy, as we aren't invalidating anything
        );
    }

    AdvancedVesselComponent with(FluidAlloy fluidContent)
    {
        return new AdvancedVesselComponent(itemContent, cachedRecipes, fluidContent);
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj == this || (obj instanceof AdvancedVesselComponent that
                && ItemComponent.equals(this.itemContent, that.itemContent)
                && fluidContent.equals(that.fluidContent));
    }

    @Override
    public int hashCode()
    {
        return ItemComponent.hashCode(itemContent) + 31 * fluidContent.hashCode();
    }

    @Override
    public String toString()
    {
        return "Vessel[itemContent=%s,fluidContent=%s]".formatted(itemContent, fluidContent);
    }

}
