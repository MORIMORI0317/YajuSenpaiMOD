package net.morimori0317.yajusenpai.client;

import net.morimori0317.yajusenpai.client.renderer.YJBlockRenderTypes;
import net.morimori0317.yajusenpai.client.renderer.blockentity.YJBlockRenderers;
import net.morimori0317.yajusenpai.client.renderer.entity.YJEntityRenderers;
import net.morimori0317.yajusenpai.client.renderer.item.YJItemRenderers;
import net.morimori0317.yajusenpai.networking.YJPackets;

public class YajuSenpaiClient {

    public static void preInit() {
        YJEntityRenderers.init();
    }

    public static void init() {
        YJBlockRenderTypes.init();
        YJItemProperties.init();
        YJBlockRenderers.init();
        YJItemRenderers.init();

        YJPackets.clientInit();
    }
}
