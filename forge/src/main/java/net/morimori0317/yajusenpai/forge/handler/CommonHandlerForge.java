package net.morimori0317.yajusenpai.forge.handler;

import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori0317.yajusenpai.handler.CommonHandler;

public class CommonHandlerForge {
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent e) {
        CommonHandler.onLivingTick(e.getEntity());
    }

    @SubscribeEvent
    public static void onLivingDrop(LivingDropsEvent e) {
        CommonHandler.onLivingDrop(e.getEntity(), e.getSource(), e.getDrops());
    }
}
