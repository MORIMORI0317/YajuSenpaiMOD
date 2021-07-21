package net.morimori.yjsnpimod.block;

import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.SandBlock;
import net.morimori.yjsnpimod.registry.YJSoundEvents;

public class YJSandBlock extends SandBlock {
    public YJSandBlock(Properties properties) {
        super(0x5e3500, properties);
    }

    @Override
    protected void falling(FallingBlockEntity fallingBlockEntity) {
        super.falling(fallingBlockEntity);
        fallingBlockEntity.playSound(YJSoundEvents.YJ_SYU, 1, 1);
    }
}
