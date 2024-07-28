package net.morimori0317.yajusenpai.fabric.data.cross.model;

import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.model.FileModel;
import net.morimori0317.yajusenpai.data.cross.model.MutableFileModel;
import net.morimori0317.yajusenpai.data.cross.model.OverridePredicate;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MutableFileModelImpl extends FileModelImpl implements MutableFileModel {
    private final JsonModelInjector jsonModelInjector;

    public MutableFileModelImpl(ResourceLocation location, JsonModelInjector jsonModelInjector) {
        super(location);
        this.jsonModelInjector = jsonModelInjector;
    }

    @Override
    public MutableFileModel override(@NotNull FileModel model, @NotNull List<OverridePredicate> predicates) {
        this.jsonModelInjector.putOverride(model, predicates);
        return this;
    }

    @Override
    public MutableFileModel texture(@NotNull String id, @NotNull ResourceLocation location) {
        this.jsonModelInjector.putTexture(id, location);
        return this;
    }
}
