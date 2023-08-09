package net.morimori0317.yajusenpai.server.level.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.List;

public class YJDimensions {
    public static final ResourceKey<LevelStem> THE_YAJUSENPAI_DIMENSION = ResourceKey.create(Registries.LEVEL_STEM, YJUtils.modLoc("the_yajusenpai"));
    public static final ResourceKey<NoiseGeneratorSettings> YAJUSENPAI_NOISE_SETTINGS = ResourceKey.create(Registries.NOISE_SETTINGS, YJUtils.modLoc("yajusenpai"));
    public static final ResourceKey<Biome> YAJUSENPAI_BIOME = ResourceKey.create(Registries.BIOME, YJUtils.modLoc("yajusenpai"));

    public static RegistrySetBuilder addToBuilder(RegistrySetBuilder builder) {
        builder = builder.add(Registries.BIOME, context -> {
            context.register(YAJUSENPAI_BIOME, YJBiomes.createYJBiome(context));
        });

        builder = builder.add(Registries.NOISE_SETTINGS, context -> {
            context.register(YAJUSENPAI_NOISE_SETTINGS, yajusenpaiNoiseGeneratorSetting(context));
        });

        builder = builder.add(Registries.LEVEL_STEM, context -> {
            HolderGetter<DimensionType> dimensionTypeHolderGetter = context.lookup(Registries.DIMENSION_TYPE);
            HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettingsHolderGetter = context.lookup(Registries.NOISE_SETTINGS);
            HolderGetter<Biome> biomeSourceHolderGetter = context.lookup(Registries.BIOME);

            context.register(THE_YAJUSENPAI_DIMENSION, new LevelStem(dimensionTypeHolderGetter.getOrThrow(BuiltinDimensionTypes.OVERWORLD),
                    new NoiseBasedChunkGenerator(new FixedBiomeSource(biomeSourceHolderGetter.getOrThrow(YAJUSENPAI_BIOME)), noiseGeneratorSettingsHolderGetter.getOrThrow(YAJUSENPAI_NOISE_SETTINGS))));
        });

        return builder;
    }

    private static NoiseGeneratorSettings yajusenpaiNoiseGeneratorSetting(BootstapContext<NoiseGeneratorSettings> context) {
        HolderGetter<DensityFunction> densityFunctionHolderGetter = context.lookup(Registries.DENSITY_FUNCTION);
        HolderGetter<NormalNoise.NoiseParameters> noiseParametersHolderGetter = context.lookup(Registries.NOISE);

        NoiseSettings noiseSettings = NoiseSettings.create(-64, 384, 1, 2);
        NoiseRouter noiseRouter = NoiseRouterData.overworld(densityFunctionHolderGetter, noiseParametersHolderGetter, false, false);
        SurfaceRules.RuleSource ruleSource = YJSurfaceRuleData.yjDimension();

        List<Climate.ParameterPoint> spawns = new OverworldBiomeBuilder().spawnTarget();

        return new NoiseGeneratorSettings(noiseSettings,
                YJBlocks.YJ_STONE.get().defaultBlockState(),
                Blocks.WATER.defaultBlockState(),
                noiseRouter,
                ruleSource,
                spawns,
                63,
                false,
                true,
                true,
                false);
    }

    private static DensityFunction noiseGradientDensity(DensityFunction densityFunction, DensityFunction densityFunction2) {
        DensityFunction densityFunction3 = DensityFunctions.mul(densityFunction2, densityFunction);
        return DensityFunctions.mul(DensityFunctions.constant(4.0), densityFunction3.quarterNegative());
    }

    private static DensityFunction getFunction(HolderGetter<DensityFunction> holderGetter, ResourceKey<DensityFunction> resourceKey) {
        return new DensityFunctions.HolderHolder(holderGetter.getOrThrow(resourceKey));
    }

    private static DensityFunction slideOverworld(boolean bl, DensityFunction densityFunction) {
        return slide(densityFunction, -64, 384, bl ? 16 : 80, bl ? 0 : 64, -0.078125, 0, 24, bl ? 0.4 : 0.1171875);
    }

    private static ResourceKey<DensityFunction> createDensityFunctionKey(String string) {
        return ResourceKey.create(Registries.DENSITY_FUNCTION, new ResourceLocation(string));
    }

    private static DensityFunction slide(DensityFunction densityFunction, int i, int j, int k, int l, double d, int m, int n, double e) {
        DensityFunction densityFunction2 = densityFunction;
        DensityFunction densityFunction3 = DensityFunctions.yClampedGradient(i + j - k, i + j - l, 1.0, 0.0);
        densityFunction2 = DensityFunctions.lerp(densityFunction3, d, densityFunction2);
        DensityFunction densityFunction4 = DensityFunctions.yClampedGradient(i + m, i + n, 0.0, 1.0);
        densityFunction2 = DensityFunctions.lerp(densityFunction4, e, densityFunction2);
        return densityFunction2;
    }
}
