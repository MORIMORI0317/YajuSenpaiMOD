package net.morimori0317.yajusenpai.fabric.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.effect.YJMobEffects;

public class YJRoseBlockFabric extends FlowerBlock {
    public YJRoseBlockFabric(MobEffect mobEffect, int i, Properties properties) {
        super(mobEffect, i, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return super.mayPlaceOn(blockState, blockGetter, blockPos) || blockState.is(YJBlockTags.INM_BLOCK);
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos blockPos, Entity entity) {
        if (!level.isClientSide && level.getDifficulty() != Difficulty.PEACEFUL) {
            if (entity instanceof LivingEntity livingEntity)
                livingEntity.addEffect(new MobEffectInstance(YJMobEffects.BEAST_FICTION.get(), 40));
        }
    }
}
