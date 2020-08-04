package net.morimori.yjsnpimod;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.morimori.yjsnpimod.proxy.ClientProxy;
import net.morimori.yjsnpimod.proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(YJSNPIMOD.MODID)
public class YJSNPIMOD {
    public static final String MODID = "yjsnpimod";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final CommonProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new CommonProxy());

    public YJSNPIMOD() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    }

    private void setup(final FMLCommonSetupEvent event) {
        proxy.preInit();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ClientProxy.clientInit();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        proxy.init();
    }

    private void processIMC(final InterModProcessEvent event) {
        proxy.posInit();
    }
}
