package net.morimori0317.yajusenpai.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.chunk.LevelChunk;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class YJPlayerUtils {
    public static void giveItem(@NotNull ServerPlayer player, @NotNull ItemStack stack) {
        if (!player.addItem(stack))
            player.drop(stack, false, true);
    }

    public static void doPlayers(@NotNull LevelReader level, @NotNull BlockPos pos, @NotNull Consumer<ServerPlayer> playerConsumer) {
        LevelChunk lch = (LevelChunk) level.getChunk(pos);
        doPlayers(lch, playerConsumer);
    }

    public static void doPlayers(@NotNull LevelChunk chunk, @NotNull Consumer<ServerPlayer> playerConsumer) {
        ((ServerChunkCache) chunk.getLevel().getChunkSource()).chunkMap.getPlayers(chunk.getPos(), false).forEach(playerConsumer);
    }
}
