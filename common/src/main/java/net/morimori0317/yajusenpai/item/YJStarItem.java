package net.morimori0317.yajusenpai.item;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.SimpleFoiledItem;

public class YJStarItem extends SimpleFoiledItem {
    public YJStarItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canBeHurtBy(DamageSource damageSource) {
        if (!super.canBeHurtBy(damageSource))
            return false;
        return !damageSource.isExplosion();
    }
}
