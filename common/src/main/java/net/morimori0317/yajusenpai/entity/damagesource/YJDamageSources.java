package net.morimori0317.yajusenpai.entity.damagesource;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class YJDamageSources {
    public static DamageSource ikisugi(@NotNull Level level, @Nullable Entity cause) {
        HolderLookup.RegistryLookup<DamageType> registryLookup = level.registryAccess().lookup(Registries.DAMAGE_TYPE).get();

        ResourceKey<DamageType> damageType;

        if (cause == null) {
            damageType = YJDamageTypes.IKISUGI;
        } else {
            damageType = YJDamageTypes.PLAYER_IKISUGI;
        }

        return new DamageSource(registryLookup.getOrThrow(damageType), cause);
    }
}
