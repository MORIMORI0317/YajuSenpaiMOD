package net.morimori0317.yajusenpai.server.level.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.Util;
import net.minecraft.core.HolderGetter;
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
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.server.level.dimension.InmBlockGen;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class YJPlacedFeatures {
    public static final ResourceKey<PlacedFeature> TREES_YJ = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("trees_yj"));
    public static final ResourceKey<PlacedFeature> PATCH_GRASS_YJ = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("patch_grass_yj"));
    public static final ResourceKey<PlacedFeature> FLOWER_DEFAULT_YJ = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("flower_default_yj"));
    public static final ResourceKey<PlacedFeature> PATCH_BB = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("patch_bb"));
    public static final ResourceKey<PlacedFeature> PATCH_GB = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("patch_gb"));
    public static final ResourceKey<PlacedFeature> PATCH_RB = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("patch_rb"));

    public static final ResourceKey<PlacedFeature> CHUNK_EXPLODING_YAJUSENPAI_BLOCK_LOWER = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("chunk_exploding_yajusenpai_block_lower"));

    public static final Map<InmBlockGen, ResourceKey<PlacedFeature>> INM_BLOCK_CHUNK_YJDIM = Util.make(() -> {
        Map<InmBlockGen, ResourceKey<PlacedFeature>> ret = new EnumMap<>(InmBlockGen.class);
        for (InmBlockGen value : InmBlockGen.values()) {
            ret.put(value, ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("inm_chunk/yjdim/" + value.getName() + "_block")));
        }
        return ret;
    });

    public static final Map<InmBlockGen, ResourceKey<PlacedFeature>> INM_BLOCK_CHUNK_GENERAL = Util.make(() -> {
        Map<InmBlockGen, ResourceKey<PlacedFeature>> ret = new EnumMap<>(InmBlockGen.class);
        for (InmBlockGen value : InmBlockGen.values()) {
            ret.put(value, ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("inm_chunk/general/" + value.getName() + "_block")));
        }
        return ret;
    });

    public static final Map<InmBlockGen, ResourceKey<PlacedFeature>> INM_BLOCK_CHUNK_SPECIAL = Util.make(() -> {
        Map<InmBlockGen, ResourceKey<PlacedFeature>> ret = new EnumMap<>(InmBlockGen.class);
        for (InmBlockGen value : InmBlockGen.values()) {
            ret.put(value, ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("inm_chunk/special/" + value.getName() + "_block")));
        }
        return ret;
    });


    public static final ResourceKey<PlacedFeature> ORE_YJNIUM_MIDDLE = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjnium_middle"));
    public static final ResourceKey<PlacedFeature> ORE_YJNIUM_SMALL = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjnium_small"));
    public static final ResourceKey<PlacedFeature> ORE_YJNIUM_UPPER = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yjnium_upper"));
    public static final ResourceKey<PlacedFeature> ORE_YAJUSENPAI = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yajusenpai"));
    public static final ResourceKey<PlacedFeature> ORE_YAJUSENPAI_LOWER = ResourceKey.create(Registries.PLACED_FEATURE, YJUtils.modLoc("ore_yajusenpai_lower"));


    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<PlacedFeature> register) {
        SimpleWeightedRandomList.Builder<IntProvider> yjTreeCount = SimpleWeightedRandomList.builder();
        yjTreeCount.add(ConstantInt.of(0), 19);
        yjTreeCount.add(ConstantInt.of(1), 3);

        register.add(TREES_YJ, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);

            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJTreeFeatures.YJ_TREE), ImmutableList.of(
                    CountPlacement.of(new WeightedListInt(yjTreeCount.build())),
                    InSquarePlacement.spread(),
                    SurfaceWaterDepthFilter.forMaxDepth(0),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR),
                    PlacementUtils.filteredByBlockSurvival(YJBlocks.YJ_SAPLING.get()),
                    BiomeFilter.biome()));
        });

        register.add(PATCH_GRASS_YJ, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);

            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.YJ_PATCH_GRASS), ImmutableList.of(
                    NoiseThresholdCountPlacement.of(-0.8, 5, 10),
                    InSquarePlacement.spread(),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.WORLD_SURFACE_WG),
                    BiomeFilter.biome()));
        });

        register.add(FLOWER_DEFAULT_YJ, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.YJ_FLOWER_DEFAULT), ImmutableList.of(
                    RarityFilter.onAverageOnceEvery(8),
                    InSquarePlacement.spread(),
                    HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                    BiomeFilter.biome()));
        });

        List<PlacementModifier> backMaterialPlacedModifier = ImmutableList.of(
                RarityFilter.onAverageOnceEvery(300),
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                BiomeFilter.biome()
        );

        register.add(PATCH_BB, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.PATCH_BB), backMaterialPlacedModifier);
        });
        register.add(PATCH_GB, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.PATCH_GB), backMaterialPlacedModifier);
        });
        register.add(PATCH_RB, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJVegetationFeatures.PATCH_RB), backMaterialPlacedModifier);
        });

        INM_BLOCK_CHUNK_YJDIM.forEach((inmBlockGen, key) -> inmChunkGen(register, key, YJOreFeatures.INM_BLOCK_CHUNK.get(inmBlockGen), inmBlockGen.isYj(), inmBlockGen.isRare(), true, false));
        INM_BLOCK_CHUNK_GENERAL.forEach((inmBlockGen, key) -> inmChunkGen(register, key, YJOreFeatures.INM_BLOCK_CHUNK.get(inmBlockGen), inmBlockGen.isYj(), inmBlockGen.isRare(), false, false));
        INM_BLOCK_CHUNK_SPECIAL.forEach((inmBlockGen, key) -> inmChunkGen(register, key, YJOreFeatures.INM_BLOCK_CHUNK.get(inmBlockGen), inmBlockGen.isYj(), inmBlockGen.isRare(), false, true));

        register.add(ORE_YJNIUM_MIDDLE, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJNIUM), ImmutableList.of(
                    CountPlacement.of(10),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)),
                    BiomeFilter.biome()));
        });

        register.add(ORE_YJNIUM_SMALL, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJNIUM_SMALL), ImmutableList.of(
                    CountPlacement.of(10),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(72)),
                    BiomeFilter.biome()));
        });

        register.add(ORE_YJNIUM_UPPER, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YJNIUM), ImmutableList.of(
                    CountPlacement.of(90),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)),
                    BiomeFilter.biome()));
        });

        register.add(ORE_YAJUSENPAI, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YAJUSENPAI), ImmutableList.of(
                    CountPlacement.of(4),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)),
                    BiomeFilter.biome()));
        });

        register.add(ORE_YAJUSENPAI_LOWER, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.ORE_YAJUSENPAI), ImmutableList.of(
                    CountPlacement.of(UniformInt.of(0, 1)),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)),
                    BiomeFilter.biome()));
        });

        register.add(CHUNK_EXPLODING_YAJUSENPAI_BLOCK_LOWER, ctx -> {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(YJOreFeatures.INM_BLOCK_CHUNK.get(InmBlockGen.YAJUSENPAI_EXPLODING)), ImmutableList.of(
                    CountPlacement.of(3),
                    InSquarePlacement.spread(),
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-62), VerticalAnchor.absolute(30)),
                    BiomeFilter.biome()));
        });

    }

    private static void inmChunkGen(RegistriesDatapackProviderWrapper.DynamicRegister<PlacedFeature> register,
                                    ResourceKey<PlacedFeature> key,
                                    ResourceKey<ConfiguredFeature<?, ?>> configuredFeatureKey, boolean yj, boolean rare, boolean yjDim, boolean special) {

        register.add(key, ctx -> {
            ImmutableList.Builder<PlacementModifier> modifierBuilder = new ImmutableList.Builder<>();
            modifierBuilder.add(InSquarePlacement.spread());

            if (special) {
                modifierBuilder.add(CountPlacement.of(rare ? 5 : 19));
                modifierBuilder.add(HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(160)));
                modifierBuilder.add(RarityFilter.onAverageOnceEvery(150 * InmBlockGen.values().length));
            } else {
                modifierBuilder.add(CountPlacement.of(1));

                if (yjDim) {
                    modifierBuilder.add(rare ? HeightRangePlacement.uniform(VerticalAnchor.absolute(-62), VerticalAnchor.absolute(30)) : HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(160)));
                    if (!yj) {
                        modifierBuilder.add(RarityFilter.onAverageOnceEvery(20));
                    }
                    modifierBuilder.add(BiomeFilter.biome());
                } else {
                    modifierBuilder.add(HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(160)));
                    modifierBuilder.add(RarityFilter.onAverageOnceEvery((rare ? 16 : 20) * InmBlockGen.values().length));
                }
            }

            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
            return new PlacedFeature(configuredFeatureHolderGetter.getOrThrow(configuredFeatureKey), modifierBuilder.build());
        });
    }
}