package net.morimori0317.yajusenpai.forge.client.handler;

import net.minecraft.client.model.EntityModel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori0317.yajusenpai.client.handler.RenderHandler;

public class RenderHandlerForge {
    @SubscribeEvent
    public static void onLivingRenderPre(RenderLivingEvent.Pre<LivingEntity, ? extends EntityModel<LivingEntity>> e) {
        RenderHandler.onLivingRenderPre(e.getEntity(), e.getPoseStack());
    }

    @SubscribeEvent
    public static void onLivingRenderPost(RenderLivingEvent.Post<LivingEntity, ? extends EntityModel<LivingEntity>> e) {
        RenderHandler.onLivingRenderPost(e.getEntity(), e.getPoseStack());
    }
}
