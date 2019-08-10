package com.morimori.yjsnpimod.handler;

import java.util.Random;

import com.morimori.yjsnpimod.effects.MODEffects;
import com.morimori.yjsnpimod.items.MODItems;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class LivingDropsHandler {
    public void onDrop(LivingDropsEvent event) {

    	Random r = new Random();
    	if (event.getEntity() instanceof ZombieEntity) {
    		if(r.nextInt(1919*10)<=364) {
    	event.getDrops().add(new ItemEntity(event.getEntityLiving().getEntityWorld(), event.getEntityLiving().getPosition().getX(), event.getEntityLiving().getPosition().getY(), event.getEntityLiving().getPosition().getZ(), new ItemStack(MODItems.POTATO_SENPAI)));

    		}
		}
    	if(!event.getEntityLiving().isNonBoss()) {
        	event.getDrops().add(new ItemEntity(event.getEntityLiving().getEntityWorld(), event.getEntityLiving().getPosition().getX(), event.getEntityLiving().getPosition().getY(), event.getEntityLiving().getPosition().getZ(), new ItemStack(MODItems.YJ_STAR)));

    	}

		if(event.getEntityLiving().isPotionActive(MODEffects.BEASTIFICATIO)) {
			if(r.nextInt(1919)<=364) {
		   	event.getDrops().add(new ItemEntity(event.getEntityLiving().getEntityWorld(), event.getEntityLiving().getPosition().getX(), event.getEntityLiving().getPosition().getY(), event.getEntityLiving().getPosition().getZ(), new ItemStack(MODItems.DIAMOND_SENPAI)));
			}

	}
		if(r.nextInt(114514)<=810) {
	event.getDrops().add(new ItemEntity(event.getEntityLiving().getEntityWorld(), event.getEntityLiving().getPosition().getX(), event.getEntityLiving().getPosition().getY(), event.getEntityLiving().getPosition().getZ(), new ItemStack(MODItems.YJ_INGOT)));

		}

  }
}
