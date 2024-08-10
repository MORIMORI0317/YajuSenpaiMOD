package net.morimori0317.yajusenpai.explatform.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.client.renderer.item.BEWLItemRenderer;

public class YJClientExpectPlatform {
    @ExpectPlatform
    public static void registerItemRenderer(ItemLike item, BEWLItemRenderer renderer) {
        throw new AssertionError();
    }
}
