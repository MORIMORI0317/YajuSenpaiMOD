package com.morimori.yjsnpimod.other;

import com.morimori.yjsnpimod.blocks.MODBlocks;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MODItemGroups extends ItemGroup {


	public MODItemGroups(String label) {
		super(label);

	}

	public static final ItemGroup YJ_TAB = new MODItemGroups("yjsnpi").setBackgroundImageName("yjsnpi.png");
    @OnlyIn(Dist.CLIENT)
	public ItemStack createIcon() {

		return  new ItemStack(MODBlocks.YJ_SNPAI_BLOCK);
	};

	   public boolean hasSearchBar() {
		      return true;
		   }

}
