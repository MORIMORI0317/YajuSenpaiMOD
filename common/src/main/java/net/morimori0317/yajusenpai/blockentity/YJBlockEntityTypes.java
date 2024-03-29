package net.morimori0317.yajusenpai.blockentity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;

import java.util.function.Supplier;

public class YJBlockEntityTypes {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES_REGISTER = DeferredRegister.create(YajuSenpai.MODID, Registries.BLOCK_ENTITY_TYPE);
    public static final RegistrySupplier<BlockEntityType<YJPortalBlockEntity>> YJ_PORTAL = register("yj_portal", () -> YJPortalBlockEntity::new, YJBlocks.YJ_PORTAL);
    public static final RegistrySupplier<BlockEntityType<BigPillowBlockEntity>> BIG_PILLOW = register("big_pillow", () -> BigPillowBlockEntity::new, YJBlocks.BIG_PILLOW);

    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(String name, Supplier<BlockEntityType.BlockEntitySupplier<T>> constructor, RegistrySupplier<Block> blocks) {
        return BLOCK_ENTITY_TYPES_REGISTER.register(name, () -> BlockEntityType.Builder.of(constructor.get(), blocks.get()).build(null));
    }

    public static void init() {
        BLOCK_ENTITY_TYPES_REGISTER.register();
    }
}
