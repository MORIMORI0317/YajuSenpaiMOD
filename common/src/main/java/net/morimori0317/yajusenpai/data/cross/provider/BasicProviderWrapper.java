package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;

public abstract class BasicProviderWrapper extends DataProviderWrapper<DataProvider> {
    private final DataProvider basicProvider;

    public BasicProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
        this.basicProvider = crossDataGeneratorAccess.createBasicProvider(this);
    }

    @Override
    public DataProvider getProvider() {
        return basicProvider;
    }

    public abstract CompletableFuture<?> run(CachedOutput cachedOutput);

    public abstract String getName();
}
