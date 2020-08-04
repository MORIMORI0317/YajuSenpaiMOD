package net.morimori.yjsnpimod.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraft.item.SimpleFoiledItem;
import net.minecraftforge.registries.IForgeRegistry;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJItems {
    public static final Item YJ_CORE = newItem("yj_core");
    public static final Item YJ_INGOT = newItem("yj_ingot");
    public static final Item BAKED_POTATO_SENPAI = newFoodItem("baked_potato_senpai", YJFoods.BAKED_POTATO_SENPAI);
    public static final Item YJ_STAR = new SimpleFoiledItem(new Item.Properties().group(YJItemGroup.MOD_TAB).rarity(Rarity.UNCOMMON)).setRegistryName(YJSNPIMOD.MODID, "yj_star");

    public static void registerItem(IForgeRegistry<Item> r) {
        registryItem(r, YJ_CORE);
        registryItem(r, YJ_INGOT);
        registryItem(r, BAKED_POTATO_SENPAI);
        registryItem(r, YJ_STAR);
    }

    private static void registryItem(IForgeRegistry<Item> r, Item i) {
        r.register(i);
    }

    private static Item newFoodItem(String name, Food foos) {
        return new Item(new Item.Properties().group(YJItemGroup.MOD_TAB).food(foos)).setRegistryName(YJSNPIMOD.MODID, name);
    }

    private static Item newItem(String name) {
        return new Item(new Item.Properties().group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, name);
    }
}
