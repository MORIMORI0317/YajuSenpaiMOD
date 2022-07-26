package net.morimori0317.yajusenpai.util;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class YJPlayerUtils {
    public static void giveItem(@NotNull ServerPlayer player, @NotNull ItemStack stack) {
        if (!player.addItem(stack))
            player.drop(stack, false, true);
    }
}
