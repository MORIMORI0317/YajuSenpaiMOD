package net.morimori.yjsnpimod.block;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.item.YJCreativeModeTab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class YJBlocks {
    private static final Map<ResourceLocation, Item> MOD_ITEMS = new HashMap<>();
    private static final Map<ResourceLocation, Block> MOD_BLOCKS = new HashMap<>();
    public static final List<Block> ENDERMAN_BLOCKS = new ArrayList<>();

    public static final Block YJSNPI_INTERVIEW_BLOCK = register("yjsnpi_interview_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_GOMANETSU_BLOCK = register("yjsnpi_gomanetsu_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_ENNUI_BLOCK = register("yjsnpi_ennui_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_MEZIKARA_BLOCK = register("yjsnpi_mezikara_block", YJMaterial.YJSNPI, YJSoundType.MEZIKARA, 1f, 10f);
    public static final Block YJSNPI_NEHAN_BLOCK = register("yjsnpi_nehan_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_SHITARIGAO_BLOCK = register("yjsnpi_shitarigao_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_IKISUGI_BLOCK = register("yjsnpi_ikisugi_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_IMDKOJI_BLOCK = register("yjsnpi_imdkoji_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_KUNEKUNE_BLOCK = register("yjsnpi_kunekune_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);

    public static final Block TON_BLOCK = register("ton_block", YJMaterial.TON, YJSoundType.TON, 1f, 10f);
    public static final Block KMR_BLOCK = register("kmr_block", YJMaterial.KMR, YJSoundType.KMR, 1f, 10f);
    public static final Block MUR_BLOCK = register("mur_block", YJMaterial.MUR, YJSoundType.MUR, 1f, 10f);

    public static final Block BB = register("bb", Material.STONE, DyeColor.BLUE, SoundType.GLASS, 0.1f, 0f);
    public static final Block YJSNPI_EXPLODING_BLOCK = register("yjsnpi_exploding_block", new YJExplodingBlock(BlockBehaviour.Properties.of(YJMaterial.YJSNPI).sound(YJSoundType.YJ).strength(1f, 0f)));

    public static final Block YJNIUM_ORE = register("yjnium_ore", Material.STONE, SoundType.STONE, 3.0F, 3.0F);
    public static final Block YJNIUM_BLOCK = register("yjnium_block", Material.METAL, SoundType.METAL, 5.0F, 6.0F);

    public static final Block YJ_HOUSE_DOOR = register("yj_house_door", new YJHouseDoorBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 0).sound(SoundType.METAL).noOcclusion()));

    public static final Block YJ_SAND = register("yj_sand", new YJSandBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(YJSoundType.YJ_SAND).strength(0.5F)));


    private static Block register(String name, Material materialIn, DyeColor dyeColor, SoundType sound, float hardness, float resistance) {
        return register(name, new Block(BlockBehaviour.Properties.of(materialIn, dyeColor).sound(sound).strength(hardness, resistance)));
    }

    private static Block register(String name, Material materialIn, SoundType sound, float hardness, float resistance) {

        return register(name, new Block(BlockBehaviour.Properties.of(materialIn).sound(sound).strength(hardness, resistance)));
    }

    private static Block register(String name, Block block) {

        return register(name, block, n -> new BlockItem(n, new Item.Properties().tab(YJCreativeModeTab.MOD_TAB)));
    }

    private static Block register(String name, Block block, Function<Block, Item> item) {
        MOD_BLOCKS.put(new ResourceLocation(YJSNPIMOD.MODID, name), block);
        MOD_ITEMS.put(new ResourceLocation(YJSNPIMOD.MODID, name), item.apply(block));
        return block;
    }

    public static void init() {
        MOD_ITEMS.forEach((n, m) -> Registry.register(Registry.ITEM, n, m));
        MOD_BLOCKS.forEach((n, m) -> Registry.register(Registry.BLOCK, n, m));

        ENDERMAN_BLOCKS.add(YJSNPI_INTERVIEW_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_GOMANETSU_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_ENNUI_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_MEZIKARA_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_NEHAN_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_SHITARIGAO_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_IKISUGI_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_IMDKOJI_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_KUNEKUNE_BLOCK);
        ENDERMAN_BLOCKS.add(TON_BLOCK);
        ENDERMAN_BLOCKS.add(KMR_BLOCK);
        ENDERMAN_BLOCKS.add(MUR_BLOCK);
        ENDERMAN_BLOCKS.add(YJSNPI_EXPLODING_BLOCK);
    }

}
