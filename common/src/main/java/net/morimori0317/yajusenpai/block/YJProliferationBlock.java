package net.morimori0317.yajusenpai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.morimori0317.yajusenpai.sound.InmFamilySounds;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YJProliferationBlock extends InmBaseBlock {
    public static final IntegerProperty YJ_CONT = YJBlockStateProperties.YJ_PR_CONT;

    public YJProliferationBlock(Properties properties) {
        super(InmFamilySounds.YAJUSENPAI, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(YJ_CONT, 0));
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        super.randomTick(blockState, serverLevel, blockPos, randomSource);
        boolean flg = false;
        for (Direction value : Direction.values()) {
            BlockPos pos = blockPos.relative(value);
            if (serverLevel.getBlockState(pos).isAir()) {
                serverLevel.setBlockAndUpdate(pos, this.defaultBlockState().setValue(YJ_CONT, blockState.getValue(YJ_CONT) + 1));
                flg = true;
            }
        }
        if (flg) {
            serverLevel.playSound(null, blockPos, YJSoundEvents.YJ_PROLIFERATION.get(), SoundSource.BLOCKS, 3, 1);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(YJ_CONT) < 364;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(YJ_CONT);
    }

}