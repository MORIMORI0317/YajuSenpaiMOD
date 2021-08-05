package net.morimori.yjsnpimod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.morimori.yjsnpimod.YJSNPIMOD;

import java.util.HashMap;
import java.util.Map;

public class YJEntityTypes {
    private static final Map<ResourceLocation, EntityType<?>> MOD_ENTITYS = new HashMap<>();
    public static final EntityType<KatyouCat> KATYOU_CAT = register("katyou_cat", MobCategory.CREATURE, KatyouCat::new, 0.6F, 0.7F, 8);

    private static <T extends Entity> EntityType<T> register(String name, MobCategory spawnGroup, EntityType.EntityFactory<T> factory, float sizeX, float sizeY, int range) {
        EntityType<T> type = FabricEntityTypeBuilder.create(spawnGroup, factory).dimensions(EntityDimensions.fixed(sizeX, sizeY)).trackRangeBlocks(range).build();
        MOD_ENTITYS.put(new ResourceLocation(YJSNPIMOD.MODID, name), type);
        return type;
    }

    public static void init() {
        MOD_ENTITYS.forEach((n, m) -> Registry.register(Registry.ENTITY_TYPE, n, m));
        FabricDefaultAttributeRegistry.register(KATYOU_CAT, KatyouCat.createMobAttributes());
    }
}
