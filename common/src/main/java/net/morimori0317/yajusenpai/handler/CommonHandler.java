package net.morimori0317.yajusenpai.handler;

import dev.architectury.networking.NetworkManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageSources;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageTypes;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.networking.YJPackets;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.function.Consumer;

public class CommonHandler {
    public static int IKISUGI_DIE_TIME = 20 * 8 + 3;


    public static void onLivingTick(LivingEntity livingEntity) {
        YJLivingEntity yjLiving = (YJLivingEntity) livingEntity;

        if (!livingEntity.level().isClientSide()) {
            var effect = livingEntity.getEffect(YJMobEffects.IKISUGI.vanillaHolder());
            if (livingEntity.hasEffect(YJMobEffects.IKISUGI.vanillaHolder()) && effect != null) {
                if (effect.getDuration() <= 20) {
                    livingEntity.removeEffect(YJMobEffects.IKISUGI.vanillaHolder());
                    livingEntity.hurt(YJDamageSources.ikisugi(livingEntity.level(), yjLiving.getGrantedIkisugiEntity()), 114514f);
                }

                if (effect.getDuration() <= IKISUGI_DIE_TIME && !yjLiving.isIkisugi()) {
                    yjLiving.setIkisugi(true);
                    livingEntity.level().playSound(null, livingEntity, YJSoundEvents.YJ_IKISUGI_ONRY.get(), SoundSource.VOICE, 3, 1);
                }

            } else {
                yjLiving.setIkisugi(false);
                yjLiving.setGrantedIkisugiEntity(null);
            }

            boolean coma = livingEntity.hasEffect(YJMobEffects.COMA.vanillaHolder());

            if (coma != yjLiving.isComaSync()) {
                yjLiving.setComaSync(coma);
                YJUtils.doPlayers(livingEntity.level(), livingEntity.blockPosition(), p -> NetworkManager.sendToPlayer(p, new YJPackets.ComaSyncMessage(livingEntity.getId(), coma)));
            }

            if (livingEntity.hasEffect(YJMobEffects.COMA.vanillaHolder()) && yjLiving.getSleepingPos() == null) {
                var efct = livingEntity.getEffect(YJMobEffects.COMA.vanillaHolder());
                if (efct != null) {
                    float ra = ((float) efct.getAmplifier() + 1) / 256f;
                    if (livingEntity.getRandom().nextInt((int) (100 - (99 * ra))) == 0) {
                        livingEntity.level().playSound(null, livingEntity, YJSoundEvents.TON_STAGGER.get(), SoundSource.VOICE, 1, 1);
                    }
                }
            }

            if (yjLiving.getYJPortalCoolDown() > 0)
                yjLiving.setYJPortalCoolDown(yjLiving.getYJPortalCoolDown() - 1);

            if (!yjLiving.canYJPortalUse() && yjLiving.getYJPortalCoolDown() <= 0 && !livingEntity.level().getBlockState(livingEntity.blockPosition()).is(YJBlocks.YJ_PORTAL.get()))
                yjLiving.setYJPortalUse(true);
        }
    }

    public static void onLivingDrop(LivingEntity livingEntity, DamageSource source, Consumer<ItemStack> dropAppender) {
        if (livingEntity.getMaxHealth() >= 100 && source.is(YJDamageTypes.IKISUGI)) {
            dropAppender.accept(new ItemStack(YJItems.YJ_STAR.get()));
        }
    }
}
