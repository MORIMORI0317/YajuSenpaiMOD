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
import net.morimori0317.yajusenpai.entity.YJLivingEntityAccessor;
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
public class LivingEntityMixin implements YJLivingEntityAccessor {

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
    public boolean yajuSenpai$isIkisugi() {
        return yajuSenpai$ikisugi;
    }

    @Override
    public void yajuSenpai$setIkisugi(boolean ikisugi) {
        this.yajuSenpai$ikisugi = ikisugi;
    }

    @Override
    public Entity yajuSenpai$getGrantedIkisugiEntity() {
        return yajuSenpai$grantedIkisugiEntity;
    }

    @Override
    public void yajuSenpai$setGrantedIkisugiEntity(Entity entity) {
        this.yajuSenpai$grantedIkisugiEntity = entity;
    }

    @Override
    public BlockPos yajuSenpai$getSleepingPos() {
        return yajuSenpai$sleepingPos;
    }

    @Override
    public void yajuSenpai$setSleepingPos(BlockPos sleepingPos) {
        this.yajuSenpai$sleepingPos = sleepingPos;
    }

    @Override
    public boolean yajuSenpai$isComa() {
        var ths = (LivingEntity) (Object) this;
        return ths.hasEffect(YJMobEffects.COMA.vanillaHolder()) || yajuSenpai$isComaSync();
    }

    @Override
    public void yajuSenpai$setComaSync(boolean comaSync) {
        this.yajuSenpai$comaSync = comaSync;
    }

    @Override
    public boolean yajuSenpai$isComaSync() {
        return yajuSenpai$comaSync;
    }

    @Override
    public boolean yajuSenpai$isIkisugiSleeping() {
        return yajuSenpai$ikisugiSleeping;
    }

    @Override
    public void yajuSenpai$setIkisugiSleeping(boolean ikisugiSleeping) {
        this.yajuSenpai$ikisugiSleeping = ikisugiSleeping;
    }

    @Override
    public void yajuSenpai$setYJPortalCoolDown(int coolDown) {
        this.yajuSenpai$yjPortalCoolDown = coolDown;
    }

    @Override
    public int yajuSenpai$getYJPortalCoolDown() {
        return this.yajuSenpai$yjPortalCoolDown;
    }

    @Override
    public boolean yajuSenpai$canYJPortalUse() {
        return yajuSenpai$yjPortalUse;
    }

    @Override
    public void yajuSenpai$setYJPortalUse(boolean use) {
        this.yajuSenpai$yjPortalUse = use;
    }
}
