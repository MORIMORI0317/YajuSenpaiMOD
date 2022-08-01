package net.morimori0317.yajusenpai.server.world.features;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;

import java.util.List;
import java.util.function.Supplier;

public class YJOreFeatures {
    private static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(YajuSenpai.MODID, Registry.CONFIGURED_FEATURE_REGISTRY);

    public static final RuleTest NATURAL_YJ_STONE = new TagMatchTest(YJBlockTags.BASE_YJ_STONE_YJDIM);
    public static final RuleTest YJ_STONE_ORE_REPLACEABLES = new TagMatchTest(YJBlockTags.YJ_STONE_ORE_REPLACEABLES);
    public static final RuleTest YJ_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(YJBlockTags.YJ_DEEPSLATE_ORE_REPLACEABLES);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_YJNIUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(YJ_STONE_ORE_REPLACEABLES, YJBlocks.YJNIUM_ORE.get().defaultBlockState()), OreConfiguration.target(YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YJNIUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_YJSNPI_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(YJ_STONE_ORE_REPLACEABLES, YJBlocks.YJSNPI_ORE.get().defaultBlockState()), OreConfiguration.target(YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YJSNPI_ORE.get().defaultBlockState())));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJNIUM = register("ore_yjnium", Feature.ORE, () -> new OreConfiguration(ORE_YJNIUM_TARGET_LIST.get(), 9));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJNIUM_SMALL = register("ore_yjnium_small", Feature.ORE, () -> new OreConfiguration(ORE_YJNIUM_TARGET_LIST.get(), 4));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI = register("ore_yjsnpi", Feature.ORE, () -> new OreConfiguration(ORE_YJSNPI_TARGET_LIST.get(), 9, 0.5F));

    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_INTERVIEW_BLOCK = register("ore_yjsnpi_interview_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_INTERVIEW_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_GOMANETSU_BLOCK = register("ore_yjsnpi_gomanetsu_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_GOMANETSU_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_ENNUI_BLOCK = register("ore_yjsnpi_ennui_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_ENNUI_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_MEZIKARA_BLOCK = register("ore_yjsnpi_mezikara_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_MEZIKARA_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_NEHAN_BLOCK = register("ore_yjsnpi_nehan_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_NEHAN_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_SHITARIGAO_BLOCK = register("ore_yjsnpi_shitarigao_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_SHITARIGAO_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_IKISUGI_BLOCK = register("ore_yjsnpi_ikisugi_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_IKISUGI_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_IMDKUJ_BLOCK = register("ore_yjsnpi_imdkuj_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_IMDKUJ_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_KUNEKUNE_BLOCK = register("ore_yjsnpi_kunekune_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_KUNEKUNE_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_SZKFK_BLOCK = register("ore_yjsnpi_szkfk_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_SZKFK_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_CCCLKTJM_BLOCK = register("ore_yjsnpi_ccclktjm_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_CCCLKTJM_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_CWCWTD_BLOCK = register("ore_yjsnpi_cwcwtd_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_CWCWTD_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_YJSNPI_INTLNGTM_BLOCK = register("ore_yjsnpi_intlngtm_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YJSNPI_INTLNGTM_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_TON_BLOCK = register("ore_ton_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.TON_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_KMR_BLOCK = register("ore_kmr_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.KMR_BLOCK.get().defaultBlockState(), 33));
    public static final RegistrySupplier<ConfiguredFeature<OreConfiguration, ?>> ORE_MUR_BLOCK = register("ore_mur_block", Feature.ORE, () -> new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.MUR_BLOCK.get().defaultBlockState(), 33));


    public static <FC extends FeatureConfiguration, F extends Feature<FC>> RegistrySupplier<ConfiguredFeature<FC, ?>> register(String name, F feature, Supplier<FC> featureConfiguration) {
        return CONFIGURED_FEATURES.register(name, () -> new ConfiguredFeature(feature, featureConfiguration.get()));
    }

    public static void init() {
        CONFIGURED_FEATURES.register();
    }
}
