package com.morimori.yjsnpimod.effects;

import com.morimori.yjsnpimod.Variable;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class MODEffects {
	public static final Effect BEASTIFICATIO = new BeastFictionEffect(EffectType.HARMFUL, 5056011).setRegistryName(Variable.MODID,"beastfiction");
	public static final Effect CUM = new CumEffect(EffectType.HARMFUL, 16119285).setRegistryName(Variable.MODID,"cum");
	public static final Effect COMA = new CumEffect(EffectType.HARMFUL, 16119285).setRegistryName(Variable.MODID,"coma");



}
