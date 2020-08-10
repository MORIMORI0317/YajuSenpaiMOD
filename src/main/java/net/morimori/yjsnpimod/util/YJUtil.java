package net.morimori.yjsnpimod.util;

import com.google.common.collect.Streams;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.effect.YJEffects;
import net.morimori.yjsnpimod.item.YJItems;

import java.util.Random;

public class YJUtil {
    @OnlyIn(Dist.CLIENT)
    public static boolean isYJOverwrite(ClientPlayerEntity player) {

        Minecraft mc = YJSNPIMOD.proxy.getMinecraft();

        if (mc.player.getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.BEASTFICTION)) {
            Random r = new Random();
            int level = mc.player.getActivePotionEffect(YJEffects.BEASTFICTION).getAmplifier() + 1;
            float la = level / 256;
            if (r.nextInt((int) (19 - (la * 19))) == 0)
                return true;
        }

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

        if (entity instanceof LivingEntity && ((LivingEntity) entity).getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.BEASTFICTION)) {
            return true;
        }

        if (entity instanceof HorseEntity && Streams.stream(entity.getArmorInventoryList()).anyMatch(n -> n.getItem() == YJItems.YJSNPI_HORSE_ARMOR)) {
            return true;
        }


        if (Streams.stream(entity.getArmorInventoryList()).allMatch(n -> n.getItem() == YJItems.YJSNPI_HELMET || n.getItem() == YJItems.YJSNPI_CHESTPLATE || n.getItem() == YJItems.YJSNPI_LEGGINGS || n.getItem() == YJItems.YJSNPI_BOOTS)) {
            return true;
        }


        return false;
    }
}
