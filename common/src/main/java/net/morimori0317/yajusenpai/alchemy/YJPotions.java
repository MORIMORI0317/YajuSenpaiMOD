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
import net.morimori0317.yajusenpai.util.RegistryHolderEntry;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.function.Supplier;

public class YJPotions {
    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(YajuSenpai.MODID, Registries.POTION);

    public static final RegistryHolderEntry<Potion> BEAST_FICTION = register("beast_fiction", () -> new MobEffectInstance(YJMobEffects.BEAST_FICTION.vanillaHolder(), 20 * 490));
    public static final RegistryHolderEntry<Potion> LONG_BEAST_FICTION = register("long_beast_fiction", "beast_fiction", () -> new MobEffectInstance(YJMobEffects.BEAST_FICTION.vanillaHolder(), 20 * 1159));
    public static final RegistryHolderEntry<Potion> IKISUGI = register("ikisugi", () -> new MobEffectInstance(YJMobEffects.IKISUGI.vanillaHolder(), 20 * 65));
    public static final RegistryHolderEntry<Potion> COMA = register("coma", () -> new MobEffectInstance(YJMobEffects.COMA.vanillaHolder(), 1800));
    public static final RegistryHolderEntry<Potion> LONG_COMA = register("long_coma", "coma", () -> new MobEffectInstance(YJMobEffects.COMA.vanillaHolder(), 4800));
    public static final RegistryHolderEntry<Potion> STRONG_COMA = register("strong_coma", "coma", () -> new MobEffectInstance(YJMobEffects.COMA.vanillaHolder(), 1800, 3));

    private static RegistryHolderEntry<Potion> register(@Nullable String name, Supplier<MobEffectInstance>... mobEffectInstances) {
        return register(name, name, mobEffectInstances);
    }

    private static RegistryHolderEntry<Potion> register(@Nullable String name, @Nullable String potionName, Supplier<MobEffectInstance>... mobEffectInstances) {
        return new RegistryHolderEntry<>(POTIONS.register(name, () -> {
            MobEffectInstance[] effects = Arrays.stream(mobEffectInstances).map(Supplier::get).toList().toArray(MobEffectInstance[]::new);
            return new Potion(potionName, effects);
        }));
    }

    public static void init() {
        POTIONS.register();
    }

    public static void setupBrewing(BrewingRegistryAccess access) {
        for (RegistrySupplier<Block> yj_block : YJBlocks.YJ_BLOCKS) {
            access.add(Potions.AWKWARD, yj_block.get().asItem(), BEAST_FICTION.vanillaHolder());
        }

        access.add(BEAST_FICTION.vanillaHolder(), Items.REDSTONE, LONG_BEAST_FICTION.vanillaHolder());
        access.add(BEAST_FICTION.vanillaHolder(), YJItems.YJ_STAR.get(), IKISUGI.vanillaHolder());
        access.add(LONG_BEAST_FICTION.vanillaHolder(), YJItems.YJ_STAR.get(), IKISUGI.vanillaHolder());
        access.add(Potions.AWKWARD, YJItems.ICE_TEA.get(), COMA.vanillaHolder());
        access.add(COMA.vanillaHolder(), Items.REDSTONE, LONG_COMA.vanillaHolder());
        access.add(COMA.vanillaHolder(), Items.GLOWSTONE_DUST, STRONG_COMA.vanillaHolder());
    }
}
