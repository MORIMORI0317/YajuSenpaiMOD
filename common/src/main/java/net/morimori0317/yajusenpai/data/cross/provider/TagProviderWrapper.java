package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.ManualTagHolder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public abstract class TagProviderWrapper<T, A extends TagProviderWrapper.TagProviderAccess<T, ? extends TagProviderWrapper.TagAppenderWrapper<T>>> extends DataProviderWrapper<TagsProvider<T>> {
    private final CompletableFuture<HolderLookup.Provider> lookup;

    public TagProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
        this.lookup = lookup;
    }

    public CompletableFuture<HolderLookup.Provider> getLookup() {
        return lookup;
    }

    public abstract void generateTag(A providerAccess);

    public static interface TagProviderAccess<T, W extends TagAppenderWrapper<T>> {
        W tag(TagKey<T> tagKey);
    }

    public static interface TagAppenderWrapper<T> {
        TagAppenderWrapper<T> addTag(TagKey<T> tagKey);

        TagAppenderWrapper<T> add(ResourceKey<T> resourceKey);

        TagAppenderWrapper<T> add(ResourceKey<T>... resourceKeys);

        TagAppenderWrapper<T> addOptional(ResourceLocation resourceLocation);

        TagAppenderWrapper<T> addOptionalTag(ResourceLocation resourceLocation);

        default TagAppenderWrapper<T> addTags(List<TagKey<T>> tagKeys) {
            TagAppenderWrapper<T> appenderWrapper = this;

            for (TagKey<T> tagKey : tagKeys)
                appenderWrapper = appenderWrapper.addTag(tagKey);

            return appenderWrapper;
        }

        default TagAppenderWrapper<T> addTagHolders(List<ManualTagHolder<T>> tagHolders) {
            TagAppenderWrapper<T> appenderWrapper = this;

            for (ManualTagHolder<T> tagHolder : tagHolders)
                appenderWrapper = appenderWrapper.addTagHolder(tagHolder);

            return appenderWrapper;
        }

        default TagAppenderWrapper<T> addOptionalTag(ResourceLocation... resourceLocations) {
            TagAppenderWrapper<T> appenderWrapper = this;

            for (ResourceLocation resourceLocation : resourceLocations)
                appenderWrapper = appenderWrapper.addOptionalTag(resourceLocation);

            return appenderWrapper;
        }

        default TagAppenderWrapper<T> addTagHolder(ManualTagHolder<T> tagHolder) {
           /* var tp = getTagProvider();
            if (tp != null)
                tagHolder.registering(tp);*/
            return addTag(tagHolder.getKey());
        }

        default TagAppenderWrapper<T> addVanillaTag(TagKey<T> tagKey) {
            return addTag(tagKey);
        }

    }
}
