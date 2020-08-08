package net.morimori.yjsnpimod.item;

import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

public class YJItemTags {
    public static final ITag.INamedTag<Item> YJNIUM_INGOT = fgTag("ingots/yjnium");
    public static final ITag.INamedTag<Item> YJSNPI_INGOT = fgTag("ingots/yjsnpi");

    private static ITag.INamedTag<Item> fgTag(String name) {
        return ItemTags.makeWrapperTag("forge:" + name);
    }

}
