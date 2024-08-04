package net.morimori0317.yajusenpai.server.handler;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.LootEvent;
import dev.architectury.event.events.common.TickEvent;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.utils.value.IntValue;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.block.InmBlock;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.enchantment.YJEnchantmentEffectComponents;
import net.morimori0317.yajusenpai.entity.YJLivingEntityAccessor;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageSources;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageTypeTags;
import net.morimori0317.yajusenpai.explatform.YJExpectPlatform;
import net.morimori0317.yajusenpai.item.IceTeaItem;
import net.morimori0317.yajusenpai.item.SoftSmartphoneItem;
import net.morimori0317.yajusenpai.item.YJDataComponents;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.server.level.YJLootTables;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.apache.commons.lang3.mutable.MutableInt;

import java.util.function.Consumer;

public final class ServerHandler {

    public static final RegistrySupplier<SoundEvent>[] KYN_ATUI_SOUNDS = new
            RegistrySupplier[]{
            YJSoundEvents.KYN_ATUI1,
            YJSoundEvents.KYN_ATUI2,
            YJSoundEvents.KYN_ATUI3,
            YJSoundEvents.KYN_ATUI4,
            YJSoundEvents.KYN_ATUI5,
            YJSoundEvents.KYN_ATUI6,
            YJSoundEvents.KYN_ATUI7,
            YJSoundEvents.KYN_ATUI8,
            YJSoundEvents.KYN_ATUI9,
            YJSoundEvents.KYN_ATUI10,
            YJSoundEvents.KYN_ATUI11,
            YJSoundEvents.KYN_ATUI12,
            YJSoundEvents.KYN_ATUI13,
            YJSoundEvents.KYN_ATUI14,
            YJSoundEvents.KYN_ATUI15,
            YJSoundEvents.KYN_ATUI16,
            YJSoundEvents.KYN_ATUI17,
            YJSoundEvents.KYN_ATUI18,
            YJSoundEvents.KYN_ATUI19,
            YJSoundEvents.KYN_ATUI20,
            YJSoundEvents.KYN_ATUI21,
            YJSoundEvents.KYN_ATUI22,
            YJSoundEvents.KYN_ATUI23,
            YJSoundEvents.KYN_ATUI24,
            YJSoundEvents.KYN_ATUI25,
            YJSoundEvents.KYN_ATUI26,
            YJSoundEvents.KYN_ATUI27,
            YJSoundEvents.KYN_ATUI28
    };

    public static void init() {
        EntityEvent.LIVING_DEATH.register(ServerHandler::onLivingDie);
        LootEvent.MODIFY_LOOT_TABLE.register(YJLootTables::onLootTableModify);
        TickEvent.PLAYER_POST.register(ServerHandler::onPlayerTick);
        EntityEvent.LIVING_HURT.register(ServerHandler::onLivingHurt);
    }

    private static EventResult onLivingHurt(LivingEntity target, DamageSource source, float amount) {
        Entity attacker = source.getEntity();

        if (attacker instanceof LivingEntity livingAttacker) {
            for (InteractionHand hand : InteractionHand.values()) {
                var item = livingAttacker.getItemInHand(hand);
                if (item.is(YJItems.ICE_TEA.get()) && IceTeaItem.canAttackIceTea(target)) {
                    IceTeaItem.attackIceTea(item, livingAttacker, target);
                    break;
                }

                if (item.is(YJItems.SOFT_SMARTPHONE.get()) && SoftSmartphoneItem.canIkisugi(livingAttacker, target)) {
                    SoftSmartphoneItem.startIkisugi(livingAttacker.level(), livingAttacker, target);
                    break;
                }
            }

            InmBlock inmBlock = null;

            if (livingAttacker.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof InmBlock inmBaseBlock) {
                inmBlock = inmBaseBlock;
            } else {
                ItemStack weapon = source.getWeaponItem();
                if (weapon != null && weapon.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof InmBlock inmBaseBlock) {
                    inmBlock = inmBaseBlock;
                }
            }

            if (inmBlock != null) {
                inmBlock.onAttack(livingAttacker.level(), livingAttacker);
            }
        }

        return EventResult.pass();
    }

