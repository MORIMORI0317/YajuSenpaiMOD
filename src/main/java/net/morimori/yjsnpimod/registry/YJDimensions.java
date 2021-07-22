package net.morimori.yjsnpimod.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.morimori.yjsnpimod.YJSNPIMOD;


public class YJDimensions {
    public static final ResourceKey<Level> YJ_WORLD_KEY = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(YJSNPIMOD.MODID, "yj_dimension"));

    public static void init() {

    }

}
