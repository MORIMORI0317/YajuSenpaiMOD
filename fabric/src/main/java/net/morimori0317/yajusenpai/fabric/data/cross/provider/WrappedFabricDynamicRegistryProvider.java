package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class WrappedFabricDynamicRegistryProvider extends FabricDynamicRegistryProvider {
    private final RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper;

    public WrappedFabricDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(output, registriesFuture);
        this.registriesDatapackProviderWrapper = registriesDatapackProviderWrapper;
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        this.registriesDatapackProviderWrapper.getRegisters().forEach(it -> addToEntry(registries, entries, it));
    }

    private <T> void addToEntry(HolderLookup.Provider registries, Entries entries, RegistriesDatapackProviderWrapper.DynamicRegister<T> register) {
        register.getEntries().forEach((key, entry) -> entries.add(registries.lookupOrThrow(register.getRegistryKey()), key));
    }

    @Override
    public @NotNull String getName() {
        return "Cloth Dynamic Registry";
    }
}
