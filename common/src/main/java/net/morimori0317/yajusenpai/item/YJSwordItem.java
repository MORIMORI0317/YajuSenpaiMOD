package net.morimori0317.yajusenpai.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class YJSwordItem extends SwordItem implements YJToolItem {
    public YJSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void postHurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        YJToolItem.hurtEnemy(target, attacker, false);
        super.postHurtEnemy(itemStack, target, attacker);
    }
}
