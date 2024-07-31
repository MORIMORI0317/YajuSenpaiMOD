package net.morimori0317.yajusenpai.explatform.fabric;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class YJExpectPlatformImpl {
    public static boolean isElytraItem(ItemStack stack) {
        Item item = stack.getItem();
        return item instanceof ElytraItem || item instanceof FabricElytraItem;
    }

    public static boolean isFood(ItemStack stack, LivingEntity livingEntity) {
        return stack.get(DataComponents.FOOD) != null;
    }
}
