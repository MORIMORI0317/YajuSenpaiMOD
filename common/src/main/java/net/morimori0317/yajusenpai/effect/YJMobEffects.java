package net.morimori0317.yajusenpai.effect;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.morimori0317.yajusenpai.YajuSenpai;

import java.util.function.Supplier;

public class YJMobEffects {
    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(YajuSenpai.MODID, Registry.MOB_EFFECT_REGISTRY);

    public static MobEffect RAW_BEASTFICTION;

    public static final RegistrySupplier<MobEffect> BEASTFICTION = register("beastfiction", () -> new YJMobEffect(MobEffectCategory.HARMFUL, 5056011));
    public static final RegistrySupplier<MobEffect> IKISUGI = register("ikisugi", () -> new YJMobEffect(MobEffectCategory.HARMFUL, 16119285));
    public static final RegistrySupplier<MobEffect> COMA = register("coma", () -> new YJMobEffect(MobEffectCategory.HARMFUL, 9699539).addAttributeModifier(Attributes.MOVEMENT_SPEED, "A114514E-7CE8-4030-940E-514C1F160890", -0.15, AttributeModifier.Operation.MULTIPLY_TOTAL));

    private static RegistrySupplier<MobEffect> register(String name, Supplier<MobEffect> effectSupplier) {
        if ("beastfiction".equals(name)) {
            RAW_BEASTFICTION = effectSupplier.get();
            return MOB_EFFECTS.register(name, () -> RAW_BEASTFICTION);
        }
        return MOB_EFFECTS.register(name, effectSupplier);
    }

    public static void init() {
        MOB_EFFECTS.register();
    }
}
