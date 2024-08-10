package net.morimori0317.yajusenpai.neoforge.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class YJItemTagsNeoForge {
    public static final TagKey<Item> ORES_YJNIUM = bind("ores/yjnium");
    public static final TagKey<Item> ORES_YJSNPI = bind("ores/yjsnpi");
    public static final TagKey<Item> STORAGE_BLOCKS_YJNIUM = bind("storage_blocks/yjnium");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_YJNIUM = bind("storage_blocks/raw_yjnium");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_YJSNPI = bind("storage_blocks/raw_yjsnpi");
    public static final TagKey<Item> CROPS_POTATO_SENPAI = bind("crops/potato_senpai");
    public static final TagKey<Item> INGOTS_YJNIUM = bind("ingots/yjnium");
    public static final TagKey<Item> INGOTS_YJSNPI = bind("ingots/yjsnpi");
    public static final TagKey<Item> NUGGETS_YJNIUM = bind("nuggets/yjnium");
    public static final TagKey<Item> NUGGETS_YJSNPI = bind("nuggets/yjsnpi");
    public static final TagKey<Item> RAW_MATERIALS_YJNIUM = bind("raw_materials/yjnium");
    public static final TagKey<Item> RAW_MATERIALS_YJSNPI = bind("raw_materials/yjsnpi");

    public static final TagKey<Item> DRINKS = bind("drinks");
    public static final TagKey<Item> TEA = bind("tea");
    public static final TagKey<Item> ICE_TEA = bind("ice_tea");
    public static final TagKey<Item> ICETEA = bind("icetea");
    public static final TagKey<Item> DRINKS_TEA = bind("drinks/tea");
    public static final TagKey<Item> DRINKS_ICE_TEA = bind("drinks/ice_tea");
    public static final TagKey<Item> DRINKS_ICETEA = bind("drinks/icetea");

    public static final TagKey<Item> FRUITS = bind("fruits");
    public static final TagKey<Item> APPLE = bind("apple");
    public static final TagKey<Item> FRUITS_APPLE = bind("fruits/apple");

    private static TagKey<Item> bind(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", id));
    }
}
