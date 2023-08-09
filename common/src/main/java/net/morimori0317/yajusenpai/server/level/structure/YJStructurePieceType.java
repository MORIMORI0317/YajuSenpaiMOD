package net.morimori0317.yajusenpai.server.level.structure;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.morimori0317.yajusenpai.YajuSenpai;

import java.util.function.Supplier;

public class YJStructurePieceType {
    private static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES = DeferredRegister.create(YajuSenpai.MODID, Registries.STRUCTURE_PIECE);

    public static final RegistrySupplier<StructurePieceType> YJ_HOUSE = register("yj_house", () -> (StructurePieceType.StructureTemplateType) YJHousePieces.YJHousePiece::new);

    private static RegistrySupplier<StructurePieceType> register(String name, Supplier<StructurePieceType> structurePieceType) {
        return STRUCTURE_PIECE_TYPES.register(name, structurePieceType);
    }

    public static void init() {
        STRUCTURE_PIECE_TYPES.register();
    }
}
