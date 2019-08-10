package com.morimori.yjsnpimod.blocks;

import com.morimori.yjsnpimod.items.MODItems;

import net.minecraft.block.PotatoBlock;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class IPotatoBlock extends PotatoBlock{

	public IPotatoBlock(Properties properties) {
		super(properties);

	}
	   @OnlyIn(Dist.CLIENT)
	   protected IItemProvider getSeedsItem() {
	      return MODItems.POTATO_SENPAI;
	   }
}
