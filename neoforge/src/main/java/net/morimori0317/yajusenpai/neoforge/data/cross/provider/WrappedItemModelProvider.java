package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.data.cross.provider.ItemModelProviderWrapper;
import net.morimori0317.yajusenpai.neoforge.data.cross.model.ItemModelProviderAccessImpl;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class WrappedItemModelProvider extends ItemModelProvider {
    private final ItemModelProviderWrapper itemModelProviderWrapper;

    public WrappedItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper, ItemModelProviderWrapper itemModelProviderWrapper) {
        super(output, modid, existingFileHelper);
        this.itemModelProviderWrapper = itemModelProviderWrapper;
    }

    @Override
    protected void registerModels() {
        this.itemModelProviderWrapper.generateItemModels(new ItemModelProviderAccessImpl(this));
    }
}
