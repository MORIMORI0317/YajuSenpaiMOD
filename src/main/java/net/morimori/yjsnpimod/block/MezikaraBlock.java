package net.morimori.yjsnpimod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.morimori.yjsnpimod.YJSoundEvents;

public class MezikaraBlock extends Block {
    public MezikaraBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (worldIn.isBlockPowered(pos)) {
            worldIn.playSound((PlayerEntity) null, pos, YJSoundEvents.MEZIKARA_ALL, SoundCategory.BLOCKS, 3, 1);
        }
    }
}
