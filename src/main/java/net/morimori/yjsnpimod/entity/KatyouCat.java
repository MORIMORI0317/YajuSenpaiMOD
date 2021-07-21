package net.morimori.yjsnpimod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.level.Level;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.registry.YJSoundEvents;
import org.jetbrains.annotations.Nullable;

public class KatyouCat extends Cat {
    private static final ResourceLocation LOCATION = new ResourceLocation(YJSNPIMOD.MODID, "textures/entity/katyou_cat.png");

    public KatyouCat(EntityType<? extends Cat> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return LOCATION;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return YJSoundEvents.KATYOU_NYA;
    }
}
