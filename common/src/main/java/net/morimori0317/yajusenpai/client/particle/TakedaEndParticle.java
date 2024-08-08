package net.morimori0317.yajusenpai.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TakedaEndParticle extends TextureSheetParticle {

    protected TakedaEndParticle(ClientLevel clientLevel, double x, double y, double z, SpriteSet spriteSet) {
        super(clientLevel, x, y, z);
        this.pickSprite(spriteSet);
        this.gravity = 0.0F;
        this.lifetime = 20 * 9;
        this.hasPhysics = false;
        this.alpha = 1;
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();

        if (age >= lifetime - 20) {
            this.alpha = (float) (lifetime - age) / 20f;
        } else {
            this.alpha = 1;
        }
    }

    @Override
    public float getQuadSize(float f) {
        return 0.3f;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType particleOptions, ClientLevel clientLevel, double x, double y, double z, double g, double h, double i) {
            return new TakedaEndParticle(clientLevel, x, y, z, sprites);
        }
    }
}
