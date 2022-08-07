package net.morimori0317.yajusenpai.forge.alchemy;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.morimori0317.yajusenpai.alchemy.YJPotions;

public class ForgeBrewingSetup {
    public static void setup() {
        YJPotions.setupBrewing((input, inputItem, output) -> {
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), input)), Ingredient.of(inputItem), PotionUtils.setPotion(new ItemStack(Items.POTION), output)));
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), input)), Ingredient.of(inputItem), PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), output)));
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), input)), Ingredient.of(inputItem), PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), output)));
        });

        for (RegistrySupplier<Potion> potion : YJPotions.RAW.keySet()) {
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), potion.get())), Ingredient.of(Items.GUNPOWDER), PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion.get())));
            BrewingRecipeRegistry.addRecipe(new BrewingRecipe(Ingredient.of(PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), potion.get())), Ingredient.of(Items.DRAGON_BREATH), PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), potion.get())));
        }
    }
}
