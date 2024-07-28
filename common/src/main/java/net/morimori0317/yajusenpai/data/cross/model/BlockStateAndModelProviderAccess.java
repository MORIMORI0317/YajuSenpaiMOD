package net.morimori0317.yajusenpai.data.cross.model;

import com.google.gson.JsonElement;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * それぞれのプラットフォームで同じ動作をするブロックステータスとブロックモデル生成
 */
public interface BlockStateAndModelProviderAccess {

    /**
     * 板状のブロックのアイテムモデルを生成
     *
     * @param block ブロック
     */
    void simpleFlatBlockItemModel(@NotNull Block block);

    /**
     * 存在を未確認のファイルモデルを取得
     *
     * @param modelLocation モデルロケーション
     * @return モデル
     */
    @NotNull
    FileModel uncheckedModel(@NotNull ResourceLocation modelLocation);

    /**
     * 階段ブロックのモデルとブロックステータスの生成、アイテムモデルの生成
     *
     * @param stairBlock 階段ブロック
     */
    void stairsBlockItemModel(@NotNull StairBlock stairBlock, @NotNull FileModel baseBlockModel);

    /**
     * ハーフブロックのモデルとブロックステータスの生成、アイテムモデルの生成
     *
     * @param slabBlock      ハーフブロック
     * @param baseBlockModel ベースとなるブロックのモデル
     */
    void slabBlockItemModel(@NotNull SlabBlock slabBlock, @NotNull FileModel baseBlockModel);

    /**
     * 原木のモデルとブロックステータスの生成、アイテムモデルの生成
     *
     * @param block 原木ブロック
     */
    void logBlockItemModel(@NotNull RotatedPillarBlock block);

    /**
     * モデル出力を取得
     *
     * @return モデル出力
     */
    @NotNull
    BiConsumer<ResourceLocation, Supplier<JsonElement>> modelOutput();

    /**
     * 簡素な立方体ブロックのステート、ブロックモデル、アイテムモデルを生成する
     *
     * @param block ブロック
     */
    void simpleCubeBlockStateModelAndItemModel(@NotNull Block block);

    /**
     * 全面同じテクスチャのブロックモデルを生成
     *
     * @param blockLocation   ブロックロケーション
     * @param textureLocation テクスチャロケーション
     * @return モデル
     */
    @NotNull
    default FileModel cubeAllBlockModel(@NotNull ResourceLocation blockLocation, @NotNull ResourceLocation textureLocation) {
        return cubeAllBlockModel(blockLocation, FileTexture.of(textureLocation));
    }

    /**
     * 全面同じテクスチャのブロックモデルを生成
     *
     * @param blockLocation ブロックロケーション
     * @param fileTexture   ファイルテクスチャ
     * @return モデル
     */
    @NotNull
    FileModel cubeAllBlockModel(@NotNull ResourceLocation blockLocation, @NotNull FileTexture fileTexture);

    /**
     * 全面同じテクスチャのブロックモデルを生成
     *
     * @param block           ブロック
     * @param textureLocation テクスチャロケーション
     * @return モデル
     */
    @NotNull
    default FileModel cubeAllBlockModel(@NotNull Block block, @NotNull ResourceLocation textureLocation) {
        return cubeAllBlockModel(block, FileTexture.of(textureLocation));
    }

    /**
     * 全面同じテクスチャのブロックモデルを生成
     *
     * @param block       ブロック
     * @param fileTexture ファイルテクスチャ
     * @return モデル
     */
    @NotNull
    FileModel cubeAllBlockModel(@NotNull Block block, @NotNull FileTexture fileTexture);

