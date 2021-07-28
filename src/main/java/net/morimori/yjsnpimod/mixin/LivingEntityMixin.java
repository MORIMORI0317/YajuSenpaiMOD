package net.morimori.yjsnpimod.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.SoundType;
import net.morimori.yjsnpimod.block.YJSoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @ModifyVariable(method = "playBlockFallSound", ordinal = 0, at = @At("STORE"))
    private SoundType playBlockFallSound(SoundType soundType) {

        return soundType instanceof YJSoundType ? ((YJSoundType) soundType).getLowPitchSound() : soundType;
    }
}
