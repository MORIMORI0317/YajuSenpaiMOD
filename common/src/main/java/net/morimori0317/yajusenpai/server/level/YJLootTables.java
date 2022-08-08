package net.morimori0317.yajusenpai.server.level;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.item.YJItems;

public class YJLootTables {
    private static final ResourceLocation ZOMBIE = new ResourceLocation("entities/zombie");
    private static final ResourceLocation HUSK = new ResourceLocation("entities/husk");

    public static void onLootTableModify(LootTables lootManager, ResourceLocation id, LootTableModify modifyAccess) {
        if (ZOMBIE.equals(id) || HUSK.equals(id)) {
            var antennaPoolB = LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.025f / 3f))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer())
                    .add(LootItem.lootTableItem(YJItems.POTATO_SENPAI.get()));

            modifyAccess.addLootPool(new ResourceLocation(YajuSenpai.MODID, "potato_senpai"), antennaPoolB);
        }
    }

    public static interface LootTableModify {
        void addLootPool(ResourceLocation name, LootPool.Builder poolBuilder);
    }
}
