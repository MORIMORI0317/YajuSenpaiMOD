package net.morimori0317.yajusenpai.entity;

import com.google.common.collect.Streams;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.sound.YJSoundEvents;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InariOtokoEater {
    private int cooldown;
    private boolean eat;

    public void tick(ServerPlayer serverPlayer) {
        if (eat) {
            ItemStack stack = getEatenFood(serverPlayer);

            if (stack != null && !stack.isEmpty()) {
                stack.shrink(1);
                serverPlayer.level().playSound(null, serverPlayer, YJSoundEvents.SECOND_INARI_OTOKO_EAT.get(), SoundSource.PLAYERS, 1f, 1f);
                cooldown = 20 * 3 + serverPlayer.getRandom().nextInt(20 * 2);
            }

            eat = false;
        }

        if (cooldown > 0) {
            cooldown--;
        }
    }

    public void eat() {
        if (cooldown <= 0) {
            eat = true;
        }
    }

    private ItemStack getEatenFood(ServerPlayer player) {
        Stream<ItemStack> invItems = player.getInventory().items.stream();
        Stream<ItemStack> eqItems = Arrays.stream(EquipmentSlot.values())
                .map(player::getItemBySlot);

        List<ItemStack> foods = Streams.concat(invItems, eqItems)
                .filter(it -> YJUtils.isFood(it, player))
                .toList();

        if (foods.isEmpty()) {
            return null;
        }

        return foods.get(player.getRandom().nextInt(foods.size()));
    }
}
