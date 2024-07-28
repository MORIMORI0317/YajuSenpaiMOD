package net.morimori0317.yajusenpai.neoforge.data.cross.model;

import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.model.MutableFileModel;
import net.neoforged.neoforge.client.model.generators.ModelBuilder;
import org.jetbrains.annotations.NotNull;

public abstract class MutableFileModelImpl extends FileModelImpl implements MutableFileModel {
    private final ModelBuilder<?> modelBuilder;

    public MutableFileModelImpl(ModelBuilder<?> modelBuilder) {
        super(modelBuilder);
        this.modelBuilder = modelBuilder;
    }

    @Override
    public MutableFileModel texture(@NotNull String id, @NotNull ResourceLocation location) {
        this.modelBuilder.texture(id, location);
        return this;
    }
}
