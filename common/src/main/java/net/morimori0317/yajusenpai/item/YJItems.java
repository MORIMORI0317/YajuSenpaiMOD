package net.morimori0317.yajusenpai.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.morimori0317.yajusenpai.YajuSenpai;

import java.util.function.Supplier;

public class YJItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(YajuSenpai.MODID, Registry.ITEM_REGISTRY);
    public static final RegistrySupplier<Item> ICON = register("icon", () -> new Item(new Item.Properties()));
    public static final RegistrySupplier<Item> YJ_CORE = register("yj_core");
    public static final RegistrySupplier<Item> YJ_STAR = register("yj_star", () -> new SimpleFoiledItem(new Item.Properties().tab(YJCreativeModeTab.MOD_TAB).rarity(Rarity.UNCOMMON)));

    public static final RegistrySupplier<Item> YJNIUM_INGOT = register("yjnium_ingot");
    public static final RegistrySupplier<Item> YJNIUM_NUGGET = register("yjnium_nugget");
    public static final RegistrySupplier<Item> RAW_YJNIUM = register("raw_yjnium");
    public static final RegistrySupplier<Item> YJSNPI_INGOT = register("yjsnpi_ingot");
    public static final RegistrySupplier<Item> YJSNPI_NUGGET = register("yjsnpi_nugget");
    public static final RegistrySupplier<Item> RAW_YJSNPI = register("raw_yjsnpi");

    public static final RegistrySupplier<Item> YJNIUM_HORSE_ARMOR = register("yjnium_horse_armor", () -> new YJHorseArmorItem(5, (new Item.Properties()).stacksTo(1).tab(YJCreativeModeTab.MOD_TAB), false));
    public static final RegistrySupplier<Item> YJNIUM_SWORD = register("yjnium_sword", () -> new SwordItem(YJTiers.YJNIUM, 3, -2.4F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJNIUM_PICKAXE = register("yjnium_pickaxe", () -> new PickaxeItem(YJTiers.YJNIUM, 1, -2.8F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJNIUM_AXE = register("yjnium_axe", () -> new AxeItem(YJTiers.YJNIUM, 6.0F, -3.1F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJNIUM_SHOVEL = register("yjnium_shovel", () -> new ShovelItem(YJTiers.YJNIUM, 1.5F, -3.0F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJNIUM_HOE = register("yjnium_hoe", () -> new HoeItem(YJTiers.YJNIUM, -2, -1.0F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJNIUM_HELMET = register("yjnium_helmet", () -> new ArmorItem(YJArmorMaterials.YJNIUM, EquipmentSlot.HEAD, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJNIUM_CHESTPLATE = register("yjnium_chestplate", () -> new ArmorItem(YJArmorMaterials.YJNIUM, EquipmentSlot.CHEST, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJNIUM_LEGGINGS = register("yjnium_leggings", () -> new ArmorItem(YJArmorMaterials.YJNIUM, EquipmentSlot.LEGS, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJNIUM_BOOTS = register("yjnium_boots", () -> new ArmorItem(YJArmorMaterials.YJNIUM, EquipmentSlot.FEET, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));

    public static final RegistrySupplier<Item> YJSNPI_HORSE_ARMOR = register("yjsnpi_horse_armor", () -> new YJHorseArmorItem(5, (new Item.Properties()).stacksTo(1).tab(YJCreativeModeTab.MOD_TAB), true));
    public static final RegistrySupplier<Item> YJSNPI_SWORD = register("yjsnpi_sword", () -> new YJSwordItem(YJTiers.YJSNPI, 3, -2.4F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJSNPI_PICKAXE = register("yjsnpi_pickaxe", () -> new PickaxeItem(YJTiers.YJSNPI, 1, -2.8F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJSNPI_AXE = register("yjsnpi_axe", () -> new AxeItem(YJTiers.YJSNPI, 6.0F, -3.1F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJSNPI_SHOVEL = register("yjsnpi_shovel", () -> new ShovelItem(YJTiers.YJSNPI, 1.5F, -3.0F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJSNPI_HOE = register("yjsnpi_hoe", () -> new HoeItem(YJTiers.YJSNPI, -2, -1.0F, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJSNPI_HELMET = register("yjsnpi_helmet", () -> new ArmorItem(YJArmorMaterials.YJSNPI, EquipmentSlot.HEAD, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJSNPI_CHESTPLATE = register("yjsnpi_chestplate", () -> new ArmorItem(YJArmorMaterials.YJSNPI, EquipmentSlot.CHEST, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJSNPI_LEGGINGS = register("yjsnpi_leggings", () -> new ArmorItem(YJArmorMaterials.YJSNPI, EquipmentSlot.LEGS, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final RegistrySupplier<Item> YJSNPI_BOOTS = register("yjsnpi_boots", () -> new ArmorItem(YJArmorMaterials.YJSNPI, EquipmentSlot.FEET, new Item.Properties().tab(YJCreativeModeTab.MOD_TAB)));

    private static RegistrySupplier<Item> register(String name) {
        return register(name, () -> new Item(new Item.Properties().tab(YJCreativeModeTab.MOD_TAB)));
    }

    private static RegistrySupplier<Item> register(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }

    public static void init() {
        ITEMS.register();
    }
}
