package net.morimori.yjsnpimod.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJItems {
    public static final Item YJ_CORE = newItem("yj_core");
    public static final Item BAKED_POTATO_SENPAI = newFoodItem("baked_potato_senpai", YJFoods.BAKED_POTATO_SENPAI);
    public static final Item YJ_STAR = new SimpleFoiledItem(new Item.Properties().group(YJItemGroup.MOD_TAB).rarity(Rarity.UNCOMMON)).setRegistryName(YJSNPIMOD.MODID, "yj_star");

    public static final Item YJNIUM_INGOT = newItem("yjnium_ingot");
    public static final Item YJNIUM_NUGGET = newItem("yjnium_nugget");
    public static final Item YJNIUM_HORSE_ARMOR = new HorseArmorItem(5, new ResourceLocation(YJSNPIMOD.MODID, "textures/models/horse_armor/horse_armor_yjnium.png"), (new Item.Properties()).maxStackSize(1).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_horse_armor");

    public static final Item YJNIUM_SWORD = new SwordItem(YJItemTiers.YJNIUM, 3, -2.4F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_sword");
    public static final Item YJNIUM_PICKAXE = new PickaxeItem(YJItemTiers.YJNIUM, 1, -2.8F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_pickaxe");
    public static final Item YJNIUM_AXE = new AxeItem(YJItemTiers.YJNIUM, 6.0F, -3.1F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_axe");
    public static final Item YJNIUM_SHOVEL = new ShovelItem(YJItemTiers.YJNIUM, 1.5F, -3.0F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_shovel");
    public static final Item YJNIUM_HOE = new HoeItem(YJItemTiers.YJNIUM, -2, -1.0F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_hoe");
    public static final Item YJNIUM_HELMET = new ArmorItem(YJArmorMaterial.YJNIUM, EquipmentSlotType.HEAD, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_helmet");
    public static final Item YJNIUM_CHESTPLATE = new ArmorItem(YJArmorMaterial.YJNIUM, EquipmentSlotType.CHEST, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_chestplate");
    public static final Item YJNIUM_LEGGINGS = new ArmorItem(YJArmorMaterial.YJNIUM, EquipmentSlotType.LEGS, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_leggings");
    public static final Item YJNIUM_BOOTS = new ArmorItem(YJArmorMaterial.YJNIUM, EquipmentSlotType.FEET, (new Item.Properties()).group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, "yjnium_boots");


    public static void registerItem(IForgeRegistry<Item> r) {
        registryItem(r, YJ_CORE);
        registryItem(r, BAKED_POTATO_SENPAI);
        registryItem(r, YJ_STAR);
        registryItem(r, YJNIUM_INGOT);
        registryItem(r, YJNIUM_NUGGET);
        registryItem(r, YJNIUM_SWORD);
        registryItem(r, YJNIUM_PICKAXE);
        registryItem(r, YJNIUM_AXE);
        registryItem(r, YJNIUM_SHOVEL);
        registryItem(r, YJNIUM_HOE);
        registryItem(r, YJNIUM_HELMET);
        registryItem(r, YJNIUM_CHESTPLATE);
        registryItem(r, YJNIUM_LEGGINGS);
        registryItem(r, YJNIUM_BOOTS);
        registryItem(r, YJNIUM_HORSE_ARMOR);
    }

    private static void registryItem(IForgeRegistry<Item> r, Item i) {
        r.register(i);
    }

    private static Item newFoodItem(String name, Food foos) {
        return new Item(new Item.Properties().group(YJItemGroup.MOD_TAB).food(foos)).setRegistryName(YJSNPIMOD.MODID, name);
    }

    private static Item newItem(String name) {
        return new Item(new Item.Properties().group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, name);
    }
}
