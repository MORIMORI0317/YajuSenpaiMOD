package com.morimori.yjsnpimod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.morimori.yjsnpimod.blocks.MODBlocks;
import com.morimori.yjsnpimod.handler.LivingDamageHandler;
import com.morimori.yjsnpimod.handler.LivingDropsHandler;
import com.morimori.yjsnpimod.handler.LivingEntityHandler;
import com.morimori.yjsnpimod.handler.LivingSpawnHandler;
import com.morimori.yjsnpimod.handler.PlaySoundAtEntityHandler;
import com.morimori.yjsnpimod.other.Sounds;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("yjsnpimod")
public class YJSNPImod
{

    public static final Logger LOGGER = LogManager.getLogger();

    public YJSNPImod() {

    	IEventBus BUS =MinecraftForge.EVENT_BUS;
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        BUS.addListener(EventPriority.NORMAL, false, PlaySoundAtEntityEvent.class, new PlaySoundAtEntityHandler()::onPlaySoundAtEntity);

        BUS.addListener(EventPriority.NORMAL, false, LivingDamageEvent.class, new LivingDamageHandler()::onLivingDamage);

        BUS.addListener(EventPriority.HIGH, false, LivingSpawnEvent.CheckSpawn.class, new LivingSpawnHandler()::onLivingSpawn);

        BUS.addListener(EventPriority.NORMAL, false, LivingEvent.class, new LivingEntityHandler()::onLivingEntity);

        BUS.addListener(EventPriority.NORMAL, false, LivingDropsEvent.class, new LivingDropsHandler()::onDrop);


		DistExecutor.runWhenOn(Dist.CLIENT, ()->()-> {

			FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		});

		BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {


    	Sounds.ListRegSound();




        LOGGER.info("YJSNPI-setup");
        LOGGER.info("YJSNPI BLOCK >> {}", MODBlocks.YJ_SNPAI_BLOCK.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        LOGGER.info("YJSNPI-doClientStuff", event.getMinecraftSupplier().get().gameSettings);

    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
    	 LOGGER.info("YJSNPI-enqueueIMC");
    }

    private void processIMC(final InterModProcessEvent event)
    {

   	 LOGGER.info("YJSNPI-processIMC");
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    	 LOGGER.info("YJSNPI-onServerStarting");
  }




}