    /**
     * それぞれの方向で違うテクスチャを指定する
     *
     * @param blockLocation ブロックロケーション
     * @param down          下側のテクスチャ
     * @param up            上側のテクスチャ
     * @param north         北側のテクスチャ
     * @param south         南側のテクスチャ
     * @param east          東側のテクスチャ
     * @param west          西側のテクスチャ
     * @return モデル
     */
    @NotNull
    FileModel cubeBlockModel(@NotNull ResourceLocation blockLocation, @NotNull FileTexture down, @NotNull FileTexture up, @NotNull FileTexture north, @NotNull FileTexture south, @NotNull FileTexture east, @NotNull FileTexture west);

    /**
     * それぞれの方向で違うテクスチャを指定する
     *
     * @param blockLocation ブロックロケーション
     * @param down          下側のテクスチャ
     * @param up            上側のテクスチャ
     * @param north         北側のテクスチャ
     * @param south         南側のテクスチャ
     * @param east          東側のテクスチャ
     * @param west          西側のテクスチャ
     * @return モデル
     */
    @NotNull
    default FileModel cubeBlockModel(@NotNull ResourceLocation blockLocation, @NotNull ResourceLocation down, @NotNull ResourceLocation up, @NotNull ResourceLocation north, @NotNull ResourceLocation south, @NotNull ResourceLocation east, @NotNull ResourceLocation west) {
        return cubeBlockModel(blockLocation, FileTexture.of(down), FileTexture.of(up), FileTexture.of(north), FileTexture.of(south), FileTexture.of(east), FileTexture.of(west));
    }

    /**
     * それぞれの方向で違うテクスチャを指定する
     *
     * @param block ブロック
     * @param down  下側のテクスチャ
     * @param up    上側のテクスチャ
     * @param north 北側のテクスチャ
     * @param south 南側のテクスチャ
     * @param east  東側のテクスチャ
     * @param west  西側のテクスチャ
     * @return モデル
     */
    @NotNull
    default FileModel cubeBlockModel(@NotNull Block block, @NotNull ResourceLocation down, @NotNull ResourceLocation up, @NotNull ResourceLocation north, @NotNull ResourceLocation south, @NotNull ResourceLocation east, @NotNull ResourceLocation west) {
        return cubeBlockModel(block, FileTexture.of(down), FileTexture.of(up), FileTexture.of(north), FileTexture.of(south), FileTexture.of(east), FileTexture.of(west));
    }

    /**
     * それぞれの方向で違うテクスチャを指定する
     *
     * @param block ブロック
     * @param down  下側のテクスチャ
     * @param up    上側のテクスチャ
     * @param north 北側のテクスチャ
     * @param south 南側のテクスチャ
     * @param east  東側のテクスチャ
     * @param west  西側のテクスチャ
     * @return モデル
     */
    @NotNull
    FileModel cubeBlockModel(@NotNull Block block, @NotNull FileTexture down, @NotNull FileTexture up, @NotNull FileTexture north, @NotNull FileTexture south, @NotNull FileTexture east, @NotNull FileTexture west);

    /**
     * 上下と側面ごとに違うテクスチャを指定する
     *
     * @param blockLocation ブロックロケーション
     * @param bottom        下側のテクスチャ
     * @param side          側面のテクスチャ
     * @param top           上側のテクスチャ
     * @return モデル
     */
    @NotNull
    default FileModel cubeBottomTopBlockModel(@NotNull ResourceLocation blockLocation, @NotNull ResourceLocation bottom, @NotNull ResourceLocation side, @NotNull ResourceLocation top) {
        return cubeBottomTopBlockModel(blockLocation, FileTexture.of(bottom), FileTexture.of(side), FileTexture.of(top));
    }

    /**
     * 上下と側面ごとに違うテクスチャを指定する
     *
     * @param blockLocation ブロックロケーション
     * @param bottom        下側のテクスチャ
     * @param side          側面のテクスチャ
     * @param top           上側のテクスチャ
     * @return モデル
     */
    @NotNull
    FileModel cubeBottomTopBlockModel(@NotNull ResourceLocation blockLocation, @NotNull FileTexture bottom, @NotNull FileTexture side, @NotNull FileTexture top);

