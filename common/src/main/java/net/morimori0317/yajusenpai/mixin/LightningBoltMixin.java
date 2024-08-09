package net.morimori0317.yajusenpai.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.block.state.BlockState;
import net.morimori0317.yajusenpai.block.TakedaInmBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightningBolt.class)
public abstract class LightningBoltMixin {

    @Shadow
    protected abstract BlockPos getStrikePosition();

    @Inject(method = "tick",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LightningBolt;clearCopperOnLightningStrike(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;)V", shift = At.Shift.AFTER))
    private void tickInject(CallbackInfo ci) {
        LightningBolt ths = (LightningBolt) (Object) this;
        if (ths.level() instanceof ServerLevel serverLevel) {
            BlockPos blockPos = getStrikePosition();
            BlockState blockState = ths.level().getBlockState(blockPos);

            if (blockState.getBlock() instanceof TakedaInmBlock takedaInmBlock) {
                takedaInmBlock.end(serverLevel, blockPos, ths, null);
            }

            for (BlockPos pos : BlockPos.randomInCube(ths.level().random, 10, blockPos, 1)) {
                BlockState posState = ths.level().getBlockState(pos);
                if (posState.getBlock() instanceof TakedaInmBlock takedaInmBlock) {
                    takedaInmBlock.end(serverLevel, pos, ths, null);
                }
            }
        }
    }
}
