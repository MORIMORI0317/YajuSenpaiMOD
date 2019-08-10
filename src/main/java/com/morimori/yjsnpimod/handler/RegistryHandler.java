package com.morimori.yjsnpimod.handler;

import com.morimori.yjsnpimod.Variable;
import com.morimori.yjsnpimod.YJSNPImod;
import com.morimori.yjsnpimod.blocks.MODBlocks;
import com.morimori.yjsnpimod.effects.MODEffects;
import com.morimori.yjsnpimod.effects.MODPotions;
import com.morimori.yjsnpimod.items.BigPillowBlockItem;
import com.morimori.yjsnpimod.items.MODItems;
import com.morimori.yjsnpimod.items.ProliferationBlockItem;
import com.morimori.yjsnpimod.other.MODItemGroups;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class RegistryHandler {
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

        	YJSNPImod.LOGGER.info("YJSNPI-onBlocksRegistry");
        	blockRegistryEvent.getRegistry().registerAll(
        			MODBlocks.PROLIFERATION_YJSNPI,
        			MODBlocks.YJ_SNPAI_BLOCK,
        			MODBlocks.BIG_PILLOW,
        			MODBlocks.POTATO_SENPAI,
        			MODBlocks.YJ_ROSE,
        			MODBlocks.POTTED_YJ_ROSE


        			);
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {

        	YJSNPImod.LOGGER.info("YJSNPI-onItemsRegistry");
        	itemRegistryEvent.getRegistry().registerAll(

        			 new ProliferationBlockItem(MODBlocks.PROLIFERATION_YJSNPI, new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID, "proliferation_yjsnpi_block"),
        			 new BlockItem(MODBlocks.YJ_SNPAI_BLOCK, new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID, "yj_senpai_block"),
        			 new BigPillowBlockItem(MODBlocks.BIG_PILLOW, new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID, "big_pillow"),
        			 new BlockItem(MODBlocks.YJ_ROSE, new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID, "yj_rose"),

        			 MODItems.YJINTERVEW_RECORD,
        			 MODItems.YONSYOU_RECORD,
        			 MODItems.SANSYOU_RECORD,
        			 MODItems.CYCLOPS_RECORD,
        			 MODItems.JAKEN_YORUIKIMASYOUNE,
        			 MODItems.JAKEN_YORUIKIMASYOU,
        			 MODItems.YJ_CORE,
        			 MODItems.SOFT_SMARTPHONE,
        			 MODItems.DIAMOND_SENPAI,
        			 MODItems.DIAMOND_SENPAI_SWORD,
        			 MODItems.DIAMOND_SENPAI_AXE,
        			 MODItems.DIAMOND_SENPAI_SHOVEL,
        			 MODItems.DIAMOND_SENPAI_PICKAXE,
        			 MODItems.DIAMOND_SENPAI_HOE,
        			 MODItems.POTATO_SENPAI,
        			 MODItems.INFINITY_SENPAI_CATALYST,
        			 MODItems.INFINITY_SENPAI_INGOT,
        			 MODItems.YJ_INGOT,
        			 MODItems.YJ_AXE,
        			 MODItems.YJ_SHOVEL,
        			 MODItems.YJ_SWORD,
        			 MODItems.YJ_HOE,
        			 MODItems.YJ_PICKAXE,
        			 MODItems.INFINITY_SENPAI_AXE,
        			 MODItems.INFINITY_SENPAI_HOE,
        			 MODItems.INFINITY_SENPAI_PICKAXE,
        			 MODItems.INFINITY_SENPAI_SHOVEL,
        			 MODItems.INFINITY_SENPAI_SWORD,
        			 MODItems.YJ_STAR,
        			 MODItems.BAKED_POTATO_SENPAI




        		);
        }
        @SubscribeEvent
        public static void onEffectRegistry(final RegistryEvent.Register<Effect> effectRegistryEvent) {

        	YJSNPImod.LOGGER.info("YJSNPI-onEffecstRegistry");
        	effectRegistryEvent.getRegistry().registerAll(
        			MODEffects.BEASTIFICATIO,
        			MODEffects.CUM,
        			MODEffects.COMA
        			);

        }
        @SubscribeEvent
        public static void onPotionRegistry(final RegistryEvent.Register<Potion> effectRegistryEvent) {

        	YJSNPImod.LOGGER.info("YJSNPI-onPotionRegistry");
        	effectRegistryEvent.getRegistry().registerAll(
        			MODPotions.BEASTIFICATIO,
        			MODPotions.LONG_BEASTIFICATIO,
        			MODPotions.STRONG_BEASTIFICATIO,
        			MODPotions.CUM,
        			MODPotions.LONG_CUM,
        			MODPotions.STRONG_CUM,
        			MODPotions.MORE_LONG_CUM,
        			MODPotions.MORE_STRONG_CUM
        			);

        }
    }

}
