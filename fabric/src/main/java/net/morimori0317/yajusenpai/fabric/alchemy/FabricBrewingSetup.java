package net.morimori0317.yajusenpai.fabric.alchemy;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.morimori0317.yajusenpai.alchemy.YJPotions;

public class FabricBrewingSetup {
    public static void init() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> YJPotions.setupBrewing(builder::addMix));
    }
}
