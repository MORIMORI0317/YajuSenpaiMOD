package net.morimori0317.yajusenpai.data;

import com.google.common.collect.ImmutableList;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.felnull.otyacraftengine.data.CrossDataGeneratorAccess;
import dev.felnull.otyacraftengine.data.provider.RecipeProviderWrapper;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.item.YJItems;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class YJRecipeProviderWrapper extends RecipeProviderWrapper {
    private static final String BLUE_NAME = "blue";
    private static final String GREEN_NAME = "green";
    private static final String RED_NAME = "red";
    private final ImmutableList<ItemLike> YJNIUM_SMELTABLES = ImmutableList.of(YJBlocks.YJNIUM_ORE.get(), YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), YJItems.RAW_YJNIUM.get());
    private final ImmutableList<ItemLike> YJSNPI_SMELTABLES = ImmutableList.of(YJBlocks.YJSNPI_ORE.get(), YJBlocks.DEEPSLATE_YJSNPI_ORE.get(), YJItems.RAW_YJSNPI.get());

    public YJRecipeProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
    }

    @Override
    public void generateRecipe(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess) {
        generateCraftingRecipe(exporter, providerAccess);
    }

    private void generateCraftingRecipe(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess) {
        backMaterial(exporter, providerAccess, YJBlocks.BB.get(), YJItemTags.COMPAT_BLUE_DYE);
        backMaterial(exporter, providerAccess, YJBlocks.GB.get(), YJItemTags.COMPAT_GREEN_DYE);
        backMaterial(exporter, providerAccess, YJBlocks.RB.get(), YJItemTags.COMPAT_RED_DYE);

        backMaterialDyeing(exporter, providerAccess, YJBlocks.BB.get(), YJItemTags.COMPAT_BLUE_DYE, Pair.of(YJBlocks.GB.get(), GREEN_NAME), Pair.of(YJBlocks.RB.get(), RED_NAME));
        backMaterialDyeing(exporter, providerAccess, YJBlocks.GB.get(), YJItemTags.COMPAT_GREEN_DYE, Pair.of(YJBlocks.BB.get(), BLUE_NAME), Pair.of(YJBlocks.RB.get(), RED_NAME));
        backMaterialDyeing(exporter, providerAccess, YJBlocks.RB.get(), YJItemTags.COMPAT_RED_DYE, Pair.of(YJBlocks.BB.get(), BLUE_NAME), Pair.of(YJBlocks.GB.get(), GREEN_NAME));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, YJBlocks.BIG_PILLOW.get())
                .define('A', Items.WHITE_WOOL)
                .define('B', YJItemTags.COMPAT_YJSNPI_INGOT)
                .pattern("AAA")
                .pattern("ABA")
                .unlockedBy(providerAccess.getHasName(YJItems.YJSNPI_INGOT.get()), providerAccess.has(YJItemTags.COMPAT_YJSNPI_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, YJItems.BRIEF.get())
                .define('A', Items.WHITE_WOOL)
                .define('B', YJItemTags.COMPAT_NETHERITE_INGOT)
                .pattern("A A")
                .pattern("ABA")
                .pattern("AAA")
                .unlockedBy(providerAccess.getHasName(Items.NETHERITE_INGOT), providerAccess.has(YJItemTags.COMPAT_NETHERITE_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, YJItems.CYCLOPS_SUNGLASSES.get())
                .define('A', YJItemTags.COMPAT_IRON_INGOT)
                .define('B', YJItemTags.COMPAT_NETHERITE_INGOT)
                .define('C', YJItemTags.COMPAT_TINTED_GLASS)
                .pattern("AAA")
                .pattern("BCB")
                .pattern("AAA")
                .unlockedBy(providerAccess.getHasName(Items.NETHERITE_INGOT), providerAccess.has(YJItemTags.COMPAT_NETHERITE_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, YJItems.ICE_TEA.get())
                .define('A', YJItemTags.COMPAT_WHEAT)
                .define('B', Items.GLASS_BOTTLE)
                .pattern("AAA")
                .pattern(" B ")
                .unlockedBy(providerAccess.getHasName(Items.WHEAT), providerAccess.has(YJItemTags.COMPAT_WHEAT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, YJItems.SOFT_SMARTPHONE.get())
                .define('A', Items.WHITE_WOOL)
                .define('B', YJItemTags.COMPAT_YJSNPI_INGOT)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .unlockedBy(providerAccess.getHasName(YJItems.YJSNPI_INGOT.get()), providerAccess.has(YJItemTags.COMPAT_YJSNPI_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, YJItems.YJ_CORE.get())
                .define('A', YJItems.APPLE.get())
                .define('B', YJItems.CYCLOPS_SUNGLASSES.get())
                .define('C', YJItems.BAKED_POTATO_SENPAI.get())
                .define('D', YJItems.SOFT_SMARTPHONE.get())
                .define('E', YJItems.YJ_STAR.get())
                .define('F', YJBlocks.BIG_PILLOW.get())
                .define('G', YJItems.ICE_TEA.get())
                .define('H', YJItems.BRIEF.get())
                .define('I', YJBlocks.YJ_ROSE.get())
                .pattern("ABC")
                .pattern("DEF")
                .pattern("GHI")
                .unlockedBy(providerAccess.getHasName(YJItems.YJ_STAR.get()), providerAccess.has(YJItems.YJ_STAR.get()))
                .save(exporter);

        sword(exporter, providerAccess, YJItems.YJNIUM_SWORD.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        sword(exporter, providerAccess, YJItems.YJSNPI_SWORD.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        pickaxe(exporter, providerAccess, YJItems.YJNIUM_PICKAXE.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        pickaxe(exporter, providerAccess, YJItems.YJSNPI_PICKAXE.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        axe(exporter, providerAccess, YJItems.YJNIUM_AXE.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        axe(exporter, providerAccess, YJItems.YJSNPI_AXE.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        shovel(exporter, providerAccess, YJItems.YJNIUM_SHOVEL.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        shovel(exporter, providerAccess, YJItems.YJSNPI_SHOVEL.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        hoe(exporter, providerAccess, YJItems.YJNIUM_HOE.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        hoe(exporter, providerAccess, YJItems.YJSNPI_HOE.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        helmet(exporter, providerAccess, YJItems.YJNIUM_HELMET.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        helmet(exporter, providerAccess, YJItems.YJSNPI_HELMET.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        chestplate(exporter, providerAccess, YJItems.YJNIUM_CHESTPLATE.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        chestplate(exporter, providerAccess, YJItems.YJSNPI_CHESTPLATE.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        leggings(exporter, providerAccess, YJItems.YJNIUM_LEGGINGS.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        leggings(exporter, providerAccess, YJItems.YJSNPI_LEGGINGS.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        boots(exporter, providerAccess, YJItems.YJNIUM_BOOTS.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        boots(exporter, providerAccess, YJItems.YJSNPI_BOOTS.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        nineBlockStorageRecipes(exporter, providerAccess, RecipeCategory.MISC, YJItems.RAW_YJNIUM.get(), RecipeCategory.BUILDING_BLOCKS, YJBlocks.RAW_YJNIUM_BLOCK.get());
        nineBlockStorageRecipes(exporter, providerAccess, RecipeCategory.MISC, YJItems.RAW_YJSNPI.get(), RecipeCategory.BUILDING_BLOCKS, YJBlocks.RAW_YJSNPI_BLOCK.get());

        planksFromLog(exporter, providerAccess, YJBlocks.YJ_PLANKS.get(), YJItemTags.YJ_LOGS, 4);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, YJBlocks.YJ_SLAB.get(), 6)
                .group("wooden_slab")
                .define('#', YJBlocks.YJ_PLANKS.get())
                .pattern("###")
                .unlockedBy(providerAccess.getHasName(YJBlocks.YJ_PLANKS.get()), providerAccess.has(YJBlocks.YJ_PLANKS.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, YJBlocks.YJ_STAIRS.get(), 4)
                .group("wooden_stairs")
                .define('#', YJBlocks.YJ_PLANKS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .unlockedBy(providerAccess.getHasName(YJBlocks.YJ_PLANKS.get()), providerAccess.has(YJBlocks.YJ_PLANKS.get()))
                .save(exporter);

        nineBlockStorageRecipesWithCustomPacking(exporter, providerAccess, RecipeCategory.MISC, YJItems.YJNIUM_NUGGET.get(), RecipeCategory.MISC, YJItems.YJNIUM_INGOT.get(), "yjnium_ingot_from_nuggets", "yjnium_ingot");
        nineBlockStorageRecipesWithCustomPacking(exporter, providerAccess, RecipeCategory.MISC, YJItems.YJSNPI_NUGGET.get(), RecipeCategory.MISC, YJItems.YJSNPI_INGOT.get(), "yjsnpi_ingot_from_nuggets", "yjsnpi_ingot");


        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, YJItems.YJNIUM_HORSE_ARMOR.get())
                .define('X', YJItemTags.COMPAT_YJNIUM_INGOT)
                .pattern("X X")
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy(providerAccess.getHasName(YJItems.YJNIUM_INGOT.get()), providerAccess.has(YJItemTags.COMPAT_YJNIUM_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, YJItems.YJSNPI_HORSE_ARMOR.get())
                .define('X', YJItemTags.COMPAT_YJSNPI_INGOT)
                .pattern("X X")
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy(providerAccess.getHasName(YJItems.YJSNPI_INGOT.get()), providerAccess.has(YJItemTags.COMPAT_YJSNPI_INGOT))
                .save(exporter);

        nineBlockStorageRecipesRecipesWithCustomUnpacking(exporter, providerAccess, RecipeCategory.MISC, YJItems.YJNIUM_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, YJBlocks.YJNIUM_BLOCK.get(), "yjnium_ingot_from_yjnium_block", "yjnium_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, YJBlocks.YJSNPI_INTERVIEW_BLOCK.get())
                .define('A', YJItemTags.COMPAT_YJSNPI_INGOT)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .unlockedBy(providerAccess.getHasName(YJItems.YJSNPI_INGOT.get()), providerAccess.has(YJItemTags.COMPAT_YJSNPI_INGOT))
                .save(exporter);

        oreSmelting(exporter, providerAccess, YJNIUM_SMELTABLES, RecipeCategory.MISC, YJItems.YJNIUM_INGOT.get(), 0.7f, 200, "yjnium_ingot");
        oreBlasting(exporter, providerAccess, YJNIUM_SMELTABLES, RecipeCategory.MISC, YJItems.YJNIUM_INGOT.get(), 0.7f, 100, "yjnium_ingot");

        oreSmelting(exporter, providerAccess, YJSNPI_SMELTABLES, RecipeCategory.MISC, YJItems.YJSNPI_INGOT.get(), 0.7f, 200, "yjsnpi_ingot");
        oreBlasting(exporter, providerAccess, YJSNPI_SMELTABLES, RecipeCategory.MISC, YJItems.YJSNPI_INGOT.get(), 0.7f, 100, "yjsnpi_ingot");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(YJItems.POTATO_SENPAI.get()), RecipeCategory.FOOD, YJItems.BAKED_POTATO_SENPAI.get(), 0.35f, 200)
                .unlockedBy("has_potato_senpai", providerAccess.has(YJItems.POTATO_SENPAI.get()))
                .save(exporter);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(YJItems.YJNIUM_PICKAXE.get(), YJItems.YJNIUM_SHOVEL.get(), YJItems.YJNIUM_AXE.get(), YJItems.YJNIUM_HOE.get(), YJItems.YJNIUM_SWORD.get(), YJItems.YJNIUM_HELMET.get(), YJItems.YJNIUM_CHESTPLATE.get(), YJItems.YJNIUM_LEGGINGS.get(), YJItems.YJNIUM_BOOTS.get(), YJItems.YJNIUM_HORSE_ARMOR.get()), RecipeCategory.MISC, YJItems.YJNIUM_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_yjnium_pickaxe", providerAccess.has(YJItems.YJNIUM_PICKAXE.get()))
                .unlockedBy("has_yjnium_shovel", providerAccess.has(YJItems.YJNIUM_SHOVEL.get()))
                .unlockedBy("has_yjnium_axe", providerAccess.has(YJItems.YJNIUM_AXE.get()))
                .unlockedBy("has_yjnium_hoe", providerAccess.has(YJItems.YJNIUM_HOE.get()))
                .unlockedBy("has_yjnium_sword", providerAccess.has(YJItems.YJNIUM_SWORD.get()))
                .unlockedBy("has_yjnium_helmet", providerAccess.has(YJItems.YJNIUM_HELMET.get()))
                .unlockedBy("has_yjnium_chestplate", providerAccess.has(YJItems.YJNIUM_CHESTPLATE.get()))
                .unlockedBy("has_yjnium_leggings", providerAccess.has(YJItems.YJNIUM_LEGGINGS.get()))
                .unlockedBy("has_yjnium_boots", providerAccess.has(YJItems.YJNIUM_BOOTS.get()))
                .unlockedBy("has_yjnium_horse_armor", providerAccess.has(YJItems.YJNIUM_HORSE_ARMOR.get()))
                .save(exporter, getSmeltingRecipeName(YJItems.YJNIUM_NUGGET.get(), providerAccess));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(YJItems.YJSNPI_PICKAXE.get(), YJItems.YJSNPI_SHOVEL.get(), YJItems.YJSNPI_AXE.get(), YJItems.YJSNPI_HOE.get(), YJItems.YJSNPI_SWORD.get(), YJItems.YJSNPI_HELMET.get(), YJItems.YJSNPI_CHESTPLATE.get(), YJItems.YJSNPI_LEGGINGS.get(), YJItems.YJSNPI_BOOTS.get(), YJItems.YJSNPI_HORSE_ARMOR.get()), RecipeCategory.MISC, YJItems.YJSNPI_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_yjsnpi_pickaxe", providerAccess.has(YJItems.YJSNPI_PICKAXE.get()))
                .unlockedBy("has_yjsnpi_shovel", providerAccess.has(YJItems.YJSNPI_SHOVEL.get()))
                .unlockedBy("has_yjsnpi_axe", providerAccess.has(YJItems.YJSNPI_AXE.get()))
                .unlockedBy("has_yjsnpi_hoe", providerAccess.has(YJItems.YJSNPI_HOE.get()))
                .unlockedBy("has_yjsnpi_sword", providerAccess.has(YJItems.YJSNPI_SWORD.get()))
                .unlockedBy("has_yjsnpi_helmet", providerAccess.has(YJItems.YJSNPI_HELMET.get()))
                .unlockedBy("has_yjsnpi_chestplate", providerAccess.has(YJItems.YJSNPI_CHESTPLATE.get()))
                .unlockedBy("has_yjsnpi_leggings", providerAccess.has(YJItems.YJSNPI_LEGGINGS.get()))
                .unlockedBy("has_yjsnpi_boots", providerAccess.has(YJItems.YJSNPI_BOOTS.get()))
                .unlockedBy("has_yjsnpi_horse_armor", providerAccess.has(YJItems.YJSNPI_HORSE_ARMOR.get()))
                .save(exporter, getSmeltingRecipeName(YJItems.YJSNPI_NUGGET.get(), providerAccess));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(YJItems.YJNIUM_PICKAXE.get(), YJItems.YJNIUM_SHOVEL.get(), YJItems.YJNIUM_AXE.get(), YJItems.YJNIUM_HOE.get(), YJItems.YJNIUM_SWORD.get(), YJItems.YJNIUM_HELMET.get(), YJItems.YJNIUM_CHESTPLATE.get(), YJItems.YJNIUM_LEGGINGS.get(), YJItems.YJNIUM_BOOTS.get(), YJItems.YJNIUM_HORSE_ARMOR.get()), RecipeCategory.MISC, YJItems.YJNIUM_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_yjnium_pickaxe", providerAccess.has(YJItems.YJNIUM_PICKAXE.get()))
                .unlockedBy("has_yjnium_shovel", providerAccess.has(YJItems.YJNIUM_SHOVEL.get()))
                .unlockedBy("has_yjnium_axe", providerAccess.has(YJItems.YJNIUM_AXE.get()))
                .unlockedBy("has_yjnium_hoe", providerAccess.has(YJItems.YJNIUM_HOE.get()))
                .unlockedBy("has_yjnium_sword", providerAccess.has(YJItems.YJNIUM_SWORD.get()))
                .unlockedBy("has_yjnium_helmet", providerAccess.has(YJItems.YJNIUM_HELMET.get()))
                .unlockedBy("has_yjnium_chestplate", providerAccess.has(YJItems.YJNIUM_CHESTPLATE.get()))
                .unlockedBy("has_yjnium_leggings", providerAccess.has(YJItems.YJNIUM_LEGGINGS.get()))
                .unlockedBy("has_yjnium_boots", providerAccess.has(YJItems.YJNIUM_BOOTS.get()))
                .unlockedBy("has_yjnium_horse_armor", providerAccess.has(YJItems.YJNIUM_HORSE_ARMOR.get()))
                .save(exporter, getBlastingRecipeName(YJItems.YJNIUM_NUGGET.get(), providerAccess));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(YJItems.YJSNPI_PICKAXE.get(), YJItems.YJSNPI_SHOVEL.get(), YJItems.YJSNPI_AXE.get(), YJItems.YJSNPI_HOE.get(), YJItems.YJSNPI_SWORD.get(), YJItems.YJSNPI_HELMET.get(), YJItems.YJSNPI_CHESTPLATE.get(), YJItems.YJSNPI_LEGGINGS.get(), YJItems.YJSNPI_BOOTS.get(), YJItems.YJSNPI_HORSE_ARMOR.get()), RecipeCategory.MISC, YJItems.YJSNPI_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_yjsnpi_pickaxe", providerAccess.has(YJItems.YJSNPI_PICKAXE.get()))
                .unlockedBy("has_yjsnpi_shovel", providerAccess.has(YJItems.YJSNPI_SHOVEL.get()))
                .unlockedBy("has_yjsnpi_axe", providerAccess.has(YJItems.YJSNPI_AXE.get()))
                .unlockedBy("has_yjsnpi_hoe", providerAccess.has(YJItems.YJSNPI_HOE.get()))
                .unlockedBy("has_yjsnpi_sword", providerAccess.has(YJItems.YJSNPI_SWORD.get()))
                .unlockedBy("has_yjsnpi_helmet", providerAccess.has(YJItems.YJSNPI_HELMET.get()))
                .unlockedBy("has_yjsnpi_chestplate", providerAccess.has(YJItems.YJSNPI_CHESTPLATE.get()))
                .unlockedBy("has_yjsnpi_leggings", providerAccess.has(YJItems.YJSNPI_LEGGINGS.get()))
                .unlockedBy("has_yjsnpi_boots", providerAccess.has(YJItems.YJSNPI_BOOTS.get()))
                .unlockedBy("has_yjsnpi_horse_armor", providerAccess.has(YJItems.YJSNPI_HORSE_ARMOR.get()))
                .save(exporter, getBlastingRecipeName(YJItems.YJSNPI_NUGGET.get(), providerAccess));

        cookRecipes(exporter, providerAccess, "smoking", RecipeSerializer.SMOKING_RECIPE, 100);
        cookRecipes(exporter, providerAccess, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 600);

        for (final RegistrySupplier<Block> yjBlock : YJBlocks.YJ_BLOCKS) {
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(YJItemTags.YJSNPI_BLOCK), RecipeCategory.BUILDING_BLOCKS, yjBlock.get())
                    .unlockedBy("has_yjsnpi_block", providerAccess.has(YJItemTags.YJSNPI_BLOCK))
                    .save(exporter, getConversionRecipeName("yjsnpi_block", yjBlock.get(), providerAccess) + "_stonecutting");
        }

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(YJItems.YJ_CORE.get()), Ingredient.of(YJItems.YJSNPI_SWORD.get()), Ingredient.of(YJItems.YJ_CORE.get()), RecipeCategory.COMBAT, YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get())
                .unlocks(providerAccess.getHasName(YJItems.YJ_CORE.get()), providerAccess.has(Items.NETHERITE_INGOT))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get()));
    }

    private void backMaterial(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike backMaterial, TagKey<Item> dyeTag) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, backMaterial, 32)
                .define('A', dyeTag)
                .define('B', YJItemTags.COMPAT_GLOWSTONE)
                .pattern(" A ")
                .pattern("ABA")
                .pattern(" A ")
                .unlockedBy("has_dye", providerAccess.has(dyeTag))
                .save(exporter);
    }

    @SafeVarargs
    private void backMaterialDyeing(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike backMaterial, TagKey<Item> dyeTag, Pair<ItemLike, String>... backMaterialNames) {
        for (Pair<ItemLike, String> backMaterialName : backMaterialNames) {
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, backMaterial, 8)
                    .define('A', dyeTag)
                    .define('B', backMaterialName.getLeft())
                    .pattern("BBB")
                    .pattern("BAB")
                    .pattern("BBB")
                    .unlockedBy("has_dye", providerAccess.has(dyeTag))
                    .save(exporter, modLoc(providerAccess.getItemName(backMaterial) + "_dyeing_" + backMaterialName.getRight()));
        }
    }

    private void sword(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike sword, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void pickaxe(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike pickaxe, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void axe(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike axe, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void shovel(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike shovel, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void hoe(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike hoe, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void helmet(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike helmet, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet)
                .define('X', material)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void chestplate(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike chestplate, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate)
                .define('X', material)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void leggings(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike leggings, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings)
                .define('X', material)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void boots(Consumer<FinishedRecipe> exporter, RecipeProviderAccess providerAccess, ItemLike boots, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots)
                .define('X', material)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, RecipeCategory recipeCategory, ItemLike itemLike, RecipeCategory recipeCategory2, ItemLike itemLike2) {
        nineBlockStorageRecipes(consumer, providerAccess, recipeCategory, itemLike, recipeCategory2, itemLike2, providerAccess.getItemName(itemLike2), null, providerAccess.getItemName(itemLike), null);
    }

    private void nineBlockStorageRecipes(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, RecipeCategory recipeCategory, ItemLike itemLike, RecipeCategory recipeCategory2, ItemLike itemLike2, String string, @Nullable String string2, String string3, @Nullable String string4) {
        ShapelessRecipeBuilder.shapeless(recipeCategory, itemLike, 9).requires(itemLike2).group(string4).unlockedBy(providerAccess.getHasName(itemLike2), providerAccess.has(itemLike2)).save(consumer, new ResourceLocation(string3));
        ShapedRecipeBuilder.shaped(recipeCategory2, itemLike2).define(Character.valueOf('#'), itemLike).pattern("###").pattern("###").pattern("###").group(string2).unlockedBy(providerAccess.getHasName(itemLike), providerAccess.has(itemLike)).save(consumer, new ResourceLocation(string));
    }

    private void planksFromLog(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, ItemLike itemLike, TagKey<Item> tagKey, int i) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, itemLike, i).requires(tagKey).group("planks").unlockedBy("has_log", providerAccess.has(tagKey)).save(consumer);
    }

    private void nineBlockStorageRecipesWithCustomPacking(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, RecipeCategory recipeCategory, ItemLike itemLike, RecipeCategory recipeCategory2, ItemLike itemLike2, String string, String string2) {
        nineBlockStorageRecipes(consumer, providerAccess, recipeCategory, itemLike, recipeCategory2, itemLike2, string, string2, providerAccess.getItemName(itemLike), null);
    }

    private void nineBlockStorageRecipesRecipesWithCustomUnpacking(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, RecipeCategory recipeCategory, ItemLike itemLike, RecipeCategory recipeCategory2, ItemLike itemLike2, String string, String string2) {
        nineBlockStorageRecipes(consumer, providerAccess, recipeCategory, itemLike, recipeCategory2, itemLike2, providerAccess.getItemName(itemLike2), null, string, string2);
    }

    private void oreSmelting(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, List<ItemLike> list, RecipeCategory recipeCategory, ItemLike itemLike, float f, int i, String string) {
        oreCooking(consumer, providerAccess, RecipeSerializer.SMELTING_RECIPE, list, recipeCategory, itemLike, f, i, string, "_from_smelting");
    }

    private void oreCooking(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, RecipeSerializer<? extends AbstractCookingRecipe> recipeSerializer, List<ItemLike> list, RecipeCategory recipeCategory, ItemLike itemLike, float f, int i, String string, String string2) {
        for (ItemLike itemLike2 : list) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike2), recipeCategory, itemLike, f, i, recipeSerializer).group(string).unlockedBy(getHasName(itemLike2, providerAccess), providerAccess.has(itemLike2)).save(consumer, providerAccess.getItemName(itemLike) + string2 + "_" + providerAccess.getItemName(itemLike2));
        }
    }

    private String getHasName(ItemLike itemLike, RecipeProviderAccess providerAccess) {
        return "has_" + providerAccess.getItemName(itemLike);
    }

    private void oreBlasting(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, List<ItemLike> list, RecipeCategory recipeCategory, ItemLike itemLike, float f, int i, String string) {
        oreCooking(consumer, providerAccess, RecipeSerializer.BLASTING_RECIPE, list, recipeCategory, itemLike, f, i, string, "_from_blasting");
    }

    private String getSmeltingRecipeName(ItemLike itemLike, RecipeProviderAccess providerAccess) {
        return providerAccess.getItemName(itemLike) + "_from_smelting";
    }

    private String getBlastingRecipeName(ItemLike itemLike, RecipeProviderAccess providerAccess) {
        return providerAccess.getItemName(itemLike) + "_from_blasting";
    }

    private void simpleCookingRecipe(Consumer<FinishedRecipe> p_249398_, RecipeProviderAccess providerAccess, String p_249709_, RecipeSerializer<? extends AbstractCookingRecipe> p_251876_, int p_249258_, ItemLike p_250669_, ItemLike p_250224_, float p_252138_) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(p_250669_), RecipeCategory.FOOD, p_250224_, p_252138_, p_249258_, p_251876_).unlockedBy(providerAccess.getHasName(p_250669_), providerAccess.has(p_250669_)).save(p_249398_, providerAccess.getItemName(p_250224_) + "_from_" + p_249709_);
    }

    private void cookRecipes(Consumer<FinishedRecipe> consumer, RecipeProviderAccess providerAccess, String string, RecipeSerializer<? extends AbstractCookingRecipe> recipeSerializer, int i) {
        simpleCookingRecipe(consumer, providerAccess, string, recipeSerializer, i, YJItems.POTATO_SENPAI.get(), YJItems.BAKED_POTATO_SENPAI.get(), 0.35f);
    }

    private String getConversionRecipeName(String name, ItemLike itemLike2, RecipeProviderAccess providerAccess) {
        return name + "_from_" + providerAccess.getItemName(itemLike2);
    }
}