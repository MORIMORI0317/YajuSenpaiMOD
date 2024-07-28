package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.biome.Biome;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;

public abstract class BiomeTagsProviderWrapper extends TagProviderWrapper<Biome, TagProviderWrapper.TagProviderAccess<Biome, TagProviderWrapper.TagAppenderWrapper<Biome>>> {
    private final TagsProvider<Biome> biomeTagsProvider;

    public BiomeTagsProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess);
        this.biomeTagsProvider = crossDataGeneratorAccess.createBiomeTagProvider(packOutput, lookup, this, registriesDatapackProviderWrapper);
    }

    @Override
    public TagsProvider<Biome> getProvider() {
        return this.biomeTagsProvider;
    }
}
