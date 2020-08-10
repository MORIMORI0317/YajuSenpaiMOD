package net.morimori.yjsnpimod.item;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import red.felnull.otyacraftengine.item.IDetailedInfomationItem;

public class JakenShieldItem extends ShieldItem implements IDetailedInfomationItem {
    public JakenShieldItem(Properties builder) {
        super(builder);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 114514;
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == YJItems.YJ_CORE || super.getIsRepairable(toRepair, repair);
    }
}
