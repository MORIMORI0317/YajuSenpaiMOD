package net.morimori0317.yajusenpai.block;

import com.google.common.base.Suppliers;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.morimori0317.yajusenpai.sound.InmFamilySound;
import net.morimori0317.yajusenpai.sound.InmFamilySounds;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

import java.util.function.Supplier;

public class YJSoundType extends SoundType {
    public static final Supplier<SoundType> YAJUSENPAI = createYJSoundType(1.2f, InmFamilySounds.YAJUSENPAI);
    public static final Supplier<SoundType> TON = createYJSoundType(1.2f, InmFamilySounds.TON);
    public static final Supplier<SoundType> KMR = createYJSoundType(1.2f, InmFamilySounds.KMR);
    public static final Supplier<SoundType> MUR = createYJSoundType(1.2f, InmFamilySounds.MUR);
    public static final Supplier<SoundType> MEDIKARA = createYJSoundType(10f, InmFamilySounds.YAJUSENPAI_MEDIKARA);
    public static final Supplier<SoundType> NKTIDKSG = createYJSoundType(1.2f, InmFamilySounds.NKTIDKSG);
    public static final Supplier<SoundType> TAKEDA_INM = createYJSoundType(1.2f, InmFamilySounds.TAKEDA_INM);
    public static final Supplier<SoundType> KATYOU = createYJSoundType(1.2f, InmFamilySounds.KATYOU);
    public static final Supplier<SoundType> SECOND_INARI_OTOKO = createYJSoundType(1.2f, InmFamilySounds.SECOND_INARI_OTOKO);
    public static final Supplier<SoundType> AKYS = createYJSoundType(1.2f, InmFamilySounds.AKYS);
    public static final Supplier<SoundType> GO = createYJSoundType(1.3f, InmFamilySounds.GO);
    public static final Supplier<SoundType> HIDE = createYJSoundType(1.2f, InmFamilySounds.HIDE);

    public static final Supplier<SoundType> YJ_STONE = createSoundType(1.0F, 1.0F, () -> SoundEvents.STONE_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.STONE_PLACE, () -> SoundEvents.STONE_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_GRAVEL = createSoundType(1.0F, 1.0F, () -> SoundEvents.GRAVEL_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.GRAVEL_PLACE, () -> SoundEvents.GRAVEL_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_SAND = createSoundType(1.0F, 1.0F, () -> SoundEvents.SAND_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.SAND_PLACE, () -> SoundEvents.SAND_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_GRASS = createSoundType(1.0F, 1.0F, () -> SoundEvents.GRASS_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.GRASS_PLACE, () -> SoundEvents.GRASS_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_WOOD = createSoundType(1.0F, 1.0F, () -> SoundEvents.WOOD_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.WOOD_PLACE, () -> SoundEvents.WOOD_HIT, YJSoundEvents.YJ_FALL);
    public static final Supplier<SoundType> YJ_CROP = createSoundType(1.0F, 1.0F, () -> SoundEvents.CROP_BREAK, YJSoundEvents.YJ_STEP, () -> SoundEvents.CROP_PLANTED, () -> SoundEvents.CROP_BREAK, YJSoundEvents.YJ_FALL);

    private static Supplier<SoundType> createSoundType(float volume, float pitch, Supplier<SoundEvent> breakSound, Supplier<SoundEvent> stepSound, Supplier<SoundEvent> placeSound, Supplier<SoundEvent> hitSound, Supplier<SoundEvent> fallSound) {
        return Suppliers.memoize(() -> new SoundType(volume, pitch, breakSound.get(), stepSound.get(), placeSound.get(), hitSound.get(), fallSound.get()));
    }

    private static Supplier<SoundType> createYJSoundType(float volume, InmFamilySound inmFamilySound) {
        return Suppliers.memoize(() -> new YJSoundType(volume, inmFamilySound));
    }

    private YJSoundType(float volume, InmFamilySound inmFamilySound) {
        super(volume, 1.2f,
                inmFamilySound.blockBreak().get(),
                inmFamilySound.blockStep().get(),
                inmFamilySound.blockPlace().get(),
                inmFamilySound.blockHit().get(),
                inmFamilySound.blockFall().get());
    }
}
