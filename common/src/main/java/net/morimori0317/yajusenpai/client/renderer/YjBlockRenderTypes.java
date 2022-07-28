package net.morimori0317.yajusenpai.client.renderer;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.RenderType;
import net.morimori0317.yajusenpai.block.YJBlocks;

public class YjBlockRenderTypes {
    public static void init() {
        RenderTypeRegistry.register(RenderType.cutout(), YJBlocks.YJ_SAPLING.get(), YJBlocks.YJ_GRASS.get(), YJBlocks.TALL_YJ_GRASS.get(), YJBlocks.YJ_ROSE.get());
    }
}
