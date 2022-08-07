package net.morimori0317.yajusenpai.fabric.alchemy;

import net.minecraft.world.item.alchemy.PotionBrewing;
import net.morimori0317.yajusenpai.alchemy.YJPotions;

public class FabricBrewingSetup {
    public static void init() {
        YJPotions.setupBrewing(PotionBrewing::addMix);
    }
}
