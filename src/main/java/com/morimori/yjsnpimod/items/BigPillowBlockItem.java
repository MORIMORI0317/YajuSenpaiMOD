package com.morimori.yjsnpimod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.morimori.yjsnpimod.net.URLreeder;
import com.morimori.yjsnpimod.utils.YJToolTipUtils;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BigPillowBlockItem extends BlockItem{

	public static String SOZAI_TITEL=URLreeder.Titelloadint("https://www.nicovideo.jp/watch/sm19360333");

	public BigPillowBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);

	}
	   @OnlyIn(Dist.CLIENT)
	   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		   	if(YJToolTipUtils.iskyePush(Minecraft.getInstance().gameSettings.keyBindSneak,tooltip)) {
	      tooltip.add(this.getIDescription());
	      YJToolTipUtils.genSozaiURL(tooltip, "https://www.nicovideo.jp/watch/sm19360333", SOZAI_TITEL);

		   	}


	   }

	   @OnlyIn(Dist.CLIENT)
	   public ITextComponent getIDescription() {
	      return new TranslationTextComponent(this.getTranslationKey() + ".desc").applyTextStyle(TextFormatting.GRAY);
	   }

}
