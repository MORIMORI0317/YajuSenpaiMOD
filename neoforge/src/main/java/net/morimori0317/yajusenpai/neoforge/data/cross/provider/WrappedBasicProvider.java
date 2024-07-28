package net.morimori0317.yajusenpai.neoforge.data.cross.provider;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.morimori0317.yajusenpai.data.cross.provider.BasicProviderWrapper;

import java.util.concurrent.CompletableFuture;

public class WrappedBasicProvider implements DataProvider {
    private final BasicProviderWrapper basicProviderWrapper;

    public WrappedBasicProvider(BasicProviderWrapper basicProviderWrapper) {
        this.basicProviderWrapper = basicProviderWrapper;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput arg) {
        return basicProviderWrapper.run(arg);
    }

    @Override
    public String getName() {
        return basicProviderWrapper.getName();
    }
}
