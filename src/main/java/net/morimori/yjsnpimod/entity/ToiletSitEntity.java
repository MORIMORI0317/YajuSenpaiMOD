package net.morimori.yjsnpimod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;

public class ToiletSitEntity extends Entity {
    public ToiletSitEntity(EntityType<? extends ToiletSitEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public ToiletSitEntity(World worldIn) {
        super(YJEntityTypes.TOILET_SIT, worldIn);
    }

    @Override
    protected void registerData() {

    }

    @Override
    protected void readAdditional(CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {

    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return null;
    }
}
