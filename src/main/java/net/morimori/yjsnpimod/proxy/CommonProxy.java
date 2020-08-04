package net.morimori.yjsnpimod.proxy;

import net.morimori.yjsnpimod.YJSNPIMOD;
import red.felnull.otyacraftengine.api.registries.OERegistries;

public class CommonProxy {
    public void preInit() {
        OERegistries.registrierModColor(YJSNPIMOD.MODID, 9127187);
    }

    public void init() {

    }

    public void posInit() {

    }
}
