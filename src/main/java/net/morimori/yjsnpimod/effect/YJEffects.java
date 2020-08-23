package net.morimori.yjsnpimod.effect;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.morimori.yjsnpimod.YJSNPIMOD;

import java.util.ArrayList;
import java.util.List;

public class YJEffects {
    public static List<Effect> MOD_EFFECT = new ArrayList<Effect>();

    public static final Effect BEASTFICTION = register("beastfiction", new YBaseEffect(EffectType.HARMFUL, 5056011));
    public static final Effect CUM = register("cum", new YBaseEffect(EffectType.HARMFUL, 16119285));
    public static final Effect COMA = register("coma", new YBaseEffect(EffectType.HARMFUL, 9699539).addAttributesModifier(Attributes.field_233821_d_, "A114514E-7CE8-4030-940E-514C1F160890", (double) -0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL));


    private static Effect register(String name, Effect effect) {
        MOD_EFFECT.add(effect.setRegistryName(YJSNPIMOD.MODID, name));
        return effect;
    }
}
