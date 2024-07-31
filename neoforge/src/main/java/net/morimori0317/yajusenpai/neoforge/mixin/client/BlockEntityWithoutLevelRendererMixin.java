package net.morimori0317.yajusenpai.neoforge.mixin.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.client.util.YJRenderUtils;
import net.morimori0317.yajusenpai.neoforge.client.renderer.item.ItemRendererRegisterNeoForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityWithoutLevelRenderer.class)
public class BlockEntityWithoutLevelRendererMixin {

    @Inject(method = "renderByItem", at = @At("HEAD"), cancellable = true)
    private void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay, CallbackInfo info) {
        var renderer = ItemRendererRegisterNeoForge.getRenderer(stack.getItem());
        if (renderer != null) {
            renderer.render(stack, displayContext, poseStack, multiBufferSource, YJRenderUtils.getPartialTicks(), light, overlay);
            info.cancel();
        }
    }
}