package net.morimori.yjsnpimod.client.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.entity.ToiletSitEntity;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.util.YJUtil;
import red.felnull.otyacraftengine.api.ResponseSender;

import java.util.Random;

public class ClientHandler {

    private static Minecraft mc = Minecraft.getInstance();

    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent e) {

        if (mc.player == null || e.getSound().getSoundLocation().getNamespace().equals(YJSNPIMOD.MODID))
            return;

        if (YJUtil.isYJOverwrite(mc.player)) {
            e.setResultSound(SimpleSound.master(YJSoundEvents.YJ_OVERWRITE, 1, 1));
        }
        if (mc.player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() == YJItems.CYCLOPS_SUNGLASSES) {

            Random r = new Random();
            if (r.nextInt(364) == 0) {
                e.setResultSound(SimpleSound.master(YJSoundEvents.CYCLOPS_SANGRASSED, 1, 1));
            }
        }

    }

    @SubscribeEvent
    public static void onKey(InputEvent.KeyInputEvent e) {

        if (mc.player == null)
            return;

        if (e.getKey() == mc.gameSettings.keyBindJump.getKey().getKeyCode()) {
            if (mc.player.getRidingEntity() instanceof ToiletSitEntity) {
                ResponseSender.sendToServer(new ResourceLocation(YJSNPIMOD.MODID, "toiletsitting"), 0, "", new CompoundNBT());
            }
        }
    }
}
