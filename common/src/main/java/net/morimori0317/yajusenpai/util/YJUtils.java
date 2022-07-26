package net.morimori0317.yajusenpai.util;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.morimori0317.yajusenpai.enchantment.YJEnchantments;

public class YJUtils {
    public static boolean hasKatyouEnchantment(ItemStack stack) {
        return EnchantmentHelper.getItemEnchantmentLevel(YJEnchantments.KATYOU_CURSE.get(), stack) > 0;
    }

    public static boolean hasGabaAnaDaddyEnchantment(ItemStack stack) {
        return EnchantmentHelper.getItemEnchantmentLevel(YJEnchantments.GABA_ANA_DADDY_CURSE.get(), stack) > 0;
    }

    public static boolean hasKynEnchantment(ItemStack stack) {
        return EnchantmentHelper.getItemEnchantmentLevel(YJEnchantments.KYN_CURSE.get(), stack) > 0;
    }

    public static ItemStack createFutoiSeaChicken() {
        var ch = new ItemStack(Items.CHICKEN);
        ch.setHoverName(Component.translatable("item.yajusenpai.futoi_sea_chicken").withStyle(Style.EMPTY.withBold(true).withItalic(false)));
        ch.getOrCreateTag().putBoolean("futoi_sea_chicken", true);
        return ch;
    }
}
