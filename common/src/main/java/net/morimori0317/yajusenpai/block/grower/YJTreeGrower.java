package net.morimori0317.yajusenpai.block.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.morimori0317.yajusenpai.server.level.features.YJTreeFeatures;
import org.jetbrains.annotations.Nullable;

public class YJTreeGrower extends AbstractTreeGrower {

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean bl) {
        return YJTreeFeatures.YJ_TREE;
    }
}
