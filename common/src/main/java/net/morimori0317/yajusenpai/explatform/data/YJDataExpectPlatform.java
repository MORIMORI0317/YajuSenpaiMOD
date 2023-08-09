package net.morimori0317.yajusenpai.explatform.data;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.felnull.otyacraftengine.data.provider.IntrinsicHolderTagsProviderWrapper;
import dev.felnull.otyacraftengine.data.provider.ItemTagProviderWrapper;
import net.minecraft.world.level.block.Block;

public class YJDataExpectPlatform {
    @ExpectPlatform
    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        throw new AssertionError();
    }
}
