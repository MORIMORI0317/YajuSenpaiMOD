package net.morimori0317.yajusenpai;

import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.enchantment.YJEnchantments;
import net.morimori0317.yajusenpai.painting.YJPaintings;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YajuSenpai {
    public static final String MODID = "yajusenpai";

    public static void init() {
        YJSoundEvents.init();
        YJBlocks.init();
        YJEnchantments.init();
        YJPaintings.init();
        ServerHandler.init();
        //https://misode.github.io/dimension/
        //https://github.com/misode/vanilla-worldgen/tree/master/worldgen/biome
    }
}
