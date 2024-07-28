package net.morimori0317.yajusenpai.fabric.data.cross.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.morimori0317.yajusenpai.data.cross.provider.FluidTagProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class WrappedFabricFluidTagProvider extends FabricTagProvider.FluidTagProvider {
    private final FluidTagProviderWrapper fluidTagProviderWrapper;

    public WrappedFabricFluidTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, FluidTagProviderWrapper fluidTagProviderWrapper) {
        super(output, completableFuture);
        this.fluidTagProviderWrapper = fluidTagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.fluidTagProviderWrapper.generateTag(new FluidTagProviderAccessImpl());
    }

    private class FluidTagProviderAccessImpl implements IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Fluid> {
        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<Fluid> tag(TagKey<Fluid> tagKey) {
            return new WrappedFabricIntrinsicHolderTagsProvider.IntrinsicHolderTagAppenderWrapperImpl<>(WrappedFabricFluidTagProvider.this.tag(tagKey), fluidTagProviderWrapper);
        }
    }
}
