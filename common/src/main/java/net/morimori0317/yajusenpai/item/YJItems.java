package net.morimori0317.yajusenpai.item;

import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.entity.YJEntityTypes;

import java.util.function.Supplier;

public class YJItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(YajuSenpai.MODID, Registries.ITEM);
    public static final RegistrySupplier<Item> ICON = register("icon", () -> new Item(new Item.Properties()));

    public static final RegistrySupplier<Item> YJ_CORE = registerProp("yj_core", () -> baseProperties().rarity(Rarity.RARE));
    public static final RegistrySupplier<Item> YJ_STAR = register("yj_star", () -> new YJStarItem(baseProperties().rarity(Rarity.UNCOMMON)));

    public static final RegistrySupplier<Item> YJNIUM_INGOT = register("yjnium_ingot");
    public static final RegistrySupplier<Item> YJNIUM_NUGGET = register("yjnium_nugget");
    public static final RegistrySupplier<Item> RAW_YJNIUM = register("raw_yjnium");
    public static final RegistrySupplier<Item> YJSNPI_INGOT = register("yjsnpi_ingot");
    public static final RegistrySupplier<Item> YJSNPI_NUGGET = register("yjsnpi_nugget");
    public static final RegistrySupplier<Item> RAW_YJSNPI = register("raw_yjsnpi");

    public static final RegistrySupplier<Item> YJNIUM_HORSE_ARMOR = register("yjnium_horse_armor", () -> new YJHorseArmorItem(5, false, baseProperties().stacksTo(1)));
    public static final RegistrySupplier<Item> YJNIUM_SWORD = register("yjnium_sword", () -> new SwordItem(YJTiers.YJNIUM, 3, -2.4F, baseProperties()));
    public static final RegistrySupplier<Item> YJNIUM_PICKAXE = register("yjnium_pickaxe", () -> new PickaxeItem(YJTiers.YJNIUM, 1, -2.8F, baseProperties()));
    public static final RegistrySupplier<Item> YJNIUM_AXE = register("yjnium_axe", () -> new AxeItem(YJTiers.YJNIUM, 6.0F, -3.1F, baseProperties()));
    public static final RegistrySupplier<Item> YJNIUM_SHOVEL = register("yjnium_shovel", () -> new ShovelItem(YJTiers.YJNIUM, 1.5F, -3.0F, baseProperties()));
    public static final RegistrySupplier<Item> YJNIUM_HOE = register("yjnium_hoe", () -> new HoeItem(YJTiers.YJNIUM, -2, -1.0F, baseProperties()));
    public static final RegistrySupplier<Item> YJNIUM_HELMET = register("yjnium_helmet", () -> new ArmorItem(YJArmorMaterials.YJNIUM, ArmorItem.Type.HELMET, baseProperties()));
    public static final RegistrySupplier<Item> YJNIUM_CHESTPLATE = register("yjnium_chestplate", () -> new ArmorItem(YJArmorMaterials.YJNIUM, ArmorItem.Type.CHESTPLATE, baseProperties()));
    public static final RegistrySupplier<Item> YJNIUM_LEGGINGS = register("yjnium_leggings", () -> new ArmorItem(YJArmorMaterials.YJNIUM, ArmorItem.Type.LEGGINGS, baseProperties()));
    public static final RegistrySupplier<Item> YJNIUM_BOOTS = register("yjnium_boots", () -> new ArmorItem(YJArmorMaterials.YJNIUM, ArmorItem.Type.BOOTS, baseProperties()));

    public static final RegistrySupplier<Item> YJSNPI_HORSE_ARMOR = register("yjsnpi_horse_armor", () -> new YJHorseArmorItem(8, true, baseProperties().stacksTo(1)));
    public static final RegistrySupplier<Item> YJSNPI_SWORD = register("yjsnpi_sword", () -> new YJSwordItem(YJTiers.YJSNPI, 3, -2.4F, baseProperties()));
    public static final RegistrySupplier<Item> YJSNPI_PICKAXE = register("yjsnpi_pickaxe", () -> new PickaxeItem(YJTiers.YJSNPI, 1, -2.8F, baseProperties()));
    public static final RegistrySupplier<Item> YJSNPI_AXE = register("yjsnpi_axe", () -> new AxeItem(YJTiers.YJSNPI, 6.0F, -3.1F, baseProperties()));
    public static final RegistrySupplier<Item> YJSNPI_SHOVEL = register("yjsnpi_shovel", () -> new ShovelItem(YJTiers.YJSNPI, 1.5F, -3.0F, baseProperties()));
    public static final RegistrySupplier<Item> YJSNPI_HOE = register("yjsnpi_hoe", () -> new HoeItem(YJTiers.YJSNPI, -2, -1.0F, baseProperties()));
    public static final RegistrySupplier<Item> YJSNPI_HELMET = register("yjsnpi_helmet", () -> new ArmorItem(YJArmorMaterials.YJSNPI, ArmorItem.Type.HELMET, baseProperties()));
    public static final RegistrySupplier<Item> YJSNPI_CHESTPLATE = register("yjsnpi_chestplate", () -> new ArmorItem(YJArmorMaterials.YJSNPI, ArmorItem.Type.CHESTPLATE, baseProperties()));
    public static final RegistrySupplier<Item> YJSNPI_LEGGINGS = register("yjsnpi_leggings", () -> new ArmorItem(YJArmorMaterials.YJSNPI, ArmorItem.Type.LEGGINGS, baseProperties()));
    public static final RegistrySupplier<Item> YJSNPI_BOOTS = register("yjsnpi_boots", () -> new ArmorItem(YJArmorMaterials.YJSNPI, ArmorItem.Type.BOOTS, baseProperties()));

    public static final RegistrySupplier<Item> APPLE = register("apple", () -> new YJAppleItem(baseProperties().food(YJFoods.APPLE)));
    public static final RegistrySupplier<Item> ICE_TEA = register("ice_tea", () -> new IceTeaItem(baseProperties().food(YJFoods.ICE_TEA.get())));

    public static final RegistrySupplier<Item> POTATO_SENPAI = register("potato_senpai", () -> new ItemNameBlockItem(YJBlocks.POTATOES_SENPAI.get(), baseProperties().food(YJFoods.YJ_POTATO.get())));
    public static final RegistrySupplier<Item> BAKED_POTATO_SENPAI = register("baked_potato_senpai", () -> new Item(baseProperties().food(YJFoods.YJ_BAKED_POTATO.get())));

    public static final RegistrySupplier<Item> JAKEN_YORUIKIMASYOUNE_SWORD = register("jaken_yoruikimasyoune_sword", () -> new JakenSwordItem(YJTiers.JAKEN_YORUIKIMASYOUNE, 16, 806F, baseProperties()));
    public static final RegistrySupplier<Item> CYCLOPS_SUNGLASSES = register("cyclops_sunglasses", () -> new CyclopsSunglassesItem(YJArmorMaterials.CYCLOPS_SUNGLASSES, ArmorItem.Type.HELMET, baseProperties()));
    public static final RegistrySupplier<Item> BRIEF = register("brief", () -> new CyclopsSunglassesItem(YJArmorMaterials.BRIEF, ArmorItem.Type.LEGGINGS, baseProperties()));
    public static final RegistrySupplier<Item> SOFT_SMARTPHONE = register("soft_smartphone", () -> new SoftSmartphoneItem(baseProperties().durability(19)));

    public static final RegistrySupplier<Item> KATYOU_CAT_SPAWN_EGG = register("katyou_cat_spawn_egg", () -> new ArchitecturySpawnEggItem(YJEntityTypes.KATYOU_CAT, 0xa87668, 0x131311, baseProperties()));

    private static RegistrySupplier<Item> register(String name) {

        return register(name, () -> new Item(baseProperties()));
    }

    private static RegistrySupplier<Item> registerProp(String name, Supplier<Item.Properties> propertiesSupplier) {
        return ITEMS.register(name, () -> new Item(propertiesSupplier.get()));
    }

    private static RegistrySupplier<Item> register(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }

    public static void init() {
        ITEMS.register();
    }

    public static Item.Properties baseProperties() {
        return new Item.Properties().arch$tab(YJCreativeModeTabs.MOD_TAB);
    }
}
