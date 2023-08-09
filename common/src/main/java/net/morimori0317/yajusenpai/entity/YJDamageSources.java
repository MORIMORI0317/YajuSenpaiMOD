package net.morimori0317.yajusenpai.entity;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class YJDamageSources {
    public static DamageSource ikisugi(@NotNull Level level, @Nullable Entity cause, @Nullable Entity indirectCause) {
        HolderLookup.RegistryLookup<DamageType> registryLookup = level.registryAccess().lookup(Registries.DAMAGE_TYPE).get();
        return new DamageSource(registryLookup.getOrThrow(YJDamageTypes.IKISUGI), cause, indirectCause);
    }
}
