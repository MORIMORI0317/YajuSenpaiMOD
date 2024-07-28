package net.morimori0317.yajusenpai.data.cross.model;

import com.google.common.base.Preconditions;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.model.impl.FileTextureImpl;
import org.jetbrains.annotations.NotNull;

/**
 * テクスチャファイルの指定
 */
public interface FileTexture {
    /**
     * リソースロケーションを指定する
     *
     * @param textureLocation テクスチャのリソースロケーション
     * @return テクスチャ指定
     */
    @NotNull
    static FileTexture of(@NotNull ResourceLocation textureLocation) {
        Preconditions.checkNotNull(textureLocation, "TextureLocation is Null");

        return new FileTextureImpl(textureLocation, true);
    }

    /**
     * リソースロケーションを指定する<br>
     * Forgeの存在の検証をスキップする
     *
     * @param textureLocation テクスチャのリソースロケーション
     * @return テクスチャ指定
     */
    @NotNull
    static FileTexture ofUncheck(@NotNull ResourceLocation textureLocation) {
        Preconditions.checkNotNull(textureLocation, "TextureLocation is Null");

        return new FileTextureImpl(textureLocation, false);
    }

    /**
     * リソースロケーションを指定する
     *
     * @param textureLocation テクスチャのリソースロケーション
     * @param existingCheck   存在の検証
     * @return テクスチャ指定
     */
    @NotNull
    static FileTexture of(@NotNull ResourceLocation textureLocation, boolean existingCheck) {
        Preconditions.checkNotNull(textureLocation, "TextureLocation is Null");

        return new FileTextureImpl(textureLocation, existingCheck);
    }

    /**
     * 指定されたテクスチャのリソースロケーション
     *
     * @return リソースロケーション
     */
    @NotNull
    ResourceLocation getLocation();

    /**
     * Forgeの存在の検証を実行するかどうか
     *
     * @return 実行するかどうか
     */
    boolean isExistingCheck();
}
