package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.morimori0317.yajusenpai.data.cross.provider.BlockLootTableProviderWrapper;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class WrappedBlockLootTableProvider extends LootTableProvider {
    private final BlockLootTableProviderWrapper blockLootTableProviderWrapper;

    public WrappedBlockLootTableProvider(PackOutput arg, BlockLootTableProviderWrapper blockLootTableProviderWrapper, CompletableFuture<HolderLookup.Provider> lookup) {
        super(arg, Set.of(), ImmutableList.of(new LootTableProvider.SubProviderEntry((lookupProvider) -> new WrappedBlockLootSubProvider(lookupProvider, blockLootTableProviderWrapper), LootContextParamSets.BLOCK)), lookup);
        this.blockLootTableProviderWrapper = blockLootTableProviderWrapper;
    }

    private static class WrappedBlockLootSubProvider extends BlockLootSubProvider {
        private final BlockLootTableProviderWrapper blockLootTableProviderWrapper;

        protected WrappedBlockLootSubProvider(HolderLookup.Provider lookupProvider, BlockLootTableProviderWrapper blockLootTableProviderWrapper) {
            super(ImmutableSet.of(), FeatureFlags.REGISTRY.allFlags(), lookupProvider);
            this.blockLootTableProviderWrapper = blockLootTableProviderWrapper;
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return blockLootTableProviderWrapper.getKnownBlocks();
        }

        @Override
        protected void generate() {
            blockLootTableProviderWrapper.generateBlockLootTables(this, new BlockLootTableProviderAccessImpl());
        }

        private class BlockLootTableProviderAccessImpl implements BlockLootTableProviderWrapper.BlockLootTableProviderAccess {
            @Override
            public void excludeFromStrictValidation(Block block) {

            }

            @Override
            public void dropSelf(Block block) {
                WrappedBlockLootSubProvider.this.dropSelf(block);
            }

            @Override
            public void dropOther(Block block, ItemLike itemLike) {
                WrappedBlockLootSubProvider.this.dropOther(block, itemLike);
            }

            @Override
            public void dropWhenSilkTouch(Block block) {
                WrappedBlockLootSubProvider.this.dropWhenSilkTouch(block);
            }

            @Override
            public void otherWhenSilkTouch(Block block, Block drop) {
                WrappedBlockLootSubProvider.this.otherWhenSilkTouch(block, drop);
            }

            @Override
            public void add(Block block, LootTable.Builder builder) {
                WrappedBlockLootSubProvider.this.add(block, builder);
            }

            @Override
            public HolderLookup.Provider registries() {
                return WrappedBlockLootSubProvider.this.registries;
            }

            @Override
            public Set<Item> explosionResistant() {
                return WrappedBlockLootSubProvider.this.explosionResistant;
            }
        }
    }
}
