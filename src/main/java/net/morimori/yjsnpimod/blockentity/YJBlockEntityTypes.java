package net.morimori.yjsnpimod.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;

import java.util.HashMap;
import java.util.Map;

public class YJBlockEntityTypes {
    private static final Map<ResourceLocation, BlockEntityType<?>> MOD_BLOCKENTITYTYPES = new HashMap<>();
    public static final BlockEntityType<YJPortalBlockEntity> YJ_PORTAL = register("yj_portal",  FabricBlockEntityTypeBuilder.create(YJPortalBlockEntity::new, YJBlocks.YJ_PORTAL).build(null));

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> types) {
        MOD_BLOCKENTITYTYPES.put(new ResourceLocation(YJSNPIMOD.MODID, name), types);
        return types;
    }

    public static void init() {
        MOD_BLOCKENTITYTYPES.forEach((n, m) -> Registry.register(Registry.BLOCK_ENTITY_TYPE, n, m));
    }
}
