package net.morimori0317.yajusenpai.fabric.data;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.RegistrySetBuilder;
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
                .addTags(ImmutableList.of(YJBlockTags.YJNIUM_ORES, YJBlockTags.YJSNPI_ORES));
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        providerAccess.copy(ConventionalBlockTags.ORES, ConventionalItemTags.ORES);

        providerAccess.tag(ConventionalItemTags.FOODS)
                .add(YJItems.APPLE_INM.get(), YJItems.ICE_TEA.get(), YJItems.POTATO_SENPAI.get(), YJItems.BAKED_POTATO_SENPAI.get());

        providerAccess.tag(YJItemTagsFabric.GLOWSTONE_BLOCKS)
                .add(Items.GLOWSTONE);

        providerAccess.tag(YJItemTagsFabric.IRON_INGOTS)
                .add(Items.IRON_INGOT);

        providerAccess.tag(YJItemTagsFabric.NETHERITE_INGOTS)
                .add(Items.NETHERITE_INGOT);

        providerAccess.tag(YJItemTagsFabric.RAW_YJNIUM_ORES)
                .add(YJItems.RAW_YJNIUM.get());

        providerAccess.tag(YJItemTagsFabric.RAW_YJNIUM_BLOCKS)
                .add(YJBlocks.RAW_YJNIUM_BLOCK.get().asItem());

        providerAccess.tag(YJItemTagsFabric.RAW_YJSNPI_ORES)
                .add(YJItems.RAW_YAJUSENPAI.get());

        providerAccess.tag(YJItemTagsFabric.RAW_YJSNPI_BLOCKS)
                .add(YJBlocks.RAW_YAJUSENPAI_BLOCK.get().asItem());

        providerAccess.tag(YJItemTagsFabric.WHEAT_CROPS)
                .add(Items.WHEAT);

        providerAccess.tag(YJItemTagsFabric.YJNIUM_BLOCKS)
                .add(YJBlocks.YJNIUM_BLOCK.get().asItem());

        providerAccess.tag(YJItemTagsFabric.YJNIUM_INGOTS)
                .add(YJItems.YJNIUM_INGOT.get());

        providerAccess.tag(YJItemTagsFabric.YJNIUM_NUGGETS)
                .add(YJItems.YJNIUM_NUGGET.get());

        providerAccess.tag(YJItemTagsFabric.YJSNPI_INGOTS)
                .add(YJItems.YAJUSENPAI_INGOT.get());

        providerAccess.tag(YJItemTagsFabric.YJSNPI_NUGGETS)
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
                .addTag(YJItemTagsFabric.RAW_YJNIUM_ORES);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJNIUM_BLOCK)
                .addTag(YJItemTagsFabric.RAW_YJNIUM_BLOCKS);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJSNPI)
                .addTag(YJItemTagsFabric.RAW_YJSNPI_ORES);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJSNPI_BLOCK)
                .addTag(YJItemTagsFabric.RAW_YJSNPI_BLOCKS);

        providerAccess.tag(YJItemTags.COMPAT_RED_DYE)
                .addVanillaTag(ConventionalItemTags.RED_DYES);

        providerAccess.tag(YJItemTags.COMPAT_TINTED_GLASS)
                .add(Items.TINTED_GLASS);

        providerAccess.tag(YJItemTags.COMPAT_WHEAT)
                .addTag(YJItemTagsFabric.WHEAT_CROPS);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_BLOCK)
                .addTag(YJItemTagsFabric.YJNIUM_BLOCKS);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_INGOT)
                .addTag(YJItemTagsFabric.YJNIUM_INGOTS);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_NUGGET)
                .addTag(YJItemTagsFabric.YJNIUM_NUGGETS);

        providerAccess.tag(YJItemTags.COMPAT_YJSNPI_INGOT)
                .addTag(YJItemTagsFabric.YJSNPI_INGOTS);

        providerAccess.tag(YJItemTags.COMPAT_YJSNPI_NUGGET)
                .addTag(YJItemTagsFabric.YJSNPI_NUGGETS);
    }


    public static void generateBiomeTag(TagProviderWrapper.TagProviderAccess<Biome, TagProviderWrapper.TagAppenderWrapper<Biome>> providerAccess) {
        providerAccess.tag(YJBiomeTags.HAS_YJ_HOUSE)
                .addVanillaTag(ConventionalBiomeTags.IS_OVERWORLD)
                .addVanillaTag(ConventionalBiomeTags.IS_NETHER)
                .addVanillaTag(ConventionalBiomeTags.IS_OUTER_END_ISLAND);

        providerAccess.tag(ConventionalBiomeTags.IS_PLAINS)
                .add(YJBiomes.YAJUSENPAI_BIOME);
    }
}
