package net.morimori.yjsnpimod.handler;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.effect.YJEffects;
import net.morimori.yjsnpimod.entity.YJEntityTypes;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.tileentity.YJTileEntityTypes;

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

    @SubscribeEvent
    public static void onEffectRegistry(final RegistryEvent.Register<Effect> e) {
        YJEffects.registerEffect(e.getRegistry());
    }

    @SubscribeEvent
    public static void onTileEntityTypeRegistry(final RegistryEvent.Register<TileEntityType<?>> e) {
        YJTileEntityTypes.registerTileEntityType(e.getRegistry());
    }

    @SubscribeEvent
    public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> e) {
        YJEntityTypes.registerEntity(e.getRegistry());
    }
}
