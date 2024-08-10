package net.morimori0317.yajusenpai.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.DamageTypeTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageTypeTags;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageTypes;
import net.morimori0317.yajusenpai.explatform.data.YJDataExpectPlatform;

import java.util.concurrent.CompletableFuture;

public class YJDamageTypeTagsProvider extends DamageTypeTagsProviderWrapper {
    public YJDamageTypeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess, registriesDatapackProviderWrapper);
    }

    @Override
    public void generateTag(TagProviderAccess<DamageType, TagAppenderWrapper<DamageType>> providerAccess) {
        providerAccess.tag(DamageTypeTags.BYPASSES_INVULNERABILITY)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_ENCHANTMENTS)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_EFFECTS)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_ARMOR)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_COOLDOWN)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_SHIELD)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_RESISTANCE)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.AVOIDS_GUARDIAN_THORNS)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(DamageTypeTags.NO_IMPACT)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        providerAccess.tag(YJDamageTypeTags.IS_IKISUGI)
                .add(YJDamageTypes.IKISUGI, YJDamageTypes.PLAYER_IKISUGI);

        YJDataExpectPlatform.generateDamageTypeTag(providerAccess);
    }
}
