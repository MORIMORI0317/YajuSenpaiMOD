package net.morimori.yjsnpimod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.morimori.yjsnpimod.YJSNPIMOD;

import java.util.Random;

public class YJUtils {
    public static boolean isYJDim(Level level) {
        return new ResourceLocation(YJSNPIMOD.MODID, "yj_dimension").equals(level.dimension().location());
    }

    public static boolean yjRandom(Random random) {
        return 364 > random.nextInt(1919);
    }

    public static boolean veryYjRandom(Random random) {
        return 114514 > random.nextInt(1919810);
    }
}
