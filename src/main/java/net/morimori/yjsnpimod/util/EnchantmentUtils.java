package net.morimori.yjsnpimod.util;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class EnchantmentUtils {
    public static boolean hasEnchantment(Enchantment enchantment, ItemStack itemStack) {
        return EnchantmentHelper.getItemEnchantmentLevel(enchantment, itemStack) > 0;
    }
}
