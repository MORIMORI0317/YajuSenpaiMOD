package net.morimori0317.yajusenpai.server.level.features;

import com.google.common.base.Suppliers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
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
import java.util.function.Supplier;

public class YJOreFeatures {
    public static final RuleTest NATURAL_YJ_STONE = new TagMatchTest(YJBlockTags.BASE_YJ_STONE_YJDIM);
    public static final RuleTest YJ_STONE_ORE_REPLACEABLES = new TagMatchTest(YJBlockTags.YJ_STONE_ORE_REPLACEABLES);
    public static final RuleTest YJ_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(YJBlockTags.YJ_DEEPSLATE_ORE_REPLACEABLES);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_YJNIUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(YJ_STONE_ORE_REPLACEABLES, YJBlocks.YJNIUM_ORE.get().defaultBlockState()), OreConfiguration.target(YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YJNIUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_YAJUSENPAI_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(YJ_STONE_ORE_REPLACEABLES, YJBlocks.YAJUSENPAI_ORE.get().defaultBlockState()), OreConfiguration.target(YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get().defaultBlockState())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJNIUM = key("ore_yjnium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJNIUM_SMALL = key("ore_yjnium_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI = key("ore_yajusenpai");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_INTERVIEW_BLOCK = key("ore_yajusenpai_interview_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_GOMANETSU_BLOCK = key("ore_yajusenpai_gomanetsu_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_ENNUI_BLOCK = key("ore_yajusenpai_ennui_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_MEDIKARA_BLOCK = key("ore_yajusenpai_medikara_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_NEHAN_BLOCK = key("ore_yajusenpai_nehan_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_SHITARIGAO_BLOCK = key("ore_yajusenpai_shitarigao_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_IKISUGI_BLOCK = key("ore_yajusenpai_ikisugi_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_IMDKUJ_BLOCK = key("ore_yajusenpai_imdkuj_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_KUNEKUNE_BLOCK = key("ore_yajusenpai_kunekune_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_SZKFK_BLOCK = key("ore_yajusenpai_szkfk_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_CCCLKTJM_BLOCK = key("ore_yajusenpai_ccclktjm_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_CWCWTD_BLOCK = key("ore_yajusenpai_cwcwtd_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_INTLNGTM_BLOCK = key("ore_yajusenpai_intlngtm_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TON_BLOCK = key("ore_ton_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_KMR_BLOCK = key("ore_kmr_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_MUR_BLOCK = key("ore_mur_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_NKTIDKSG_BLOCK = key("ore_nktidksg_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TAKEDA_INM_BLOCK = key("ore_takeda_inm_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_KATYOU_BLOCK = key("ore_katyou_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SECOND_INARI_OTOKO_BLOCK = key("ore_second_inari_otoko_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_AKYS_BLOCK = key("ore_akys_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_GO_BLOCK = key("ore_go_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_HIDE_BLOCK = key("ore_hide_block");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_KBTIT_BLOCK = key("ore_kbtit_block");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI_EXPLODING_BLOCK = key("ore_yajusenpai_exploding_block");

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, YJUtils.modLoc(id));
    }

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<ConfiguredFeature<?, ?>> register) {
        register.add(ORE_YJNIUM, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YJNIUM_TARGET_LIST.get(), 9)));
        register.add(ORE_YJNIUM_SMALL, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YJNIUM_TARGET_LIST.get(), 4)));
        register.add(ORE_YAJUSENPAI, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YAJUSENPAI_TARGET_LIST.get(), 9, 0.5F)));

        inmBlockOre(register, ORE_YAJUSENPAI_INTERVIEW_BLOCK, YJBlocks.YAJUSENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_GOMANETSU_BLOCK, YJBlocks.GOMANETSU_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_ENNUI_BLOCK, YJBlocks.ENNUI_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_MEDIKARA_BLOCK, YJBlocks.MEDIKARA_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_NEHAN_BLOCK, YJBlocks.NEHAN_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_SHITARIGAO_BLOCK, YJBlocks.SHITARIGAO_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_IKISUGI_BLOCK, YJBlocks.YAJUSENPAI_IKISUGI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_IMDKUJ_BLOCK, YJBlocks.IMDKUJ_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_KUNEKUNE_BLOCK, YJBlocks.KUNEKUNE_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_SZKFK_BLOCK, YJBlocks.SZKFK_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_CCCLKTJM_BLOCK, YJBlocks.CCCLKTJM_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_CWCWTD_BLOCK, YJBlocks.CWCWTD_SENPAI_BLOCK, 33);
        inmBlockOre(register, ORE_YAJUSENPAI_INTLNGTM_BLOCK, YJBlocks.INTLNGTM_SENPAI_BLOCK, 33);

        inmBlockOre(register, ORE_TON_BLOCK, YJBlocks.TON_BLOCK, 33);
        inmBlockOre(register, ORE_KMR_BLOCK, YJBlocks.KMR_BLOCK, 33);
        inmBlockOre(register, ORE_MUR_BLOCK, YJBlocks.MUR_BLOCK, 33);
        inmBlockOre(register, ORE_NKTIDKSG_BLOCK, YJBlocks.NKTIDKSG_BLOCK, 33);
        inmBlockOre(register, ORE_TAKEDA_INM_BLOCK, YJBlocks.TAKEDA_INM_BLOCK, 33);
        inmBlockOre(register, ORE_KATYOU_BLOCK, YJBlocks.KATYOU_BLOCK, 33);
        inmBlockOre(register, ORE_SECOND_INARI_OTOKO_BLOCK, YJBlocks.SECOND_INARI_OTOKO_BLOCK, 33);
        inmBlockOre(register, ORE_AKYS_BLOCK, YJBlocks.AKYS_BLOCK, 33);
        inmBlockOre(register, ORE_GO_BLOCK, YJBlocks.GO_BLOCK, 33);
        inmBlockOre(register, ORE_HIDE_BLOCK, YJBlocks.HIDE_BLOCK, 33);
        inmBlockOre(register, ORE_KBTIT_BLOCK, YJBlocks.KBTIT_BLOCK, 33);

        inmBlockOre(register, ORE_YAJUSENPAI_EXPLODING_BLOCK, YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK, 15);
    }

    private static void inmBlockOre(RegistriesDatapackProviderWrapper.DynamicRegister<ConfiguredFeature<?, ?>> register, ResourceKey<ConfiguredFeature<?, ?>> key, Supplier<Block> block, int size) {
        register.add(key, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NATURAL_YJ_STONE, block.get().defaultBlockState(), size)));
    }
}
