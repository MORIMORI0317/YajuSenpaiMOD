package net.morimori.yjsnpimod.client.handler;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IRegistryDelegate;
import red.felnull.otyacraftengine.asm.lib.ObfuscationReflectionUtil;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ColorHandler {
    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item e) {
        ItemColors c = e.getItemColors();

        Map<IRegistryDelegate<Item>, IItemColor> colors = ObfuscationReflectionUtil.getPrivateValue(ItemColors.class, c, "colors");

        c.register(new IItemColor() {
            public int getColor(ItemStack item, int layer) {
                if (item.getTag() != null && item.getTag().contains("Bukkaked") && item.getTag().getBoolean("Bukkaked")) {
                    return 9127187;
                }
                return -1;
            }
        }, ForgeRegistries.ITEMS.getValues().stream().filter(n -> !colors.containsKey(n.asItem().delegate)).toArray(IItemProvider[]::new));

    }
}
