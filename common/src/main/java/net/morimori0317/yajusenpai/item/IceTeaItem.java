package net.morimori0317.yajusenpai.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.entity.YJLivingEntity;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class IceTeaItem extends Item {

    public IceTeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide() && !(attacker instanceof ServerPlayer player && player.getCooldowns().isOnCooldown(this)) && canAttackIceTea(target)) {
            attackIceTea(itemStack, attacker, target);
        }
        return super.hurtEnemy(itemStack, target, attacker);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (!player.getCooldowns().isOnCooldown(YJItems.ICE_TEA.get()) && canAttackIceTea(livingEntity)) {
            attackIceTea(itemStack, player, livingEntity);
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        }
        return InteractionResult.PASS;
    }

    public static boolean canAttackIceTea(LivingEntity target) {
        if (((YJLivingEntity) target).getSleepingPos() != null)
            return false;
        return !((YJLivingEntity) target).isComa();
    }

    public static void attackIceTea(ItemStack itemStack, LivingEntity attacker, LivingEntity target) {
        target.addEffect(new MobEffectInstance(YJMobEffects.COMA.get(), 10000, 2));
        if (!attacker.level().isClientSide) {
            attacker.level().playSound(null, attacker, YJSoundEvents.YJ_OTTODAIJOUBUKA.get(), SoundSource.VOICE, 3, 1);

            if (attacker instanceof ServerPlayer player) {
                player.getCooldowns().addCooldown(YJItems.ICE_TEA.get(), 20);
                if (!player.getAbilities().instabuild)
                    itemStack.shrink(1);
            } else {
                itemStack.shrink(1);
            }
        }
    }
}
