package net.morimori0317.yajusenpai.entity;

import dev.architectury.registry.level.entity.trade.TradeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.block.YJBlocks;

public class YJVillagerTrades {
    public static void setup() {
        for (RegistrySupplier<Block> inmBlock : YJBlocks.INM_BLOCKS) {
            TradeRegistry.registerTradeForWanderingTrader(false, new InmBlockTrade(inmBlock));
        }
    }
}
