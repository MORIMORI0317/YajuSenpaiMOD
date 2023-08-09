package net.morimori0317.yajusenpai.mixin;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.morimori0317.yajusenpai.block.IYJFallingBlock;
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

    @Inject(method = "discard", at = @At("HEAD"))
    private void discard(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if (entity instanceof FallingBlockEntity && ((FallingBlockEntity) entity).getBlockState().getBlock() instanceof IYJFallingBlock) {
            int ct = btpCont % 3;
            entity.level()  .playSound(null, getX(), getY(), getZ(), YJSoundEvents.BUTIPA[ct].get(), getSoundSource(), 1, 1);
            btpCont++;
        }
    }
}
