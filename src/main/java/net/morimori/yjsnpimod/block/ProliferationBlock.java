package net.morimori.yjsnpimod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.morimori.yjsnpimod.YJSoundEvents;

import java.util.Arrays;
import java.util.Random;

public class ProliferationBlock extends Block {
    public ProliferationBlock(Properties properties) {
        super(properties.tickRandomly());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        boolean canPro = Arrays.stream(Direction.values()).anyMatch(n -> canProlifetion(worldIn, pos.offset(n)));

        if (!canPro)
            return;

        Arrays.stream(Direction.values()).forEach(n -> proliferationPlase(worldIn, pos.offset(n)));
        worldIn.playSound((PlayerEntity) null, pos, YJSoundEvents.YJ_NNA, SoundCategory.BLOCKS, 10, 1);

    }

    private boolean canProlifetion(ServerWorld worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos).getMaterial().isReplaceable();
    }

    private void proliferationPlase(ServerWorld worldIn, BlockPos pos) {
        if (canProlifetion(worldIn, pos)) {
            worldIn.setBlockState(pos, this.getDefaultState());
        }
    }
}
