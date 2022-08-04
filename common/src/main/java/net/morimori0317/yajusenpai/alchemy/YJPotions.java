package net.morimori0317.yajusenpai.alchemy;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.function.Supplier;

public class YJPotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(YajuSenpai.MODID, Registry.POTION_REGISTRY);
    public static final RegistrySupplier<Potion> BEASTFICTION = register("beastfiction", () -> new MobEffectInstance(YJMobEffects.BEASTFICTION.get(), 20 * 490));
    public static final RegistrySupplier<Potion> LONG_BEASTFICTION = register("long_beastfiction", () -> new MobEffectInstance(YJMobEffects.BEASTFICTION.get(), 20 * 1159));
    public static final RegistrySupplier<Potion> IKISUGI = register("ikisugi", () -> new MobEffectInstance(YJMobEffects.IKISUGI.get(), 20 * 65));
    public static final RegistrySupplier<Potion> COMA = register("coma", () -> new MobEffectInstance(YJMobEffects.COMA.get(), 1800));
    public static final RegistrySupplier<Potion> LONG_COMA = register("long_coma", () -> new MobEffectInstance(YJMobEffects.COMA.get(), 4800));
    public static final RegistrySupplier<Potion> STRONG_COMA = register("strong_coma", () -> new MobEffectInstance(YJMobEffects.COMA.get(), 1800, 3));

    private static RegistrySupplier<Potion> register(@Nullable String name, Supplier<MobEffectInstance>... mobEffectInstances) {
        return POTIONS.register(name, () -> {
            MobEffectInstance[] effects = Arrays.stream(mobEffectInstances).map(Supplier::get).toList().toArray(new MobEffectInstance[0]);
            return new Potion(name, effects);
        });
    }

    public static void init() {
        POTIONS.register();
    }
}
