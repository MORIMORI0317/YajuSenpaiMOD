package net.morimori0317.yajusenpai;

import net.morimori0317.yajusenpai.alchemy.YJPotions;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.blockentity.YJBlockEntityTypes;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.enchantment.YJEnchantments;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.painting.YJPaintings;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import net.morimori0317.yajusenpai.server.world.features.YJOreFeatures;
import net.morimori0317.yajusenpai.server.world.features.YJTreeFeatures;
import net.morimori0317.yajusenpai.server.world.features.YJVegetationFeatures;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YajuSenpai {
    public static final String MODID = "yajusenpai";

    public static void init() {
        YJSoundEvents.init();
        YJMobEffects.init();
        YJPotions.init();
        YJBlocks.init();
        YJBlockEntityTypes.init();
        YJItems.init();
        YJEnchantments.init();
        YJPaintings.init();
        ServerHandler.init();
        YJTreeFeatures.init();
        YJOreFeatures.init();
        YJVegetationFeatures.init();

        //https://misode.github.io/dimension/
        //https://github.com/misode/vanilla-worldgen/tree/master/worldgen/biome
    }
}
