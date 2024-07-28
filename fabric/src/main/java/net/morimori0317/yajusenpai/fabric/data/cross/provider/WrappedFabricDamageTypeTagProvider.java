package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.morimori0317.yajusenpai.data.cross.provider.DamageTypeTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class WrappedFabricDamageTypeTagProvider extends FabricTagProvider<DamageType> {
    private final DamageTypeTagsProviderWrapper tagProviderWrapper;

    public WrappedFabricDamageTypeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, DamageTypeTagsProviderWrapper tagProviderWrapper) {
        super(output, Registries.DAMAGE_TYPE, registriesFuture);
        this.tagProviderWrapper = tagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tagProviderWrapper.generateTag(new DamageTypeTagProviderAccessImpl());
    }

    private class DamageTypeTagProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<DamageType, TagProviderWrapper.TagAppenderWrapper<DamageType>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<DamageType> tag(TagKey<DamageType> tagKey) {
            return new WrappedFabricTagProvider.TagAppenderWrapperImpl<>(WrappedFabricDamageTypeTagProvider.this.tag(tagKey));
        }
    }
}
