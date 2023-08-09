package net.morimori0317.yajusenpai.data;

import dev.felnull.otyacraftengine.data.CrossDataGeneratorAccess;
import dev.felnull.otyacraftengine.data.provider.RegistriesDatapackProviderWrapper;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.entity.YJDamageTypes;
import net.morimori0317.yajusenpai.server.level.dimension.YJDimensions;
import net.morimori0317.yajusenpai.server.level.features.YJOreFeatures;
import net.morimori0317.yajusenpai.server.level.features.YJPlacedFeatures;
import net.morimori0317.yajusenpai.server.level.features.YJTreeFeatures;
import net.morimori0317.yajusenpai.server.level.features.YJVegetationFeatures;
import net.morimori0317.yajusenpai.server.level.structure.YJStructureSets;
import net.morimori0317.yajusenpai.server.level.structure.YJStructures;

import java.util.concurrent.CompletableFuture;

public class YJRegistriesDatapackProviderWrapper extends RegistriesDatapackProviderWrapper {
    private static final RegistrySetBuilder BUILDER;

    static {
        RegistrySetBuilder builder = new RegistrySetBuilder();

        builder = YJDamageTypes.addToBuilder(builder);
        builder = YJDimensions.addToBuilder(builder);
        builder = YJPlacedFeatures.addToBuilder(builder);
        builder = YJStructures.addToBuilder(builder);
        builder = YJStructureSets.addToBuilder(builder);

        builder.add(Registries.CONFIGURED_FEATURE, context -> {
            YJVegetationFeatures.registerBuilder(context);
            YJTreeFeatures.registerBuilder(context);
            YJOreFeatures.registerBuilder(context);
        });

        BUILDER = builder;
    }

    public YJRegistriesDatapackProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, lookup, BUILDER, crossDataGeneratorAccess);
    }

    //https://github1s.com/TeamTwilight/twilightforest/blob/HEAD/src/main/java/twilightforest/data/RegistryDataGenerator.java <-参考
    protected static CompletableFuture<HolderLookup.Provider> unitedLookup(CompletableFuture<HolderLookup.Provider> lookup) {
        return lookup.thenApplyAsync(it -> BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), it), Util.backgroundExecutor());
    }
}
