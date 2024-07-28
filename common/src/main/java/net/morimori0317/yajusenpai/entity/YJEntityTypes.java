package net.morimori0317.yajusenpai.entity;

import dev.architectury.registry.level.entity.EntityAttributeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.morimori0317.yajusenpai.YajuSenpai;

import java.util.function.Supplier;

public class YJEntityTypes {
    private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(YajuSenpai.MODID, Registries.ENTITY_TYPE);
    public static final RegistrySupplier<EntityType<KatyouCat>> KATYOU_CAT = register("katyou_cat", () -> EntityType.Builder.of(KatyouCat::new, MobCategory.CREATURE).sized(0.6F, 0.7F).clientTrackingRange(8));

    private static <T extends Entity> RegistrySupplier<EntityType<T>> register(String name, Supplier<EntityType.Builder<T>> builderSupplier) {
        return ENTITY_TYPES.register(name, () -> builderSupplier.get().build(name));
    }

    public static void init() {
        ENTITY_TYPES.register();
        EntityAttributeRegistry.register(KATYOU_CAT, KatyouCat::createMobAttributes);
    }
}