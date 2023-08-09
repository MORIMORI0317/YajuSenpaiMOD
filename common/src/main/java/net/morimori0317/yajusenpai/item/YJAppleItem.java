package net.morimori0317.yajusenpai.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.handler.CommonHandler;

public class YJAppleItem extends Item {
    public YJAppleItem(Properties properties) {
        super(properties);
    }

    @Override
    protected String getOrCreateDescriptionId() {
        return "item.minecraft.apple";
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (isEdible() && !level.isClientSide()) {
            MobEffectInstance effectInstance = null;

            if (!livingEntity.hasEffect(YJMobEffects.IKISUGI.get()) && level.random.nextFloat() <= 0.114514f)
                effectInstance = new MobEffectInstance(YJMobEffects.IKISUGI.get(), CommonHandler.IKISUGI_DIE_TIME, 0);
            else if (level.random.nextFloat() <= 0.1919)
                effectInstance = new MobEffectInstance(YJMobEffects.COMA.get(), 20 * 40, 0);
            else if (level.random.nextFloat() <= 0.810)
                effectInstance = new MobEffectInstance(YJMobEffects.BEAST_FICTION.get(), 20 * 60, 0);

            if (effectInstance != null)
                livingEntity.addEffect(effectInstance);
        }
        return super.finishUsingItem(itemStack, level, livingEntity);
    }
}