package net.morimori.yjsnpimod.proxy;

import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.game.YJGamerules;
import red.felnull.otyacraftengine.api.registries.OERegistries;

public class CommonProxy {
    public void preInit() {
        OERegistries.registrierModColor(YJSNPIMOD.MODID, 9127187);
        YJGamerules.register();
    }

    public void init() {

    }

    public void posInit() {

    }
}
