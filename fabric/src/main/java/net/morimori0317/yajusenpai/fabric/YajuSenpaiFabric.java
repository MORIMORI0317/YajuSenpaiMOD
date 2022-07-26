package net.morimori0317.yajusenpai.fabric;

import net.fabricmc.api.ModInitializer;
import net.morimori0317.yajusenpai.YajuSenpai;

public class YajuSenpaiFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        YajuSenpai.init();
    }
}
