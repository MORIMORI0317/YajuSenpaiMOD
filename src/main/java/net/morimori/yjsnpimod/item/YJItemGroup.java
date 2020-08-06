package net.morimori.yjsnpimod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJItemGroup {

    public static final ItemGroup MOD_TAB = new ItemGroup(YJSNPIMOD.MODID) {
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon() {
            return new ItemStack(Items.APPLE);
        }
    }.setBackgroundImageName("yjsnpi.png");
}
