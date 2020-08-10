package net.morimori.yjsnpimod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.SoundCategory;
import net.morimori.yjsnpimod.YJSoundEvents;

public class YJSwordItem extends SwordItem {
    public YJSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties p_i48460_4_) {
        super(tier, attackDamageIn, attackSpeedIn, p_i48460_4_);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        attacker.getEntityWorld().playSound((PlayerEntity) null, attacker.getPosX(), attacker.getPosY(), attacker.getPosZ(), YJSoundEvents.YJ_ATTACK, SoundCategory.VOICE, 3.0F, 1);
        return super.hitEntity(stack, target, attacker);
    }
}
