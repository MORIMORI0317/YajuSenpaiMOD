package net.morimori0317.yajusenpai.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YJSoundType extends SoundType {
    public static final SoundType YJ = new YJSoundType(1.2f, YJSoundEvents.YJ_BREAK.get(), YJSoundEvents.YJ_STEP.get(), YJSoundEvents.YJ_PLACE.get(), YJSoundEvents.YJ_HIT.get(), YJSoundEvents.YJ_FALL.get());
    public static final SoundType TON = new YJSoundType(1.2f, YJSoundEvents.TON_BREAK.get(), YJSoundEvents.TON_STEP.get(), YJSoundEvents.TON_PLACE.get(), YJSoundEvents.TON_HIT.get(), YJSoundEvents.TON_FALL.get());
    public static final SoundType KMR = new YJSoundType(1.2f, YJSoundEvents.KMR_BREAK.get(), YJSoundEvents.KMR_STEP.get(), YJSoundEvents.KMR_PLACE.get(), YJSoundEvents.KMR_HIT.get(), YJSoundEvents.KMR_FALL.get());
    public static final SoundType MUR = new YJSoundType(1.2f, YJSoundEvents.MUR_BREAK.get(), YJSoundEvents.MUR_STEP.get(), YJSoundEvents.MUR_PLACE.get(), YJSoundEvents.MUR_HIT.get(), YJSoundEvents.MUR_FALL.get());
    public static final SoundType MEZIKARA = new YJSoundType(10f, YJSoundEvents.MEZIKARA_HONTAI.get(), YJSoundEvents.MEZIKARA_NS.get(), YJSoundEvents.MEZIKARA_MAEBURI.get(), YJSoundEvents.MEZIKARA_NS.get(), YJSoundEvents.MEZIKARA_MAEBURI.get());
    public static final SoundType YJ_STONE = new SoundType(1.0F, 1.0F, SoundEvents.STONE_BREAK, YJSoundEvents.YJ_STEP.get(), SoundEvents.STONE_PLACE, SoundEvents.STONE_HIT, YJSoundEvents.YJ_FALL.get());
    public static final SoundType YJ_GRAVEL = new SoundType(1.0F, 1.0F, SoundEvents.GRAVEL_BREAK, YJSoundEvents.YJ_STEP.get(), SoundEvents.GRAVEL_PLACE, SoundEvents.GRAVEL_HIT, YJSoundEvents.YJ_FALL.get());
    public static final SoundType YJ_SAND = new SoundType(1.0F, 1.0F, SoundEvents.SAND_BREAK, YJSoundEvents.YJ_STEP.get(), SoundEvents.SAND_PLACE, SoundEvents.SAND_HIT, YJSoundEvents.YJ_FALL.get());
    public static final SoundType YJ_GRASS = new SoundType(1.0F, 1.0F, SoundEvents.GRASS_BREAK, YJSoundEvents.YJ_STEP.get(), SoundEvents.GRASS_PLACE, SoundEvents.GRASS_HIT, YJSoundEvents.YJ_FALL.get());
    public static final SoundType YJ_WOOD = new SoundType(1.0F, 1.0F, SoundEvents.WOOD_BREAK, YJSoundEvents.YJ_STEP.get(), SoundEvents.WOOD_PLACE, SoundEvents.WOOD_HIT, YJSoundEvents.YJ_FALL.get());

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