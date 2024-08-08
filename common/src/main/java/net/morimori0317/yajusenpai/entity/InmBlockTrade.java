package net.morimori0317.yajusenpai.entity;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public class InmBlockTrade implements VillagerTrades.ItemListing {
    private final Supplier<Block> inmBlock;

    public InmBlockTrade(Supplier<Block> inmBlock) {
        this.inmBlock = inmBlock;
    }

    @Override
    public @Nullable MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
        return new MerchantOffer(new ItemCost(Items.EMERALD, randomSource.nextInt(10) + 1), Optional.empty(),
                new ItemStack(inmBlock.get(), randomSource.nextInt(64) + 1), 114514, 30, 0.05f);
    }
}
