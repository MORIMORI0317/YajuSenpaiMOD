package net.morimori0317.yajusenpai.alchemy;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;

public interface BrewingRegistryAccess {
    void add(Potion input, Item inputItem, Potion output);
}
