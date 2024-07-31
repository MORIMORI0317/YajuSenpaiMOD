package net.morimori0317.yajusenpai.explatform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class YJExpectPlatform {
    @ExpectPlatform
    public static boolean isElytraItem(ItemStack stack) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static boolean isFood(ItemStack stack, LivingEntity livingEntity) {
        throw new AssertionError();
    }
}
