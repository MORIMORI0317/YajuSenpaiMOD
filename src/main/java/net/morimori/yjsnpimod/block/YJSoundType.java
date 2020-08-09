package net.morimori.yjsnpimod.block;

import net.minecraft.block.SoundType;
import net.morimori.yjsnpimod.YJSoundEvents;

public class YJSoundType {
    public static final SoundType YJ = new SoundType(3.0F, 1.2F, YJSoundEvents.YJ_BREAK, YJSoundEvents.YJ_STEP, YJSoundEvents.YJ_PLACE, YJSoundEvents.YJ_HIT, YJSoundEvents.YJ_FALL);
    public static final SoundType MEZIKARA = new SoundType(3.0F, 1.2F, YJSoundEvents.MEZIKARA_HONTAI, YJSoundEvents.MEZIKARA_NS, YJSoundEvents.MEZIKARA_MAEBURI, YJSoundEvents.MEZIKARA_NS, YJSoundEvents.MEZIKARA_MAEBURI);
}
