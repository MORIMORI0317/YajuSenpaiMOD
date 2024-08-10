package net.morimori0317.yajusenpai.fabric.data;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.YajuSenpaiDataGenerator;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.ItemTagProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.TagProviderWrapper;
import net.morimori0317.yajusenpai.fabric.block.YJBlockTagsFabric;
import net.morimori0317.yajusenpai.fabric.data.cross.CrossDataGeneratorAccesses;
import net.morimori0317.yajusenpai.fabric.item.YJItemTagsFabric;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomeTags;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomes;

import java.util.concurrent.atomic.AtomicReference;

public class YajuSenpaiDataGeneratorFabric implements DataGeneratorEntrypoint {
    private final AtomicReference<CrossDataGeneratorAccess> dataGeneratorAccess = new AtomicReference<>();

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        dataGeneratorAccess.set(CrossDataGeneratorAccesses.create(fabricDataGenerator));
        YajuSenpaiDataGenerator.init(dataGeneratorAccess.get());
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        YajuSenpaiDataGenerator.buildRegistry(registryBuilder);
    }


    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        providerAccess.tag(ConventionalBlockTags.ORES)
                .addTags(ImmutableList.of(YJBlockTags.YJNIUM_ORES, YJBlockTags.YAJUSENPAI_ORES));

        providerAccess.tag(ConventionalBlockTags.STONES)
                .add(YJBlocks.YJ_STONE.get(), YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(ConventionalBlockTags.COBBLESTONES)
                .add(YJBlocks.YJ_STONE.get(), YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(YJBlockTagsFabric.STORAGE_BLOCKS_YJNIUM)
                .add(YJBlocks.YJNIUM_BLOCK.get());

        providerAccess.tag(YJBlockTagsFabric.STORAGE_BLOCKS_RAW_YJNIUM)
                .add(YJBlocks.RAW_YJNIUM_BLOCK.get());

        providerAccess.tag(ConventionalBlockTags.STORAGE_BLOCKS)
                .addTags(ImmutableList.of(YJBlockTagsFabric.STORAGE_BLOCKS_YJNIUM,
                        YJBlockTagsFabric.STORAGE_BLOCKS_RAW_YJNIUM,
                        YJBlockTagsFabric.STORAGE_BLOCKS_RAW_YAJUSENPAI));

        providerAccess.tag(YJBlockTagsFabric.STORAGE_BLOCKS_RAW_YAJUSENPAI)
                .add(YJBlocks.RAW_YAJUSENPAI_BLOCK.get());

        providerAccess.tag(YJBlockTagsFabric.YJNIUM_ORES)
                .add(YJBlocks.YJNIUM_ORE.get(), YJBlocks.DEEPSLATE_YJNIUM_ORE.get());

        providerAccess.tag(YJBlockTagsFabric.YAJUSENPAI_ORES)
                .add(YJBlocks.YAJUSENPAI_ORE.get(), YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get());

        providerAccess.tag(ConventionalBlockTags.ORES)
                .addVanillaTag(YJBlockTagsFabric.YAJUSENPAI_ORES)
                .addVanillaTag(YJBlockTagsFabric.YJNIUM_ORES);

        providerAccess.tag(YJBlockTagsFabric.SANDS)
                .add(YJBlocks.YJ_SAND.get());

        providerAccess.tag(YJBlockTagsFabric.GRAVELS)
                .add(YJBlocks.YJ_GRAVEL.get());
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        providerAccess.copy(ConventionalBlockTags.ORES, ConventionalItemTags.ORES);
        providerAccess.copy(ConventionalBlockTags.STORAGE_BLOCKS, ConventionalItemTags.STORAGE_BLOCKS);
        providerAccess.copy(YJBlockTagsFabric.SANDS, YJItemTagsFabric.SANDS);
        providerAccess.copy(YJBlockTagsFabric.GRAVELS, YJItemTagsFabric.GRAVELS);
        providerAccess.copy(YJBlockTagsFabric.YJNIUM_ORES, YJItemTagsFabric.YJNIUM_ORES);
        providerAccess.copy(YJBlockTagsFabric.YAJUSENPAI_ORES, YJItemTagsFabric.YAJUSENPAI_ORES);
        providerAccess.copy(YJBlockTagsFabric.STORAGE_BLOCKS_YJNIUM, YJItemTagsFabric.STORAGE_BLOCKS_YJNIUM);
        providerAccess.copy(YJBlockTagsFabric.STORAGE_BLOCKS_RAW_YJNIUM, YJItemTagsFabric.STORAGE_BLOCKS_RAW_YJNIUM);
        providerAccess.copy(YJBlockTagsFabric.STORAGE_BLOCKS_RAW_YAJUSENPAI, YJItemTagsFabric.STORAGE_BLOCKS_RAW_YAJUSENPAI);

        providerAccess.tag(ConventionalItemTags.FOODS)
                .add(YJItems.ICE_TEA.get(), YJItems.BAKED_POTATO_SENPAI.get());

        providerAccess.tag(ConventionalItemTags.FRUITS_FOODS)
                .add(YJItems.APPLE_INM.get());

        providerAccess.tag(ConventionalItemTags.VEGETABLES_FOODS)
                .add(YJItems.POTATO_SENPAI.get());

        providerAccess.tag(YJItemTagsFabric.GLOWSTONE_BLOCKS)
                .add(Items.GLOWSTONE);

        providerAccess.tag(YJItemTagsFabric.OLD_RAW_YJNIUM_ORES)
                .addTag(YJItemTagsFabric.YJNIUM_RAW_MATERIALS);

        providerAccess.tag(YJItemTagsFabric.YJNIUM_RAW_MATERIALS)
                .add(YJItems.RAW_YJNIUM.get());

        providerAccess.tag(YJItemTagsFabric.OLD_RAW_YJNIUM_BLOCKS)
                .addTag(YJItemTagsFabric.STORAGE_BLOCKS_RAW_YJNIUM);

        providerAccess.tag(YJItemTagsFabric.OLD_RAW_YAJUSENPAI_ORES)
                .addTag(YJItemTagsFabric.YAJUSENPAI_RAW_MATERIALS);

        providerAccess.tag(YJItemTagsFabric.YAJUSENPAI_RAW_MATERIALS)
                .add(YJItems.RAW_YAJUSENPAI.get());

        providerAccess.tag(YJItemTagsFabric.OLD_RAW_YAJUSENPAI_BLOCKS)
                .addTag(YJItemTagsFabric.STORAGE_BLOCKS_RAW_YAJUSENPAI);

        providerAccess.tag(YJItemTagsFabric.WHEAT_CROPS)
                .add(Items.WHEAT);

        providerAccess.tag(YJItemTagsFabric.OLD_YJNIUM_BLOCKS)
                .addTag(YJItemTagsFabric.STORAGE_BLOCKS_YJNIUM);

        providerAccess.tag(YJItemTagsFabric.OLD_YJNIUM_INGOTS)
                .addTag(YJItemTagsFabric.YJNIUM_INGOTS);

        providerAccess.tag(YJItemTagsFabric.YJNIUM_INGOTS)
                .add(YJItems.YJNIUM_INGOT.get());

        providerAccess.tag(YJItemTagsFabric.OLD_YJNIUM_NUGGETS)
                .addTag(YJItemTagsFabric.YJNIUM_NUGGETS);

        providerAccess.tag(YJItemTagsFabric.YJNIUM_NUGGETS)
                .add(YJItems.YJNIUM_NUGGET.get());

        providerAccess.tag(YJItemTagsFabric.OLD_YAJUSENPAI_INGOTS)
                .addTag(YJItemTagsFabric.YAJUSENPAI_INGOTS);

        providerAccess.tag(YJItemTagsFabric.YAJUSENPAI_INGOTS)
                .add(YJItems.YAJUSENPAI_INGOT.get());

        providerAccess.tag(YJItemTagsFabric.OLD_YAJUSENPAI_NUGGETS)
                .addTag(YJItemTagsFabric.YAJUSENPAI_NUGGETS);

        providerAccess.tag(YJItemTagsFabric.YAJUSENPAI_NUGGETS)
                .add(YJItems.YAJUSENPAI_NUGGET.get());

        providerAccess.tag(YJItemTags.COMPAT_BLUE_DYE)
                .addVanillaTag(ConventionalItemTags.BLUE_DYES);

        providerAccess.tag(YJItemTags.COMPAT_GLOWSTONE)
                .addTag(YJItemTagsFabric.GLOWSTONE_BLOCKS);

        providerAccess.tag(YJItemTags.COMPAT_GREEN_DYE)
                .addVanillaTag(ConventionalItemTags.GREEN_DYES);

        providerAccess.tag(YJItemTags.COMPAT_IRON_INGOT)
                .addVanillaTag(ConventionalItemTags.IRON_INGOTS);

        providerAccess.tag(YJItemTags.COMPAT_NETHERITE_INGOT)
                .addVanillaTag(ConventionalItemTags.NETHERITE_INGOTS);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJNIUM)
                .addTag(YJItemTagsFabric.YJNIUM_RAW_MATERIALS);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJNIUM_BLOCK)
                .addTag(YJItemTagsFabric.STORAGE_BLOCKS_RAW_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YAJUSENPAI)
                .addTag(YJItemTagsFabric.YAJUSENPAI_RAW_MATERIALS);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YAJUSENPAI_BLOCK)
                .addTag(YJItemTagsFabric.STORAGE_BLOCKS_RAW_YAJUSENPAI);

        providerAccess.tag(YJItemTags.COMPAT_RED_DYE)
                .addVanillaTag(ConventionalItemTags.RED_DYES);

        providerAccess.tag(YJItemTags.COMPAT_TINTED_GLASS)
                .add(Items.TINTED_GLASS);

        providerAccess.tag(YJItemTags.COMPAT_WHEAT)
                .addTag(YJItemTagsFabric.WHEAT_CROPS);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_BLOCK)
                .addTag(YJItemTagsFabric.STORAGE_BLOCKS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_INGOT)
                .addTag(YJItemTagsFabric.YJNIUM_INGOTS);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_NUGGET)
                .addTag(YJItemTagsFabric.YJNIUM_NUGGETS);

        providerAccess.tag(YJItemTags.COMPAT_YAJUSENPAI_INGOT)
                .addTag(YJItemTagsFabric.YAJUSENPAI_INGOTS);

        providerAccess.tag(YJItemTags.COMPAT_YAJUSENPAI_NUGGET)
                .addTag(YJItemTagsFabric.YAJUSENPAI_NUGGETS);

        providerAccess.tag(YJItemTagsFabric.DRINKS)
                .addTags(ImmutableList.of(
                        YJItemTagsFabric.TEA,
                        YJItemTagsFabric.ICE_TEA,
                        YJItemTagsFabric.ICETEA,
                        YJItemTagsFabric.DRINKS_TEA,
                        YJItemTagsFabric.DRINKS_ICE_TEA,
                        YJItemTagsFabric.DRINKS_ICETEA
                ));

        providerAccess.tag(YJItemTagsFabric.TEA)
                .add(YJItems.ICE_TEA.get());
        providerAccess.tag(YJItemTagsFabric.ICE_TEA)
                .add(YJItems.ICE_TEA.get());
        providerAccess.tag(YJItemTagsFabric.ICETEA)
                .add(YJItems.ICE_TEA.get());
        providerAccess.tag(YJItemTagsFabric.DRINKS_TEA)
                .add(YJItems.ICE_TEA.get());
        providerAccess.tag(YJItemTagsFabric.DRINKS_ICE_TEA)
                .add(YJItems.ICE_TEA.get());
        providerAccess.tag(YJItemTagsFabric.DRINKS_ICETEA)
                .add(YJItems.ICE_TEA.get());

        providerAccess.tag(YJItemTagsFabric.FRUITS)
                .addTags(ImmutableList.of(
                        YJItemTagsFabric.APPLE,
                        YJItemTagsFabric.FRUITS_APPLE
                ));
        providerAccess.tag(YJItemTagsFabric.APPLE)
                .add(YJItems.APPLE_INM.get());
        providerAccess.tag(YJItemTagsFabric.FRUITS_APPLE)
                .add(YJItems.APPLE_INM.get());

        providerAccess.tag(YJItemTagsFabric.NETHER_STARS)
                .add(YJItems.YJ_STAR.get());

        providerAccess.tag(ConventionalItemTags.INGOTS)
                .addTags(ImmutableList.of(YJItemTagsFabric.YJNIUM_INGOTS, YJItemTagsFabric.YAJUSENPAI_INGOTS));

        providerAccess.tag(ConventionalItemTags.NUGGETS)
                .addTags(ImmutableList.of(YJItemTagsFabric.YJNIUM_NUGGETS, YJItemTagsFabric.YAJUSENPAI_NUGGETS));

        providerAccess.tag(ConventionalItemTags.MELEE_WEAPON_TOOLS)
                .add(YJItems.YJNIUM_SWORD.get(), YJItems.YAJUSENPAI_SWORD.get(), YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get());

        providerAccess.tag(ConventionalItemTags.TOOLS)
                .add(YJItems.SOFT_SMARTPHONE.get());
    }


    public static void generateBiomeTag(TagProviderWrapper.TagProviderAccess<Biome, TagProviderWrapper.TagAppenderWrapper<Biome>> providerAccess) {
        providerAccess.tag(YJBiomeTags.HAS_YJ_HOUSE)
                .addVanillaTag(ConventionalBiomeTags.IS_OVERWORLD)
                .addVanillaTag(ConventionalBiomeTags.IS_NETHER)
                .addVanillaTag(ConventionalBiomeTags.IS_OUTER_END_ISLAND);

        providerAccess.tag(ConventionalBiomeTags.IS_PLAINS)
                .add(YJBiomes.YAJUSENPAI_BIOME);
    }

    public static void generateDamageTypeTag(TagProviderWrapper.TagProviderAccess<DamageType, TagProviderWrapper.TagAppenderWrapper<DamageType>> providerAccess) {
    }
}
