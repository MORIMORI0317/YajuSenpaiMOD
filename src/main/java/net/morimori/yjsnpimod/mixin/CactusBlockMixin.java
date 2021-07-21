package net.morimori.yjsnpimod.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.morimori.yjsnpimod.block.YJBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;

@Mixin(CactusBlock.class)
public class CactusBlockMixin {
    @Inject(method = "canSurvive", at = @At("RETURN"), cancellable = true)
    private void canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValue()) {
            Iterator<Direction> var4 = Direction.Plane.HORIZONTAL.iterator();

            Direction direction;
            Material material;
            do {
                if (!var4.hasNext()) {
                    BlockState blockState3 = levelReader.getBlockState(blockPos.below());
                    cir.setReturnValue(blockState3.is(YJBlocks.YJ_SAND) && !levelReader.getBlockState(blockPos.above()).getMaterial().isLiquid());
                    return;
                }

                direction = var4.next();
                BlockState blockState2 = levelReader.getBlockState(blockPos.relative(direction));
                material = blockState2.getMaterial();
            } while (!material.isSolid() && !levelReader.getFluidState(blockPos.relative(direction)).is(FluidTags.LAVA));
        }
    }
}
