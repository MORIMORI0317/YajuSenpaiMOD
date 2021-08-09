package net.morimori.yjsnpimod.world;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.morimori.yjsnpimod.YJSNPIMOD;

import java.util.Random;

public class YJHousePieces {
    static final ResourceLocation STRUCTURE_LOCATION_YJHOUSE = new ResourceLocation(YJSNPIMOD.MODID, "yjhouse/yjtei");


    public static void addPieces(StructureManager structureManager, BlockPos blockPos, Rotation rotation, StructurePieceAccessor structurePieceAccessor, Random random) {
        structurePieceAccessor.addPiece(new YJHousePiece(structureManager, STRUCTURE_LOCATION_YJHOUSE, blockPos, rotation, 22));
    }

    public static class YJHousePiece extends TemplateStructurePiece {
        public YJHousePiece(StructureManager structureManager, ResourceLocation resourceLocation, BlockPos blockPos, Rotation rotation, int i) {
            super(YJStructurePieceTypes.MY_PIECE, 0, structureManager, resourceLocation, resourceLocation.toString(), makeSettings(rotation, resourceLocation), blockPos.below(i));
        }

        public YJHousePiece(ServerLevel serverLevel, CompoundTag compoundTag) {
            super(YJStructurePieceTypes.MY_PIECE, compoundTag, serverLevel, (resourceLocation) -> makeSettings(Rotation.valueOf(compoundTag.getString("Rot")), resourceLocation));
        }

        @Override
        protected void handleDataMarker(String string, BlockPos blockPos, ServerLevelAccessor serverLevelAccessor, Random random, BoundingBox boundingBox) {

        }

        @Override
        protected void addAdditionalSaveData(ServerLevel serverLevel, CompoundTag compoundTag) {
            super.addAdditionalSaveData(serverLevel, compoundTag);
            compoundTag.putString("Rot", this.placeSettings.getRotation().name());
        }

        private static StructurePlaceSettings makeSettings(Rotation rotation, ResourceLocation resourceLocation) {
            return (new StructurePlaceSettings()).setRotation(rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        }


    }
}