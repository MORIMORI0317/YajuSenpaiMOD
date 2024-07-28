package net.morimori0317.yajusenpai.neoforge.data.cross.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.morimori0317.yajusenpai.data.cross.model.*;
import net.morimori0317.yajusenpai.neoforge.data.cross.WrappedBlockStateBuilder;
import net.morimori0317.yajusenpai.neoforge.mixin.data.BlockStateProviderAccessor;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class BlockStateAndModelProviderAccessImpl implements BlockStateAndModelProviderAccess {
    private final BlockStateProvider blockStateProvider;
    private final ItemModelProviderAccess itemModelProviderAccess;

    public BlockStateAndModelProviderAccessImpl(BlockStateProvider blockStateProvider) {
        this.blockStateProvider = blockStateProvider;
        this.itemModelProviderAccess = new ItemModelProviderAccessImpl(blockStateProvider.itemModels());
    }

    @Override
    public void simpleFlatBlockItemModel(@NotNull Block block) {
        ResourceLocation itemLoc = ModelLocationUtils.getModelLocation(block.asItem());
        ResourceLocation blockLoc = this.blockStateProvider.blockTexture(block);

        this.blockStateProvider.itemModels().getBuilder(itemLoc.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", blockLoc);
    }

    @Override
    public @NotNull FileModel uncheckedModel(@NotNull ResourceLocation modelLocation) {
        return of(new ModelFile.UncheckedModelFile(modelLocation));
    }

    @Override
    public void stairsBlockItemModel(@NotNull StairBlock stairBlock, @NotNull FileModel baseBlockModel) {
        this.blockStateProvider.stairsBlock(stairBlock, baseBlockModel.getLocation());
        simpleBlockItemModel(stairBlock, existingModel(key(stairBlock)));
    }

    @Override
    public void slabBlockItemModel(@NotNull SlabBlock slabBlock, @NotNull FileModel baseBlockModel) {
        ResourceLocation loc = baseBlockModel.getLocation();
        this.blockStateProvider.slabBlock(slabBlock, loc, loc, loc, loc);
        simpleBlockItemModel(slabBlock, existingModel(key(slabBlock)));
    }

    @Override
    public void logBlockItemModel(@NotNull RotatedPillarBlock block) {
        this.blockStateProvider.logBlock(block);
    }

    @Override
    public @NotNull BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput() {
        return (loc, jsonSupplier) -> this.blockStateProvider.models().generatedModels.put(loc, new SimpleJsonModelBuilder(loc, this.blockStateProvider.models().existingFileHelper, (JsonObject) jsonSupplier.get()));
    }

    @Override
    public void simpleCubeBlockStateModelAndItemModel(@NotNull Block block) {
        ModelFile model = this.blockStateProvider.cubeAll(block);
        this.blockStateProvider.simpleBlock(block, model);
        this.blockStateProvider.simpleBlockItem(block, model);
    }

    private FileModel of(ModelFile modelFile) {
        return new FileModelImpl(modelFile);
    }

    private MutableFileModel of(BlockModelBuilder blockModelBuilder) {
        return new BlockMutableFileModelImpl(blockModelBuilder);
    }

    @Override
    public @NotNull FileModel cubeAllBlockModel(@NotNull ResourceLocation blockLocation, @NotNull ResourceLocation textureLocation) {
        return of(this.blockStateProvider.models().cubeAll(blockLocation.toString(), textureLocation));
    }

    @Override
    public @NotNull FileModel cubeAllBlockModel(@NotNull ResourceLocation blockLocation, @NotNull FileTexture fileTexture) {
        var bm = this.blockStateProvider.models()
                .withExistingParent(blockLocation.toString(), "block/cube_all");

        return of(setTexture(bm, "all", fileTexture));
    }

    @Override
    public @NotNull FileModel cubeAllBlockModel(@NotNull Block block, @NotNull ResourceLocation texture) {
        return of(this.blockStateProvider.models().cubeAll(name(block), texture));
    }

    @Override
    public @NotNull FileModel cubeAllBlockModel(@NotNull Block block, @NotNull FileTexture fileTexture) {
        var bm = this.blockStateProvider.models()
                .withExistingParent(name(block), "block/cube_all");

        return of(setTexture(bm, "all", fileTexture));
    }

    @Override
    public @NotNull FileModel cubeBlockModel(@NotNull ResourceLocation blockLocation, @NotNull ResourceLocation down, @NotNull ResourceLocation up, @NotNull ResourceLocation north, @NotNull ResourceLocation south, @NotNull ResourceLocation east, @NotNull ResourceLocation west) {
        return of(this.blockStateProvider.models().cube(blockLocation.toString(), down, up, north, south, east, west));
    }

    @Override
    public @NotNull FileModel cubeBlockModel(@NotNull ResourceLocation blockLocation, @NotNull FileTexture down, @NotNull FileTexture up, @NotNull FileTexture north, @NotNull FileTexture south, @NotNull FileTexture east, @NotNull FileTexture west) {
        var bm = this.blockStateProvider.models().withExistingParent(blockLocation.toString(), "cube");

        setTexture(bm, "down", down);
        setTexture(bm, "up", up);
        setTexture(bm, "north", north);
        setTexture(bm, "south", south);
        setTexture(bm, "east", east);
        setTexture(bm, "west", west);

        return of(bm);
    }

    @Override
    public @NotNull FileModel cubeBlockModel(@NotNull Block block, @NotNull ResourceLocation down, @NotNull ResourceLocation up, @NotNull ResourceLocation north, @NotNull ResourceLocation south, @NotNull ResourceLocation east, @NotNull ResourceLocation west) {
        return of(this.blockStateProvider.models().cube(name(block), down, up, north, south, east, west));
    }

    @Override
    public @NotNull FileModel cubeBlockModel(@NotNull Block block, @NotNull FileTexture down, @NotNull FileTexture up, @NotNull FileTexture north, @NotNull FileTexture south, @NotNull FileTexture east, @NotNull FileTexture west) {
        var bm = this.blockStateProvider.models().withExistingParent(name(block), "cube");

        setTexture(bm, "down", down);
        setTexture(bm, "up", up);
        setTexture(bm, "north", north);
        setTexture(bm, "south", south);
        setTexture(bm, "east", east);
        setTexture(bm, "west", west);

        return of(bm);
    }

    @Override
    public @NotNull FileModel cubeBottomTopBlockModel(@NotNull ResourceLocation blockLocation, @NotNull ResourceLocation bottom, @NotNull ResourceLocation side, @NotNull ResourceLocation top) {
        return of(this.blockStateProvider.models().cubeBottomTop(blockLocation.toString(), side, bottom, top));
    }

    @Override
    public @NotNull FileModel cubeBottomTopBlockModel(@NotNull ResourceLocation blockLocation, @NotNull FileTexture bottom, @NotNull FileTexture side, @NotNull FileTexture top) {
        var bm = this.blockStateProvider.models().withExistingParent(blockLocation.toString(), "block/cube_bottom_top");

        setTexture(bm, "side", side);
        setTexture(bm, "bottom", bottom);
        setTexture(bm, "top", top);

        return of(bm);
    }

    @Override
    public @NotNull FileModel cubeBottomTopBlockModel(@NotNull Block block, @NotNull ResourceLocation bottom, @NotNull ResourceLocation side, @NotNull ResourceLocation top) {
        return of(this.blockStateProvider.models().cubeBottomTop(name(block), side, bottom, top));
    }

    @Override
    public @NotNull FileModel cubeBottomTopBlockModel(@NotNull Block block, @NotNull FileTexture bottom, @NotNull FileTexture side, @NotNull FileTexture top) {
        var bm = this.blockStateProvider.models().withExistingParent(name(block), "block/cube_bottom_top");

        setTexture(bm, "side", side);
        setTexture(bm, "bottom", bottom);
        setTexture(bm, "top", top);

        return of(bm);
    }

    @Override
    public @NotNull MutableFileModel parentedBlockModel(@NotNull Block block, @NotNull ResourceLocation parentLocation) {
        return of(this.blockStateProvider.models().withExistingParent(name(block), parentLocation));
    }

    @Override
    public @NotNull FileModel existingModel(@NotNull ResourceLocation location) {
        return of(this.blockStateProvider.models().getExistingFile(location));
    }

    @Override
    public @NotNull FileModel particleOnlyModel(@NotNull Block block, @NotNull ResourceLocation particleLocation) {
        return of(this.blockStateProvider.models().getBuilder(name(block)).texture("particle", particleLocation));
    }

    @Override
    public @NotNull FileModel particleOnlyModel(@NotNull Block block, @NotNull FileTexture particleLocation) {
        var bm = this.blockStateProvider.models().getBuilder(name(block));
        setTexture(bm, "particle", particleLocation);
        return of(bm);
    }

    @Override
    public void simpleBlockState(@NotNull Block block, @NotNull FileModel model) {
        this.blockStateProvider.simpleBlock(block, FileModelImpl.getModelFile(model));
    }

    @Override
    public void simpleBlockItemModel(@NotNull Block block, @NotNull FileModel model) {
        this.blockStateProvider.simpleBlockItem(block, FileModelImpl.getModelFile(model));
    }

    @Override
    public void horizontalBlockState(@NotNull Block block, @NotNull FileModel model) {
        this.blockStateProvider.horizontalBlock(block, FileModelImpl.getModelFile(model));
    }

    @Override
    public void parentedBlockItemModel(@NotNull Block block, @NotNull ResourceLocation parentLocation) {
        var name = Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(block.asItem()));
        this.blockStateProvider.itemModels().getBuilder(name.toString()).parent(new ModelFile.UncheckedModelFile(parentLocation));
    }

    @Override
    public void addBlockStateGenerator(@NotNull BlockStateGenerator blockStateGenerator) {
        Block block = blockStateGenerator.getBlock();
        if (((BlockStateProviderAccessor) this.blockStateProvider).getRegisteredBlocks().containsKey(block))
            throw new IllegalStateException("Duplicate registration");

        ((BlockStateProviderAccessor) this.blockStateProvider).getRegisteredBlocks().put(block, new WrappedBlockStateBuilder(blockStateGenerator));
    }

    @Override
    public ItemModelProviderAccess itemModelProviderAccess() {
        return this.itemModelProviderAccess;
    }

    private String name(Block block) {
        return this.key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private BlockModelBuilder setTexture(BlockModelBuilder blockModelBuilder, String key, FileTexture fileTexture) {
        if (fileTexture.isExistingCheck()) {
            blockModelBuilder.texture(key, fileTexture.getLocation());
        } else {
            ((UncheckedTextureModelBuilder) blockModelBuilder).uncheckedTexture(key, fileTexture.getLocation());
        }
        return blockModelBuilder;
    }

    private static class SimpleJsonModelBuilder extends BlockModelBuilder {
        private final JsonObject jsonObject;

        protected SimpleJsonModelBuilder(ResourceLocation outputLocation, ExistingFileHelper existingFileHelper, JsonObject jsonObject) {
            super(outputLocation, existingFileHelper);
            this.jsonObject = jsonObject;
        }

        @Override
        public JsonObject toJson() {
            return jsonObject;
        }
    }
}