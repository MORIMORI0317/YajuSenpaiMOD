package net.morimori0317.yajusenpai.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;

public interface YJLivingEntityAccessor {
    boolean yajuSenpai$isIkisugi();

    void yajuSenpai$setIkisugi(boolean ikisugi);

    Entity yajuSenpai$getGrantedIkisugiEntity();

    void yajuSenpai$setGrantedIkisugiEntity(Entity entity);

    BlockPos yajuSenpai$getSleepingPos();

    void yajuSenpai$setSleepingPos(BlockPos pos);

    boolean yajuSenpai$isComa();

    boolean yajuSenpai$isComaSync();

    void yajuSenpai$setComaSync(boolean comaSync);

    boolean yajuSenpai$isIkisugiSleeping();

    void yajuSenpai$setIkisugiSleeping(boolean ikisugiSleeping);

    int yajuSenpai$getYJPortalCoolDown();

    void yajuSenpai$setYJPortalCoolDown(int coolDown);

    boolean yajuSenpai$canYJPortalUse();

    void yajuSenpai$setYJPortalUse(boolean use);
}