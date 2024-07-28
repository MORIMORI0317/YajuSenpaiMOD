package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AdvancementProviderWrapper extends DataProviderWrapper<DataProvider> {
    private final DataProvider advancementProvider;

    public AdvancementProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess, CompletableFuture<HolderLookup.Provider> lookup, List<AdvancementSubProviderWrapper> subProviderWrappers) {
        super(packOutput, crossDataGeneratorAccess);
        this.advancementProvider = crossDataGeneratorAccess.createAdvancementProvider(packOutput, this, lookup, subProviderWrappers);
    }

    @Override
    public DataProvider getProvider() {
        return advancementProvider;
    }
}
