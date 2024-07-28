package net.morimori0317.yajusenpai.block;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class YJBlockStateProperties {
    public static final IntegerProperty YJ_EX_TIMER = IntegerProperty.create("yj_timer", 0, 146);
    public static final BooleanProperty YJ_EX_STARTED = BooleanProperty.create("yj_start");
    public static final BooleanProperty YJ_EX_FIRE = BooleanProperty.create("yj_fire");
    public static final IntegerProperty YJ_PR_CONT = IntegerProperty.create("yj_cont", 0, 364);
}