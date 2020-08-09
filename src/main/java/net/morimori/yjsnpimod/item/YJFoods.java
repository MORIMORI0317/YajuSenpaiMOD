package net.morimori.yjsnpimod.item;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.morimori.yjsnpimod.effect.YJEffects;

public class YJFoods {
    public static final Food BAKED_POTATO_SENPAI = (new Food.Builder()).hunger(5).saturation(0.6F).build();
    public static final Food ICE_TEA = (new Food.Builder()).hunger(6).saturation(0.1F).effect(new EffectInstance(YJEffects.COMA, 10000, 2), 1.0F).build();
}
