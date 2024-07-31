package net.morimori0317.yajusenpai.client.renderer.item;

import net.morimori0317.yajusenpai.block.YJBlocks;

public class YJItemRenderers {
    public static void init() {
        ItemRendererRegister.register(YJBlocks.GO_BLOCK.get(), new GoBlockItemRenderer());
    }
}
