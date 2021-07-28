package net.morimori.yjsnpimod.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.material.FluidState;
import net.morimori.yjsnpimod.registry.StructureReplace;
import net.morimori.yjsnpimod.util.YJUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mixin(StructurePiece.class)
public abstract class StructurePieceMixin {
    @Shadow
    protected abstract BlockPos.MutableBlockPos getWorldPos(int i, int j, int k);

    @Shadow
    protected abstract boolean canBeReplaced(LevelReader levelReader, int i, int j, int k, BoundingBox boundingBox);

    @Shadow
    private Mirror mirror;

    @Shadow
    private Rotation rotation;

    @Shadow
    @Final
    private static Set<Block> SHAPE_CHECK_BLOCKS;

    @Shadow
    public abstract StructurePieceType getType();

    @Inject(method = "placeBlock", at = @At("HEAD"), cancellable = true)
    private void placeBlock(WorldGenLevel worldGenLevel, BlockState blockState, int i, int j, int k, BoundingBox boundingBox, CallbackInfo ci) {
        boolean flg = false;
        if (YJUtils.isYJDim(worldGenLevel.getLevel())) {

            List<StructurePieceType> MONUMENTS = new ArrayList<>();
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_BUILDING);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_CORE_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_DOUBLE_X_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_DOUBLE_XY_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_DOUBLE_Y_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_DOUBLE_YZ_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_DOUBLE_Z_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_ENTRY_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_PENTHOUSE);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_SIMPLE_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_SIMPLE_TOP_ROOM);
            MONUMENTS.add(StructurePieceType.OCEAN_MONUMENT_WING_ROOM);

            if (getType() == StructurePieceType.DESERT_PYRAMID_PIECE && StructureReplace.DESERTPYRAMID.containsKey(blockState.getBlock())) {
                blockState = StructureReplace.DESERTPYRAMID.get(blockState.getBlock()).defaultBlockState();
                flg = true;
            } else if (MONUMENTS.contains(getType()) && StructureReplace.MONUMENT.containsKey(blockState.getBlock())) {
                blockState = StructureReplace.MONUMENT.get(blockState.getBlock()).defaultBlockState();
                flg = true;
            }
        }

        if (flg) {
            ci.cancel();
            BlockPos blockPos = this.getWorldPos(i, j, k);
            if (boundingBox.isInside(blockPos)) {
                if (this.canBeReplaced(worldGenLevel, i, j, k, boundingBox)) {
                    if (this.mirror != Mirror.NONE) {
                        blockState = blockState.mirror(this.mirror);
                    }

                    if (this.rotation != Rotation.NONE) {
                        blockState = blockState.rotate(this.rotation);
                    }

                    worldGenLevel.setBlock(blockPos, blockState, 2);
                    FluidState fluidState = worldGenLevel.getFluidState(blockPos);
                    if (!fluidState.isEmpty()) {
                        worldGenLevel.getLiquidTicks().scheduleTick(blockPos, fluidState.getType(), 0);
                    }

                    if (SHAPE_CHECK_BLOCKS.contains(blockState.getBlock())) {
                        worldGenLevel.getChunk(blockPos).markPosForPostprocessing(blockPos);
                    }

                }
            }
        }
    }
}
