package net.morimori.yjsnpimod.block.grower;

import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.morimori.yjsnpimod.biome.YJFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class YJTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(Random random, boolean bl) {
        return YJFeatures.YJ_TREE;
    }
}
