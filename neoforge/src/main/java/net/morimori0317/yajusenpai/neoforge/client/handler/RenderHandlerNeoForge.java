package net.morimori0317.yajusenpai.neoforge.client.handler;

import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.LivingEntity;
import net.morimori0317.yajusenpai.client.handler.RenderHandler;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

public class RenderHandlerNeoForge {
    @SubscribeEvent
    public static void onLivingRenderPre(RenderLivingEvent.Pre<LivingEntity, ? extends EntityModel<LivingEntity>> e) {
        RenderHandler.onLivingRenderPre(e.getEntity(), e.getPoseStack());
    }

    @SubscribeEvent
    public static void onLivingRenderPost(RenderLivingEvent.Post<LivingEntity, ? extends EntityModel<LivingEntity>> e) {
        RenderHandler.onLivingRenderPost(e.getEntity(), e.getPoseStack());
    }
}
