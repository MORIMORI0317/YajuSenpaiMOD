package net.morimori0317.yajusenpai.data;

import dev.felnull.otyacraftengine.data.CrossDataGeneratorAccess;
import dev.felnull.otyacraftengine.data.provider.DamageTypeTagsProviderWrapper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.morimori0317.yajusenpai.entity.YJDamageTypeTags;
import net.morimori0317.yajusenpai.entity.YJDamageTypes;

import java.util.concurrent.CompletableFuture;

public class YJDamageTypeTagsProviderWrapper extends DamageTypeTagsProviderWrapper {
    public YJDamageTypeTagsProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, YJRegistriesDatapackProviderWrapper.unitedLookup(lookup), crossDataGeneratorAccess);
    }

    @Override
    public void generateTag(TagProviderAccess<DamageType, TagAppenderWrapper<DamageType>> providerAccess) {
        providerAccess.tag(DamageTypeTags.BYPASSES_INVULNERABILITY)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_ENCHANTMENTS)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_EFFECTS)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_ARMOR)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_COOLDOWN)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_SHIELD)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.BYPASSES_RESISTANCE)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.ALWAYS_HURTS_ENDER_DRAGONS)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.AVOIDS_GUARDIAN_THORNS)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(DamageTypeTags.NO_IMPACT)
                .add(YJDamageTypes.IKISUGI);

        providerAccess.tag(YJDamageTypeTags.IS_IKISUGI)
                .add(YJDamageTypes.IKISUGI);
    }
}
