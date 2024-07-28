package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;

public abstract class PoiTypeTagProviderWrapper extends TagProviderWrapper<PoiType, TagProviderWrapper.TagProviderAccess<PoiType, TagProviderWrapper.TagAppenderWrapper<PoiType>>> {
    private final TagsProvider<PoiType> poiTypeTagsProvider;

    public PoiTypeTagProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, lookup, crossDataGeneratorAccess);
        this.poiTypeTagsProvider = crossDataGeneratorAccess.createPoiTypeTagProvider(packOutput, lookup, this);
    }

    @Override
    public TagsProvider<PoiType> getProvider() {
        return poiTypeTagsProvider;
    }
}
