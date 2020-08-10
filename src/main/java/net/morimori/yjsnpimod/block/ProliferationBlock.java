package net.morimori.yjsnpimod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.morimori.yjsnpimod.YJGamerules;
import net.morimori.yjsnpimod.YJSoundEvents;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProliferationBlock extends Block {
    public static final IntegerProperty PROLIFERATION = YJBlockStateProperties.PROLIFERATION_0_19;
    private boolean penetration;
    private boolean safety;
    private boolean anti;

    public ProliferationBlock(Properties properties, boolean penetration, boolean safety, boolean anti) {
        super(properties.tickRandomly());
        this.penetration = penetration;
        this.safety = safety;
        this.anti = anti;
        this.setDefaultState(this.stateContainer.getBaseState().with(PROLIFERATION, 0));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(PROLIFERATION);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {

        if (anti && state.get(PROLIFERATION) >= 1) {
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
            worldIn.playSound((PlayerEntity) null, pos, YJSoundEvents.YJ_ANTIPROLIFERATION, SoundCategory.BLOCKS, 3, 1);
        }

        if (worldIn.isRemote || !worldIn.getGameRules().getBoolean(YJGamerules.YJSNPI_BLOCK_PROLIFERATION) || (safety && state.get(PROLIFERATION) >= 19) || !Arrays.stream(Direction.values()).anyMatch(n -> canProlifetion(worldIn, pos.offset(n))))
            return;


        Arrays.stream(Direction.values()).filter(n -> canProlifetion(worldIn, pos.offset(n))).forEach(n -> worldIn.setBlockState(pos.offset(n), safety || anti ? this.getDefaultState().with(PROLIFERATION, (anti ? 0 : state.get(PROLIFERATION)) + 1) :
                this.getDefaultState()));
        worldIn.playSound((PlayerEntity) null, pos, anti ? YJSoundEvents.YJ_ANTIPROLIFERATION : YJSoundEvents.YJ_PROLIFERATION, SoundCategory.BLOCKS, 3, 1);
        if (anti) {
            worldIn.setBlockState(pos, this.getDefaultState().with(PROLIFERATION, 1));
        }
    }

    private boolean canProlifetion(ServerWorld worldIn, BlockPos pos) {

        if (anti) {
            return YJBlockTags.PROLIFERATION.func_230235_a_(worldIn.getBlockState(pos).getBlock());
        }

        if (YJBlockTags.ANTI_PROLIFERATION.func_230235_a_(worldIn.getBlockState(pos).getBlock())) {
            return false;
        }

        if (safety) {
            List<LivingEntity> entitys = worldIn.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1), n -> n.isAlive());
            return worldIn.getBlockState(pos).getMaterial().isReplaceable() && entitys.isEmpty();
        }

        return penetration || worldIn.getBlockState(pos).getMaterial().isReplaceable();
    }
}
