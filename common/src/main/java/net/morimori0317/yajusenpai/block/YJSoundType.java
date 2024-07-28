package net.morimori0317.yajusenpai.block;

import com.google.common.base.Suppliers;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

import java.util.function.Supplier;

public class YJSoundType extends SoundType {
    public static final Supplier<SoundType> YJ = createYJSoundType(1.2f, YJSoundEvents.YJ_BREAK, YJSoundEvents.YJ_STEP, YJSoundEvents.YJ_PLACE, YJSoundEvents.YJ_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> TON = createYJSoundType(1.2f, YJSoundEvents.TON_BREAK, YJSoundEvents.TON_STEP, YJSoundEvents.TON_PLACE, YJSoundEvents.TON_HIT, YJSoundEvents.TON_FALL);
    public static final Supplier<SoundType> KMR = createYJSoundType(1.2f, YJSoundEvents.KMR_BREAK, YJSoundEvents.KMR_STEP, YJSoundEvents.KMR_PLACE, YJSoundEvents.KMR_HIT, YJSoundEvents.KMR_FALL);
    public static final Supplier<SoundType> MUR = createYJSoundType(1.2f, YJSoundEvents.MUR_BREAK, YJSoundEvents.MUR_STEP, YJSoundEvents.MUR_PLACE, YJSoundEvents.MUR_HIT, YJSoundEvents.MUR_FALL);
    public static final Supplier<SoundType> MEDIKARA = createYJSoundType(10f, YJSoundEvents.MEDIKARA_HONTAI, YJSoundEvents.MEDIKARA_NS, YJSoundEvents.MEDIKARA_MAEBURI, YJSoundEvents.MEDIKARA_NS, YJSoundEvents.MEDIKARA_MAEBURI);
    public static final Supplier<SoundType> NKTIDKSG = createYJSoundType(10f, YJSoundEvents.NKTIDKSG_BREAK, YJSoundEvents.NKTIDKSG_STEP, YJSoundEvents.NKTIDKSG_PLACE, YJSoundEvents.NKTIDKSG_HIT, YJSoundEvents.NKTIDKSG_FALL);
    public static final Supplier<SoundType> TAKEDA_INM = createYJSoundType(10f, YJSoundEvents.TAKEDA_INM_BREAK, YJSoundEvents.TAKEDA_INM_STEP, YJSoundEvents.TAKEDA_INM_PLACE, YJSoundEvents.TAKEDA_INM_HIT, YJSoundEvents.TAKEDA_INM_FALL);
    public static final Supplier<SoundType> KATYOU = createYJSoundType(10f, YJSoundEvents.KATYOU_BREAK, YJSoundEvents.KATYOU_STEP, YJSoundEvents.KATYOU_PLACE, YJSoundEvents.KATYOU_HIT, YJSoundEvents.KATYOU_FALL);
    public static final Supplier<SoundType> INARI_OTOKO = createYJSoundType(10f, YJSoundEvents.INARI_OTOKO_BREAK, YJSoundEvents.INARI_OTOKO_STEP, YJSoundEvents.INARI_OTOKO_PLACE, YJSoundEvents.INARI_OTOKO_HIT, YJSoundEvents.INARI_OTOKO_FALL);

    public static final Supplier<SoundType> YJ_STONE = createSoundType(1.0F, 1.0F, () -> SoundEvents.STONE_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.STONE_PLACE, () -> SoundEvents.STONE_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_GRAVEL = createSoundType(1.0F, 1.0F, () -> SoundEvents.GRAVEL_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.GRAVEL_PLACE, () -> SoundEvents.GRAVEL_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_SAND = createSoundType(1.0F, 1.0F, () -> SoundEvents.SAND_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.SAND_PLACE, () -> SoundEvents.SAND_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_GRASS = createSoundType(1.0F, 1.0F, () -> SoundEvents.GRASS_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.GRASS_PLACE, () -> SoundEvents.GRASS_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_WOOD = createSoundType(1.0F, 1.0F, () -> SoundEvents.WOOD_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.WOOD_PLACE, () -> SoundEvents.WOOD_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_CROP = createSoundType(1.0F, 1.0F, () -> SoundEvents.CROP_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.CROP_PLANTED, () -> SoundEvents.CROP_BREAK, YJSoundEvents.YJ_FALL);

    private static Supplier<SoundType> createSoundType(float volume, float pitch, Supplier<SoundEvent> breakSound, Supplier<SoundEvent> stepSound, Supplier<SoundEvent> placeSound, Supplier<SoundEvent> hitSound, Supplier<SoundEvent> fallSound) {
        return Suppliers.memoize(() -> new SoundType(volume, pitch, breakSound.get(), stepSound.get(), placeSound.get(), hitSound.get(), fallSound.get()));
    }

    private static Supplier<SoundType> createYJSoundType(float volume, Supplier<SoundEvent> breakSound, Supplier<SoundEvent> stepSound, Supplier<SoundEvent> placeSound, Supplier<SoundEvent> hitSound, Supplier<SoundEvent> fallSound) {
        return Suppliers.memoize(() -> new YJSoundType(volume, breakSound.get(), stepSound.get(), placeSound.get(), hitSound.get(), fallSound.get()));
    }

    private final SoundType normal;
    private final SoundType highPitch;
    private final SoundType lowPitch;

    public YJSoundType(float volume, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        super(volume, 1.2f, breakSound, stepSound, placeSound, hitSound, fallSound);
        this.normal = new SoundType(volume, 1f, breakSound, stepSound, placeSound, hitSound, fallSound);
        this.highPitch = new SoundType(volume, 2f, breakSound, stepSound, placeSound, hitSound, fallSound);
        this.lowPitch = new SoundType(volume, 1f / 0.75f, breakSound, stepSound, placeSound, hitSound, fallSound);
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
