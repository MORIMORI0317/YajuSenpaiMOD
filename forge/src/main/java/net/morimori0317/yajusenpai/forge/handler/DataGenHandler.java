package net.morimori0317.yajusenpai.forge.handler;

import com.google.common.collect.ImmutableList;
import dev.felnull.otyacraftengine.data.provider.IntrinsicHolderTagsProviderWrapper;
import dev.felnull.otyacraftengine.data.provider.ItemTagProviderWrapper;
import dev.felnull.otyacraftengine.forge.data.CrossDataGeneratorAccesses;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.YajuSenpaiDataGenerator;
import net.morimori0317.yajusenpai.forge.block.YJBlockTagsForge;
import net.morimori0317.yajusenpai.forge.item.YJItemTagsForge;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.item.YJItems;

@Mod.EventBusSubscriber(modid = YajuSenpai.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenHandler {
    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        YajuSenpaiDataGenerator.init(CrossDataGeneratorAccesses.create(event));
    }

    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        providerAccess.tag(Tags.Blocks.COBBLESTONE_DEEPSLATE)
                .add(YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(Tags.Blocks.COBBLESTONE_NORMAL)
                .add(YJBlocks.YJ_STONE.get());

        providerAccess.tag(Tags.Blocks.ORE_BEARING_GROUND_DEEPSLATE)
                .add(YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(Tags.Blocks.ORE_BEARING_GROUND_STONE)
                .add(YJBlocks.YJ_STONE.get());

        providerAccess.tag(YJBlockTagsForge.ORES_YJNIUM)
                .addTag(YJBlockTags.YJNIUM_ORES);

        providerAccess.tag(YJBlockTagsForge.ORES_YJSNPI)
                .addTag(YJBlockTags.YJSNPI_ORES);

        providerAccess.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), YJBlocks.DEEPSLATE_YJSNPI_ORE.get());

        providerAccess.tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(YJBlocks.YJNIUM_ORE.get(), YJBlocks.YJSNPI_ORE.get());

        providerAccess.tag(YJBlockTagsForge.STORAGE_BLOCKS_RAW_YJNIUM)
                .add(YJBlocks.RAW_YJNIUM_BLOCK.get());

        providerAccess.tag(YJBlockTagsForge.STORAGE_BLOCKS_RAW_YJSNPI)
                .add(YJBlocks.RAW_YJSNPI_BLOCK.get());

        providerAccess.tag(YJBlockTagsForge.STORAGE_BLOCKS_YJNIUM)
                .add(YJBlocks.YJNIUM_BLOCK.get());

        providerAccess.tag(Tags.Blocks.GRAVEL)
                .add(YJBlocks.YJ_GRAVEL.get());

        providerAccess.tag(Tags.Blocks.ORES)
                .addTags(ImmutableList.of(YJBlockTagsForge.ORES_YJNIUM, YJBlockTagsForge.ORES_YJSNPI));

        providerAccess.tag(Tags.Blocks.SAND)
                .add(YJBlocks.YJ_SAND.get());

        providerAccess.tag(Tags.Blocks.STONE)
                .add(YJBlocks.YJ_STONE.get(), YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTags(ImmutableList.of(YJBlockTagsForge.STORAGE_BLOCKS_YJNIUM, YJBlockTagsForge.STORAGE_BLOCKS_RAW_YJNIUM, YJBlockTagsForge.STORAGE_BLOCKS_RAW_YJSNPI));
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        providerAccess.copy(Tags.Blocks.COBBLESTONE_DEEPSLATE, Tags.Items.COBBLESTONE_DEEPSLATE);
        providerAccess.copy(Tags.Blocks.COBBLESTONE_NORMAL, Tags.Items.COBBLESTONE_NORMAL);
        providerAccess.copy(Tags.Blocks.ORE_BEARING_GROUND_DEEPSLATE, Tags.Items.ORE_BEARING_GROUND_DEEPSLATE);
        providerAccess.copy(YJBlockTagsForge.ORES_YJNIUM, YJItemTagsForge.ORES_YJNIUM);
        providerAccess.copy(YJBlockTagsForge.ORES_YJSNPI, YJItemTagsForge.ORES_YJSNPI);
        providerAccess.copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);
        providerAccess.copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
        providerAccess.copy(YJBlockTagsForge.STORAGE_BLOCKS_RAW_YJNIUM, YJItemTagsForge.STORAGE_BLOCKS_RAW_YJNIUM);
        providerAccess.copy(YJBlockTagsForge.STORAGE_BLOCKS_RAW_YJSNPI, YJItemTagsForge.STORAGE_BLOCKS_RAW_YJSNPI);
        providerAccess.copy(YJBlockTagsForge.STORAGE_BLOCKS_YJNIUM, YJItemTagsForge.STORAGE_BLOCKS_YJNIUM);
        providerAccess.copy(Tags.Blocks.GRAVEL, Tags.Items.GRAVEL);
        providerAccess.copy(Tags.Blocks.ORES, Tags.Items.ORES);
        providerAccess.copy(Tags.Blocks.SAND, Tags.Items.SAND);
        providerAccess.copy(Tags.Blocks.STONE, Tags.Items.STONE);
        providerAccess.copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        providerAccess.tag(Tags.Items.CROPS_POTATO)
                .add(YJItems.POTATO_SENPAI.get());

        providerAccess.tag(YJItemTagsForge.CROPS_POTATO_SENPAI)
                .add(YJItems.POTATO_SENPAI.get());

        providerAccess.tag(YJItemTagsForge.INGOTS_YJNIUM)
                .add(YJItems.YJNIUM_INGOT.get());

        providerAccess.tag(YJItemTagsForge.INGOTS_YJSNPI)
                .add(YJItems.YJSNPI_INGOT.get());

        providerAccess.tag(YJItemTagsForge.NUGGETS_YJNIUM)
                .add(YJItems.YJNIUM_NUGGET.get());

        providerAccess.tag(YJItemTagsForge.NUGGETS_YJSNPI)
                .add(YJItems.YJSNPI_NUGGET.get());

        providerAccess.tag(YJItemTagsForge.RAW_MATERIALS_YJNIUM)
                .add(YJItems.RAW_YJNIUM.get());

        providerAccess.tag(YJItemTagsForge.RAW_MATERIALS_YJSNPI)
                .add(YJItems.RAW_YJSNPI.get());

        providerAccess.tag(Tags.Items.CROPS)
                .addTag(YJItemTagsForge.CROPS_POTATO_SENPAI);

        providerAccess.tag(Tags.Items.INGOTS)
                .addTags(ImmutableList.of(YJItemTagsForge.INGOTS_YJNIUM, YJItemTagsForge.INGOTS_YJSNPI));

        providerAccess.tag(Tags.Items.NETHER_STARS)
                .add(YJItems.YJ_STAR.get());

        providerAccess.tag(Tags.Items.NUGGETS)
                .addTags(ImmutableList.of(YJItemTagsForge.NUGGETS_YJNIUM, YJItemTagsForge.NUGGETS_YJSNPI));

        providerAccess.tag(Tags.Items.RAW_MATERIALS)
                .addTags(ImmutableList.of(YJItemTagsForge.RAW_MATERIALS_YJSNPI, YJItemTagsForge.RAW_MATERIALS_YJNIUM));


        providerAccess.tag(YJItemTags.COMPAT_BLUE_DYE)
                .addTag(Tags.Items.DYES_BLUE);

        providerAccess.tag(YJItemTags.COMPAT_GLOWSTONE)
                .add(Items.GLOWSTONE);

        providerAccess.tag(YJItemTags.COMPAT_GREEN_DYE)
                .addTag(Tags.Items.DYES_GREEN);

        providerAccess.tag(YJItemTags.COMPAT_IRON_INGOT)
                .addTag(Tags.Items.INGOTS_IRON);

        providerAccess.tag(YJItemTags.COMPAT_NETHERITE_INGOT)
                .addTag(Tags.Items.INGOTS_NETHERITE);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJNIUM)
                .addTag(YJItemTagsForge.RAW_MATERIALS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJNIUM_BLOCK)
                .addTag(YJItemTagsForge.STORAGE_BLOCKS_RAW_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJSNPI)
                .addTag(YJItemTagsForge.RAW_MATERIALS_YJSNPI);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJSNPI_BLOCK)
                .addTag(YJItemTagsForge.STORAGE_BLOCKS_RAW_YJSNPI);

        providerAccess.tag(YJItemTags.COMPAT_RED_DYE)
                .addTag(Tags.Items.DYES_RED);

        providerAccess.tag(YJItemTags.COMPAT_TINTED_GLASS)
                .addTag(Tags.Items.GLASS_TINTED);

        providerAccess.tag(YJItemTags.COMPAT_WHEAT)
                .addTag(Tags.Items.CROPS_WHEAT);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_BLOCK)
                .addTag(YJItemTagsForge.STORAGE_BLOCKS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_INGOT)
                .addTag(YJItemTagsForge.INGOTS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_NUGGET)
                .addTag(YJItemTagsForge.NUGGETS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_YJSNPI_INGOT)
                .addTag(YJItemTagsForge.INGOTS_YJSNPI);

        providerAccess.tag(YJItemTags.COMPAT_YJSNPI_NUGGET)
                .addTag(YJItemTagsForge.NUGGETS_YJSNPI);
    }
}
