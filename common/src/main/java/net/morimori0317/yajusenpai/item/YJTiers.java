package net.morimori0317.yajusenpai.item;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum YJTiers implements Tier {
    YJNIUM(2, 250, 6.0F, 2.0F, 14, () -> Ingredient.of(YJItems.YJNIUM_INGOT.get())),
    YJSNPI(3, 1919, 8.10F, 3.0F, 19, () -> Ingredient.of(YJItems.YJSNPI_INGOT.get())),
    JAKEN_YORUIKIMASYOUNE(1, 114514, 1, 2, 26, () -> Ingredient.of(YJItems.YJ_CORE.get()));
    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    YJTiers(int j, int k, float f, float g, int l, Supplier<Ingredient> supplier) {
        this.level = j;
        this.uses = k;
        this.speed = f;
        this.damage = g;
        this.enchantmentValue = l;
        this.repairIngredient = new LazyLoadedValue(supplier);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}