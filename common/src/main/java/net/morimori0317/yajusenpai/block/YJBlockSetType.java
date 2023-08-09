package net.morimori0317.yajusenpai.block;

import com.google.common.base.Suppliers;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

import java.util.function.Supplier;

public class YJBlockSetType {
    public static final Supplier<BlockSetType> YJ_HOUSE = Suppliers.memoize(() -> BlockSetType.register(new BlockSetType("yj_house", true, SoundType.METAL, YJSoundEvents.YJ_DOOR_CLOSE.get(), YJSoundEvents.YJ_DOOR_OPEN.get(), YJSoundEvents.YJ_DOOR_CLOSE.get(), YJSoundEvents.YJ_DOOR_OPEN.get(), YJSoundEvents.YJ_DOOR_CLOSE.get(), YJSoundEvents.YJ_DOOR_OPEN.get(), YJSoundEvents.YJ_DOOR_CLOSE.get(), YJSoundEvents.YJ_DOOR_OPEN.get())));
}
