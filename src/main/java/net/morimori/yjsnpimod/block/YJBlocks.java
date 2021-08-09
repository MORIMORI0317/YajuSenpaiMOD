package net.morimori.yjsnpimod.block;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.grower.YJTreeGrower;
import net.morimori.yjsnpimod.item.FoiledBlockItem;
import net.morimori.yjsnpimod.item.YJCreativeModeTab;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class YJBlocks {
    private static final List<BlockEntry> MOD_BLOCKS = new ArrayList<>();
    public static final List<Block> INM_BLOCKS = new ArrayList<>();

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
    public static final Block GB = register("gb", Material.STONE, DyeColor.GREEN, SoundType.GLASS, 0.1f, 0f);
    public static final Block YJSNPI_EXPLODING_BLOCK = registerFoiled("yjsnpi_exploding_block", new YJExplodingBlock(BlockBehaviour.Properties.of(YJMaterial.YJSNPI).sound(YJSoundType.YJ).strength(1f, 0f).lightLevel(value -> {
        float level = ((float) value.getValue(YJExplodingBlock.YJ_TIMER) % 14f) / 14;
        float alevel = Math.min(level, 1f - level) * 2f;
        return (int) (alevel * 16f) + 1;
    })));
    public static final Block YJSNPI_PROLIFERATION_BLOCK = registerFoiled("yjsnpi_proliferation_block", new YJProliferationBlock(BlockBehaviour.Properties.of(YJMaterial.YJSNPI).sound(YJSoundType.YJ).randomTicks().strength(1f, 0f)));
    public static final Block YJ_HOUSE_DOOR = register("yj_house_door", new YJHouseDoorBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 0).sound(SoundType.METAL).noOcclusion()));
    public static final Block YJ_PORTAL = register("yj_portal", new YJPortalBlock(BlockBehaviour.Properties.of(Material.PORTAL, MaterialColor.COLOR_BLACK).noCollission().lightLevel((blockStatex) -> 15).strength(-1.0F, 3600000.0F).noDrops()), null);

    public static final Block YJ_SAND = register("yj_sand", new YJSandBlock(BlockBehaviour.Properties.of(Material.SAND, MaterialColor.SAND).sound(YJSoundType.YJ_SAND).strength(0.5F)));
    public static final Block YJ_SAPLING = register("yj_sapling", new YJSaplingBlock(new YJTreeGrower(), BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.GRASS)));
    public static final Block YJ_LEAVES = register("yj_leaves", Blocks.leaves(YJSoundType.YJ_GRASS));
    public static final Block YJ_LOG = register("yj_log", new YJLogBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(YJSoundType.YJ_WOOD).strength(2)));
    public static final Block YJ_PLANKS = register("yj_planks", new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F, 3.0F).sound(YJSoundType.YJ_WOOD)));
    public static final Block YJ_SLAB = register("yj_slab", new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).strength(2.0F, 3.0F).sound(YJSoundType.YJ_WOOD)));
    public static final Block YJ_STAIRS = register("yj_stairs", new YJStairBlock(YJ_PLANKS.defaultBlockState(), BlockBehaviour.Properties.copy(YJ_PLANKS)));
    public static final Block YJ_GRASS = register("yj_grass", new YJTallGrassBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(YJSoundType.YJ_GRASS)));
    public static final Block TALL_YJ_GRASS = register("tall_yj_grass", new DoublePlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(YJSoundType.YJ_GRASS)), n -> new DoubleHighBlockItem(n, (new Item.Properties()).tab(YJCreativeModeTab.MOD_TAB)));
    public static final Block YJ_GRASS_BLOCK = register("yj_grass_block", new GrassBlock(BlockBehaviour.Properties.of(Material.GRASS).randomTicks().strength(0.6F).sound(YJSoundType.YJ_GRASS)));
    public static final Block YJ_ROSE = register("yj_rose", new FlowerBlock(MobEffects.POISON, 5, BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(YJSoundType.YJ_GRASS)));

    public static final Block YJNIUM_ORE = register("yjnium_ore", new OreBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final Block YJSNPI_ORE = register("yjsnpi_ore", new OreBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).sound(YJSoundType.YJ)));
    public static final Block DEEPSLATE_YJNIUM_ORE = register("deepslate_yjnium_ore", new OreBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final Block DEEPSLATE_YJSNPI_ORE = register("deepslate_yjsnpi_ore", new OreBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).sound(YJSoundType.YJ)));
    public static final Block YJNIUM_BLOCK = register("yjnium_block", Material.METAL, SoundType.METAL, 5.0F, 6.0F);
    public static final Block RAW_YJNIUM_BLOCK = register("raw_yjnium_block", Material.STONE, YJSoundType.STONE, 5.0F, 6.0F);
    public static final Block RAW_YJSNPI_BLOCK = register("raw_yjsnpi_block", Material.STONE, YJSoundType.YJ, 5.0F, 6.0F);

    public static final Block BIG_PILLOW = register("big_pillow", new BigPillowBlock(BlockBehaviour.Properties.of(Material.WOOL).sound(SoundType.WOOD).strength(0.2F).noOcclusion()));

    private static Block register(String name, Material materialIn, DyeColor dyeColor, SoundType sound, float hardness, float resistance) {

        return register(name, new Block(BlockBehaviour.Properties.of(materialIn, dyeColor).sound(sound).strength(hardness, resistance)));
    }

    private static Block register(String name, Material materialIn, SoundType sound, float hardness, float resistance) {
        return register(name, new Block(BlockBehaviour.Properties.of(materialIn).sound(sound).strength(hardness, resistance)));
    }

    private static Block registerFoiled(String name, Block block) {
        return register(name, block, n -> new FoiledBlockItem(n, new Item.Properties().tab(YJCreativeModeTab.MOD_TAB)));
    }

    private static Block register(String name, Block block) {
        return register(name, block, n -> new BlockItem(n, new Item.Properties().tab(YJCreativeModeTab.MOD_TAB)));
    }

    private static Block register(String name, Block block, Function<Block, Item> item) {
        MOD_BLOCKS.add(new BlockEntry(name, block, item == null ? null : item.apply(block)));
        return block;
    }

    public static void init() {
        MOD_BLOCKS.forEach(n -> {
            Registry.register(Registry.BLOCK, new ResourceLocation(YJSNPIMOD.MODID, n.name), n.block);
            if (n.blockitem != null)
                Registry.register(Registry.ITEM, new ResourceLocation(YJSNPIMOD.MODID, n.name), n.blockitem);
        });
        INM_BLOCKS.add(YJSNPI_INTERVIEW_BLOCK);
        INM_BLOCKS.add(YJSNPI_GOMANETSU_BLOCK);
        INM_BLOCKS.add(YJSNPI_ENNUI_BLOCK);
        INM_BLOCKS.add(YJSNPI_MEZIKARA_BLOCK);
        INM_BLOCKS.add(YJSNPI_NEHAN_BLOCK);
        INM_BLOCKS.add(YJSNPI_SHITARIGAO_BLOCK);
        INM_BLOCKS.add(YJSNPI_IKISUGI_BLOCK);
        INM_BLOCKS.add(YJSNPI_IMDKOJI_BLOCK);
        INM_BLOCKS.add(YJSNPI_KUNEKUNE_BLOCK);
        INM_BLOCKS.add(TON_BLOCK);
        INM_BLOCKS.add(KMR_BLOCK);
        INM_BLOCKS.add(MUR_BLOCK);
        INM_BLOCKS.add(YJSNPI_EXPLODING_BLOCK);
        INM_BLOCKS.add(YJSNPI_PROLIFERATION_BLOCK);
    }

    private static record BlockEntry(String name, Block block, Item blockitem) {

    }
}
