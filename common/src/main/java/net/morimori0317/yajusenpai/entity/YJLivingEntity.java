package net.morimori0317.yajusenpai.entity;

import net.minecraft.world.entity.Entity;

public interface YJLivingEntity {
    boolean isIkisugi();

    void setIkisugi(boolean ikisugi);

    Entity getGrantedIkisugiEntity();

    void setGrantedIkisugiEntity(Entity entity);
}
