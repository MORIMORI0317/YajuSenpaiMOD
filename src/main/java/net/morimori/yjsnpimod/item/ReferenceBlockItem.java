package net.morimori.yjsnpimod.item;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.morimori.yjsnpimod.data.ReferenceGetter;
import red.felnull.otyacraftengine.item.IDetailedInfomationItem;

public class ReferenceBlockItem extends BlockItem implements IDetailedInfomationItem {
    private final String url;

    public ReferenceBlockItem(Block blockIn, Properties builder, String url) {
        super(blockIn, builder);
        this.url = url;
    }

    @Override
    public void addDetailedInformation(ItemTooltipEvent e) {
        e.getToolTip().add(ReferenceGetter.getReference(url).func_240699_a_(TextFormatting.DARK_AQUA));
    }
}
