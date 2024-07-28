package net.morimori0317.yajusenpai.data.cross.model.impl;

import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.model.FileTexture;
import org.jetbrains.annotations.NotNull;

public record FileTextureImpl(ResourceLocation location, boolean existingCheck) implements FileTexture {
    @Override
    public @NotNull ResourceLocation getLocation() {
        return location;
    }

    @Override
    public boolean isExistingCheck() {
        return existingCheck;
    }
}
