package net.morimori.yjsnpimod.enchantment;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.morimori.yjsnpimod.YJSNPIMOD;

import java.util.ArrayList;
import java.util.List;

public class YJEnchantments {
    private static final List<EnchantmentEntry> MOD_ENCHANTMENTS = new ArrayList<>();
    public static final Enchantment KATYOU_CURSE = register("katyou_curse", new KatyouCurseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values()));
    public static final Enchantment OREMOITCHAU_CURSE = register("oremoitchau_curse", new OremoitchauCurseEnchantment(Enchantment.Rarity.VERY_RARE, EquipmentSlot.values()));

    public static Enchantment register(String name, Enchantment enchantment) {
        MOD_ENCHANTMENTS.add(new EnchantmentEntry(name, enchantment));
        return enchantment;
    }

    public static void init() {
        MOD_ENCHANTMENTS.forEach(n -> Registry.register(Registry.ENCHANTMENT, new ResourceLocation(YJSNPIMOD.MODID, n.name), n.enchantment));
    }

    private static record EnchantmentEntry(String name, Enchantment enchantment) {

    }
}
