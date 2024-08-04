package net.morimori0317.yajusenpai.data;

import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.morimori0317.yajusenpai.data.cross.CrossDataGeneratorAccess;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.enchantment.YJEnchantments;
import net.morimori0317.yajusenpai.entity.damagesource.YJDamageTypes;
import net.morimori0317.yajusenpai.entity.decoration.YJPaintingVariants;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomes;
import net.morimori0317.yajusenpai.server.level.dimension.YJDimensions;
import net.morimori0317.yajusenpai.server.level.dimension.YJNoiseGeneratorSettings;
import net.morimori0317.yajusenpai.server.level.features.YJOreFeatures;
import net.morimori0317.yajusenpai.server.level.features.YJPlacedFeatures;
import net.morimori0317.yajusenpai.server.level.features.YJTreeFeatures;
import net.morimori0317.yajusenpai.server.level.features.YJVegetationFeatures;
import net.morimori0317.yajusenpai.server.level.structure.YJStructureSets;
import net.morimori0317.yajusenpai.server.level.structure.YJStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class YJRegistriesDatapackProvider extends RegistriesDatapackProviderWrapper {
    public static final List<DynamicRegister<?>> REGISTERS = ImmutableList.copyOf(registers());
    public static final Supplier<RegistrySetBuilder> BUILDER = Suppliers.memoize(() -> RegistriesDatapackProviderWrapper.createRegistrySetBuilder(new RegistrySetBuilder(), REGISTERS));

    public YJRegistriesDatapackProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookup, CrossDataGeneratorAccess crossDataGeneratorAccess) {
        super(packOutput, lookup, crossDataGeneratorAccess, REGISTERS, BUILDER);
    }

    private static List<DynamicRegister<?>> registers() {
        List<DynamicRegister<?>> registers = new ArrayList<>();

        DynamicRegister<DamageType> damageTypeRegister = new DynamicRegister<>(Registries.DAMAGE_TYPE);
        YJDamageTypes.register(damageTypeRegister);
        registers.add(damageTypeRegister);

        DynamicRegister<Enchantment> enchantmentRegister = new DynamicRegister<>(Registries.ENCHANTMENT);
        YJEnchantments.register(enchantmentRegister);
        registers.add(enchantmentRegister);

        DynamicRegister<ConfiguredFeature<?, ?>> configuredFeatureRegister = new DynamicRegister<>(Registries.CONFIGURED_FEATURE);
        YJTreeFeatures.register(configuredFeatureRegister);
        YJVegetationFeatures.register(configuredFeatureRegister);
        YJOreFeatures.register(configuredFeatureRegister);
        registers.add(configuredFeatureRegister);

        DynamicRegister<PlacedFeature> placedFeatureRegister = new DynamicRegister<>(Registries.PLACED_FEATURE);
        YJPlacedFeatures.register(placedFeatureRegister);
        registers.add(placedFeatureRegister);

        DynamicRegister<Biome> biomeRegister = new DynamicRegister<>(Registries.BIOME);
        YJBiomes.register(biomeRegister);
        registers.add(biomeRegister);

        DynamicRegister<NoiseGeneratorSettings> noiseGeneratorSettingsRegister = new DynamicRegister<NoiseGeneratorSettings>(Registries.NOISE_SETTINGS);
        YJNoiseGeneratorSettings.register(noiseGeneratorSettingsRegister);
        registers.add(noiseGeneratorSettingsRegister);

        DynamicRegister<LevelStem> levelStemRegister = new DynamicRegister<>(Registries.LEVEL_STEM);
        YJDimensions.register(levelStemRegister);
        registers.add(levelStemRegister);

        DynamicRegister<StructureSet> structureSetRegister = new DynamicRegister<>(Registries.STRUCTURE_SET);
        YJStructureSets.register(structureSetRegister);
        registers.add(structureSetRegister);

        DynamicRegister<Structure> structureRegister = new DynamicRegister<>(Registries.STRUCTURE);
        YJStructures.register(structureRegister);
        registers.add(structureRegister);

        DynamicRegister<PaintingVariant> paintingVariantRegister = new DynamicRegister<>(Registries.PAINTING_VARIANT);
        YJPaintingVariants.register(paintingVariantRegister);
        registers.add(paintingVariantRegister);

        return registers;
    }
}
