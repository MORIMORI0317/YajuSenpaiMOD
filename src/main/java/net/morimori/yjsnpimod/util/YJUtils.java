package net.morimori.yjsnpimod.util;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.block.YJExplodingBlock;
import net.morimori.yjsnpimod.registry.YJDimensions;

import java.util.Random;

public class YJUtils {
    public static boolean isYJDim(Level level) {
        return YJDimensions.YJ_DIMENSION_LOCATION.equals(level.dimension().location());
    }

    public static boolean yjRandom(Random random) {
        return 364 > random.nextInt(1919);
    }

    public static boolean veryYjRandom(Random random) {
        return 114514 > random.nextInt(1919810);
    }

    public static boolean isYJIkisugibleBlock(BlockState state) {
        return state.is(YJBlocks.YJSNPI_EXPLODING_BLOCK) && state.getValue(YJExplodingBlock.YJ_START);
    }
}
