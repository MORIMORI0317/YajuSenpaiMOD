package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.morimori0317.yajusenpai.data.cross.provider.DamageTypeTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class WrappedDamageTypeTagsProvider extends TagsProvider<DamageType> {
    private final DamageTypeTagsProviderWrapper tagProviderWrapper;

    public WrappedDamageTypeTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, String modid, ExistingFileHelper existingFileHelper, DamageTypeTagsProviderWrapper tagProviderWrapper) {
        super(arg, Registries.DAMAGE_TYPE, completableFuture, modid, existingFileHelper);
        this.tagProviderWrapper = tagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tagProviderWrapper.generateTag(new DamageTypeTagsProviderAccessImpl());
    }

    private class DamageTypeTagsProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<DamageType, TagProviderWrapper.TagAppenderWrapper<DamageType>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<DamageType> tag(TagKey<DamageType> tagKey) {
            return new WrappedTagsProvider.TagAppenderWrapperImpl<>(WrappedDamageTypeTagsProvider.this.tag(tagKey));
        }
    }
}
