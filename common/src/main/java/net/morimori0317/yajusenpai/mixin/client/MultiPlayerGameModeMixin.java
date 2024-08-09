package net.morimori0317.yajusenpai.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.SoundType;
import net.morimori0317.yajusenpai.block.YJSoundType;
import net.morimori0317.yajusenpai.block.YJSoundTypeFlags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {
    @Inject(method = "continueDestroyBlock",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F", ordinal = 0))
    private void continueDestroyBlockInject(BlockPos blockPos, Direction direction, CallbackInfoReturnable<Boolean> cir, @Local(ordinal = 0) SoundType soundType) {
        if (soundType instanceof YJSoundType) {
            YJSoundTypeFlags.PLAY_HIT_FLAG.set(true);
        }
    }

    @Inject(method = "continueDestroyBlock",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F", ordinal = 0, shift = At.Shift.AFTER))
    private void continueDestroyBlockInject2(BlockPos blockPos, Direction direction, CallbackInfoReturnable<Boolean> cir) {
        YJSoundTypeFlags.PLAY_HIT_FLAG.set(false);
    }
}
