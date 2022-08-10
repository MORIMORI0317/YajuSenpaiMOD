package net.morimori0317.yajusenpai.item;

import net.minecraft.world.level.block.ComposterBlock;
import net.morimori0317.yajusenpai.block.YJBlocks;

public class YJComposters {
    public static void setup() {
        ComposterBlock.add(0.3F, YJBlocks.YJ_SAPLING.get());
        ComposterBlock.add(0.3F, YJBlocks.YJ_LEAVES.get());
        ComposterBlock.add(0.3F, YJBlocks.YJ_GRASS.get());
        ComposterBlock.add(0.5F, YJBlocks.TALL_YJ_GRASS.get());
        ComposterBlock.add(0.65F, YJBlocks.YJ_ROSE.get());
        ComposterBlock.add(0.65F, YJItems.APPLE.get());
        ComposterBlock.add(0.65F, YJItems.POTATO_SENPAI.get());
        ComposterBlock.add(0.85F, YJItems.BAKED_POTATO_SENPAI.get());
        ComposterBlock.add(1F, YJItems.YJ_STAR.get());
    }
}
