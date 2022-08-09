package net.morimori0317.yajusenpai.mixin.client;

import net.minecraft.client.resources.ClientPackSource;
import net.minecraft.server.packs.repository.Pack;
import net.morimori0317.yajusenpai.client.resources.YJClientPackSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(ClientPackSource.class)
public class ClientPackSourceMixin {
    @Inject(method = "loadPacks", at = @At("TAIL"))
    private void loadPacks(Consumer<Pack> consumer, Pack.PackConstructor packConstructor, CallbackInfo ci) {
        Pack pack = YJClientPackSource.createHighResolutionTexturePack(packConstructor);
        if (pack != null)
            consumer.accept(pack);
    }
}
