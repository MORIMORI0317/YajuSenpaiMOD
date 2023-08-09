package net.morimori0317.yajusenpai.explatform.data.fabric;

import dev.felnull.otyacraftengine.data.provider.IntrinsicHolderTagsProviderWrapper;
import dev.felnull.otyacraftengine.data.provider.ItemTagProviderWrapper;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.fabric.data.YajuSenpaiDataGeneratorFabric;

public class YJDataExpectPlatformImpl {
    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        YajuSenpaiDataGeneratorFabric.generateBlockTag(providerAccess);
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        YajuSenpaiDataGeneratorFabric.generateItemTag(providerAccess);
    }
}
