package net.morimori0317.yajusenpai.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.morimori0317.yajusenpai.item.YJToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockBehaviour.class)
public class BlockBehaviourMixin {
    @Inject(method = "spawnAfterBreak", at = @At("HEAD"))
    private void spawnAfterBreakInject(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, ItemStack itemStack, boolean bl, CallbackInfo ci) {
        if (itemStack.getItem() instanceof YJToolItem) {
            YJToolItem.breakBlock(serverLevel, blockPos);
        }
    }
}
