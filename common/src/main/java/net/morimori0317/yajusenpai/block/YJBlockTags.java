package net.morimori0317.yajusenpai.block;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.YajuSenpai;

public class YJBlockTags {
    public static final TagKey<Block> YJ_STONE_ORE_REPLACEABLES = create("yj_stone_ore_replaceables");
    public static final TagKey<Block> YJ_DEEPSLATE_ORE_REPLACEABLES = create("yj_deepslate_ore_replaceables");
    public static final TagKey<Block> BASE_YJ_STONE_YJDIM = create("base_yj_stone_yjdim");

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(YajuSenpai.MODID, name));
    }
}
