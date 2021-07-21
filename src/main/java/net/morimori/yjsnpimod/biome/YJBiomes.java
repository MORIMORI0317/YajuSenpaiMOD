package net.morimori.yjsnpimod.biome;

public class YJBiomes {

    public static void init() {
       /* ConfiguredSurfaceBuilder<SurfaceBuilderBaseConfiguration> OBSIDIAN_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.configured(new SurfaceBuilderBaseConfiguration(Blocks.OBSIDIAN.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));

        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.monsters(spawnSettings, 95, 5, 100);
        BiomeGenerationSettings.Builder generationSettings = new BiomeGenerationSettings.Builder();
        generationSettings.surfaceBuilder(OBSIDIAN_SURFACE_BUILDER);
        BiomeDefaultFeatures.addDefaultOverworldLandStructures(generationSettings);
        BiomeDefaultFeatures.addDefaultCarvers(generationSettings);
        BiomeDefaultFeatures.addDefaultLakes(generationSettings);
        BiomeDefaultFeatures.addDefaultMonsterRoom(generationSettings);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultSprings(generationSettings);
        BiomeDefaultFeatures.addSurfaceFreezing(generationSettings);

        Biome testBiome = new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(0x3f76e4).waterFogColor(0x050533).fogColor(0xc0d8ff).skyColor(0x77adff).build())
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();

        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(YJSNPIMOD.MODID, "test"), OBSIDIAN_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, new ResourceLocation(YJSNPIMOD.MODID, "test"), testBiome);*/


        IkisugiBiome.init();
        YJDesertBiome.init();
    }


}
