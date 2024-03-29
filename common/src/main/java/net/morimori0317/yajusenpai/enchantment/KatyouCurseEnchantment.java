package net.morimori0317.yajusenpai.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class KatyouCurseEnchantment extends Enchantment {
    public KatyouCurseEnchantment(Rarity rarity, EquipmentSlot... equipmentSlots) {
        super(rarity, EnchantmentCategory.BREAKABLE, equipmentSlots);
    }

    @Override
    public int getMinCost(int i) {
        return 25;
    }

    @Override
    public int getMaxCost(int i) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }
}
