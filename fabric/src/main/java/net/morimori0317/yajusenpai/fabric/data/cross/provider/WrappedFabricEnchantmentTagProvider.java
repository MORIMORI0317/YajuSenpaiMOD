package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.morimori0317.yajusenpai.data.cross.provider.EnchantmentTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class WrappedFabricEnchantmentTagProvider extends FabricTagProvider.EnchantmentTagProvider {
    private final EnchantmentTagsProviderWrapper tagsProviderWrapper;

    public WrappedFabricEnchantmentTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, EnchantmentTagsProviderWrapper tagsProviderWrapper) {
        super(output, completableFuture);
        this.tagsProviderWrapper = tagsProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        this.tagsProviderWrapper.generateTag(new EnchantmentTagProviderAccessImpl());
    }

    private class EnchantmentTagProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<Enchantment, TagProviderWrapper.TagAppenderWrapper<Enchantment>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<Enchantment> tag(TagKey<Enchantment> tagKey) {
            return new WrappedFabricTagProvider.TagAppenderWrapperImpl<>(WrappedFabricEnchantmentTagProvider.this.tag(tagKey));
        }
    }
}
