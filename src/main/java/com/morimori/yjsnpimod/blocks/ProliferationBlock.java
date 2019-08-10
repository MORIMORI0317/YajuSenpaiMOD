package com.morimori.yjsnpimod.blocks;

import java.util.Random;

import com.morimori.yjsnpimod.other.Sounds;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ProliferationBlock extends Block{

	public ProliferationBlock(Properties properties) {
		super(properties);

	}
	   public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {

		   boolean oto=false;
		   if (isBlockPlase(pos.up(),worldIn)) {
			   oto=true;
			   worldIn.setBlockState(pos.up(), this.getDefaultState());

		}
		   if (isBlockPlase(pos.down(),worldIn)) {
			   oto=true;
			   worldIn.setBlockState(pos.down(), this.getDefaultState());

		}

		   if (isBlockPlase(pos.east(),worldIn)) {
			   oto=true;
			   worldIn.setBlockState(pos.east(), this.getDefaultState());

		}
		   if (isBlockPlase(pos.north(),worldIn)) {
			   oto=true;
			   worldIn.setBlockState(pos.north(), this.getDefaultState());

		}
		   if (isBlockPlase(pos.west(),worldIn)) {
			   oto=true;
			   worldIn.setBlockState(pos.west(), this.getDefaultState());

		}

		   if (isBlockPlase(pos.south(),worldIn)) {
			   oto=true;
			   worldIn.setBlockState(pos.south(), this.getDefaultState());

		}
		  // worldIn.playSound(pos.getX(), pos.getY(), pos.getZ(), Sounds.yarimasunexeevent, SoundCategory.RE, 1.0F, 1.0F, false);
	         if (oto == true)
	         {

	          	   worldIn.playSound((PlayerEntity)null, pos, Sounds.SoundLisRandom(Sounds.YJPBlockSoundlist), SoundCategory.RECORDS, 3.0F, 1);


	         }

		   }

	   public boolean isBlockPlase(BlockPos pos,World worldIn) {


		   if(worldIn.getBlockState(pos)==Blocks.AIR.getDefaultState()||worldIn.getBlockState(pos)==Blocks.CAVE_AIR.getDefaultState()||worldIn.getBlockState(pos)==Blocks.VOID_AIR.getDefaultState()) {


				return true;


		   }

		return false;



	   }



}
