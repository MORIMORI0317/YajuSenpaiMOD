package net.morimori.yjsnpimod.mixin;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.SoundType;
import net.morimori.yjsnpimod.block.YJSandBlock;
import net.morimori.yjsnpimod.block.YJSoundType;
import net.morimori.yjsnpimod.registry.YJSoundEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {
    private static int btpCont;

    @Shadow
    public abstract double getX();

    @Shadow
    public abstract double getY();

    @Shadow
    public abstract double getZ();

    @Shadow
    public abstract SoundSource getSoundSource();

    @Inject(method = "discard", at = @At("HEAD"))
    private void discard(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if (entity instanceof FallingBlockEntity && ((FallingBlockEntity) entity).getBlockState().getBlock() instanceof YJSandBlock) {
            int ct = btpCont % 3;
            SoundEvent soundEvent;
            if (ct == 0) {
                soundEvent = YJSoundEvents.YJ_BU;
            } else if (ct == 1) {
                soundEvent = YJSoundEvents.YJ_TI;
            } else {
                soundEvent = YJSoundEvents.YJ_PA;
            }
            entity.level.playSound(null, getX(), getY(), getZ(), soundEvent, getSoundSource(), 1, 1);
            btpCont++;
        }
    }

    @ModifyVariable(method = "playStepSound", ordinal = 0, at = @At("STORE"))
    private SoundType playStepSound(SoundType soundType) {
        return soundType instanceof YJSoundType ? ((YJSoundType) soundType).getNormalSound() : soundType;
    }
}
