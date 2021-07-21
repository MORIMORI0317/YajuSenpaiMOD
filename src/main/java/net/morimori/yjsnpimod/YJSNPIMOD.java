package net.morimori.yjsnpimod;

import net.fabricmc.api.ModInitializer;
import net.morimori.yjsnpimod.biome.YJBiomes;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.registry.YJMotives;
import net.morimori.yjsnpimod.registry.YJSoundEvents;

public class YJSNPIMOD implements ModInitializer {
    public static final String MODID = "yjsnpimod";

    @Override
    public void onInitialize() {
        YJItems.init();
        YJBlocks.init();
        YJSoundEvents.init();
        YJMotives.init();
        YJBiomes.init();
    }
}
