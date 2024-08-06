package net.morimori0317.yajusenpai.server.level.dimension;

import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.morimori0317.yajusenpai.server.level.features.YJPlacedFeatures;

public class YJBiomeModifications {
    public static void init() {
        BiomeModifications.addProperties((biomeContext, mutable) -> {
            if (!biomeContext.hasTag(YJBiomeTags.IS_YAJUSENPAI)) {
                YJPlacedFeatures.INM_BLOCK_CHUNK_GENERAL.forEach((inmBlockGen, key) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, key));
                YJPlacedFeatures.INM_BLOCK_CHUNK_SPECIAL.forEach((inmBlockGen, key) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, key));
            }
        });
    }
}
