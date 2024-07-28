package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.morimori0317.yajusenpai.data.cross.provider.AdvancementProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.AdvancementSubProviderWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class WrappedAdvancementProvider extends AdvancementProvider {
    private final AdvancementProviderWrapper advancementProviderWrapper;

    public WrappedAdvancementProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, List<AdvancementSubProviderWrapper> subProviderWrappers, AdvancementProviderWrapper advancementProviderWrapper) {
        super(arg, completableFuture, subProviderWrappers.stream().map(n -> (AdvancementSubProvider) (r, consumer) -> n.generate(consumer)).toList());
        this.advancementProviderWrapper = advancementProviderWrapper;
    }
}
