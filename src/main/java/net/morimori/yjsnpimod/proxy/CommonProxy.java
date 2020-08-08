package net.morimori.yjsnpimod.proxy;

import net.minecraft.client.Minecraft;
import net.morimori.yjsnpimod.YJGamerules;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.world.worldgen.OreGeneration;
import red.felnull.otyacraftengine.api.registries.OERegistries;

public class CommonProxy {
    public void preInit() {
        OERegistries.registrierModColor(YJSNPIMOD.MODID, 9127187);
        YJGamerules.register();
        OreGeneration.init();
    }

    public void init() {

    }

    public void posInit() {

    }

    public Minecraft getMinecraft() {
        return null;
    }
}
