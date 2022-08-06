package net.morimori0317.yajusenpai.client.renderer.blockentity;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.morimori0317.yajusenpai.blockentity.YJBlockEntityTypes;

public class YJBlockRenderers {
    public static void init() {
        BlockEntityRendererRegistry.register(YJBlockEntityTypes.YJ_PORTAL.get(), context -> new YJPortalRenderer<>());
    }
}
