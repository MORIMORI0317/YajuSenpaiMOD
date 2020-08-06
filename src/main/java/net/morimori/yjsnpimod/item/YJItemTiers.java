package net.morimori.yjsnpimod.item;

import net.minecraft.item.crafting.Ingredient;
import red.felnull.otyacraftengine.item.ItemTierByIKSG;

public class YJItemTiers {
    public static final ItemTierByIKSG YJNIUM = new ItemTierByIKSG(2, 250, 6.0F, 2.0F, 14, () -> {
        return Ingredient.fromItems(YJItems.YJNIUM_INGOT);
    });
}
