package net.morimori0317.yajusenpai.item;

import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.morimori0317.yajusenpai.YajuSenpai;

public class YJCreativeModeTab {
    public static final CreativeModeTab MOD_TAB = CreativeTabRegistry.create(new ResourceLocation(YajuSenpai.MODID, YajuSenpai.MODID), () -> new ItemStack(YJItems.ICON.get()));
}
