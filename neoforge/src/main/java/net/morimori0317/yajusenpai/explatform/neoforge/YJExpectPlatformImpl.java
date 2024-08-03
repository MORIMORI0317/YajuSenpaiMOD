package net.morimori0317.yajusenpai.explatform.neoforge;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;

public class YJExpectPlatformImpl {
    public static boolean isElytraItem(ItemStack stack) {
        return stack.getItem() instanceof ElytraItem;
    }


    public static boolean isFood(ItemStack stack, LivingEntity livingEntity) {
        return stack.getFoodProperties(livingEntity) != null;
    }

    public static boolean isAtuiBlock(Level level, BlockPos blockPos, BlockState state) {
        FluidState fluidState = state.getFluidState();

        for (Direction dir : Direction.values()) {
            IFluidHandler fluidHandler = level.getCapability(Capabilities.FluidHandler.BLOCK, blockPos, dir);

            if (fluidHandler == null) {
                continue;
            }

            int fluidTanks = fluidHandler.getTanks();
            for (int i = 0; i < fluidTanks; i++) {
                FluidStack stack = fluidHandler.getFluidInTank(i);

                if (stack.isEmpty()) {
                    continue;
                }

                if (stack.is(FluidTags.LAVA) || stack.is(Tags.Fluids.LAVA) ||
                        stack.getFluidType().getTemperature(stack) >= 1300) {
                    return true;
                }
            }
        }


        return fluidState.is(Tags.Fluids.LAVA);
    }

    public static boolean isOboreruBlock(Level level, BlockPos blockPos, BlockState state) {
        return state.getFluidState().is(Tags.Fluids.WATER);
    }
}
