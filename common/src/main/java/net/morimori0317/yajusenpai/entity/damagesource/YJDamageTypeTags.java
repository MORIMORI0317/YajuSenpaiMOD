package net.morimori0317.yajusenpai.entity.damagesource;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJDamageTypeTags {
    public static final TagKey<DamageType> IS_IKISUGI = bind("is_ikisugi");

    private static TagKey<DamageType> bind(String id) {
        return TagKey.create(Registries.DAMAGE_TYPE, YJUtils.modLoc(id));
    }
}
