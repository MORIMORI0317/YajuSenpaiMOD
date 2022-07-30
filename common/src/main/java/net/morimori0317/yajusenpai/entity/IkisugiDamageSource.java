package net.morimori0317.yajusenpai.entity;

import net.minecraft.world.damagesource.DamageSource;

public class IkisugiDamageSource extends DamageSource {
    public IkisugiDamageSource() {
        super("ikisugi");
        bypassInvul();
        bypassEnchantments();
        bypassMagic();
        bypassArmor();
        setMagic();
    }
}
