package net.morimori0317.yajusenpai.enchantment;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.morimori0317.yajusenpai.YajuSenpai;

import java.util.function.Supplier;

public class YJEnchantments {
    private static final EquipmentSlot[] ALL_ARMOR_SLOTS = {EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    private static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(YajuSenpai.MODID, Registries.ENCHANTMENT);
    public static final RegistrySupplier<Enchantment> KATYOU_CURSE = register("katyou_curse", () -> new KatyouCurseEnchantment(Enchantment.Rarity.VERY_RARE));
    public static final RegistrySupplier<Enchantment> GABA_ANA_DADDY_CURSE = register("gaba_ana_daddy_curse", () -> new GabaAnaDaddyEnchantment(Enchantment.Rarity.VERY_RARE));
    public static final RegistrySupplier<Enchantment> KYN_CURSE = register("kyn_curse", () -> new KynCurseEnchantment(Enchantment.Rarity.VERY_RARE, ALL_ARMOR_SLOTS));

    private static RegistrySupplier<Enchantment> register(String name, Supplier<Enchantment> enchantment) {
        return ENCHANTMENTS.register(name, enchantment);
    }

    public static void init() {
        ENCHANTMENTS.register();
    }
}
