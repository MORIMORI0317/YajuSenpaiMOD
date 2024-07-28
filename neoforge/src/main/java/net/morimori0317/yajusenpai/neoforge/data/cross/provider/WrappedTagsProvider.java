package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WrappedTagsProvider<T> extends TagsProvider<T> {
    private final TagProviderWrapper<T, TagProviderWrapper.TagProviderAccess<T, TagProviderWrapper.TagAppenderWrapper<T>>> tagProviderWrapper;

    protected WrappedTagsProvider(PackOutput arg, ResourceKey<? extends Registry<T>> arg2, CompletableFuture<HolderLookup.Provider> completableFuture, String modId, @Nullable ExistingFileHelper existingFileHelper, TagProviderWrapper<T, TagProviderWrapper.TagProviderAccess<T, TagProviderWrapper.TagAppenderWrapper<T>>> tagProviderWrapper) {
        super(arg, arg2, completableFuture, modId, existingFileHelper);
        this.tagProviderWrapper = tagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tagProviderWrapper.generateTag(new TagProviderAccessImpl());
    }

    private class TagProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<T, TagProviderWrapper.TagAppenderWrapper<T>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<T> tag(TagKey<T> tagKey) {
            return new TagAppenderWrapperImpl<>(WrappedTagsProvider.this.tag(tagKey));
        }
    }

    protected static class TagAppenderWrapperImpl<A> implements TagProviderWrapper.TagAppenderWrapper<A> {
        private final TagAppender<A> appender;

        protected TagAppenderWrapperImpl(TagAppender<A> appender) {
            this.appender = appender;
        }

        private TagProviderWrapper.TagAppenderWrapper<A> of(TagAppender<A> appender) {
            return new TagAppenderWrapperImpl<>(appender);
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> addTag(TagKey<A> tagKey) {
            return of(this.appender.addTag(tagKey));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> add(ResourceKey<A> resourceKey) {
            return of(this.appender.add(resourceKey));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> add(ResourceKey<A>... resourceKeys) {
            return of(this.appender.add(resourceKeys));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> addOptional(ResourceLocation resourceLocation) {
            return of(this.appender.addOptional(resourceLocation));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> addOptionalTag(ResourceLocation resourceLocation) {
            return of(this.appender.addOptionalTag(resourceLocation));
        }
    }
   /* protected static class TagAppenderWrapperImpl<A> implements TagProviderWrapper.TagAppenderWrapper<A> {
        private final TagProviderWrapper.TagProviderAccess<A> provider;
        private final TagAppender<A> appender;

        protected TagAppenderWrapperImpl(TagProviderWrapper.TagProviderAccess<A> provider, TagAppender<A> appender) {
            this.provider = provider;
            this.appender = appender;
        }

       *//* @Override
        public TagProviderWrapper.TagAppenderWrapper<A> add(A object) {
            return new TagAppenderWrapperImpl<>(provider, appender.add(object));
        }*//*

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> add(A object) {
            return null;
        }

        @SafeVarargs
        @Override
        public final TagProviderWrapper.TagAppenderWrapper<A> add(ResourceKey<A>... resourceKeys) {
            return new TagAppenderWrapperImpl<>(provider, appender.add(resourceKeys));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> addOptional(ResourceLocation resourceLocation) {
            return new TagAppenderWrapperImpl<>(provider, appender.addOptional(resourceLocation));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> addTagHolder(TagKey<A> tagKey) {
            return new TagAppenderWrapperImpl<>(provider, appender.addTag(tagKey));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> addOptionalTag(ResourceLocation resourceLocation) {
            return new TagAppenderWrapperImpl<>(provider, appender.addOptionalTag(resourceLocation));
        }

        @Override
        public TagProviderWrapper.TagAppenderWrapper<A> add(A... objects) {
            return null;
        }

       *//* @SafeVarargs
        @Override
        public final TagProviderWrapper.TagAppenderWrapper<A> add(A... objects) {
            return new TagAppenderWrapperImpl<>(provider, appender.add(objects));
        }*//*

        @Override
        public TagProviderWrapper.TagProviderAccess<A> getTagProvider() {
            return provider;
        }
    }*/
}
