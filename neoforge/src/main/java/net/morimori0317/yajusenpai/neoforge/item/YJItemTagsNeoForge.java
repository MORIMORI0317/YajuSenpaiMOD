package net.morimori0317.yajusenpai.neoforge.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class YJItemTagsNeoForge {
    public static final TagKey<Item> ORES_YJNIUM = fgBind("ores/yjnium");
    public static final TagKey<Item> ORES_YJSNPI = fgBind("ores/yjsnpi");
    public static final TagKey<Item> STORAGE_BLOCKS_YJNIUM = fgBind("storage_blocks/yjnium");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_YJNIUM = fgBind("storage_blocks/raw_yjnium");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_YJSNPI = fgBind("storage_blocks/raw_yjsnpi");
    public static final TagKey<Item> CROPS_POTATO_SENPAI = fgBind("crops/potato_senpai");
    public static final TagKey<Item> INGOTS_YJNIUM = fgBind("ingots/yjnium");
    public static final TagKey<Item> INGOTS_YJSNPI = fgBind("ingots/yjsnpi");
    public static final TagKey<Item> NUGGETS_YJNIUM = fgBind("nuggets/yjnium");
    public static final TagKey<Item> NUGGETS_YJSNPI = fgBind("nuggets/yjsnpi");
    public static final TagKey<Item> RAW_MATERIALS_YJNIUM = fgBind("raw_materials/yjnium");
    public static final TagKey<Item> RAW_MATERIALS_YJSNPI = fgBind("raw_materials/yjsnpi");

    private static TagKey<Item> fgBind(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("neoforge", id));
    }
}
