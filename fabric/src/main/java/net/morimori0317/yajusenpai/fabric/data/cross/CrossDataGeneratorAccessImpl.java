package net.morimori0317.yajusenpai.fabric.data.cross;

import com.google.common.collect.ImmutableList;
import dev.architectury.platform.Mod;
import dev.architectury.platform.Platform;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.*;
import net.morimori0317.yajusenpai.fabric.data.cross.provider.*;
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
    private final FabricDataGenerator fabricDataGenerator;
    private final FabricDataGenerator.Pack pack;

    protected CrossDataGeneratorAccessImpl(FabricDataGenerator fabricDataGenerator) {
        this.fabricDataGenerator = fabricDataGenerator;
        this.pack = fabricDataGenerator.createPack();
    }

    @Override
    public @NotNull DataGenerator getVanillaGenerator() {
        return fabricDataGenerator;
    }

    @Override
    public <T extends DataProvider> T addProvider(DataProvider.@NotNull Factory<T> factory) {
        return pack.addProvider(factory);
    }

    @Override
    public <T extends DataProvider> T addProvider(@NotNull BiFunction<PackOutput, CompletableFuture<HolderLookup.Provider>, T> dataProviderSupplier) {
        return pack.addProvider(dataProviderSupplier::apply);
    }

    @Override
    public Mod getMod() {
        return Platform.getMod(fabricDataGenerator.getModId());
    }

    @Override
    public RecipeProvider createRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, RecipeProviderWrapper recipeProviderWrapper) {
        return new WrappedFabricRecipeProvider((FabricDataOutput) packOutput, lookup, recipeProviderWrapper);
    }

    @Override
    public TagsProvider<Item> createItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, ItemTagProviderWrapper itemTagProviderWrapper, @NotNull BlockTagProviderWrapper blockTagProviderWrapper) {
        var blockTagsProvider = blockTagProviderWrapper.getProvider();
        if (!(blockTagsProvider instanceof FabricTagProvider.BlockTagProvider blockTagProvider))
            throw new IllegalArgumentException("Not FabricTagProvider.BlockTagProvider");
        return new WrappedFabricItemTagProvider((FabricDataOutput) packOutput, lookup, blockTagProvider, itemTagProviderWrapper);
    }

    @Override
    public TagsProvider<Fluid> createFluidTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, FluidTagProviderWrapper fluidTagProviderWrapper) {
        return new WrappedFabricFluidTagProvider((FabricDataOutput) packOutput, lookup, fluidTagProviderWrapper);
    }

    @Override
    public TagsProvider<Block> createBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, BlockTagProviderWrapper blockTagProviderWrapper) {
        return new WrappedFabricBlockTagProvider((FabricDataOutput) packOutput, lookup, blockTagProviderWrapper);
    }

    @Override
    public TagsProvider<PoiType> createPoiTypeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, PoiTypeTagProviderWrapper poiTypeTagProviderWrapper) {
        return new WrappedFabricPoiTypeTagProvider((FabricDataOutput) packOutput, lookup, poiTypeTagProviderWrapper);
    }

    @Override
    public TagsProvider<DamageType> createDamageTypeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, DamageTypeTagsProviderWrapper damageTypeTagsProviderWrapper, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        return new WrappedFabricDamageTypeTagProvider((FabricDataOutput) packOutput, lookup, damageTypeTagsProviderWrapper);
    }

    @Override
    public TagsProvider<Enchantment> createEnchantmentTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, EnchantmentTagsProviderWrapper enchantmentTagsProviderWrapper, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        return new WrappedFabricEnchantmentTagProvider((FabricDataOutput) packOutput, lookup, enchantmentTagsProviderWrapper);
    }

    @Override
    public TagsProvider<Biome> createBiomeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, BiomeTagsProviderWrapper biomeTagsProviderWrapper, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        return new WrappedFabricBiomeTagProvider((FabricDataOutput) packOutput, lookup, biomeTagsProviderWrapper);
    }

    @Override
    public DataProvider createBasicProvider(BasicProviderWrapper basicProviderWrapper) {
        return new WrappedFabricBasicProvider(basicProviderWrapper);
    }

    @Override
    public DataProvider createBlockLootTableProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup, BlockLootTableProviderWrapper blockLootTableProviderWrapper) {
        return new WrappedFabricBlockLootTableProvider((FabricDataOutput) packOutput, registryLookup, blockLootTableProviderWrapper);
    }

    @Override
    public DataProvider createAdvancementProvider(PackOutput packOutput, AdvancementProviderWrapper advancementProviderWrapper, CompletableFuture<HolderLookup.Provider> registryLookup, List<AdvancementSubProviderWrapper> subProviderWrappers) {
        return new WrappedFabricAdvancementProvider((FabricDataOutput) packOutput, registryLookup, advancementProviderWrapper, subProviderWrappers);
    }

    @Override
    public DataProvider createItemModelProvider(PackOutput packOutput, ItemModelProviderWrapper itemModelProviderWrapper) {
        return new WrappedFabricItemModelProvider((FabricDataOutput) packOutput, itemModelProviderWrapper);
    }

    @Override
    public DataProvider createBlockStateAndModelProvider(PackOutput packOutput, BlockStateAndModelProviderWrapper blockStateAndModelProviderWrapper) {
        return new WrappedFabricBlockModelProvider((FabricDataOutput) packOutput, this, blockStateAndModelProviderWrapper);
    }

    @Override
    public DataProvider createRegistriesDatapackGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, RegistriesDatapackProviderWrapper registriesDatapackProviderWrapper) {
        return new WrappedFabricDynamicRegistryProvider((FabricDataOutput) packOutput, lookup, registriesDatapackProviderWrapper);
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
