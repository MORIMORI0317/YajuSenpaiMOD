package net.morimori0317.yajusenpai.forge.handler;

import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori0317.yajusenpai.handler.CommonHandler;

public class CommonHandlerForge {
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingUpdateEvent e) {
        CommonHandler.onLivingTick(e.getEntityLiving());
    }
}
