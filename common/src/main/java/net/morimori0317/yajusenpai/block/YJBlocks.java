package net.morimori0317.yajusenpai.block;

import com.google.common.collect.ImmutableList;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.Util;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.effect.YJMobEffects;
import net.morimori0317.yajusenpai.item.*;
import net.morimori0317.yajusenpai.sound.InmFamilySound;
import net.morimori0317.yajusenpai.sound.InmFamilySounds;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public final class YJBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(YajuSenpai.MODID, Registries.BLOCK);
    private static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(YajuSenpai.MODID, Registries.ITEM);

    public static final RegistrySupplier<Block> YAJUSENPAI_BLOCK = registerInm("yajusenpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> YAJUSENPAI_IKISUGI_BLOCK = registerInm("yajusenpai_ikisugi_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> GOMANETSU_SENPAI_BLOCK = registerInm("gomanetsu_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> ENNUI_SENPAI_BLOCK = registerInm("ennui_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> MEDIKARA_SENPAI_BLOCK = registerInm("medikara_senpai_block", () -> new MedikaraBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLUE)
            .sound(YJSoundType.MEDIKARA.get())
            .strength(1f, 10f)));
    public static final RegistrySupplier<Block> NEHAN_SENPAI_BLOCK = registerInm("nehan_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> SHITARIGAO_SENPAI_BLOCK = registerInm("shitarigao_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BLUE));
    public static final RegistrySupplier<Block> IMDKUJ_SENPAI_BLOCK = registerInm("imdkuj_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_RED));
    public static final RegistrySupplier<Block> KUNEKUNE_SENPAI_BLOCK = registerInm("kunekune_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BLUE));
    public static final RegistrySupplier<Block> SZKFK_SENPAI_BLOCK = registerInm("szkfk_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> CCCLKTJM_SENPAI_BLOCK = registerInm("ccclktjm_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> CWCWTD_SENPAI_BLOCK = registerInm("cwcwtd_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> INTLNGTM_SENPAI_BLOCK = registerInm("intlngtm_senpai_block", () -> inmBlock(InmFamilySounds.YAJUSENPAI, YJSoundType.YAJUSENPAI.get(), MapColor.COLOR_BROWN));

    public static final RegistrySupplier<Block> TON_BLOCK = registerInm("ton_block", () -> inmBlock(InmFamilySounds.TON, YJSoundType.TON.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> KMR_BLOCK = registerInm("kmr_block", () -> inmBlock(InmFamilySounds.KMR, YJSoundType.KMR.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> MUR_BLOCK = registerInm("mur_block", () -> inmBlock(InmFamilySounds.MUR, YJSoundType.MUR.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> NKTIDKSG_BLOCK = registerInm("nktidksg_block", () -> inmBlock(InmFamilySounds.NKTIDKSG, YJSoundType.NKTIDKSG.get(), MapColor.COLOR_LIGHT_GRAY));
    public static final RegistrySupplier<Block> TAKEDA_INM_BLOCK = register("takeda_inm_block", () -> new TakedaInmBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .sound(YJSoundType.TAKEDA_INM.get())
                    .strength(0.1f, 0)),
            it -> new TakedaInmBlockItem(it, YJItems.baseProperties()));
    public static final RegistrySupplier<Block> KATYOU_BLOCK = registerInm("katyou_block", () -> inmBlock(InmFamilySounds.KATYOU, YJSoundType.KATYOU.get(), MapColor.COLOR_LIGHT_GRAY));
    public static final RegistrySupplier<Block> SECOND_INARI_OTOKO_BLOCK = register("second_inari_otoko_block",
            () -> inmBlock(InmFamilySounds.SECOND_INARI_OTOKO, YJSoundType.SECOND_INARI_OTOKO.get(), MapColor.COLOR_ORANGE),
            it -> new InariOtokoBlockItem(it, YJItems.baseProperties()));
    public static final RegistrySupplier<Block> AKYS_BLOCK = registerInm("akys_block", () -> inmBlock(InmFamilySounds.AKYS, YJSoundType.AKYS.get(), MapColor.COLOR_ORANGE));
    public static final RegistrySupplier<Block> GO_BLOCK = registerInm("go_block", () -> new InmBlock(InmFamilySounds.GO, BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_BLUE)
            .lightLevel(it -> 15)
            .sound(YJSoundType.GO.get())
            .strength(1.75f, 9999)));
    public static final RegistrySupplier<Block> HIDE_BLOCK = registerInm("hide_block", () -> new HideBlock(InmFamilySounds.HIDE, BlockBehaviour.Properties.of()
            .mapColor(MapColor.TERRACOTTA_WHITE)
            .sound(YJSoundType.HIDE.get())
            .strength(10.0F, 3600000.0F)));
    public static final RegistrySupplier<Block> KBTIT_BLOCK = registerInm("kbtit_block", () -> inmBlock(InmFamilySounds.KBTIT, YJSoundType.KBTIT.get(), MapColor.COLOR_BROWN));
    public static final RegistrySupplier<Block> ONDISK_BLOCK = registerInm("ondisk_block", () -> inmBlock(InmFamilySounds.ONDISK, YJSoundType.ONDISK.get(), MapColor.TERRACOTTA_WHITE));
    public static final RegistrySupplier<Block> AUCTION_OTOKO_BLOCK = registerInm("auction_otoko_block", () -> inmBlock(InmFamilySounds.AUCTION_OTOKO, YJSoundType.AUCTION_OTOKO.get(), MapColor.COLOR_RED));

    public static final RegistrySupplier<Block> BB = register("bb", () -> backMaterialBlock(MapColor.COLOR_BLUE));
    public static final RegistrySupplier<Block> GB = register("gb", () -> backMaterialBlock(MapColor.COLOR_LIGHT_GREEN));
    public static final RegistrySupplier<Block> RB = register("rb", () -> backMaterialBlock(MapColor.COLOR_RED));

    public static final RegistrySupplier<Block> YJ_STONE = register("yj_stone", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).sound(YJSoundType.YJ_STONE.get())));
    public static final RegistrySupplier<Block> YJ_DEEPSLATE = register("yj_deepslate", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).sound(YJSoundType.YJ_STONE.get())));
    public static final RegistrySupplier<Block> YJ_DIRT = register("yj_dirt", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT).sound(YJSoundType.YJ_GRAVEL.get())));
    public static final RegistrySupplier<Block> YJ_SAND = register("yj_sand", () -> new YJFallingBlock(new ColorRGBA(12827056), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).sound(YJSoundType.YJ_SAND.get())));
    public static final RegistrySupplier<Block> YJ_GRAVEL = register("yj_gravel", () -> new YJFallingBlock(new ColorRGBA(12827056), BlockBehaviour.Properties.ofFullCopy(Blocks.GRAVEL).sound(YJSoundType.YJ_GRAVEL.get())));

    public static final RegistrySupplier<Block> YJ_LEAVES = register("yj_leaves", () -> Blocks.leaves(YJSoundType.YJ_GRASS.get()));
    public static final RegistrySupplier<RotatedPillarBlock> YJ_LOG = register("yj_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).sound(YJSoundType.YJ_WOOD.get())));
    public static final RegistrySupplier<Block> YJ_PLANKS = register("yj_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_BROWN).sound(YJSoundType.YJ_WOOD.get())));
    public static final RegistrySupplier<SlabBlock> YJ_SLAB = register("yj_slab", () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB).mapColor(MapColor.COLOR_BROWN).sound(YJSoundType.YJ_WOOD.get())));
    public static final RegistrySupplier<StairBlock> YJ_STAIRS = register("yj_stairs", () -> new StairBlock(YJ_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS).mapColor(MapColor.COLOR_BROWN)));

    public static final RegistrySupplier<Block> SHORT_YJ_GRASS = register("short_yj_grass", () -> new TallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK).replaceable().noCollission().instabreak().offsetType(BlockBehaviour.OffsetType.XYZ).ignitedByLava().pushReaction(PushReaction.DESTROY).sound(YJSoundType.YJ_GRASS.get())));
    public static final RegistrySupplier<Block> TALL_YJ_GRASS = register("tall_yj_grass", () -> new DoublePlantBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS).replaceable().noCollission().instabreak().offsetType(BlockBehaviour.OffsetType.XYZ).ignitedByLava().pushReaction(PushReaction.DESTROY).sound(YJSoundType.YJ_GRASS.get())), block -> new DoubleHighBlockItem(block, YJItems.baseProperties()));

    public static final RegistrySupplier<Block> YJ_ROSE = register("yj_rose", () -> new YJRoseBlock(YJMobEffects.BEAST_FICTION.vanillaHolder(), 8, BlockBehaviour.Properties.of().noCollission().instabreak().sound(YJSoundType.YJ_GRASS.get()).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistrySupplier<Block> POTTED_YJ_ROSE = register("potted_yj_rose", () -> Blocks.flowerPot(YJ_ROSE.get()), null);

    public static final RegistrySupplier<Block> YJ_SAPLING = register("yj_sapling", () -> new SaplingBlock(YJTreeGrower.YJ_TREE, BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(YJSoundType.YJ_GRASS.get())));
    public static final RegistrySupplier<Block> POTTED_YJ_SAPLING = register("potted_yj_sapling", () -> Blocks.flowerPot(YJ_SAPLING.get()), null);

    public static final RegistrySupplier<Block> YJNIUM_ORE = register("yjnium_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final RegistrySupplier<Block> YAJUSENPAI_ORE = register("yajusenpai_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE).sound(YJSoundType.YAJUSENPAI.get())));
    public static final RegistrySupplier<Block> DEEPSLATE_YJNIUM_ORE = register("deepslate_yjnium_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
    public static final RegistrySupplier<Block> DEEPSLATE_YAJUSENPAI_ORE = register("deepslate_yajusenpai_ore", () -> new DropExperienceBlock(ConstantInt.of(0), BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE).sound(YJSoundType.YAJUSENPAI.get())));
    public static final RegistrySupplier<Block> YJNIUM_BLOCK = register("yjnium_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> RAW_YJNIUM_BLOCK = register("raw_yjnium_block", () -> new Block(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<Block> RAW_YAJUSENPAI_BLOCK = register("raw_yajusenpai_block", () -> new Block(BlockBehaviour.Properties.of().sound(YJSoundType.YAJUSENPAI.get()).strength(5.0F, 6.0F).requiresCorrectToolForDrops()));

    public static final RegistrySupplier<Block> POTATOES_SENPAI = register("potatoes_senpai", () -> new YJPotatoBlock(BlockBehaviour.Properties.of().noCollission().randomTicks().instabreak().sound(YJSoundType.YJ_CROP.get())), null);
    public static final RegistrySupplier<Block> YJ_HOUSE_DOOR = register("yj_house_door", () -> new YJHouseDoorBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).requiresCorrectToolForDrops().strength(5.0F, 0).sound(SoundType.METAL).noOcclusion()), b -> new DoubleHighBlockItem(b, new Item.Properties().arch$tab(YJCreativeModeTabs.MOD_TAB)));

    public static final RegistrySupplier<Block> EXPLOSION_YAJUSENPAI_BLOCK = registerFoiled("explosion_yajusenpai_block", () -> new YJExplodingBlock(BlockBehaviour.Properties.of().sound(YJSoundType.YAJUSENPAI.get()).strength(1f, 0f).lightLevel(value -> {
        float level = ((float) value.getValue(YJExplodingBlock.YJ_TIMER) % 14f) / 14;
        float alevel = Math.min(level, 1f - level) * 2f;
        return (int) (alevel * 16f) + 1;
    })));

    public static final RegistrySupplier<Block> PROLIFERATION_YAJUSENPAI_BLOCK = registerFoiled("proliferation_yajusenpai_block", () -> new YJProliferationBlock(BlockBehaviour.Properties.of().sound(YJSoundType.YAJUSENPAI.get()).randomTicks().strength(1f, 0f)));
    public static final RegistrySupplier<Block> YJ_PORTAL = register("yj_portal", () -> new YJPortalBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).pushReaction(PushReaction.BLOCK).noCollission().lightLevel((blockStatex) -> 15).strength(-1.0F, 0.5F).noLootTable()), null);

    public static final RegistrySupplier<Block> BIG_PILLOW = register("big_pillow", () -> new BigPillowBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(0.2F, 1200.0F).noOcclusion()));

    public static final List<RegistrySupplier<Block>> YJ_BLOCKS = ImmutableList.of(
            YAJUSENPAI_BLOCK,
            GOMANETSU_SENPAI_BLOCK,
            ENNUI_SENPAI_BLOCK,
            MEDIKARA_SENPAI_BLOCK,
            NEHAN_SENPAI_BLOCK,
            SHITARIGAO_SENPAI_BLOCK,
            YAJUSENPAI_IKISUGI_BLOCK,
            IMDKUJ_SENPAI_BLOCK,
            KUNEKUNE_SENPAI_BLOCK,
            SZKFK_SENPAI_BLOCK,
            CCCLKTJM_SENPAI_BLOCK,
            CWCWTD_SENPAI_BLOCK,
            INTLNGTM_SENPAI_BLOCK
    );

    public static final List<RegistrySupplier<Block>> NON_YJ_BLOCKS = ImmutableList.of(
            TON_BLOCK,
            KMR_BLOCK,
            MUR_BLOCK,
            NKTIDKSG_BLOCK,
            TAKEDA_INM_BLOCK,
            KATYOU_BLOCK,
            SECOND_INARI_OTOKO_BLOCK,
            AKYS_BLOCK,
            GO_BLOCK,
            HIDE_BLOCK,
            KBTIT_BLOCK,
            ONDISK_BLOCK,
            AUCTION_OTOKO_BLOCK
    );

    public static final List<RegistrySupplier<Block>> INM_BLOCKS = Util.make(() -> {
        ImmutableList.Builder<RegistrySupplier<Block>> builder = new ImmutableList.Builder<>();
        builder.addAll(YJ_BLOCKS);
        builder.addAll(NON_YJ_BLOCKS);
        return builder.build();
    });

    private static RegistrySupplier<Block> registerFoiled(String name, Supplier<Block> block) {
        return register(name, block, n -> new BlockItem(n, YJItems.baseProperties()
                .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    }

    private static <T extends Block> RegistrySupplier<T> register(String name, Supplier<T> block) {
        return register(name, block, n -> new BlockItem(n, YJItems.baseProperties()));
    }

    private static <T extends Block> RegistrySupplier<T> registerInm(String name, Supplier<T> block) {
        return register(name, block, n -> new InmBlockItem(n, YJItems.baseProperties()));
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

    private static Block inmBlock(InmFamilySound inmFamilySound, SoundType soundType, MapColor mapColor) {
        return new InmBlock(inmFamilySound, BlockBehaviour.Properties.of().mapColor(mapColor).strength(1f, 10f).sound(soundType));
    }

    private static Block backMaterialBlock(MapColor mapColor) {
        return new Block(BlockBehaviour.Properties.of().mapColor(mapColor).strength(0.5f, 0.1f).sound(SoundType.GLASS).lightLevel(l -> 15));
    }
}
