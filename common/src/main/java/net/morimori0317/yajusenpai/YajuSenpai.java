package net.morimori0317.yajusenpai;

import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import net.morimori0317.yajusenpai.alchemy.YJPotions;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.blockentity.YJBlockEntityTypes;
import net.morimori0317.yajusenpai.client.YajuSenpaiClient;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.enchantment.YJEnchantments;
import net.morimori0317.yajusenpai.entity.YJEntityTypes;
import net.morimori0317.yajusenpai.item.YJComposters;
import net.morimori0317.yajusenpai.item.YJCreativeModeTabs;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import net.morimori0317.yajusenpai.server.level.structure.YJStructurePieceType;
import net.morimori0317.yajusenpai.server.level.structure.YJStructureTypes;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YajuSenpai {
    public static final String MODID = "yajusenpai";

    public static void init() {
        YJSoundEvents.init();
        YJMobEffects.init();
        YJPotions.init();
        YJCreativeModeTabs.init();
        YJBlocks.init();
        YJEntityTypes.init();
        YJItems.init();
        YJBlockEntityTypes.init();
        YJEnchantments.init();
        ServerHandler.init();
        YJStructureTypes.init();
        YJStructurePieceType.init();

        EnvExecutor.runInEnv(Env.CLIENT, () -> YajuSenpaiClient::preInit);
        //https://misode.github.io/dimension/
        //https://github.com/misode/vanilla-worldgen/tree/master/worldgen/biome
    }

    public static void setup() {
        YJComposters.setup();
    }
}
