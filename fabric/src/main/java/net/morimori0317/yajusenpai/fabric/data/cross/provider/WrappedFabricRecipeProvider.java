package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.data.cross.provider.RecipeProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class WrappedFabricRecipeProvider extends FabricRecipeProvider {
    private final RecipeProviderWrapper recipeProviderWrapper;

    public WrappedFabricRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, RecipeProviderWrapper recipeProviderWrapper) {
        super(output, registriesFuture);
        this.recipeProviderWrapper = recipeProviderWrapper;
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        recipeProviderWrapper.generateRecipe(exporter, new RecipeProviderAccessImpl());
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
