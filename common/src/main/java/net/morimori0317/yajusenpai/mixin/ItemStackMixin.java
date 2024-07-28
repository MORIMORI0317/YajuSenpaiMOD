package net.morimori0317.yajusenpai.mixin;

import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.server.handler.ServerHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Shadow
    public abstract boolean is(Item item);

    @Inject(method = "canBeHurtBy", at = @At("HEAD"), cancellable = true)
    private void canBeHurtByInject(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (this.is(YJItems.YJ_STAR.get()) && damageSource.is(DamageTypeTags.IS_EXPLOSION)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "inventoryTick", at = @At("TAIL"))
    private void inventoryTick(Level level, Entity entity, int i, boolean bl, CallbackInfo ci) {
        if (!level.isClientSide()) {
            ItemStack stack = (ItemStack) (Object) this;
            if (!stack.isEmpty()) {
                ServerHandler.onItemInventoryTick(level, entity, stack);
            }
        }
    }
}
