package net.morimori.yjsnpimod.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;

public class SimpleFoiledBlockItem extends BlockItem {
    public SimpleFoiledBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
