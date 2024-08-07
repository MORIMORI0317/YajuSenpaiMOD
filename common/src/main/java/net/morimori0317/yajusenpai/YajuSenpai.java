package net.morimori0317.yajusenpai;

import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import net.morimori0317.yajusenpai.alchemy.YJPotions;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.blockentity.YJBlockEntityTypes;
import net.morimori0317.yajusenpai.client.YajuSenpaiClient;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.enchantment.YJEnchantmentEffectComponents;
import net.morimori0317.yajusenpai.entity.YJEntityTypes;
import net.morimori0317.yajusenpai.entity.YJVillagerTrades;
import net.morimori0317.yajusenpai.item.*;
import net.morimori0317.yajusenpai.networking.YJPackets;
import net.morimori0317.yajusenpai.particles.YJParticleTypes;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomeModifications;
import net.morimori0317.yajusenpai.server.level.structure.YJStructurePieceType;
import net.morimori0317.yajusenpai.server.level.structure.YJStructureTypes;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YajuSenpai {
    public static final String MODID = "yajusenpai";

    public static void init() {
        YJSoundEvents.init();
        YJMobEffects.init();
        YJPotions.init();
        YJArmorMaterials.init();
        YJCreativeModeTabs.init();
        YJBlocks.init();
        YJItems.init();
        YJDataComponents.init();
        YJEnchantmentEffectComponents.init();
        YJBlockEntityTypes.init();
        YJEntityTypes.init();
        YJStructureTypes.init();
        YJStructurePieceType.init();
        YJParticleTypes.init();

        ServerHandler.init();
        YJBiomeModifications.init();

        EnvExecutor.runInEnv(Env.CLIENT, () -> YajuSenpaiClient::preInit);
        EnvExecutor.runInEnv(Env.SERVER, () -> YJPackets::serverInit);
    }

    public static void setup() {
        YJComposters.setup();
        YJVillagerTrades.setup();
    }
}
