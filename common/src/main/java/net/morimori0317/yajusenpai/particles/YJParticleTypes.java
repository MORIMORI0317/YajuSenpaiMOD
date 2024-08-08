package net.morimori0317.yajusenpai.particles;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.explatform.YJExpectPlatform;

import java.util.function.Supplier;

public class YJParticleTypes {
    private static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(YajuSenpai.MODID, Registries.PARTICLE_TYPE);
    public static final RegistrySupplier<SimpleParticleType> TAKEDA_END = register("takeda_end", () -> YJExpectPlatform.createSimpleParticleType(true));

    private static RegistrySupplier<SimpleParticleType> register(String name, Supplier<SimpleParticleType> particleTypeSupplier) {
        return PARTICLE_TYPES.register(name, particleTypeSupplier);
    }

    public static void init() {
        PARTICLE_TYPES.register();
    }
}
