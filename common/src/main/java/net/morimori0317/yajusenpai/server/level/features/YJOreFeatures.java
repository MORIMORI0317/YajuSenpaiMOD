package net.morimori0317.yajusenpai.server.level.features;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.List;

public class YJOreFeatures {
    public static final RuleTest NATURAL_YJ_STONE = new TagMatchTest(YJBlockTags.BASE_YJ_STONE_YJDIM);
    public static final RuleTest YJ_STONE_ORE_REPLACEABLES = new TagMatchTest(YJBlockTags.YJ_STONE_ORE_REPLACEABLES);
    public static final RuleTest YJ_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(YJBlockTags.YJ_DEEPSLATE_ORE_REPLACEABLES);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_YJNIUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(YJ_STONE_ORE_REPLACEABLES, YJBlocks.YJNIUM_ORE.get().defaultBlockState()), OreConfiguration.target(YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YJNIUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_YJSNPI_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(YJ_STONE_ORE_REPLACEABLES, YJBlocks.YAJUSENPAI_ORE.get().defaultBlockState()), OreConfiguration.target(YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get().defaultBlockState())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJNIUM = key("ore_yjnium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJNIUM_SMALL = key("ore_yjnium_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI = key("ore_yjsnpi");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_INTERVIEW_BLOCK = key("ore_yjsnpi_interview_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_GOMANETSU_BLOCK = key("ore_yjsnpi_gomanetsu_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_ENNUI_BLOCK = key("ore_yjsnpi_ennui_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_MEDIKARA_BLOCK = key("ore_yjsnpi_medikara_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_NEHAN_BLOCK = key("ore_yjsnpi_nehan_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_SHITARIGAO_BLOCK = key("ore_yjsnpi_shitarigao_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_IKISUGI_BLOCK = key("ore_yjsnpi_ikisugi_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_IMDKUJ_BLOCK = key("ore_yjsnpi_imdkuj_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_KUNEKUNE_BLOCK = key("ore_yjsnpi_kunekune_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_SZKFK_BLOCK = key("ore_yjsnpi_szkfk_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_CCCLKTJM_BLOCK = key("ore_yjsnpi_ccclktjm_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_CWCWTD_BLOCK = key("ore_yjsnpi_cwcwtd_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_INTLNGTM_BLOCK = key("ore_yjsnpi_intlngtm_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TON_BLOCK = key("ore_ton_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_KMR_BLOCK = key("ore_kmr_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MUR_BLOCK = key("ore_mur_block");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJSNPI_EXPLODING_BLOCK = key("ore_yjsnpi_exploding_block");

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, YJUtils.modLoc(id));
    }

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<ConfiguredFeature<?, ?>> register) {
        register.add(ORE_YJNIUM, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YJNIUM_TARGET_LIST.get(), 9)));
        register.add(ORE_YJNIUM_SMALL, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YJNIUM_TARGET_LIST.get(), 4)));
        register.add(ORE_YJSNPI, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YJSNPI_TARGET_LIST.get(), 9, 0.5F)));

        register.add(ORE_YJSNPI_INTERVIEW_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YAJUSENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_GOMANETSU_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.GOMANETSU_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_ENNUI_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.ENNUI_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_MEDIKARA_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.MEDIKARA_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_NEHAN_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.NEHAN_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_SHITARIGAO_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.SHITARIGAO_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_IKISUGI_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.YAJUSENPAI_IKISUGI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_IMDKUJ_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.IMDKUJ_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_KUNEKUNE_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.KUNEKUNE_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_SZKFK_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.SZKFK_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_CCCLKTJM_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.CCCLKTJM_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_CWCWTD_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.CWCWTD_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_INTLNGTM_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.INTLNGTM_SENPAI_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_TON_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.TON_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_KMR_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.KMR_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_MUR_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.MUR_BLOCK.get().defaultBlockState(), 33)));
        register.add(ORE_YJSNPI_EXPLODING_BLOCK, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK.get().defaultBlockState(), 15)));
    }
}
