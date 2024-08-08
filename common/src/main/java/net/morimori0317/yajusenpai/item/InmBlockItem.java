package net.morimori0317.yajusenpai.item;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.block.InmBlock;

public class InmBlockItem extends BlockItem {
    public InmBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void onDestroyed(ItemEntity itemEntity) {
        super.onDestroyed(itemEntity);

        if (this.getBlock() instanceof InmBlock inmBlock) {
            Level level = itemEntity.level();
            if (!level.isClientSide) {
                level.playSound(null, itemEntity.position().x, itemEntity.position().y, itemEntity.position().z, inmBlock.getInmFamilySound().die().get(), SoundSource.NEUTRAL, 5, 1);
            }
        }
    }


}
