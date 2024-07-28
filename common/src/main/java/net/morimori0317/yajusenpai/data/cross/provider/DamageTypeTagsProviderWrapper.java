package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.damagesource.DamageType;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.concurrent.CompletableFuture;

public abstract class DamageTypeTagsProviderWrapper extends TagProviderWrapper<DamageType, TagProviderWrapper.TagProviderAccess<DamageType, TagProviderWrapper.TagAppenderWrapper<DamageType>>> {
    private final TagsProvider<DamageType> damageTypeTagsProvider;

    public DamageTypeTagsProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess);
        this.damageTypeTagsProvider = crossDataGeneratorAccess.createDamageTypeTagProvider(packOutput, lookup, this, registriesDatapackProviderWrapper);
    }

    @Override
    public TagsProvider<DamageType> getProvider() {
        return damageTypeTagsProvider;
    }
}
