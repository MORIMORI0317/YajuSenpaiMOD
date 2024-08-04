package net.morimori0317.yajusenpai.entity.damagesource;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJDamageTypes {
    public static final ResourceKey<DamageType> IKISUGI = key("ikisugi");
    public static final ResourceKey<DamageType> PLAYER_IKISUGI = key("player_ikisugi");

    private static ResourceKey<DamageType> key(String id) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, YJUtils.modLoc(id));
    }

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<DamageType> register) {
        register.add(IKISUGI, context -> new DamageType("ikisugi", 0f));
        register.add(PLAYER_IKISUGI, context -> new DamageType("ikisugi.player", 0f));
    }
}
