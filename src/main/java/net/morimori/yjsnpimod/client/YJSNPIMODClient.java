package net.morimori.yjsnpimod.client;

import net.fabricmc.api.ClientModInitializer;
import net.morimori.yjsnpimod.client.renderer.BlockRenderTypes;
import net.morimori.yjsnpimod.client.renderer.entity.YJEntityRenderers;

public class YJSNPIMODClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        YJEntityRenderers.init();
        BlockRenderTypes.init();
    }
}
