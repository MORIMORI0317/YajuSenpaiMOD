package net.morimori.yjsnpimod.world;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.DoublePlantPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;

import java.util.*;

public class YJFeatures {
    public static final List<ConfiguredFeature<?, ?>> ORE_INMBLOCKS = new ArrayList<>();

    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_YJNIUM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, YJBlocks.YJNIUM_ORE.defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YJNIUM_ORE.defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_YJSNPI_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, YJBlocks.YJSNPI_ORE.defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YJSNPI_ORE.defaultBlockState()));

    public static final RandomPatchConfiguration YJ_GRASS_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(YJBlocks.YJ_GRASS.defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(32).build();
    public static final RandomPatchConfiguration TALL_YJ_GRASS_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(YJBlocks.TALL_YJ_GRASS.defaultBlockState()), new DoublePlantPlacer())).tries(64).noProjection().build();
    public static final RandomPatchConfiguration YJ_FLOWER_CONFIG = (new RandomPatchConfiguration.GrassConfigurationBuilder(new WeightedStateProvider(Features.weightedBlockStateBuilder().add(YJBlocks.YJ_ROSE.defaultBlockState(), 2)), SimpleBlockPlacer.INSTANCE)).tries(64).build();

    private static final Map<ResourceLocation, ConfiguredFeature<?, ?>> MOD_FEATURES = new HashMap<>();
    public static final ConfiguredFeature<TreeConfiguration, ?> YJ_TREE = register("yj_tree", Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(YJBlocks.YJ_LOG.defaultBlockState()), new StraightTrunkPlacer(4, 2, 0), new SimpleStateProvider(YJBlocks.YJ_LEAVES.defaultBlockState()), new SimpleStateProvider(YJBlocks.YJ_SAPLING.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build()));
    public static final ConfiguredFeature<TreeConfiguration, ?> FANCY_YJ_TREE = register("fancy_yj_tree", Feature.TREE.configured((new TreeConfiguration.TreeConfigurationBuilder(new SimpleStateProvider(YJBlocks.YJ_LOG.defaultBlockState()), new FancyTrunkPlacer(3, 11, 0), new SimpleStateProvider(YJBlocks.YJ_LEAVES.defaultBlockState()), new SimpleStateProvider(YJBlocks.YJ_SAPLING.defaultBlockState()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))).ignoreVines().build()));
    public static final ConfiguredFeature<?, ?> BIRCH_YJ = register("birch_yj", Feature.RANDOM_SELECTOR.configured(new RandomFeatureConfiguration(ImmutableList.of(FANCY_YJ_TREE.weighted(0.3F)), YJ_TREE)).decorated(Features.Decorators.HEIGHTMAP_WITH_TREE_THRESHOLD_SQUARED).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(10, 0.1F, 1))));
    public static final ConfiguredFeature<?, ?> PATCH_GRASS_YJ = register("patch_grass_yj", Feature.RANDOM_PATCH.configured(YJ_GRASS_CONFIG).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).decorated(FeatureDecorator.COUNT_NOISE.configured(new NoiseDependantDecoratorConfiguration(-0.8D, 5, 10))));
    public static final ConfiguredFeature<?, ?> PATCH_GRASS_FOREST_YJ = register("patch_grass_forest_yj", Feature.RANDOM_PATCH.configured(YJ_GRASS_CONFIG).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));
    public static final ConfiguredFeature<?, ?> PATCH_TALL_GRASS_2_YJ = register("patch_tall_grass_2_yj", Feature.RANDOM_PATCH.configured(TALL_YJ_GRASS_CONFIG).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP).squared().decorated(FeatureDecorator.COUNT_NOISE.configured(new NoiseDependantDecoratorConfiguration(-0.8D, 0, 7))));
    public static final ConfiguredFeature<?, ?> PATCH_GRASS_PLAIN_YJ = register("patch_grass_plain_yj", Feature.RANDOM_PATCH.configured(YJ_GRASS_CONFIG).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).decorated(FeatureDecorator.COUNT_NOISE.configured(new NoiseDependantDecoratorConfiguration(-0.8D, 5, 10))));
    public static final ConfiguredFeature<?, ?> YJ_FLOWERS = register("yj_flowers", Feature.FLOWER.configured(YJ_FLOWER_CONFIG).decorated(Features.Decorators.ADD_32).decorated(Features.Decorators.HEIGHTMAP_SQUARE.count(2)));
    public static final ConfiguredFeature<?, ?> ORE_YJNIUM = register("ore_yjnium", Feature.ORE.configured(new OreConfiguration(ORE_YJNIUM_TARGET_LIST, 9)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(63)).squared().count(5));
    public static final ConfiguredFeature<?, ?> ORE_YJNIUM_YJDIM = register("ore_yjnium_yjdim", Feature.ORE.configured(new OreConfiguration(ORE_YJNIUM_TARGET_LIST, 9)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(63)).squared().count(40));
    public static final ConfiguredFeature<?, ?> ORE_YJSNPI = register("ore_yjsnpi", Feature.ORE.configured(new OreConfiguration(ORE_YJSNPI_TARGET_LIST, 9)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(31)).squared().count(10));

    private static <T extends FeatureConfiguration> ConfiguredFeature<T, ?> register(String name, ConfiguredFeature<T, ?> feature) {
        MOD_FEATURES.put(new ResourceLocation(YJSNPIMOD.MODID, name), feature);
        return feature;
    }

    public static void init() {
        YJBlocks.INM_BLOCKS.stream().filter(n -> n != YJBlocks.YJSNPI_PROLIFERATION_BLOCK).forEach(n -> {
            ResourceLocation location = Registry.BLOCK.getKey(n);
            ORE_INMBLOCKS.add(register("ore_" + location.getPath(), createInmOreFeature(n)));
        });
        MOD_FEATURES.forEach((n, m) -> Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, n, m));
    }

    private static ConfiguredFeature<?, ?> createInmOreFeature(Block block) {
        ImmutableList<OreConfiguration.TargetBlockState> ORE_INM_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, block.defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, block.defaultBlockState()));
        return Feature.ORE.configured(new OreConfiguration(ORE_INM_TARGET_LIST, 9)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(194)).squared().count(10);
    }

    public static void addYJDimOres(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_YJNIUM_YJDIM);
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ORE_YJSNPI);
        ORE_INMBLOCKS.forEach(n -> builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, n));
    }
}
