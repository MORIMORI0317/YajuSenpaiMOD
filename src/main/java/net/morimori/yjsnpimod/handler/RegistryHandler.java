package net.morimori.yjsnpimod.handler;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.item.YJItems;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
        YJItems.registerItem(e.getRegistry());
        YJBlocks.registerItem(e.getRegistry());
    }

    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<Block> e) {
        YJBlocks.registerBlock(e.getRegistry());
    }
}
