package net.morimori0317.yajusenpai.entity;

import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;

public class EnityIkisugiDamageSource extends EntityDamageSource {

    public EnityIkisugiDamageSource(Entity entity) {
        super("ikisugi", entity);
        bypassInvul();
        bypassEnchantments();
        bypassMagic();
        bypassArmor();
        setMagic();
    }
}
