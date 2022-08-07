package net.morimori0317.yajusenpai.client.renderer.entity;

import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import net.morimori0317.yajusenpai.entity.YJEntityTypes;

public class YJEntityRenderers {
    public static void init() {
        EntityRendererRegistry.register(YJEntityTypes.KATYOU_CAT, KatyouCatRenderer::new);
    }
}
