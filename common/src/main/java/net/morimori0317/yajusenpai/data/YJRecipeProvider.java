package net.morimori0317.yajusenpai.data;

import com.google.common.collect.ImmutableList;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.RecipeProviderWrapper;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.item.YJItems;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class YJRecipeProvider extends RecipeProviderWrapper {
    private static final String BLUE_NAME = "blue";
    private static final String GREEN_NAME = "green";
    private static final String RED_NAME = "red";
    private final ImmutableList<ItemLike> YJNIUM_SMELTABLES = ImmutableList.of(YJBlocks.YJNIUM_ORE.get(), YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), YJItems.RAW_YJNIUM.get());
    private final ImmutableList<ItemLike> YJSNPI_SMELTABLES = ImmutableList.of(YJBlocks.YAJUSENPAI_ORE.get(), YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get(), YJItems.RAW_YAJUSENPAI.get());

    public YJRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, lookup, crossDataGeneratorAccess);
    }

    @Override
    public void generateRecipe(RecipeOutput recipeOutput, RecipeProviderAccess providerAccess) {
        generate(recipeOutput, providerAccess);
    }

    private void generate(RecipeOutput exporter, RecipeProviderAccess providerAccess) {
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
                .unlockedBy(providerAccess.getHasName(YJItems.YAJUSENPAI_INGOT.get()), providerAccess.has(YJItemTags.COMPAT_YJSNPI_INGOT))
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
                .unlockedBy(providerAccess.getHasName(YJItems.YAJUSENPAI_INGOT.get()), providerAccess.has(YJItemTags.COMPAT_YJSNPI_INGOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, YJItems.YJ_CORE.get())
                .define('A', YJItems.APPLE_INM.get())
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
        sword(exporter, providerAccess, YJItems.YAJUSENPAI_SWORD.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        pickaxe(exporter, providerAccess, YJItems.YJNIUM_PICKAXE.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        pickaxe(exporter, providerAccess, YJItems.YAJUSENPAI_PICKAXE.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        axe(exporter, providerAccess, YJItems.YJNIUM_AXE.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        axe(exporter, providerAccess, YJItems.YAJUSENPAI_AXE.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        shovel(exporter, providerAccess, YJItems.YJNIUM_SHOVEL.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        shovel(exporter, providerAccess, YJItems.YAJUSENPAI_SHOVEL.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        hoe(exporter, providerAccess, YJItems.YJNIUM_HOE.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        hoe(exporter, providerAccess, YJItems.YAJUSENPAI_HOE.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        helmet(exporter, providerAccess, YJItems.YJNIUM_HELMET.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        helmet(exporter, providerAccess, YJItems.YAJUSENPAI_HELMET.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        chestplate(exporter, providerAccess, YJItems.YJNIUM_CHESTPLATE.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        chestplate(exporter, providerAccess, YJItems.YAJUSENPAI_CHESTPLATE.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        leggings(exporter, providerAccess, YJItems.YJNIUM_LEGGINGS.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        leggings(exporter, providerAccess, YJItems.YAJUSENPAI_LEGGINGS.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        boots(exporter, providerAccess, YJItems.YJNIUM_BOOTS.get(), YJItemTags.COMPAT_YJNIUM_INGOT);
        boots(exporter, providerAccess, YJItems.YAJUSENPAI_BOOTS.get(), YJItemTags.COMPAT_YJSNPI_INGOT);

        nineBlockStorageRecipes(providerAccess, exporter, RecipeCategory.MISC, YJItems.RAW_YJNIUM.get(), RecipeCategory.BUILDING_BLOCKS, YJBlocks.RAW_YJNIUM_BLOCK.get());
        nineBlockStorageRecipes(providerAccess, exporter, RecipeCategory.MISC, YJItems.RAW_YAJUSENPAI.get(), RecipeCategory.BUILDING_BLOCKS, YJBlocks.RAW_YAJUSENPAI_BLOCK.get());

        planksFromLog(providerAccess, exporter, YJBlocks.YJ_PLANKS.get(), YJItemTags.YJ_LOGS, 4);

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

        nineBlockStorageRecipesWithCustomPacking(providerAccess, exporter, RecipeCategory.MISC, YJItems.YJNIUM_NUGGET.get(), RecipeCategory.MISC, YJItems.YJNIUM_INGOT.get(), "yjnium_ingot_from_nuggets", "yjnium_ingot");
        nineBlockStorageRecipesWithCustomPacking(providerAccess, exporter, RecipeCategory.MISC, YJItems.YAJUSENPAI_NUGGET.get(), RecipeCategory.MISC, YJItems.YAJUSENPAI_INGOT.get(), "yjsnpi_ingot_from_nuggets", "yjsnpi_ingot");


 /*       ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, YJItems.YJNIUM_HORSE_ARMOR.get())
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
                .save(exporter);*/

        nineBlockStorageRecipesRecipesWithCustomUnpacking(providerAccess, exporter, RecipeCategory.MISC, YJItems.YJNIUM_INGOT.get(), RecipeCategory.BUILDING_BLOCKS, YJBlocks.YJNIUM_BLOCK.get(), "yjnium_ingot_from_yjnium_block", "yjnium_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, YJBlocks.YAJUSENPAI_BLOCK.get())
                .define('A', YJItemTags.COMPAT_YJSNPI_INGOT)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .unlockedBy(providerAccess.getHasName(YJItems.YAJUSENPAI_INGOT.get()), providerAccess.has(YJItemTags.COMPAT_YJSNPI_INGOT))
                .save(exporter);

        oreSmelting(providerAccess, exporter, YJNIUM_SMELTABLES, RecipeCategory.MISC, YJItems.YJNIUM_INGOT.get(), 0.7f, 200, "yjnium_ingot");
        oreBlasting(providerAccess, exporter, YJNIUM_SMELTABLES, RecipeCategory.MISC, YJItems.YJNIUM_INGOT.get(), 0.7f, 100, "yjnium_ingot");

        oreSmelting(providerAccess, exporter, YJSNPI_SMELTABLES, RecipeCategory.MISC, YJItems.YAJUSENPAI_INGOT.get(), 0.7f, 200, "yjsnpi_ingot");
        oreBlasting(providerAccess, exporter, YJSNPI_SMELTABLES, RecipeCategory.MISC, YJItems.YAJUSENPAI_INGOT.get(), 0.7f, 100, "yjsnpi_ingot");

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(YJItems.POTATO_SENPAI.get()), RecipeCategory.FOOD, YJItems.BAKED_POTATO_SENPAI.get(), 0.35f, 200)
                .unlockedBy("has_potato_senpai", providerAccess.has(YJItems.POTATO_SENPAI.get()))
                .save(exporter);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(YJItems.YJNIUM_PICKAXE.get(), YJItems.YJNIUM_SHOVEL.get(), YJItems.YJNIUM_AXE.get(), YJItems.YJNIUM_HOE.get(), YJItems.YJNIUM_SWORD.get(), YJItems.YJNIUM_HELMET.get(), YJItems.YJNIUM_CHESTPLATE.get(), YJItems.YJNIUM_LEGGINGS.get(), YJItems.YJNIUM_BOOTS.get()/*, YJItems.YJNIUM_HORSE_ARMOR.get()*/), RecipeCategory.MISC, YJItems.YJNIUM_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_yjnium_pickaxe", providerAccess.has(YJItems.YJNIUM_PICKAXE.get()))
                .unlockedBy("has_yjnium_shovel", providerAccess.has(YJItems.YJNIUM_SHOVEL.get()))
                .unlockedBy("has_yjnium_axe", providerAccess.has(YJItems.YJNIUM_AXE.get()))
                .unlockedBy("has_yjnium_hoe", providerAccess.has(YJItems.YJNIUM_HOE.get()))
                .unlockedBy("has_yjnium_sword", providerAccess.has(YJItems.YJNIUM_SWORD.get()))
                .unlockedBy("has_yjnium_helmet", providerAccess.has(YJItems.YJNIUM_HELMET.get()))
                .unlockedBy("has_yjnium_chestplate", providerAccess.has(YJItems.YJNIUM_CHESTPLATE.get()))
                .unlockedBy("has_yjnium_leggings", providerAccess.has(YJItems.YJNIUM_LEGGINGS.get()))
                .unlockedBy("has_yjnium_boots", providerAccess.has(YJItems.YJNIUM_BOOTS.get()))
                //   .unlockedBy("has_yjnium_horse_armor", providerAccess.has(YJItems.YJNIUM_HORSE_ARMOR.get()))
                .save(exporter, getSmeltingRecipeName(providerAccess, YJItems.YJNIUM_NUGGET.get()));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(YJItems.YAJUSENPAI_PICKAXE.get(), YJItems.YAJUSENPAI_SHOVEL.get(), YJItems.YAJUSENPAI_AXE.get(), YJItems.YAJUSENPAI_HOE.get(), YJItems.YAJUSENPAI_SWORD.get(), YJItems.YAJUSENPAI_HELMET.get(), YJItems.YAJUSENPAI_CHESTPLATE.get(), YJItems.YAJUSENPAI_LEGGINGS.get(), YJItems.YAJUSENPAI_BOOTS.get()/*, YJItems.YAJUSENPAI_HORSE_ARMOR.get()*/), RecipeCategory.MISC, YJItems.YAJUSENPAI_NUGGET.get(), 0.1f, 200)
                .unlockedBy("has_yjsnpi_pickaxe", providerAccess.has(YJItems.YAJUSENPAI_PICKAXE.get()))
                .unlockedBy("has_yjsnpi_shovel", providerAccess.has(YJItems.YAJUSENPAI_SHOVEL.get()))
                .unlockedBy("has_yjsnpi_axe", providerAccess.has(YJItems.YAJUSENPAI_AXE.get()))
                .unlockedBy("has_yjsnpi_hoe", providerAccess.has(YJItems.YAJUSENPAI_HOE.get()))
                .unlockedBy("has_yjsnpi_sword", providerAccess.has(YJItems.YAJUSENPAI_SWORD.get()))
                .unlockedBy("has_yjsnpi_helmet", providerAccess.has(YJItems.YAJUSENPAI_HELMET.get()))
                .unlockedBy("has_yjsnpi_chestplate", providerAccess.has(YJItems.YAJUSENPAI_CHESTPLATE.get()))
                .unlockedBy("has_yjsnpi_leggings", providerAccess.has(YJItems.YAJUSENPAI_LEGGINGS.get()))
                .unlockedBy("has_yjsnpi_boots", providerAccess.has(YJItems.YAJUSENPAI_BOOTS.get()))
                // .unlockedBy("has_yjsnpi_horse_armor", providerAccess.has(YJItems.YAJUSENPAI_HORSE_ARMOR.get()))
                .save(exporter, getSmeltingRecipeName(providerAccess, YJItems.YAJUSENPAI_NUGGET.get()));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(YJItems.YJNIUM_PICKAXE.get(), YJItems.YJNIUM_SHOVEL.get(), YJItems.YJNIUM_AXE.get(), YJItems.YJNIUM_HOE.get(), YJItems.YJNIUM_SWORD.get(), YJItems.YJNIUM_HELMET.get(), YJItems.YJNIUM_CHESTPLATE.get(), YJItems.YJNIUM_LEGGINGS.get(), YJItems.YJNIUM_BOOTS.get()/*, YJItems.YJNIUM_HORSE_ARMOR.get()*/), RecipeCategory.MISC, YJItems.YJNIUM_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_yjnium_pickaxe", providerAccess.has(YJItems.YJNIUM_PICKAXE.get()))
                .unlockedBy("has_yjnium_shovel", providerAccess.has(YJItems.YJNIUM_SHOVEL.get()))
                .unlockedBy("has_yjnium_axe", providerAccess.has(YJItems.YJNIUM_AXE.get()))
                .unlockedBy("has_yjnium_hoe", providerAccess.has(YJItems.YJNIUM_HOE.get()))
                .unlockedBy("has_yjnium_sword", providerAccess.has(YJItems.YJNIUM_SWORD.get()))
                .unlockedBy("has_yjnium_helmet", providerAccess.has(YJItems.YJNIUM_HELMET.get()))
                .unlockedBy("has_yjnium_chestplate", providerAccess.has(YJItems.YJNIUM_CHESTPLATE.get()))
                .unlockedBy("has_yjnium_leggings", providerAccess.has(YJItems.YJNIUM_LEGGINGS.get()))
                .unlockedBy("has_yjnium_boots", providerAccess.has(YJItems.YJNIUM_BOOTS.get()))
                // .unlockedBy("has_yjnium_horse_armor", providerAccess.has(YJItems.YJNIUM_HORSE_ARMOR.get()))
                .save(exporter, getBlastingRecipeName(providerAccess, YJItems.YJNIUM_NUGGET.get()));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(YJItems.YAJUSENPAI_PICKAXE.get(), YJItems.YAJUSENPAI_SHOVEL.get(), YJItems.YAJUSENPAI_AXE.get(), YJItems.YAJUSENPAI_HOE.get(), YJItems.YAJUSENPAI_SWORD.get(), YJItems.YAJUSENPAI_HELMET.get(), YJItems.YAJUSENPAI_CHESTPLATE.get(), YJItems.YAJUSENPAI_LEGGINGS.get(), YJItems.YAJUSENPAI_BOOTS.get()/*, YJItems.YAJUSENPAI_HORSE_ARMOR.get()*/), RecipeCategory.MISC, YJItems.YAJUSENPAI_NUGGET.get(), 0.1f, 100)
                .unlockedBy("has_yjsnpi_pickaxe", providerAccess.has(YJItems.YAJUSENPAI_PICKAXE.get()))
                .unlockedBy("has_yjsnpi_shovel", providerAccess.has(YJItems.YAJUSENPAI_SHOVEL.get()))
                .unlockedBy("has_yjsnpi_axe", providerAccess.has(YJItems.YAJUSENPAI_AXE.get()))
                .unlockedBy("has_yjsnpi_hoe", providerAccess.has(YJItems.YAJUSENPAI_HOE.get()))
                .unlockedBy("has_yjsnpi_sword", providerAccess.has(YJItems.YAJUSENPAI_SWORD.get()))
                .unlockedBy("has_yjsnpi_helmet", providerAccess.has(YJItems.YAJUSENPAI_HELMET.get()))
                .unlockedBy("has_yjsnpi_chestplate", providerAccess.has(YJItems.YAJUSENPAI_CHESTPLATE.get()))
                .unlockedBy("has_yjsnpi_leggings", providerAccess.has(YJItems.YAJUSENPAI_LEGGINGS.get()))
                .unlockedBy("has_yjsnpi_boots", providerAccess.has(YJItems.YAJUSENPAI_BOOTS.get()))
                // .unlockedBy("has_yjsnpi_horse_armor", providerAccess.has(YJItems.YAJUSENPAI_HORSE_ARMOR.get()))
                .save(exporter, getBlastingRecipeName(providerAccess, YJItems.YAJUSENPAI_NUGGET.get()));

        cookRecipes(providerAccess, exporter, "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100);
        cookRecipes(providerAccess, exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, 600);

        for (final RegistrySupplier<Block> yjBlock : YJBlocks.YJ_BLOCKS) {
            SingleItemRecipeBuilder.stonecutting(Ingredient.of(YJItemTags.YJSNPI_BLOCK), RecipeCategory.BUILDING_BLOCKS, yjBlock.get())
                    .unlockedBy("has_yjsnpi_block", providerAccess.has(YJItemTags.YJSNPI_BLOCK))
                    .save(exporter, getConversionRecipeName(providerAccess, "yjsnpi_block", yjBlock.get()) + "_stonecutting");
        }

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(YJItems.YJ_CORE.get()), Ingredient.of(YJItems.YAJUSENPAI_SWORD.get()), Ingredient.of(YJItems.YJ_CORE.get()), RecipeCategory.COMBAT, YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get())
                .unlocks(providerAccess.getHasName(YJItems.YJ_CORE.get()), providerAccess.has(Items.NETHERITE_INGOT))
                .save(exporter, RecipeBuilder.getDefaultRecipeId(YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get()));
    }

    private <T extends AbstractCookingRecipe> void cookRecipes(RecipeProviderAccess providerAccess, RecipeOutput arg, String string, RecipeSerializer<T> arg2, AbstractCookingRecipe.Factory<T> arg3, int i) {
        simpleCookingRecipe(providerAccess, arg, string, arg2, arg3, i, YJItems.POTATO_SENPAI.get(), YJItems.BAKED_POTATO_SENPAI.get(), 0.35f);
    }

    protected static <T extends AbstractCookingRecipe> void simpleCookingRecipe(RecipeProviderAccess providerAccess, RecipeOutput arg, String string, RecipeSerializer<T> arg2, AbstractCookingRecipe.Factory<T> arg3, int i, ItemLike arg4, ItemLike arg5, float f) {
        SimpleCookingRecipeBuilder var10000 = SimpleCookingRecipeBuilder.generic(Ingredient.of(arg4), RecipeCategory.FOOD, arg5, f, i, arg2, arg3).unlockedBy(providerAccess.getHasName(arg4), providerAccess.has(arg4));
        String var10002 = providerAccess.getItemName(arg5);
        var10000.save(arg, var10002 + "_from_" + string);
    }

    private void backMaterial(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike backMaterial, TagKey<Item> dyeTag) {
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
    private void backMaterialDyeing(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike backMaterial, TagKey<Item> dyeTag, Pair<ItemLike, String>... backMaterialNames) {
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

    private void sword(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike sword, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, sword)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void pickaxe(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike pickaxe, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void axe(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike axe, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void shovel(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike shovel, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void hoe(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike hoe, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe)
                .define('#', Items.STICK)
                .define('X', material)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void helmet(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike helmet, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, helmet)
                .define('X', material)
                .pattern("XXX")
                .pattern("X X")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void chestplate(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike chestplate, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, chestplate)
                .define('X', material)
                .pattern("X X")
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void leggings(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike leggings, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, leggings)
                .define('X', material)
                .pattern("XXX")
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    private void boots(RecipeOutput exporter, RecipeProviderAccess providerAccess, ItemLike boots, TagKey<Item> material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, boots)
                .define('X', material)
                .pattern("X X")
                .pattern("X X")
                .unlockedBy("has_material", providerAccess.has(material))
                .save(exporter);
    }

    protected static void nineBlockStorageRecipesWithCustomPacking(RecipeProviderAccess providerAccess, RecipeOutput arg, RecipeCategory arg2, ItemLike arg3, RecipeCategory arg4, ItemLike arg5, String string, String string2) {
        nineBlockStorageRecipes(providerAccess, arg, arg2, arg3, arg4, arg5, string, string2, getSimpleRecipeName(providerAccess, arg3), (String) null);
    }

    protected static void nineBlockStorageRecipesRecipesWithCustomUnpacking(RecipeProviderAccess providerAccess, RecipeOutput arg, RecipeCategory arg2, ItemLike arg3, RecipeCategory arg4, ItemLike arg5, String string, String string2) {
        nineBlockStorageRecipes(providerAccess, arg, arg2, arg3, arg4, arg5, getSimpleRecipeName(providerAccess, arg5), null, string, string2);
    }

    protected static void nineBlockStorageRecipes(RecipeProviderAccess providerAccess, RecipeOutput arg, RecipeCategory arg2, ItemLike arg3, RecipeCategory arg4, ItemLike arg5) {
        nineBlockStorageRecipes(providerAccess, arg, arg2, arg3, arg4, arg5, getSimpleRecipeName(providerAccess, arg5), null, getSimpleRecipeName(providerAccess, arg3), (String) null);
    }

    protected static void nineBlockStorageRecipes(RecipeProviderAccess providerAccess, RecipeOutput arg, RecipeCategory arg2, ItemLike arg3, RecipeCategory arg4, ItemLike arg5, String string, @Nullable String string2, String string3, @Nullable String string4) {
        ShapelessRecipeBuilder.shapeless(arg2, arg3, 9).requires(arg5).group(string4).unlockedBy(providerAccess.getHasName(arg5), providerAccess.has(arg5)).save(arg, ResourceLocation.parse(string3));
        ShapedRecipeBuilder.shaped(arg4, arg5).define('#', arg3).pattern("###").pattern("###").pattern("###").group(string2).unlockedBy(providerAccess.getHasName(arg3), providerAccess.has(arg3)).save(arg, ResourceLocation.parse(string));
    }

    protected static String getSimpleRecipeName(RecipeProviderAccess providerAccess, ItemLike arg) {
        return providerAccess.getItemName(arg);
    }

    protected static void planksFromLog(RecipeProviderAccess providerAccess, RecipeOutput arg, ItemLike arg2, TagKey<Item> arg3, int i) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, arg2, i).requires(arg3).group("planks").unlockedBy("has_log", providerAccess.has(arg3)).save(arg);
    }

    protected static void oreBlasting(RecipeProviderAccess providerAccess, RecipeOutput arg, List<ItemLike> list, RecipeCategory arg2, ItemLike arg3, float f, int i, String string) {
        oreCooking(providerAccess, arg, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, list, arg2, arg3, f, i, string, "_from_blasting");
    }

    protected static void oreSmelting(RecipeProviderAccess providerAccess, RecipeOutput arg, List<ItemLike> list, RecipeCategory arg2, ItemLike arg3, float f, int i, String string) {
        oreCooking(providerAccess, arg, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, list, arg2, arg3, f, i, string, "_from_smelting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeProviderAccess providerAccess, RecipeOutput arg, RecipeSerializer<T> arg2, AbstractCookingRecipe.Factory<T> arg3, List<ItemLike> list, RecipeCategory arg4, ItemLike arg5, float f, int i, String string, String string2) {
        for (ItemLike itemlike : list) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), arg4, arg5, f, i, arg2, arg3).group(string).unlockedBy(providerAccess.getHasName(itemlike), providerAccess.has(itemlike)).save(arg, providerAccess.getItemName(arg5) + string2 + "_" + providerAccess.getItemName(itemlike));
        }
    }

    protected static String getSmeltingRecipeName(RecipeProviderAccess providerAccess, ItemLike arg) {
        return providerAccess.getItemName(arg) + "_from_smelting";
    }

    protected static String getBlastingRecipeName(RecipeProviderAccess providerAccess, ItemLike arg) {
        return providerAccess.getItemName(arg) + "_from_blasting";
    }

    protected static String getConversionRecipeName(RecipeProviderAccess providerAccess, String arg, ItemLike arg2) {
        return arg + "_from_" + providerAccess.getItemName(arg2);
    }
}
