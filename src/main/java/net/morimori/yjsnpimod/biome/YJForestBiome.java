package net.morimori.yjsnpimod.biome;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.data.worldgen.biome.VanillaBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;

public class YJForestBiome {
    public static void init() {
        ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(YJBlocks.YJ_GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        generationSettings.surfaceBuilder(SURFACE_BUILDER);
        generationSettings.addStructureStart(StructureFeatures.VILLAGE_PLAINS);
        generationSettings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
        generationSettings.addStructureStart(StructureFeatures.WOODLAND_MANSION);

        BiomeDefaultFeatures.addDefaultOverworldLandStructures(generationSettings);

        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_STANDARD);
        BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
        BiomeDefaultFeatures.addDefaultLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);

        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);

        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YJFeatures.BIRCH_YJ);

        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, YJFeatures.PATCH_GRASS_FOREST_YJ);
        // BiomeDefaultFeatures.addForestGrass(generationSettings);

        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);

        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);
        spawnSettings.setPlayerCanSpawn();

        Biome biome = new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.FOREST)
                .depth(0.1f).scale(0.4f).temperature(0.7F).downfall(0.8F).specialEffects((new net.minecraft.world.level.biome.BiomeSpecialEffects.Builder()).waterColor(0x364364).waterFogColor(0x1919).fogColor(0x114514).skyColor(0x114514)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build()).mobSpawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(YJSNPIMOD.MODID, "yj_forest"), SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(YJSNPIMOD.MODID, "yj_forest"), biome);

    }
}
