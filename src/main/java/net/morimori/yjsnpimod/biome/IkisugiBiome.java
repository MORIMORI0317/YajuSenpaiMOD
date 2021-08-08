package net.morimori.yjsnpimod.biome;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;

public class IkisugiBiome {
    public static void init() {
        ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(YJBlocks.YJSNPI_EXPLODING_BLOCK.defaultBlockState(), YJBlocks.YJSNPI_EXPLODING_BLOCK.defaultBlockState(), YJBlocks.YJSNPI_EXPLODING_BLOCK.defaultBlockState()));

        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        generationSettings.surfaceBuilder(SURFACE_BUILDER);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(generationSettings);
        BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
        BiomeDefaultFeatures.addDefaultLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);
        YJFeatures.addYJDimOres(generationSettings);

        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        spawnSettings.setPlayerCanSpawn();


        Biome biome = new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x3f76e4).waterFogColor(0x050533).fogColor(0xc0d8ff).skyColor(0x77adff).build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(YJSNPIMOD.MODID, "ikisugi"), SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(YJSNPIMOD.MODID, "ikisugi"), biome);
    }
}
