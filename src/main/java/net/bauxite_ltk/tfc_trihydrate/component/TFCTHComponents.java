package net.bauxite_ltk.tfc_trihydrate.component;

import com.mojang.serialization.Codec;
import net.bauxite_ltk.tfc_trihydrate.TFCTrihydrate;
import net.bauxite_ltk.tfc_trihydrate.component.mold.AdvancedVesselComponent;
import net.dries007.tfc.util.registry.RegistryHolder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class TFCTHComponents {
    public static final DeferredRegister<DataComponentType<?>> COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, TFCTrihydrate.MODID);

    public static final TFCTHComponents.Id<AdvancedVesselComponent> ADVANCED_VESSEL = register("advanced_vessel", AdvancedVesselComponent.CODEC, AdvancedVesselComponent.STREAM_CODEC);


    private static <T> TFCTHComponents.Id<T> register(String name, Codec<T> codec, StreamCodec<? super RegistryFriendlyByteBuf, T> streamCodec)
    {
        return new TFCTHComponents.Id<>(COMPONENTS.register(name, () -> new DataComponentType.Builder<T>()
                .persistent(codec)
                .networkSynchronized(streamCodec)
                .build()));
    }

    public record Id<T>(DeferredHolder<DataComponentType<?>, DataComponentType<T>> holder)
            implements RegistryHolder<DataComponentType<?>, DataComponentType<T>> {}

    public static void init(IEventBus modEventBus){
        COMPONENTS.register(modEventBus);
    }
}
