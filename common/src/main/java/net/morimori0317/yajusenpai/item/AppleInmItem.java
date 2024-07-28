package net.morimori0317.yajusenpai.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import org.jetbrains.annotations.NotNull;

public class AppleInmItem extends Item {
    public AppleInmItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (!level.isClientSide) {
            MobEffectInstance effectInstance = null;

            if (!livingEntity.hasEffect(YJMobEffects.IKISUGI.vanillaHolder()) && level.random.nextFloat() <= 0.114514f) {
                effectInstance = new MobEffectInstance(YJMobEffects.IKISUGI.vanillaHolder(), YJMobEffects.IKISUGI_DIE_TIME, 0);
            } else if (level.random.nextFloat() <= 0.1919) {
                effectInstance = new MobEffectInstance(YJMobEffects.COMA.vanillaHolder(), 20 * 40, 0);
            } else if (level.random.nextFloat() <= 0.810) {
                effectInstance = new MobEffectInstance(YJMobEffects.BEAST_FICTION.vanillaHolder(), 20 * 60, 0);
            }

            if (effectInstance != null) {
                livingEntity.addEffect(effectInstance);
            }
        }

        return super.finishUsingItem(itemStack, level, livingEntity);
    }
}