package net.morimori0317.yajusenpai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.morimori0317.yajusenpai.particles.YJParticleTypes;
import net.morimori0317.yajusenpai.sound.InmFamilySounds;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

import java.util.function.BiConsumer;

public class TakedaInmBlock extends InmBlock {
    public static final BooleanProperty END = YJBlockStateProperties.END;

    public TakedaInmBlock(Properties properties) {
        super(InmFamilySounds.TAKEDA_INM, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(END, false));
    }

    @Override
    public void fallOn(Level level, BlockState blockState, BlockPos blockPos, Entity entity, float f) {
        if (f > 4) {
            if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
                end(serverLevel, blockPos, entity, entity.position());
            }
        } else {
            super.fallOn(level, blockState, blockPos, entity, f);
        }
    }

    public void end(ServerLevel level, BlockPos blockPos, Entity entity, Vec3 loc) {
        if (!level.getBlockState(blockPos).is(this) || level.getBlockState(blockPos).getValue(END)) {
            return;
        }

        if (loc == null) {
            level.destroyBlock(blockPos, false, entity);
            Vec3 pos = blockPos.getCenter();
            level.sendParticles(YJParticleTypes.TAKEDA_END.get(),
                    pos.x,
                    pos.y,
                    pos.z,
                    0, 0, 0, 0, 0);
        } else {
            level.playSound(null, blockPos, YJSoundEvents.TAKEDA_INM_BLOOD.get(), SoundSource.BLOCKS, 5, 1);
            level.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, Blocks.REDSTONE_BLOCK.defaultBlockState()),
                    loc.x(),
                    loc.y(),
                    loc.z(),
                    35, 0,
                    0, 0, 1f);

            level.setBlock(blockPos, level.getBlockState(blockPos).setValue(END, true), 3);
            level.scheduleTick(blockPos, this, 5);
        }

    }

    @Override
    protected void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        if (!blockState.is(this) || !blockState.getValue(END)) {
            return;
        }

        serverLevel.destroyBlock(blockPos, false);

        Vec3 pos = blockPos.getCenter();
        serverLevel.sendParticles(YJParticleTypes.TAKEDA_END.get(),
                pos.x,
                pos.y,
                pos.z,
                0, 0, 0, 0, 0);

    }

    @Override
    protected void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult, Projectile projectile) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel && projectile.getType() != EntityType.WIND_CHARGE) {
            end(serverLevel, blockHitResult.getBlockPos(), projectile.getOwner(),
                    blockHitResult.getLocation());
        }
    }

    @Override
    protected void onExplosionHit(BlockState blockState, Level level, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            end(serverLevel, blockPos, explosion.source, null);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(END);
    }

    @Override
    public void onHeadEquipmentDie(Level level, LivingEntity livingEntity) {
        super.onHeadEquipmentDie(level, livingEntity);

        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(YJParticleTypes.TAKEDA_END.get(),
                    livingEntity.position().x,
                    livingEntity.position().y + livingEntity.getEyeHeight(),
                    livingEntity.position().z,
                    0, 0, 0, 0, 0);
        }
    }
}
