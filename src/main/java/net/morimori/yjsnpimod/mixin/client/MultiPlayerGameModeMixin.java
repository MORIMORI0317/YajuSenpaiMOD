package net.morimori.yjsnpimod.mixin.client;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.world.level.block.SoundType;
import net.morimori.yjsnpimod.block.YJSoundType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MultiPlayerGameMode.class)
public class MultiPlayerGameModeMixin {
    @ModifyVariable(method = "continueDestroyBlock", ordinal = 0, at = @At("STORE"))
    private SoundType continueDestroyBlock(SoundType soundType) {
        return soundType instanceof YJSoundType ? ((YJSoundType) soundType).getHighPitchSound() : soundType;
    }
}
