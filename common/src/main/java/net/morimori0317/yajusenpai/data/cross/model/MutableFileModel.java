package net.morimori0317.yajusenpai.data.cross.model;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface MutableFileModel extends FileModel {
    MutableFileModel override(@NotNull FileModel model, @NotNull List<OverridePredicate> predicates);

    MutableFileModel texture(@NotNull String id, @NotNull ResourceLocation location);
}
