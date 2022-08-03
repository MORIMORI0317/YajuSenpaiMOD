package net.morimori0317.yajusenpai.explatform.client.forge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.client.renderer.item.BEWLItemRenderer;
import net.morimori0317.yajusenpai.forge.client.renderer.ItemRendererRegisterFG;

public class YJClientExpectPlatformImpl {
    public static void registerItemRenderer(ItemLike item, BEWLItemRenderer renderer) {
        ItemRendererRegisterFG.register(item, renderer);
    }

    public static BlockEntityWithoutLevelRenderer getBlockEntityRenderer() {
        return Minecraft.getInstance().getItemRenderer().getBlockEntityRenderer();
    }

    public static void registerItemProperties(Item item, ResourceLocation location, ItemPropertyFunction itemPropertyFunction) {
        ItemProperties.register(item, location, itemPropertyFunction);
    }
}
