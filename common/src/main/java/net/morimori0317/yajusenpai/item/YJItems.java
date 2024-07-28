package net.morimori0317.yajusenpai.item;

import dev.architectury.core.item.ArchitecturySpawnEggItem;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.entity.YJEntityTypes;

import java.util.function.Supplier;

public final class YJItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(YajuSenpai.MODID, Registries.ITEM);

    public static final RegistrySupplier<Item> ICON = register("icon", () -> new Item(new Item.Properties()));

    public static final RegistrySupplier<Item> YJ_CORE = registerProp("yj_core", () -> baseProperties().rarity(Rarity.RARE));
    public static final RegistrySupplier<Item> YJ_STAR = registerProp("yj_star", () -> baseProperties().rarity(Rarity.UNCOMMON)
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));

    public static final RegistrySupplier<Item> YJNIUM_INGOT = register("yjnium_ingot");
    public static final RegistrySupplier<Item> YJNIUM_NUGGET = register("yjnium_nugget");
    public static final RegistrySupplier<Item> RAW_YJNIUM = register("raw_yjnium");
    public static final RegistrySupplier<Item> YAJUSENPAI_INGOT = register("yajusenpai_ingot");
    public static final RegistrySupplier<Item> YAJUSENPAI_NUGGET = register("yajusenpai_nugget");
    public static final RegistrySupplier<Item> RAW_YAJUSENPAI = register("raw_yajusenpai");

    public static final RegistrySupplier<Item> YJNIUM_HORSE_ARMOR = register("yjnium_horse_armor", () -> new AnimalArmorItem(YJArmorMaterials.YJNIUM.vanillaHolder(), AnimalArmorItem.BodyType.EQUESTRIAN, false, baseProperties().stacksTo(1)));
    public static final RegistrySupplier<Item> YJNIUM_SWORD = register("yjnium_sword", () ->
            new SwordItem(YJTiers.YJNIUM, baseProperties().attributes(SwordItem.createAttributes(YJTiers.YJNIUM, 3, -2.4F))));
    public static final RegistrySupplier<Item> YJNIUM_PICKAXE = register("yjnium_pickaxe", () ->
            new PickaxeItem(YJTiers.YJNIUM, baseProperties().attributes(PickaxeItem.createAttributes(YJTiers.YJNIUM, 1, -2.8F))));
    public static final RegistrySupplier<Item> YJNIUM_AXE = register("yjnium_axe", () ->
            new AxeItem(YJTiers.YJNIUM, baseProperties().attributes(AxeItem.createAttributes(YJTiers.YJNIUM, 6.0F, -3.1F))));
    public static final RegistrySupplier<Item> YJNIUM_SHOVEL = register("yjnium_shovel", () ->
            new ShovelItem(YJTiers.YJNIUM, baseProperties().attributes(ShovelItem.createAttributes(YJTiers.YJNIUM, 1.5F, -3.0F))));
    public static final RegistrySupplier<Item> YJNIUM_HOE = register("yjnium_hoe", () ->
            new HoeItem(YJTiers.YJNIUM, baseProperties().attributes(HoeItem.createAttributes(YJTiers.YJNIUM, -2, -1.0F))));
    public static final RegistrySupplier<Item> YJNIUM_HELMET = register("yjnium_helmet", () ->
            new ArmorItem(YJArmorMaterials.YJNIUM.vanillaHolder(), ArmorItem.Type.HELMET, baseProperties().durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final RegistrySupplier<Item> YJNIUM_CHESTPLATE = register("yjnium_chestplate", () ->
            new ArmorItem(YJArmorMaterials.YJNIUM.vanillaHolder(), ArmorItem.Type.CHESTPLATE, baseProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final RegistrySupplier<Item> YJNIUM_LEGGINGS = register("yjnium_leggings", () ->
            new ArmorItem(YJArmorMaterials.YJNIUM.vanillaHolder(), ArmorItem.Type.LEGGINGS, baseProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final RegistrySupplier<Item> YJNIUM_BOOTS = register("yjnium_boots", () ->
            new ArmorItem(YJArmorMaterials.YJNIUM.vanillaHolder(), ArmorItem.Type.BOOTS, baseProperties().durability(ArmorItem.Type.BOOTS.getDurability(15))));

    public static final RegistrySupplier<Item> YAJUSENPAI_HORSE_ARMOR = register("yajusenpai_horse_armor", () -> new AnimalArmorItem(YJArmorMaterials.YAJUSENPAI.vanillaHolder(), AnimalArmorItem.BodyType.EQUESTRIAN, false, baseProperties().stacksTo(1)));
    public static final RegistrySupplier<Item> YAJUSENPAI_SWORD = register("yajusenpai_sword", () ->
            new YJSwordItem(YJTiers.YAJUSENPAI, baseProperties().attributes(SwordItem.createAttributes(YJTiers.YAJUSENPAI, 3, -2.4F))));
    public static final RegistrySupplier<Item> YAJUSENPAI_PICKAXE = register("yajusenpai_pickaxe", () ->
            new YJPickaxeItem(YJTiers.YAJUSENPAI, baseProperties().attributes(PickaxeItem.createAttributes(YJTiers.YAJUSENPAI, 1, -2.8F))));
    public static final RegistrySupplier<Item> YAJUSENPAI_AXE = register("yajusenpai_axe", () ->
            new YJAxeItem(YJTiers.YAJUSENPAI, baseProperties().attributes(AxeItem.createAttributes(YJTiers.YAJUSENPAI, 6.0F, -3.1F))));
    public static final RegistrySupplier<Item> YAJUSENPAI_SHOVEL = register("yajusenpai_shovel", () ->
            new YJShovelItem(YJTiers.YAJUSENPAI, baseProperties().attributes(ShovelItem.createAttributes(YJTiers.YAJUSENPAI, 1.5F, -3.0F))));
    public static final RegistrySupplier<Item> YAJUSENPAI_HOE = register("yajusenpai_hoe", () ->
            new YJHoeItem(YJTiers.YAJUSENPAI, baseProperties().attributes(HoeItem.createAttributes(YJTiers.YAJUSENPAI, -2, -1.0F))));
    public static final RegistrySupplier<Item> YAJUSENPAI_HELMET = register("yajusenpai_helmet", () ->
            new ArmorItem(YJArmorMaterials.YAJUSENPAI.vanillaHolder(), ArmorItem.Type.HELMET, baseProperties().durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final RegistrySupplier<Item> YAJUSENPAI_CHESTPLATE = register("yajusenpai_chestplate", () ->
            new ArmorItem(YJArmorMaterials.YAJUSENPAI.vanillaHolder(), ArmorItem.Type.CHESTPLATE, baseProperties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))));
    public static final RegistrySupplier<Item> YAJUSENPAI_LEGGINGS = register("yajusenpai_leggings", () ->
            new ArmorItem(YJArmorMaterials.YAJUSENPAI.vanillaHolder(), ArmorItem.Type.LEGGINGS, baseProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final RegistrySupplier<Item> YAJUSENPAI_BOOTS = register("yajusenpai_boots", () ->
            new ArmorItem(YJArmorMaterials.YAJUSENPAI.vanillaHolder(), ArmorItem.Type.BOOTS, baseProperties().durability(ArmorItem.Type.BOOTS.getDurability(15))));

    public static final RegistrySupplier<Item> APPLE_INM = register("apple_inm", () -> new AppleInmItem(baseProperties().food(YJFoods.APPLE_INM)));
    public static final RegistrySupplier<Item> ICE_TEA = register("ice_tea", () -> new IceTeaItem(baseProperties().food(YJFoods.ICE_TEA.get())));

    public static final RegistrySupplier<Item> POTATO_SENPAI = register("potato_senpai", () -> new ItemNameBlockItem(YJBlocks.POTATOES_SENPAI.get(), baseProperties().food(YJFoods.YJ_POTATO.get())));
    public static final RegistrySupplier<Item> BAKED_POTATO_SENPAI = register("baked_potato_senpai", () -> new Item(baseProperties().food(YJFoods.YJ_BAKED_POTATO.get())));

    public static final RegistrySupplier<Item> JAKEN_YORUIKIMASYOUNE_SWORD = register("jaken_yoruikimasyoune_sword", () ->
            new JakenSwordItem(YJTiers.JAKEN_YORUIKIMASYOUNE, baseProperties().attributes(JakenSwordItem.createJakenAttributes(YJTiers.JAKEN_YORUIKIMASYOUNE, 16, 806F))));
    public static final RegistrySupplier<Item> CYCLOPS_SUNGLASSES = register("cyclops_sunglasses", () ->
            new ArmorItem(YJArmorMaterials.CYCLOPS_SUNGLASSES.vanillaHolder(), ArmorItem.Type.HELMET, baseProperties().durability(ArmorItem.Type.HELMET.getDurability(15))));
    public static final RegistrySupplier<Item> BRIEF = register("brief", () ->
            new ArmorItem(YJArmorMaterials.BRIEF.vanillaHolder(), ArmorItem.Type.LEGGINGS, baseProperties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final RegistrySupplier<Item> SOFT_SMARTPHONE = register("soft_smartphone", () -> new SoftSmartphoneItem(baseProperties().durability(19)));

    public static final RegistrySupplier<Item> O_BACK = register("o_back", () ->
            new OBackItem(YJArmorMaterials.O_BACK.vanillaHolder(), ArmorItem.Type.LEGGINGS, baseProperties().durability(110)));

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
