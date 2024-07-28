package net.morimori0317.yajusenpai.server.level.dimension;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.*;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.List;

public class YJNoiseGeneratorSettings {
    public static final ResourceKey<NoiseGeneratorSettings> YAJUSENPAI_NOISE_SETTINGS = ResourceKey.create(Registries.NOISE_SETTINGS, YJUtils.modLoc("yajusenpai"));

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<NoiseGeneratorSettings> register) {
        register.add(YAJUSENPAI_NOISE_SETTINGS, YJNoiseGeneratorSettings::yajusenpaiNoiseGeneratorSetting);
    }

    private static NoiseGeneratorSettings yajusenpaiNoiseGeneratorSetting(BootstrapContext<NoiseGeneratorSettings> context) {
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
}
