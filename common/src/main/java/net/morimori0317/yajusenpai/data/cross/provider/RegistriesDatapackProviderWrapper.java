package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.explatform.data.YJDataExpectPlatform;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class RegistriesDatapackProviderWrapper extends DataProviderWrapper<DataProvider> {
    private final List<DynamicRegister<?>> registers;
    private final Supplier<RegistrySetBuilder> registrySetBuilder;
    private final DataProvider registriesDatapackGenerator;

    public RegistriesDatapackProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, List<DynamicRegister<?>> registers, Supplier<RegistrySetBuilder> registrySetBuilder) {
        super(packOutput, crossDataGeneratorAccess);
        this.registers = registers;
        this.registrySetBuilder = registrySetBuilder;
        this.registriesDatapackGenerator = crossDataGeneratorAccess.createRegistriesDatapackGenerator(packOutput, lookup, this);
    }

    @Override
    public DataProvider getProvider() {
        return this.registriesDatapackGenerator;
    }

    public RegistrySetBuilder getRegistrySetBuilder() {
        return registrySetBuilder.get();
    }

    public static RegistrySetBuilder createRegistrySetBuilder(RegistrySetBuilder builder, List<DynamicRegister<?>> registersList) {
        registersList.forEach(it -> it.addToBuilder(builder));
        return builder;
    }

    public List<DynamicRegister<?>> getRegisters() {
        return registers;
    }

    public CompletableFuture<HolderLookup.Provider> getLookupProvider() {
        return YJDataExpectPlatform.getRegistriesDatapackProviderLookup(this.registriesDatapackGenerator);
    }

    public static class DynamicRegister<T> {
        private final Map<ResourceKey<T>, Function<BootstrapContext<T>, T>> entries = new HashMap<>();
        private final ResourceKey<? extends Registry<T>> registryKey;

        public DynamicRegister(ResourceKey<? extends Registry<T>> registryKey) {
            this.registryKey = registryKey;
        }

        public void add(ResourceKey<T> key, Function<BootstrapContext<T>, T> entryFactory) {
            if (entries.containsKey(key)) {
                throw new IllegalStateException("Duplicate registration.");
            }
            entries.put(key, entryFactory);
        }

        protected void addToBuilder(RegistrySetBuilder builder) {
            builder.add(registryKey, context -> entries.forEach((key, factory) -> context.register(key, factory.apply(context))));
        }

        public ResourceKey<? extends Registry<T>> getRegistryKey() {
            return registryKey;
        }

        public Map<ResourceKey<T>, Function<BootstrapContext<T>, T>> getEntries() {
            return entries;
        }
    }
}
