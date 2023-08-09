package net.morimori0317.yajusenpai.server.level.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.List;

public class YJVegetationFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> YJ_PATCH_GRASS = key("yj_patch_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YJ_FLOWER_DEFAULT = key("yj_flower_default");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BB = key("patch_bb");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GB = key("patch_gb");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_RB = key("patch_rb");

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, YJUtils.modLoc(id));
    }

    private static SimpleWeightedRandomList.Builder<BlockState> createDefaultFlowerBuilder() {
        SimpleWeightedRandomList.Builder<BlockState> b = SimpleWeightedRandomList.builder();
        b.add(YJBlocks.YJ_ROSE.get().defaultBlockState(), 2);
        return b;
    }

    public static void registerBuilder(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(YJ_PATCH_GRASS, new ConfiguredFeature<>(Feature.RANDOM_PATCH, VegetationFeatures.grassPatch(BlockStateProvider.simple(YJBlocks.YJ_GRASS.get()), 32)));
        context.register(YJ_FLOWER_DEFAULT, new ConfiguredFeature<>(Feature.RANDOM_PATCH, VegetationFeatures.grassPatch(new WeightedStateProvider(createDefaultFlowerBuilder()), 64)));
        context.register(PATCH_BB, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(YJBlocks.BB.get())), List.of(YJBlocks.YJ_DIRT.get()))));
        context.register(PATCH_GB, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(YJBlocks.GB.get())), List.of(YJBlocks.YJ_DIRT.get()))));
        context.register(PATCH_RB, new ConfiguredFeature<>(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(YJBlocks.RB.get())), List.of(YJBlocks.YJ_DIRT.get()))));
    }
}
