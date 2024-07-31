package net.morimori0317.yajusenpai.mixin;

import net.minecraft.server.level.ServerPlayer;
import net.morimori0317.yajusenpai.entity.InariOtokoAccessor;
import net.morimori0317.yajusenpai.entity.InariOtokoEater;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin implements InariOtokoAccessor {
    @Unique
    private final InariOtokoEater yajuSenpai$inariOtokoEater = new InariOtokoEater();

    @Inject(method = "tick", at = @At("TAIL"))
    private void tickInject(CallbackInfo ci) {
        yajuSenpai$inariOtokoEater.tick((ServerPlayer) (Object) this);
    }

    @Override
    public InariOtokoEater yajuSenpai$getInariOtokoEater() {
        return this.yajuSenpai$inariOtokoEater;
    }
}
