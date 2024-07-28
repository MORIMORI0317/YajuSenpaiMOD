package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

public interface DataProviderWrapperBase {
    CrossDataGeneratorAccess getCrossGeneratorAccess();

    default ResourceLocation modLoc(String id) {
        return ResourceLocation.fromNamespaceAndPath(getCrossGeneratorAccess().getMod().getModId(), id);
    }

    default DataGenerator getGenerator() {
        return getCrossGeneratorAccess().getVanillaGenerator();
    }
}
