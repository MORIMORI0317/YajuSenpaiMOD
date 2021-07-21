package net.morimori.yjsnpimod.client.renderer.entity;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.morimori.yjsnpimod.entity.YJEntityTypes;

public class YJEntityRenderers {
    public static void init() {
        EntityRendererRegistry.INSTANCE.register(YJEntityTypes.KATYOU_CAT, KatyouCatRenderer::new);
    }
}
