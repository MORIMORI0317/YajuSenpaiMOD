package net.morimori0317.yajusenpai.neoforge.data.cross;

import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

public interface CrossDataGeneratorAccesses {
    @NotNull
    static CrossDataGeneratorAccess create(GatherDataEvent gatherDataEvent) {
        return new CrossDataGeneratorAccessImpl(gatherDataEvent);
    }
}
