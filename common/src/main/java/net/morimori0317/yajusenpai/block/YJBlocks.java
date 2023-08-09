package net.morimori0317.yajusenpai.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.block.grower.YJTreeGrower;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.explatform.YJExpectPlatform;
import net.morimori0317.yajusenpai.item.FoiledBlockItem;
import net.morimori0317.yajusenpai.item.YJCreativeModeTabs;
import net.morimori0317.yajusenpai.item.YJItems;

import java.util.function.Function;
import java.util.function.Supplier;

public class YJBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(YajuSenpai.MODID, Registries.BLOCK);
    private static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(YajuSenpai.MODID, Registries.ITEM);

    public static final RegistrySupplier<Block> YJSNPI_INTERVIEW_BLOCK = register("yjsnpi_interview_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YJSNPI_GOMANETSU_BLOCK = register("yjsnpi_gomanetsu_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YJSNPI_ENNUI_BLOCK = register("yjsnpi_ennui_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YJSNPI_MEZIKARA_BLOCK = register("yjsnpi_mezikara_block", () -> new MezikaraBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(YJSoundType.MEZIKARA.get()).strength(1f, 10f)));
    public static final RegistrySupplier<Block> YJSNPI_NEHAN_BLOCK = register("yjsnpi_nehan_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YJSNPI_SHITARIGAO_BLOCK = register("yjsnpi_shitarigao_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BLUE));
    public static final RegistrySupplier<Block> YJSNPI_IKISUGI_BLOCK = register("yjsnpi_ikisugi_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YJSNPI_IMDKUJ_BLOCK = register("yjsnpi_imdkuj_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_RED));
    public static final RegistrySupplier<Block> YJSNPI_KUNEKUNE_BLOCK = register("yjsnpi_kunekune_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BLUE));
    public static final RegistrySupplier<Block> YJSNPI_SZKFK_BLOCK = register("yjsnpi_szkfk_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YJSNPI_CCCLKTJM_BLOCK = register("yjsnpi_ccclktjm_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YJSNPI_CWCWTD_BLOCK = register("yjsnpi_cwcwtd_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YJSNPI_INTLNGTM_BLOCK = register("yjsnpi_intlngtm_block", () -> inmBlock(YJSoundType.YJ.get(), MapColor.COLOR_BROWN));

    public static final RegistrySupplier<Block> TON_BLOCK = register("ton_block", () -> inmBlock(YJSoundType.TON.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> KMR_BLOCK = register("kmr_block", () -> inmBlock(YJSoundType.KMR.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> MUR_BLOCK = register("mur_block", () -> inmBlock(YJSoundType.MUR.get(), MapColor.COLOR_BROWN));

    public static final RegistrySupplier<Block>[] INM_BLOCKS = (RegistrySupplier<Block>[]) new RegistrySupplier[]{YJSNPI_INTERVIEW_BLOCK, YJSNPI_GOMANETSU_BLOCK, YJSNPI_ENNUI_BLOCK, YJSNPI_MEZIKARA_BLOCK, YJSNPI_NEHAN_BLOCK, YJSNPI_SHITARIGAO_BLOCK, YJSNPI_IKISUGI_BLOCK, YJSNPI_IMDKUJ_BLOCK, YJSNPI_KUNEKUNE_BLOCK, YJSNPI_SZKFK_BLOCK, YJSNPI_CCCLKTJM_BLOCK, YJSNPI_CWCWTD_BLOCK, YJSNPI_INTLNGTM_BLOCK, TON_BLOCK, KMR_BLOCK, MUR_BLOCK};
    public static final RegistrySupplier<Block>[] YJ_BLOCKS = (RegistrySupplier<Block>[]) new RegistrySupplier[]{YJSNPI_INTERVIEW_BLOCK, YJSNPI_GOMANETSU_BLOCK, YJSNPI_ENNUI_BLOCK, YJSNPI_MEZIKARA_BLOCK, YJSNPI_NEHAN_BLOCK, YJSNPI_SHITARIGAO_BLOCK, YJSNPI_IKISUGI_BLOCK, YJSNPI_IMDKUJ_BLOCK, YJSNPI_KUNEKUNE_BLOCK, YJSNPI_SZKFK_BLOCK, YJSNPI_CCCLKTJM_BLOCK, YJSNPI_CWCWTD_BLOCK, YJSNPI_INTLNGTM_BLOCK};

    public static final RegistrySupplier<Block> BB = register("bb", () -> backMaterialBlock(MapColor.COLOR_BLUE));
    public static final RegistrySupplier<Block> GB = register("gb", () -> backMaterialBlock(MapColor.COLOR_LIGHT_GREEN));
    public static final RegistrySupplier<Block> RB = register("rb", () -> backMaterialBlock(MapColor.COLOR_RED));

    public static final RegistrySupplier<Block> YJ_STONE = register("yj_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(YJSoundType.YJ_STONE.get())));
    public static final RegistrySupplier<Block> YJ_DEEPSLATE = register("yj_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(YJSoundType.YJ_STONE.get())));
    public static final RegistrySupplier<Block> YJ_DIRT = register("yj_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(YJSoundType.YJ_GRAVEL.get())));
    public static final RegistrySupplier<Block> YJ_SAND = register("yj_sand", () -> new YJSandBlock(12827056, BlockBehaviour.Properties.copy(Blocks.SAND).sound(YJSoundType.YJ_SAND.get())));
    public static final RegistrySupplier<Block> YJ_GRAVEL = register("yj_gravel", () -> new YJGravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).sound(YJSoundType.YJ_GRAVEL.get())));

    public static final RegistrySupplier<Block> YJ_LEAVES = register("yj_leaves", () -> Blocks.leaves(YJSoundType.YJ_GRASS.get()));
    public static final RegistrySupplier<RotatedPillarBlock> YJ_LOG = register("yj_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(YJSoundType.YJ_WOOD.get())));
    public static final RegistrySupplier<Block> YJ_PLANKS = register("yj_planks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_BROWN).sound(YJSoundType.YJ_WOOD.get())));
    public static final RegistrySupplier<SlabBlock> YJ_SLAB = register("yj_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_BROWN).sound(YJSoundType.YJ_WOOD.get())));
    public static final RegistrySupplier<StairBlock> YJ_STAIRS = register("yj_stairs", () -> new StairBlock(YJ_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_BROWN)));

    public static final RegistrySupplier<Block> YJ_GRASS = register("yj_grass", () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).sound(YJSoundType.YJ_GRASS.get())));
    public static final RegistrySupplier<Block> TALL_YJ_GRASS = register("tall_yj_grass", () -> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS).sound(YJSoundType.YJ_GRASS.get())), block -> new DoubleHighBlockItem(block, YJItems.baseProperties()));

    public static final RegistrySupplier<Block> YJ_ROSE = register("yj_rose", () -> YJExpectPlatform.createYJFlower(YJMobEffects.BEAST_FICTION, 8, BlockBehaviour.Properties.of().noCollission().instabreak().sound(YJSoundType.YJ_GRASS.get()).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistrySupplier<Block> POTTED_YJ_ROSE = register("potted_yj_rose", () -> Blocks.flowerPot(YJ_ROSE.get()), null);

    public static final RegistrySupplier<Block> YJ_SAPLING = register("yj_sapling", () -> new SaplingBlock(new YJTreeGrower(), BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(YJSoundType.YJ_GRASS.get())));
    public static final RegistrySupplier<Block> POTTED_YJ_SAPLING = register("potted_yj_sapling", () -> Blocks.flowerPot(YJ_SAPLING.get()), null);

    public static final RegistrySupplier<Block> YJNIUM_ORE = register("yjnium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistrySupplier<Block> YJSNPI_ORE = register("yjsnpi_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).sound(YJSoundType.YJ.get())));
    public static final RegistrySupplier<Block> DEEPSLATE_YJNIUM_ORE = register("deepslate_yjnium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)));
    public static final RegistrySupplier<Block> DEEPSLATE_YJSNPI_ORE = register("deepslate_yjsnpi_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_ORE).sound(YJSoundType.YJ.get())));
    public static final RegistrySupplier<Block> YJNIUM_BLOCK = register("yjnium_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> RAW_YJNIUM_BLOCK = register("raw_yjnium_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> RAW_YJSNPI_BLOCK = register("raw_yjsnpi_block", () -> new Block(BlockBehaviour.Properties.of().sound(YJSoundType.YJ.get()).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> POTATOES_SENPAI = register("potatoes_senpai", () -> new YJPotatoBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(YJSoundType.YJ_CROP.get())), null);
    public static final RegistrySupplier<Block> YJ_HOUSE_DOOR = register("yj_house_door", () -> new YJHouseDoorBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).requiresCorrectToolForDrops().strength(5.0F, 0).sound(SoundType.METAL).noOcclusion()), b -> new DoubleHighBlockItem(b, new Item.Properties().arch$tab(YJCreativeModeTabs.MOD_TAB)));

    public static final RegistrySupplier<Block> YJSNPI_EXPLODING_BLOCK = registerFoiled("yjsnpi_exploding_block", () -> new YJExplodingBlock(BlockBehaviour.Properties.of().sound(YJSoundType.YJ.get()).strength(1f, 0f).lightLevel(value -> {
        float level = ((float) value.getValue(YJExplodingBlock.YJ_TIMER) % 14f) / 14;
        float alevel = Math.min(level, 1f - level) * 2f;
        return (int) (alevel * 16f) + 1;
    })));
    public static final RegistrySupplier<Block> YJSNPI_PROLIFERATION_BLOCK = registerFoiled("yjsnpi_proliferation_block", () -> new YJProliferationBlock(BlockBehaviour.Properties.of().sound(YJSoundType.YJ.get()).randomTicks().strength(1f, 0f)));
    public static final RegistrySupplier<Block> YJ_PORTAL = register("yj_portal", () -> new YJPortalBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).noCollission().lightLevel((blockStatex) -> 15).strength(-1.0F, 0.5F).noLootTable()), null);

    public static final RegistrySupplier<Block> BIG_PILLOW = register("big_pillow", () -> new BigPillowBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.2F, 1200.0F).noOcclusion()));

    private static RegistrySupplier<Block> registerFoiled(String name, Supplier<Block> block) {
        return register(name, block, n -> new FoiledBlockItem(n, YJItems.baseProperties()));
    }

    private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> block) {
        return register(name, block, n -> new BlockItem(n, YJItems.baseProperties()));
    }

    private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> block, Function<T, Item> blockItem) {
        var blockr = BLOCKS.register(name, block);
        if (blockItem != null)
            BLOCK_ITEMS.register(name, () -> blockItem.apply(blockr.get()));
        return blockr;
    }

    public static void init() {
        BLOCKS.register();
        BLOCK_ITEMS.register();
    }

    private static Block inmBlock(SoundType soundType, MapColor mapColor) {
        return new Block(BlockBehaviour.Properties.of().mapColor(mapColor).strength(1f, 10f).sound(soundType));
    }

    private static Block backMaterialBlock(MapColor mapColor) {
        return new Block(BlockBehaviour.Properties.of().mapColor(mapColor).strength(0.5f, 0.1f).sound(SoundType.GLASS).lightLevel(l -> 15));
    }
}
