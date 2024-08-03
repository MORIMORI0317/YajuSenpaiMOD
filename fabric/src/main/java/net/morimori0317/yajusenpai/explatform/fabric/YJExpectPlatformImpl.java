package net.morimori0317.yajusenpai.explatform.fabric;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalFluidTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class YJExpectPlatformImpl {
    public static boolean isElytraItem(ItemStack stack) {
        Item item = stack.getItem();
        return item instanceof ElytraItem || item instanceof FabricElytraItem;
    }

    public static boolean isFood(ItemStack stack, LivingEntity livingEntity) {
        return stack.get(DataComponents.FOOD) != null;
    }

    public static boolean isAtuiBlock(Level level, BlockPos blockPos, BlockState state) {
        return state.getFluidState().is(ConventionalFluidTags.LAVA);
    }

    public static boolean isOboreruBlock(Level level, BlockPos blockPos, BlockState state) {
        return state.getFluidState().is(ConventionalFluidTags.WATER);
    }
}
