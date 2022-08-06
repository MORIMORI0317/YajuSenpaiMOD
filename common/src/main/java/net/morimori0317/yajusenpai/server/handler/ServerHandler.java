package net.morimori0317.yajusenpai.server.handler;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.event.events.common.TickEvent;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.SoundType;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.EnityIkisugiDamageSource;
import net.morimori0317.yajusenpai.entity.IkisugiDamageSource;
import net.morimori0317.yajusenpai.entity.YJDamageSource;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.item.CyclopsSunglassesItem;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJPlayerUtils;
import net.morimori0317.yajusenpai.util.YJUtils;

public class ServerHandler {
    public static void init() {
        TickEvent.PLAYER_POST.register(ServerHandler::onPlayerTick);
        EntityEvent.LIVING_DEATH.register(ServerHandler::onLivingDie);
        InteractionEvent.INTERACT_ENTITY.register(ServerHandler::onEntityInteract);
    }

    private static EventResult onEntityInteract(Player player, Entity entity, InteractionHand hand) {
        /*if (!entity.level.isClientSide()) {
            ItemStack itemStack = player.getItemInHand(hand);
            if (itemStack.is(YJItems.ICE_TEA.get()) && entity instanceof LivingEntity livingEntity) {
                if (!player.getCooldowns().isOnCooldown(YJItems.ICE_TEA.get()) && !livingEntity.hasEffect(YJMobEffects.COMA.get())) {
                    for (Pair<MobEffectInstance, Float> effect : YJItems.ICE_TEA.get().getFoodProperties().getEffects()) {
                        livingEntity.addEffect(effect.getFirst());
                    }

                    player.level.playSound(null, player, YJSoundEvents.YJ_OTTODAIJOUBUKA.get(), SoundSource.VOICE, 3, 1);

                    player.getCooldowns().addCooldown(YJItems.ICE_TEA.get(), 20);
                    if (!player.getAbilities().instabuild)
                        itemStack.shrink(1);
                }
            }
        }*/
        return EventResult.pass();
    }

    private static EventResult onLivingDie(LivingEntity livingEntity, DamageSource source) {
        if (source instanceof IkisugiDamageSource || source instanceof EnityIkisugiDamageSource) {
            livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.YJ_NNA.get(), SoundSource.VOICE, 3, 1);
            if (source instanceof EnityIkisugiDamageSource ikisugiDamageSource && ikisugiDamageSource.getEntity() != null) {
                if (livingEntity.getRandom().nextInt(19) == 0) {
                    var srce = ikisugiDamageSource.getEntity();
                    if (srce instanceof LivingEntity srcLiving) {
                        srcLiving.hurt(YJDamageSource.IKISUGI, srcLiving.getMaxHealth());
                    } else {
                        srce.hurt(YJDamageSource.IKISUGI, 114514);
                        livingEntity.level.playSound(null, srce.getX(), srce.getY(), srce.getZ(), YJSoundEvents.YJ_NNA.get(), SoundSource.VOICE, 3, 1);
                    }
                }

            }
        } else if (livingEntity.hasEffect(YJMobEffects.COMA.get())) {
            livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.TON_SEKAINOTON.get(), SoundSource.VOICE, 3, 1);
        }

        if (!livingEntity.getLevel().isClientSide()) {
            if (YJUtils.isYJSound(livingEntity))
                livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.YJ_NNA.get(), SoundSource.NEUTRAL, 3, 1);

            SoundType ist = YJUtils.getInmSoundType(livingEntity.getItemBySlot(EquipmentSlot.HEAD));
            if (ist != null)
                livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), ist.getBreakSound(), SoundSource.NEUTRAL, 3, 1);

            if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof CyclopsSunglassesItem)
                livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.CYCLOPS_AIKISO.get(), SoundSource.NEUTRAL, 3, 1);
        }

        return EventResult.pass();
    }

    public static void onLivingHurtInvoker(LivingEntity livingEntity, DamageSource source, float amount) {
        if (!livingEntity.getLevel().isClientSide() && source.isFire()) {
            int kc = -1;
            int akc = 0;
            for (ItemStack item : livingEntity.getArmorSlots()) {
                if (YJUtils.hasKynEnchantment(item)) {
                    int ikc = 0;
                    if (item.getTag() != null)
                        ikc = item.getTag().getInt("kyn_count");
                    kc = Math.max(kc, ikc);
                    akc++;
                }
            }

            if (kc >= 0) {
                livingEntity.level.playSound(null, livingEntity, YJSoundEvents.KYN_ATUIs[Mth.clamp(kc, 0, YJSoundEvents.KYN_ATUIs.length - 1)].get(), SoundSource.NEUTRAL, akc, 1);
                kc = (kc + 1) % YJSoundEvents.KYN_ATUIs.length;
                for (ItemStack item : livingEntity.getArmorSlots()) {
                    if (YJUtils.hasKynEnchantment(item))
                        item.getOrCreateTag().putInt("kyn_count", kc);
                }
            }
        }

        if (!livingEntity.getLevel().isClientSide()) {
            if (YJUtils.isYJSound(livingEntity))
                livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.YJ_DAMEGE.get(), SoundSource.NEUTRAL, 3, 1);

            SoundType ist = YJUtils.getInmSoundType(livingEntity.getItemBySlot(EquipmentSlot.HEAD));
            if (ist != null)
                livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), ist.getHitSound(), SoundSource.NEUTRAL, 3, 1);

            if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof CyclopsSunglassesItem)
                livingEntity.level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.CYCLOPS_NAZOOTO.get(), SoundSource.NEUTRAL, 3, 1);
        }

    }

    private static void onPlayerTick(Player player) {
        YJLivingEntity yjLiving = (YJLivingEntity) player;

        if (player instanceof ServerPlayer serverPlayer) {
            for (ItemStack item : serverPlayer.getArmorSlots()) {
                if (YJUtils.hasGabaAnaDaddyEnchantment(item))
                    futoiSeaChickenTick(serverPlayer);
            }
        }

        if (yjLiving.getSleepingPos() != null) {
            var bs = player.level.getBlockState(yjLiving.getSleepingPos());
            if (bs.is(YJBlocks.BIG_PILLOW.get())) {
                var pos = yjLiving.getSleepingPos();
                player.setPos(pos.getX() + 0.5, pos.getY() + bs.getCollisionShape(player.level, yjLiving.getSleepingPos()).max(Direction.Axis.Y), pos.getZ() + 0.5);
            }
        }
    }

    public static void futoiSeaChickenTick(ServerPlayer serverPlayer) {
        if (serverPlayer.getRandom().nextInt(20 * 60 * 2) == 0) {
            YJPlayerUtils.giveItem(serverPlayer, YJUtils.createFutoiSeaChicken());
            serverPlayer.level.playSound(null, serverPlayer, YJSoundEvents.GABAANADADDY_FUTOI_SEA_CHICKEN_GAHOSHII.get(), SoundSource.NEUTRAL, 0.3f, 1);
        }
    }
}
