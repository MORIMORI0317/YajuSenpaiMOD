package net.morimori0317.yajusenpai.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.morimori0317.yajusenpai.block.YJFallingBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "discard", at = @At("HEAD"))
    private void discard(CallbackInfo ci) {
        Entity ths = (Entity) (Object) this;

        if (!ths.level().isClientSide() && ths instanceof FallingBlockEntity fallingBlockEntity &&
                fallingBlockEntity.getBlockState().getBlock() instanceof YJFallingBlock yjFallingBlock) {
            yjFallingBlock.buttippa(fallingBlockEntity);
        }
    }
}
