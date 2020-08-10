package net.morimori.yjsnpimod.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.morimori.yjsnpimod.data.ReferenceGetter;
import red.felnull.otyacraftengine.item.IDetailedInfomationItem;

public class CyclopsSunglassesItem extends ArmorItem implements IDetailedInfomationItem {
    public CyclopsSunglassesItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties p_i48534_3_) {
        super(materialIn, slot, p_i48534_3_);
    }

    @Override
    public void addDetailedInformation(ItemTooltipEvent e) {
        e.getToolTip().add(ReferenceGetter.getReference("https://www.nicovideo.jp/watch/sm25377226").func_240699_a_(TextFormatting.DARK_AQUA));
    }
}
