package net.morimori0317.yajusenpai.explatform.neoforge;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;

public class YJExpectPlatformImpl {
    public static boolean isElytraItem(ItemStack stack) {
        return stack.getItem() instanceof ElytraItem;
    }


    public static boolean isFood(ItemStack stack, LivingEntity livingEntity) {
        return stack.getFoodProperties(livingEntity) != null;
    }
}
