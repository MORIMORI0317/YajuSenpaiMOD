package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.morimori0317.yajusenpai.data.cross.provider.PaintingVariantTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class WrappedFabricPaintingVariantTagProvider extends FabricTagProvider<PaintingVariant> {
    private final PaintingVariantTagsProviderWrapper paintingVariantTagsProviderWrapper;

    public WrappedFabricPaintingVariantTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, PaintingVariantTagsProviderWrapper paintingVariantTagsProviderWrapper) {
        super(output, Registries.PAINTING_VARIANT, registriesFuture);
        this.paintingVariantTagsProviderWrapper = paintingVariantTagsProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        this.paintingVariantTagsProviderWrapper.generateTag(new PaintingVariantTagProviderAccessImpl());
    }

    private class PaintingVariantTagProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<PaintingVariant, TagProviderWrapper.TagAppenderWrapper<PaintingVariant>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<PaintingVariant> tag(TagKey<PaintingVariant> tagKey) {
            return new WrappedFabricTagProvider.TagAppenderWrapperImpl<>(WrappedFabricPaintingVariantTagProvider.this.tag(tagKey));
        }
    }
}
