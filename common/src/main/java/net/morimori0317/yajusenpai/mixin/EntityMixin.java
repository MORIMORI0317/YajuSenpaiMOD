package net.morimori0317.yajusenpai.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.block.IYJFallingBlock;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Unique
    private static int btpCont;

    @Shadow
    public abstract double getX();

    @Shadow
    public abstract double getY();

    @Shadow
    public abstract double getZ();

    @Shadow
    public abstract SoundSource getSoundSource();

    @Shadow
    public abstract boolean isSilent();

    @Shadow
    public Level level;

    @Inject(method = "discard", at = @At("HEAD"))
    private void discard(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if (entity instanceof FallingBlockEntity && ((FallingBlockEntity) entity).getBlockState().getBlock() instanceof IYJFallingBlock) {
            int ct = btpCont % 3;
            entity.level.playSound(null, getX(), getY(), getZ(), YJSoundEvents.BUTIPA[ct].get(), getSoundSource(), 1, 1);
            btpCont++;
        }
    }

    @Inject(method = "playSound(Lnet/minecraft/sounds/SoundEvent;FF)V", at = @At("HEAD"), cancellable = true)
    private void playSound(SoundEvent soundEvent, float f, float g, CallbackInfo ci) {
        SoundEvent newSound = null;
        if ((Entity) (Object) this instanceof LivingEntity livingEntity && livingEntity instanceof Player) {
            if (livingEntity.getItemInHand(livingEntity.getUsedItemHand()).is(YJItems.JAKEN_YORUIKIMASYOU_SHIELD.get())) {
                if (soundEvent == SoundEvents.SHIELD_BLOCK) {
                    newSound = YJSoundEvents.YJ_DAMEGE.get();
                } else if (soundEvent == SoundEvents.SHIELD_BREAK) {
                    newSound = YJSoundEvents.YJ_NNA.get();
                }
            }
        }
        if (newSound != null) {
            if (!this.isSilent())
                this.level.playSound(null, this.getX(), this.getY(), this.getZ(), newSound, this.getSoundSource(), f, g);
            ci.cancel();
        }
    }
}
