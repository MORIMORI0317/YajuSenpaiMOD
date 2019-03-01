package yjblock;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Block_YJSMPI extends Block {

    public Block_YJSMPI() {
        super(Material.WOOD);
        this.setRegistryName(Yjblock_core.MODID,"yj_block");
        this.setUnlocalizedName("yjblock");
        this.setCreativeTab(Yjblock_core.yjtab);
        this.setSoundType(SoundType.GLASS);
        this.setHardness(1.0F);
        this.setResistance(10.0F);
        this.setTickRandomly(true);
    }




     public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {



    	 boolean oto=false;


         IBlockState sita = worldIn.getBlockState(pos.down());
         Block blocksita = sita.getBlock();
         IBlockState ue = worldIn.getBlockState(pos.up());
         Block blockuue = ue.getBlock();
         IBlockState yokoeast = worldIn.getBlockState(pos.east());
         Block blockyokoeast = yokoeast.getBlock();
         IBlockState yokowast = worldIn.getBlockState(pos.west());
         Block blockyokowast = yokowast.getBlock();
         IBlockState yokonorth = worldIn.getBlockState(pos.north());
         Block blockyokonorth = yokonorth.getBlock();
         IBlockState yokosorth = worldIn.getBlockState(pos.south());
         Block blockyokosorth = yokosorth.getBlock();
         if (blocksita == Blocks.AIR)

         {
        	 oto=true;
	worldIn.setBlockState(pos.down(), this.getDefaultState());

         }
         if (blockuue == Blocks.AIR)

         {
        	 oto=true;
	worldIn.setBlockState(pos.up(), this.getDefaultState());

         }
         if (blockyokoeast == Blocks.AIR)

         {
        	 oto=true;
	worldIn.setBlockState(pos.east(), this.getDefaultState());

         }
         if (blockyokowast == Blocks.AIR)

         {
        	 oto=true;
	worldIn.setBlockState(pos.west(), this.getDefaultState());

         }

         if (blockyokonorth == Blocks.AIR)

         {
        	 oto=true;
	worldIn.setBlockState(pos.north(), this.getDefaultState());

         }
         if (blockyokosorth == Blocks.AIR)
         {
        	 oto=true;
	worldIn.setBlockState(pos.south(), this.getDefaultState());

         }

         if (oto == true)
         {
        	 oto=false;
        	 int randama =rand.nextInt(11);
        	 switch (randama){
          	case 0:
          		  worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.yarimasunexeevent, SoundCategory.RECORDS, 3.0F, 1);
          		  break;
          	case 1:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.nnaevent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 2:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.onaonevent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 3:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.mazuutisaxaevent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 4:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.katakuevent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 5:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.nuwatikaretaevent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 6:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.buttipaevent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 7:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.ikisugievent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 8:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.osuonegaievent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 9:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.dedemasuyoevent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
          	case 10:
          		worldIn.playSound((EntityPlayer)null, pos, Yjblock_core.fookimatiievent, SoundCategory.RECORDS, 3.0F, 1);
          		break;
        	 }
        	 }

     }

     @SideOnly(Side.CLIENT)
     public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
     {


    	 tooltip.add(I18n.translateToLocal("tooltip.yjblock"));
     }
     }
