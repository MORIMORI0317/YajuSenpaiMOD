package net.morimori0317.yajusenpai.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;

public class JakenShieldItem extends ShieldItem {
    public JakenShieldItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isValidRepairItem(ItemStack itemStack, ItemStack itemStack2) {
        return itemStack2.is(YJItems.YJ_CORE.get());
    }
}
