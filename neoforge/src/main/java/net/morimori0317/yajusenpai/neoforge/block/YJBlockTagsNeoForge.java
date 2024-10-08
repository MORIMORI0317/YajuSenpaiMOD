package net.morimori0317.yajusenpai.neoforge.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class YJBlockTagsNeoForge {
    public static final TagKey<Block> ORES_YJNIUM = fgBind("ores/yjnium");
    public static final TagKey<Block> ORES_YAJUSENPAI = fgBind("ores/yajusenpai");
    public static final TagKey<Block> STORAGE_BLOCKS_YJNIUM = fgBind("storage_blocks/yjnium");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_YJNIUM = fgBind("storage_blocks/raw_yjnium");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_YAJUSENPAI = fgBind("storage_blocks/raw_yajusenpai");

    private static TagKey<Block> fgBind(String id) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", id));
    }
}