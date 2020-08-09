package net.morimori.yjsnpimod.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.IForgeRegistry;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJEntityTypes {
    public static final EntityType<ToiletSitEntity> TOILET_SIT = EntityType.Builder.<ToiletSitEntity>create(ToiletSitEntity::new, EntityClassification.MISC).size(0.1F, 0.1F).build(YJSNPIMOD.MODID + ":toilet_sit");

    public static void registerEntity(IForgeRegistry<EntityType<?>> r) {
        r.register(TOILET_SIT.setRegistryName(YJSNPIMOD.MODID, "toilet_sit"));
    }
}
