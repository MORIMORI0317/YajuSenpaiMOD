package net.morimori0317.yajusenpai.server.level.dimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJBiomeTags {
    public static final TagKey<Biome> HAS_YJ_HOUSE = bind("has_structure/yj_house");
    public static final TagKey<Biome> IS_YAJUSENPAI = bind("is_yajusenpai");

    private static TagKey<Biome> bind(String id) {
        return TagKey.create(Registries.BIOME, YJUtils.modLoc(id));
    }
}
