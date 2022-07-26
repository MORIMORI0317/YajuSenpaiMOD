package net.morimori0317.yajusenpai.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.morimori0317.yajusenpai.YajuSenpai;
import net.morimori0317.yajusenpai.item.YJCreativeModeTab;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class YJBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(YajuSenpai.MODID, Registry.BLOCK_REGISTRY);
    private static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(YajuSenpai.MODID, Registry.ITEM_REGISTRY);

    public static final RegistrySupplier<Block> YJSNPI_INTERVIEW_BLOCK = register("yjsnpi_interview_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_GOMANETSU_BLOCK = register("yjsnpi_gomanetsu_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_ENNUI_BLOCK = register("yjsnpi_ennui_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_MEZIKARA_BLOCK = register("yjsnpi_mezikara_block", YJMaterial.YJSNPI, () -> YJSoundType.MEZIKARA, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_NEHAN_BLOCK = register("yjsnpi_nehan_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_SHITARIGAO_BLOCK = register("yjsnpi_shitarigao_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_IKISUGI_BLOCK = register("yjsnpi_ikisugi_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_IMDKUJ_BLOCK = register("yjsnpi_imdkuj_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_KUNEKUNE_BLOCK = register("yjsnpi_kunekune_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);

    public static final RegistrySupplier<Block> YJSNPI_SZKFK_BLOCK = register("yjsnpi_szkfk_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_CCCLKTJM_BLOCK = register("yjsnpi_ccclktjm_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_CWCWTD_BLOCK = register("yjsnpi_cwcwtd_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);
    public static final RegistrySupplier<Block> YJSNPI_INTLNGTM_BLOCK = register("yjsnpi_intlngtm_block", YJMaterial.YJSNPI, () -> YJSoundType.YJ, 1f, 10f);

    public static final RegistrySupplier<Block> TON_BLOCK = register("ton_block", YJMaterial.TON, () -> YJSoundType.TON, 1f, 10f);
    public static final RegistrySupplier<Block> KMR_BLOCK = register("kmr_block", YJMaterial.KMR, () -> YJSoundType.KMR, 1f, 10f);
    public static final RegistrySupplier<Block> MUR_BLOCK = register("mur_block", YJMaterial.MUR, () -> YJSoundType.MUR, 1f, 10f);

    public static final RegistrySupplier<Block> BB = register("bb", Material.STONE, DyeColor.BLUE, () -> SoundType.GLASS, 0.5f, 0.1f, l -> 15);
    public static final RegistrySupplier<Block> GB = register("gb", Material.STONE, DyeColor.GREEN, () -> SoundType.GLASS, 0.5f, 0.1f, l -> 15);
    public static final RegistrySupplier<Block> RB = register("rb", Material.STONE, DyeColor.RED, () -> SoundType.GLASS, 0.5f, 0.1f, l -> 15);

    public static final RegistrySupplier<Block> YJ_STONE = register("yj_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(YJSoundType.YJ_STONE)));
    public static final RegistrySupplier<Block> YJ_DEEPSLATE = register("yj_deepslate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE).sound(YJSoundType.YJ_STONE)));
    public static final RegistrySupplier<Block> YJ_DIRT = register("yj_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(YJSoundType.YJ_GRAVEL)));
    public static final RegistrySupplier<Block> YJ_SAND = register("yj_sand", () -> new YJSandBlock(12827056, BlockBehaviour.Properties.copy(Blocks.SAND).sound(YJSoundType.YJ_SAND)));
    public static final RegistrySupplier<Block> YJ_GRAVEL = register("yj_gravel", () -> new YJGravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL).sound(YJSoundType.YJ_GRAVEL)));

    private static RegistrySupplier<Block> register(String name, Material materialIn, DyeColor dyeColor, Supplier<SoundType> sound, float hardness, float resistance, ToIntFunction<BlockState> light) {
        return register(name, () -> new Block(BlockBehaviour.Properties.of(materialIn, dyeColor).sound(sound.get()).strength(hardness, resistance).lightLevel(light)), n -> new BlockItem(n, new Item.Properties().tab(YJCreativeModeTab.MOD_TAB)));
    }

    private static RegistrySupplier<Block> register(String name, Material materialIn, Supplier<SoundType> sound, float hardness, float resistance) {
        return register(name, () -> new Block(BlockBehaviour.Properties.of(materialIn).sound(sound.get()).strength(hardness, resistance)), n -> new BlockItem(n, new Item.Properties().tab(YJCreativeModeTab.MOD_TAB)));
    }

    private static RegistrySupplier<Block> register(String name, Supplier<Block> block) {
        return register(name, block, n -> new BlockItem(n, new Item.Properties().tab(YJCreativeModeTab.MOD_TAB)));
    }

    private static RegistrySupplier<Block> register(String name, Supplier<Block> block, Function<Block, Item> blockItem) {
        var blockr = BLOCKS.register(name, block);
        BLOCK_ITEMS.register(name, () -> blockItem.apply(blockr.get()));
        return blockr;
    }

    public static void init() {
        BLOCKS.register();
        BLOCK_ITEMS.register();
    }
}
