package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.data.PackOutput;
import net.morimori0317.yajusenpai.data.cross.provider.BlockStateAndModelProviderWrapper;
import net.morimori0317.yajusenpai.neoforge.data.cross.model.BlockStateAndModelProviderAccessImpl;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class WrappedBlockStateProvider extends BlockStateProvider {
    private final BlockStateAndModelProviderWrapper blockStateAndModelProviderWrapper;

    public WrappedBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper, BlockStateAndModelProviderWrapper blockStateAndModelProviderWrapper) {
        super(output, modid, exFileHelper);
        this.blockStateAndModelProviderWrapper = blockStateAndModelProviderWrapper;
    }

    @Override
    protected void registerStatesAndModels() {
        this.blockStateAndModelProviderWrapper.generateStatesAndModels(new BlockStateAndModelProviderAccessImpl(this));
    }
}
