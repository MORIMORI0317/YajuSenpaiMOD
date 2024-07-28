package net.morimori0317.yajusenpai.neoforge.client.handler;

import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.client.YajuSenpaiClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = YajuSenpai.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientBusHandlerNeoForge {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        NeoForge.EVENT_BUS.register(RenderHandlerNeoForge.class);
        YajuSenpaiClient.init();
    }
}
