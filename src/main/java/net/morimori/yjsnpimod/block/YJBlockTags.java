package net.morimori.yjsnpimod.block;

import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJBlockTags {
    public static final ITag.INamedTag<Block> PROLIFERATION = yjTag("proliferation");
    public static final ITag.INamedTag<Block> ANTI_PROLIFERATION = yjTag("anti_proliferation");

    private static ITag.INamedTag<Block> yjTag(String name) {
        return BlockTags.makeWrapperTag(YJSNPIMOD.MODID + ":" + name);
    }
}
