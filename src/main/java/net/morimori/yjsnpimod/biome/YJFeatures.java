package net.morimori.yjsnpimod.biome;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

public class YJFeatures {
    public static final RandomPatchConfiguration YJ_GRASS_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(YJBlocks.YJ_GRASS.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(32).build();

    private static final Map<ResourceLocation, ConfiguredFeature<?, ?>> MOD_FEATURES = new HashMap<>();
    public static final ConfiguredFeature<TreeConfiguration, ?> YJ_TREE = register("yj_tree", Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(YJBlocks.YJ_LOG.defaultBlockState()), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(YJBlocks.YJ_LEAVES.defaultBlockState()), new SimpleStateProvider(YJBlocks.YJ_SAPLING.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_YJ_TREE = register("fancy_yj_tree", Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(YJBlocks.YJ_LOG.defaultBlockState()), new FancyTrunkPlacer(3, 11, 0), new SimpleStateProvider(YJBlocks.YJ_LEAVES.defaultBlockState()), new SimpleStateProvider(YJBlocks.YJ_SAPLING.defaultBlockState()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));
    public static final ConfiguredFeature<?, ?> BIRCH_YJ = register("birch_yj", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(FANCY_YJ_TREE.weighted(0.3F)), YJ_TREE)).decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(10, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> PATCH_GRASS_YJ = register("patch_grass_yj", Feature.RANDOM_PATCH.configured(YJ_GRASS_CONFIG).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).decorated(FeatureDecorator.COUNT_NOISE.configured(new NoiseDependantDecoratorConfiguration(-0.8D, 5, 10))));
    public static final ConfiguredFeature<?, ?> PATCH_GRASS_FOREST_YJ = register("patch_grass_forest_yj", Feature.RANDOM_PATCH.configured(YJ_GRASS_CONFIG).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));

    private static <T extends FeatureConfiguration> ConfiguredFeature<T, ?> register(String name, ConfiguredFeature<T, ?> feature) {
        MOD_FEATURES.put(new ResourceLocation(YJSNPIMOD.MODID, name), feature);
        return feature;
    }

    public static void init() {
        MOD_FEATURES.forEach((n, m) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, n, m));
    }
}
