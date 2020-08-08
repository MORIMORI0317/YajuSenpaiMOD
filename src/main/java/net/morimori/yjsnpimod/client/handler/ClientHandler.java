package net.morimori.yjsnpimod.client.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.util.YJUtil;

public class ClientHandler {

    private static Minecraft mc = Minecraft.getInstance();

    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent e) {

        if (mc.player == null || e.getSound().getSoundLocation().getNamespace().equals(YJSNPIMOD.MODID) || !YJUtil.isYJOverwrite(mc.player))
            return;

        e.setResultSound(SimpleSound.master(YJSoundEvents.YJ_PROLIFERATION, 1, 1));
    }
}
