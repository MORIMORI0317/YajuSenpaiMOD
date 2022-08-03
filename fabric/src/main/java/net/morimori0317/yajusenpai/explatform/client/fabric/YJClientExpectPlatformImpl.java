package net.morimori0317.yajusenpai.explatform.client.fabric;

import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.client.renderer.item.BEWLItemRenderer;
import net.morimori0317.yajusenpai.fabric.mixin.client.ItemRendererAccessor;

public class YJClientExpectPlatformImpl {
    public static void registerItemRenderer(ItemLike item, BEWLItemRenderer renderer) {
        BuiltinItemRendererRegistry.INSTANCE.register(item, renderer::render);
    }

    public static BlockEntityWithoutLevelRenderer getBlockEntityRenderer() {
        return ((ItemRendererAccessor) (Minecraft.getInstance().getItemRenderer())).getBlockEntityRenderer();
    }

    public static void registerItemProperties(Item item, ResourceLocation location, ItemPropertyFunction itemPropertyFunction) {
        ItemProperties.register(item, location, itemPropertyFunction::call);
    }
}
