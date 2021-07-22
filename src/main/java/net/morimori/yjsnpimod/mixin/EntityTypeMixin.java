package net.morimori.yjsnpimod.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.morimori.yjsnpimod.entity.YJEntityTypes;
import net.morimori.yjsnpimod.util.DimensionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityType.class)
public class EntityTypeMixin<T extends Entity> {
    @Inject(method = "create(Lnet/minecraft/world/level/Level;)Lnet/minecraft/world/entity/Entity;", at = @At("HEAD"), cancellable = true)
    private void create(Level level, CallbackInfoReturnable<T> cir) {
        EntityType type = (EntityType<T>) (Object) this;
        if (type == EntityType.CAT && DimensionUtils.isYJDim(level)) {
            cir.setReturnValue((T) YJEntityTypes.KATYOU_CAT.create(level));
        }
    }
}