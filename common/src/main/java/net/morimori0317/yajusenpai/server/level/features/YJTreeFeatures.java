package net.morimori0317.yajusenpai.server.level.features;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;

import java.util.function.Function;
import java.util.function.Supplier;

public class YJTreeFeatures {
    private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(YajuSenpai.MODID, Registry.CONFIGURED_FEATURE_REGISTRY);
    public static final Function<RegistrySupplier<ConfiguredFeature<TreeConfiguration, ?>>, Holder<ConfiguredFeature<TreeConfiguration, ?>>> HOLDER = Util.memoize(n -> Holder.direct(n.get()));
    public static final RegistrySupplier<ConfiguredFeature<TreeConfiguration, ?>> YJ_TREE = register("yj_tree", Feature.TREE, () -> createYJTree().build());

    public static void init() {
        CONFIGURED_FEATURES.register();
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistrySupplier<ConfiguredFeature<FC, ?>> register(String name, F feature, Supplier<FC> featureConfiguration) {
        return CONFIGURED_FEATURES.register(name, () -> new ConfiguredFeature(feature, featureConfiguration.get()));
    }

    private static TreeConfiguration.TreeConfigurationBuilder createYJTree() {
        return TreeFeatures.createStraightBlobTree(YJBlocks.YJ_LOG.get(), YJBlocks.YJ_LEAVES.get(), 5, 4, 1, 3).ignoreVines();
    }
}
