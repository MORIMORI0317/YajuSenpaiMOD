package net.morimori.yjsnpimod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.morimori.yjsnpimod.blockentity.YJPortalBlockEntity;
import net.morimori.yjsnpimod.registry.YJDimensions;
import net.morimori.yjsnpimod.util.YJUtils;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class YJPortalBlock extends BaseEntityBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 6.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    protected YJPortalBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (level instanceof ServerLevel && !entity.isPassenger() && !entity.isVehicle() && entity.canChangeDimensions() && Shapes.joinIsNotEmpty(Shapes.create(entity.getBoundingBox().move((double) (-blockPos.getX()), (double) (-blockPos.getY()), (double) (-blockPos.getZ()))), blockState.getShape(level, blockPos), BooleanOp.AND)) {
            ResourceKey<Level> resourceKey = YJUtils.isYJDim(level) ? Level.OVERWORLD : YJDimensions.getYJDimension(level.getServer());
            ServerLevel serverLevel = ((ServerLevel) level).getServer().getLevel(resourceKey);
            if (serverLevel == null) {
                return;
            }

            Random r = new Random();
            if (entity instanceof ServerPlayer serverPlayer) {
                serverPlayer.fallDistance = 0;
                serverPlayer.teleportTo(serverLevel, entity.getX() + r.nextInt(10) - 5, entity.getY(), entity.getZ() + r.nextInt(10) - 5, serverPlayer.getYRot(), serverPlayer.getVoicePitch());
            } else {
                entity.teleportTo(entity.getX() + r.nextInt(30) - 15, entity.getY(), entity.getZ() + r.nextInt(30) - 15);
                entity.changeDimension(serverLevel);
            }
        }
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canBeReplaced(BlockState blockState, Fluid fluid) {
        return false;
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, Random random) {
        double d = (double) blockPos.getX() + random.nextDouble();
        double e = (double) blockPos.getY() + 0.8D;
        double f = (double) blockPos.getZ() + random.nextDouble();
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
