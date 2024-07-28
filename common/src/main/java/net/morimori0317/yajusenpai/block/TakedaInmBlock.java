package net.morimori0317.yajusenpai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.BiConsumer;

public class TakedaInmBlock extends InmBaseBlock {
    public TakedaInmBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        if (f > 4) {
            if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
                end(serverLevel, blockPos, entity);
            }
        } else {
            super.fallOn(level, blockState, blockPos, entity, f);
        }
    }

    public static void end(ServerLevel level, BlockPos blockPos, Entity entity) {
        if (!level.getBlockState(blockPos).is(YJBlocks.TAKEDA_INM_BLOCK.get())) {
            return;
        }

        level.destroyBlock(blockPos, true, entity);
    }

    @Override
    protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            end(serverLevel, blockHitResult.getBlockPos(), projectile.getOwner());
        }
    }

    @Override
    protected void onExplosionHit(BlockState blockState, Level level, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            end(serverLevel, blockPos, explosion.source);
        }
    }
}
