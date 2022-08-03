package net.morimori0317.yajusenpai.item;

import com.mojang.datafixers.util.Pair;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class IceTeaItem extends Item {

    public IceTeaItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack itemStack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level.isClientSide() && !(attacker instanceof ServerPlayer player && player.getCooldowns().isOnCooldown(this)) && !target.hasEffect(YJMobEffects.COMA.get())) {
            for (Pair<MobEffectInstance, Float> effect : getFoodProperties().getEffects()) {
                target.addEffect(effect.getFirst());
            }

            attacker.level.playSound(null, attacker, YJSoundEvents.YJ_OTTODAIJOUBUKA.get(), SoundSource.VOICE, 3, 1);

            if (attacker instanceof ServerPlayer player) {
                player.getCooldowns().addCooldown(this, 20);
                if (!player.getAbilities().instabuild)
                    itemStack.shrink(1);
            } else {
                itemStack.shrink(1);
            }
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
}
