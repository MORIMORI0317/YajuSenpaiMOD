package net.morimori0317.yajusenpai.server.level.features;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJTreeFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> YJ_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, YJUtils.modLoc("yj_tree"));

    private static TreeConfiguration.TreeConfigurationBuilder createYJTree() {
        return TreeFeatures.createStraightBlobTree(YJBlocks.YJ_LOG.get(), YJBlocks.YJ_LEAVES.get(), 5, 4, 1, 3).ignoreVines();
    }

    public static void registerBuilder(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(YJ_TREE, new ConfiguredFeature<>(Feature.TREE, createYJTree().build()));
    }
}
