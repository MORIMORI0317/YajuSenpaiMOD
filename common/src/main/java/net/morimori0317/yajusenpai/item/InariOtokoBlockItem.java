package net.morimori0317.yajusenpai.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.entity.InariOtokoAccessor;
import net.morimori0317.yajusenpai.entity.InariOtokoEater;

public class InariOtokoBlockItem extends InmBlockItem {
    public InariOtokoBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl) {
        if (entity instanceof ServerPlayer serverPlayer) {
            if (serverPlayer.getRandom().nextInt(((20 * 30) + (int) ((20f * 60f) * (1f - (float) itemStack.getCount() / (float) itemStack.getMaxStackSize()) * 3f))) == 0) {
                InariOtokoEater inariOtokoEater = ((InariOtokoAccessor) serverPlayer).yajuSenpai$getInariOtokoEater();
                inariOtokoEater.eat();
            }
        }
    }
}
