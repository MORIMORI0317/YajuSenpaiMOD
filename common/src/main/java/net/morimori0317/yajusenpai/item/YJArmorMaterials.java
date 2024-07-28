package net.morimori0317.yajusenpai.item;

import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.util.RegistryHolderEntry;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class YJArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIAL = DeferredRegister.create(YajuSenpai.MODID, Registries.ARMOR_MATERIAL);

    public static final RegistryHolderEntry<ArmorMaterial> YJNIUM = register("yjnium", () -> create("yjnium", Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 10);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 2);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 1.4F, 1.4F, () -> Ingredient.of(YJItems.YJNIUM_INGOT.get())));

    public static final RegistryHolderEntry<ArmorMaterial> YAJUSENPAI = register("yajusenpai", () -> create("yajusenpai", Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 10);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 2);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 1.4F, 1.4F, () -> Ingredient.of(YJItems.YJNIUM_INGOT.get())));

    public static final RegistryHolderEntry<ArmorMaterial> CYCLOPS_SUNGLASSES = register("cyclops_sunglasses", () -> create("cyclops_sunglasses", Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 10);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 2);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 1.4F, 1.4F, () -> Ingredient.of(YJItems.YJNIUM_INGOT.get())));

    public static final RegistryHolderEntry<ArmorMaterial> BRIEF = register("brief", () -> create("brief", Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 5);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 10);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 2);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 1.4F, 1.4F, () -> Ingredient.of(YJItems.YJNIUM_INGOT.get())));

    public static final RegistryHolderEntry<ArmorMaterial> O_BACK = register("o_back", () -> create("o_back", Util.make(new EnumMap<>(ArmorItem.Type.class), (enumMap) -> {
        enumMap.put(ArmorItem.Type.BOOTS, 2);
        enumMap.put(ArmorItem.Type.LEGGINGS, 6);
        enumMap.put(ArmorItem.Type.CHESTPLATE, 10);
        enumMap.put(ArmorItem.Type.HELMET, 2);
        enumMap.put(ArmorItem.Type.BODY, 2);
    }), 110, SoundEvents.ARMOR_EQUIP_IRON, 0, 0, () -> Ingredient.of(YJBlocks.NKTIDKSG_BLOCK.get())));

    private static ArmorMaterial create(String name, EnumMap<ArmorItem.Type, Integer> enumMap, int i, Holder<SoundEvent> arg, float f, float g, Supplier<Ingredient> supplier) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(YJUtils.modLoc(name)));
        return create(enumMap, i, arg, f, g, supplier, list);
    }

    private static ArmorMaterial create(EnumMap<ArmorItem.Type, Integer> enumMap, int i, Holder<SoundEvent> arg, float f, float g, Supplier<Ingredient> supplier, List<ArmorMaterial.Layer> list) {
        EnumMap<ArmorItem.Type, Integer> enumMap2 = new EnumMap<>(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = ArmorItem.Type.values();
        for (ArmorItem.Type type : var9) {
            enumMap2.put(type, enumMap.get(type));
        }
        return new ArmorMaterial(enumMap2, i, arg, supplier, list, f, g);
    }

    private static RegistryHolderEntry<ArmorMaterial> register(String name, Supplier<ArmorMaterial> effectSupplier) {
        return new RegistryHolderEntry<>(ARMOR_MATERIAL.register(name, effectSupplier));
    }

    public static void init() {
        ARMOR_MATERIAL.register();
    }
}
