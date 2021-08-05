package net.morimori.yjsnpimod.biome;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.StructureFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;

public class YJDesertBiome {
    public static void init() {
        ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(YJBlocks.YJ_SAND.defaultBlockState(), YJBlocks.YJ_SAND.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        generationSettings.surfaceBuilder(SURFACE_BUILDER);
        generationSettings.addStructureStart(StructureFeatures.VILLAGE_DESERT);
        generationSettings.addStructureStart(StructureFeatures.PILLAGER_OUTPOST);
        generationSettings.addStructureStart(StructureFeatures.DESERT_PYRAMID);
        BiomeDefaultFeatures.addFossilDecoration(generationSettings);

        BiomeDefaultFeatures.addDefaultOverworldLandStructures(generationSettings);
        generationSettings.addStructureStart(StructureFeatures.RUINED_PORTAL_DESERT);
        BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
        BiomeDefaultFeatures.addDesertLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultCrystalFormations(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);
        BiomeDefaultFeatures.addDesertVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
       // BiomeDefaultFeatures.addDesertExtraVegetation(generationSettings);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);
        BiomeDefaultFeatures.addDesertExtraDecoration(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);

        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.monsters(spawnSettings, 19, 1, 100);
        BiomeDefaultFeatures.caveSpawns(spawnSettings);
        spawnSettings.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HUSK, 80, 4, 4));
        spawnSettings.setPlayerCanSpawn();

        Biome biome = new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.DESERT)
                .depth(-0.2F)
                .scale(0.05F)
                .temperature(2.0F)
                .downfall(0.0F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x5e3500).waterFogColor(0x5e3500).fogColor(0x5e3500).skyColor(0x5e3500).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(YJSNPIMOD.MODID, "yj_desert"), SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(YJSNPIMOD.MODID, "yj_desert"), biome);

    }
}
