package net.morimori0317.yajusenpai.block;

public class YJSoundTypeFlags {
    public static final ThreadLocal<Boolean> PLAY_BREAK_FLAG = ThreadLocal.withInitial(() -> false);
    public static final ThreadLocal<Boolean> PLAY_STEP_FLAG = ThreadLocal.withInitial(() -> false);
    public static final ThreadLocal<Boolean> PLAY_STEP_0_8_FLAG = ThreadLocal.withInitial(() -> false);
    public static final ThreadLocal<Boolean> PLAY_PLACE_FLAG = ThreadLocal.withInitial(() -> false);
    public static final ThreadLocal<Boolean> PLAY_HIT_FLAG = ThreadLocal.withInitial(() -> false);
    public static final ThreadLocal<Boolean> PLAY_FALL_FLAG = ThreadLocal.withInitial(() -> false);
}
