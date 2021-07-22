package net.morimori.yjsnpimod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.morimori.yjsnpimod.registry.YJSoundEvents;

import java.util.Random;

public class YJExplodingBlock extends Block {
    public static final IntegerProperty YJ_TIMER = YJBlockStateProperties.YJ_EX_TIMER;
    public static final BooleanProperty YJ_START = YJBlockStateProperties.YJ_EX_STARTED;

    public YJExplodingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(YJ_TIMER, 0).setValue(YJ_START, false));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (blockState.getValue(YJ_START))
            return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);

        if (!level.isClientSide())
            startIkisugi(blockState, level, blockPos);

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public void startIkisugi(BlockState blockState, LevelAccessor serverLevel, BlockPos blockPos) {
        if (blockState.getValue(YJ_START))
            return;
        serverLevel.setBlock(blockPos, blockState.setValue(YJ_START, true).setValue(YJ_TIMER, 0), 2);
        serverLevel.getBlockTicks().scheduleTick(blockPos, this, 0);
        serverLevel.playSound(null, blockPos, YJSoundEvents.YJ_IKISUGI_ONRY, SoundSource.BLOCKS, 3, 1);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(YJ_START, YJ_TIMER);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        if (!blockState.getValue(YJ_START))
            return;
        int cont = blockState.getValue(YJ_TIMER);
        if (cont >= 146) {
            serverLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 2);
            serverLevel.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 8.10F, Explosion.BlockInteraction.DESTROY);
        } else {
            if (cont == 141)
                serverLevel.playSound(null, blockPos, YJSoundEvents.YJ_NNA, SoundSource.BLOCKS, 3, 1);
            serverLevel.setBlock(blockPos, blockState.setValue(YJ_TIMER, cont + 1), 2);
            serverLevel.getBlockTicks().scheduleTick(blockPos, this, 0);
        }
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        super.neighborChanged(blockState, level, blockPos, block, blockPos2, bl);
        if (!level.isClientSide()) {
            
        }
    }
}