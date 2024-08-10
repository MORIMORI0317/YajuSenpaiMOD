package net.morimori0317.yajusenpai.fabric.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class YJBlockTagsFabric {
    public static final TagKey<Block> STORAGE_BLOCKS_YJNIUM = bind("storage_blocks/yjnium");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_YJNIUM = bind("storage_blocks/raw_yjnium");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_YAJUSENPAI = bind("storage_blocks/raw_yajusenpai");

    public static final TagKey<Block> YJNIUM_ORES = bind("ores/yjnium");
    public static final TagKey<Block> YAJUSENPAI_ORES = bind("ores/yajusenpai");

    public static final TagKey<Block> SANDS = bind("sands");
    public static final TagKey<Block> GRAVELS = bind("gravels");

    private static TagKey<Block> bind(String id) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", id));
    }
}
