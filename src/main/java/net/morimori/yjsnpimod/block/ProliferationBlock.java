package net.morimori.yjsnpimod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.game.YJGamerules;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProliferationBlock extends Block {
    private boolean penetration;
    private boolean safety;
    public static final IntegerProperty PROLIFERATION = YJBlockStateProperties.PROLIFERATION_0_19;

    public ProliferationBlock(Properties properties, boolean penetration, boolean safety) {
        super(properties.tickRandomly());
        this.penetration = penetration;
        this.safety = safety;


        this.setDefaultState(this.stateContainer.getBaseState().with(PROLIFERATION, 0));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {

        builder.add(PROLIFERATION);

    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {


        if (worldIn.isRemote || !worldIn.getGameRules().getBoolean(YJGamerules.YJSNPI_BLOCK_PROLIFERATION) || (safety && state.get(PROLIFERATION) >= 19) || !Arrays.stream(Direction.values()).anyMatch(n -> canProlifetion(worldIn, pos.offset(n))))
            return;

        Arrays.stream(Direction.values()).filter(n -> canProlifetion(worldIn, pos.offset(n))).forEach(n -> worldIn.setBlockState(pos.offset(n), safety ? this.getDefaultState().with(PROLIFERATION, state.get(PROLIFERATION) + 1) : this.getDefaultState()));
        worldIn.playSound((PlayerEntity) null, pos, YJSoundEvents.YJ_NNA, SoundCategory.BLOCKS, 3, 1);
    }

    private boolean canProlifetion(ServerWorld worldIn, BlockPos pos) {

        if (safety) {
            List<LivingEntity> entitys = worldIn.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1), n -> n.isAlive());
            return worldIn.getBlockState(pos).getMaterial().isReplaceable() && entitys.isEmpty();
        }

        return penetration || worldIn.getBlockState(pos).getMaterial().isReplaceable();
    }
}
