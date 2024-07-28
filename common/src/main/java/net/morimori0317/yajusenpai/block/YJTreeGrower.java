package net.morimori0317.yajusenpai.block;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.morimori0317.yajusenpai.server.level.features.YJTreeFeatures;

import java.util.Optional;

public class YJTreeGrower {
    public static final TreeGrower YJ_TREE = new TreeGrower("yj_tree", Optional.empty(), Optional.of(YJTreeFeatures.YJ_TREE), Optional.empty());
}
