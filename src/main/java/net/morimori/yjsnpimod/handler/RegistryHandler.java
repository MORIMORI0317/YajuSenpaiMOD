package net.morimori.yjsnpimod.handler;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.morimori.yjsnpimod.YJSoundEvents;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.effect.YJEffects;
import net.morimori.yjsnpimod.entity.YJEntityTypes;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.tileentity.YJTileEntityTypes;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegistry(final RegistryEvent.Register<Item> e) {
        YJItems.MOD_ITEMS.forEach(n -> e.getRegistry().register(n));
        YJBlocks.MOD_BLOCKITEMS.forEach(n -> e.getRegistry().register(n));
    }

    @SubscribeEvent
    public static void onBlockRegistry(final RegistryEvent.Register<Block> e) {
        YJBlocks.MOD_BLOCKS.forEach(n -> e.getRegistry().register(n));
    }

    @SubscribeEvent
    public static void onEffectRegistry(final RegistryEvent.Register<Effect> e) {
        YJEffects.MOD_EFFECT.forEach(n -> e.getRegistry().register(n));
    }

    @SubscribeEvent
    public static void onTileEntityTypeRegistry(final RegistryEvent.Register<TileEntityType<?>> e) {
        YJTileEntityTypes.MOD_TILEENTITYTYPES.forEach(n -> e.getRegistry().register(n));
    }

    @SubscribeEvent
    public static void onEntityRegistry(final RegistryEvent.Register<EntityType<?>> e) {
        YJEntityTypes.registerEntity(e.getRegistry());
    }

    @SubscribeEvent
    public static void onSoundEventRegistry(final RegistryEvent.Register<SoundEvent> e) {
        YJSoundEvents.MOD_SOUNDS.forEach(n -> e.getRegistry().register(n));
    }
}
