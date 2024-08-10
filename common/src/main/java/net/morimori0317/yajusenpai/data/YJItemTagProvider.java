package net.morimori0317.yajusenpai.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.morimori0317.yajusenpai.block.YJBlockTags;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.BlockTagProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.ItemTagProviderWrapper;
import net.morimori0317.yajusenpai.explatform.data.YJDataExpectPlatform;
import net.morimori0317.yajusenpai.item.YJItemTags;
import net.morimori0317.yajusenpai.item.YJItems;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class YJItemTagProvider extends ItemTagProviderWrapper {
    public YJItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess, @NotNull BlockTagProviderWrapper blockTagProviderWrapper) {
        super(packOutput, lookup, crossDataGeneratorAccess, blockTagProviderWrapper);
    }

    @Override
    public void generateTag(ItemTagProviderAccess providerAccess) {
        providerAccess.tag(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(YJItems.YJNIUM_INGOT.get(), YJItems.YAJUSENPAI_INGOT.get());

        providerAccess.tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
                .add(YJItems.YJNIUM_PICKAXE.get(), YJItems.YAJUSENPAI_PICKAXE.get());

        providerAccess.tag(YJItemTags.KATYOU_BROKEN_ENCHANTABLE)
                .add(Items.WOLF_ARMOR)
                .addVanillaTag(ItemTags.DURABILITY_ENCHANTABLE);

        providerAccess.tag(YJItemTags.GABA_ANA_DADDY_ENCHANTABLE)
                .addVanillaTag(ItemTags.DURABILITY_ENCHANTABLE);

        providerAccess.tag(YJItemTags.KYN_ENCHANTABLE)
                .addVanillaTag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .addVanillaTag(ItemTags.SWORD_ENCHANTABLE)
                .addVanillaTag(ItemTags.WEAPON_ENCHANTABLE)
                .addVanillaTag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .addVanillaTag(ItemTags.MINING_ENCHANTABLE)
                .addVanillaTag(ItemTags.FISHING_ENCHANTABLE)
                .addVanillaTag(ItemTags.TRIDENT_ENCHANTABLE)
                .addVanillaTag(ItemTags.BOW_ENCHANTABLE)
                .addVanillaTag(ItemTags.CROSSBOW_ENCHANTABLE)
                .addVanillaTag(ItemTags.MACE_ENCHANTABLE);

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
        providerAccess.copy(YJBlockTags.YAJUSENPAI_BLOCK, YJItemTags.YAJUSENPAI_BLOCK);
        providerAccess.copy(YJBlockTags.YAJUSENPAI_ORES, YJItemTags.YAJUSENPAI_ORES);
        providerAccess.copy(YJBlockTags.GO_IS_GOD, YJItemTags.GO_IS_GOD);

        providerAccess.tag(ItemTags.AXES)
                .add(YJItems.YJNIUM_AXE.get(), YJItems.YAJUSENPAI_AXE.get());

        providerAccess.tag(ItemTags.HOES)
                .add(YJItems.YJNIUM_HOE.get(), YJItems.YAJUSENPAI_HOE.get());

        providerAccess.tag(ItemTags.PICKAXES)
                .add(YJItems.YJNIUM_PICKAXE.get(), YJItems.YAJUSENPAI_PICKAXE.get());

        providerAccess.tag(ItemTags.SHOVELS)
                .add(YJItems.YJNIUM_SHOVEL.get(), YJItems.YAJUSENPAI_SHOVEL.get());

        providerAccess.tag(ItemTags.SWORDS)
                .add(YJItems.YJNIUM_SWORD.get(), YJItems.YAJUSENPAI_SWORD.get(), YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get());

        providerAccess.tag(ItemTags.FOOT_ARMOR)
                .add(YJItems.YJNIUM_BOOTS.get(), YJItems.YAJUSENPAI_BOOTS.get());

        providerAccess.tag(ItemTags.LEG_ARMOR)
                .add(YJItems.YJNIUM_LEGGINGS.get(), YJItems.YAJUSENPAI_LEGGINGS.get(), YJItems.BRIEF.get(), YJItems.O_BACK.get());

        providerAccess.tag(ItemTags.CHEST_ARMOR)
                .add(YJItems.YJNIUM_CHESTPLATE.get(), YJItems.YAJUSENPAI_CHESTPLATE.get());

        providerAccess.tag(ItemTags.HEAD_ARMOR)
                .add(YJItems.YJNIUM_HELMET.get(), YJItems.YAJUSENPAI_HELMET.get(), YJItems.CYCLOPS_SUNGLASSES.get());

        providerAccess.tag(ItemTags.HORSE_FOOD)
                .add(YJItems.APPLE_INM.get());

        providerAccess.tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(YJItems.SOFT_SMARTPHONE.get());

        YJDataExpectPlatform.generateItemTag(providerAccess);
    }
}
