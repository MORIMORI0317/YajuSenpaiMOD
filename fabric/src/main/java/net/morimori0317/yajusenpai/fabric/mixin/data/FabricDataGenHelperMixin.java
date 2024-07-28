package net.morimori0317.yajusenpai.fabric.mixin.data;

import net.fabricmc.fabric.impl.datagen.FabricDataGenHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FabricDataGenHelper.class)
public class FabricDataGenHelperMixin {
    @Inject(at = @At("TAIL"), method = "runInternal", remap = false)
    private static void runInternalInject(CallbackInfo ci) {
        System.exit(0);
    }
}
