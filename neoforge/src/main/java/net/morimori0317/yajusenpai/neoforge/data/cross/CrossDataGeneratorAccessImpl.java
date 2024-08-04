package net.morimori0317.yajusenpai.neoforge.data.cross;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import dev.architectury.platform.Mod;
import dev.architectury.platform.Platform;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.*;
import net.morimori0317.yajusenpai.neoforge.data.cross.provider.*;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

@ApiStatus.Internal
public class CrossDataGeneratorAccessImpl implements CrossDataGeneratorAccess {
    private final List<Path> resourceInputFolders = new ArrayList<>();
    private final GatherDataEvent gatherDataEvent;

    protected CrossDataGeneratorAccessImpl(GatherDataEvent gatherDataEvent) {
        this.gatherDataEvent = gatherDataEvent;
    }

    @Override
    public @NotNull DataGenerator getVanillaGenerator() {
        return gatherDataEvent.getGenerator();
    }

    @Override
    public <T extends DataProvider> T addProvider(DataProvider.@NotNull Factory<T> factory) {
        return getVanillaGenerator().addProvider(true, factory);
    }

    @Override
    public <T extends DataProvider> T addProvider(@NotNull BiFunction<PackOutput, CompletableFuture<HolderLookup.Provider>, T> dataProviderSupplier) {
        var lookup = gatherDataEvent.getLookupProvider();
        return getVanillaGenerator().addProvider(true, (DataProvider.Factory<T>) arg -> dataProviderSupplier.apply(arg, lookup));
    }

    @Override
    public Mod getMod() {
        return Platform.getMod(gatherDataEvent.getModContainer().getModId());
    }

    @Override
    public RecipeProvider createRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, RecipeProviderWrapper recipeProviderWrapper) {
        return new WrappedRecipeProvider(packOutput, lookup, recipeProviderWrapper);
    }

    @Override
    public TagsProvider<Item> createItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, ItemTagProviderWrapper itemTagProviderWrapper, @NotNull BlockTagProviderWrapper blockTagProviderWrapper) {
        if (!(blockTagProviderWrapper.getProvider() instanceof BlockTagsProvider blockTagsProvider))
            throw new IllegalArgumentException("Not BlockTagsProvider");


        return new WrappedItemTagsProvider(packOutput, lookup, blockTagsProvider.contentsGetter(), gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), itemTagProviderWrapper);
    }

    @Override
    public TagsProvider<Fluid> createFluidTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, FluidTagProviderWrapper fluidTagProviderWrapper) {
        return new WrappedFluidTagsProvider(packOutput, lookup, fluidTagProviderWrapper, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper());
    }

    @Override
    public TagsProvider<Block> createBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, BlockTagProviderWrapper blockTagProviderWrapper) {
        return new WrappedBlockTagsProvider(packOutput, lookup, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), blockTagProviderWrapper);
    }

    @Override
    public TagsProvider<PoiType> createPoiTypeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, PoiTypeTagProviderWrapper poiTypeTagProviderWrapper) {
        return new WrappedPoiTypeTagsProvider(packOutput, lookup, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), poiTypeTagProviderWrapper);
    }

    @Override
    public TagsProvider<DamageType> createDamageTypeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, DamageTypeTagsProviderWrapper damageTypeTagsProviderWrapper, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        CompletableFuture<HolderLookup.Provider> lookupProvider = lookup;

        if (registriesDatapackProviderWrapper != null) {
            lookupProvider = registriesDatapackProviderWrapper.getLookupProvider();
        }

        return new WrappedDamageTypeTagsProvider(packOutput, lookupProvider, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), damageTypeTagsProviderWrapper);
    }

    @Override
    public TagsProvider<Enchantment> createEnchantmentTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, EnchantmentTagsProviderWrapper enchantmentTagsProviderWrapper, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        CompletableFuture<HolderLookup.Provider> lookupProvider = lookup;

        if (registriesDatapackProviderWrapper != null) {
            lookupProvider = registriesDatapackProviderWrapper.getLookupProvider();
        }

        return new WrappedEnchantmentTagsProvider(packOutput, lookupProvider, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), enchantmentTagsProviderWrapper);
    }

    @Override
    public TagsProvider<Biome> createBiomeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, BiomeTagsProviderWrapper biomeTagsProviderWrapper, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        CompletableFuture<HolderLookup.Provider> lookupProvider = lookup;

        if (registriesDatapackProviderWrapper != null) {
            lookupProvider = registriesDatapackProviderWrapper.getLookupProvider();
        }

        return new WrappedBiomeTagsProvider(packOutput, lookupProvider, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), biomeTagsProviderWrapper);
    }

    @Override
    public TagsProvider<PaintingVariant> createPaintingVariantTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, PaintingVariantTagsProviderWrapper paintingVariantTagsProviderWrapper, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        CompletableFuture<HolderLookup.Provider> lookupProvider = lookup;

        if (registriesDatapackProviderWrapper != null) {
            lookupProvider = registriesDatapackProviderWrapper.getLookupProvider();
        }

        return new WrappedPaintingVariantTagsProvider(packOutput, lookupProvider, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), paintingVariantTagsProviderWrapper);
    }

    @Override
    public DataProvider createBasicProvider(BasicProviderWrapper basicProviderWrapper) {
        return new WrappedBasicProvider(basicProviderWrapper);
    }

    @Override
    public DataProvider createBlockLootTableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup, BlockLootTableProviderWrapper blockLootTableProviderWrapper) {
        return new WrappedBlockLootTableProvider(packOutput, blockLootTableProviderWrapper, registryLookup);
    }


    @Override
    public DataProvider createAdvancementProvider(PackOutput packOutput, AdvancementProviderWrapper advancementProviderWrapper, CompletableFuture<HolderLookup.Provider> registryLookup, List<AdvancementSubProviderWrapper> subProviderWrappers) {
        return new WrappedAdvancementProvider(getVanillaGenerator().getPackOutput(), registryLookup, subProviderWrappers, advancementProviderWrapper);
    }

    @Override
    public DataProvider createItemModelProvider(PackOutput packOutput, ItemModelProviderWrapper itemModelProviderWrapper) {
        return new WrappedItemModelProvider(packOutput, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), itemModelProviderWrapper);
    }

    @Override
    public DataProvider createBlockStateAndModelProvider(PackOutput packOutput, BlockStateAndModelProviderWrapper blockStateAndModelProviderWrapper) {
        return new WrappedBlockStateProvider(packOutput, gatherDataEvent.getModContainer().getModId(), gatherDataEvent.getExistingFileHelper(), blockStateAndModelProviderWrapper);
    }

    @Override
    public DataProvider createRegistriesDatapackGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        return new DatapackBuiltinEntriesProvider(packOutput, lookup, registriesDatapackProviderWrapper.getRegistrySetBuilder(), ImmutableSet.of(gatherDataEvent.getModContainer().getModId()));
    }

    @Override
    public Collection<Path> getResourceInputFolders() {
        return ImmutableList.copyOf(resourceInputFolders);
    }

    @Override
    public void addResourceInputFolders(Path path) {
        resourceInputFolders.add(path);
    }
}
