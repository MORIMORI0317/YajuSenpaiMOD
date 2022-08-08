package net.morimori0317.yajusenpai.fabric.server.handler;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.morimori0317.yajusenpai.server.level.YJLootTables;

public class ServerHandlerFabric {
    public static void init() {
        LootTableEvents.MODIFY.register(ServerHandlerFabric::onLootTableModify);
    }

    private static void onLootTableModify(ResourceManager resourceManager, LootTables lootManager, ResourceLocation id, LootTable.Builder tableBuilder, LootTableSource source) {
        YJLootTables.onLootTableModify(lootManager, id, (name, poolBuilder) -> tableBuilder.withPool(poolBuilder));
    }
}
