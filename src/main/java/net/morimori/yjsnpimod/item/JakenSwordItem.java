package net.morimori.yjsnpimod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;
import net.morimori.yjsnpimod.YJDamageSource;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.effect.YJEffects;
import red.felnull.otyacraftengine.item.IDetailedInfomationItem;

import java.util.Random;

public class JakenSwordItem extends SwordItem implements IDetailedInfomationItem {
    public JakenSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties p_i48460_4_) {
        super(tier, attackDamageIn, attackSpeedIn, p_i48460_4_);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Random r = new Random();
        if (r.nextInt(114514) <= 810) {
            attacker.getEntityWorld().playSound((PlayerEntity) null, attacker.getPosX(), attacker.getPosY(), attacker.getPosZ(), YJSoundEvents.YJ_NU, SoundCategory.VOICE, 3.0F, 1);
            target.attackEntityFrom(YJDamageSource.RAPE, 1145141919);
            attacker.addPotionEffect(new EffectInstance(YJEffects.BEASTFICTION, 200, 0));
        } else {
            attacker.getEntityWorld().playSound((PlayerEntity) null, attacker.getPosX(), attacker.getPosY(), attacker.getPosZ(), YJSoundEvents.YJ_ATTACK, SoundCategory.VOICE, 3.0F, 1);
        }

        return super.hitEntity(stack, target, attacker);
    }
}
