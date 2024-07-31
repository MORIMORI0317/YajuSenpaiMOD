package net.morimori0317.yajusenpai.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.morimori0317.yajusenpai.blockentity.YJPortalBlockEntity;
import net.morimori0317.yajusenpai.entity.YJLivingEntityAccessor;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.jetbrains.annotations.Nullable;

public class YJPortalBlock extends BaseEntityBlock {
    public static final MapCodec<YJPortalBlock> CODEC = simpleCodec(YJPortalBlock::new);
    protected static final VoxelShape SHAPE = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    protected YJPortalBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (level instanceof ServerLevel && entity instanceof ServerPlayer serverPlayer && ((YJLivingEntityAccessor) entity).yajuSenpai$canYJPortalUse() && !entity.isPassenger() && !entity.isVehicle() && entity.canUsePortal(false) && Shapes.joinIsNotEmpty(Shapes.create(entity.getBoundingBox().move((-blockPos.getX()), (-blockPos.getY()), (-blockPos.getZ()))), blockState.getShape(level, blockPos), BooleanOp.AND)) {
            ResourceKey<Level> resourceKey = YJUtils.isYJDim(level) ? Level.OVERWORLD : YJUtils.getYJDimension();
            ServerLevel serverLevel = ((ServerLevel) level).getServer().getLevel(resourceKey);
            if (serverLevel == null)
                return;

            YJLivingEntityAccessor yjLiving = (YJLivingEntityAccessor) entity;
            yjLiving.yajuSenpai$setYJPortalUse(false);
            yjLiving.yajuSenpai$setYJPortalCoolDown(20 * 3);

            serverPlayer.fallDistance = 0;
            serverPlayer.teleportTo(serverLevel, entity.getX(), entity.getY(), entity.getZ(), serverPlayer.getYRot(), serverPlayer.getVoicePitch());
        }
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, Fluid fluid) {
        return false;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        double d = (double) blockPos.getX() + randomSource.nextDouble();
        double e = (double) blockPos.getY() + 0.8D;
        double f = (double) blockPos.getZ() + randomSource.nextDouble();
        level.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new YJPortalBlockEntity(blockPos, blockState);
    }
}
