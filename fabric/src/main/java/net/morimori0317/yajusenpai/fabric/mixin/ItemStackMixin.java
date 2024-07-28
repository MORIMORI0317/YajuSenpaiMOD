package net.morimori0317.yajusenpai.fabric.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.ref.WeakReference;
import java.util.function.Consumer;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Unique
    private static final ThreadLocal<WeakReference<LivingEntity>> YJ_KATYOU_BROKEN_HURT_AND_BREAK_ENTITY_TMP = new ThreadLocal<>();

    @Unique
    private static final ThreadLocal<WeakReference<LivingEntity>> YJ_GABA_ANA_DADDY_HURT_AND_BREAK_ENTITY_TMP = new ThreadLocal<>();

    @Inject(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/critereon/ItemDurabilityTrigger;trigger(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/item/ItemStack;I)V", ordinal = 0))
    private void hurtAndBreakInject(int i, ServerLevel serverLevel, ServerPlayer serverPlayer, Consumer<Item> consumer, CallbackInfo ci, @Local(ordinal = 0, argsOnly = true) LocalIntRef damageRef) {
        if (serverPlayer != null) {
            YJ_KATYOU_BROKEN_HURT_AND_BREAK_ENTITY_TMP.remove();
            ServerHandler.onUpdateItemDamage(serverPlayer, (ItemStack) (Object) this, YJUtils.refToVal(damageRef));
        }
    }

    @Inject(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getDamageValue()I", ordinal = 1))
    private void hurtAndBreakInject2(int i, ServerLevel serverLevel, ServerPlayer serverPlayer, Consumer<Item> consumer, CallbackInfo ci, @Local(ordinal = 0, argsOnly = true) LocalIntRef damageRef) {
        if (serverPlayer == null) {
            WeakReference<LivingEntity> livingEntityRef = YJ_KATYOU_BROKEN_HURT_AND_BREAK_ENTITY_TMP.get();
            YJ_KATYOU_BROKEN_HURT_AND_BREAK_ENTITY_TMP.remove();

            if (livingEntityRef != null) {
                LivingEntity livingEntity = livingEntityRef.get();
                if (livingEntity != null) {
                    ServerHandler.onUpdateItemDamage(livingEntity, (ItemStack) (Object) this, YJUtils.refToVal(damageRef));
                }
            }
        }
    }

    @Inject(method = "hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V", ordinal = 0))
    private void hurtAndBreakInject3(int i, LivingEntity livingEntity, EquipmentSlot equipmentSlot, CallbackInfo ci) {
        if (!(livingEntity instanceof ServerPlayer)) {
            WeakReference<LivingEntity> weakEntity = new WeakReference<>(livingEntity);
            YJ_KATYOU_BROKEN_HURT_AND_BREAK_ENTITY_TMP.set(weakEntity);
            YJ_GABA_ANA_DADDY_HURT_AND_BREAK_ENTITY_TMP.set(weakEntity);
        }
    }

    @Inject(method = "hurtAndBreak(ILnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/EquipmentSlot;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V", shift = At.Shift.AFTER))
    private void hurtAndBreakInject4(int i, LivingEntity livingEntity, EquipmentSlot equipmentSlot, CallbackInfo ci) {
        YJ_KATYOU_BROKEN_HURT_AND_BREAK_ENTITY_TMP.remove();
        YJ_GABA_ANA_DADDY_HURT_AND_BREAK_ENTITY_TMP.remove();
    }

    @Inject(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/server/level/ServerPlayer;Ljava/util/function/Consumer;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;shrink(I)V", ordinal = 0))
    private void hurtAndBreakInject5(int i, ServerLevel serverLevel, ServerPlayer serverPlayer, Consumer<Item> consumer, CallbackInfo ci) {
        ItemStack ths = (ItemStack) (Object) this;
        if (serverPlayer != null) {
            YJ_GABA_ANA_DADDY_HURT_AND_BREAK_ENTITY_TMP.remove();
            ServerHandler.onItemBreak(serverPlayer, ths);
        } else {
            WeakReference<LivingEntity> livingEntityRef = YJ_GABA_ANA_DADDY_HURT_AND_BREAK_ENTITY_TMP.get();
            YJ_GABA_ANA_DADDY_HURT_AND_BREAK_ENTITY_TMP.remove();

            if (livingEntityRef != null) {
                LivingEntity livingEntity = livingEntityRef.get();
                if (livingEntity != null) {
                    ServerHandler.onItemBreak(livingEntity, ths);
                }
            }
        }
    }
}
