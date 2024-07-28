package net.morimori0317.yajusenpai.fabric.data.cross;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import org.jetbrains.annotations.NotNull;

public interface CrossDataGeneratorAccesses {
    @NotNull
    static CrossDataGeneratorAccess create(FabricDataGenerator fabricDataGenerator) {
        return new CrossDataGeneratorAccessImpl(fabricDataGenerator);
    }
}
