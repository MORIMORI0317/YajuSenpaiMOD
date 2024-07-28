package net.morimori0317.yajusenpai.server.level.features;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.morimori0317.yajusenpai.block.YJBlocks;

import java.util.HashMap;
import java.util.Map;

public class StructurePieceReplace {
    public static final Supplier<Map<Block, Block>> REPLACES = Suppliers.memoize(() -> {
        Map<Block, Block> rep = new HashMap<>();

        rep.put(Blocks.TNT, YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK.get());
        rep.put(Blocks.SANDSTONE, YJBlocks.YAJUSENPAI_BLOCK.get());
        rep.put(Blocks.SANDSTONE_STAIRS, YJBlocks.YAJUSENPAI_BLOCK.get());
        rep.put(Blocks.CUT_SANDSTONE, YJBlocks.ENNUI_SENPAI_BLOCK.get());
        rep.put(Blocks.CHISELED_SANDSTONE, YJBlocks.MEDIKARA_SENPAI_BLOCK.get());
        rep.put(Blocks.ORANGE_TERRACOTTA, YJBlocks.NEHAN_SENPAI_BLOCK.get());
        rep.put(Blocks.BLUE_TERRACOTTA, YJBlocks.YAJUSENPAI_IKISUGI_BLOCK.get());
        rep.put(Blocks.COBBLESTONE, YJBlocks.YJ_STONE.get());
        rep.put(Blocks.MOSSY_COBBLESTONE, YJBlocks.YJ_STONE.get());
        rep.put(Blocks.OAK_LOG, YJBlocks.YJ_LOG.get());
        rep.put(Blocks.STRIPPED_OAK_LOG, YJBlocks.YJ_LOG.get());
        rep.put(Blocks.WHITE_TERRACOTTA, YJBlocks.YAJUSENPAI_BLOCK.get());
        rep.put(Blocks.SHORT_GRASS, YJBlocks.SHORT_YJ_GRASS.get());
        rep.put(Blocks.TALL_GRASS, YJBlocks.TALL_YJ_GRASS.get());
        rep.put(Blocks.GRASS_BLOCK, YJBlocks.YJ_DIRT.get());
        rep.put(Blocks.DIRT, YJBlocks.YJ_DIRT.get());
        rep.put(Blocks.DIRT_PATH, YJBlocks.YJ_GRAVEL.get());
        rep.put(Blocks.OAK_PLANKS, YJBlocks.YJ_PLANKS.get());
        rep.put(Blocks.HAY_BLOCK, YJBlocks.MEDIKARA_SENPAI_BLOCK.get());
        rep.put(Blocks.OAK_LEAVES, YJBlocks.YJ_LEAVES.get());
        rep.put(Blocks.VINE, Blocks.AIR);
        rep.put(Blocks.DISPENSER, YJBlocks.MEDIKARA_SENPAI_BLOCK.get());
        rep.put(Blocks.DROPPER, YJBlocks.MEDIKARA_SENPAI_BLOCK.get());
        rep.put(Blocks.CHISELED_STONE_BRICKS, YJBlocks.TON_BLOCK.get());
        rep.put(Blocks.DEEPSLATE, YJBlocks.YJ_DEEPSLATE.get());
        rep.put(Blocks.SCULK_VEIN, Blocks.AIR);
        rep.put(Blocks.SCULK_CATALYST, YJBlocks.MEDIKARA_SENPAI_BLOCK.get());
        rep.put(Blocks.END_STONE_BRICKS, YJBlocks.YAJUSENPAI_BLOCK.get());
        rep.put(Blocks.STONE_BRICKS, YJBlocks.YJ_STONE.get());
        rep.put(Blocks.MOSSY_STONE_BRICKS, YJBlocks.YJ_STONE.get());
        rep.put(Blocks.CRACKED_STONE_BRICKS, YJBlocks.YJ_STONE.get());
        rep.put(Blocks.INFESTED_STONE_BRICKS, YJBlocks.YJ_STONE.get());
        rep.put(Blocks.INFESTED_MOSSY_STONE_BRICKS, YJBlocks.YJ_STONE.get());
        rep.put(Blocks.INFESTED_CRACKED_STONE_BRICKS, YJBlocks.YJ_STONE.get());
        rep.put(Blocks.SPRUCE_PLANKS, YJBlocks.YJ_PLANKS.get());

        return rep;
    });

    public static final Supplier<Map<Block, Function<BlockState, BlockState>>> FUNC_REPLACES = Suppliers.memoize(() -> {
        Map<Block, Function<BlockState, BlockState>> rep = new HashMap<>();
        rep.put(Blocks.OAK_SLAB, n -> {
            var s = YJBlocks.YJ_SLAB.get().defaultBlockState();
            s = s.setValue(SlabBlock.TYPE, n.getValue(SlabBlock.TYPE));
            return s;
        });

        rep.put(Blocks.STONE_BRICK_SLAB, n -> {
            var s = YJBlocks.YJ_SLAB.get().defaultBlockState();
            s = s.setValue(SlabBlock.TYPE, n.getValue(SlabBlock.TYPE));
            return s;
        });

        rep.put(Blocks.SMOOTH_STONE_SLAB, n -> {
            var s = YJBlocks.YJ_SLAB.get().defaultBlockState();
            s = s.setValue(SlabBlock.TYPE, n.getValue(SlabBlock.TYPE));
            return s;
        });

        rep.put(Blocks.COBBLESTONE_STAIRS, n -> {
            var s = YJBlocks.YJ_STAIRS.get().defaultBlockState();
            s = s.setValue(StairBlock.HALF, n.getValue(StairBlock.HALF));
            s = s.setValue(StairBlock.SHAPE, n.getValue(StairBlock.SHAPE));
            s = s.setValue(StairBlock.FACING, n.getValue(StairBlock.FACING));
            return s;
        });

        rep.put(Blocks.OAK_STAIRS, n -> {
            var s = YJBlocks.YJ_STAIRS.get().defaultBlockState();
            s = s.setValue(StairBlock.HALF, n.getValue(StairBlock.HALF));
            s = s.setValue(StairBlock.SHAPE, n.getValue(StairBlock.SHAPE));
            s = s.setValue(StairBlock.FACING, n.getValue(StairBlock.FACING));
            return s;
        });

        rep.put(Blocks.STONE_BRICK_STAIRS, n -> {
            var s = YJBlocks.YJ_STAIRS.get().defaultBlockState();
            s = s.setValue(StairBlock.HALF, n.getValue(StairBlock.HALF));
            s = s.setValue(StairBlock.SHAPE, n.getValue(StairBlock.SHAPE));
            s = s.setValue(StairBlock.FACING, n.getValue(StairBlock.FACING));
            return s;
        });

        return rep;
    });
}
