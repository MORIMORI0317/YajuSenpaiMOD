package net.morimori.yjsnpimod.client.renderer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.morimori.yjsnpimod.block.YJBlocks;

public class BlockRenderTypes {
    public static void init() {
        BlockRenderLayerMap.INSTANCE.putBlock(YJBlocks.YJ_SAPLING, RenderType.cutout());
    }
}
