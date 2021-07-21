package net.morimori.yjsnpimod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJCreativeModeTab {
    public static final CreativeModeTab MOD_TAB = FabricItemGroupBuilder.build(new ResourceLocation(YJSNPIMOD.MODID,YJSNPIMOD.MODID), () -> new ItemStack(YJItems.ICON));
}
