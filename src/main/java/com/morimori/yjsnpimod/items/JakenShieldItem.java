package com.morimori.yjsnpimod.items;

import java.util.List;

import javax.annotation.Nullable;

import com.morimori.yjsnpimod.utils.YJToolTipUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class JakenShieldItem extends ShieldItem{

	public JakenShieldItem(Properties builder) {
		super(builder);

	}
	   @OnlyIn(Dist.CLIENT)
	   public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		   int kakurituue=810;
		   int kakuritusita=114514;

		   	if(YJToolTipUtils.iskyePush(Minecraft.getInstance().gameSettings.field_228046_af_,tooltip)) {
	      tooltip.add(this.getIDescription(kakurituue,kakuritusita).applyTextStyle(TextFormatting.GRAY));
		   	}
	   }
	   @OnlyIn(Dist.CLIENT)
	   public ITextComponent getIDescription(int kakurituue, int kakuritusita) {
	      return new TranslationTextComponent(this.getTranslationKey() + ".desc",kakurituue,kakuritusita);
	   }
}
