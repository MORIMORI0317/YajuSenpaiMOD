package net.morimori.yjsnpimod.item;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvents;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.YJSoundEvents;
import red.felnull.otyacraftengine.item.ArmorMaterialByIKSG;

public class YJArmorMaterial {
    public static final ArmorMaterialByIKSG YJNIUM = new ArmorMaterialByIKSG(YJSNPIMOD.MODID + ":yjnium", 15, new int[]{2, 5, 10, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.4F, 1.4F, () -> {
        return Ingredient.fromTag(YJItemTags.YJNIUM_INGOT);
    });
    public static final ArmorMaterialByIKSG YJSNPI = new ArmorMaterialByIKSG(YJSNPIMOD.MODID + ":yjsnpi", 33, new int[]{3, 6, 8, 3}, 10, YJSoundEvents.YJ_EQUIP, 1.9F, 1.9F, () -> {
        return Ingredient.fromTag(YJItemTags.YJSNPI_INGOT);
    });
}
