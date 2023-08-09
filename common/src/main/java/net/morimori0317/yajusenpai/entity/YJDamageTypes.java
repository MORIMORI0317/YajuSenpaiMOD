package net.morimori0317.yajusenpai.entity;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJDamageTypes {
    public static final ResourceKey<DamageType> IKISUGI = key("ikisugi");

    private static ResourceKey<DamageType> key(String id) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, YJUtils.modLoc(id));
    }

    public static RegistrySetBuilder addToBuilder(RegistrySetBuilder builder) {
        return builder.add(Registries.DAMAGE_TYPE, context -> context.register(IKISUGI, new DamageType("ikisugi", 0f)));
    }

}
