package net.morimori0317.yajusenpai.client.renderer.item;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.explatform.client.YJClientExpectPlatform;

public class ItemRendererRegister {
    public static void register(RegistrySupplier<? extends ItemLike> item, BEWLItemRenderer renderer) {
        YJClientExpectPlatform.registerItemRenderer(item.get(), renderer);
    }

    public static void register(ItemLike item, BEWLItemRenderer renderer) {
        YJClientExpectPlatform.registerItemRenderer(item, renderer);
    }
}
