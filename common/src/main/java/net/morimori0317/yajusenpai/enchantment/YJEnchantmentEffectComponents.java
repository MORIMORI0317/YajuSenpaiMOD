package net.morimori0317.yajusenpai.enchantment;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.Unit;
import net.morimori0317.yajusenpai.YajuSenpai;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public final class YJEnchantmentEffectComponents {
    private static final DeferredRegister<DataComponentType<?>> ENCHANTMENT_EFFECT_COMPONENTS = DeferredRegister.create(YajuSenpai.MODID, Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE);
    public static final RegistrySupplier<DataComponentType<Unit>> KATYOU_BROKEN = register("katyou_broken", () -> (builder) -> builder.persistent(Unit.CODEC));
    public static final RegistrySupplier<DataComponentType<Unit>> GABA_ANA_DADDY = register("gaba_ana_daddy", () -> (builder) -> builder.persistent(Unit.CODEC));
    public static final RegistrySupplier<DataComponentType<Unit>> KYN = register("kyn", () -> (builder) -> builder.persistent(Unit.CODEC));

    private static <T> RegistrySupplier<DataComponentType<T>> register(String name, Supplier<UnaryOperator<DataComponentType.Builder<T>>> operator) {
        return ENCHANTMENT_EFFECT_COMPONENTS.register(name, () -> operator.get().apply(DataComponentType.builder()).build());
    }

    public static void init() {
        ENCHANTMENT_EFFECT_COMPONENTS.register();
    }
}
