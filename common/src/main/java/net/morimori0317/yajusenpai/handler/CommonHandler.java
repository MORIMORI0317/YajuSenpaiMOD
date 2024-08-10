package net.morimori0317.yajusenpai.handler;

import dev.architectury.networking.NetworkManager;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.blockentity.BigPillowBlockEntity;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.YJLivingEntityAccessor;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageTypeTags;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.networking.YJPackets;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.function.Consumer;

public class CommonHandler {
    public static int IKISUGI_DIE_TIME = 20 * 8 + 3;

    public static void onLivingTick(LivingEntity livingEntity) {
        YJLivingEntityAccessor yjLiving = (YJLivingEntityAccessor) livingEntity;

        if (!livingEntity.level().isClientSide()) {
            var effect = livingEntity.getEffect(YJMobEffects.IKISUGI.vanillaHolder());
            if (livingEntity.hasEffect(YJMobEffects.IKISUGI.vanillaHolder()) && effect != null) {
                if (effect.getDuration() <= 20) {
                    livingEntity.removeEffect(YJMobEffects.IKISUGI.vanillaHolder());
                    YJUtils.ikisugiKill(livingEntity, yjLiving.yajuSenpai$getGrantedIkisugiEntity());
                }

                if (effect.getDuration() <= IKISUGI_DIE_TIME && !yjLiving.yajuSenpai$isIkisugi()) {
                    yjLiving.yajuSenpai$setIkisugi(true);
                    livingEntity.level().playSound(null, livingEntity, YJSoundEvents.YJ_IKISUGI_ONRY.get(), SoundSource.VOICE, 3, 1);
                }

            } else {
                yjLiving.yajuSenpai$setIkisugi(false);
                yjLiving.yajuSenpai$setGrantedIkisugiEntity(null);
            }

            boolean coma = livingEntity.hasEffect(YJMobEffects.COMA.vanillaHolder());

            if (coma != yjLiving.yajuSenpai$isComaSync()) {
                yjLiving.yajuSenpai$setComaSync(coma);
                YJUtils.doPlayers(livingEntity.level(), livingEntity.blockPosition(), p -> NetworkManager.sendToPlayer(p, new YJPackets.ComaSyncMessage(livingEntity.getId(), coma)));
            }

            if (livingEntity.hasEffect(YJMobEffects.COMA.vanillaHolder()) && yjLiving.yajuSenpai$getSleepingPos() == null) {
                var efct = livingEntity.getEffect(YJMobEffects.COMA.vanillaHolder());
                if (efct != null) {
                    float ra = ((float) efct.getAmplifier() + 1) / 256f;
                    if (livingEntity.getRandom().nextInt((int) (100 - (99 * ra))) == 0) {
                        livingEntity.level().playSound(null, livingEntity, YJSoundEvents.TON_STAGGER.get(), SoundSource.VOICE, 1, 1);
                    }
                }
            }

            if (yjLiving.yajuSenpai$getYJPortalCoolDown() > 0)
                yjLiving.yajuSenpai$setYJPortalCoolDown(yjLiving.yajuSenpai$getYJPortalCoolDown() - 1);

            if (yjLiving.yajuSenpai$getSleepingPos() != null && (!BigPillowBlockEntity.canComa(livingEntity) || !livingEntity.level().getBlockState(yjLiving.yajuSenpai$getSleepingPos()).is(YJBlocks.BIG_PILLOW.get()))) {
                yjLiving.yajuSenpai$setSleepingPos(null);
            }

            if (!yjLiving.yajuSenpai$canYJPortalUse() &&
                    yjLiving.yajuSenpai$getYJPortalCoolDown() <= 0 &&
                    livingEntity.level().getBlockStates(livingEntity.getBoundingBox()).noneMatch(it -> it.is(YJBlocks.YJ_PORTAL.get()))) {

                yjLiving.yajuSenpai$setYJPortalUse(true);
            }

            if (yjLiving.yajuSenpai$isIkisugiSleeping() && yjLiving.yajuSenpai$getSleepingPos() == null) {
                yjLiving.yajuSenpai$setIkisugiSleeping(false);
            }
        }
    }

    public static void onLivingDrop(LivingEntity livingEntity, DamageSource source, Consumer<ItemStack> dropAppender) {
        if (YJUtils.isBoss(livingEntity) && source.is(YJDamageTypeTags.IS_IKISUGI)) {
            dropAppender.accept(new ItemStack(YJItems.YJ_STAR.get()));
        }
    }
}
