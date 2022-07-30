package net.morimori0317.yajusenpai.fabric.mixin;

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
}
