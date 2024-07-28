package net.morimori0317.yajusenpai.item;

import com.google.common.base.Suppliers;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.Objects;
import java.util.function.Supplier;

public enum YJTiers implements Tier {
    YJNIUM(BlockTags.INCORRECT_FOR_IRON_TOOL, 250, 6.0F, 2.0F, 14, () -> Ingredient.of(YJItems.YJNIUM_INGOT.get())),
    YAJUSENPAI(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 1919, 8.10F, 3.0F, 19, () -> Ingredient.of(YJItems.YAJUSENPAI_INGOT.get())),
    JAKEN_YORUIKIMASYOUNE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 114514, 1, 2.19f, 26, () -> Ingredient.of(YJItems.YJ_CORE.get()));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;

    YJTiers(final TagKey<Block> tagKey, final int j, final float f, final float g, final int k, final Supplier<Ingredient> supplier) {
        this.incorrectBlocksForDrops = tagKey;
        this.uses = j;
        this.speed = f;
        this.damage = g;
        this.enchantmentValue = k;
        Objects.requireNonNull(supplier);
        this.repairIngredient = Suppliers.memoize(supplier::get);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
