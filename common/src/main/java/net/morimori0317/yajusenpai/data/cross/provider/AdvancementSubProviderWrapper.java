package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.network.chat.Component;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;

import java.util.function.Consumer;

public abstract class AdvancementSubProviderWrapper implements DataProviderWrapperBase {
    protected final CrossDataGeneratorAccess crossDataGeneratorAccess;

    protected AdvancementSubProviderWrapper(CrossDataGeneratorAccess crossDataGeneratorAccess) {
        this.crossDataGeneratorAccess = crossDataGeneratorAccess;
    }

    public abstract void generate(Consumer<AdvancementHolder> consumer);

    protected Component modTitle(String name) {
        return title(getCrossGeneratorAccess().getMod().getModId(), name);
    }

    protected Component title(String category, String name) {
        return Component.translatable(String.format("advancements.%s.%s.title", category, name));
    }

    protected Component modDescription(String name) {
        return description(getCrossGeneratorAccess().getMod().getModId(), name);
    }

    protected Component description(String category, String name) {
        return Component.translatable(String.format("advancements.%s.%s.description", category, name));
    }

    @Override
    public CrossDataGeneratorAccess getCrossGeneratorAccess() {
        return crossDataGeneratorAccess;
    }
}
