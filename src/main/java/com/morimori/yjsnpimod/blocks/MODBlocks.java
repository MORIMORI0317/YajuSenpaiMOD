package com.morimori.yjsnpimod.blocks;

import com.morimori.yjsnpimod.Variable;
import com.morimori.yjsnpimod.effects.MODEffects;
import com.morimori.yjsnpimod.other.Sounds;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class MODBlocks {
    public static final Block PROLIFERATION_YJSNPI = new ProliferationBlock(Block.Properties.create(Material.CLAY, MaterialColor.BROWN).sound(Sounds.YJ).tickRandomly().hardnessAndResistance(1F, 10F)).setRegistryName(Variable.MODID,"proliferation_yjsnpi_block");
    public static final Block YJ_SNPAI_BLOCK = new Block(Block.Properties.create(Material.CLAY, MaterialColor.BROWN).sound(Sounds.YJ).hardnessAndResistance(1F, 10F)).setRegistryName(Variable.MODID,"yj_senpai_block");
    public static final Block BIG_PILLOW = new BigPillowBlock(Block.Properties.create(Material.WOOL, MaterialColor.WHITE_TERRACOTTA).sound(SoundType.CLOTH).hardnessAndResistance(1F, 10F)).setRegistryName(Variable.MODID,"big_pillow");
    public static final Block POTATO_SENPAI =  new IPotatoBlock(Block.Properties.create(Material.PLANTS).doesNotBlockMovement().tickRandomly().sound(Sounds.YJ)).setRegistryName(Variable.MODID,"potato_senpai");

    public static final Block YJ_ROSE = new YjRoseBlock(MODEffects.BEASTIFICATIO, Block.Properties.create(Material.CLAY, MaterialColor.BROWN).sound(Sounds.YJ).tickRandomly().hardnessAndResistance(0, 0).doesNotBlockMovement()).setRegistryName(Variable.MODID,"yj_rose");
    public static final Block POTTED_YJ_ROSE = new FlowerPotBlock(YJ_ROSE, Block.Properties.create(Material.MISCELLANEOUS)).setRegistryName(Variable.MODID,"potted_yj_rose");



}
