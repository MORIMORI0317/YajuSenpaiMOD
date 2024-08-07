package net.morimori0317.yajusenpai.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class YJPortalBlockEntity extends BlockEntity {
    public YJPortalBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(YJBlockEntityTypes.YJ_PORTAL.get(), blockPos, blockState);
    }

    public boolean shouldRenderFace(Direction direction) {
        return direction.getAxis() == Direction.Axis.Y;
    }
}