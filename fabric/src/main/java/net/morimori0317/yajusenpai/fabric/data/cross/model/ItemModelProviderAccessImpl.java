package net.morimori0317.yajusenpai.fabric.data.cross.model;

import com.google.gson.JsonElement;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.morimori0317.yajusenpai.data.cross.model.FileModel;
import net.morimori0317.yajusenpai.data.cross.model.FileTexture;
import net.morimori0317.yajusenpai.data.cross.model.ItemModelProviderAccess;
import net.morimori0317.yajusenpai.data.cross.model.MutableFileModel;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ItemModelProviderAccessImpl implements ItemModelProviderAccess {
    private final BiConsumer<ResourceLocation, Supplier<JsonElement>> output;

    public ItemModelProviderAccessImpl(BiConsumer<ResourceLocation, Supplier<JsonElement>> output) {
        this.output = output;
    }


    @Override
    public @NotNull MutableFileModel basicFlatItem(@NotNull Item item) {
        return createLayer0Model(ModelTemplates.FLAT_ITEM, item);
    }

    @Override
    public @NotNull MutableFileModel basicFlatItem(@NotNull FileTexture itemTexture) {
        return createLayer0Model(ModelTemplates.FLAT_ITEM, itemTexture.getLocation());
    }

    @Override
    public @NotNull MutableFileModel basicFlatItem(@NotNull Item item, @NotNull FileTexture itemTexture) {
        return createModel(ModelTemplates.FLAT_ITEM, TextureMapping.layer0(itemTexture.getLocation()), item);
    }

    @Override
    public @NotNull MutableFileModel basicFlatItem(@NotNull ResourceLocation itemLocation, @NotNull FileTexture itemTexture) {
        return createModel(ModelTemplates.FLAT_ITEM, TextureMapping.layer0(itemTexture.getLocation()), itemLocation);
    }

    @Override
    public @NotNull MutableFileModel handheldFlatItem(@NotNull Item item) {
        return createLayer0Model(ModelTemplates.FLAT_HANDHELD_ITEM, item);
    }

    @Override
    public @NotNull MutableFileModel handheldFlatItem(@NotNull FileTexture itemTexture) {
        return createLayer0Model(ModelTemplates.FLAT_HANDHELD_ITEM, itemTexture.getLocation());
    }

    @Override
    public @NotNull MutableFileModel parentedItem(@NotNull Item item, @NotNull ResourceLocation parentLocation) {
        var ji = new JsonModelInjector(this.output);
        var loc = ModelLocationUtils.getModelLocation(item);
        ji.injectedModelOutput().accept(loc, new DelegatedModel(parentLocation));
        return new MutableFileModelImpl(loc, ji);
    }

    @Override
    public @NotNull MutableFileModel parentedItem(@NotNull ResourceLocation itemLocation, @NotNull ResourceLocation parentLocation) {
        var ji = new JsonModelInjector(this.output);
        var loc = decorateItemModelLocation(itemLocation);
        ji.injectedModelOutput().accept(loc, new DelegatedModel(parentLocation));
        return new MutableFileModelImpl(loc, ji);
    }

    @Override
    public @NotNull FileModel existingModel(@NotNull ResourceLocation location) {
        return new FileModelImpl(location);
    }

    private MutableFileModelImpl createLayer0Model(ModelTemplate modelTemplate, ResourceLocation itemLocation) {
        return createModel(modelTemplate, TextureMapping.layer0(decorateItemModelLocation(itemLocation)), itemLocation);
    }

    private MutableFileModelImpl createLayer0Model(ModelTemplate modelTemplate, Item item) {
        return createModel(modelTemplate, TextureMapping.layer0(item), item);
    }

    private MutableFileModelImpl createModel(ModelTemplate modelTemplate, TextureMapping textureMapping, ResourceLocation itemLocation) {
        var ji = new JsonModelInjector(this.output);
        var loc = decorateItemModelLocation(itemLocation);
        modelTemplate.create(loc, textureMapping, ji.injectedModelOutput());
        return new MutableFileModelImpl(loc, ji);
    }

    private MutableFileModelImpl createModel(ModelTemplate modelTemplate, TextureMapping textureMapping, Item item) {
        var ji = new JsonModelInjector(this.output);
        var loc = ModelLocationUtils.getModelLocation(item);
        modelTemplate.create(loc, textureMapping, ji.injectedModelOutput());
        return new MutableFileModelImpl(loc, ji);
    }

    private static ResourceLocation decorateItemModelLocation(ResourceLocation location) {
        return ResourceLocation.fromNamespaceAndPath(location.getNamespace(), "item/" + location.getPath());
    }
}