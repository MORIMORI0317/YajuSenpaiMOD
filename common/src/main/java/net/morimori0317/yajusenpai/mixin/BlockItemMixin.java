package net.morimori0317.yajusenpai.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.SoundType;
import net.morimori0317.yajusenpai.block.YJSoundType;
import net.morimori0317.yajusenpai.block.YJSoundTypeFlags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class BlockItemMixin {
    @Inject(method = "place",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V", ordinal = 0))
    private void placeInject(BlockPlaceContext blockPlaceContext, CallbackInfoReturnable<InteractionResult> cir, @Local(ordinal = 0) SoundType soundType) {
        if (soundType instanceof YJSoundType) {
            YJSoundTypeFlags.PLAY_PLACE_FLAG.set(true);
        }
    }

    @Inject(method = "place",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V", ordinal = 0, shift = At.Shift.AFTER))
    private void placeInject2(BlockPlaceContext blockPlaceContext, CallbackInfoReturnable<InteractionResult> cir) {
        YJSoundTypeFlags.PLAY_PLACE_FLAG.set(false);
    }
}
