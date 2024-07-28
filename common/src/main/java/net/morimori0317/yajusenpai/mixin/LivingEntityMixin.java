package net.morimori0317.yajusenpai.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.enchantment.YJEnchantmentEffectComponents;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.item.YJDataComponents;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin implements YJLivingEntity {

    @Unique
    private boolean yajuSenpai$ikisugi;
    @Unique
    private Entity yajuSenpai$grantedIkisugiEntity;
    @Unique
    private BlockPos yajuSenpai$sleepingPos;
    @Unique
    private boolean yajuSenpai$comaSync;
    @Unique
    private boolean yajuSenpai$ikisugiSleeping;
    @Unique
    private int yajuSenpai$yjPortalCoolDown;
    @Unique
    private boolean yajuSenpai$yjPortalUse;


    @Inject(method = "eat(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/food/FoodProperties;)Lnet/minecraft/world/item/ItemStack;",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playSound(Lnet/minecraft/world/entity/player/Player;DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V"))
    private void eatInject(Level level, ItemStack itemStack, FoodProperties foodProperties, CallbackInfoReturnable<ItemStack> cir) {
        if (itemStack.has(YJDataComponents.FUTOI_SEA_CHICKEN.get())) {
            level.playSound(null, (LivingEntity) (Object) this, YJSoundEvents.GABAANADADDY_OISHII.get(), SoundSource.NEUTRAL, 1f, 1f);
        }
    }

    @Inject(method = "hurt", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/world/entity/LivingEntity;playHurtSound(Lnet/minecraft/world/damagesource/DamageSource;)V"))
    private void hurt(DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir) {
        ServerHandler.onLivingHurtSound((LivingEntity) (Object) this, damageSource, f);
    }

    @Inject(method = "baseTick", at = @At(value = "HEAD"))
    private void baseTick(CallbackInfo ci) {
        var ths = (LivingEntity) (Object) this;
        if (!ths.level().isClientSide() && !ths.isOnFire()) {
            boolean kyn = false;

            for (EquipmentSlot slot : EquipmentSlot.values()) {
                ItemStack stack = ths.getItemBySlot(slot);

                if (EnchantmentHelper.has(stack, YJEnchantmentEffectComponents.KYN.get())) {
                    kyn = true;
                    break;
                }
            }

            if (kyn) {
                ths.igniteForSeconds(3);
            }
        }
    }

    @Override
    public boolean isIkisugi() {
        return yajuSenpai$ikisugi;
    }

    @Override
    public void setIkisugi(boolean ikisugi) {
        this.yajuSenpai$ikisugi = ikisugi;
    }

    @Override
    public Entity getGrantedIkisugiEntity() {
        return yajuSenpai$grantedIkisugiEntity;
    }

    @Override
    public void setGrantedIkisugiEntity(Entity entity) {
        this.yajuSenpai$grantedIkisugiEntity = entity;
    }

    @Override
    public BlockPos getSleepingPos() {
        return yajuSenpai$sleepingPos;
    }

    @Override
    public void setSleepingPos(BlockPos sleepingPos) {
        this.yajuSenpai$sleepingPos = sleepingPos;
    }

    @Override
    public boolean isComa() {
        var ths = (LivingEntity) (Object) this;
        return ths.hasEffect(YJMobEffects.COMA.vanillaHolder()) || isComaSync();
    }

    @Override
    public void setComaSync(boolean comaSync) {
        this.yajuSenpai$comaSync = comaSync;
    }

    @Override
    public boolean isComaSync() {
        return yajuSenpai$comaSync;
    }

    @Override
    public boolean isIkisugiSleeping() {
        return yajuSenpai$ikisugiSleeping;
    }

    @Override
    public void setIkisugiSleeping(boolean ikisugiSleeping) {
        this.yajuSenpai$ikisugiSleeping = ikisugiSleeping;
    }

    @Override
    public void setYJPortalCoolDown(int coolDown) {
        this.yajuSenpai$yjPortalCoolDown = coolDown;
    }

    @Override
    public int getYJPortalCoolDown() {
        return this.yajuSenpai$yjPortalCoolDown;
    }

    @Override
    public boolean canYJPortalUse() {
        return yajuSenpai$yjPortalUse;
    }

    @Override
    public void setYJPortalUse(boolean use) {
        this.yajuSenpai$yjPortalUse = use;
    }
}
