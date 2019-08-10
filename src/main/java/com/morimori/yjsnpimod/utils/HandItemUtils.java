package com.morimori.yjsnpimod.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.morimori.yjsnpimod.items.MODItems;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class HandItemUtils {
	public static boolean isHandinSheildItem(Entity entyty) {


		Iterable<ItemStack> Item = entyty.getHeldEquipment();
		List<ItemStack> ItemList = StreamSupport
			    .stream(Item.spliterator(), false)
			    .collect(Collectors.toList());
		if(ItemList.get(1).getItem()==MODItems.JAKEN_YORUIKIMASYOU) {


			return true;
	}
		if(ItemList.get(0).getItem()==MODItems.JAKEN_YORUIKIMASYOU) {


			return true;
	}


		return false;


	}
}
