package net.morimori0317.yajusenpai.handler;

import dev.architectury.networking.NetworkManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.blockentity.BigPillowBlockEntity;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.EnityIkisugiDamageSource;
import net.morimori0317.yajusenpai.entity.YJDamageSource;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.networking.YJPackets;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJEntityUtil;
import net.morimori0317.yajusenpai.util.YJPlayerUtils;

import java.util.Collection;

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

            if (livingEntity.hasEffect(YJMobEffects.COMA.get()) && yjLiving.getSleepingPos() == null) {
                var efct = livingEntity.getEffect(YJMobEffects.COMA.get());
                if (efct != null) {
                    float ra = ((float) efct.getAmplifier() + 1) / 256f;
                    if (livingEntity.getRandom().nextInt((int) (100 - (99 * ra))) == 0) {
                        livingEntity.level.playSound(null, livingEntity, YJSoundEvents.TON_STAGGER.get(), SoundSource.VOICE, 1, 1);
                    }
                }
            }
        }

        if (yjLiving.getSleepingPos() != null && (!BigPillowBlockEntity.canComa(livingEntity) || !livingEntity.level.getBlockState(yjLiving.getSleepingPos()).is(YJBlocks.BIG_PILLOW.get()))) {
            yjLiving.setSleepingPos(null);
        }

        if (yjLiving.isIkisugiSleeping() && yjLiving.getSleepingPos() == null)
            yjLiving.setIkisugiSleeping(false);


    }

    public static void onLivingDrop(LivingEntity livingEntity, DamageSource source, Collection<ItemEntity> drops) {
        if (livingEntity.getMaxHealth() >= 100 && (source == YJDamageSource.IKISUGI || source instanceof EnityIkisugiDamageSource))
            drops.add(YJEntityUtil.createItemEntity(new ItemStack(YJItems.YJ_STAR.get()), livingEntity.level, livingEntity.position().x, livingEntity.position().y, livingEntity.position().z));
    }
}
