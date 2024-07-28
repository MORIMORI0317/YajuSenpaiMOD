package net.morimori0317.yajusenpai.neoforge.handler;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.YajuSenpaiDataGenerator;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.ItemTagProviderWrapper;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.neoforge.block.YJBlockTagsNeoForge;
import net.morimori0317.yajusenpai.neoforge.data.cross.CrossDataGeneratorAccesses;
import net.morimori0317.yajusenpai.neoforge.item.YJItemTagsNeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = YajuSenpai.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenHandler {
    @SubscribeEvent
    public static void onDataGen(GatherDataEvent event) {
        YajuSenpaiDataGenerator.init(CrossDataGeneratorAccesses.create(event));
    }

    public static void generateBlockTag(IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Block> providerAccess) {
        providerAccess.tag(Tags.Blocks.COBBLESTONES_DEEPSLATE)
                .add(YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(Tags.Blocks.COBBLESTONES_NORMAL)
                .add(YJBlocks.YJ_STONE.get());

        providerAccess.tag(Tags.Blocks.ORE_BEARING_GROUND_DEEPSLATE)
                .add(YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(Tags.Blocks.ORE_BEARING_GROUND_STONE)
                .add(YJBlocks.YJ_STONE.get());

        providerAccess.tag(YJBlockTagsNeoForge.ORES_YJNIUM)
                .addTag(YJBlockTags.YJNIUM_ORES);

        providerAccess.tag(YJBlockTagsNeoForge.ORES_YJSNPI)
                .addTag(YJBlockTags.YJSNPI_ORES);

        providerAccess.tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE)
                .add(YJBlocks.DEEPSLATE_YJNIUM_ORE.get(), YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get());

        providerAccess.tag(Tags.Blocks.ORES_IN_GROUND_STONE)
                .add(YJBlocks.YJNIUM_ORE.get(), YJBlocks.YAJUSENPAI_ORE.get());

        providerAccess.tag(YJBlockTagsNeoForge.STORAGE_BLOCKS_RAW_YJNIUM)
                .add(YJBlocks.RAW_YJNIUM_BLOCK.get());

        providerAccess.tag(YJBlockTagsNeoForge.STORAGE_BLOCKS_RAW_YJSNPI)
                .add(YJBlocks.RAW_YAJUSENPAI_BLOCK.get());

        providerAccess.tag(YJBlockTagsNeoForge.STORAGE_BLOCKS_YJNIUM)
                .add(YJBlocks.YJNIUM_BLOCK.get());

        providerAccess.tag(Tags.Blocks.GRAVELS)
                .add(YJBlocks.YJ_GRAVEL.get());

        providerAccess.tag(Tags.Blocks.ORES)
                .addTags(ImmutableList.of(YJBlockTagsNeoForge.ORES_YJNIUM, YJBlockTagsNeoForge.ORES_YJSNPI));

        providerAccess.tag(Tags.Blocks.SANDS)
                .add(YJBlocks.YJ_SAND.get());

        providerAccess.tag(Tags.Blocks.STONES)
                .add(YJBlocks.YJ_STONE.get(), YJBlocks.YJ_DEEPSLATE.get());

        providerAccess.tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTags(ImmutableList.of(YJBlockTagsNeoForge.STORAGE_BLOCKS_YJNIUM, YJBlockTagsNeoForge.STORAGE_BLOCKS_RAW_YJNIUM, YJBlockTagsNeoForge.STORAGE_BLOCKS_RAW_YJSNPI));
    }

    public static void generateItemTag(ItemTagProviderWrapper.ItemTagProviderAccess providerAccess) {
        providerAccess.copy(Tags.Blocks.COBBLESTONES_DEEPSLATE, Tags.Items.COBBLESTONES_DEEPSLATE);
        providerAccess.copy(Tags.Blocks.COBBLESTONES_NORMAL, Tags.Items.COBBLESTONES_NORMAL);
        providerAccess.copy(Tags.Blocks.ORE_BEARING_GROUND_DEEPSLATE, Tags.Items.ORE_BEARING_GROUND_DEEPSLATE);
        providerAccess.copy(YJBlockTagsNeoForge.ORES_YJNIUM, YJItemTagsNeoForge.ORES_YJNIUM);
        providerAccess.copy(YJBlockTagsNeoForge.ORES_YJSNPI, YJItemTagsNeoForge.ORES_YJSNPI);
        providerAccess.copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);
        providerAccess.copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
        providerAccess.copy(YJBlockTagsNeoForge.STORAGE_BLOCKS_RAW_YJNIUM, YJItemTagsNeoForge.STORAGE_BLOCKS_RAW_YJNIUM);
        providerAccess.copy(YJBlockTagsNeoForge.STORAGE_BLOCKS_RAW_YJSNPI, YJItemTagsNeoForge.STORAGE_BLOCKS_RAW_YJSNPI);
        providerAccess.copy(YJBlockTagsNeoForge.STORAGE_BLOCKS_YJNIUM, YJItemTagsNeoForge.STORAGE_BLOCKS_YJNIUM);
        providerAccess.copy(Tags.Blocks.GRAVELS, Tags.Items.GRAVELS);
        providerAccess.copy(Tags.Blocks.ORES, Tags.Items.ORES);
        providerAccess.copy(Tags.Blocks.SANDS, Tags.Items.SANDS);
        providerAccess.copy(Tags.Blocks.STONES, Tags.Items.STONES);
        providerAccess.copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        providerAccess.tag(Tags.Items.CROPS_POTATO)
                .add(YJItems.POTATO_SENPAI.get());

        providerAccess.tag(YJItemTagsNeoForge.CROPS_POTATO_SENPAI)
                .add(YJItems.POTATO_SENPAI.get());

        providerAccess.tag(YJItemTagsNeoForge.INGOTS_YJNIUM)
                .add(YJItems.YJNIUM_INGOT.get());

        providerAccess.tag(YJItemTagsNeoForge.INGOTS_YJSNPI)
                .add(YJItems.YAJUSENPAI_INGOT.get());

        providerAccess.tag(YJItemTagsNeoForge.NUGGETS_YJNIUM)
                .add(YJItems.YJNIUM_NUGGET.get());

        providerAccess.tag(YJItemTagsNeoForge.NUGGETS_YJSNPI)
                .add(YJItems.YAJUSENPAI_NUGGET.get());

        providerAccess.tag(YJItemTagsNeoForge.RAW_MATERIALS_YJNIUM)
                .add(YJItems.RAW_YJNIUM.get());

        providerAccess.tag(YJItemTagsNeoForge.RAW_MATERIALS_YJSNPI)
                .add(YJItems.RAW_YAJUSENPAI.get());

        providerAccess.tag(Tags.Items.CROPS)
                .addTag(YJItemTagsNeoForge.CROPS_POTATO_SENPAI);

        providerAccess.tag(Tags.Items.INGOTS)
                .addTags(ImmutableList.of(YJItemTagsNeoForge.INGOTS_YJNIUM, YJItemTagsNeoForge.INGOTS_YJSNPI));

        providerAccess.tag(Tags.Items.NETHER_STARS)
                .add(YJItems.YJ_STAR.get());

        providerAccess.tag(Tags.Items.NUGGETS)
                .addTags(ImmutableList.of(YJItemTagsNeoForge.NUGGETS_YJNIUM, YJItemTagsNeoForge.NUGGETS_YJSNPI));

        providerAccess.tag(Tags.Items.RAW_MATERIALS)
                .addTags(ImmutableList.of(YJItemTagsNeoForge.RAW_MATERIALS_YJSNPI, YJItemTagsNeoForge.RAW_MATERIALS_YJNIUM));


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
                .addTag(YJItemTagsNeoForge.RAW_MATERIALS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJNIUM_BLOCK)
                .addTag(YJItemTagsNeoForge.STORAGE_BLOCKS_RAW_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJSNPI)
                .addTag(YJItemTagsNeoForge.RAW_MATERIALS_YJSNPI);

        providerAccess.tag(YJItemTags.COMPAT_RAW_YJSNPI_BLOCK)
                .addTag(YJItemTagsNeoForge.STORAGE_BLOCKS_RAW_YJSNPI);

        providerAccess.tag(YJItemTags.COMPAT_RED_DYE)
                .addTag(Tags.Items.DYES_RED);

        providerAccess.tag(YJItemTags.COMPAT_TINTED_GLASS)
                .addTag(Tags.Items.GLASS_BLOCKS_TINTED);

        providerAccess.tag(YJItemTags.COMPAT_WHEAT)
                .addTag(Tags.Items.CROPS_WHEAT);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_BLOCK)
                .addTag(YJItemTagsNeoForge.STORAGE_BLOCKS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_INGOT)
                .addTag(YJItemTagsNeoForge.INGOTS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_YJNIUM_NUGGET)
                .addTag(YJItemTagsNeoForge.NUGGETS_YJNIUM);

        providerAccess.tag(YJItemTags.COMPAT_YJSNPI_INGOT)
                .addTag(YJItemTagsNeoForge.INGOTS_YJSNPI);

        providerAccess.tag(YJItemTags.COMPAT_YJSNPI_NUGGET)
                .addTag(YJItemTagsNeoForge.NUGGETS_YJSNPI);
    }
}