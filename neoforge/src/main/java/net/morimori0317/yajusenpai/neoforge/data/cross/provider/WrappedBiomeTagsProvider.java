package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.morimori0317.yajusenpai.data.cross.provider.BiomeTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WrappedBiomeTagsProvider extends BiomeTagsProvider {
    private final BiomeTagsProviderWrapper tagProviderWrapper;

    public WrappedBiomeTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, String modId, @Nullable ExistingFileHelper existingFileHelper, BiomeTagsProviderWrapper tagProviderWrapper) {
        super(arg, completableFuture, modId, existingFileHelper);
        this.tagProviderWrapper = tagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tagProviderWrapper.generateTag(new BiomeTagsProviderAccessImpl());
    }

    private class BiomeTagsProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<Biome, TagProviderWrapper.TagAppenderWrapper<Biome>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<Biome> tag(TagKey<Biome> tagKey) {
            return new WrappedTagsProvider.TagAppenderWrapperImpl<>(WrappedBiomeTagsProvider.this.tag(tagKey));
        }
    }
}
