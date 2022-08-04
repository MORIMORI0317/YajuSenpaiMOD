package net.morimori0317.yajusenpai.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class FoiledBlockItem extends BlockItem {
    public FoiledBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return true;
    }
}