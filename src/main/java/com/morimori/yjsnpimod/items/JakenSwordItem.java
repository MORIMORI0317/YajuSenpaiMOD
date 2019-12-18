package com.morimori.yjsnpimod.items;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.morimori.yjsnpimod.effects.MODEffects;
import com.morimori.yjsnpimod.other.MODDamageSources;
import com.morimori.yjsnpimod.other.Sounds;
import com.morimori.yjsnpimod.utils.YJToolTipUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class JakenSwordItem extends SwordItem{

	public JakenSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}

	   public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		      stack.damageItem(1, attacker, (p_220045_0_) -> {
		         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		      });


  			Random r = new Random();
  			if(r.nextInt(114514)<=810) {
  		      attacker.getEntityWorld().playSound((PlayerEntity)null, attacker.getPosition(), Sounds.SoundLisRandom(Sounds.YJChanseSoundlist), SoundCategory.RECORDS, 3.0F, 1);
  				target.attackEntityFrom(MODDamageSources.RAPE, 1145141919);
  				attacker.addPotionEffect(new EffectInstance(MODEffects.BEASTIFICATIO,200,0));


  			}
  			else {

  		      attacker.getEntityWorld().playSound((PlayerEntity)null, attacker.getPosition(), Sounds.SoundLisRandom(Sounds.YJJakenSworlSoundlist), SoundCategory.RECORDS, 3.0F, 1);
			}
		      return true;
		   }

	   @OnlyIn(Dist.CLIENT)
	   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		   int kakurituue=810;
		   int kakuritusita=114514;

		   	if(YJToolTipUtils.iskyePush(Minecraft.getInstance().gameSettings.field_228046_af_,tooltip)) {
	      tooltip.add(this.getIDescription(kakurituue,kakuritusita).applyTextStyle(TextFormatting.GRAY));
		   	}
	   }
	   @OnlyIn(Dist.CLIENT)
	   public ITextComponent getIDescription(int kakurituue, int kakuritusita) {
	      return new TranslationTextComponent(this.getTranslationKey() + ".desc",kakurituue,kakuritusita);
	   }
}
