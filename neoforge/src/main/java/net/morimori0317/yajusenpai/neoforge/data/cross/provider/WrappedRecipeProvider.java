package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

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
import net.morimori0317.yajusenpai.data.cross.provider.RecipeProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class WrappedRecipeProvider extends RecipeProvider {
    private final RecipeProviderWrapper recipeProviderWrapper;

    public WrappedRecipeProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, RecipeProviderWrapper recipeProviderWrapper) {
        super(arg, completableFuture);
        this.recipeProviderWrapper = recipeProviderWrapper;
    }

    @Override
    protected void buildRecipes(RecipeOutput arg) {
        recipeProviderWrapper.generateRecipe(arg, new RecipeProviderAccessImpl());
    }

    private static class RecipeProviderAccessImpl implements RecipeProviderWrapper.RecipeProviderAccess {
        @Override
        public Criterion<InventoryChangeTrigger.TriggerInstance> has(MinMaxBounds.Ints ints, ItemLike itemLike) {
            return RecipeProvider.has(ints, itemLike);
        }

        @Override
        public Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike itemLike) {
            return RecipeProvider.has(itemLike);
        }

        @Override
        public Criterion<InventoryChangeTrigger.TriggerInstance> has(TagKey<Item> tagKey) {
            return RecipeProvider.has(tagKey);
        }

        @Override
        public String getHasName(ItemLike itemLike) {
            return RecipeProvider.getHasName(itemLike);
        }

        @Override
        public String getItemName(ItemLike itemLike) {
            return RecipeProvider.getItemName(itemLike);
        }
    }
}
