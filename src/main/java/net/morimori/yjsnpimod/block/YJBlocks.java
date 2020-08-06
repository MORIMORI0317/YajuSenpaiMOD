package net.morimori.yjsnpimod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.item.ProliferationBlockItem;
import net.morimori.yjsnpimod.item.YJItemGroup;

public class YJBlocks {

    public static final Block YJSNPI_INTERVIEW_BLOCK = newBlock("yjsnpi_interview_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_GOMANETSU_BLOCK = newBlock("yjsnpi_gomanetsu_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_ENNUI_BLOCK = newBlock("yjsnpi_ennui_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_MEZIKARA_BLOCK = newBlock("yjsnpi_mezikara_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_NEHAN_BLOCK = newBlock("yjsnpi_nehan_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_SHITARIGAO_BLOCK = newBlock("yjsnpi_shitarigao_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_IKISUGI_BLOCK = newBlock("yjsnpi_ikisugi_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_IMDKOJI_BLOCK = newBlock("yjsnpi_imdkoji_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_KUNEKUNE_BLOCK = newBlock("yjsnpi_kunekune_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);

    public static final Block PROLIFERATION_YJSNPI_BLOCK = new ProliferationBlock(AbstractBlock.Properties.create(YJMaterial.YJSNPI).sound(YJSoundType.YJ).hardnessAndResistance(1, 10f), false, false).setRegistryName(YJSNPIMOD.MODID, "proliferation_yjsnpi_block");
    public static final Block IKISUGI_PROLIFERATION_YJSNPI_BLOCK = new ProliferationBlock(AbstractBlock.Properties.create(YJMaterial.YJSNPI).sound(YJSoundType.YJ).hardnessAndResistance(1, 10f), true, false).setRegistryName(YJSNPIMOD.MODID, "ikisugi_proliferation_yjsnpi_block");
    public static final Block GOMANETSU_PROLIFERATION_YJSNPI_BLOCK = new ProliferationBlock(AbstractBlock.Properties.create(YJMaterial.YJSNPI).sound(YJSoundType.YJ).hardnessAndResistance(1, 10f), false, true).setRegistryName(YJSNPIMOD.MODID, "gomanetsu_proliferation_yjsnpi_block");

    public static final Block YJNIUM_ORE = new Block(AbstractBlock.Properties.create(YJMaterial.YJSNPI).func_235861_h_().hardnessAndResistance(3.0F, 3.0F).sound(SoundType.STONE)).setRegistryName("yjnium_ore");
    public static final Block YJNIUM_BLOCK = new Block(AbstractBlock.Properties.create(YJMaterial.YJSNPI).func_235861_h_().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)).setRegistryName("yjnium_block");

    public static void registerBlock(IForgeRegistry<Block> r) {
        registryBlock(r, YJSNPI_INTERVIEW_BLOCK);
        registryBlock(r, YJSNPI_GOMANETSU_BLOCK);
        registryBlock(r, YJSNPI_ENNUI_BLOCK);
        registryBlock(r, YJSNPI_MEZIKARA_BLOCK);
        registryBlock(r, YJSNPI_NEHAN_BLOCK);
        registryBlock(r, YJSNPI_SHITARIGAO_BLOCK);
        registryBlock(r, YJSNPI_IKISUGI_BLOCK);
        registryBlock(r, YJSNPI_IMDKOJI_BLOCK);
        registryBlock(r, YJSNPI_KUNEKUNE_BLOCK);

        registryBlock(r, PROLIFERATION_YJSNPI_BLOCK);
        registryBlock(r, IKISUGI_PROLIFERATION_YJSNPI_BLOCK);
        registryBlock(r, GOMANETSU_PROLIFERATION_YJSNPI_BLOCK);

        registryBlock(r, YJNIUM_ORE);
        registryBlock(r, YJNIUM_BLOCK);
    }

    public static void registerItem(IForgeRegistry<Item> r) {
        registryBlockItem(r, YJSNPI_INTERVIEW_BLOCK);
        registryBlockItem(r, YJSNPI_GOMANETSU_BLOCK);
        registryBlockItem(r, YJSNPI_ENNUI_BLOCK);
        registryBlockItem(r, YJSNPI_MEZIKARA_BLOCK);
        registryBlockItem(r, YJSNPI_NEHAN_BLOCK);
        registryBlockItem(r, YJSNPI_SHITARIGAO_BLOCK);
        registryBlockItem(r, YJSNPI_IKISUGI_BLOCK);
        registryBlockItem(r, YJSNPI_IMDKOJI_BLOCK);
        registryBlockItem(r, YJSNPI_KUNEKUNE_BLOCK);

        r.register(new ProliferationBlockItem(PROLIFERATION_YJSNPI_BLOCK, new Item.Properties().group(YJItemGroup.MOD_TAB)).setRegistryName(PROLIFERATION_YJSNPI_BLOCK.getRegistryName()));
        r.register(new ProliferationBlockItem(IKISUGI_PROLIFERATION_YJSNPI_BLOCK, new Item.Properties().group(YJItemGroup.MOD_TAB)).setRegistryName(IKISUGI_PROLIFERATION_YJSNPI_BLOCK.getRegistryName()));
        r.register(new ProliferationBlockItem(GOMANETSU_PROLIFERATION_YJSNPI_BLOCK, new Item.Properties().group(YJItemGroup.MOD_TAB)).setRegistryName(GOMANETSU_PROLIFERATION_YJSNPI_BLOCK.getRegistryName()));

        registryBlockItem(r, YJNIUM_ORE);
        registryBlockItem(r, YJNIUM_BLOCK);
    }

    private static Block newBlock(String name, Material materialIn, SoundType sound, float hardness, float resistance) {
        return new Block(AbstractBlock.Properties.create(materialIn).sound(sound).hardnessAndResistance(hardness, resistance))
                .setRegistryName(YJSNPIMOD.MODID, name);
    }

    private static void registryBlock(IForgeRegistry<Block> r, Block b) {
        r.register(b);
    }

    private static void registryBlockItem(IForgeRegistry<Item> r, Block b) {
        r.register(new BlockItem(b, new Item.Properties().group(YJItemGroup.MOD_TAB)).setRegistryName(b.getRegistryName()));
    }

}
