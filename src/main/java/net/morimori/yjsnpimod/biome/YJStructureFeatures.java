package net.morimori.yjsnpimod.biome;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.morimori.yjsnpimod.YJSNPIMOD;

import java.util.HashMap;
import java.util.Map;

public class YJStructureFeatures {
    private static final Map<ResourceLocation, ConfiguredStructureFeature<?, ?>> ORE_STRUCTUREFEATURES = new HashMap<>();

    public static final StructureFeature<NoneFeatureConfiguration> YJ_HOUSE_FUTER = new YJHouseFeature(NoneFeatureConfiguration.CODEC);
    public static final ConfiguredStructureFeature<?, ?> YJ_HOUSE = register("yj_house", YJ_HOUSE_FUTER.configured(NoneFeatureConfiguration.NONE));

    private static <FC extends FeatureConfiguration, F extends StructureFeature<FC>> ConfiguredStructureFeature<FC, F> register(String name, ConfiguredStructureFeature<FC, F> feature) {
        ORE_STRUCTUREFEATURES.put(new ResourceLocation(YJSNPIMOD.MODID, name), feature);
        return feature;
    }

    public static void init() {

        FabricStructureBuilder.create(new ResourceLocation(YJSNPIMOD.MODID, "yj_house_st"), YJ_HOUSE_FUTER)
                .step(GenerationStep.Decoration.SURFACE_STRUCTURES)
                .defaultConfig(64, 16, 12345)
                .adjustsSurface()
                .register();

        ORE_STRUCTUREFEATURES.forEach((n, m) -> Registry.register(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, n, m));
        BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.getResourceKey(YJ_HOUSE).ifPresent(n -> BiomeModifications.addStructure(l -> (l.getBiome().getBiomeCategory() != Biome.BiomeCategory.OCEAN) && (l.getBiome().getBiomeCategory() != Biome.BiomeCategory.RIVER) && (l.getBiome().getBiomeCategory() != Biome.BiomeCategory.NONE), n));
    }
}
