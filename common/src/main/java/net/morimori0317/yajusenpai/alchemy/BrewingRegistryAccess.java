package net.morimori0317.yajusenpai.alchemy;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;

public interface BrewingRegistryAccess {
    void add(Holder<Potion> input, Item inputItem, Holder<Potion> output);
}
