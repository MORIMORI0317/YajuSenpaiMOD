package net.morimori0317.yajusenpai.server.level.features;

import com.google.common.base.Suppliers;
import net.minecraft.Util;
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
import net.morimori0317.yajusenpai.server.level.dimension.InmBlockGen;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class YJOreFeatures {
    public static final RuleTest INM_BLOCK_REPLACEABLES = new TagMatchTest(YJBlockTags.INM_BLOCK_REPLACEABLES);
    public static final RuleTest YJ_STONE_ORE_REPLACEABLES = new TagMatchTest(YJBlockTags.YJ_STONE_ORE_REPLACEABLES);
    public static final RuleTest YJ_DEEPSLATE_ORE_REPLACEABLES = new TagMatchTest(YJBlockTags.YJ_DEEPSLATE_ORE_REPLACEABLES);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_YJNIUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(YJ_STONE_ORE_REPLACEABLES, YJBlocks.YJNIUM_ORE.get().defaultBlockState()), OreConfiguration.target(YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YJNIUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> ORE_YAJUSENPAI_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(YJ_STONE_ORE_REPLACEABLES, YJBlocks.YAJUSENPAI_ORE.get().defaultBlockState()), OreConfiguration.target(YJ_DEEPSLATE_ORE_REPLACEABLES, YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get().defaultBlockState())));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJNIUM = key("ore_yjnium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YJNIUM_SMALL = key("ore_yjnium_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_YAJUSENPAI = key("ore_yajusenpai");

    public static final Map<InmBlockGen, ResourceKey<ConfiguredFeature<?, ?>>> INM_BLOCK_CHUNK = Util.make(() -> {
        Map<InmBlockGen, ResourceKey<ConfiguredFeature<?, ?>>> ret = new EnumMap<>(InmBlockGen.class);
        for (InmBlockGen value : InmBlockGen.values()) {
            ret.put(value, key(value.getName() + "block_chunk"));
        }
        return ret;
    });

    private static ResourceKey<ConfiguredFeature<?, ?>> key(String id) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, YJUtils.modLoc(id));
    }

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<ConfiguredFeature<?, ?>> register) {
        register.add(ORE_YJNIUM, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YJNIUM_TARGET_LIST.get(), 9)));
        register.add(ORE_YJNIUM_SMALL, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YJNIUM_TARGET_LIST.get(), 4)));
        register.add(ORE_YAJUSENPAI, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(ORE_YAJUSENPAI_TARGET_LIST.get(), 9, 0.5F)));

        INM_BLOCK_CHUNK.forEach((key, entry) -> inmBlockOre(register, entry, key.getBlock(), key.isRare() ? 15 : 33));
    }

    private static void inmBlockOre(RegistriesDatapackProviderWrapper.DynamicRegister<ConfiguredFeature<?, ?>> register, ResourceKey<ConfiguredFeature<?, ?>> key, Supplier<Block> block, int size) {
        register.add(key, ctx -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(INM_BLOCK_REPLACEABLES, block.get().defaultBlockState(), size)));
    }
}
