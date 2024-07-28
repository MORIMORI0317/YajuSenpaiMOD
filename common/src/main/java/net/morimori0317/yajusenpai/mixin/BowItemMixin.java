package net.morimori0317.yajusenpai.mixin;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.enchantment.YJEnchantmentEffectComponents;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BowItem.class)
public class BowItemMixin {
    @Inject(method = "releaseUsing", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V", shift = At.Shift.AFTER))
    private void releaseUsingInject(ItemStack itemStack, Level level, LivingEntity livingEntity, int i, CallbackInfo ci) {
        if (EnchantmentHelper.has(itemStack, YJEnchantmentEffectComponents.GABA_ANA_DADDY.get()) && livingEntity.getRandom().nextInt(10) == 0) {
            level.playSound(null, livingEntity, YJSoundEvents.GABAANADADDY_ARCHER.get(), SoundSource.PLAYERS, 1f, 1f);
        }
    }
}
