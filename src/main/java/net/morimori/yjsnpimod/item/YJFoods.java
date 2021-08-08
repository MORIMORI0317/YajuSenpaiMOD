package net.morimori.yjsnpimod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class YJFoods {
    public static final FoodProperties APPLE = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build();
    public static final FoodProperties ICE_TEA = new FoodProperties.Builder().nutrition(6).saturationMod(1.2F).effect(new MobEffectInstance(MobEffects.CONFUSION, 200), 1f).build();
}
