package net.morimori0317.yajusenpai.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.morimori0317.yajusenpai.client.YajuSenpaiClient;

public class YajuSenpaiClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        YajuSenpaiClient.init();
    }
}
