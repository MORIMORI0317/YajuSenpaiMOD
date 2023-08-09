package net.morimori0317.yajusenpai.forge.handler;

import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.morimori0317.yajusenpai.YajuSenpai;

@Mod.EventBusSubscriber(modid = YajuSenpai.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandler {
    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        DataGenHandlerW.onDataGen(event);
    }
}
