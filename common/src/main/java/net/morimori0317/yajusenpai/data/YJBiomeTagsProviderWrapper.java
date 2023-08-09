package net.morimori0317.yajusenpai.data;

import dev.felnull.otyacraftengine.data.CrossDataGeneratorAccess;
import dev.felnull.otyacraftengine.data.provider.BiomeTagsProviderWrapper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomeTags;
import net.morimori0317.yajusenpai.server.level.dimension.YJDimensions;

import java.util.concurrent.CompletableFuture;

public class YJBiomeTagsProviderWrapper extends BiomeTagsProviderWrapper {
    public YJBiomeTagsProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, YJRegistriesDatapackProviderWrapper.unitedLookup(lookup), crossDataGeneratorAccess);
    }

    @Override
    public void generateTag(TagProviderAccess<Biome, TagAppenderWrapper<Biome>> providerAccess) {
        providerAccess.tag(BiomeTags.HAS_DESERT_PYRAMID)
                .add(YJDimensions.YAJUSENPAI_BIOME);

        providerAccess.tag(BiomeTags.HAS_JUNGLE_TEMPLE)
                .add(YJDimensions.YAJUSENPAI_BIOME);

        providerAccess.tag(BiomeTags.HAS_STRONGHOLD)
                .add(YJDimensions.YAJUSENPAI_BIOME);

        providerAccess.tag(BiomeTags.HAS_VILLAGE_PLAINS)
                .add(YJDimensions.YAJUSENPAI_BIOME);

        providerAccess.tag(YJBiomeTags.HAS_YJ_HOUSE)
                .addVanillaTag(BiomeTags.IS_OVERWORLD)
                .addVanillaTag(BiomeTags.IS_NETHER)
                .addTag(YJBiomeTags.IS_YAJUSENPAI);

        providerAccess.tag(YJBiomeTags.IS_YAJUSENPAI)
                .add(YJDimensions.YAJUSENPAI_BIOME);
    }
}
