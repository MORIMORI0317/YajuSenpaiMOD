package net.morimori0317.yajusenpai.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class YJHoeItem extends HoeItem implements YJToolItem {
    public YJHoeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void postHurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        YJToolItem.hurtEnemy(target, attacker, false);
        super.postHurtEnemy(itemStack, target, attacker);
    }
}
