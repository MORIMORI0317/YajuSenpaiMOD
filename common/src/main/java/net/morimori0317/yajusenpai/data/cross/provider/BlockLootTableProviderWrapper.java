package net.morimori0317.yajusenpai.data.cross.provider;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public abstract class BlockLootTableProviderWrapper extends DataProviderWrapper<DataProvider> {
    private final DataProvider blockLootTableProvider;

    public BlockLootTableProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
        this.blockLootTableProvider = crossDataGeneratorAccess.createBlockLootTableProvider(packOutput, lookup, this);
    }

    @Override
    public DataProvider getProvider() {
        return blockLootTableProvider;
    }

    public abstract void generateBlockLootTables(BlockLootSubProvider blockLoot, BlockLootTableProviderAccess providerAccess);

    public abstract Iterable<Block> getKnownBlocks();

    protected Iterable<Block> extract(DeferredRegister<Block> deferredRegister) {
        List<Block> blocks = new ArrayList<>();
        deferredRegister.iterator().forEachRemaining(r -> blocks.add(r.get()));
        return blocks;
    }

    public static interface BlockLootTableProviderAccess {
        void excludeFromStrictValidation(Block block);

        void dropSelf(Block block);

        void dropOther(Block block, ItemLike itemLike);

        void dropWhenSilkTouch(Block block);

        void otherWhenSilkTouch(Block block, Block drop);

        void add(Block block, LootTable.Builder builder);

        HolderLookup.Provider registries();

        Set<Item> explosionResistant();
    }
}
