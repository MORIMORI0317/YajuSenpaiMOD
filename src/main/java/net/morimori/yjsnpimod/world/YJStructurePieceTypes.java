package net.morimori.yjsnpimod.world;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.morimori.yjsnpimod.YJSNPIMOD;

public class YJStructurePieceTypes {
    public static final StructurePieceType MY_PIECE = YJHousePieces.YJHousePiece::new;
    public static void init() {
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(YJSNPIMOD.MODID, "yjhouse_piece"), MY_PIECE);
    }
}
