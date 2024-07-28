package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.morimori0317.yajusenpai.data.cross.provider.AdvancementProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.AdvancementSubProviderWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;


public class WrappedFabricAdvancementProvider extends FabricAdvancementProvider {
    private final AdvancementProviderWrapper advancementProviderWrapper;
    private final List<AdvancementSubProviderWrapper> subProviderWrappers;

    public WrappedFabricAdvancementProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup,
                                            AdvancementProviderWrapper advancementProviderWrapper, List<AdvancementSubProviderWrapper> subProviderWrappers) {
        super(output, registryLookup);
        this.advancementProviderWrapper = advancementProviderWrapper;
        this.subProviderWrappers = subProviderWrappers;
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        for (AdvancementSubProviderWrapper subProviderWrapper : subProviderWrappers) {
            subProviderWrapper.generate(consumer);
        }
    }
}

