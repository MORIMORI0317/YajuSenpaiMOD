package net.morimori.yjsnpimod.handler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.effect.YJEffects;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.util.YJUtil;

import java.util.Random;

public class ServerHandler {

    @SubscribeEvent
    public static void onDamege(LivingDamageEvent e) {
        if (YJUtil.isYJOn(e.getEntity())) {
            e.getEntity().world.playSound((PlayerEntity) null, e.getEntity().getPosX(), e.getEntity().getPosY(), e.getEntity().getPosZ(), YJSoundEvents.YJ_DAMEGE, SoundCategory.VOICE, 3, 1);
        }
    }

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent e) {
        if (e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.COMA)) {
            e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntityLiving().getPosX(), e.getEntityLiving().getPosY(), e.getEntityLiving().getPosZ(), YJSoundEvents.TON_SEKAINOTON, SoundCategory.VOICE, 3, 1);
        }
    }

    @SubscribeEvent
    public static void onMobTick(LivingEvent.LivingUpdateEvent e) {

        if (e.getEntityLiving().getActivePotionEffects().stream().anyMatch(n -> n.getPotion() == YJEffects.COMA)) {
            Random r = new Random();
            int level = e.getEntityLiving().getActivePotionEffect(YJEffects.COMA).getAmplifier() + 1;
            float la = level / 256;
            if (r.nextInt((int) (100 - (99 * la))) == 0) {
                e.getEntityLiving().world.playSound((PlayerEntity) null, e.getEntityLiving().getPosX(), e.getEntityLiving().getPosY(), e.getEntityLiving().getPosZ(), YJSoundEvents.TON_STAGGER, SoundCategory.VOICE, 3 * level, 1);
                Vector3d mv = e.getEntityLiving().getMotion();
                double x = (r.nextDouble() - 0.5d) * 3d;
                double z = (r.nextDouble() - 0.5d) * 3d;
                mv = mv.add(x, 0, z);
                e.getEntityLiving().setMotion(mv);
            }
        }
    }

    @SubscribeEvent
    public static void onMobSpawn(LivingSpawnEvent.SpecialSpawn e) {
        LivingEntity mob = e.getEntityLiving();

        Random r = new Random();

        if (mob instanceof ZombieEntity || mob instanceof AbstractSkeletonEntity || mob instanceof PiglinEntity) {
            if (r.nextFloat() <= 0.0810f) {
                mob.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(YJItems.CYCLOPS_SUNGLASSES));
            } else if (r.nextFloat() <= 0.0364364f) {
                mob.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(YJItems.YJNIUM_HELMET));
                mob.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(YJItems.YJNIUM_CHESTPLATE));
                mob.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(YJItems.YJNIUM_LEGGINGS));
                mob.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(YJItems.YJNIUM_BOOTS));
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.YJNIUM_SWORD));
            } else if (r.nextFloat() <= 0.01919f) {
                mob.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(YJItems.YJSNPI_HELMET));
                mob.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(YJItems.YJSNPI_CHESTPLATE));
                mob.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(YJItems.YJSNPI_LEGGINGS));
                mob.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(YJItems.YJSNPI_BOOTS));
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.YJSNPI_SWORD));
            }
        }

        if (mob instanceof FoxEntity) {
            if (r.nextFloat() <= 0.0364364f) {
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.YJNIUM_INGOT));
            } else if (r.nextFloat() <= 0.01919f) {
                mob.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(YJItems.YJSNPI_INGOT));
            }
        }

    }
}
