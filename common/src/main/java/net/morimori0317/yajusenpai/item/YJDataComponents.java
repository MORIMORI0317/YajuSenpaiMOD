package net.morimori0317.yajusenpai.item;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.Unit;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class YJDataComponents {
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(YajuSenpai.MODID, Registries.DATA_COMPONENT_TYPE);

    public static final RegistrySupplier<DataComponentType<Unit>> FUTOI_SEA_CHICKEN = register("futoi_sea_chicken", () ->
            (builder) -> builder.persistent(Codec.unit(Unit.INSTANCE)).networkSynchronized(StreamCodec.unit(Unit.INSTANCE)));
    public static final RegistrySupplier<DataComponentType<Integer>> KYN_COUNT = register("kyn_count", () ->
            (builder) -> builder.persistent(ExtraCodecs.intRange(0, ServerHandler.KYN_ATUI_SOUNDS.length)).networkSynchronized(ByteBufCodecs.VAR_INT));


    private static <T> RegistrySupplier<DataComponentType<T>> register(String name, Supplier<UnaryOperator<DataComponentType.Builder<T>>> operator) {
        return DATA_COMPONENTS.register(name, () -> operator.get().apply(DataComponentType.builder()).build());
    }

    public static void init() {
        DATA_COMPONENTS.register();
    }
}
