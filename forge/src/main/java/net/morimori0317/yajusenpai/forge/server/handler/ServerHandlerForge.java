package net.morimori0317.yajusenpai.forge.server.handler;

import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori0317.yajusenpai.server.level.YJLootTables;

public class ServerHandlerForge {
    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent e) {
        YJLootTables.onLootTableModify(e.getLootTableManager(), e.getName(), (name, poolBuilder) -> e.getTable().addPool(poolBuilder.name(name.toString()).build()));
    }
}
