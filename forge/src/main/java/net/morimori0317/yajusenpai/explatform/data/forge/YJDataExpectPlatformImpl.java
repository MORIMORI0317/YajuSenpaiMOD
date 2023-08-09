package net.morimori0317.yajusenpai.explatform.data.forge;

import dev.felnull.otyacraftengine.data.provider.IntrinsicHolderTagsProviderWrapper;
import dev.felnull.otyacraftengine.data.provider.ItemTagProviderWrapper;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.forge.handler.DataGenHandler;

public class YJDataExpectPlatformImpl {
    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        DataGenHandler.generateBlockTag(providerAccess);
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        DataGenHandler.generateItemTag(providerAccess);
    }
}
