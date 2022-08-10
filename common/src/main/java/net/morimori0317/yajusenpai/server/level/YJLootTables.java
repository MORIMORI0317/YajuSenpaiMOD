package net.morimori0317.yajusenpai.server.level;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.item.YJItems;

public class YJLootTables {
    private static final ResourceLocation ZOMBIE = new ResourceLocation("entities/zombie");
    private static final ResourceLocation ZOMBIE_VILLAGER = new ResourceLocation("entities/zombie_villager");
    private static final ResourceLocation HUSK = new ResourceLocation("entities/husk");

    public static void onLootTableModify(LootTables lootManager, ResourceLocation id, LootTableModify modifyAccess) {
        if (ZOMBIE.equals(id) || HUSK.equals(id) || ZOMBIE_VILLAGER.equals(id)) {
            var pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.025f / 3f))
                    .when(LootItemKilledByPlayerCondition.killedByPlayer())
                    .add(LootItem.lootTableItem(YJItems.POTATO_SENPAI.get()));

            modifyAccess.addLootPool(new ResourceLocation(YajuSenpai.MODID, "potato_senpai"), pool);
        }

        if (id.getPath().startsWith("chests/") || id.getPath().startsWith("gameplay/")) {
            var pool = LootPool.lootPool().setRolls(UniformGenerator.between(1, 3))
                    .when(LootItemRandomChanceCondition.randomChance(0.114514f));

            for (RegistrySupplier<Block> inm_block : YJBlocks.INM_BLOCKs) {
                pool = pool.add(LootItem.lootTableItem(inm_block.get()));
            }

            pool = pool.add(LootItem.lootTableItem(YJBlocks.YJSNPI_EXPLODING_BLOCK.get()));
            pool = pool.add(LootItem.lootTableItem(YJBlocks.YJSNPI_PROLIFERATION_BLOCK.get()));

            modifyAccess.addLootPool(new ResourceLocation(YajuSenpai.MODID, "inm_blocks"), pool);
        }
    }

    public static interface LootTableModify {
        void addLootPool(ResourceLocation name, LootPool.Builder poolBuilder);
    }
}
