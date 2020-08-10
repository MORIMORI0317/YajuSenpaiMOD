package net.morimori.yjsnpimod.item;

import net.minecraft.item.Item;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.morimori.yjsnpimod.data.ReferenceGetter;
import red.felnull.otyacraftengine.item.IDetailedInfomationItem;

public class SoftSwordItem extends Item implements IDetailedInfomationItem {
    public SoftSwordItem(Properties properties) {
        super(properties);
    }

    @Override
    public void addDetailedInformation(ItemTooltipEvent e) {
        e.getToolTip().add(ReferenceGetter.getReference("https://www.nicovideo.jp/watch/sm18842224").func_240699_a_(TextFormatting.DARK_AQUA));
    }
}
