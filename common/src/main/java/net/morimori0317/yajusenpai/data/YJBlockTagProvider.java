package net.morimori0317.yajusenpai.data;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.BlockTagProviderWrapper;
import net.morimori0317.yajusenpai.explatform.data.YJDataExpectPlatform;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class YJBlockTagProvider extends BlockTagProviderWrapper {
    public YJBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, lookup, crossDataGeneratorAccess);
    }

    @Override
    public void generateTag(IntrinsicTagProviderAccess<Block> providerAccess) {
        providerAccess.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(YJBlocks.YJ_LOG.get(), YJBlocks.YJ_PLANKS.get(), YJBlocks.YJ_SLAB.get(), YJBlocks.YJ_STAIRS.get());

        providerAccess.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(YJBlocks.YJ_LEAVES.get());

        providerAccess.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(YJBlocks.YJ_STONE.get(), YJBlocks.YJ_DEEPSLATE.get(), YJBlocks.YJNIUM_ORE.get(),
                        YJBlocks.YAJUSENPAI_ORE.get(), YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get(),
                        YJBlocks.YJNIUM_BLOCK.get(), YJBlocks.RAW_YJNIUM_BLOCK.get(), YJBlocks.RAW_YAJUSENPAI_BLOCK.get(),
                        YJBlocks.YJ_HOUSE_DOOR.get(), YJBlocks.BB.get(), YJBlocks.GB.get(), YJBlocks.RB.get());

        providerAccess.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(YJBlocks.YJ_DIRT.get(), YJBlocks.YJ_SAND.get(), YJBlocks.YJ_GRAVEL.get());

        providerAccess.tag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(YJBlocks.YJ_DIRT.get());

        providerAccess.tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(YJBlocks.YJNIUM_BLOCK.get());

        providerAccess.tag(BlockTags.CROPS)
                .add(YJBlocks.POTATOES_SENPAI.get());

        providerAccess.tag(BlockTags.DIRT)
                .add(YJBlocks.YJ_DIRT.get());

        providerAccess.tag(BlockTags.DOORS)
                .add(YJBlocks.YJ_HOUSE_DOOR.get());

        providerAccess.tag(BlockTags.DRAGON_IMMUNE)
                .add(YJBlocks.BIG_PILLOW.get());

        providerAccess.tag(BlockTags.ENDERMAN_HOLDABLE)
                .add(YJBlocks.YJ_SAND.get(), YJBlocks.YJ_DIRT.get(), YJBlocks.YJ_GRAVEL.get())
                .addTag(YJBlockTags.INM_BLOCK);

        providerAccess.tag(BlockTags.LEAVES)
                .add(YJBlocks.YJ_LEAVES.get());

        providerAccess.tag(BlockTags.LOGS_THAT_BURN)
                .addTag(YJBlockTags.YJ_LOGS);

        providerAccess.tag(BlockTags.LUSH_GROUND_REPLACEABLE)
                .add(YJBlocks.YJ_SAND.get());

        providerAccess.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(YJBlocks.YJNIUM_BLOCK.get());

        providerAccess.tag(BlockTags.PLANKS)
                .add(YJBlocks.YJ_PLANKS.get());

        providerAccess.tag(BlockTags.PORTALS)
                .add(YJBlocks.YJ_PORTAL.get());

        providerAccess.tag(BlockTags.REPLACEABLE_BY_TREES)
                .add(YJBlocks.SHORT_YJ_GRASS.get(), YJBlocks.TALL_YJ_GRASS.get());

        providerAccess.tag(BlockTags.SAND)
                .add(YJBlocks.YJ_SAND.get());

        providerAccess.tag(BlockTags.SAPLINGS)
                .add(YJBlocks.YJ_SAPLING.get());

        providerAccess.tag(BlockTags.SMALL_FLOWERS)
                .add(YJBlocks.YJ_ROSE.get());

        providerAccess.tag(BlockTags.WOODEN_SLABS)
                .add(YJBlocks.YJ_SLAB.get());

        providerAccess.tag(BlockTags.WOODEN_STAIRS)
                .add(YJBlocks.YJ_STAIRS.get());


        providerAccess.tag(YJBlockTags.BASE_YJ_STONE_YJDIM)
                .add(YJBlocks.YJ_STONE.get(), YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(YJBlockTags.INM_BLOCK)
                .add(YJBlocks.NON_YJ_BLOCKS.stream().map(Supplier::get).toArray(Block[]::new))
                .addTag(YJBlockTags.YAJUSENPAI_BLOCK);

        providerAccess.tag(YJBlockTags.YJ_DEEPSLATE_ORE_REPLACEABLES)
                .add(YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(YJBlockTags.YJ_LOGS)
                .add(YJBlocks.YJ_LOG.get());

        providerAccess.tag(YJBlockTags.YJ_STONE_ORE_REPLACEABLES)
                .add(YJBlocks.YJ_STONE.get());

        providerAccess.tag(YJBlockTags.YJNIUM_ORES)
                .add(YJBlocks.YJNIUM_ORE.get(), YJBlocks.DEEPSLATE_YJNIUM_ORE.get());

        providerAccess.tag(YJBlockTags.YAJUSENPAI_ORES)
                .add(YJBlocks.YAJUSENPAI_BLOCK.get(), YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get());

        providerAccess.tag(YJBlockTags.YAJUSENPAI_BLOCK)
                .add(YJBlocks.YJ_BLOCKS.stream().map(Supplier::get).toArray(Block[]::new));

        providerAccess.tag(YJBlockTags.INM_BLOCK_REPLACEABLES)
                .add(Blocks.END_STONE)
                .addTags(ImmutableList.of(YJBlockTags.BASE_YJ_STONE_YJDIM, YJBlockTags.YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlockTags.YJ_STONE_ORE_REPLACEABLES))
                .addVanillaTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
                .addVanillaTag(BlockTags.STONE_ORE_REPLACEABLES)
                .addVanillaTag(BlockTags.BASE_STONE_NETHER)
                .addVanillaTag(BlockTags.BASE_STONE_OVERWORLD);

        providerAccess.tag(YJBlockTags.GO_IS_GOD)
                .add(YJBlocks.GO_BLOCK.get());

        YJDataExpectPlatform.generateBlockTag(providerAccess);
    }
}
