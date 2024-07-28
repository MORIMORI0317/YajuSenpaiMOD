package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.ItemTagProviderWrapper;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WrappedItemTagsProvider extends ItemTagsProvider {
    private final ItemTagProviderWrapper tagProviderWrapper;

    public WrappedItemTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagLookup, String modId, @Nullable ExistingFileHelper existingFileHelper, ItemTagProviderWrapper tagProviderWrapper) {
        super(arg, completableFuture, blockTagLookup, modId, existingFileHelper);
        this.tagProviderWrapper = tagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.tagProviderWrapper.generateTag(new ItemTagProviderAccessImpl());
    }

    private class ItemTagProviderAccessImpl implements ItemTagProviderWrapper.ItemTagProviderAccess {
        @Override
        public void copy(TagKey<Block> blockTag, TagKey<Item> itemTag) {
            WrappedItemTagsProvider.this.copy(blockTag, itemTag);
        }

        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<Item> tag(TagKey<Item> tagKey) {
            return new WrappedIntrinsicHolderTagsProvider.IntrinsicHolderTagAppenderWrapperImpl<>(WrappedItemTagsProvider.this.tag(tagKey));
        }
    }
}
