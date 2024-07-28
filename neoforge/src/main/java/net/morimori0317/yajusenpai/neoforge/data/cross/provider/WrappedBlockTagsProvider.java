package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.data.cross.provider.BlockTagProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WrappedBlockTagsProvider extends BlockTagsProvider {
    private final BlockTagProviderWrapper tagProviderWrapper;

    public WrappedBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper, BlockTagProviderWrapper tagProviderWrapper) {
        super(output, lookupProvider, modId, existingFileHelper);
        this.tagProviderWrapper = tagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tagProviderWrapper.generateTag(new BlockTagProviderAccessImpl());
    }

    private class BlockTagProviderAccessImpl implements IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> {
        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<Block> tag(TagKey<Block> tagKey) {
            return new WrappedIntrinsicHolderTagsProvider.IntrinsicHolderTagAppenderWrapperImpl<>(WrappedBlockTagsProvider.this.tag(tagKey));
        }
    }
}
