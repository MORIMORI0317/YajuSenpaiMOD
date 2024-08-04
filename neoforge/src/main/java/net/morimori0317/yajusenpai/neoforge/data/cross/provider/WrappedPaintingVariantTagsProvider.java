package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.morimori0317.yajusenpai.data.cross.provider.PaintingVariantTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WrappedPaintingVariantTagsProvider extends PaintingVariantTagsProvider {
    private final PaintingVariantTagsProviderWrapper tagsProviderWrapper;

    public WrappedPaintingVariantTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, String modId, @Nullable ExistingFileHelper existingFileHelper, PaintingVariantTagsProviderWrapper tagsProviderWrapper) {
        super(arg, completableFuture, modId, existingFileHelper);
        this.tagsProviderWrapper = tagsProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tagsProviderWrapper.generateTag(new PaintingVariantTagsProviderAccessImpl());
    }

    private class PaintingVariantTagsProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<PaintingVariant, TagProviderWrapper.TagAppenderWrapper<PaintingVariant>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<PaintingVariant> tag(TagKey<PaintingVariant> tagKey) {
            return new WrappedTagsProvider.TagAppenderWrapperImpl<>(WrappedPaintingVariantTagsProvider.this.tag(tagKey));
        }
    }
}
