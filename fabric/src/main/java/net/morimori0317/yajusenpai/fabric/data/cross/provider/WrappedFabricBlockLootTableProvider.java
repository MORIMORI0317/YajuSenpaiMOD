package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.morimori0317.yajusenpai.data.cross.provider.BlockLootTableProviderWrapper;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WrappedFabricBlockLootTableProvider extends FabricBlockLootTableProvider {
    private final BlockLootTableProviderWrapper blockLootTableProviderWrapper;

    public WrappedFabricBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup, BlockLootTableProviderWrapper blockLootTableProviderWrapper) {
        super(dataOutput, registryLookup);
        this.blockLootTableProviderWrapper = blockLootTableProviderWrapper;
    }

    @Override
    public void generate() {
        blockLootTableProviderWrapper.generateBlockLootTables(this, new BlockLootTableProviderAccessImpl());
    }

    @Override
    public LootTable.Builder createLeavesDrops(Block block, Block block2, float... fs) {
        return super.createLeavesDrops(block, block2, fs);
    }

    private class BlockLootTableProviderAccessImpl implements BlockLootTableProviderWrapper.BlockLootTableProviderAccess {
        @Override
        public void excludeFromStrictValidation(Block block) {
            WrappedFabricBlockLootTableProvider.this.excludeFromStrictValidation(block);
        }

        @Override
        public void dropSelf(Block block) {
            WrappedFabricBlockLootTableProvider.this.dropSelf(block);
        }

        @Override
        public void dropOther(Block block, ItemLike itemLike) {
            WrappedFabricBlockLootTableProvider.this.dropOther(block, itemLike);
        }

        @Override
        public void dropWhenSilkTouch(Block block) {
            WrappedFabricBlockLootTableProvider.this.dropWhenSilkTouch(block);
        }

        @Override
        public void otherWhenSilkTouch(Block block, Block drop) {
            WrappedFabricBlockLootTableProvider.this.otherWhenSilkTouch(block, drop);
        }

        @Override
        public void add(Block block, LootTable.Builder builder) {
            WrappedFabricBlockLootTableProvider.this.add(block, builder);
        }

        @Override
        public HolderLookup.Provider registries() {
            return WrappedFabricBlockLootTableProvider.this.registries;
        }

        @Override
        public Set<Item> explosionResistant() {
            return WrappedFabricBlockLootTableProvider.this.explosionResistant;
        }
    }
}
