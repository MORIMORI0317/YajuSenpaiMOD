package net.morimori0317.yajusenpai.fabric.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class YJItemTagsFabric {
    public static final TagKey<Item> GLOWSTONE_BLOCKS = bind("glowstone_blocks");

    public static final TagKey<Item> OLD_RAW_YJNIUM_ORES = bind("raw_yjnium_ores");
    public static final TagKey<Item> OLD_RAW_YAJUSENPAI_ORES = bind("raw_yajusenpai_ores");
    public static final TagKey<Item> OLD_YJNIUM_BLOCKS = bind("yjnium_blocks");
    public static final TagKey<Item> OLD_RAW_YJNIUM_BLOCKS = bind("raw_yjnium_blocks");
    public static final TagKey<Item> OLD_RAW_YAJUSENPAI_BLOCKS = bind("raw_yajusenpai_blocks");
    public static final TagKey<Item> OLD_YJNIUM_INGOTS = bind("yjnium_ingots");
    public static final TagKey<Item> OLD_YAJUSENPAI_INGOTS = bind("yajusenpai_ingots");
    public static final TagKey<Item> OLD_YJNIUM_NUGGETS = bind("yjnium_nuggets");
    public static final TagKey<Item> OLD_YAJUSENPAI_NUGGETS = bind("yajusenpai_nuggets");

    public static final TagKey<Item> YJNIUM_ORES = bind("ores/yjnium");
    public static final TagKey<Item> YAJUSENPAI_ORES = bind("ores/yajusenpai");
    public static final TagKey<Item> YJNIUM_RAW_MATERIALS = bind("raw_materials/yjnium");
    public static final TagKey<Item> YAJUSENPAI_RAW_MATERIALS = bind("raw_materials/yajusenpai");
    public static final TagKey<Item> STORAGE_BLOCKS_YJNIUM = bind("storage_blocks/yjnium");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_YJNIUM = bind("storage_blocks/raw_yjnium");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_YAJUSENPAI = bind("storage_blocks/raw_yajusenpai");
    public static final TagKey<Item> YJNIUM_INGOTS = bind("ingots/yjnium");
    public static final TagKey<Item> YAJUSENPAI_INGOTS = bind("ingots/yajusenpai");
    public static final TagKey<Item> YJNIUM_NUGGETS = bind("nuggets/yjnium");
    public static final TagKey<Item> YAJUSENPAI_NUGGETS = bind("nuggets/yajusenpai");

    public static final TagKey<Item> WHEAT_CROPS = bind("wheat_crops");

    public static final TagKey<Item> SANDS = bind("sands");
    public static final TagKey<Item> GRAVELS = bind("gravels");

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

    public static final TagKey<Item> NETHER_STARS = bind("nether_stars");

    private static TagKey<Item> bind(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", id));
    }
}
