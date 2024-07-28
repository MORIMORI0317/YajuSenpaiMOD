package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.ItemTagProviderWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;


public class WrappedFabricItemTagProvider extends FabricTagProvider.ItemTagProvider {
    private final ItemTagProviderWrapper tagProviderWrapper;

    public WrappedFabricItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable BlockTagProvider blockTagProvider, ItemTagProviderWrapper tagProviderWrapper) {
        super(output, completableFuture, blockTagProvider);
        this.tagProviderWrapper = tagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tagProviderWrapper.generateTag(new ItemTagProviderAccessImpl());
    }


    private class ItemTagProviderAccessImpl implements ItemTagProviderWrapper.ItemTagProviderAccess {
        @Override
        public void copy(TagKey<Block> blockTag, TagKey<Item> itemTag) {
            WrappedFabricItemTagProvider.this.copy(blockTag, itemTag);
        }

        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<Item> tag(TagKey<Item> tagKey) {
            return new WrappedFabricIntrinsicHolderTagsProvider.IntrinsicHolderTagAppenderWrapperImpl<>(WrappedFabricItemTagProvider.this.tag(tagKey), tagProviderWrapper);
        }
    }
}

