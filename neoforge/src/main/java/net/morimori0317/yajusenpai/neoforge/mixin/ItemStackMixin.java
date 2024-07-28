package net.morimori0317.yajusenpai.neoforge.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalIntRef;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Inject(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/critereon/ItemDurabilityTrigger;trigger(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/item/ItemStack;I)V", ordinal = 0))
    private void hurtAndBreakInject(int j, ServerLevel arg, LivingEntity arg2, Consumer<Item> consumer, CallbackInfo ci, @Local(ordinal = 0, argsOnly = true) LocalIntRef damageRef) {
        if (arg2 instanceof ServerPlayer) {
            ServerHandler.onUpdateItemDamage(arg2, (ItemStack) (Object) this, YJUtils.refToVal(damageRef));
        }
    }

    @Inject(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;getDamageValue()I", ordinal = 1))
    private void hurtAndBreakInject2(int j, ServerLevel arg, LivingEntity arg2, Consumer<Item> consumer, CallbackInfo ci, @Local(ordinal = 0, argsOnly = true) LocalIntRef damageRef) {
        if (!(arg2 instanceof ServerPlayer)) {
            ServerHandler.onUpdateItemDamage(arg2, (ItemStack) (Object) this, YJUtils.refToVal(damageRef));
        }
    }

    @Inject(method = "hurtAndBreak(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/LivingEntity;Ljava/util/function/Consumer;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;shrink(I)V", ordinal = 0))
    private void hurtAndBreakInject3(int j, ServerLevel arg, LivingEntity arg2, Consumer<Item> consumer, CallbackInfo ci) {
        ServerHandler.onItemBreak(arg2, (ItemStack) (Object) this);
    }
}
