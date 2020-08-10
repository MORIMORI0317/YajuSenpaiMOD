package net.morimori.yjsnpimod.item;

import net.minecraft.item.crafting.Ingredient;
import red.felnull.otyacraftengine.item.ItemTierByIKSG;

public class YJItemTiers {
    public static final ItemTierByIKSG YJNIUM = new ItemTierByIKSG(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.fromTag(YJItemTags.YJNIUM_INGOT);
    });
    public static final ItemTierByIKSG YJSNPI = new ItemTierByIKSG(3, 1919, 8.10F, 3.0F, 19, () -> {
        return Ingredient.fromTag(YJItemTags.YJSNPI_INGOT);
    });
    public static final ItemTierByIKSG JAKEN_YORUIKIMASYOUNE = new ItemTierByIKSG(1, 114514, 1, 2, 26, () -> {
        return Ingredient.fromItems(YJItems.YJ_CORE);
    });
}
