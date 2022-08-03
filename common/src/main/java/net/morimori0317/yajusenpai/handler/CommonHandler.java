package net.morimori0317.yajusenpai.handler;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.YJDamageSource;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class CommonHandler {
    public static int IKISUGI_DIE_TIME = 20 * 8 + 3;

    public static void onLivingTick(LivingEntity livingEntity) {
        YJLivingEntity yjLiving = (YJLivingEntity) livingEntity;

        if (!livingEntity.level.isClientSide()) {
            var effect = livingEntity.getEffect(YJMobEffects.IKISUGI.get());
            if (livingEntity.hasEffect(YJMobEffects.IKISUGI.get()) && effect != null) {
                if (effect.getDuration() <= 20) {
                    livingEntity.removeEffect(YJMobEffects.IKISUGI.get());
                    livingEntity.hurt(YJDamageSource.ikisugi(yjLiving.getGrantedIkisugiEntity()), 114514f);
                }

                if (effect.getDuration() <= IKISUGI_DIE_TIME && !yjLiving.isIkisugi()) {
                    yjLiving.setIkisugi(true);
                    livingEntity.level.playSound(null, livingEntity, YJSoundEvents.YJ_IKISUGI_ONRY.get(), SoundSource.VOICE, 3, 1);
                }

            } else {
                yjLiving.setIkisugi(false);
                yjLiving.setGrantedIkisugiEntity(null);
            }
        }

    }
}
