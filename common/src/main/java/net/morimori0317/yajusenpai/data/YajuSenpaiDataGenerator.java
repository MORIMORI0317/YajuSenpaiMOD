package net.morimori0317.yajusenpai.data;

import dev.felnull.otyacraftengine.data.CrossDataGeneratorAccess;

public class YajuSenpaiDataGenerator {
    public static void init(CrossDataGeneratorAccess access) {
        access.addProviderWrapper(YJItemModelProviderWrapper::new);
        access.addProviderWrapper(YJBlockStateAndModelProviderWrapper::new);
        access.addProviderWrapper(YJRegistriesDatapackProviderWrapper::new);

        YJBlockTagProviderWrapper blockTagProviderWrapper = access.addProviderWrapper(YJBlockTagProviderWrapper::new);
        access.addProviderWrapper((packOutput, lookup, generatorAccess) -> new YJItemTagProviderWrapper(packOutput, lookup, generatorAccess, blockTagProviderWrapper));
        access.addProviderWrapper(YJDamageTypeTagsProviderWrapper::new);
        access.addProviderWrapper(YJBiomeTagsProviderWrapper::new);

        access.addProviderWrapper(YJRecipeProviderWrapper::new);
        access.addProviderWrapper(YJBlockLootTableProviderWrapper::new);
    }
}
