package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;

public abstract class DataProviderWrapper<T extends DataProvider> implements DataProviderWrapperBase {
    private final CrossDataGeneratorAccess crossDataGeneratorAccess;
    public final PackOutput packOutput;

    public DataProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        this.packOutput = packOutput;
        this.crossDataGeneratorAccess = crossDataGeneratorAccess;
    }

    public CrossDataGeneratorAccess getCrossGeneratorAccess() {
        return crossDataGeneratorAccess;
    }

    public abstract T getProvider();

    public static interface Factory<T extends DataProviderWrapper<?>> {
        T create(PackOutput packOutput);
    }

    public static interface LookupFactory<T extends DataProviderWrapper<?>> {
        T create(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup);
    }

    public static interface GeneratorAccessedFactory<T extends DataProviderWrapper<?>> {
        T create(PackOutput packOutput, CrossDataGeneratorAccess generatorAccess);
    }

    public static interface LookupGeneratorAccessedFactory<T extends DataProviderWrapper<?>> {
        T create(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess generatorAccess);
    }
}
