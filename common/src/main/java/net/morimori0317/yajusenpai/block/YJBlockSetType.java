package net.morimori0317.yajusenpai.block;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class YJBlockSetType {
    public static final Supplier<BlockSetType> YJ_HOUSE = Suppliers.memoize(() -> BlockSetType.register(
            new BlockSetType("yj_house", true, true, true,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    SoundType.METAL,
                    YJSoundEvents.YJ_DOOR_CLOSE.get(),
                    YJSoundEvents.YJ_DOOR_OPEN.get(),
                    YJSoundEvents.YJ_DOOR_CLOSE.get(),
                    YJSoundEvents.YJ_DOOR_OPEN.get(),
                    YJSoundEvents.YJ_DOOR_CLOSE.get(),
                    YJSoundEvents.YJ_DOOR_OPEN.get(),
                    YJSoundEvents.YJ_DOOR_CLOSE.get(),
                    YJSoundEvents.YJ_DOOR_OPEN.get())));
}
