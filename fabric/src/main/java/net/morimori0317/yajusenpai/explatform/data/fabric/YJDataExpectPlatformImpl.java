package net.morimori0317.yajusenpai.explatform.data.fabric;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.ItemTagProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;
import net.morimori0317.yajusenpai.fabric.data.YajuSenpaiDataGeneratorFabric;

import java.util.concurrent.CompletableFuture;

public class YJDataExpectPlatformImpl {
    public static CompletableFuture<HolderLookup.Provider> getRegistriesDatapackProviderLookup(DataProvider provider) {
        return null;
    }

    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        YajuSenpaiDataGeneratorFabric.generateBlockTag(providerAccess);
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        YajuSenpaiDataGeneratorFabric.generateItemTag(providerAccess);
    }

    public static void generateBiomeTag(TagProviderWrapper.TagProviderAccess<Biome, TagProviderWrapper.TagAppenderWrapper<Biome>> providerAccess) {
        YajuSenpaiDataGeneratorFabric.generateBiomeTag(providerAccess);
    }
}
