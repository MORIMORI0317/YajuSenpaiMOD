package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;

public abstract class PaintingVariantTagsProviderWrapper extends TagProviderWrapper<PaintingVariant, TagProviderWrapper.TagProviderAccess<PaintingVariant, TagProviderWrapper.TagAppenderWrapper<PaintingVariant>>> {
    private final TagsProvider<PaintingVariant> paintingVariantTagsProvider;

    public PaintingVariantTagsProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess);
        this.paintingVariantTagsProvider = crossDataGeneratorAccess.createPaintingVariantTagProvider(packOutput, lookup, this, registriesDatapackProviderWrapper);
    }

    @Override
    public TagsProvider<PaintingVariant> getProvider() {
        return this.paintingVariantTagsProvider;
    }
}
