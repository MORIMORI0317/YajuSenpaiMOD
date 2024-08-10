package net.morimori0317.yajusenpai.explatform.client.fabric;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.client.renderer.item.BEWLItemRenderer;
import net.morimori0317.yajusenpai.client.util.YJRenderUtils;

public class YJClientExpectPlatformImpl {
    public static void registerItemRenderer(ItemLike item, BEWLItemRenderer renderer) {
        BuiltinItemRendererRegistry.INSTANCE.register(item, (stack, mode, matrices, vertexConsumers, light, overlay) ->
                renderer.render(stack, mode, matrices, vertexConsumers, YJRenderUtils.getPartialTicks(), light, overlay));
    }
}
