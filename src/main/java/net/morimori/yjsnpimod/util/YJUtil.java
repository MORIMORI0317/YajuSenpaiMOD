package net.morimori.yjsnpimod.util;

import com.google.common.collect.Streams;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.item.YJItems;

import java.util.Random;

public class YJUtil {
    @OnlyIn(Dist.CLIENT)
    public static boolean isYJOverwrite(ClientPlayerEntity player) {

        Minecraft mc = YJSNPIMOD.proxy.getMinecraft();

        if (Streams.stream(mc.player.getArmorInventoryList()).allMatch(n -> n.getItem() == YJItems.YJSNPI_HELMET || n.getItem() == YJItems.YJSNPI_CHESTPLATE || n.getItem() == YJItems.YJSNPI_LEGGINGS || n.getItem() == YJItems.YJSNPI_BOOTS)) {
            Random r = new Random();
            if (r.nextInt(19) == 0)
                return true;
        }

        return false;
    }

    public static boolean isYJOn(Entity entity) {

        if (entity == null)
            return false;

        if (entity instanceof HorseEntity && Streams.stream(entity.getArmorInventoryList()).anyMatch(n -> n.getItem() == YJItems.YJSNPI_HORSE_ARMOR)) {
            return true;
        }


        if (Streams.stream(entity.getArmorInventoryList()).allMatch(n -> n.getItem() == YJItems.YJSNPI_HELMET || n.getItem() == YJItems.YJSNPI_CHESTPLATE || n.getItem() == YJItems.YJSNPI_LEGGINGS || n.getItem() == YJItems.YJSNPI_BOOTS)) {
            return true;
        }


        return false;
    }
}
