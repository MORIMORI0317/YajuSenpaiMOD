package net.morimori.yjsnpimod.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.morimori.yjsnpimod.registry.YJSoundEvents;

public class YJSoundType {
    public static final SoundType YJ = new SoundType(3.0F, 1.2F, YJSoundEvents.YJ_BREAK, YJSoundEvents.YJ_STEP, YJSoundEvents.YJ_PLACE, YJSoundEvents.YJ_HIT, YJSoundEvents.YJ_FALL);
    public static final SoundType MEZIKARA = new SoundType(3.0F, 1.2F, YJSoundEvents.MEZIKARA_HONTAI, YJSoundEvents.MEZIKARA_NS, YJSoundEvents.MEZIKARA_MAEBURI, YJSoundEvents.MEZIKARA_NS, YJSoundEvents.MEZIKARA_MAEBURI);
    public static final SoundType YJ_SAND = new SoundType(1.0F, 1.0F, SoundEvents.SAND_BREAK, YJSoundEvents.YJ_STEP, SoundEvents.SAND_PLACE, SoundEvents.SAND_HIT, YJSoundEvents.YJ_FALL);
}
