package net.morimori0317.yajusenpai.enchantment;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.morimori0317.yajusenpai.YajuSenpai;

public class GabaAnaDaddyEnchantment extends Enchantment {
    private static final ResourceLocation GAD_FONT = new ResourceLocation(YajuSenpai.MODID, "gaba_ana_daddy");
    private static final Style GAD_STYLE = Style.EMPTY.withFont(GAD_FONT);

    public GabaAnaDaddyEnchantment(Rarity rarity, EquipmentSlot... equipmentSlots) {
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

    @Override
    public Component getFullname(int i) {
        var cmp = super.getFullname(i);

        if (cmp instanceof MutableComponent mutableComponent)
            mutableComponent.withStyle(GAD_STYLE);

        return cmp;
    }
}
