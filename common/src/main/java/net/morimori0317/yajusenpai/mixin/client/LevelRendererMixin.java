package net.morimori0317.yajusenpai.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.morimori0317.yajusenpai.block.YJSoundType;
import net.morimori0317.yajusenpai.block.YJSoundTypeFlags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {
    @Inject(method = "levelEvent",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getBreakSound()Lnet/minecraft/sounds/SoundEvent;", ordinal = 0))
    private void levelEventInject(int i, BlockPos blockPos, int j, CallbackInfo ci, @Local(ordinal = 0) SoundType soundType) {
        if (soundType instanceof YJSoundType) {
            YJSoundTypeFlags.PLAY_BREAK_FLAG.set(true);
        }
    }

    @Inject(method = "levelEvent",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ClientLevel;playLocalSound(Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V", ordinal = 41, shift = At.Shift.AFTER))
    private void levelEventInject2(int i, BlockPos blockPos, int j, CallbackInfo ci) {
        YJSoundTypeFlags.PLAY_BREAK_FLAG.set(false);
    }
}
