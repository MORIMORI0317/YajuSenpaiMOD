package net.morimori0317.yajusenpai.server.world.features;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;

import java.util.List;
import java.util.function.Supplier;

public class YJVegetationFeatures {
    private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(YajuSenpai.MODID, Registry.CONFIGURED_FEATURE_REGISTRY);

    public static final RegistrySupplier<ConfiguredFeature<RandomPatchConfiguration, ?>> YJ_PATCH_GRASS = register("yj_patch_grass", Feature.RANDOM_PATCH, () -> VegetationFeatures.grassPatch(BlockStateProvider.simple(YJBlocks.YJ_GRASS.get()), 32));
    public static final RegistrySupplier<ConfiguredFeature<RandomPatchConfiguration, ?>> YJ_FLOWER_DEFAULT = register("yj_flower_default", Feature.RANDOM_PATCH, () -> VegetationFeatures.grassPatch(new WeightedStateProvider(createDefaultFlowerBuilder()), 64));
    public static final RegistrySupplier<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BB = register("patch_bb", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(YJBlocks.BB.get())), List.of(YJBlocks.YJ_DIRT.get())));
    public static final RegistrySupplier<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GB = register("patch_gb", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(YJBlocks.GB.get())), List.of(YJBlocks.YJ_DIRT.get())));
    public static final RegistrySupplier<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_RB = register("patch_rb", Feature.RANDOM_PATCH, () -> FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(YJBlocks.RB.get())), List.of(YJBlocks.YJ_DIRT.get())));

    private static SimpleWeightedRandomList.Builder<BlockState> createDefaultFlowerBuilder() {
        SimpleWeightedRandomList.Builder<BlockState> b = SimpleWeightedRandomList.builder();
        b.add(YJBlocks.YJ_ROSE.get().defaultBlockState(), 2);
        return b;
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistrySupplier<ConfiguredFeature<FC, ?>> register(String name, F feature, Supplier<FC> featureConfiguration) {
        return CONFIGURED_FEATURES.register(name, () -> new ConfiguredFeature(feature, featureConfiguration.get()));
    }

    public static void init() {
        CONFIGURED_FEATURES.register();
    }
}
