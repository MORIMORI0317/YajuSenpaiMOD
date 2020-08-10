package net.morimori.yjsnpimod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.morimori.yjsnpimod.block.ToiletBlock;
import net.morimori.yjsnpimod.block.YJBlocks;

public class ToiletSitEntity extends Entity {
    public ToiletSitEntity(EntityType<? extends ToiletSitEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public ToiletSitEntity(World worldIn) {
        super(YJEntityTypes.TOILET_SIT, worldIn);
    }

    @Override
    public void tick() {
        super.tick();
        if (world.getBlockState(this.func_233580_cy_()).getBlock() != YJBlocks.TOILET || !world.getBlockState(this.func_233580_cy_()).get(ToiletBlock.OPEN)) {
            this.remove();
        }
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
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