    private static EventResult onLivingDie(LivingEntity livingEntity, DamageSource source) {
        Level level = livingEntity.level();

        if (!level.isClientSide()) {
            ItemStack headStack = livingEntity.getItemBySlot(EquipmentSlot.HEAD);

            if (source.is(YJDamageTypeTags.IS_IKISUGI)) {
                level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.YJ_NNA.get(), SoundSource.VOICE, 3, 1);

                Entity attackerEntity = source.getEntity();
                if (attackerEntity != null && livingEntity.getRandom().nextInt(1919) == 0) {
                    if (attackerEntity instanceof LivingEntity srcLiving) {
                        srcLiving.hurt(YJDamageSources.ikisugi(level, livingEntity), srcLiving.getMaxHealth());
                    } else {
                        attackerEntity.hurt(YJDamageSources.ikisugi(level, livingEntity), 114514);
                        level.playSound(null, attackerEntity.getX(), attackerEntity.getY(), attackerEntity.getZ(), YJSoundEvents.YJ_NNA.get(), SoundSource.VOICE, 3, 1);
                    }
                }
            } else {
                if (livingEntity.hasEffect(YJMobEffects.COMA.vanillaHolder())) {
                    level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.TON_SEKAINOTON.get(), SoundSource.VOICE, 3, 1);
                }

                if (YJUtils.isYJSound(livingEntity)) {
                    level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.YJ_NNA.get(), SoundSource.NEUTRAL, 3, 1);
                }
            }

            if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof InmBlock inmBaseBlock) {
                inmBaseBlock.onHeadEquipmentDie(level, livingEntity);
            }

            if (headStack.is(YJItems.CYCLOPS_SUNGLASSES.get())) {
                level.playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.CYCLOPS_NAZOOTO.get(), SoundSource.NEUTRAL, 3, 1);
            }
        }

        return EventResult.pass();
    }

    public static void onUpdateItemDamage(LivingEntity livingEntity, ItemStack stack, IntValue damageRef) {
        if (damageRef.get() <= 0 || livingEntity == null || livingEntity.level().isClientSide()) {
            return;
        }

        if (EnchantmentHelper.has(stack, YJEnchantmentEffectComponents.KATYOU_BROKEN.get())) {
            boolean brokenFlag = livingEntity.getRandom().nextInt(30) == 0;
            livingEntity.level().playSound(null, livingEntity, brokenFlag ? YJSoundEvents.KATYOU_BROKEN.get() : YJSoundEvents.KATYOU.get(), SoundSource.NEUTRAL, 0.5f, 1);
            int damage = getBrokenDamage(stack);
            if (brokenFlag && damageRef.get() < damage) {
                damageRef.accept(damage);
            }
        }
    }

    public static void onItemBreak(LivingEntity livingEntity, ItemStack stack) {
        if (livingEntity == null || livingEntity.level().isClientSide()) {
            return;
        }

        if (EnchantmentHelper.has(stack, YJEnchantmentEffectComponents.GABA_ANA_DADDY.get())) {
            livingEntity.level().playSound(null, livingEntity, YJSoundEvents.GABAANADADDY_IKUYO.get(), SoundSource.NEUTRAL, 0.5f, 1);
        }

        MutableInt oremoIcchauCount = new MutableInt();

        iterateEntityStorage(livingEntity, itStack -> {
            if (itStack == stack || !EnchantmentHelper.has(itStack, YJEnchantmentEffectComponents.GABA_ANA_DADDY.get())) {
                return;
            }

            int preDamage = itStack.getDamageValue();
            int damage = itStack.getDamageValue() + getBrokenDamage(itStack);
            itStack.setDamageValue(damage);

            boolean flag = false;

            if (damage >= itStack.getMaxDamage()) {
                itStack.shrink(1);
                flag = true;
            }

            if (preDamage < damage) {
                flag = true;
            }

            if (flag) {
                oremoIcchauCount.increment();
            }
        });

        if (oremoIcchauCount.intValue() > 0) {
            livingEntity.level().playSound(null, livingEntity, YJSoundEvents.GABAANADADDY_OREMOITCHAU.get(), SoundSource.NEUTRAL, oremoIcchauCount.intValue(), 1);
        }
    }

    private static void iterateEntityStorage(LivingEntity livingEntity, Consumer<ItemStack> consumer) {
        for (EquipmentSlot eqSlot : EquipmentSlot.values()) {
            ItemStack eqSlotStack = livingEntity.getItemBySlot(eqSlot);
            consumer.accept(eqSlotStack);
        }

        if (livingEntity instanceof ServerPlayer player) {
            player.getInventory().items.forEach(consumer);
        }
    }

    private static int getBrokenDamage(ItemStack stack) {
        int damage = stack.getMaxDamage() - stack.getDamageValue();

        if (YJExpectPlatform.isElytraItem(stack)) {
            damage -= 1;
        }

        return damage;
    }

    public static void onItemInventoryTick(Level level, Entity entity, ItemStack stack) {
        if (EnchantmentHelper.has(stack, YJEnchantmentEffectComponents.GABA_ANA_DADDY.get())
                && entity.getRandom().nextInt(20 * 60 * 2) == 0) {

            if (entity instanceof ServerPlayer player) {
                YJUtils.giveItemToPlayer(player, YJUtils.createFutoiSeaChicken());
            } else {
                YJUtils.giveItemToEntity(entity, YJUtils.createFutoiSeaChicken());
            }

            level.playSound(null, entity, YJSoundEvents.GABAANADADDY_FUTOI_SEA_CHICKEN_GAHOSHII.get(), SoundSource.NEUTRAL, 0.3f, 1);
        }
    }

    public static void onLivingHurtSound(LivingEntity livingEntity, DamageSource source, float amount) {
        Level level = livingEntity.level();

        if (level.isClientSide()) {
            return;
        }

        if (source.is(DamageTypeTags.IS_FIRE)) {
            int kynIndex = -1;
            for (int i = 0; i < EquipmentSlot.values().length; i++) {
                EquipmentSlot slot = EquipmentSlot.values()[i];
                ItemStack stack = livingEntity.getItemBySlot(slot);

                if (EnchantmentHelper.has(stack, YJEnchantmentEffectComponents.KYN.get())) {
                    kynIndex = i;
                    break;
                }
            }

            if (kynIndex >= 0) {
                int kynCount = 0;
                int kynItemCount = 0;

                for (int i = kynIndex; i < EquipmentSlot.values().length; i++) {
                    EquipmentSlot slot = EquipmentSlot.values()[i];
                    ItemStack stack = livingEntity.getItemBySlot(slot);
                    if (i == kynIndex || EnchantmentHelper.has(stack, YJEnchantmentEffectComponents.KYN.get())) {
                        kynCount = Math.max(kynCount, stack.getOrDefault(YJDataComponents.KYN_COUNT.get(), 0));
                        kynItemCount++;
                    }
                }

                level.playSound(null, livingEntity, KYN_ATUI_SOUNDS[Mth.clamp(kynCount, 0, KYN_ATUI_SOUNDS.length - 1)].get(), SoundSource.NEUTRAL, kynItemCount, 1);
                kynCount = (kynCount + 1) % KYN_ATUI_SOUNDS.length;

                for (int i = kynIndex; i < EquipmentSlot.values().length; i++) {
                    EquipmentSlot slot = EquipmentSlot.values()[i];
                    ItemStack stack = livingEntity.getItemBySlot(slot);
                    if (i == kynIndex || EnchantmentHelper.has(stack, YJEnchantmentEffectComponents.KYN.get())) {
                        stack.set(YJDataComponents.KYN_COUNT.get(), kynCount);
                    }
                }
            }
        }


        if (livingEntity.hasEffect(YJMobEffects.COMA.vanillaHolder())) {
            livingEntity.level().playSound(null, livingEntity, YJSoundEvents.TON_STAGGER.get(), SoundSource.VOICE, 1, 1);
        }

        if (YJUtils.isYJSound(livingEntity)) {
            livingEntity.level().playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.YJ_DAMEGE.get(), SoundSource.NEUTRAL, 3, 1);
        }

        if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof InmBlock inmBaseBlock) {
            inmBaseBlock.onHeadEquipmentDamage(level, source, livingEntity);
        }

        if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).is(YJItems.CYCLOPS_SUNGLASSES.get())) {
            livingEntity.level().playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), YJSoundEvents.CYCLOPS_NAZOOTO.get(), SoundSource.NEUTRAL, 3, 1);
        }

    }

    private static void onPlayerTick(Player player) {
        YJLivingEntityAccessor yjLiving = (YJLivingEntityAccessor) player;

        if (yjLiving.yajuSenpai$getSleepingPos() != null) {
            var bs = player.level().getBlockState(yjLiving.yajuSenpai$getSleepingPos());
            if (bs.is(YJBlocks.BIG_PILLOW.get())) {
                var pos = yjLiving.yajuSenpai$getSleepingPos();
                player.setPos(pos.getX() + 0.5, pos.getY() + bs.getCollisionShape(player.level(), yjLiving.yajuSenpai$getSleepingPos()).max(Direction.Axis.Y), pos.getZ() + 0.5);
            }
        }
    }
}
