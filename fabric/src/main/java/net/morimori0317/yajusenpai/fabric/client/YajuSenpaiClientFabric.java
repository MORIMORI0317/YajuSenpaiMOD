package net.morimori0317.yajusenpai.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.morimori0317.yajusenpai.client.YajuSenpaiClient;
import net.morimori0317.yajusenpai.client.particle.TakedaEndParticle;
import net.morimori0317.yajusenpai.particles.YJParticleTypes;

public class YajuSenpaiClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        YajuSenpaiClient.init();

        ParticleFactoryRegistry.getInstance().register(YJParticleTypes.TAKEDA_END.get(), TakedaEndParticle.Provider::new);
    }
}
