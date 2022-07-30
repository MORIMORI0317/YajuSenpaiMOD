package net.morimori0317.yajusenpai.item;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YJSwordItem extends SwordItem {
    public YJSwordItem(Tier tier, int i, float f, Properties properties) {
        super(tier, i, f, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level.isClientSide())
            attacker.level.playSound(null, attacker, YJSoundEvents.YJ_ATTACK.get(), SoundSource.NEUTRAL, 5, 1);
        return super.hurtEnemy(itemStack, target, attacker);
    }
}