package com.morimori.yjsnpimod.handler;

import java.util.Random;

import com.morimori.yjsnpimod.blocks.MODBlocks;
import com.morimori.yjsnpimod.effects.MODEffects;
import com.morimori.yjsnpimod.other.Sounds;
import com.morimori.yjsnpimod.utils.HandItemUtils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

public class LivingDamageHandler {
        public void onLivingDamage(LivingDamageEvent event) {


    		LivingEntity e =event.getEntityLiving();
    		World w=e.getEntityWorld();

    		if(HandItemUtils.isHandinSheildItem(event.getEntity())){

    			Random r = new Random();
    			if(r.nextInt(114514)<=810) {
    			event.setCanceled(true);
    			w.playSound((PlayerEntity)null, event.getEntity().getPosition(), Sounds.SoundLisRandom(Sounds.YJJakenSworlSoundlist), SoundCategory.RECORDS, 3.0F, 1);
    			e.addPotionEffect(new EffectInstance(MODEffects.BEASTIFICATIO,200,0));
    			}
    		}

    		if(e.isPotionActive(MODEffects.BEASTIFICATIO)) {
    			w.playSound((PlayerEntity)null, event.getEntity().getPosition(), Sounds.SoundLisRandom(Sounds.YJJakenShieldSoundlist), SoundCategory.RECORDS, 3.0F, 1);
        		Block block = 	w.getBlockState(e.getPosition().add(0, -1, 0)).getBlock();
        		if(block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND||block == MODBlocks.YJ_SNPAI_BLOCK||block == MODBlocks.PROLIFERATION_YJSNPI) {
        			if (w.getBlockState(e.getPosition()).getBlock()==Blocks.AIR||w.getBlockState(e.getPosition()).getBlock()==Blocks.VOID_AIR||w.getBlockState(e.getPosition()).getBlock()==Blocks.CAVE_AIR) {



        			w.setBlockState(e.getPosition(), MODBlocks.YJ_ROSE.getDefaultState());

        			}



        		}
    		}







        }

    }


