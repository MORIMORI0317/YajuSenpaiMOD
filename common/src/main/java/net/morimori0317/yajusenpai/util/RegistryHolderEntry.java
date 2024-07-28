package net.morimori0317.yajusenpai.util;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Holder;

import java.util.Objects;
import java.util.function.Supplier;

public final class RegistryHolderEntry<T> {
    private final Supplier<Holder<T>> vanillaHolder;

    public RegistryHolderEntry(RegistrySupplier<T> registrySupplier) {
        this.vanillaHolder = Suppliers.memoize(() -> Objects.requireNonNull(registrySupplier.getRegistrar().getHolder(registrySupplier.getKey())));
    }

    public Holder<T> vanillaHolder() {
        return vanillaHolder.get();
    }
}
