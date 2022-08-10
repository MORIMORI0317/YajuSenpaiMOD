package net.morimori0317.yajusenpai.fabric;

import net.fabricmc.api.ModInitializer;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.fabric.alchemy.FabricBrewingSetup;
import net.morimori0317.yajusenpai.fabric.server.handler.ServerHandlerFabric;

public class YajuSenpaiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        YajuSenpai.init();
        YajuSenpai.setup();
        FabricBrewingSetup.init();
        ServerHandlerFabric.init();
    }
}
