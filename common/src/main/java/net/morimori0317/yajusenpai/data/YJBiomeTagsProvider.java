package net.morimori0317.yajusenpai.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.BiomeTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.explatform.data.YJDataExpectPlatform;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomeTags;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomes;

import java.util.concurrent.CompletableFuture;

public class YJBiomeTagsProvider extends BiomeTagsProviderWrapper {

    public YJBiomeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess, registriesDatapackProviderWrapper);
    }

    @Override
    public void generateTag(TagProviderAccess<Biome, TagAppenderWrapper<Biome>> providerAccess) {
        providerAccess.tag(BiomeTags.HAS_DESERT_PYRAMID)
                .add(YJBiomes.YAJUSENPAI_BIOME);

        providerAccess.tag(BiomeTags.HAS_JUNGLE_TEMPLE)
                .add(YJBiomes.YAJUSENPAI_BIOME);

        providerAccess.tag(BiomeTags.HAS_STRONGHOLD)
                .add(YJBiomes.YAJUSENPAI_BIOME);

        providerAccess.tag(BiomeTags.HAS_VILLAGE_PLAINS)
                .add(YJBiomes.YAJUSENPAI_BIOME);

        providerAccess.tag(YJBiomeTags.HAS_YJ_HOUSE)
                .addVanillaTag(BiomeTags.IS_OVERWORLD)
                .addVanillaTag(BiomeTags.IS_NETHER)
                .addTag(YJBiomeTags.IS_YAJUSENPAI);

        providerAccess.tag(YJBiomeTags.IS_YAJUSENPAI)
                .add(YJBiomes.YAJUSENPAI_BIOME);

        YJDataExpectPlatform.generateBiomeTag(providerAccess);
    }
}