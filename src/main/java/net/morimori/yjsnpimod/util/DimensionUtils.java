package net.morimori.yjsnpimod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class DimensionUtils {
    public static boolean isYJDim(Level level) {
        return new ResourceLocation(YJSNPIMOD.MODID, "yj_dimension").equals(level.dimension().location());
    }
}
