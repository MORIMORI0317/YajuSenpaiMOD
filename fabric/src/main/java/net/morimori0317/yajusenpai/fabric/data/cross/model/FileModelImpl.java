package net.morimori0317.yajusenpai.fabric.data.cross.model;

import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.model.FileModel;
import org.jetbrains.annotations.NotNull;

public class FileModelImpl implements FileModel {
    private final ResourceLocation location;

    public FileModelImpl(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public @NotNull ResourceLocation getLocation() {
        return location;
    }
}
