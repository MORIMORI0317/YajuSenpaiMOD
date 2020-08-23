package net.morimori.yjsnpimod.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.morimori.yjsnpimod.YJSNPIMOD;
import red.felnull.otyacraftengine.item.HorseArmorItemByIKSG;

import java.util.ArrayList;
import java.util.List;

public class YJItems {
    public static List<Item> MOD_ITEMS = new ArrayList<Item>();

    public static final Item YJ_ICON = register("yj_icon", new Item(new Item.Properties()));
    public static final Item YJ_CORE = register("yj_core");
    public static final Item YJ_STAR = register("yj_star", new SimpleFoiledItem(new Item.Properties().group(YJItemGroup.MOD_TAB).rarity(Rarity.UNCOMMON)));
    public static final Item YJNIUM_INGOT = register("yjnium_ingot", new DetarItem(new Item.Properties().group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_NUGGET = register("yjnium_nugget");
    public static final Item YJNIUM_HORSE_ARMOR = register("yjnium_horse_armor", new HorseArmorItemByIKSG(5, (new Item.Properties()).maxStackSize(1).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_SWORD = register("yjnium_sword", new SwordItem(YJItemTiers.YJNIUM, 3, -2.4F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_PICKAXE = register("yjnium_pickaxe", new PickaxeItem(YJItemTiers.YJNIUM, 1, -2.8F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_AXE = register("yjnium_axe", new AxeItem(YJItemTiers.YJNIUM, 6.0F, -3.1F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_SHOVEL = register("yjnium_shovel", new ShovelItem(YJItemTiers.YJNIUM, 1.5F, -3.0F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_HOE = register("yjnium_hoe", new HoeItem(YJItemTiers.YJNIUM, -2, -1.0F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_HELMET = register("yjnium_helmet", new ArmorItem(YJArmorMaterial.YJNIUM, EquipmentSlotType.HEAD, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_CHESTPLATE = register("yjnium_chestplate", new ArmorItem(YJArmorMaterial.YJNIUM, EquipmentSlotType.CHEST, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_LEGGINGS = register("yjnium_leggings", new ArmorItem(YJArmorMaterial.YJNIUM, EquipmentSlotType.LEGS, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJNIUM_BOOTS = register("yjnium_boots", new ArmorItem(YJArmorMaterial.YJNIUM, EquipmentSlotType.FEET, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_INGOT = register("yjsnpi_ingot", new DetarItem(new Item.Properties().group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_NUGGET = register("yjsnpi_nugget");
    public static final Item YJSNPI_HORSE_ARMOR = register("yjsnpi_horse_armor", new HorseArmorItemByIKSG(5, (new Item.Properties()).maxStackSize(1).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_SWORD = register("yjsnpi_sword", new YJSwordItem(YJItemTiers.YJSNPI, 3, -2.4F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_PICKAXE = register("yjsnpi_pickaxe", new PickaxeItem(YJItemTiers.YJSNPI, 1, -2.8F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_AXE = register("yjsnpi_axe", new AxeItem(YJItemTiers.YJSNPI, 6.0F, -3.1F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_SHOVEL = register("yjsnpi_shovel", new ShovelItem(YJItemTiers.YJSNPI, 1.5F, -3.0F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_HOE = register("yjsnpi_hoe", new HoeItem(YJItemTiers.YJSNPI, -2, -1.0F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_HELMET = register("yjsnpi_helmet", new ArmorItem(YJArmorMaterial.YJSNPI, EquipmentSlotType.HEAD, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_CHESTPLATE = register("yjsnpi_chestplate", new ArmorItem(YJArmorMaterial.YJSNPI, EquipmentSlotType.CHEST, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_LEGGINGS = register("yjsnpi_leggings", new ArmorItem(YJArmorMaterial.YJSNPI, EquipmentSlotType.LEGS, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item YJSNPI_BOOTS = register("yjsnpi_boots", new ArmorItem(YJArmorMaterial.YJSNPI, EquipmentSlotType.FEET, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item CYCLOPS_SUNGLASSES = register("cyclops_sunglasses", new CyclopsSunglassesItem(YJArmorMaterial.CYCLOPS_SUNGLASSES, EquipmentSlotType.HEAD, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item ICE_TEA = register("ice_tea", new IceTeaItem(new Item.Properties().group(YJItemGroup.MOD_TAB).food(YJFoods.ICE_TEA)));
    public static final Item JAKEN_YORUIKIMASYOUNE = register("jaken_yoruikimasyoune_sword", new JakenSwordItem(YJItemTiers.JAKEN_YORUIKIMASYOUNE, 16, 806F, (new Item.Properties()).group(YJItemGroup.MOD_TAB)));
    public static final Item JAKEN_YORUIKIMASYOU = register("jaken_yoruikimasyou_shield", new JakenShieldItem((new Item.Properties()).group(YJItemGroup.MOD_TAB).maxStackSize(1).maxDamage(114514)));
    public static final Item SOFT_SMARTPHONE = register("soft_smartphone", new SoftSwordItem(new Item.Properties().group(YJItemGroup.MOD_TAB).maxStackSize(1)));


    private static Item register(String name) {
        return register(name, new Item(new Item.Properties().group(YJItemGroup.MOD_TAB)));
    }

    private static Item register(String name, Item item) {
        MOD_ITEMS.add(item.setRegistryName(YJSNPIMOD.MODID, name));
        return item;
    }
}
