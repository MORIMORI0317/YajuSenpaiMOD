package net.morimori0317.yajusenpai.item;

import com.google.common.base.Suppliers;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum YJArmorMaterials implements ArmorMaterial {
    YJNIUM("yjnium", 19, Util.make(new EnumMap<>(ArmorItem.Type.class), (durMul) -> {
        durMul.put(ArmorItem.Type.BOOTS, 2);
        durMul.put(ArmorItem.Type.LEGGINGS, 5);
        durMul.put(ArmorItem.Type.CHESTPLATE, 10);
        durMul.put(ArmorItem.Type.HELMET, 2);
    }), 9, () -> SoundEvents.ARMOR_EQUIP_IRON, 1.4F, 1.4F, () -> Ingredient.of(YJItems.YJNIUM_INGOT.get())),


    YJSNPI("yjsnpi", 36, Util.make(new EnumMap<>(ArmorItem.Type.class), (durMul) -> {
        durMul.put(ArmorItem.Type.BOOTS, 3);
        durMul.put(ArmorItem.Type.LEGGINGS, 6);
        durMul.put(ArmorItem.Type.CHESTPLATE, 8);
        durMul.put(ArmorItem.Type.HELMET, 3);
    }), 10, YJSoundEvents.YJ_EQUIP, 1.9F, 1.9F, () -> Ingredient.of(YJItems.YJSNPI_INGOT.get())),

    CYCLOPS_SUNGLASSES("cyclops_sunglasses", 193, Util.make(new EnumMap<>(ArmorItem.Type.class), (durMul) -> {
        durMul.put(ArmorItem.Type.BOOTS, 19);
        durMul.put(ArmorItem.Type.LEGGINGS, 19);
        durMul.put(ArmorItem.Type.CHESTPLATE, 19);
        durMul.put(ArmorItem.Type.HELMET, 5);
    }), 0xa + 193, YJSoundEvents.CYCLOPS_NAZOOTO, 0, 0, () -> Ingredient.of(Items.TINTED_GLASS)),

    BRIEF("brief", 81, Util.make(new EnumMap<>(ArmorItem.Type.class), (durMul) -> {
        durMul.put(ArmorItem.Type.BOOTS, 19);
        durMul.put(ArmorItem.Type.LEGGINGS, 7);
        durMul.put(ArmorItem.Type.CHESTPLATE, 19);
        durMul.put(ArmorItem.Type.HELMET, 19);
    }), 931, YJSoundEvents.YJ_NU, 0, 0, () -> Ingredient.of(Items.WHITE_WOOL));

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final Supplier<SoundEvent> sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    YJArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue, Supplier<SoundEvent> sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = YajuSenpai.MODID + ":" + name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionFunctionForType;
        this.enchantmentValue = enchantmentValue;
        this.sound = Suppliers.memoize(sound::get);
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return ArmorMaterials.HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionFunctionForType.get(type);
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound.get();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
