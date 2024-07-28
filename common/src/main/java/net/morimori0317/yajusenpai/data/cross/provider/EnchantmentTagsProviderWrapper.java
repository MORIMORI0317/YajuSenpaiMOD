package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.item.enchantment.Enchantment;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;

public abstract class EnchantmentTagsProviderWrapper extends TagProviderWrapper<Enchantment, TagProviderWrapper.TagProviderAccess<Enchantment, TagProviderWrapper.TagAppenderWrapper<Enchantment>>> {
    private final TagsProvider<Enchantment> enchantmentTagsProvider;

    public EnchantmentTagsProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess);
        this.enchantmentTagsProvider = crossDataGeneratorAccess.createEnchantmentTagProvider(packOutput, lookup, this, registriesDatapackProviderWrapper);
    }

    @Override
    public TagsProvider<Enchantment> getProvider() {
        return this.enchantmentTagsProvider;
    }
}
