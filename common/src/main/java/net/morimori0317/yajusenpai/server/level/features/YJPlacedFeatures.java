package net.morimori0317.yajusenpai.server.level.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.List;

public class YJPlacedFeatures {
    public static final ResourceKey<PlacedFeature> TREES_YJ = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("trees_yj"));
    public static final ResourceKey<PlacedFeature> PATCH_GRASS_YJ = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("patch_grass_yj"));
    public static final ResourceKey<PlacedFeature> FLOWER_DEFAULT_YJ = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("flower_default_yj"));
    public static final ResourceKey<PlacedFeature> PATCH_BB = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("patch_bb"));
    public static final ResourceKey<PlacedFeature> PATCH_GB = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("patch_gb"));
    public static final ResourceKey<PlacedFeature> PATCH_RB = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("patch_rb"));

    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_KMR_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_kmr_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_MUR_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_mur_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_TON_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_ton_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_CCCLKTJM_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_ccclktjm_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_CWCWTD_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_cwcwtd_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_ENNUI_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_ennui_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_GOMANETSU_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_gomanetsu_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_IKISUGI_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_ikisugi_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_IMDKUJ_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_imdkuj_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_INTERVIEW_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_interview_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_INTLNGTM_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_intlngtm_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_KUNEKUNE_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_kunekune_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_MEZIKARA_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_mezikara_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_NEHAN_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_nehan_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_SHITARIGAO_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_shitarigao_block"));
    public static final ResourceKey<PlacedFeature> ORE_INM_ORE_YJSNPI_SZKFK_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_inm/ore_yjsnpi_szkfk_block"));

    public static final ResourceKey<PlacedFeature> ORE_YJNIUM_MIDDLE = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjnium_middle"));
    public static final ResourceKey<PlacedFeature> ORE_YJNIUM_SMALL = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjnium_small"));
    public static final ResourceKey<PlacedFeature> ORE_YJNIUM_UPPER = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjnium_upper"));
    public static final ResourceKey<PlacedFeature> ORE_YJSNPI = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjsnpi"));
    public static final ResourceKey<PlacedFeature> ORE_YJSNPI_EXPLODING_BLOCK = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjsnpi_exploding_block"));
    public static final ResourceKey<PlacedFeature> ORE_YJSNPI_LOWER = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjsnpi_lower"));

    public static RegistrySetBuilder addToBuilder(RegistrySetBuilder builder) {

        builder = builder.add(Registries.PLACED_FEATURE, context -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

            SimpleWeightedRandomList.Builder<IntProvider> yjTreeCount = SimpleWeightedRandomList.builder();
            yjTreeCount.add(ConstantInt.of(0), 19);
            yjTreeCount.add(ConstantInt.of(1), 3);

            context.register(TREES_YJ, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJTreeFeatures.YJ_TREE), ImmutableList.of(
                    CountPlacement.of(new WeightedListInt(yjTreeCount.build())),
                    InSquarePlacement.spread(),
                    SurfaceWaterDepthFilter.forMaxDepth(0),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                    PlacementUtils.filteredByBlockSurvival(YJBlocks.YJ_SAPLING.get()),
                    BiomeFilter.biome()
            )));

            context.register(PATCH_GRASS_YJ, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.YJ_PATCH_GRASS), ImmutableList.of(
                    NoiseThresholdCountPlacement.of(-0.8, 5, 10),
                    InSquarePlacement.spread(),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                    BiomeFilter.biome()
            )));

            context.register(FLOWER_DEFAULT_YJ, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.YJ_FLOWER_DEFAULT), ImmutableList.of(
                    RarityFilter.onAverageOnceEvery(8),
                    InSquarePlacement.spread(),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                    BiomeFilter.biome()
            )));

            List<PlacementModifier> backMaterialPlacedModifier = ImmutableList.of(
                    RarityFilter.onAverageOnceEvery(300),
                    InSquarePlacement.spread(),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                    BiomeFilter.biome()
            );

            context.register(PATCH_BB, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.PATCH_BB), backMaterialPlacedModifier));
            context.register(PATCH_GB, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.PATCH_GB), backMaterialPlacedModifier));
            context.register(PATCH_RB, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.PATCH_RB), backMaterialPlacedModifier));

            List<PlacementModifier> inmOrePlacedModifier = ImmutableList.of(
                    CountPlacement.of(1),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160)),
                    BiomeFilter.biome()
            );

            context.register(ORE_INM_ORE_KMR_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_KMR_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_MUR_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_MUR_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_TON_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_TON_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_CCCLKTJM_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_CCCLKTJM_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_CWCWTD_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_CWCWTD_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_ENNUI_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_ENNUI_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_GOMANETSU_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_GOMANETSU_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_IKISUGI_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_IKISUGI_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_IMDKUJ_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_IMDKUJ_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_INTERVIEW_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_INTERVIEW_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_INTLNGTM_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_INTLNGTM_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_KUNEKUNE_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_KUNEKUNE_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_MEZIKARA_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_MEZIKARA_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_NEHAN_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_NEHAN_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_SHITARIGAO_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_SHITARIGAO_BLOCK), inmOrePlacedModifier));
            context.register(ORE_INM_ORE_YJSNPI_SZKFK_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_SZKFK_BLOCK), inmOrePlacedModifier));

            context.register(ORE_YJNIUM_MIDDLE, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJNIUM), ImmutableList.of(
                    CountPlacement.of(10),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)),
                    BiomeFilter.biome()
            )));

            context.register(ORE_YJNIUM_SMALL, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJNIUM_SMALL), ImmutableList.of(
                    CountPlacement.of(10),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(72)),
                    BiomeFilter.biome()
            )));

            context.register(ORE_YJNIUM_UPPER, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJNIUM), ImmutableList.of(
                    CountPlacement.of(90),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)),
                    BiomeFilter.biome()
            )));

            context.register(ORE_YJSNPI, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI), ImmutableList.of(
                    CountPlacement.of(4),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)),
                    BiomeFilter.biome()
            )));

            context.register(ORE_YJSNPI_EXPLODING_BLOCK, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI_EXPLODING_BLOCK), ImmutableList.of(
                    CountPlacement.of(1),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-62), VerticalAnchor.absolute(30)),
                    BiomeFilter.biome()
            )));

            context.register(ORE_YJSNPI_LOWER, new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJSNPI), ImmutableList.of(
                    CountPlacement.of(UniformInt.of(0, 1)),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)),
                    BiomeFilter.biome()
            )));
        });

        return builder;
    }
}
