package net.morimori0317.yajusenpai.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalFloatRef;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.block.YJSoundTypeFlags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Level.class)
public class LevelClientMixin {
    @Inject(method = "playLocalSound(Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V", at = @At("HEAD"))
    private void playLocalSoundInject(BlockPos blockPos, SoundEvent soundEvent, SoundSource soundSource, float f, float g, boolean bl, CallbackInfo ci, @Local(ordinal = 1, argsOnly = true) LocalFloatRef pitchRef) {
        boolean yjBreak = YJSoundTypeFlags.PLAY_BREAK_FLAG.get();
        YJSoundTypeFlags.PLAY_BREAK_FLAG.set(false);

        if (yjBreak) {
            pitchRef.set(1f);
        }
    }
}
