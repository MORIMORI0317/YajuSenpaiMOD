package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class WrappedFabricIntrinsicHolderTagsProvider<T> extends WrappedFabricTagProvider<T> {
    private final IntrinsicHolderTagsProviderWrapper<T, IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T>> intrinsicHolderTagsProvider;

    public WrappedFabricIntrinsicHolderTagsProvider(FabricDataOutput output, ResourceKey<? extends Registry<T>> registryKey, CompletableFuture<HolderLookup.Provider> registriesFuture, IntrinsicHolderTagsProviderWrapper<T, IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T>> intrinsicHolderTagsProvider) {
        super(output, registryKey, registriesFuture, null);
        this.intrinsicHolderTagsProvider = intrinsicHolderTagsProvider;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.intrinsicHolderTagsProvider.generateTag(new IntrinsicHolderTagProviderAccessImpl());
    }

    private class IntrinsicHolderTagProviderAccessImpl implements IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T> {
        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> tag(TagKey<T> tagKey) {
            return new IntrinsicHolderTagAppenderWrapperImpl<>(WrappedFabricIntrinsicHolderTagsProvider.this.tag(tagKey), intrinsicHolderTagsProvider);
        }
    }

    protected static class IntrinsicHolderTagAppenderWrapperImpl<T> extends WrappedFabricTagProvider.TagAppenderWrapperImpl<T> implements IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> {
        private final TagAppender<T> tagAppender;
        private final IntrinsicHolderTagsProviderWrapper<T, ? extends IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T>> tagProviderWrapper;

        protected IntrinsicHolderTagAppenderWrapperImpl(TagAppender<T> appender, IntrinsicHolderTagsProviderWrapper<T, ? extends IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T>> tagProviderWrapper) {
            super(appender);
            this.tagAppender = appender;
            this.tagProviderWrapper = tagProviderWrapper;
        }

        private IntrinsicHolderTagAppenderWrapperImpl<T> of(TagAppender<T> appender) {
            return new IntrinsicHolderTagAppenderWrapperImpl<>(appender, tagProviderWrapper);
        }

        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> add(T object) {
            return of(tagAppender.add(tagProviderWrapper.getKeyExtractor().apply(object)));
        }

        @SafeVarargs
        @Override
        public final IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> add(T... objects) {
            IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> ret = null;

            for (T object : objects) {
                ret = this.add(object);
            }

            return ret == null ? of(tagAppender) : ret;
        }
    }
}
