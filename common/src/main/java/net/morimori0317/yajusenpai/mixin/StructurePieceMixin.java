package net.morimori0317.yajusenpai.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.material.FluidState;
import net.morimori0317.yajusenpai.server.world.features.StructurePieceReplace;
import net.morimori0317.yajusenpai.util.YJUtils;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Set;

@Mixin(StructurePiece.class)
public abstract class StructurePieceMixin {
    @Shadow
    @Final
    private static Set<Block> SHAPE_CHECK_BLOCKS;

    @Shadow
    public abstract StructurePieceType getType();

    @Inject(method = "placeBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/WorldGenLevel;setBlock(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z", ordinal = 0), locals = LocalCapture.CAPTURE_FAILSOFT, cancellable = true)
    private void placeBlock(WorldGenLevel worldGenLevel, BlockState blockState, int i, int j, int k, BoundingBox boundingBox, CallbackInfo ci, BlockPos blockPos) {
        if (YJUtils.isYJDim(worldGenLevel.getLevel())) {
            BlockState ns = null;
            var rep = StructurePieceReplace.REPLACES.get();
            var r = rep.get(blockState.getBlock());
            if (r != null)
                ns = r.defaultBlockState();

            if (ns == null) {
                var frep = StructurePieceReplace.FUNC_REPLACES.get();
                var fr = frep.get(blockState.getBlock());
                if (fr != null)
                    ns = fr.apply(blockState);
            }

            if (ns != null) {
                ci.cancel();
                worldGenLevel.setBlock(blockPos, ns, 2);
                FluidState fluidState = worldGenLevel.getFluidState(blockPos);
                if (!fluidState.isEmpty())
                    worldGenLevel.scheduleTick(blockPos, fluidState.getType(), 0);

                if (SHAPE_CHECK_BLOCKS.contains(ns.getBlock()))
                    worldGenLevel.getChunk(blockPos).markPosForPostprocessing(blockPos);
            }
        }
    }
}
