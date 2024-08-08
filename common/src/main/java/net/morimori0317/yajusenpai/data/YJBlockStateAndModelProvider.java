package net.morimori0317.yajusenpai.data;

import com.google.gson.JsonElement;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;
import net.morimori0317.yajusenpai.block.BigPillowBlock;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.block.YJExplodingBlock;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.model.BlockStateAndModelProviderAccess;
import net.morimori0317.yajusenpai.data.cross.model.FileModel;
import net.morimori0317.yajusenpai.data.cross.model.FileTexture;
import net.morimori0317.yajusenpai.data.cross.provider.BlockStateAndModelProviderWrapper;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class YJBlockStateAndModelProvider extends BlockStateAndModelProviderWrapper {

    public YJBlockStateAndModelProvider(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
    }

    @Override
    public void generateStatesAndModels(BlockStateAndModelProviderAccess providerAccess) {
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.YAJUSENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.GOMANETSU_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.ENNUI_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.MEDIKARA_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.NEHAN_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.SHITARIGAO_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.YAJUSENPAI_IKISUGI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.IMDKUJ_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.KUNEKUNE_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.SZKFK_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.CCCLKTJM_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.CWCWTD_SENPAI_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.INTLNGTM_SENPAI_BLOCK.get());

        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.TON_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.KMR_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.MUR_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.NKTIDKSG_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.TAKEDA_INM_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.KATYOU_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.SECOND_INARI_OTOKO_BLOCK.get());
        rndInmBlock(providerAccess, YJBlocks.AKYS_BLOCK.get(), "akys_block_0", "akys_block_1", "akys_block_2");
        goBlock(providerAccess);
        rndInmBlock(providerAccess, YJBlocks.HIDE_BLOCK.get(), "hide_block_0", "hide_block_1", "hide_block_2");
        rndInmBlock(providerAccess, YJBlocks.KBTIT_BLOCK.get(), "kbtit_block_0", "kbtit_block_1", "kbtit_block_2");
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.ONDISK_BLOCK.get());
        rndInmBlock(providerAccess, YJBlocks.AUCTION_OTOKO_BLOCK.get(), "auction_otoko_block_0", "auction_otoko_block_1", "auction_otoko_block_2");

        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.BB.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.GB.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.RB.get());

        yjStone(providerAccess);
        yjDeepslate(providerAccess);
        createRotatedVariantBlock(providerAccess, YJBlocks.YJ_DIRT.get());
        createRotatedVariantBlock(providerAccess, YJBlocks.YJ_SAND.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.YJ_GRAVEL.get());

        yjLeaves(providerAccess);

        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.YJ_LOG.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.YJ_PLANKS.get());

        providerAccess.slabBlockItemModel(YJBlocks.YJ_SLAB.get(), providerAccess.existingModel(modLoc("block/yj_planks")));
        providerAccess.stairsBlockItemModel(YJBlocks.YJ_STAIRS.get(), providerAccess.existingModel(modLoc("block/yj_planks")));

        yjGrass(providerAccess);
        tallYjGrass(providerAccess);

        createPlant(providerAccess, YJBlocks.YJ_ROSE.get(), YJBlocks.POTTED_YJ_ROSE.get());
        createPlant(providerAccess, YJBlocks.YJ_SAPLING.get(), YJBlocks.POTTED_YJ_SAPLING.get());

        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.YJNIUM_ORE.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.YAJUSENPAI_ORE.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.DEEPSLATE_YJNIUM_ORE.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.DEEPSLATE_YAJUSENPAI_ORE.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.YJNIUM_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.RAW_YJNIUM_BLOCK.get());
        providerAccess.simpleCubeBlockStateModelAndItemModel(YJBlocks.RAW_YAJUSENPAI_BLOCK.get());

        createRotatesSenpaiCropBlock(providerAccess, YJBlocks.POTATOES_SENPAI.get(), BlockStateProperties.AGE_7, 0, 0, 1, 1, 2, 2, 2, 3);

        createDoor(providerAccess, YJBlocks.YJ_HOUSE_DOOR.get());
        yjsnpiExplodingBlock(providerAccess);
        yjProliferationBlock(providerAccess);
        bigPillow(providerAccess);
    }

    private void goBlock(BlockStateAndModelProviderAccess providerAccess) {
        rndInmBlock(providerAccess, false, YJBlocks.GO_BLOCK.get(), "go_block_0", "go_block_1");
        providerAccess.parentedBlockItemModel(YJBlocks.GO_BLOCK.get(), YJUtils.modLoc("item/go_block_impl"));
    }

    private void rndInmBlock(BlockStateAndModelProviderAccess providerAccess, Block block, String id, String... ids) {
        rndInmBlock(providerAccess, true, block, id, ids);
    }

    private void rndInmBlock(BlockStateAndModelProviderAccess providerAccess, boolean generateItemModel, Block block, String id, String... ids) {
        List<Variant> variants = new ArrayList<>();

        FileModel fileModel = providerAccess.cubeAllBlockModel(YJUtils.modLoc(id), FileTexture.of(YJUtils.modLoc("block/" + id)));
        Variant variant = Variant.variant().with(VariantProperties.MODEL, fileModel.getLocation());
        variants.add(variant);

        for (String idEntry : ids) {
            FileModel entryModel = providerAccess.cubeAllBlockModel(YJUtils.modLoc(idEntry), FileTexture.of(YJUtils.modLoc("block/" + idEntry)));
            variants.add(Variant.variant().with(VariantProperties.MODEL, entryModel.getLocation()));
        }

        providerAccess.addBlockStateGenerator(MultiVariantGenerator.multiVariant(block, variants.toArray(Variant[]::new)));

        if (generateItemModel) {
            providerAccess.simpleBlockItemModel(block, fileModel);
        }
    }

    private void bigPillow(BlockStateAndModelProviderAccess providerAccess) {
        FileModel model = providerAccess.existingModel(ModelLocationUtils.getModelLocation(YJBlocks.BIG_PILLOW.get()));

        providerAccess.addBlockStateGenerator(MultiVariantGenerator.multiVariant(YJBlocks.BIG_PILLOW.get(), Variant.variant().with(VariantProperties.MODEL, model.getLocation()))
                .with(PropertyDispatch.property(BigPillowBlock.FACING)
                        .select(Direction.WEST, Variant.variant())
                        .select(Direction.NORTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.EAST, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, Variant.variant().with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))));

        providerAccess.itemModelProviderAccess().basicFlatItem(YJBlocks.BIG_PILLOW.get().asItem(), YJUtils.modLoc("item/big_pillow"));
    }

    private void yjProliferationBlock(BlockStateAndModelProviderAccess providerAccess) {
        FileModel model = providerAccess.cubeAllBlockModel(YJBlocks.PROLIFERATION_YAJUSENPAI_BLOCK.get(), ModelLocationUtils.getModelLocation(YJBlocks.YAJUSENPAI_BLOCK.get()));
        providerAccess.simpleBlockState(YJBlocks.PROLIFERATION_YAJUSENPAI_BLOCK.get(), model);
        providerAccess.simpleBlockItemModel(YJBlocks.PROLIFERATION_YAJUSENPAI_BLOCK.get(), model);
    }

    private void yjsnpiExplodingBlock(BlockStateAndModelProviderAccess providerAccess) {
        for (int i = 0; i < 147; i++) {
            ModelTemplates.CUBE_ALL.create(modLoc("block/exploding_yajusenpai_block/yj_" + i), TextureMapping.cube(modLoc("block/exploding_yajusenpai_block/yj_" + i)), providerAccess.modelOutput());
        }

        MultiVariantGenerator generator = MultiVariantGenerator.multiVariant(YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK.get())
                .with(PropertyDispatch.properties(YJExplodingBlock.YJ_START, YJExplodingBlock.YJ_TIMER).generate((aBoolean, integer) -> {
                    if (!aBoolean) {
                        return Variant.variant().with(VariantProperties.MODEL, modLoc("block/yajusenpai_ikisugi_block"));
                    }

                    return Variant.variant().with(VariantProperties.MODEL, modLoc("block/exploding_yajusenpai_block/yj_" + integer));
                }));
        providerAccess.addBlockStateGenerator(generator);

        providerAccess.simpleBlockItemModel(YJBlocks.EXPLOSION_YAJUSENPAI_BLOCK.get(), providerAccess.existingModel(ModelLocationUtils.getModelLocation(YJBlocks.YAJUSENPAI_IKISUGI_BLOCK.get())));
    }

    private static void tallYjGrass(BlockStateAndModelProviderAccess providerAccess) {
        providerAccess.itemModelProviderAccess().basicFlatItem(YJBlocks.TALL_YJ_GRASS.get().asItem(), YJUtils.modLoc("block/tall_yj_grass_top"));

        ResourceLocation resourceLocation = createSuffixedVariant(YJBlocks.TALL_YJ_GRASS.get(), "_top", ModelTemplates.CROSS, TextureMapping::cross, providerAccess.modelOutput());
        ResourceLocation resourceLocation2 = createSuffixedVariant(YJBlocks.TALL_YJ_GRASS.get(), "_bottom", ModelTemplates.CROSS, TextureMapping::cross, providerAccess.modelOutput());
        createDoubleBlock(providerAccess, YJBlocks.TALL_YJ_GRASS.get(), resourceLocation, resourceLocation2);
    }

    private static void yjGrass(BlockStateAndModelProviderAccess providerAccess) {
        TextureMapping textureMapping = TextureMapping.cross(YJBlocks.SHORT_YJ_GRASS.get());
        ResourceLocation resourceLocation = ModelTemplates.CROSS.create(YJBlocks.SHORT_YJ_GRASS.get(), textureMapping, providerAccess.modelOutput());
        providerAccess.addBlockStateGenerator(createSimpleBlock(YJBlocks.SHORT_YJ_GRASS.get(), resourceLocation));

        providerAccess.simpleFlatBlockItemModel(YJBlocks.SHORT_YJ_GRASS.get());
    }

    private static void yjLeaves(BlockStateAndModelProviderAccess providerAccess) {
        ResourceLocation model = TexturedModel.LEAVES.create(YJBlocks.YJ_LEAVES.get(), providerAccess.modelOutput());
        providerAccess.addBlockStateGenerator(createSimpleBlock(YJBlocks.YJ_LEAVES.get(), model));

        providerAccess.simpleBlockItemModel(YJBlocks.YJ_LEAVES.get(), providerAccess.uncheckedModel(model));
    }

    private static void yjDeepslate(BlockStateAndModelProviderAccess providerAccess) {
        FileModel model = providerAccess.cubeAllBlockModel(YJBlocks.YJ_DEEPSLATE.get(), FileTexture.of(YJUtils.modLoc("block/yj_deepslate")));
        providerAccess.simpleBlockItemModel(YJBlocks.YJ_DEEPSLATE.get(), model);

        TexturedModel texturedModel = TexturedModel.CUBE.get(YJBlocks.YJ_DEEPSLATE.get());
        TextureMapping textureMapping = texturedModel.getMapping();

        providerAccess.addBlockStateGenerator(createMirroredColumnGenerator(YJBlocks.YJ_DEEPSLATE.get(), model.getLocation(), textureMapping, providerAccess.modelOutput()));
    }

    private static void yjStone(BlockStateAndModelProviderAccess providerAccess) {
        FileModel model = providerAccess.cubeAllBlockModel(YJBlocks.YJ_STONE.get(), FileTexture.of(YJUtils.modLoc("block/yj_stone")));
        providerAccess.simpleBlockItemModel(YJBlocks.YJ_STONE.get(), model);

        TexturedModel texturedModel = TexturedModel.CUBE.get(YJBlocks.YJ_STONE.get());
        TextureMapping textureMapping = texturedModel.getMapping();

        providerAccess.addBlockStateGenerator(createMirroredCubeGenerator(YJBlocks.YJ_STONE.get(), model.getLocation(), textureMapping, providerAccess.modelOutput()));
    }

    private static void createDoor(BlockStateAndModelProviderAccess providerAccess, Block block) {
        TextureMapping textureMapping = TextureMapping.door(block);
        ResourceLocation resourceLocation = ModelTemplates.DOOR_BOTTOM_LEFT.create(block, textureMapping, providerAccess.modelOutput());
        ResourceLocation resourceLocation2 = ModelTemplates.DOOR_BOTTOM_LEFT_OPEN.create(block, textureMapping, providerAccess.modelOutput());
        ResourceLocation resourceLocation3 = ModelTemplates.DOOR_BOTTOM_RIGHT.create(block, textureMapping, providerAccess.modelOutput());
        ResourceLocation resourceLocation4 = ModelTemplates.DOOR_BOTTOM_RIGHT_OPEN.create(block, textureMapping, providerAccess.modelOutput());
        ResourceLocation resourceLocation5 = ModelTemplates.DOOR_TOP_LEFT.create(block, textureMapping, providerAccess.modelOutput());
        ResourceLocation resourceLocation6 = ModelTemplates.DOOR_TOP_LEFT_OPEN.create(block, textureMapping, providerAccess.modelOutput());
        ResourceLocation resourceLocation7 = ModelTemplates.DOOR_TOP_RIGHT.create(block, textureMapping, providerAccess.modelOutput());
        ResourceLocation resourceLocation8 = ModelTemplates.DOOR_TOP_RIGHT_OPEN.create(block, textureMapping, providerAccess.modelOutput());

        providerAccess.itemModelProviderAccess().basicFlatItem(block.asItem());
        providerAccess.addBlockStateGenerator(createDoor(block, resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4, resourceLocation5, resourceLocation6, resourceLocation7, resourceLocation8));
    }

    private static BlockStateGenerator createDoor(Block block, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, ResourceLocation resourceLocation5, ResourceLocation resourceLocation6, ResourceLocation resourceLocation7, ResourceLocation resourceLocation8) {
        return MultiVariantGenerator.multiVariant(block).with(configureDoorHalf(configureDoorHalf(PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.DOOR_HINGE, BlockStateProperties.OPEN), DoubleBlockHalf.LOWER, resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4), DoubleBlockHalf.UPPER, resourceLocation5, resourceLocation6, resourceLocation7, resourceLocation8));
    }

    private static PropertyDispatch.C4<Direction, DoubleBlockHalf, DoorHingeSide, Boolean> configureDoorHalf(PropertyDispatch.C4<Direction, DoubleBlockHalf, DoorHingeSide, Boolean> c4, DoubleBlockHalf doubleBlockHalf, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4) {
        return c4.select(Direction.EAST, doubleBlockHalf, DoorHingeSide.LEFT, (Boolean) false, Variant.variant().with(VariantProperties.MODEL, resourceLocation)).select(Direction.SOUTH, doubleBlockHalf, DoorHingeSide.LEFT, (Boolean) false, Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).select(Direction.WEST, doubleBlockHalf, DoorHingeSide.LEFT, (Boolean) false, Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).select(Direction.NORTH, doubleBlockHalf, DoorHingeSide.LEFT, (Boolean) false, Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).select(Direction.EAST, doubleBlockHalf, DoorHingeSide.RIGHT, (Boolean) false, Variant.variant().with(VariantProperties.MODEL, resourceLocation3)).select(Direction.SOUTH, doubleBlockHalf, DoorHingeSide.RIGHT, false, Variant.variant().with(VariantProperties.MODEL, resourceLocation3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).select(Direction.WEST, doubleBlockHalf, DoorHingeSide.RIGHT, (Boolean) false, Variant.variant().with(VariantProperties.MODEL, resourceLocation3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).select(Direction.NORTH, doubleBlockHalf, DoorHingeSide.RIGHT, (Boolean) false, Variant.variant().with(VariantProperties.MODEL, resourceLocation3).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).select(Direction.EAST, doubleBlockHalf, DoorHingeSide.LEFT, (Boolean) true, Variant.variant().with(VariantProperties.MODEL, resourceLocation2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).select(Direction.SOUTH, doubleBlockHalf, DoorHingeSide.LEFT, (Boolean) true, Variant.variant().with(VariantProperties.MODEL, resourceLocation2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180)).select(Direction.WEST, doubleBlockHalf, DoorHingeSide.LEFT, (Boolean) true, Variant.variant().with(VariantProperties.MODEL, resourceLocation2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).select(Direction.NORTH, doubleBlockHalf, DoorHingeSide.LEFT, (Boolean) true, Variant.variant().with(VariantProperties.MODEL, resourceLocation2)).select(Direction.EAST, doubleBlockHalf, DoorHingeSide.RIGHT, (Boolean) true, Variant.variant().with(VariantProperties.MODEL, resourceLocation4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)).select(Direction.SOUTH, doubleBlockHalf, DoorHingeSide.RIGHT, (Boolean) true, Variant.variant().with(VariantProperties.MODEL, resourceLocation4)).select(Direction.WEST, doubleBlockHalf, DoorHingeSide.RIGHT, (Boolean) true, Variant.variant().with(VariantProperties.MODEL, resourceLocation4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90)).select(Direction.NORTH, doubleBlockHalf, DoorHingeSide.RIGHT, (Boolean) true, Variant.variant().with(VariantProperties.MODEL, resourceLocation4).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180));
    }

    private static void createRotatesSenpaiCropBlock(BlockStateAndModelProviderAccess providerAccess, Block block, Property<Integer> property, int... is) {
        if (property.getPossibleValues().size() != is.length) {
            throw new IllegalArgumentException();
        }
        Int2ObjectOpenHashMap<ResourceLocation> int2ObjectMap = new Int2ObjectOpenHashMap<>();
        PropertyDispatch propertyDispatch = PropertyDispatch.property(property).generate(integer -> {
            int i = is[integer];
            ResourceLocation resourceLocation = int2ObjectMap.computeIfAbsent(i, j -> createSuffixedVariant(Blocks.POTATOES, "_stage" + i, ModelTemplates.CROP, TextureMapping::crop, providerAccess.modelOutput()));
            return Variant.variant().with(VariantProperties.MODEL, resourceLocation);
        });

        providerAccess.itemModelProviderAccess().basicFlatItem(block.asItem());
        providerAccess.addBlockStateGenerator(MultiVariantGenerator.multiVariant(block).with(propertyDispatch));
    }

    private static void createPlant(BlockStateAndModelProviderAccess providerAccess, Block plantBlock, Block potBlock) {
        providerAccess.simpleFlatBlockItemModel(plantBlock);
        TextureMapping textureMapping = TextureMapping.cross(plantBlock);
        ResourceLocation resourceLocation = ModelTemplates.CROSS.create(plantBlock, textureMapping, providerAccess.modelOutput());
        providerAccess.addBlockStateGenerator(createSimpleBlock(plantBlock, resourceLocation));

        TextureMapping plantTextureMapping = TextureMapping.plant(plantBlock);
        ResourceLocation potLoc = ModelTemplates.FLOWER_POT_CROSS.create(potBlock, plantTextureMapping, providerAccess.modelOutput());
        providerAccess.addBlockStateGenerator(createSimpleBlock(potBlock, potLoc));
    }

    private static void createDoubleBlock(BlockStateAndModelProviderAccess providerAccess, Block block, ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        providerAccess.addBlockStateGenerator(MultiVariantGenerator.multiVariant(block).with(PropertyDispatch.property(BlockStateProperties.DOUBLE_BLOCK_HALF).select(DoubleBlockHalf.LOWER, Variant.variant().with(VariantProperties.MODEL, resourceLocation2)).select(DoubleBlockHalf.UPPER, Variant.variant().with(VariantProperties.MODEL, resourceLocation))));
    }

    private static ResourceLocation createSuffixedVariant(Block block, String string, ModelTemplate modelTemplate, Function<ResourceLocation, TextureMapping> function, BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput) {
        return modelTemplate.createWithSuffix(block, string, function.apply(TextureMapping.getBlockTexture(block, string)), modelOutput);
    }

    public static MultiVariantGenerator createSimpleBlock(Block block, ResourceLocation resourceLocation) {
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, resourceLocation));
    }

    private void createRotatedVariantBlock(BlockStateAndModelProviderAccess providerAccess, Block block) {
        FileModel model = providerAccess.cubeAllBlockModel(block, FileTexture.of(ModelLocationUtils.getModelLocation(block)));
        providerAccess.simpleBlockItemModel(block, model);

        providerAccess.addBlockStateGenerator(createRotatedVariant(block, model.getLocation()));
    }

    private static MultiVariantGenerator createRotatedVariant(Block block, ResourceLocation resourceLocation) {
        return MultiVariantGenerator.multiVariant(block, createRotatedVariants(resourceLocation));
    }

    private static Variant[] createRotatedVariants(ResourceLocation resourceLocation) {
        return new Variant[]{Variant.variant().with(VariantProperties.MODEL, resourceLocation), Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90), Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180), Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270)};
    }

    private static BlockStateGenerator createMirroredColumnGenerator(Block block, ResourceLocation resourceLocation, TextureMapping textureMapping, BiConsumer<ResourceLocation, Supplier<JsonElement>> biConsumer) {
        ResourceLocation resourceLocation2 = ModelTemplates.CUBE_COLUMN_MIRRORED.create(block, textureMapping, biConsumer);
        return createRotatedVariant(block, resourceLocation, resourceLocation2).with(createRotatedPillar());
    }

    private static PropertyDispatch createRotatedPillar() {
        return PropertyDispatch.property(BlockStateProperties.AXIS).select(Direction.Axis.Y, Variant.variant()).select(Direction.Axis.Z, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90)).select(Direction.Axis.X, Variant.variant().with(VariantProperties.X_ROT, VariantProperties.Rotation.R90).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));
    }

    private static BlockStateGenerator createMirroredCubeGenerator(Block block, ResourceLocation resourceLocation, TextureMapping textureMapping, BiConsumer<ResourceLocation, Supplier<JsonElement>> biConsumer) {
        ResourceLocation resourceLocation2 = ModelTemplates.CUBE_MIRRORED_ALL.create(block, textureMapping, biConsumer);
        return createRotatedVariant(block, resourceLocation, resourceLocation2);
    }

    private static MultiVariantGenerator createRotatedVariant(Block block, ResourceLocation resourceLocation, ResourceLocation resourceLocation2) {
        return MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, resourceLocation), Variant.variant().with(VariantProperties.MODEL, resourceLocation2), Variant.variant().with(VariantProperties.MODEL, resourceLocation).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180), Variant.variant().with(VariantProperties.MODEL, resourceLocation2).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180));
    }
}
