package net.morimori.yjsnpimod.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.Level;
import net.morimori.yjsnpimod.YJSNPIMOD;


public class YJDimensions {
    public static final ResourceLocation YJ_DIMENSION_LOCATION = new ResourceLocation(YJSNPIMOD.MODID, "yj_dimension");

    public static void init() {

    }

    public static ResourceKey<Level> getYJDimension(MinecraftServer server) {
        return server.levelKeys().stream().filter(n -> n.location().equals(YJ_DIMENSION_LOCATION)).findFirst().orElse(null);
    }

}
