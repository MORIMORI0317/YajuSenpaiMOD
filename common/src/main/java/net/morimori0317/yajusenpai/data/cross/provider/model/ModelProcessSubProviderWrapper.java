package net.morimori0317.yajusenpai.data.cross.provider.model;

import net.minecraft.data.CachedOutput;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.DataProviderWrapperBase;
import net.morimori0317.yajusenpai.data.cross.provider.ModelProcessProviderWrapper;

import java.util.List;

public abstract class ModelProcessSubProviderWrapper implements DataProviderWrapperBase {
    protected final CrossDataGeneratorAccess crossDataGeneratorAccess;

    public ModelProcessSubProviderWrapper(CrossDataGeneratorAccess crossDataGeneratorAccess) {
        this.crossDataGeneratorAccess = crossDataGeneratorAccess;
    }

    @Override
    public CrossDataGeneratorAccess getCrossGeneratorAccess() {
        return crossDataGeneratorAccess;
    }

    public List<ModelProcessProviderWrapper.ModelData> process(CachedOutput cachedOutput, List<ModelProcessProviderWrapper.ModelData> modelData) {
        return modelData.stream().flatMap(r -> process(cachedOutput, r).stream()).toList();
    }

    public abstract List<ModelProcessProviderWrapper.ModelData> process(CachedOutput cachedOutput, ModelProcessProviderWrapper.ModelData modelData);
}
