package net.morimori0317.yajusenpai.sound;

import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public record InmFamilySound(@NotNull Supplier<SoundEvent> blockBreak,
                             @NotNull Supplier<SoundEvent> blockStep,
                             @NotNull Supplier<SoundEvent> blockPlace,
                             @NotNull Supplier<SoundEvent> blockHit,
                             @NotNull Supplier<SoundEvent> blockFall,
                             @NotNull Supplier<SoundEvent> attack,
                             @NotNull Supplier<SoundEvent> damage,
                             @NotNull Supplier<SoundEvent> die) {
}
