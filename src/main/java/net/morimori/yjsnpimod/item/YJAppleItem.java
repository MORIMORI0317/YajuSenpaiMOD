package net.morimori.yjsnpimod.item;

import net.minecraft.world.item.Item;

public class YJAppleItem extends Item {
    public YJAppleItem(Properties properties) {
        super(properties);
    }

    @Override
    protected String getOrCreateDescriptionId() {

        return "item.minecraft.apple";
    }
}
