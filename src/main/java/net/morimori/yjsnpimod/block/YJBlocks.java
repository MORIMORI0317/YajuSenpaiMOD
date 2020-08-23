package net.morimori.yjsnpimod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.item.ProliferationBlockItem;
import net.morimori.yjsnpimod.item.ReferenceBlockItem;
import net.morimori.yjsnpimod.item.YJItemGroup;

import java.util.ArrayList;
import java.util.List;

public class YJBlocks {
    public static List<Block> MOD_BLOCKS = new ArrayList<Block>();
    public static List<Item> MOD_BLOCKITEMS = new ArrayList<Item>();

    public static final Block YJSNPI_INTERVIEW_BLOCK = register("yjsnpi_interview_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_GOMANETSU_BLOCK = register("yjsnpi_gomanetsu_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_ENNUI_BLOCK = register("yjsnpi_ennui_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_MEZIKARA_BLOCK = register("yjsnpi_mezikara_block", new MezikaraBlock(AbstractBlock.Properties.create(YJMaterial.YJSNPI).sound(YJSoundType.MEZIKARA).hardnessAndResistance(1, 10f)), "https://www.nicovideo.jp/watch/sm30519482");
    public static final Block YJSNPI_NEHAN_BLOCK = register("yjsnpi_nehan_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_SHITARIGAO_BLOCK = register("yjsnpi_shitarigao_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f, "https://www.nicovideo.jp/watch/sm22931530");
    public static final Block YJSNPI_IKISUGI_BLOCK = register("yjsnpi_ikisugi_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_IMDKOJI_BLOCK = register("yjsnpi_imdkoji_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_KUNEKUNE_BLOCK = register("yjsnpi_kunekune_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f, "https://www.nicovideo.jp/watch/sm25608032");
    public static final Block PROLIFERATION_YJSNPI_BLOCK = register("proliferation_yjsnpi_block", new ProliferationBlock(AbstractBlock.Properties.create(YJMaterial.YJSNPI).sound(YJSoundType.YJ).hardnessAndResistance(1, 10f), false, false, false), true);
    public static final Block IKISUGI_PROLIFERATION_YJSNPI_BLOCK = register("ikisugi_proliferation_yjsnpi_block", new ProliferationBlock(AbstractBlock.Properties.create(YJMaterial.YJSNPI).sound(YJSoundType.YJ).hardnessAndResistance(1, 10f), true, false, false), true);
    public static final Block GOMANETSU_PROLIFERATION_YJSNPI_BLOCK = register("gomanetsu_proliferation_yjsnpi_block", new ProliferationBlock(AbstractBlock.Properties.create(YJMaterial.YJSNPI).sound(YJSoundType.YJ).hardnessAndResistance(1, 10f), false, true, false), true);
    public static final Block ANTI_PROLIFERATION_YJSNPI_BLOCK = register("anti_proliferation_yjsnpi_block", new ProliferationBlock(AbstractBlock.Properties.create(YJMaterial.YJSNPI).sound(YJSoundType.YJ).hardnessAndResistance(1, 10f), false, false, true), true);
    public static final Block YJNIUM_ORE = register("yjnium_ore", Material.ROCK, SoundType.STONE, 3.0F, 3.0F);
    public static final Block YJNIUM_BLOCK = register("yjnium_block", Material.IRON, SoundType.METAL, 5.0F, 6.0F);
    public static final Block TOILET = register("toilet", new ToiletBlock(AbstractBlock.Properties.create(Material.IRON).func_235861_h_().notSolid().hardnessAndResistance(1.0F, 3.0F).sound(SoundType.METAL)));
    public static final Block BIG_PILLOW = register("big_pillow", new BigPillowBlock(AbstractBlock.Properties.create(Material.WOOL).func_235861_h_().notSolid().hardnessAndResistance(1.0F, 3.0F).sound(SoundType.SNOW)), "https://www.nicovideo.jp/watch/sm19360333");

    private static Block register(String name, Block block, boolean graw) {
        if (graw)
            return register(name, block, new ProliferationBlockItem(block, new Item.Properties().group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, name));
        else
            return register(name, block);
    }

    private static Block register(String name, Block block, String url) {
        return register(name, block, new ReferenceBlockItem(block, new Item.Properties().group(YJItemGroup.MOD_TAB), url).setRegistryName(YJSNPIMOD.MODID, name));
    }

    private static Block register(String name, Material materialIn, SoundType sound, float hardness, float resistance, String url) {
        Block block = new Block(AbstractBlock.Properties.create(materialIn).sound(sound).hardnessAndResistance(hardness, resistance));
        return register(name, block, new ReferenceBlockItem(block, new Item.Properties().group(YJItemGroup.MOD_TAB), url).setRegistryName(YJSNPIMOD.MODID, name));
    }

    private static Block register(String name, Material materialIn, SoundType sound, float hardness, float resistance) {
        return register(name, new Block(AbstractBlock.Properties.create(materialIn).sound(sound).hardnessAndResistance(hardness, resistance)));
    }

    private static Block register(String name, Block block) {
        return register(name, block, new BlockItem(block, new Item.Properties().group(YJItemGroup.MOD_TAB)).setRegistryName(YJSNPIMOD.MODID, name));
    }

    private static Block register(String name, Block block, Item blockitem) {
        MOD_BLOCKS.add(block.setRegistryName(YJSNPIMOD.MODID, name));
        MOD_BLOCKITEMS.add(blockitem);
        return block;
    }

}
