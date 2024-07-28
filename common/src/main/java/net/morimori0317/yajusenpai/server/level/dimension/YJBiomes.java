package net.morimori0317.yajusenpai.server.level.dimension;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.server.level.features.YJPlacedFeatures;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJBiomes {
    public static final ResourceKey<Biome> YAJUSENPAI_BIOME = ResourceKey.create(Registries.BIOME, YJUtils.modLoc("yajusenpai"));

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<Biome> register) {
        register.add(YAJUSENPAI_BIOME, ctx -> {
            Biome.BiomeBuilder builder = new Biome.BiomeBuilder();
            builder.temperature(1.14514f);
            builder.downfall(0.4f);
            builder.hasPrecipitation(true);

            BiomeSpecialEffects.Builder biomeSpecialEffects = new BiomeSpecialEffects.Builder();
            biomeSpecialEffects.skyColor(9477011);
            biomeSpecialEffects.fogColor(12827056);
            biomeSpecialEffects.waterColor(6173952);
            biomeSpecialEffects.waterFogColor(6173952);
            biomeSpecialEffects.grassColorOverride(12827056);
            biomeSpecialEffects.foliageColorOverride(5068598);
            biomeSpecialEffects.ambientMoodSound(new AmbientMoodSettings(Holder.direct(YJSoundEvents.YJ_MOOD.get()), 6000, 8, 2));
            builder.specialEffects(biomeSpecialEffects.build());

            MobSpawnSettings.Builder mobSpawnSettings = new MobSpawnSettings.Builder();
            BiomeDefaultFeatures.commonSpawns(mobSpawnSettings);
            builder.mobSpawnSettings(mobSpawnSettings.build());

            BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder(ctx.lookup(Registries.PLACED_FEATURE), ctx.lookup(Registries.CONFIGURED_CARVER));
            biomeGenerationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE);
            biomeGenerationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE_EXTRA_UNDERGROUND);
            biomeGenerationSettings.addCarver(GenerationStep.Carving.AIR, Carvers.CANYON);

            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YJPlacedFeatures.TREES_YJ);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YJPlacedFeatures.PATCH_GRASS_YJ);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YJPlacedFeatures.FLOWER_DEFAULT_YJ);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YJPlacedFeatures.PATCH_BB);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YJPlacedFeatures.PATCH_GB);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YJPlacedFeatures.PATCH_RB);


            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_YJNIUM_MIDDLE);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_YJNIUM_SMALL);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_YJNIUM_UPPER);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_YJSNPI);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_YJSNPI_LOWER);

            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_KMR_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_MUR_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_TON_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_CCCLKTJM_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_CWCWTD_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_ENNUI_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_GOMANETSU_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_IKISUGI_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_IMDKUJ_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_INTERVIEW_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_INTLNGTM_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_KUNEKUNE_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_MEZIKARA_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_NEHAN_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_SHITARIGAO_BLOCK);
            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_INM_ORE_YJSNPI_SZKFK_BLOCK);

            biomeGenerationSettings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, YJPlacedFeatures.ORE_YJSNPI_EXPLODING_BLOCK);

            builder.generationSettings(biomeGenerationSettings.build());

            return builder.build();
        });
    }
}
