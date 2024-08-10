package net.morimori0317.yajusenpai.server.level.structure;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePieceAccessor;
import net.minecraft.world.level.levelgen.structure.TemplateStructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.morimori0317.yajusenpai.util.YJUtils;

public class YJHousePieces {
    private static final ResourceLocation STRUCTURE_LOCATION_YJ_HOUSE = YJUtils.modLoc("yj_house");

    public static void addPieces(StructureTemplateManager structureTemplateManager, BlockPos blockPos, Rotation rotation, StructurePieceAccessor structurePieceAccessor, RandomSource randomSource) {
        structurePieceAccessor.addPiece(new YJHousePiece(structureTemplateManager, STRUCTURE_LOCATION_YJ_HOUSE, blockPos, rotation, 21));
    }

    public static class YJHousePiece extends TemplateStructurePiece {

        public YJHousePiece(StructureTemplateManager structureTemplateManager, ResourceLocation resourceLocation, BlockPos blockPos, Rotation rotation, int i) {
            super(YJStructurePieceType.YJ_HOUSE.get(), 0, structureTemplateManager, resourceLocation, resourceLocation.toString(), makeSettings(rotation, resourceLocation), blockPos.below(i));
        }

        public YJHousePiece(StructureTemplateManager structureTemplateManager, CompoundTag compoundTag) {
            super(YJStructurePieceType.YJ_HOUSE.get(), compoundTag, structureTemplateManager, (resourceLocation) -> makeSettings(Rotation.valueOf(compoundTag.getString("Rot")), resourceLocation));
        }

        private static StructurePlaceSettings makeSettings(Rotation rotation, ResourceLocation resourceLocation) {
            return new StructurePlaceSettings().setRotation(rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK);
        }

        @Override
        protected void handleDataMarker(String string, BlockPos blockPos, ServerLevelAccessor serverLevelAccessor, RandomSource randomSource, BoundingBox boundingBox) {

        }

        @Override
        protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
            super.addAdditionalSaveData(structurePieceSerializationContext, compoundTag);
            compoundTag.putString("Rot", this.placeSettings.getRotation().name());
        }
    }
}