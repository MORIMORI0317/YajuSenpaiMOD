package net.morimori.yjsnpimod.client.renderer.blockentity;

import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.morimori.yjsnpimod.blockentity.YJBlockEntityTypes;

public class YJBlockRenderers {
    public static void init() {
        BlockEntityRendererRegistry.INSTANCE.register(YJBlockEntityTypes.YJ_PORTAL, context -> new YJPortalRenderer<>());
    }
}
