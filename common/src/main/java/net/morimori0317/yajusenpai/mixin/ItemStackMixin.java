package net.morimori0317.yajusenpai.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow
    public abstract int getMaxDamage();

    @Shadow
    public abstract void setDamageValue(int i);

    @Inject(method = "hurt", at = @At("HEAD"))
    private void hurt(int i, RandomSource randomSource, ServerPlayer serverPlayer, CallbackInfoReturnable<Boolean> cir) {
        if (serverPlayer != null && YJUtils.hasKatyouEnchantment((ItemStack) (Object) this)) {
            SoundEvent soundEvents = YJSoundEvents.KATYOU.get();
            boolean brokenFlag = false;
            if (randomSource.nextInt(30) == 0) {
                soundEvents = YJSoundEvents.KATYOU_BROKEN.get();
                brokenFlag = true;
            }
            serverPlayer.level.playSound(null, serverPlayer, soundEvents, SoundSource.NEUTRAL, 0.5f, 1);

            if (brokenFlag) this.setDamageValue(this.getMaxDamage());
        }
    }


    @Inject(method = "hurt", at = @At("RETURN"))
    private void hurt2(int i, RandomSource randomSource, ServerPlayer serverPlayer, CallbackInfoReturnable<Boolean> cir) {
        if (serverPlayer != null && cir.getReturnValue()) {
            List<ItemStack> items = new ArrayList<>();
            var ths = (ItemStack) (Object) this;
            items.addAll(serverPlayer.getInventory().items);
            items.addAll(serverPlayer.getInventory().armor);
            items.add(serverPlayer.getOffhandItem());
            float[] val = new float[1];
            items.stream().filter(YJUtils::hasGabaAnaDaddyEnchantment).filter(n -> n != ths).forEach(n -> {
                val[0]++;
                n.shrink(1);
            });
            if (0 < val[0])
                serverPlayer.level.playSound(null, serverPlayer, YJSoundEvents.GABAANADADDY_OREMOITCHAU.get(), SoundSource.NEUTRAL, val[0], 1);
        }
    }

    @Inject(method = "hurt", at = @At("RETURN"))
    private void hurt3(int i, RandomSource randomSource, ServerPlayer serverPlayer, CallbackInfoReturnable<Boolean> cir) {
        if (serverPlayer != null && YJUtils.hasGabaAnaDaddyEnchantment((ItemStack) (Object) this) && cir.getReturnValue())
            serverPlayer.level.playSound(null, serverPlayer, YJSoundEvents.GABAANADADDY_IKUYO.get(), SoundSource.NEUTRAL, 0.5f, 1);
    }

    @Inject(method = "inventoryTick", at = @At("TAIL"))
    private void inventoryTick(Level level, Entity entity, int i, boolean bl, CallbackInfo ci) {
        if (!level.isClientSide() && entity instanceof ServerPlayer serverPlayer && YJUtils.hasGabaAnaDaddyEnchantment((ItemStack) (Object) this))
            ServerHandler.futoiSeaChickenTick(serverPlayer);
    }

}
