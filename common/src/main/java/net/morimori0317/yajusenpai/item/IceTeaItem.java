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
import net.morimori0317.yajusenpai.entity.YJLivingEntityAccessor;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import org.jetbrains.annotations.NotNull;

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
    public @NotNull UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    @Override
    public @NotNull SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public @NotNull SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
    }

    @Override
    public @NotNull InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity livingEntity, InteractionHand interactionHand) {
        if (!player.getCooldowns().isOnCooldown(YJItems.ICE_TEA.get()) && canAttackIceTea(livingEntity)) {
            attackIceTea(itemStack, player, livingEntity);
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        }
        return InteractionResult.PASS;
    }

    public static boolean canAttackIceTea(LivingEntity target) {
        if (((YJLivingEntityAccessor) target).yajuSenpai$getSleepingPos() != null)
            return false;
        return !((YJLivingEntityAccessor) target).yajuSenpai$isComa();
    }

    public static void attackIceTea(ItemStack itemStack, LivingEntity attacker, LivingEntity target) {
        if (!attacker.level().isClientSide) {
            target.addEffect(new MobEffectInstance(YJMobEffects.COMA.vanillaHolder(), 10000, 2));

            SoundEvent soundEvent = attacker.getRandom().nextInt(19) == 0 ? YJSoundEvents.YJ_KUCHIAKEENAHORA.get() : YJSoundEvents.YJ_OTTODAIJOUBUKA.get();
            attacker.level().playSound(null, attacker, soundEvent, SoundSource.NEUTRAL, 3, 1);

            if (attacker instanceof ServerPlayer player) {
                player.getCooldowns().addCooldown(YJItems.ICE_TEA.get(), 20);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
            } else {
                itemStack.shrink(1);
            }
        }
    }
}
