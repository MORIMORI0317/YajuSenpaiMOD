package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.morimori0317.yajusenpai.data.cross.provider.FluidTagProviderWrapper;
import net.morimori0317.yajusenpai.data.cross.provider.IntrinsicHolderTagsProviderWrapper;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class WrappedFluidTagsProvider extends FluidTagsProvider {
    private final FluidTagProviderWrapper fluidTagProviderWrapper;

    public WrappedFluidTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, FluidTagProviderWrapper fluidTagProviderWrapper, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, completableFuture, modId, existingFileHelper);
        this.fluidTagProviderWrapper = fluidTagProviderWrapper;
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        this.fluidTagProviderWrapper.generateTag(new FluidTagProviderAccessImpl());
    }

    private class FluidTagProviderAccessImpl implements IntrinsicHolderTagsProviderWrapper.IntrinsicTagProviderAccess<Fluid> {
        @Override
        public IntrinsicHolderTagsProviderWrapper.IntrinsicTagAppenderWrapper<Fluid> tag(TagKey<Fluid> tagKey) {
            return new WrappedIntrinsicHolderTagsProvider.IntrinsicHolderTagAppenderWrapperImpl<>(WrappedFluidTagsProvider.this.tag(tagKey));
        }
    }
}
