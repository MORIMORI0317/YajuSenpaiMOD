package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public abstract class IntrinsicHolderTagsProviderWrapper<T, A extends IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<T>> extends TagProviderWrapper<T, A> {
    public IntrinsicHolderTagsProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, lookup, crossDataGeneratorAccess);
    }

    public abstract Function<T, ResourceKey<T>> getKeyExtractor();

    public static interface IntrinsicTagProviderAccess<T> extends TagProviderAccess<T, IntrinsicTagAppenderWrapper<T>> {
        @Override
        IntrinsicTagAppenderWrapper<T> tag(TagKey<T> tagKey);
    }

    public static interface IntrinsicTagAppenderWrapper<T> extends TagAppenderWrapper<T> {
        IntrinsicTagAppenderWrapper<T> add(T object);

        IntrinsicTagAppenderWrapper<T> add(T... objects);
    }
}
