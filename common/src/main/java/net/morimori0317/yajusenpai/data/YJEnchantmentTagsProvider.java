package net.morimori0317.yajusenpai.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.EnchantmentTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.enchantment.YJEnchantments;

import java.util.concurrent.CompletableFuture;

public class YJEnchantmentTagsProvider extends EnchantmentTagsProviderWrapper {

    public YJEnchantmentTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess, registriesDatapackProviderWrapper);
    }

    @Override
    public void generateTag(TagProviderAccess<Enchantment, TagAppenderWrapper<Enchantment>> providerAccess) {
        providerAccess.tag(EnchantmentTags.TOOLTIP_ORDER)
                .add(YJEnchantments.KATYOU_BROKEN, YJEnchantments.GABA_ANA_DADDY, YJEnchantments.KYN);

        providerAccess.tag(EnchantmentTags.TREASURE)
                .add(YJEnchantments.KATYOU_BROKEN, YJEnchantments.GABA_ANA_DADDY, YJEnchantments.KYN);

        providerAccess.tag(EnchantmentTags.ON_RANDOM_LOOT)
                .add(YJEnchantments.KATYOU_BROKEN, YJEnchantments.GABA_ANA_DADDY, YJEnchantments.KYN);

        providerAccess.tag(EnchantmentTags.TRADEABLE)
                .add(YJEnchantments.KATYOU_BROKEN, YJEnchantments.GABA_ANA_DADDY, YJEnchantments.KYN);

        providerAccess.tag(EnchantmentTags.CURSE)
                .add(YJEnchantments.KATYOU_BROKEN, YJEnchantments.GABA_ANA_DADDY, YJEnchantments.KYN);


    }
}
