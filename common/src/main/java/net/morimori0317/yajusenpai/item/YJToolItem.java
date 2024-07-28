package net.morimori0317.yajusenpai.item;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageSources;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public interface YJToolItem {
    static void hurtEnemy(LivingEntity target, LivingEntity attacker, boolean ikisugible) {
        if (!attacker.level().isClientSide) {
            SoundEvent sound = YJSoundEvents.YJ_ATTACK.get();

            if (ikisugible && attacker.getRandom().nextInt(114514) < 810) {
                sound = YJSoundEvents.YJ_NU.get();
                target.hurt(YJDamageSources.ikisugi(target.level(), attacker), 114514);
                attacker.addEffect(new MobEffectInstance(YJMobEffects.BEAST_FICTION.vanillaHolder(), 200, 0));
            }

            attacker.level().playSound(null, attacker, sound, SoundSource.NEUTRAL, 5, 1);
        }
    }

    static void breakBlock(ServerLevel serverLevel, BlockPos blockPos) {
        serverLevel.playSound(null, blockPos, YJSoundEvents.YJ_ATTACK.get(), SoundSource.NEUTRAL, 5, 1);
    }
}
