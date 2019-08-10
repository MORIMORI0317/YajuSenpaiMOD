package com.morimori.yjsnpimod.utils;

import java.util.List;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class YJToolTipUtils {
	public static int PushTime;
	public static boolean iskyePush(KeyBinding keyBindSneak, List<ITextComponent> tooltip) {
		if(keyBindSneak.isPressed()) {
			PushTime=30;
		}
		if(PushTime>=-1) {
			PushTime=PushTime-1;
		}

		if(PushTime>=0) {
			return true;
			}
		tooltip.add(new TranslationTextComponent("keypressed.desc",new TranslationTextComponent(keyBindSneak.getLocalizedName()).applyTextStyle(TextFormatting.YELLOW)));
			return false;

	}
	public static void genSozaiURL(List<ITextComponent> tooltip,String url, String tile) {

		tooltip.add(getURLdesc(url));
		tooltip.add(getURLtitle(url,tile));

	}
	public static ITextComponent getURLdesc(String url) {
	return new TranslationTextComponent("url.desc",url).applyTextStyle(TextFormatting.GREEN);
	}
	public static ITextComponent getURLtitle(String url, String tile) {

	return new TranslationTextComponent(tile).applyTextStyle(TextFormatting.BLUE);
	}
}
