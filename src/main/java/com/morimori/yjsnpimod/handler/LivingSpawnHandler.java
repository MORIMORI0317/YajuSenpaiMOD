package com.morimori.yjsnpimod.handler;

import java.util.Random;

import com.morimori.yjsnpimod.items.MODItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class LivingSpawnHandler {


   public void onLivingSpawn(LivingSpawnEvent.CheckSpawn event) {

   	LivingEntity e =event.getEntityLiving();
   	Entity en=e.getEntity();
	Random r = new Random();
	if(r.nextInt(114514)<=810) {
	if(en instanceof ZombieEntity || en instanceof SkeletonEntity|| en instanceof VindicatorEntity|| en instanceof ZombiePigmanEntity|| en instanceof DrownedEntity|| en instanceof PillagerEntity|| en instanceof VillagerEntity|| en instanceof VexEntity|| en instanceof PandaEntity|| en instanceof FoxEntity) {
   	e.setHeldItem(Hand.MAIN_HAND, new ItemStack(MODItems.JAKEN_YORUIKIMASYOUNE));
   	e.setHeldItem(Hand.OFF_HAND, new ItemStack(MODItems.JAKEN_YORUIKIMASYOU));
	}}
}
}


