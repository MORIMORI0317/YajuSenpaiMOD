package net.morimori0317.yajusenpai.util;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class YJEntityUtils {
    @NotNull
    public static ItemEntity createItemEntity(@NotNull ItemStack item, @NotNull Level level, double x, double y, double z) {
        ItemEntity iteme = new ItemEntity(level, x, y, z, item);
        iteme.setDefaultPickUpDelay();
        return iteme;
    }
}
