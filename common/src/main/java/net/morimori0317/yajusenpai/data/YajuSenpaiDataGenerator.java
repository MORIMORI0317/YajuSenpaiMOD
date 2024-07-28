package net.morimori0317.yajusenpai.data;

import net.minecraft.core.RegistrySetBuilder;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;

public class YajuSenpaiDataGenerator {
    public static void init(CrossDataGeneratorAccess access) {
        access.addProviderWrapper(YJItemModelProvider::new);
        access.addProviderWrapper(YJBlockStateAndModelProvider::new);
        access.addProviderWrapper(YJRecipeProvider::new);
        access.addProviderWrapper(YJBlockLootTableProvider::new);

        YJRegistriesDatapackProvider registriesDatapackProvider = access.addProviderWrapper(YJRegistriesDatapackProvider::new);
        YJBlockTagProvider blockTagProvider = access.addProviderWrapper(YJBlockTagProvider::new);
        access.addProviderWrapper((packOutput, lookup, generatorAccess) -> new YJItemTagProvider(packOutput, lookup, generatorAccess, blockTagProvider));
        access.addProviderWrapper((packOutput, lookup, generatorAccess) -> new YJDamageTypeTagsProvider(packOutput, lookup, generatorAccess, registriesDatapackProvider));
        access.addProviderWrapper((packOutput, lookup, generatorAccess) -> new YJEnchantmentTagsProvider(packOutput, lookup, generatorAccess, registriesDatapackProvider));
        access.addProviderWrapper((packOutput, lookup, generatorAccess) -> new YJBiomeTagsProvider(packOutput, lookup, generatorAccess, registriesDatapackProvider));
    }

    public static void buildRegistry(RegistrySetBuilder registryBuilder) {
        RegistriesDatapackProviderWrapper.createRegistrySetBuilder(registryBuilder, YJRegistriesDatapackProvider.REGISTERS);
    }
}
