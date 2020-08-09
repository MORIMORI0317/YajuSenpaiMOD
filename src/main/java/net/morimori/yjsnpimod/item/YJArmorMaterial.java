package net.morimori.yjsnpimod.item;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvents;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.YJSoundEvents;
import red.felnull.otyacraftengine.item.ArmorMaterialByIKSG;

public class YJArmorMaterial {
    public static final ArmorMaterialByIKSG YJNIUM = new ArmorMaterialByIKSG(YJSNPIMOD.MODID + ":yjnium", 19, new int[]{2, 5, 10, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.4F, 1.4F, () -> {
        return Ingredient.fromTag(YJItemTags.YJNIUM_INGOT);
    });
    public static final ArmorMaterialByIKSG YJSNPI = new ArmorMaterialByIKSG(YJSNPIMOD.MODID + ":yjsnpi", 36, new int[]{3, 6, 8, 3}, 10, YJSoundEvents.YJ_EQUIP, 1.9F, 1.9F, () -> {
        return Ingredient.fromTag(YJItemTags.YJSNPI_INGOT);
    });
    public static final ArmorMaterialByIKSG CYCLOPS_SUNGLASSES = new ArmorMaterialByIKSG(YJSNPIMOD.MODID + ":cyclops_sunglasses", 194, new int[]{0, 0, 0, 5}, Integer.parseInt("a", 16) + 193, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0, 0, () -> {
        return Ingredient.EMPTY;
    });
}
