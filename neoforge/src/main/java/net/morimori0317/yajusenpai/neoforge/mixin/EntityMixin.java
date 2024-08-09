package net.morimori0317.yajusenpai.neoforge.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.morimori0317.yajusenpai.block.YJSoundType;
import net.morimori0317.yajusenpai.block.YJSoundTypeFlags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "playCombinationStepSounds",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F", ordinal = 0))
    private void playCombinationStepSoundsInject(BlockState arg, BlockState arg2, BlockPos primaryPos, BlockPos secondaryPos, CallbackInfo ci, @Local(ordinal = 0) SoundType soundType) {
        if (soundType instanceof YJSoundType) {
            YJSoundTypeFlags.PLAY_STEP_FLAG.set(true);
        }
    }

    @Inject(method = "playCombinationStepSounds",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F", ordinal = 0, shift = At.Shift.AFTER))
    private void playCombinationStepSoundsInject2(BlockState arg, BlockState arg2, BlockPos primaryPos, BlockPos secondaryPos, CallbackInfo ci) {
        YJSoundTypeFlags.PLAY_STEP_FLAG.set(false);
    }

    @Inject(method = "playMuffledStepSound",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F", ordinal = 0))
    private void playMuffledStepSoundInject(BlockState arg, BlockPos pos, CallbackInfo ci, @Local(ordinal = 0) SoundType soundType) {
        if (soundType instanceof YJSoundType) {
            YJSoundTypeFlags.PLAY_STEP_0_8_FLAG.set(true);
        }
    }

    @Inject(method = "playMuffledStepSound",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F", ordinal = 0, shift = At.Shift.AFTER))
    private void playMuffledStepSoundInject2(BlockState arg, BlockPos pos, CallbackInfo ci) {
        YJSoundTypeFlags.PLAY_STEP_0_8_FLAG.set(false);
    }


    @Inject(method = "playStepSound",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F", ordinal = 0))
    private void playStepSoundInject(BlockPos blockPos, BlockState blockState, CallbackInfo ci, @Local(ordinal = 0) SoundType soundType) {
        if (soundType instanceof YJSoundType) {
            YJSoundTypeFlags.PLAY_STEP_FLAG.set(true);
        }
    }

    @Inject(method = "playStepSound",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/SoundType;getPitch()F", ordinal = 0, shift = At.Shift.AFTER))
    private void playStepSoundInject2(BlockPos blockPos, BlockState blockState, CallbackInfo ci) {
        YJSoundTypeFlags.PLAY_STEP_FLAG.set(false);
    }
}
