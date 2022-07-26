package net.morimori0317.yajusenpai.mixin;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "eat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"))
    private void eat(Level level, ItemStack itemStack, CallbackInfoReturnable<ItemStack> cir) {
        if (itemStack.getTag() != null && itemStack.getTag().getBoolean("futoi_sea_chicken")) {
            var ths = (LivingEntity) (Object) this;
            level.playSound(null, ths.getX(), ths.getY(), ths.getZ(), YJSoundEvents.GABAANADADDY_OISHII.get(), SoundSource.NEUTRAL, 1f, 1f);
        }
    }

    @Inject(method = "baseTick", at = @At(value = "HEAD"))
    private void baseTick(CallbackInfo ci) {
        var ths = (LivingEntity) (Object) this;
        if (!ths.level.isClientSide()) {
            boolean kf = false;
            for (ItemStack item : ths.getArmorSlots()) {
                if (YJUtils.hasKynEnchantment(item)) {
                    kf = true;
                    break;
                }
            }

            if (kf && !ths.isOnFire())
                ths.setSecondsOnFire(10);
        }
    }
}
