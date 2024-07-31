package net.morimori0317.yajusenpai.neoforge.client.renderer.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.client.renderer.item.BEWLItemRenderer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemRendererRegisterNeoForge {
    private static final Map<Item, BEWLItemRenderer> RENDERERS = new HashMap<>();

    public static void register(ItemLike item, BEWLItemRenderer renderer) {
        Objects.requireNonNull(item, "item like is null");
        Objects.requireNonNull(item.asItem(), "item is null");
        Objects.requireNonNull(renderer, "renderer is null");

        if (RENDERERS.putIfAbsent(item.asItem(), renderer) != null)
            throw new IllegalArgumentException("Item " + item.asItem().builtInRegistryHolder() + " already has a builtin renderer!");
    }

    public static BEWLItemRenderer getRenderer(Item item) {
        return RENDERERS.get(item);
    }
}
