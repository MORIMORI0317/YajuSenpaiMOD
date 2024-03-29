package net.morimori0317.yajusenpai.alchemy;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.item.YJItems;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class YJPotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(YajuSenpai.MODID, Registries.POTION);
    public static final Map<RegistrySupplier<Potion>, Potion> RAW = new HashMap<>();

    public static final RegistrySupplier<Potion> BEAST_FICTION = register("beast_fiction", () -> new MobEffectInstance(YJMobEffects.RAW.get(YJMobEffects.BEAST_FICTION), 20 * 490));
    public static final RegistrySupplier<Potion> LONG_BEAST_FICTION = register("long_beast_fiction", "beast_fiction", () -> new MobEffectInstance(YJMobEffects.RAW.get(YJMobEffects.BEAST_FICTION), 20 * 1159));
    public static final RegistrySupplier<Potion> IKISUGI = register("ikisugi", () -> new MobEffectInstance(YJMobEffects.RAW.get(YJMobEffects.IKISUGI), 20 * 65));
    public static final RegistrySupplier<Potion> COMA = register("coma", () -> new MobEffectInstance(YJMobEffects.RAW.get(YJMobEffects.COMA), 1800));
    public static final RegistrySupplier<Potion> LONG_COMA = register("long_coma", "coma", () -> new MobEffectInstance(YJMobEffects.RAW.get(YJMobEffects.COMA), 4800));
    public static final RegistrySupplier<Potion> STRONG_COMA = register("strong_coma", "coma", () -> new MobEffectInstance(YJMobEffects.RAW.get(YJMobEffects.COMA), 1800, 3));

    private static RegistrySupplier<Potion> register(@Nullable String name, Supplier<MobEffectInstance>... mobEffectInstances) {
        return register(name, name, mobEffectInstances);
    }

    private static RegistrySupplier<Potion> register(@Nullable String name, @Nullable String potionName, Supplier<MobEffectInstance>... mobEffectInstances) {
        MobEffectInstance[] effects = Arrays.stream(mobEffectInstances).map(Supplier::get).toList().toArray(new MobEffectInstance[0]);
        var p = new Potion(potionName, effects);
        var rs = POTIONS.register(name, () -> p);
        RAW.put(rs, p);
        return rs;
    }

    public static void init() {
        POTIONS.register();
    }

    public static void setupBrewing(BrewingRegistryAccess access) {
        for (RegistrySupplier<Block> yj_block : YJBlocks.YJ_BLOCKS) {
            access.add(Potions.AWKWARD, yj_block.get().asItem(), BEAST_FICTION.get());
        }

        access.add(RAW.get(BEAST_FICTION), Items.REDSTONE, RAW.get(LONG_BEAST_FICTION));
        access.add(RAW.get(BEAST_FICTION), YJItems.YJ_STAR.get(), RAW.get(IKISUGI));
        access.add(RAW.get(LONG_BEAST_FICTION), YJItems.YJ_STAR.get(), RAW.get(IKISUGI));
        access.add(Potions.AWKWARD, YJItems.ICE_TEA.get(), RAW.get(COMA));
        access.add(RAW.get(COMA), Items.REDSTONE, RAW.get(LONG_COMA));
        access.add(RAW.get(COMA), Items.GLOWSTONE_DUST, RAW.get(STRONG_COMA));
    }
}
