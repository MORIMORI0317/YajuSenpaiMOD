package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.morimori0317.yajusenpai.data.cross.provider.ItemModelProviderWrapper;
import net.morimori0317.yajusenpai.fabric.data.cross.model.ItemModelProviderAccessImpl;


public class WrappedFabricItemModelProvider extends FabricModelProvider {
    private final ItemModelProviderWrapper itemModelProviderWrapper;

    public WrappedFabricItemModelProvider(FabricDataOutput output, ItemModelProviderWrapper itemModelProviderWrapper) {
        super(output);
        this.itemModelProviderWrapper = itemModelProviderWrapper;
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        this.itemModelProviderWrapper.generateItemModels(new ItemModelProviderAccessImpl(itemModelGenerator.output));
    }

    @Override
    public String getName() {
        return "Model Definitions (Item)";
    }
}