    /**
     * 上下と側面ごとに違うテクスチャを指定する
     *
     * @param block  ブロック
     * @param bottom 下側のテクスチャ
     * @param side   側面のテクスチャ
     * @param top    上側のテクスチャ
     * @return モデル
     */
    @NotNull
    default FileModel cubeBottomTopBlockModel(@NotNull Block block, @NotNull ResourceLocation bottom, @NotNull ResourceLocation side, @NotNull ResourceLocation top) {
        return cubeBottomTopBlockModel(bottom, FileTexture.of(bottom), FileTexture.of(side), FileTexture.of(top));
    }

    /**
     * 上下と側面ごとに違うテクスチャを指定する
     *
     * @param block  ブロック
     * @param bottom 下側のテクスチャ
     * @param side   側面のテクスチャ
     * @param top    上側のテクスチャ
     * @return モデル
     */
    @NotNull
    FileModel cubeBottomTopBlockModel(@NotNull Block block, @NotNull FileTexture bottom, @NotNull FileTexture side, @NotNull FileTexture top);

    /**
     * 親モデルを継承するブロックモデル
     *
     * @param block          ブロック
     * @param parentLocation 親モデルのロケーション
     * @return モデル
     */
    @NotNull
    MutableFileModel parentedBlockModel(@NotNull Block block, @NotNull ResourceLocation parentLocation);

    /**
     * 既存のモデル
     *
     * @param location ロケーション
     * @return モデル
     */
    @NotNull
    FileModel existingModel(@NotNull ResourceLocation location);

    /**
     * パーティクルのみのモデル
     *
     * @param block            ブロック
     * @param particleLocation パーティクルのテクスチャロケーション
     * @return モデル
     */
    @NotNull
    default FileModel particleOnlyModel(@NotNull Block block, @NotNull ResourceLocation particleLocation) {
        return particleOnlyModel(block, FileTexture.of(particleLocation));
    }

    @NotNull
    FileModel particleOnlyModel(@NotNull Block block, @NotNull FileTexture particleLocation);

    /**
     * 指定のモデルが常時適用されるステート
     *
     * @param block ブロック
     * @param model モデル
     */
    void simpleBlockState(@NotNull Block block, @NotNull FileModel model);

    /**
     * 指定のブロックモデルを継承するアイテムモデルを生成<br>
     * Fabricの場合、ステートを登録していればアイテムモデル未登録でも勝手に自動登録される。<br>
     * でもForgeでは自動登録されないのでこれを利用してください。
     *
     * @param block ブロック
     * @param model モデル
     */
    void simpleBlockItemModel(@NotNull Block block, @NotNull FileModel model);

    /**
     * 方向によって回転するステート
     *
     * @param block ブロック
     * @param model モデル
     */
    void horizontalBlockState(@NotNull Block block, @NotNull FileModel model);

    /**
     * ビルトインエンティティのアイテムモデル
     *
     * @param block ブロック
     */
    default void builtinEntityBlockItemModel(@NotNull Block block) {
        parentedBlockItemModel(block, ResourceLocation.parse("builtin/entity"));
    }

    /**
     * 指定のモデルロケーションを継承するアイテムもでるを生成
     *
     * @param block          ブロック
     * @param parentLocation 親モデルのロケーション
     */
    void parentedBlockItemModel(@NotNull Block block, @NotNull ResourceLocation parentLocation);

    /**
     * ブロックステートジェネレーターを登録
     *
     * @param blockStateGenerator ブロックステートジェネレーター
     */
    void addBlockStateGenerator(@NotNull BlockStateGenerator blockStateGenerator);

    /**
     * アイテムのモデルを生成する場合に利用するアイテム生成へのアクセスを取得
     *
     * @return アイテム生成へのアクセス
     */
    ItemModelProviderAccess itemModelProviderAccess();
}
