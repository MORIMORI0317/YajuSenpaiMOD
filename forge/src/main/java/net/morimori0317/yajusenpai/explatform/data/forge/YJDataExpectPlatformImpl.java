package net.morimori0317.yajusenpai.explatform.data.forge;

import dev.felnull.otyacraftengine.data.provider.IntrinsicHolderTagsProviderWrapper;
import dev.felnull.otyacraftengine.data.provider.ItemTagProviderWrapper;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.forge.handler.DataGenHandlerW;

public class YJDataExpectPlatformImpl {
    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        DataGenHandlerW.generateBlockTag(providerAccess);
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        DataGenHandlerW.generateItemTag(providerAccess);
    }
}
