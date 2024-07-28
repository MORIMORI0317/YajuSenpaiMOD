package net.morimori0317.yajusenpai.explatform.data;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataProvider;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.ItemTagProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class YJDataExpectPlatform {
    @ExpectPlatform
    public static CompletableFuture<HolderLookup.Provider> getRegistriesDatapackProviderLookup(DataProvider provider) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        throw new AssertionError();
    }
}
