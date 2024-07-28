package net.morimori0317.yajusenpai.data.cross.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

/**
 * それぞれのプラットフォームで同じ動作をするアイテムモデル生成
 */
public interface ItemModelProviderAccess {
    /**
     * 通常の板状アイテムを生成
     *
     * @param item アイテム
     * @return モデル
     */
    @NotNull
    MutableFileModel basicFlatItem(@NotNull Item item);

    /**
     * 通常の板状アイテムを生成
     *
     * @param itemLocation ロケーション
     * @return モデル
     */
    @NotNull
    default MutableFileModel basicFlatItem(@NotNull ResourceLocation itemLocation) {
        return basicFlatItem(FileTexture.of(itemLocation));
    }

    /**
     * 通常の板状アイテムを生成
     *
     * @param itemTexture ファイルテクスチャ
     * @return モデル
     */
    @NotNull
    MutableFileModel basicFlatItem(@NotNull FileTexture itemTexture);

    /**
     * 通常の板状アイテムを生成
     *
     * @param item            アイテム
     * @param textureLocation ロケーション
     * @return モデル
     */
    @NotNull
    default MutableFileModel basicFlatItem(@NotNull Item item, @NotNull ResourceLocation textureLocation) {
        return basicFlatItem(item, FileTexture.of(textureLocation));
    }

    /**
     * 通常の板状アイテムを生成
     *
     * @param item        アイテム
     * @param itemTexture ファイルテクスチャ
     * @return モデル
     */
    @NotNull
    MutableFileModel basicFlatItem(@NotNull Item item, @NotNull FileTexture itemTexture);

    /**
     * 通常の板状アイテムを生成
     *
     * @param itemLocation    アイテムロケーション
     * @param textureLocation テクスチャロケーション
     * @return モデル
     */
    @NotNull
    default MutableFileModel basicFlatItem(@NotNull ResourceLocation itemLocation, @NotNull ResourceLocation textureLocation) {
        return basicFlatItem(itemLocation, FileTexture.of(textureLocation));
    }

    /**
     * 通常の板状アイテムを生成
     *
     * @param itemLocation テクスチャロケーション
     * @param itemTexture  ファイルテクスチャ
     * @return モデル
     */
    @NotNull
    MutableFileModel basicFlatItem(@NotNull ResourceLocation itemLocation, @NotNull FileTexture itemTexture);

    /**
     * 剣や棒の持ち方をする板状アイテムを生成
     *
     * @param item アイテム
     * @return モデル
     */
    @NotNull
    MutableFileModel handheldFlatItem(@NotNull Item item);

    /**
     * 剣や棒の持ち方をする板状アイテムを生成
     *
     * @param itemLocation アイテムロケーション
     * @return モデル
     */
    @NotNull
    default MutableFileModel handheldFlatItem(@NotNull ResourceLocation itemLocation) {
        return handheldFlatItem(FileTexture.of(itemLocation));
    }

    /**
     * 剣や棒の持ち方をする板状アイテムを生成
     *
     * @param itemTexture ファイルテクスチャ
     * @return モデル
     */
    @NotNull
    MutableFileModel handheldFlatItem(@NotNull FileTexture itemTexture);

    /**
     * ビルトインエンティティアイテム
     *
     * @param item アイテム
     * @return モデル
     */
    @NotNull
    default MutableFileModel builtinEntityItem(@NotNull Item item) {
        return parentedItem(item, ResourceLocation.parse("builtin/entity"));
    }

    /**
     * ビルトインエンティティアイテム
     *
     * @param itemLocation アイテムロケーション
     * @return モデル
     */
    @NotNull
    default MutableFileModel builtinEntityItem(@NotNull ResourceLocation itemLocation) {
        return parentedItem(itemLocation, ResourceLocation.parse("builtin/entity"));
    }

    /**
     * 親モデルを継承するアイテム
     *
     * @param item           アイテム
     * @param parentLocation 親モデルのロケーション
     * @return モデル
     */
    @NotNull
    MutableFileModel parentedItem(@NotNull Item item, @NotNull ResourceLocation parentLocation);

    /**
     * 親モデルを継承するアイテム
     *
     * @param itemLocation   アイテムロケーション
     * @param parentLocation 親モデルのロケーション
     * @return モデル
     */
    @NotNull
    MutableFileModel parentedItem(@NotNull ResourceLocation itemLocation, @NotNull ResourceLocation parentLocation);

    /**
     * 既存のモデル
     *
     * @param location ロケーション
     * @return モデル
     */
    @NotNull
    FileModel existingModel(@NotNull ResourceLocation location);
}
