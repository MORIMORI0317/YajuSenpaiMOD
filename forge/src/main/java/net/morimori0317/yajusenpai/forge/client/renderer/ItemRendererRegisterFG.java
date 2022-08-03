package net.morimori0317.yajusenpai.forge.client.renderer;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.morimori0317.yajusenpai.client.renderer.item.BEWLItemRenderer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemRendererRegisterFG {
    private static final Map<Item, BEWLItemRenderer> RENDERERS = new HashMap<>();

    public static void register(ItemLike item, BEWLItemRenderer renderer) {
        Objects.requireNonNull(item, "item is null");
        Objects.requireNonNull(item.asItem(), "item is null");
        Objects.requireNonNull(renderer, "renderer is null");

        if (RENDERERS.putIfAbsent(item.asItem(), renderer) != null)
            throw new IllegalArgumentException("Item " + item.asItem() + " already has a builtin renderer!");
    }

    public static BEWLItemRenderer getRenderer(Item item) {
        return RENDERERS.get(item);
    }
}