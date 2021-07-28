package net.morimori.yjsnpimod.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.morimori.yjsnpimod.block.YJBlocks;

import java.util.HashMap;
import java.util.Map;

public class StructureReplace {
    public static final Map<Block, Block> DESERTPYRAMID = new HashMap<>();
    public static final Map<Block, Block> MONUMENT = new HashMap<>();

    public static void init() {
        DESERTPYRAMID.put(Blocks.TNT, YJBlocks.YJSNPI_EXPLODING_BLOCK);
        DESERTPYRAMID.put(Blocks.SANDSTONE, YJBlocks.YJSNPI_INTERVIEW_BLOCK);
        DESERTPYRAMID.put(Blocks.SANDSTONE_STAIRS, YJBlocks.YJSNPI_INTERVIEW_BLOCK);
        DESERTPYRAMID.put(Blocks.CUT_SANDSTONE, YJBlocks.YJSNPI_ENNUI_BLOCK);
        DESERTPYRAMID.put(Blocks.CHISELED_SANDSTONE, YJBlocks.YJSNPI_MEZIKARA_BLOCK);
        DESERTPYRAMID.put(Blocks.ORANGE_TERRACOTTA, YJBlocks.YJSNPI_NEHAN_BLOCK);
        DESERTPYRAMID.put(Blocks.BLUE_TERRACOTTA, YJBlocks.YJSNPI_IKISUGI_BLOCK);

        MONUMENT.put(Blocks.PRISMARINE_BRICKS, YJBlocks.YJSNPI_IKISUGI_BLOCK);
        MONUMENT.put(Blocks.PRISMARINE, YJBlocks.YJSNPI_GOMANETSU_BLOCK);
        MONUMENT.put(Blocks.SEA_LANTERN, YJBlocks.YJSNPI_EXPLODING_BLOCK);
        MONUMENT.put(Blocks.DARK_PRISMARINE, YJBlocks.YJSNPI_IKISUGI_BLOCK);
        MONUMENT.put(Blocks.WET_SPONGE, YJBlocks.YJSNPI_MEZIKARA_BLOCK);
        MONUMENT.put(Blocks.SPONGE, YJBlocks.YJSNPI_MEZIKARA_BLOCK);
        MONUMENT.put(Blocks.GOLD_BLOCK, Blocks.DIAMOND_BLOCK);
    }
}
