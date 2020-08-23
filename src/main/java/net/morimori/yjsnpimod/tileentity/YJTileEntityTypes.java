package net.morimori.yjsnpimod.tileentity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ObjectHolder;
import net.morimori.yjsnpimod.YJSNPIMOD;
import net.morimori.yjsnpimod.block.YJBlocks;
import red.felnull.otyacraftengine.util.IKSGRegistryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class YJTileEntityTypes {

    public static List<TileEntityType<?>> MOD_TILEENTITYTYPES = new ArrayList<TileEntityType<?>>();

    @ObjectHolder(YJSNPIMOD.MODID + ":" + "toilet")
    public static TileEntityType<ToiletTileEntity> TOILET = register(ToiletTileEntity::new, new ResourceLocation(YJSNPIMOD.MODID, "toilet"), YJBlocks.TOILET);

    @ObjectHolder(YJSNPIMOD.MODID + ":" + "big_pillow")
    public static TileEntityType<BigPillowTileEntity> BIG_PILLOW = register(BigPillowTileEntity::new, new ResourceLocation(YJSNPIMOD.MODID, "big_pillow"), YJBlocks.BIG_PILLOW);


    private static <T extends TileEntityType<?>> T register(Supplier<? extends TileEntity> factoryIn, ResourceLocation location, Block... blocks) {
        T tile = IKSGRegistryUtil.craeteTileEntityType(factoryIn, location, blocks);
        MOD_TILEENTITYTYPES.add(tile);
        return tile;
    }
}
