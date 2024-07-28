package net.morimori0317.yajusenpai.neoforge.mixin.data;

import net.minecraft.data.Main;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Main.class)
public class DataMainMixin {
    @Inject(at = @At("TAIL"), method = "main", remap = false)
    private static void mainInject(String[] strings, CallbackInfo ci) {
        System.exit(0);
    }
}
