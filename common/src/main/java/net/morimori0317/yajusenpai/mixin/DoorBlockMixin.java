package net.morimori0317.yajusenpai.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.morimori0317.yajusenpai.block.YJHouseDoorBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DoorBlock.class)
public class DoorBlockMixin {
    @Inject(method = "playSound", at = @At("HEAD"), cancellable = true)
    private void playSound(Level level, BlockPos blockPos, boolean bl, CallbackInfo ci) {
        DoorBlock thi = (DoorBlock) (Object) this;
        if (thi instanceof YJHouseDoorBlock) {
            ci.cancel();
            level.playSound(null, blockPos, bl ? ((YJHouseDoorBlock) thi).getOpenSound() : ((YJHouseDoorBlock) thi).getCloseSound(), SoundSource.BLOCKS, 1, 1);
        }
    }
}