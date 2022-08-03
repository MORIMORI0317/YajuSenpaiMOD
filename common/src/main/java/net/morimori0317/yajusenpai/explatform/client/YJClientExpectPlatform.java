package net.morimori0317.yajusenpai.explatform.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.client.renderer.item.BEWLItemRenderer;


public class YJClientExpectPlatform {
    @ExpectPlatform
    public static void registerItemRenderer(ItemLike item, BEWLItemRenderer renderer) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static BlockEntityWithoutLevelRenderer getBlockEntityRenderer() {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void registerItemProperties(Item item, ResourceLocation location, ItemPropertyFunction itemPropertyFunction) {
        throw new AssertionError();
    }
}
