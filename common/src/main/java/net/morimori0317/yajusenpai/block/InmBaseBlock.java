package net.morimori0317.yajusenpai.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.morimori0317.yajusenpai.sound.InmFamilySound;

import java.util.function.BiConsumer;

public class InmBaseBlock extends Block {
    private final InmFamilySound inmFamilySound;

    public InmBaseBlock(InmFamilySound inmFamilySound, Properties properties) {
        super(properties);
        this.inmFamilySound = inmFamilySound;
    }

    @Override
    protected void onExplosionHit(BlockState blockState, Level level, BlockPos blockPos, Explosion explosion, BiConsumer<ItemStack, BlockPos> biConsumer) {

        if (!level.isClientSide() && explosion.canTriggerBlocks()) {
            level.playSound(null, blockPos, this.getSoundType(blockState).getHitSound(), SoundSource.BLOCKS, 5, 1);
        }

        super.onExplosionHit(blockState, level, blockPos, explosion, biConsumer);
    }

    public void onHeadEquipmentDamage(Level level, LivingEntity livingEntity) {
        level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), inmFamilySound.damage().get(), SoundSource.NEUTRAL, 3, 1);
    }

    public void onHeadEquipmentDie(Level level, LivingEntity livingEntity) {
        level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), inmFamilySound.die().get(), SoundSource.NEUTRAL, 3, 1);
    }

    public void onAttack(Level level, LivingEntity livingEntity) {
        level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), inmFamilySound.attack().get(), SoundSource.NEUTRAL, 3, 1);
    }
}
