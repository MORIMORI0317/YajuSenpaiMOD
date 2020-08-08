package net.morimori.yjsnpimod.handler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.util.YJUtil;

public class ServerHandler {

    @SubscribeEvent
    public static void onDamege(LivingDamageEvent e) {
        if (YJUtil.isYJOn(e.getEntity())) {
            e.getEntity().world.playSound((PlayerEntity) null, e.getEntity().getPosX(), e.getEntity().getPosY(), e.getEntity().getPosZ(), YJSoundEvents.YJ_PROLIFERATION, SoundCategory.BLOCKS, 3, 1);
        }
    }
}
