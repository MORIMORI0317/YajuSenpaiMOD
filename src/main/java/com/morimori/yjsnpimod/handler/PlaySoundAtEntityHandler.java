package com.morimori.yjsnpimod.handler;

import java.util.Random;

import com.morimori.yjsnpimod.effects.MODEffects;
import com.morimori.yjsnpimod.other.Sounds;
import com.morimori.yjsnpimod.utils.HandItemUtils;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;

public class PlaySoundAtEntityHandler {
        public void onPlaySoundAtEntity(PlaySoundAtEntityEvent event) {
        	if(event.getSound()==SoundEvents.ITEM_SHIELD_BLOCK)
        	if(event.getEntity() instanceof PlayerEntity) {
        		if(HandItemUtils.isHandinSheildItem(event.getEntity())){

        			event.setSound(Sounds.SoundLisRandom(Sounds.YJJakenShieldSoundlist));

        		}
        	}





        	if(event.getEntity() instanceof PlayerEntity) {

        		Random r = new Random();
        		LivingEntity e = (LivingEntity) event.getEntity();
        			if(e.getActivePotionEffect(MODEffects.CUM)!=null) {
        				int level =e.getActivePotionEffect(MODEffects.CUM).getAmplifier();
        				level=+1;
        				if(r.nextInt(1919*2/level)<=810) {
        			event.setSound(Sounds.NNA);
        				}

        			}

        	}

        }

    }


