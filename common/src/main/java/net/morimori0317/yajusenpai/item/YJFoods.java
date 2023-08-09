package net.morimori0317.yajusenpai.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.morimori0317.yajusenpai.effect.YJMobEffects;

import java.util.function.Supplier;

public class YJFoods {
    public static final FoodProperties APPLE = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build();
    public static final Supplier<FoodProperties> ICE_TEA = () -> new FoodProperties.Builder().nutrition(6).saturationMod(1.2F).effect(new MobEffectInstance(YJMobEffects.COMA.get(), 10000, 2), 1f).alwaysEat().build();
    public static final Supplier<FoodProperties> YJ_POTATO = () -> new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).effect(new MobEffectInstance(YJMobEffects.BEAST_FICTION.get(), 600, 0), 0.3F).build();
    public static final Supplier<FoodProperties> YJ_BAKED_POTATO = () -> new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).effect(new MobEffectInstance(YJMobEffects.BEAST_FICTION.get(), 600, 0), 0.6F).build();
}
