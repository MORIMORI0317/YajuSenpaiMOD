package net.morimori0317.yajusenpai.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class JakenSwordItem extends SwordItem {
    public JakenSwordItem(Tier tier, int i, float f, Properties properties) {
        super(tier, i, f, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {
            SoundEvent soundEvent = YJSoundEvents.YJ_ATTACK.get();
            if (attacker.getRandom().nextInt(114514) <= 810) {
           //     target.hurt(YJDamageSource.ikisugi(attacker), 114514);
                soundEvent = YJSoundEvents.YJ_NU.get();
                attacker.addEffect(new MobEffectInstance(YJMobEffects.BEAST_FICTION.get(), 200, 0));
            }
            attacker.level().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), soundEvent, SoundSource.NEUTRAL, 5, 1);
        }
        return super.hurtEnemy(itemStack, target, attacker);
    }
}