package net.morimori0317.yajusenpai.handler;

import dev.architectury.networking.NetworkManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.blockentity.BigPillowBlockEntity;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.YJDamageSource;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.networking.YJPackets;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJPlayerUtils;

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

            boolean coma = livingEntity.hasEffect(YJMobEffects.COMA.get());

            if (coma != yjLiving.isComaSync()) {
                yjLiving.setComaSync(coma);
                YJPlayerUtils.doPlayers(livingEntity.level, livingEntity.blockPosition(), p -> NetworkManager.sendToPlayer(p, YJPackets.COMA_SYNC, new YJPackets.ComaSyncMessage(livingEntity.getId(), coma).toFBB()));
            }
        }

        if (yjLiving.getSleepingPos() != null && (!BigPillowBlockEntity.canComa(livingEntity) || !livingEntity.level.getBlockState(yjLiving.getSleepingPos()).is(YJBlocks.BIG_PILLOW.get()))) {
            yjLiving.setSleepingPos(null);
        }
    }
}
