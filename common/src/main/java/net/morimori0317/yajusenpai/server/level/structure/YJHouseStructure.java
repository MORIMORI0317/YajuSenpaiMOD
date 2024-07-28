package net.morimori0317.yajusenpai.server.level.structure;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;

import java.util.Optional;

public class YJHouseStructure extends Structure {
    public static final MapCodec<YJHouseStructure> CODEC = simpleCodec(YJHouseStructure::new);

    protected YJHouseStructure(StructureSettings structureSettings) {
        super(structureSettings);
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext generationContext) {
        return onTopOfChunkCenter(generationContext, Heightmap.Types.WORLD_SURFACE_WG, (structurePiecesBuilder) -> {
            this.generatePieces(structurePiecesBuilder, generationContext);
        });
    }

    private void generatePieces(StructurePiecesBuilder structurePiecesBuilder, GenerationContext generationContext) {
        ChunkPos chunkPos = generationContext.chunkPos();
        WorldgenRandom worldgenRandom = generationContext.random();
        BlockPos blockPos = new BlockPos(chunkPos.getMinBlockX(), 90, chunkPos.getMinBlockZ());
        Rotation rotation = Rotation.getRandom(worldgenRandom);

        YJHousePieces.addPieces(generationContext.structureTemplateManager(), blockPos, rotation, structurePiecesBuilder, worldgenRandom);
    }

    @Override
    public StructureType<?> type() {
        return YJStructureTypes.YJ_HOUSE.get();
    }
}