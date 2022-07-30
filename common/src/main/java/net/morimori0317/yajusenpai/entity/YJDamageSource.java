package net.morimori0317.yajusenpai.entity;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;

public class YJDamageSource {
    public static final DamageSource IKISUGI = new IkisugiDamageSource();

    public static DamageSource ikisugi(Entity entity) {
        if (entity == null)
            return IKISUGI;
        return new EnityIkisugiDamageSource(entity);
    }
}
