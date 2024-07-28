package net.morimori0317.yajusenpai.neoforge;

import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.neoforge.handler.CommonHandlerForge;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(YajuSenpai.MODID)
public class YajuSenpaiNeoForge {
    public YajuSenpaiNeoForge(IEventBus modEventBus, Dist dist) {
        modEventBus.addListener(this::setup);
        YajuSenpai.init();

        NeoForge.EVENT_BUS.register(CommonHandlerForge.class);
    }

    private void setup(FMLCommonSetupEvent e) {
        YajuSenpai.setup();
    }
}
