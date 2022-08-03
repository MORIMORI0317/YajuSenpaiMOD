package net.morimori0317.yajusenpai.mixin.client;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @Inject(method = "playSound(Lnet/minecraft/sounds/SoundEvent;FF)V", at = @At("HEAD"), cancellable = true)
    private void playSound(SoundEvent soundEvent, float f, float g, CallbackInfo ci) {
        SoundEvent newSound = null;
        var ths = (LocalPlayer) (Object) this;
        if (ths.getItemInHand(ths.getUsedItemHand()).is(YJItems.JAKEN_YORUIKIMASYOU_SHIELD.get())) {
            if (soundEvent == SoundEvents.SHIELD_BLOCK) {
                newSound = YJSoundEvents.YJ_DAMEGE.get();
            } else if (soundEvent == SoundEvents.SHIELD_BREAK) {
                newSound = YJSoundEvents.YJ_NNA.get();
            }
        }
        if (newSound != null) {
            ths.level.playLocalSound(ths.getX(), ths.getY(), ths.getZ(), newSound, ths.getSoundSource(), f, g, false);
            ci.cancel();
        }
    }
}
