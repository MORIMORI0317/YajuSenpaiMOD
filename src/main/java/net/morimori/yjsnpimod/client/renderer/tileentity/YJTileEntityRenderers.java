package net.morimori.yjsnpimod.client.renderer.tileentity;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.morimori.yjsnpimod.tileentity.YJTileEntityTypes;

public class YJTileEntityRenderers {
    public static void registerTileEntityRenderer() {
        ClientRegistry.bindTileEntityRenderer(YJTileEntityTypes.TOILET, ToiletTileEntityRenderer::new);
    }
}
