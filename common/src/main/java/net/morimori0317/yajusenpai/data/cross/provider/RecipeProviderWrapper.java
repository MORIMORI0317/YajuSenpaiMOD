package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;

public abstract class RecipeProviderWrapper extends DataProviderWrapper<RecipeProvider> {
    private final RecipeProvider recipeProvider;

    public RecipeProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
        this.recipeProvider = crossDataGeneratorAccess.createRecipeProvider(packOutput, lookup, this);
    }

    @Override
    public RecipeProvider getProvider() {
        return this.recipeProvider;
    }

    public abstract void generateRecipe(RecipeOutput recipeOutput, RecipeProviderAccess providerAccess);

    public static interface RecipeProviderAccess {
        Criterion<InventoryChangeTrigger.TriggerInstance> has(MinMaxBounds.Ints ints, ItemLike itemLike);

        Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike);

        Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tagKey);

        String getHasName(ItemLike itemLike);

        String getItemName(ItemLike itemLike);
    }
}
