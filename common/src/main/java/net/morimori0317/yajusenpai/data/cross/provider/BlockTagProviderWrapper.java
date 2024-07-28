package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public abstract class BlockTagProviderWrapper extends IntrinsicHolderTagsProviderWrapper<Block, IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block>> {
    private final TagsProvider<Block> blockTagsProvider;

    public BlockTagProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, lookup, crossDataGeneratorAccess);
        this.blockTagsProvider = crossDataGeneratorAccess.createBlockTagProvider(packOutput, lookup, this);
    }

    @Override
    public Function<Block, ResourceKey<Block>> getKeyExtractor() {
        return (block) -> block.builtInRegistryHolder().key();
    }

    @Override
    public TagsProvider<Block> getProvider() {
        return blockTagsProvider;
    }
}
