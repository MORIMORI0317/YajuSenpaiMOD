package net.morimori0317.yajusenpai.block;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

import java.util.concurrent.atomic.AtomicInteger;

public class YJFallingBlock extends ColoredFallingBlock {
    public static final RegistrySupplier<SoundEvent>[] BUTIPPA_SOUNDS = new RegistrySupplier[]{
            YJSoundEvents.YJ_BU,
            YJSoundEvents.YJ_TI,
            YJSoundEvents.YJ_PA
    };

    private final AtomicInteger buttippaCounter = new AtomicInteger();

    public YJFallingBlock(ColorRGBA colorRGBA, Properties properties) {
        super(colorRGBA, properties);
    }

    public void buttippa(FallingBlockEntity fallingBlockEntity) {
        SoundEvent soundEvent = BUTIPPA_SOUNDS[buttippaCounter.getAndIncrement() % BUTIPPA_SOUNDS.length].get();

        fallingBlockEntity.level()
                .playSound(null, fallingBlockEntity.getX(), fallingBlockEntity.getY(), fallingBlockEntity.getZ(),
                        soundEvent, SoundSource.BLOCKS, 1, 1);
    }
}