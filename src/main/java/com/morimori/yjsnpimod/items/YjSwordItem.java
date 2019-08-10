package com.morimori.yjsnpimod.items;

import com.morimori.yjsnpimod.effects.MODEffects;
import com.morimori.yjsnpimod.other.Sounds;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;

public class YjSwordItem extends SwordItem{

	public YjSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);

	}
	   public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		      stack.damageItem(1, attacker, (p_220045_0_) -> {
		         p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
		      });
		      attacker.getEntityWorld().playSound((PlayerEntity)null, attacker.getPosition(), Sounds.SoundLisRandom(Sounds.YJChanseSoundlist), SoundCategory.RECORDS, 3.0F, 1);


		      target.addPotionEffect(new EffectInstance(MODEffects.BEASTIFICATIO,200,0));

		      return true;
		   }
}
