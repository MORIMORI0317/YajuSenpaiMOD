package net.morimori.yjsnpimod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.morimori.yjsnpimod.client.handler.ClientHandler;
import net.morimori.yjsnpimod.client.handler.RenderHandler;
import net.morimori.yjsnpimod.client.renderer.tileentity.YJTileEntityRenderers;

public class ClientProxy extends CommonProxy {
    public static void clientInit() {
        MinecraftForge.EVENT_BUS.register(RenderHandler.class);
        MinecraftForge.EVENT_BUS.register(ClientHandler.class);
        YJTileEntityRenderers.registerTileEntityRenderer();
    }

    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void posInit() {
        super.posInit();
    }

    @Override
    public Minecraft getMinecraft() {
        return Minecraft.getInstance();
    }
}
