package net.morimori0317.yajusenpai.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.morimori0317.yajusenpai.block.YJBlocks;

public class YJComposters {
    public static void setup() {
        ComposterBlock.add(0.3F, YJBlocks.YJ_SAPLING.get());
        ComposterBlock.add(0.3F, YJBlocks.YJ_LEAVES.get());
        ComposterBlock.add(0.3F, YJBlocks.SHORT_YJ_GRASS.get());
        ComposterBlock.add(0.5F, YJBlocks.TALL_YJ_GRASS.get());
        ComposterBlock.add(0.65F, YJBlocks.YJ_ROSE.get());
        ComposterBlock.add(0.65F, YJItems.APPLE_INM.get());
        ComposterBlock.add(0.65F, YJItems.POTATO_SENPAI.get());
        ComposterBlock.add(0.85F, YJItems.BAKED_POTATO_SENPAI.get());
        ComposterBlock.add(1F, YJItems.YJ_STAR.get());

        for (RegistrySupplier<Block> yjBlock : YJBlocks.YJ_BLOCKS) {
            ComposterBlock.add(0.3f, yjBlock.get());
        }

        for (RegistrySupplier<Block> yjBlock : YJBlocks.NON_YJ_BLOCKS) {
            ComposterBlock.add(0.1f, yjBlock.get());
        }
    }
}