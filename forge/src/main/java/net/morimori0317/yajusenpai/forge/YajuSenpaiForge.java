package net.morimori0317.yajusenpai.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.client.YajuSenpaiClient;

@Mod(YajuSenpai.MODID)
public class YajuSenpaiForge {
    public YajuSenpaiForge() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        EventBuses.registerModEventBus(YajuSenpai.MODID, FMLJavaModLoadingContext.get().getModEventBus());
        YajuSenpai.init();
    }

    private void doClientStuff(FMLClientSetupEvent event) {
        YajuSenpaiClient.init();
    }
}
