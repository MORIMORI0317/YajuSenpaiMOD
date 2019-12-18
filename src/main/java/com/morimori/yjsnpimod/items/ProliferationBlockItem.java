package com.morimori.yjsnpimod.items;

import java.util.List;

import javax.annotation.Nullable;

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

public class ProliferationBlockItem extends BlockItem{

	public ProliferationBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);

	}
	   @OnlyIn(Dist.CLIENT)
	   public boolean hasEffect(ItemStack stack) {
	      return true;
	   }



	   @OnlyIn(Dist.CLIENT)
	   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		   	if(YJToolTipUtils.iskyePush(Minecraft.getInstance().gameSettings.field_228046_af_,tooltip)) {
	      tooltip.add(this.getIDescription().applyTextStyle(TextFormatting.RED));
		   	}
	   }

	   @OnlyIn(Dist.CLIENT)
	   public ITextComponent getIDescription() {
	      return new TranslationTextComponent(this.getTranslationKey() + ".desc");
	   }




}
