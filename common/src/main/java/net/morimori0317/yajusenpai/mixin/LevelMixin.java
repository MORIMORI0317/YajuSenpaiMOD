package net.morimori0317.yajusenpai.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalFloatRef;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.block.YJSoundTypeFlags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Level.class)
public class LevelMixin {
    @Inject(method = "playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V", at = @At("HEAD"))
    private void playLocalSoundInject(Player player, BlockPos blockPos, SoundEvent soundEvent, SoundSource soundSource, float f, float g, CallbackInfo ci, @Local(ordinal = 1, argsOnly = true) LocalFloatRef pitchRef) {
        boolean yjPlace = YJSoundTypeFlags.PLAY_PLACE_FLAG.get();
        YJSoundTypeFlags.PLAY_PLACE_FLAG.set(false);

        if (yjPlace) {
            pitchRef.set(1f);
        }
    }
}
