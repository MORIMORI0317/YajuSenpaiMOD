package net.morimori0317.yajusenpai.server.level.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJDimensions {
    public static final ResourceKey<LevelStem> THE_YAJUSENPAI_DIMENSION = ResourceKey.create(Registries.LEVEL_STEM, YJUtils.modLoc("the_yajusenpai"));
    public static final ResourceKey<Level> YJ_DIM = ResourceKey.create(Registries.DIMENSION, YJUtils.modLoc("the_yajusenpai"));

    //https://misode.github.io/dimension/
    //https://github.com/misode/vanilla-worldgen/tree/master/worldgen/biome

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<LevelStem> register) {
        register.add(THE_YAJUSENPAI_DIMENSION, ctx -> {
            HolderGetter<DimensionType> dimensionTypeHolderGetter = ctx.lookup(Registries.DIMENSION_TYPE);
            HolderGetter<NoiseGeneratorSettings> noiseGeneratorSettingsHolderGetter = ctx.lookup(Registries.NOISE_SETTINGS);
            HolderGetter<Biome> biomeSourceHolderGetter = ctx.lookup(Registries.BIOME);

            return new LevelStem(dimensionTypeHolderGetter.getOrThrow(BuiltinDimensionTypes.OVERWORLD),
                    new NoiseBasedChunkGenerator(new FixedBiomeSource(biomeSourceHolderGetter.getOrThrow(YJBiomes.YAJUSENPAI_BIOME)), noiseGeneratorSettingsHolderGetter.getOrThrow(YJNoiseGeneratorSettings.YAJUSENPAI_NOISE_SETTINGS)));
        });
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
        return ResourceKey.create(Registries.DENSITY_FUNCTION, ResourceLocation.parse(string));
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
