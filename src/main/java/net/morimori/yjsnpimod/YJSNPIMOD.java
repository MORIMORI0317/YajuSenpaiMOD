package net.morimori.yjsnpimod;

import net.fabricmc.api.ModInitializer;
import net.morimori.yjsnpimod.biome.YJBiomes;
import net.morimori.yjsnpimod.biome.YJFeatures;
import net.morimori.yjsnpimod.biome.YJStructureFeatures;
import net.morimori.yjsnpimod.biome.YJStructurePieceTypes;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.blockentity.YJBlockEntityTypes;
import net.morimori.yjsnpimod.entity.YJEntityTypes;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.registry.StructureReplace;
import net.morimori.yjsnpimod.registry.YJDimensions;
import net.morimori.yjsnpimod.registry.YJMotives;
import net.morimori.yjsnpimod.registry.YJSoundEvents;

public class YJSNPIMOD implements ModInitializer {
    public static final String MODID = "yjsnpimod";

    @Override
    public void onInitialize() {
        YJItems.init();
        YJBlocks.init();
        YJBlockEntityTypes.init();
        YJSoundEvents.init();
        YJMotives.init();
        YJFeatures.init();
        YJStructurePieceTypes.init();
        YJStructureFeatures.init();
        YJBiomes.init();
        YJEntityTypes.init();
        YJDimensions.init();
        StructureReplace.init();
    }
}
