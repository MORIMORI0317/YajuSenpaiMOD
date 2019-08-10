package com.morimori.yjsnpimod.effects;

import com.morimori.yjsnpimod.Variable;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Potion;

public class MODPotions {
	public static final Potion BEASTIFICATIO = new Potion(new EffectInstance(MODEffects.BEASTIFICATIO, 3600)).setRegistryName(Variable.MODID, "beast_fiction");
	public static final Potion LONG_BEASTIFICATIO = new Potion("beast_fiction",new EffectInstance(MODEffects.BEASTIFICATIO, 9600)).setRegistryName(Variable.MODID, "long_beast_fiction");
	public static final Potion STRONG_BEASTIFICATIO = new Potion("beast_fiction",new EffectInstance(MODEffects.BEASTIFICATIO, 1800,1)).setRegistryName(Variable.MODID, "strong_beast_fiction");

	public static final Potion CUM = new Potion(new EffectInstance(MODEffects.CUM, 3600)).setRegistryName(Variable.MODID, "cum");
	public static final Potion LONG_CUM = new Potion("cum",new EffectInstance(MODEffects.CUM, 9600)).setRegistryName(Variable.MODID, "long_cum");
	public static final Potion STRONG_CUM = new Potion("cum",new EffectInstance(MODEffects.CUM, 1800,1)).setRegistryName(Variable.MODID, "strong_cum");
	public static final Potion MORE_STRONG_CUM = new Potion("cum",new EffectInstance(MODEffects.CUM, 900,2)).setRegistryName(Variable.MODID, "more_strong_cum");
	public static final Potion MORE_LONG_CUM = new Potion("cum",new EffectInstance(MODEffects.CUM, 12600)).setRegistryName(Variable.MODID, "more_long_cum");

}
