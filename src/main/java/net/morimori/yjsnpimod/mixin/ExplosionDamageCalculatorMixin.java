package net.morimori.yjsnpimod.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.block.YJExplodingBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ExplosionDamageCalculator.class)
public class ExplosionDamageCalculatorMixin {
    @Inject(method = "getBlockExplosionResistance", at = @At("HEAD"), cancellable = true)
    private void getBlockExplosionResistance(Explosion explosion, BlockGetter blockGetter, BlockPos blockPos, BlockState blockState, FluidState fluidState, CallbackInfoReturnable<Optional<Float>> cir) {
        if (blockState.is(YJBlocks.YJSNPI_EXPLODING_BLOCK) && blockState.getValue(YJExplodingBlock.YJ_START))
            cir.setReturnValue(blockState.isAir() && fluidState.isEmpty() ? Optional.empty() : Optional.of(Math.max(114514, fluidState.getExplosionResistance())));
    }
}
