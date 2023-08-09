package net.morimori0317.yajusenpai.fabric.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.morimori0317.yajusenpai.handler.CommonHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo ci) {
        CommonHandler.onLivingTick((LivingEntity) (Object) this);
    }

    @Inject(method = "dropAllDeathLoot", at = @At("TAIL"))
    private void dropAllDeathLoot(DamageSource damageSource, CallbackInfo ci) {
        var ths = (LivingEntity) (Object) this;

        List<ItemEntity> drops = new ArrayList<>();
        CommonHandler.onLivingDrop(ths, damageSource, drops);

        for (ItemEntity drop : drops) {
            ths.level().addFreshEntity(drop);
        }
    }
}
