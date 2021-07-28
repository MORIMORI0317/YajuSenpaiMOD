package net.morimori.yjsnpimod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.morimori.yjsnpimod.registry.YJSoundEvents;

public class YJSoundType extends SoundType {
    public static final SoundType YJ = new YJSoundType(1.2f, YJSoundEvents.YJ_BREAK, YJSoundEvents.YJ_STEP, YJSoundEvents.YJ_PLACE, YJSoundEvents.YJ_HIT, YJSoundEvents.YJ_FALL);
    public static final SoundType TON = new YJSoundType(1.2f, YJSoundEvents.TON_BREAK, YJSoundEvents.TON_STEP, YJSoundEvents.TON_PLACE, YJSoundEvents.TON_HIT, YJSoundEvents.TON_FALL);
    public static final SoundType KMR = new YJSoundType(1.2f, YJSoundEvents.KMR_BREAK, YJSoundEvents.KMR_STEP, YJSoundEvents.KMR_PLACE, YJSoundEvents.KMR_HIT, YJSoundEvents.KMR_FALL);
    public static final SoundType MUR = new YJSoundType(1.2f, YJSoundEvents.MUR_BREAK, YJSoundEvents.MUR_STEP, YJSoundEvents.MUR_PLACE, YJSoundEvents.MUR_HIT, YJSoundEvents.MUR_FALL);
    public static final SoundType MEZIKARA = new YJSoundType(10f, YJSoundEvents.MEZIKARA_HONTAI, YJSoundEvents.MEZIKARA_NS, YJSoundEvents.MEZIKARA_MAEBURI, YJSoundEvents.MEZIKARA_NS, YJSoundEvents.MEZIKARA_MAEBURI);
    public static final SoundType YJ_SAND = new SoundType(1.0F, 1.0F, SoundEvents.SAND_BREAK, YJSoundEvents.YJ_STEP, SoundEvents.SAND_PLACE, SoundEvents.SAND_HIT, YJSoundEvents.YJ_FALL);

    private final SoundType normal;
    private final SoundType highPitch;
    private final SoundType lowPitch;

    public YJSoundType(float volume, SoundEvent soundEvent, SoundEvent soundEvent2, SoundEvent soundEvent3, SoundEvent soundEvent4, SoundEvent soundEvent5) {
        super(volume, 1.2f, soundEvent, soundEvent2, soundEvent3, soundEvent4, soundEvent5);
        this.normal = new SoundType(volume, 1f, soundEvent, soundEvent2, soundEvent3, soundEvent4, soundEvent5);
        this.highPitch = new SoundType(volume, 2f, soundEvent, soundEvent2, soundEvent3, soundEvent4, soundEvent5);
        this.lowPitch = new SoundType(volume, 1f / 0.75f, soundEvent, soundEvent2, soundEvent3, soundEvent4, soundEvent5);
    }

    public SoundType getNormalSound() {
        return normal;
    }

    public SoundType getHighPitchSound() {
        return highPitch;
    }

    public SoundType getLowPitchSound() {
        return lowPitch;
    }
}
