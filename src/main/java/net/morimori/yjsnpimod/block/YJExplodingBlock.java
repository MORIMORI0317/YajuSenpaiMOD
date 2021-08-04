package net.morimori.yjsnpimod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.BlockHitResult;
import net.morimori.yjsnpimod.registry.YJSoundEvents;
import net.morimori.yjsnpimod.util.YJUtils;

import java.util.Random;

public class YJExplodingBlock extends Block {
    public static final IntegerProperty YJ_TIMER = YJBlockStateProperties.YJ_EX_TIMER;
    public static final BooleanProperty YJ_START = YJBlockStateProperties.YJ_EX_STARTED;
    public static final BooleanProperty YJ_FIRE = YJBlockStateProperties.YJ_EX_FIRE;

    public YJExplodingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(YJ_TIMER, 0).setValue(YJ_START, false).setValue(YJ_FIRE, false));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (blockState.getValue(YJ_START))
            return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);

        if (!level.isClientSide())
            startIkisugi(blockState, level, blockPos);

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public static void startIkisugi(BlockState blockState, LevelAccessor serverLevel, BlockPos blockPos, boolean fire) {
        if (!blockState.is(YJBlocks.YJSNPI_EXPLODING_BLOCK) || blockState.getValue(YJ_START))
            return;
        serverLevel.setBlock(blockPos, blockState.setValue(YJ_START, true).setValue(YJ_FIRE, fire).setValue(YJ_TIMER, 0), 2);
        serverLevel.getBlockTicks().scheduleTick(blockPos, YJBlocks.YJSNPI_EXPLODING_BLOCK, 0);
        serverLevel.playSound(null, blockPos, YJSoundEvents.YJ_IKISUGI_ONRY, SoundSource.BLOCKS, 3, 1);
    }

    public static void startIkisugi(BlockState blockState, LevelAccessor serverLevel, BlockPos blockPos) {
        startIkisugi(blockState, serverLevel, blockPos, false);
    }

    public static boolean isFire(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos) {

        if (serverLevel.dimension().location().equals(DimensionType.NETHER_LOCATION.location()))
            return true;

        for (Direction value : Direction.values()) {
            BlockState state = serverLevel.getBlockState(blockPos.relative(value));
            if (state.getBlock() instanceof BaseFireBlock || state.getFluidState().is(FluidTags.LAVA))
                return true;
        }

        return false;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(YJ_START, YJ_TIMER, YJ_FIRE);
    }

    @Override
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        if (!blockState.is(YJBlocks.YJSNPI_EXPLODING_BLOCK) || !blockState.getValue(YJ_START))
            return;
        int cont = blockState.getValue(YJ_TIMER);
        if (cont >= 146) {
            serverLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 2);
            serverLevel.explode(null, blockPos.getX() + 0.5d, blockPos.getY() + 0.5d, blockPos.getZ() + 0.5d, 8.10F, blockState.getValue(YJ_FIRE) || isFire(blockState, serverLevel, blockPos), Explosion.BlockInteraction.DESTROY);
        } else {
            if (cont == 141 && !YJUtils.isYJDim(serverLevel))
                serverLevel.playSound(null, blockPos, YJSoundEvents.YJ_NNA, SoundSource.BLOCKS, 3, 1);
            serverLevel.setBlock(blockPos, blockState.setValue(YJ_TIMER, cont + 1), 2);
            serverLevel.getBlockTicks().scheduleTick(blockPos, this, 0);
        }
    }

    @Override
    public void wasExploded(Level level, BlockPos blockPos, Explosion explosion) {
        if (!level.isClientSide) {
            level.setBlock(blockPos, this.defaultBlockState(), 2);
            startIkisugi(level.getBlockState(blockPos), level, blockPos, explosion.fire);
        }
    }

    @Override
    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState2, boolean bl) {
        if (!blockState2.is(blockState.getBlock())) {
            if (level.hasNeighborSignal(blockPos)) {
                startIkisugi(blockState, level, blockPos);
            }
        }
    }

    @Override
    public void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (level.hasNeighborSignal(blockPos)) {
            startIkisugi(blockState, level, blockPos);
        }
    }
}
