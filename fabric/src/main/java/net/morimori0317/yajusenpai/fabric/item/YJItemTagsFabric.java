package net.morimori0317.yajusenpai.fabric.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class YJItemTagsFabric {
    public static final TagKey<Item> GLOWSTONE_BLOCKS = bind("glowstone_blocks");
    public static final TagKey<Item> IRON_INGOTS = bind("iron_ingots");
    public static final TagKey<Item> NETHERITE_INGOTS = bind("netherite_ingots");
    public static final TagKey<Item> RAW_YJNIUM_ORES = bind("raw_yjnium_ores");
    public static final TagKey<Item> RAW_YJNIUM_BLOCKS = bind("raw_yjnium_blocks");
    public static final TagKey<Item> RAW_YJSNPI_ORES = bind("raw_yjsnpi_ores");
    public static final TagKey<Item> RAW_YJSNPI_BLOCKS = bind("raw_yjsnpi_blocks");
    public static final TagKey<Item> WHEAT_CROPS = bind("wheat_crops");
    public static final TagKey<Item> YJNIUM_BLOCKS = bind("yjnium_blocks");
    public static final TagKey<Item> YJNIUM_INGOTS = bind("yjnium_ingots");
    public static final TagKey<Item> YJNIUM_NUGGETS = bind("yjnium_nuggets");
    public static final TagKey<Item> YJSNPI_INGOTS = bind("yjsnpi_ingots");
    public static final TagKey<Item> YJSNPI_NUGGETS = bind("yjsnpi_nuggets");

    private static TagKey<Item> bind(String id) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("c", id));
    }
}
