package net.morimori0317.yajusenpai.explatform.data.neoforge;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.ItemTagProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;
import net.morimori0317.yajusenpai.neoforge.handler.DataGenHandler;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.concurrent.CompletableFuture;

public class YJDataExpectPlatformImpl {
    public static CompletableFuture<HolderLookup.Provider> getRegistriesDatapackProviderLookup(DataProvider provider) {
        if (provider instanceof DatapackBuiltinEntriesProvider datapackBuiltinEntriesProvider) {
            return datapackBuiltinEntriesProvider.getRegistryProvider();
        }
        throw new IllegalStateException();
    }

    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        DataGenHandler.generateBlockTag(providerAccess);
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        DataGenHandler.generateItemTag(providerAccess);
    }

    public static void generateBiomeTag(TagProviderWrapper.TagProviderAccess<Biome, TagProviderWrapper.TagAppenderWrapper<Biome>> providerAccess) {
        DataGenHandler.generateBiomeTag(providerAccess);
    }

    public static void generateDamageTypeTag(TagProviderWrapper.TagProviderAccess<DamageType, TagProviderWrapper.TagAppenderWrapper<DamageType>> providerAccess) {
        DataGenHandler.generateDamageTypeTag(providerAccess);
    }
}
