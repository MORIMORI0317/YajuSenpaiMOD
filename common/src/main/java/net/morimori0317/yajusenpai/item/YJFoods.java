package net.morimori0317.yajusenpai.item;

import com.google.common.base.Suppliers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.morimori0317.yajusenpai.effect.YJMobEffects;

import java.util.function.Supplier;

public class YJFoods {
    public static final FoodProperties APPLE_INM = new FoodProperties.Builder().nutrition(4).saturationModifier(0.3F).build();

    public static final Supplier<FoodProperties> ICE_TEA = Suppliers.memoize(() ->
            new FoodProperties.Builder().nutrition(6)
                    .saturationModifier(1.2F)
                    .effect(new MobEffectInstance(YJMobEffects.COMA.vanillaHolder(), 10000, 2), 1f)
                    .alwaysEdible()
                    .build());

    public static final Supplier<FoodProperties> YJ_POTATO = Suppliers.memoize(() ->
            new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationModifier(0.3F)
                    .effect(new MobEffectInstance(YJMobEffects.BEAST_FICTION.vanillaHolder(), 600, 0), 0.3F)
                    .build());

    public static final Supplier<FoodProperties> YJ_BAKED_POTATO = Suppliers.memoize(() ->
            new FoodProperties.Builder()
                    .nutrition(5)
                    .saturationModifier(0.6F)
                    .effect(new MobEffectInstance(YJMobEffects.BEAST_FICTION.vanillaHolder(), 600, 0), 0.6F)
                    .build());
}
