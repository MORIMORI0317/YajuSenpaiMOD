package com.morimori.yjsnpimod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.morimori.yjsnpimod.blocks.MODBlocks;
import com.morimori.yjsnpimod.effects.MODEffects;
import com.morimori.yjsnpimod.net.URLreeder;
import com.morimori.yjsnpimod.other.MODDamageSources;
import com.morimori.yjsnpimod.utils.YJToolTipUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SoftSwordItem extends Item{

	public static String SOZAI_TITEL=URLreeder.Titelloadint("https://www.nicovideo.jp/watch/sm18842224");
	public SoftSwordItem(Properties properties) {
		super(properties);

	}
	   public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		      stack.damageItem(1, attacker, (p_220045_0_) -> {
		         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		      });
		      for (int z = 0; z < 9; z++) {
		      for (int x = 0; x < 9; x++) {
		      for (int y = 0; y < 9; y++) {
		    	if(target.getEntityWorld().getBlockState(target.getPosition().add(x-4, z-4, y-4)).getBlock()==MODBlocks.BIG_PILLOW){
		    		target.setPosition(target.getPosition().add(x-4.5f, z-4.5f, y-4.5).getX(),target.getPosition().add(x-4, z-4, y-4).getY(),target.getPosition().add(x-4, z-4, y-4).getZ());
					attacker.addPotionEffect(new EffectInstance(MODEffects.CUM,2000,0));

					target.attackEntityFrom(MODDamageSources.RAPE, 1919);

		    		System.out.println("test");
		    	}

		     }
		      }
		      }
		      return false;
		   }
	   @OnlyIn(Dist.CLIENT)
	   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		   	if(YJToolTipUtils.iskyePush(Minecraft.getInstance().gameSettings.field_228046_af_,tooltip)) {
	      tooltip.add(this.getIDescription());
	      YJToolTipUtils.genSozaiURL(tooltip, "https://www.nicovideo.jp/watch/sm18842224", SOZAI_TITEL);

		   	}


	   }

	   @OnlyIn(Dist.CLIENT)
	   public ITextComponent getIDescription() {
	      return new TranslationTextComponent(this.getTranslationKey() + ".desc").applyTextStyle(TextFormatting.GRAY);
	   }

}
