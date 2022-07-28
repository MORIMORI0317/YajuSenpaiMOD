package net.morimori0317.yajusenpai.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

import java.util.function.Supplier;

public enum YJArmorMaterials implements ArmorMaterial {
    YJNIUM("yjnium", 19, new int[]{2, 5, 10, 2}, 9, () -> SoundEvents.ARMOR_EQUIP_IRON, 1.4F, 1.4F, () -> Ingredient.of(YJItems.YJNIUM_INGOT.get())),
    YJSNPI("yjsnpi", 36, new int[]{3, 6, 8, 3}, 10, YJSoundEvents.YJ_EQUIP, 1.9F, 1.9F, () -> Ingredient.of(YJItems.YJSNPI_INGOT.get())),
    CYCLOPS_SUNGLASSES("cyclops_sunglasses", 194, new int[]{0, 0, 0, 5}, Integer.parseInt("a", 16) + 193, YJSoundEvents.CYCLOPS_NAZOOTO, 0, 0, () -> Ingredient.EMPTY);
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final Supplier<SoundEvent> sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    YJArmorMaterials(String string2, int j, int[] is, int k, Supplier<SoundEvent> soundEvent, float f, float g, Supplier<Ingredient> supplier) {
        this.name = string2;
        this.durabilityMultiplier = j;
        this.slotProtections = is;
        this.enchantmentValue = k;
        this.sound = soundEvent;
        this.toughness = f;
        this.knockbackResistance = g;
        this.repairIngredient = new LazyLoadedValue(supplier);
    }

    public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
        return HEALTH_PER_SLOT[equipmentSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
        return this.slotProtections[equipmentSlot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound.get();
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}