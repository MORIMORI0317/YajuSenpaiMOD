package com.morimori.yjsnpimod.items;

import com.morimori.yjsnpimod.Variable;
import com.morimori.yjsnpimod.blocks.MODBlocks;
import com.morimori.yjsnpimod.other.MODItemGroups;
import com.morimori.yjsnpimod.other.MODItemTier;
import com.morimori.yjsnpimod.other.Sounds;

import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Foods;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Rarity;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SimpleFoiledItem;
import net.minecraft.item.SwordItem;

public class MODItems {
    public static final Item YJINTERVEW_RECORD = new IMusicDiscItem(810, Sounds.yjinevent, new Item.Properties().group(MODItemGroups.YJ_TAB).maxStackSize(1)).setRegistryName(Variable.MODID,"record_yjin");
    public static final Item YONSYOU_RECORD = new IMusicDiscItem(114514, Sounds.yonsyouevent, new Item.Properties().group(MODItemGroups.YJ_TAB).maxStackSize(1)).setRegistryName(Variable.MODID,"record_yonsyou");
    public static final Item SANSYOU_RECORD = new IMusicDiscItem(364364, Sounds.karatebuevent, new Item.Properties().group(MODItemGroups.YJ_TAB).maxStackSize(1)).setRegistryName(Variable.MODID,"record_karatebu");
    public static final Item CYCLOPS_RECORD = new IMusicDiscItem(931, Sounds.cyclopssnpievent, new Item.Properties().group(MODItemGroups.YJ_TAB).maxStackSize(1)).setRegistryName(Variable.MODID,"record_cyclops");
    public static final Item YJ_CORE = new Item(new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"yj_core");
    public static final Item DIAMOND_SENPAI = new Item(new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"diamond_senpai");
    public static final Item DIAMOND_SENPAI_SWORD =  new SwordItem(MODItemTier.DIAMOND_SENPAI, 3, -2.4F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"diamond_senpai_sword");
    public static final Item DIAMOND_SENPAI_AXE =  new AxeItem(MODItemTier.DIAMOND_SENPAI, 5.0F, -3.0F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"diamond_senpai_axe");
    public static final Item DIAMOND_SENPAI_PICKAXE =  new PickaxeItem(MODItemTier.DIAMOND_SENPAI, 1, -2.8F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"diamond_senpai_pickaxe");
    public static final Item DIAMOND_SENPAI_SHOVEL =  new ShovelItem(MODItemTier.DIAMOND_SENPAI, 1.5F, -3.0F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"diamond_senpai_shovel");
    public static final Item DIAMOND_SENPAI_HOE =  new HoeItem(MODItemTier.DIAMOND_SENPAI, 0, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"diamond_senpai_hoe");
    public static final Item POTATO_SENPAI = new BlockNamedItem(MODBlocks.POTATO_SENPAI, (new Item.Properties()).group(MODItemGroups.YJ_TAB).food(Foods.POTATO)).setRegistryName(Variable.MODID,"potato_senpai");
    public static final Item INFINITY_SENPAI_CATALYST = new SimpleFoiledItem(new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"infinity_senpai_catalyst");
    public static final Item INFINITY_SENPAI_INGOT = new SimpleFoiledItem(new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"infinity_senpai_ingot");
    public static final Item YJ_INGOT = new Item(new Item.Properties().group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"yj_ingot");
    public static final Item YJ_SWORD =  new YjSwordItem(MODItemTier.YJ, 1, -2.4F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"yj_sword");
    public static final Item YJ_AXE =  new AxeItem(MODItemTier.YJ, 3.0F, -3.0F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"yj_axe");
    public static final Item YJ_PICKAXE =  new PickaxeItem(MODItemTier.YJ, -1, -2.8F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"yj_pickaxe");
    public static final Item YJ_SHOVEL =  new ShovelItem(MODItemTier.YJ, -0.5F, -3.0F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"yj_shovel");
    public static final Item YJ_HOE =  new HoeItem(MODItemTier.YJ, 810, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"yj_hoe");
    public static final Item INFINITY_SENPAI_SWORD =  new InfinitySwordItem(MODItemTier.INFINITY_SENPAI, 1, -2.4F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"infinity_senpai_sword");
    public static final Item INFINITY_SENPAI_AXE =  new AxeItem(MODItemTier.INFINITY_SENPAI, 3.0F, -3.0F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"infinity_senpai_axe");
    public static final Item INFINITY_SENPAI_PICKAXE =  new PickaxeItem(MODItemTier.INFINITY_SENPAI, -1, -2.8F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"infinity_senpai_pickaxe");
    public static final Item INFINITY_SENPAI_SHOVEL =  new ShovelItem(MODItemTier.INFINITY_SENPAI, -0.5F, -3.0F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"infinity_senpai_shovel");
    public static final Item INFINITY_SENPAI_HOE =  new HoeItem(MODItemTier.INFINITY_SENPAI, 806, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"infinity_senpai_hoe");
    public static final Item YJ_STAR = new SimpleFoiledItem(new Item.Properties().group(MODItemGroups.YJ_TAB).rarity(Rarity.UNCOMMON)).setRegistryName(Variable.MODID,"yj_star");
    public static final Item BAKED_POTATO_SENPAI = new Item(new Item.Properties().group(MODItemGroups.YJ_TAB).food(Foods.BAKED_POTATO)).setRegistryName(Variable.MODID,"baked_potato_senpai");
    public static final Item SOFT_SMARTPHONE = new SoftSwordItem(new Item.Properties().group(MODItemGroups.YJ_TAB).maxDamage(19)).setRegistryName(Variable.MODID,"soft_smartphone");
    public static final Item JAKEN_YORUIKIMASYOUNE =  new JakenSwordItem(MODItemTier.YJ, 16, 806F, (new Item.Properties()).group(MODItemGroups.YJ_TAB)).setRegistryName(Variable.MODID,"jaken_yoruikimasyoune_sword");
    public static final Item JAKEN_YORUIKIMASYOU =  new JakenShieldItem((new Item.Properties()).group(MODItemGroups.YJ_TAB).maxStackSize(1)).setRegistryName(Variable.MODID,"jaken_yoruikimasyou_shield");




}
