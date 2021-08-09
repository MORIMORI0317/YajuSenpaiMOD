package net.morimori.yjsnpimod.block.grower;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.morimori.yjsnpimod.world.YJFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class YJTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean bl) {
        if (random.nextInt(10) == 0) {
            return YJFeatures.FANCY_YJ_TREE;
        } else {
            return YJFeatures.YJ_TREE;
        }
    }
}
