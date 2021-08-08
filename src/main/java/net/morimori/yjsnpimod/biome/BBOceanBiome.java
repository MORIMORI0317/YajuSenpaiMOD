package net.morimori.yjsnpimod.biome;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.biome.VanillaBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;

public class BBOceanBiome {
    public static void init() {
        ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(YJBlocks.BB.defaultBlockState(), YJBlocks.BB.defaultBlockState(), YJBlocks.BB.defaultBlockState()));

        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnSettings);

        BiomeGenerationSettings.Builder generationSettings = VanillaBiomes.baseOceanGeneration(SURFACE_BUILDER, true, false, true);
        YJFeatures.addYJDimOres(generationSettings);

        Biome biome = (new Biome.BiomeBuilder())
                .precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.OCEAN)
                .depth(-1.8F).scale(0.1F).temperature(0.5F).downfall(0.5F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x0000FF).waterFogColor(0x0000FF).fogColor(0x0000FF).skyColor(0x0000FF).ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build()).build();

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(YJSNPIMOD.MODID, "bb_ocean"), SURFACE_BUILDER);

        Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(YJSNPIMOD.MODID, "bb_ocean"), biome);

    }
}
