package net.morimori.yjsnpimod.mixin;


import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.morimori.yjsnpimod.enchantment.YJEnchantments;
import net.morimori.yjsnpimod.registry.YJSoundEvents;
import net.morimori.yjsnpimod.util.EnchantmentUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow
    public abstract void setDamageValue(int i);

    @Shadow
    public abstract int getDamageValue();

    @Shadow
    public abstract int getMaxDamage();

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void hurt(int i, Random random, ServerPlayer serverPlayer, CallbackInfoReturnable<Boolean> cir) {
        if (serverPlayer != null) {
            if (EnchantmentUtils.hasEnchantment(YJEnchantments.KATYOU_CURSE, (ItemStack) (Object) this)) {
                SoundEvent soundEvents = YJSoundEvents.KATYOU;
                boolean brokenFlag = false;
                if (random.nextInt(10) == 0) {
                    soundEvents = YJSoundEvents.KATYOU_BROKEN;
                    brokenFlag = true;
                }
                serverPlayer.level.playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), soundEvents, SoundSource.NEUTRAL, 0.5f, 1);

                if (!brokenFlag) {
                    cir.setReturnValue(false);
                    return;
                }
                if (getDamageValue() != getMaxDamage())
                    this.setDamageValue(this.getMaxDamage());
            }
        }
    }

    @Inject(method = "hurt", at = @At("RETURN"), cancellable = true)
    private void hurt2(int i, Random random, ServerPlayer serverPlayer, CallbackInfoReturnable<Boolean> cir) {
        if (serverPlayer != null && cir.getReturnValue()) {
            List<ItemStack> items = new ArrayList<>();
            items.addAll(serverPlayer.getInventory().items);
            items.addAll(serverPlayer.getInventory().armor);
            AtomicReference<Float> val = new AtomicReference<>((float) 0);
            items.stream().filter(n -> EnchantmentUtils.hasEnchantment(YJEnchantments.OREMOITCHAU_CURSE, n)).filter(n -> !n.equals(this)).forEach(n -> {
                val.updateAndGet(v -> v + 1);
                n.shrink(1);
            });
            if (0 < val.get())
                serverPlayer.level.playSound(null, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), YJSoundEvents.OREMOITCHAU, SoundSource.NEUTRAL, val.get(), 1);
        }
    }
}