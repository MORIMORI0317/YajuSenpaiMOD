package net.morimori0317.yajusenpai.neoforge.data.cross.model;

import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.model.FileModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import org.jetbrains.annotations.NotNull;

public class FileModelImpl implements FileModel {
    private final ModelFile modelFile;

    public FileModelImpl(ModelFile modelFile) {
        this.modelFile = modelFile;
    }

    @Override
    public @NotNull ResourceLocation getLocation() {
        return modelFile.getLocation();
    }

    public static ModelFile getModelFile(FileModel fileModel) {
        if (fileModel instanceof FileModelImpl fmi)
            return fmi.modelFile;

        throw new IllegalStateException("Not forge impl model file");
    }
}