package net.morimori0317.yajusenpai.neoforge.client.handler;

import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.client.YajuSenpaiClient;
import net.morimori0317.yajusenpai.client.particle.TakedaEndParticle;
import net.morimori0317.yajusenpai.particles.YJParticleTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = YajuSenpai.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientBusHandlerNeoForge {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent e) {
        NeoForge.EVENT_BUS.register(RenderHandlerNeoForge.class);
        YajuSenpaiClient.init();
    }

    @SubscribeEvent
    public static void onRegisterParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(YJParticleTypes.TAKEDA_END.get(), TakedaEndParticle.Provider::new);
    }

}
