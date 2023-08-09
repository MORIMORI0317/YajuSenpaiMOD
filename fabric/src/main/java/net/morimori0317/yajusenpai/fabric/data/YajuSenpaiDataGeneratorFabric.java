package net.morimori0317.yajusenpai.fabric.data;

import com.google.common.collect.ImmutableList;
import dev.felnull.otyacraftengine.data.provider.IntrinsicHolderTagsProviderWrapper;
import dev.felnull.otyacraftengine.data.provider.ItemTagProviderWrapper;
import dev.felnull.otyacraftengine.fabric.data.CrossDataGeneratorAccesses;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.YajuSenpaiDataGenerator;
import net.morimori0317.yajusenpai.fabric.item.YJItemTagsFabric;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.item.YJItems;

import java.util.Arrays;

public class YajuSenpaiDataGeneratorFabric implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        YajuSenpaiDataGenerator.init(CrossDataGeneratorAccesses.create(fabricDataGenerator));
    }

    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        providerAccess.tag(ConventionalBlockTags.ORES)
                .addTags(ImmutableList.of(YJBlockTags.YJNIUM_ORES, YJBlockTags.YJSNPI_ORES));
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        providerAccess.copy(ConventionalBlockTags.ORES, ConventionalItemTags.ORES);

        providerAccess.tag(ConventionalItemTags.FOODS)
                .add(YJItems.APPLE.get(), YJItems.ICE_TEA.get(), YJItems.POTATO_SENPAI.get(), YJItems.BAKED_POTATO_SENPAI.get());

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
                .add(YJItems.RAW_YJSNPI.get());

        providerAccess.tag(YJItemTagsFabric.RAW_YJSNPI_BLOCKS)
                .add(YJBlocks.RAW_YJSNPI_BLOCK.get().asItem());

        providerAccess.tag(YJItemTagsFabric.WHEAT_CROPS)
                .add(Items.WHEAT);

        providerAccess.tag(YJItemTagsFabric.YJNIUM_BLOCKS)
                .add(YJBlocks.YJNIUM_BLOCK.get().asItem());

        providerAccess.tag(YJItemTagsFabric.YJNIUM_INGOTS)
                .add(YJItems.YJNIUM_INGOT.get());

        providerAccess.tag(YJItemTagsFabric.YJNIUM_NUGGETS)
                .add(YJItems.YJNIUM_NUGGET.get());

        providerAccess.tag(YJItemTagsFabric.YJSNPI_INGOTS)
                .add(YJItems.YJSNPI_INGOT.get());

        providerAccess.tag(YJItemTagsFabric.YJSNPI_NUGGETS)
                .add(YJItems.YJSNPI_NUGGET.get());

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
}
