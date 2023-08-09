package net.morimori0317.yajusenpai.data;

import dev.felnull.otyacraftengine.data.CrossDataGeneratorAccess;
import dev.felnull.otyacraftengine.data.provider.BlockTagProviderWrapper;
import dev.felnull.otyacraftengine.data.provider.ItemTagProviderWrapper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.explatform.data.YJDataExpectPlatform;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.item.YJItems;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class YJItemTagProviderWrapper extends ItemTagProviderWrapper {
    public YJItemTagProviderWrapper(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, @NotNull BlockTagProviderWrapper blockTagProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess, blockTagProviderWrapper);
    }

    @Override
    public void generateTag(ItemTagProviderAccess providerAccess) {
        providerAccess.tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(YJItems.YJNIUM_INGOT.get(), YJItems.YJSNPI_INGOT.get());

        providerAccess.tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .add(YJItems.YJNIUM_PICKAXE.get(), YJItems.YJSNPI_PICKAXE.get());

        providerAccess.copy(BlockTags.DIRT, ItemTags.DIRT);
        providerAccess.copy(BlockTags.DOORS, ItemTags.DOORS);
        providerAccess.copy(BlockTags.LEAVES, ItemTags.LEAVES);
        providerAccess.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        providerAccess.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        providerAccess.copy(BlockTags.SAND, ItemTags.SAND);
        providerAccess.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
        providerAccess.copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

        providerAccess.tag(ItemTags.STONE_CRAFTING_MATERIALS)
                .add(YJBlocks.YJ_STONE.get().asItem(), YJBlocks.YJ_DEEPSLATE.get().asItem());

        providerAccess.tag(ItemTags.STONE_TOOL_MATERIALS)
                .add(YJBlocks.YJ_STONE.get().asItem(), YJBlocks.YJ_DEEPSLATE.get().asItem());

        providerAccess.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        providerAccess.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);

        providerAccess.copy(YJBlockTags.INM_BLOCK, YJItemTags.INM_BLOCK);
        providerAccess.copy(YJBlockTags.YJ_LOGS, YJItemTags.YJ_LOGS);
        providerAccess.copy(YJBlockTags.YJNIUM_ORES, YJItemTags.YJNIUM_ORES);
        providerAccess.copy(YJBlockTags.YJSNPI_BLOCK, YJItemTags.YJSNPI_BLOCK);
        providerAccess.copy(YJBlockTags.YJSNPI_ORES, YJItemTags.YJSNPI_ORES);

        providerAccess.tag(ItemTags.AXES)
                .add(YJItems.YJNIUM_AXE.get(), YJItems.YJSNPI_AXE.get());

        providerAccess.tag(ItemTags.HOES)
                .add(YJItems.YJNIUM_HOE.get(), YJItems.YJSNPI_HOE.get());

        providerAccess.tag(ItemTags.PICKAXES)
                .add(YJItems.YJNIUM_PICKAXE.get(), YJItems.YJSNPI_PICKAXE.get());

        providerAccess.tag(ItemTags.SHOVELS)
                .add(YJItems.YJNIUM_SHOVEL.get(), YJItems.YJSNPI_SHOVEL.get());

        providerAccess.tag(ItemTags.SWORDS)
                .add(YJItems.YJNIUM_SWORD.get(), YJItems.YJSNPI_SWORD.get(), YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get());

        YJDataExpectPlatform.generateItemTag(providerAccess);
    }
}
