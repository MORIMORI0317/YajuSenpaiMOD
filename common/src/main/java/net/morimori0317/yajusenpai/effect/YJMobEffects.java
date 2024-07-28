package net.morimori0317.yajusenpai.effect;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.util.RegistryHolderEntry;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.function.Supplier;

public class YJMobEffects {
    public static int IKISUGI_DIE_TIME = 20 * 8 + 3;

    private static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(YajuSenpai.MODID, Registries.MOB_EFFECT);

    public static final RegistryHolderEntry<MobEffect> BEAST_FICTION = register("beast_fiction", () -> new YJMobEffect(MobEffectCategory.HARMFUL, 5056011));
    public static final RegistryHolderEntry<MobEffect> IKISUGI = register("ikisugi", () -> new YJMobEffect(MobEffectCategory.HARMFUL, 16119285));
    public static final RegistryHolderEntry<MobEffect> COMA = register("coma", () -> new YJMobEffect(MobEffectCategory.HARMFUL, 9699539)
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, YJUtils.modLoc("effect.coma"), -0.15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    private static RegistryHolderEntry<MobEffect> register(String name, Supplier<MobEffect> effectSupplier) {
        return new RegistryHolderEntry<>(MOB_EFFECTS.register(name, effectSupplier));
    }

    public static void init() {
        MOB_EFFECTS.register();
    }
}
