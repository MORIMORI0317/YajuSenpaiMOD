package net.morimori0317.yajusenpai.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

public interface YJLivingEntity {
    boolean isIkisugi();

    void setIkisugi(boolean ikisugi);

    Entity getGrantedIkisugiEntity();

    void setGrantedIkisugiEntity(Entity entity);

    BlockPos getSleepingPos();

    void setSleepingPos(BlockPos pos);

    boolean isComa();

    boolean isComaSync();

    void setComaSync(boolean comaSync);

    boolean isIkisugiSleeping();

    void setIkisugiSleeping(boolean ikisugiSleeping);

    int getYJPortalCoolDown();

    void setYJPortalCoolDown(int coolDown);

    boolean canYJPortalUse();

    void setYJPortalUse(boolean use);
}
