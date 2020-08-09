package net.morimori.yjsnpimod.effect;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.registries.IForgeRegistry;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJEffects {
    public static final Effect COMA = new ComaEffect(EffectType.HARMFUL, 9699539).setRegistryName(YJSNPIMOD.MODID, "coma").addAttributesModifier(Attributes.field_233821_d_, "A114514E-7CE8-4030-940E-514C1F160890", (double)-0.15F, AttributeModifier.Operation.MULTIPLY_TOTAL);

    public static void registerEffect(IForgeRegistry<Effect> r) {
        registryItem(r, COMA);
    }

    private static void registryItem(IForgeRegistry<Effect> r, Effect i) {
        r.register(i);
    }

}
