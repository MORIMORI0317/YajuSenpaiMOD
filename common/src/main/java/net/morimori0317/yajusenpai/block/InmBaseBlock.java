package net.morimori0317.yajusenpai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiConsumer;

public class InmBaseBlock extends Block {
    public InmBaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onExplosionHit(BlockState blockState, Level level, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {

        if (!level.isClientSide() && explosion.canTriggerBlocks()) {
            level.playSound(null, blockPos, this.getSoundType(blockState).getHitSound(), SoundSource.BLOCKS, 5, 1);
        }

        super.onExplosionHit(blockState, level, blockPos, explosion, biConsumer);
    }
}
