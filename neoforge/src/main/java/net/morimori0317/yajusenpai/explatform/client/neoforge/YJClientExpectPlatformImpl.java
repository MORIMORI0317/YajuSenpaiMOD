package net.morimori0317.yajusenpai.explatform.client.neoforge;

import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.client.renderer.item.BEWLItemRenderer;
import net.morimori0317.yajusenpai.neoforge.client.renderer.item.ItemRendererRegisterNeoForge;

public class YJClientExpectPlatformImpl {
    public static void registerItemRenderer(ItemLike item, BEWLItemRenderer renderer) {
        ItemRendererRegisterNeoForge.register(item, renderer);
    }
}
