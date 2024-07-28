package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.morimori0317.yajusenpai.data.cross.provider.EnchantmentTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WrappedEnchantmentTagsProvider extends EnchantmentTagsProvider {
    private final EnchantmentTagsProviderWrapper tagsProviderWrapper;

    public WrappedEnchantmentTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, String modId, @Nullable ExistingFileHelper existingFileHelper, EnchantmentTagsProviderWrapper tagsProviderWrapper) {
        super(arg, completableFuture, modId, existingFileHelper);
        this.tagsProviderWrapper = tagsProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tagsProviderWrapper.generateTag(new EnchantmentTagsProviderAccessImpl());
    }

    private class EnchantmentTagsProviderAccessImpl implements TagProviderWrapper.TagProviderAccess<Enchantment, TagProviderWrapper.TagAppenderWrapper<Enchantment>> {
        @Override
        public TagProviderWrapper.TagAppenderWrapper<Enchantment> tag(TagKey<Enchantment> tagKey) {
            return new WrappedTagsProvider.TagAppenderWrapperImpl<>(WrappedEnchantmentTagsProvider.this.tag(tagKey));
        }
    }
}
