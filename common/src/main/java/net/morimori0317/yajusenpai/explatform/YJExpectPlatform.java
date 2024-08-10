package net.morimori0317.yajusenpai.explatform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;


public class YJExpectPlatform {
    @ExpectPlatform
    public static boolean isElytraItem(ItemStack stack) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isFood(ItemStack stack, LivingEntity livingEntity) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isAtuiBlock(Level level, BlockPos blockPos, BlockState state) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isOboreruBlock(Level level, BlockPos blockPos, BlockState state) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static SimpleParticleType createSimpleParticleType(boolean overrideLimiter) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isBoss(LivingEntity livingEntity) {
        throw new AssertionError();
    }
}
