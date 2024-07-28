package net.morimori0317.yajusenpai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.phys.BlockHitResult;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.function.BiConsumer;

public class YJExplodingBlock extends InmBaseBlock {
    public static final IntegerProperty YJ_TIMER = YJBlockStateProperties.YJ_EX_TIMER;
    public static final BooleanProperty YJ_START = YJBlockStateProperties.YJ_EX_STARTED;
    public static final BooleanProperty YJ_FIRE = YJBlockStateProperties.YJ_EX_FIRE;

    public YJExplodingBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(YJ_TIMER, 0).setValue(YJ_START, false).setValue(YJ_FIRE, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (blockState.getValue(YJ_START))
            return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);

        if (!level.isClientSide())
            startIkisugi(blockState, level, blockPos);

        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    public static void startIkisugi(BlockState blockState, LevelAccessor serverLevel, BlockPos blockPos, boolean fire) {
        if (!blockState.is(YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK.get()) || blockState.getValue(YJ_START))
            return;

        serverLevel.setBlock(blockPos, blockState.setValue(YJ_START, true).setValue(YJ_FIRE, fire).setValue(YJ_TIMER, 0), 2);
        serverLevel.scheduleTick(blockPos, YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK.get(), 0);
        serverLevel.playSound(null, blockPos, YJSoundEvents.YJ_IKISUGI_ONRY.get(), SoundSource.BLOCKS, 3, 1);
    }

    public static void startIkisugi(BlockState blockState, LevelAccessor serverLevel, BlockPos blockPos) {
        startIkisugi(blockState, serverLevel, blockPos, false);
    }

    public static boolean isFire(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos) {

        if (serverLevel.dimension() == Level.NETHER)
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
    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!blockState.is(YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK.get()) || !blockState.getValue(YJ_START))
            return;
        int cont = blockState.getValue(YJ_TIMER);
        if (cont >= 146) {
            serverLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 2);
            serverLevel.explode(null, blockPos.getX() + 0.5d, blockPos.getY() + 0.5d, blockPos.getZ() + 0.5d, 8.10F, blockState.getValue(YJ_FIRE) || isFire(blockState, serverLevel, blockPos), Level.ExplosionInteraction.BLOCK);
        } else {
            if (cont == 141 && !YJUtils.isYJDim(serverLevel))
                serverLevel.playSound(null, blockPos, YJSoundEvents.YJ_NNA.get(), SoundSource.BLOCKS, 3, 1);
            serverLevel.setBlock(blockPos, blockState.setValue(YJ_TIMER, cont + 1), 2);
            serverLevel.scheduleTick(blockPos, this, 0);
        }
    }

    @Override
    public void wasExploded(Level level, BlockPos blockPos, Explosion explosion) {
        if (!level.isClientSide) {
            level.setBlock(blockPos, this.defaultBlockState(), 2);
            startIkisugi(level.getBlockState(blockPos), level, blockPos, false /*explosion.fire*/);
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

    @Override
    public boolean dropFromExplosion(Explosion explosion) {
        return false;
    }

    @Override
    protected void onExplosionHit(BlockState blockState, Level level, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
        startIkisugi(blockState, level, blockPos);

        super.onExplosionHit(blockState, level, blockPos, explosion, biConsumer);
    }
}
