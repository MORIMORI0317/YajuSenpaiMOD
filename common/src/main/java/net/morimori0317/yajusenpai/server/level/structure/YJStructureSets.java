package net.morimori0317.yajusenpai.server.level.structure;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;
import net.morimori0317.yajusenpai.data.cross.provider.RegistriesDatapackProviderWrapper;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJStructureSets {
    public static final ResourceKey<StructureSet> YJ_HOUSES = ResourceKey.create(Registries.STRUCTURE_SET, YJUtils.modLoc("yj_houses"));

    public static void register(RegistriesDatapackProviderWrapper.DynamicRegister<StructureSet> register) {
        register.add(YJ_HOUSES, context -> {
            HolderGetter<Structure> structureHolderGetter = context.lookup(Registries.STRUCTURE);
            return new StructureSet(structureHolderGetter.getOrThrow(YJStructures.YJ_HOUSE),
                    new RandomSpreadStructurePlacement(36, 19, RandomSpreadType.LINEAR, 1131796));
        });
    }
}