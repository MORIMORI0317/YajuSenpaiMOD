package net.morimori0317.yajusenpai.block;

import dev.architectury.hooks.fluid.FluidStackHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.morimori0317.yajusenpai.explatform.YJExpectPlatform;
import net.morimori0317.yajusenpai.sound.InmFamilySound;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;

public class HideBlock extends InmBlock {
    public HideBlock(InmFamilySound inmFamilySound, Properties properties) {
        super(inmFamilySound, properties);
    }

    @Override
    protected void neighborChanged(BlockState blockState, Level level, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl) {
        if (!level.isClientSide) {
            if (isAtuiBlock(level, blockPos2, level.getBlockState(blockPos2))) {
                level.playSound(null, blockPos, YJSoundEvents.HIDE_FIRE.get(), SoundSource.BLOCKS, 5, 1);
            } else if (isOboreruBlock(level, blockPos2, level.getBlockState(blockPos2))) {
                level.playSound(null, blockPos, YJSoundEvents.HIDE_WATER.get(), SoundSource.BLOCKS, 5, 1);
            }
        }
    }

    private boolean isAtuiBlock(Level level, BlockPos blockPos, BlockState state) {
        if (state.getBlock() instanceof AbstractFurnaceBlock &&
                state.getOptionalValue(AbstractFurnaceBlock.LIT).orElse(false)) {
            return true;
        }

        if (state.getBlock() instanceof CampfireBlock &&
                state.getOptionalValue(CampfireBlock.LIT).orElse(false)) {
            return true;
        }

        FluidState fluidState = state.getFluidState();
        if (!fluidState.isEmpty() &&
                (fluidState.is(FluidTags.LAVA) || FluidStackHooks.getTemperature(fluidState.getType(), level, blockPos) >= 1300)) {
            return true;
        }

        return state.is(BlockTags.FIRE) ||
                state.is(Blocks.MAGMA_BLOCK) ||
                state.is(Blocks.LAVA_CAULDRON) ||
                YJExpectPlatform.isAtuiBlock(level, blockPos, state);
    }

    private boolean isOboreruBlock(Level level, BlockPos blockPos, BlockState state) {

        if (YJExpectPlatform.isOboreruBlock(level, blockPos, state)) {
            return true;
        }

        FluidState fluidState = state.getFluidState();
        return !fluidState.isEmpty() &&
                (fluidState.is(FluidTags.WATER) ||
                        (FluidStackHooks.getTemperature(fluidState.getType(), level, blockPos) <= 300 && FluidStackHooks.getViscosity(fluidState.getType(), level, blockPos) <= 1000));
    }
}
