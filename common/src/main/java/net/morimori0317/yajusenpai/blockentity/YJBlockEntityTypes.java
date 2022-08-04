package net.morimori0317.yajusenpai.blockentity;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlocks;

import java.util.function.Supplier;

public class YJBlockEntityTypes {
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES_REGISTER = DeferredRegister.create(YajuSenpai.MODID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);
    public static final RegistrySupplier<BlockEntityType<TheYJPortalBlockEntity>> YJ_PORTAL = register("yj_portal", () -> TheYJPortalBlockEntity::new, YJBlocks.YJ_PORTAL);

    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(String name, Supplier<BlockEntityType.BlockEntitySupplier<T>> constructor, RegistrySupplier<Block> blocks) {
        return BLOCK_ENTITY_TYPES_REGISTER.register(name, () -> BlockEntityType.Builder.of(constructor.get(), blocks.get()).build(null));
    }

    public static void init() {
        BLOCK_ENTITY_TYPES_REGISTER.register();
    }
}
