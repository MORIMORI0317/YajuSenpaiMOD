package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;

import java.util.concurrent.CompletableFuture;


public class WrappedFabricTagProvider<T> extends FabricTagProvider<T> {
    private final TagProviderWrapper<T, TagProviderWrapper.TagProviderAccess<T, TagProviderWrapper.TagAppenderWrapper<T>>> tagProviderWrapper;

    public WrappedFabricTagProvider(FabricDataOutput output, ResourceKey<? extends Registry<T>> registryKey, CompletableFuture<HolderLookup.Provider> registriesFuture, TagProviderWrapper<T, TagProviderWrapper.TagProviderAccess<T, TagProviderWrapper.TagAppenderWrapper<T>>> tagProviderWrapper) {
        super(output, registryKey, registriesFuture);
        this.tagProviderWrapper = tagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tagProviderWrapper.generateTag(new TagProviderAccessImpl());
    }

    private class TagProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<T, TagProviderWrapper.TagAppenderWrapper<T>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<T> tag(TagKey<T> tagKey) {
            return new TagAppenderWrapperImpl<>(WrappedFabricTagProvider.this.tag(tagKey));
        }
    }

    protected static class TagAppenderWrapperImpl<T> implements TagProviderWrapper.TagAppenderWrapper<T> {
        private final TagAppender<T> appender;

        protected TagAppenderWrapperImpl(TagAppender<T> appender) {
            this.appender = appender;
        }

        private TagAppenderWrapperImpl<T> of(TagAppender<T> appender) {
            return new TagAppenderWrapperImpl<>(appender);
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<T> addTag(TagKey<T> tagKey) {
            return of(appender.addTag(tagKey));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<T> add(ResourceKey<T> resourceKey) {
            return of(appender.add(resourceKey));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<T> add(ResourceKey<T>... resourceKeys) {
            return of(appender.add(resourceKeys));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<T> addOptional(ResourceLocation resourceLocation) {
            return of(appender.addOptional(resourceLocation));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<T> addOptionalTag(ResourceLocation resourceLocation) {
            return of(appender.addOptionalTag(resourceLocation));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<T> addVanillaTag(TagKey<T> tagKey) {
            return addOptionalTag(tagKey.location());
        }
    }
}

