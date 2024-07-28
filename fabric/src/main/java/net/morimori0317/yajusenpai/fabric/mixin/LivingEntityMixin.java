package net.morimori0317.yajusenpai.fabric.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.morimori0317.yajusenpai.handler.CommonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        CommonHandler.onLivingTick((LivingEntity) (Object) this);
    }

    @Inject(method = "dropAllDeathLoot",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;dropCustomDeathLoot(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;Z)V", shift = At.Shift.AFTER))
    private void dropAllDeathLoot(ServerLevel serverLevel, DamageSource damageSource, CallbackInfo ci) {
        LivingEntity ths = (LivingEntity) (Object) this;
        CommonHandler.onLivingDrop(ths, damageSource, ths::spawnAtLocation);
    }
}
