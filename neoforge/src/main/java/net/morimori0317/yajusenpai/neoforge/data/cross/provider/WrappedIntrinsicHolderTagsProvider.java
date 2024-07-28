package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class WrappedIntrinsicHolderTagsProvider<T> extends IntrinsicHolderTagsProvider<T> {
    private final IntrinsicHolderTagsProviderWrapper<T, IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T>> intrinsicHolderTagsProvider;

    public WrappedIntrinsicHolderTagsProvider(PackOutput arg, ResourceKey<? extends Registry<T>> arg2, CompletableFuture<HolderLookup.Provider> completableFuture, Function<T, ResourceKey<T>> function, String modId, @Nullable ExistingFileHelper existingFileHelper, IntrinsicHolderTagsProviderWrapper<T, IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T>> intrinsicHolderTagsProvider) {
        super(arg, arg2, completableFuture, function, modId, existingFileHelper);
        this.intrinsicHolderTagsProvider = intrinsicHolderTagsProvider;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.intrinsicHolderTagsProvider.generateTag(new IntrinsicHolderTagProviderAccessImpl());
    }

    private class IntrinsicHolderTagProviderAccessImpl implements IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T> {
        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> tag(TagKey<T> tagKey) {
            return new IntrinsicHolderTagAppenderWrapperImpl<>(WrappedIntrinsicHolderTagsProvider.this.tag(tagKey));
        }
    }

    protected static class IntrinsicHolderTagAppenderWrapperImpl<T> extends WrappedTagsProvider.TagAppenderWrapperImpl<T> implements IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> {
        private final IntrinsicTagAppender<T> intrinsicTagAppender;

        protected IntrinsicHolderTagAppenderWrapperImpl(IntrinsicTagAppender<T> appender) {
            super(appender);
            this.intrinsicTagAppender = appender;
        }

        private IntrinsicHolderTagAppenderWrapperImpl<T> of(IntrinsicTagAppender<T> appender) {
            return new IntrinsicHolderTagAppenderWrapperImpl<>(appender);
        }

        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> add(T object) {
            return of(intrinsicTagAppender.add(object));
        }

        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<T> add(T... objects) {
            return of(intrinsicTagAppender.add(objects));
        }
    }
}
