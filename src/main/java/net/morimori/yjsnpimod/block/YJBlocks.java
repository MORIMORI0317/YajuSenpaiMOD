package net.morimori.yjsnpimod.block;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.item.YJCreativeModeTab;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class YJBlocks {
    private static final Map<ResourceLocation, Item> MOD_ITEMS = new HashMap<>();
    private static final Map<ResourceLocation, Block> MOD_BLOCKS = new HashMap<>();

    public static final Block YJSNPI_INTERVIEW_BLOCK = register("yjsnpi_interview_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_GOMANETSU_BLOCK = register("yjsnpi_gomanetsu_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_ENNUI_BLOCK = register("yjsnpi_ennui_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_MEZIKARA_BLOCK = register("yjsnpi_mezikara_block", YJMaterial.YJSNPI, YJSoundType.MEZIKARA, 1f, 10f);
    public static final Block YJSNPI_NEHAN_BLOCK = register("yjsnpi_nehan_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_SHITARIGAO_BLOCK = register("yjsnpi_shitarigao_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_IKISUGI_BLOCK = register("yjsnpi_ikisugi_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_IMDKOJI_BLOCK = register("yjsnpi_imdkoji_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);
    public static final Block YJSNPI_KUNEKUNE_BLOCK = register("yjsnpi_kunekune_block", YJMaterial.YJSNPI, YJSoundType.YJ, 1f, 10f);

    public static final Block YJNIUM_ORE = register("yjnium_ore", Material.STONE, SoundType.STONE, 3.0F, 3.0F);
    public static final Block YJNIUM_BLOCK = register("yjnium_block", Material.METAL, SoundType.METAL, 5.0F, 6.0F);

    public static final Block YJ_HOUSE_DOOR = register("yj_house_door", new YJHouseDoorBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion()));

    public static final Block YJ_SAND = register("yj_sand", new YJSandBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(YJSoundType.YJ_SAND).strength(0.5F)));

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
    }

}
