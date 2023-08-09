package net.morimori0317.yajusenpai.block;

import net.minecraft.world.level.block.DoorBlock;

public class YJHouseDoorBlock extends DoorBlock {
    public YJHouseDoorBlock(Properties properties) {
        super(properties, YJBlockSetType.YJ_HOUSE.get());
    }
}
