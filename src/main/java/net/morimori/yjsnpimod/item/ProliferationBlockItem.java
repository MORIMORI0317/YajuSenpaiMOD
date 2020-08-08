package net.morimori.yjsnpimod.item;

import net.minecraft.block.Block;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.morimori.yjsnpimod.block.YJBlocks;
import red.felnull.otyacraftengine.item.IDetailedInfomationItem;

public class ProliferationBlockItem extends SimpleFoiledBlockItem implements IDetailedInfomationItem {
    public ProliferationBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void addDetailedInformation(ItemTooltipEvent e) {
        TextFormatting coloer = TextFormatting.GOLD;
        if (this.getBlock() == YJBlocks.IKISUGI_PROLIFERATION_YJSNPI_BLOCK) {
            coloer = TextFormatting.RED;
        } else if (this.getBlock() == YJBlocks.GOMANETSU_PROLIFERATION_YJSNPI_BLOCK) {
            coloer = TextFormatting.BLUE;
        } else if (this.getBlock() == YJBlocks.ANTI_PROLIFERATION_YJSNPI_BLOCK) {
            coloer = TextFormatting.DARK_PURPLE;
        }
        e.getToolTip().add((new TranslationTextComponent("tooltip.detailedinformation." + e.getItemStack().getItem().getTranslationKey())).func_240699_a_(coloer));
    }
}
