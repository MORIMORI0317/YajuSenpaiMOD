package net.morimori0317.yajusenpai.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.client.YajuSenpaiClient;
import net.morimori0317.yajusenpai.forge.handler.CommonHandlerForge;

@Mod(YajuSenpai.MODID)
public class YajuSenpaiForge {
    public YajuSenpaiForge() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(CommonHandlerForge.class);
        EventBuses.registerModEventBus(YajuSenpai.MODID, FMLJavaModLoadingContext.get().getModEventBus());
        YajuSenpai.init();
    }

    private void doClientStuff(FMLClientSetupEvent event) {
        YajuSenpaiClient.init();
    }
}
