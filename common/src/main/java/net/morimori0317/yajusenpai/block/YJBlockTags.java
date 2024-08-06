package net.morimori0317.yajusenpai.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJBlockTags {
    public static final TagKey<Block> INM_BLOCK = bind("inm_block");
    public static final TagKey<Block> YJSNPI_BLOCK = bind("yjsnpi_block");
    public static final TagKey<Block> YJ_STONE_ORE_REPLACEABLES = bind("yj_stone_ore_replaceables");
    public static final TagKey<Block> YJ_DEEPSLATE_ORE_REPLACEABLES = bind("yj_deepslate_ore_replaceables");
    public static final TagKey<Block> BASE_YJ_STONE_YJDIM = bind("base_yj_stone_yjdim");
    public static final TagKey<Block> YJ_LOGS = bind("yj_logs");
    public static final TagKey<Block> YJNIUM_ORES = bind("yjnium_ores");
    public static final TagKey<Block> YJSNPI_ORES = bind("yjsnpi_ores");
    public static final TagKey<Block> INM_BLOCK_REPLACEABLES = bind("inm_block_replaceables");

    private static TagKey<Block> bind(String id) {
        return TagKey.create(Registries.BLOCK, YJUtils.modLoc(id));
    }
}
