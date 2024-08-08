package net.morimori0317.yajusenpai.client.renderer;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.renderer.RenderType;
import net.morimori0317.yajusenpai.block.YJBlocks;

public class YJBlockRenderTypes {

    public static void init() {
        RenderTypeRegistry.register(RenderType.cutout(),
                YJBlocks.SHORT_YJ_GRASS.get(),
                YJBlocks.TALL_YJ_GRASS.get(),
                YJBlocks.YJ_ROSE.get(),
                YJBlocks.POTTED_YJ_ROSE.get(),
                YJBlocks.YJ_SAPLING.get(),
                YJBlocks.POTTED_YJ_SAPLING.get(),
                YJBlocks.POTATOES_SENPAI.get());
    }
}
