package com.morimori.yjsnpimod.blocks;

import com.morimori.yjsnpimod.effects.MODEffects;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class YjRoseBlock extends FlowerBlock {
   public YjRoseBlock(Effect effectIn, Block.Properties propertiesIn) {
      super(effectIn, 8, propertiesIn);
   }



   public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
         if (entityIn instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)entityIn;

               livingentity.addPotionEffect(new EffectInstance(MODEffects.BEASTIFICATIO, 4000));


      }


   }
   protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
	      Block block = state.getBlock();
	      return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND||block == MODBlocks.YJ_SNPAI_BLOCK||block == MODBlocks.PROLIFERATION_YJSNPI;
	   }
}