package net.morimori0317.yajusenpai.server.level.structure;


import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSpawnOverride;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomeTags;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.Map;

public class YJStructures {
    public static final ResourceKey<Structure> YJ_HOUSE = ResourceKey.create(Registries.STRUCTURE, YJUtils.modLoc("yj_house"));

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<Structure> register) {
        register.add(YJ_HOUSE, ctx -> new YJHouseStructure(structure(ctx.lookup(Registries.BIOME).getOrThrow(YJBiomeTags.HAS_YJ_HOUSE), TerrainAdjustment.BEARD_THIN)));
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> holderSet, TerrainAdjustment terrainAdjustment) {
        return structure(holderSet, Map.of(), GenerationStep.Decoration.SURFACE_STRUCTURES, terrainAdjustment);
    }

    private static Structure.StructureSettings structure(HolderSet<Biome> holderSet, Map<MobCategory, StructureSpawnOverride> map, GenerationStep.Decoration decoration, TerrainAdjustment terrainAdjustment) {
        return new Structure.StructureSettings(holderSet, map, decoration, terrainAdjustment);
    }
}