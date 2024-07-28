package net.morimori0317.yajusenpai.data.cross.provider;

import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.model.ItemModelProviderAccess;

public abstract class ItemModelProviderWrapper extends DataProviderWrapper<DataProvider> {
    private final DataProvider itemModelProvider;

    public ItemModelProviderWrapper(PackOutput packOutput, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, crossDataGeneratorAccess);
        this.itemModelProvider = crossDataGeneratorAccess.createItemModelProvider(packOutput, this);
    }

    @Override
    public DataProvider getProvider() {
        return itemModelProvider;
    }

    public abstract void generateItemModels(ItemModelProviderAccess providerAccess);
}
