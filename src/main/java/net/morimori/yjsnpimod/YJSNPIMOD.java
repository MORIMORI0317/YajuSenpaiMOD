package net.morimori.yjsnpimod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.EntityTrackingEvents;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.blockentity.YJBlockEntityTypes;
import net.morimori.yjsnpimod.enchantment.YJEnchantments;
import net.morimori.yjsnpimod.entity.YJEntityTypes;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.registry.StructureReplace;
import net.morimori.yjsnpimod.registry.YJDimensions;
import net.morimori.yjsnpimod.registry.YJMotives;
import net.morimori.yjsnpimod.registry.YJSoundEvents;
import net.morimori.yjsnpimod.world.YJBiomes;
import net.morimori.yjsnpimod.world.YJFeatures;
import net.morimori.yjsnpimod.world.YJStructureFeatures;
import net.morimori.yjsnpimod.world.YJStructurePieceTypes;

public class YJSNPIMOD implements ModInitializer {
    public static final String MODID = "yjsnpimod";

    @Override
    public void onInitialize() {
        YJItems.init();
        YJBlocks.init();
        YJEnchantments.init();
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
