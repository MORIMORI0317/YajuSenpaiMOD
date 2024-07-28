package net.morimori0317.yajusenpai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.morimori0317.yajusenpai.sound.InmFamilySounds;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class MedikaraBlock extends InmBaseBlock {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public MedikaraBlock(Properties properties) {
        super(InmFamilySounds.YAJUSENPAI_MEDIKARA, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, false));
    }

    @Override
    public boolean triggerEvent(BlockState blockState, Level level, BlockPos blockPos, int i, int j) {
        if (!level.isClientSide())
            level.playSound(null, blockPos, YJSoundEvents.MEDIKARA_ALL.get(), SoundSource.VOICE, 8.1019f, 1f);
        return true;
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        boolean flg = level.hasNeighborSignal(blockPos);
        if (flg != blockState.getValue(POWERED)) {
            if (flg)
                level.playSound(null, blockPos, YJSoundEvents.MEDIKARA_ALL.get(), SoundSource.VOICE, 8.1019f, 1f);

            level.setBlock(blockPos, blockState.setValue(POWERED, flg), 3);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
}