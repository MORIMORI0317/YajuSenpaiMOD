package net.morimori.yjsnpimod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.morimori.yjsnpimod.block.ToiletBlock;
import red.felnull.otyacraftengine.tileentity.IClientSyncbleTileEntity;
import red.felnull.otyacraftengine.tileentity.IkisugiTileEntity;

public class ToiletTileEntity extends IkisugiTileEntity implements ITickableTileEntity, IClientSyncbleTileEntity {
    public float doorAngle;
    protected ItemStack bukkakeItem = ItemStack.EMPTY;

    public ToiletTileEntity() {
        super(YJTileEntityTypes.TOILET);
    }

    @Override
    public CompoundNBT write(CompoundNBT tag) {
        super.write(tag);
        tag.putFloat("DoorAngle", this.doorAngle);
        tag.put("BukkakeItem", this.getBukkakeItem().write(new CompoundNBT()));
        return tag;
    }


    @Override
    public void readByIKSG(BlockState state, CompoundNBT tag) {
        super.readByIKSG(state, tag);
        this.doorAngle = tag.getFloat("DoorAngle");
        this.bukkakeItem = ItemStack.read(tag.getCompound("BukkakeItem"));
    }

    public ItemStack getBukkakeItem() {
        return this.bukkakeItem;
    }

    public void setBukkakeItem(ItemStack item) {
        this.bukkakeItem = item;
        this.markDirty();
    }

    @Override
    public void tick() {

        BlockState state = getBlockState();
        if (!world.isRemote) {
            if (state.get(ToiletBlock.OPEN)) {
                if (this.doorAngle < 90) {
                    this.doorAngle += 5;
                }
            } else {
                if (this.doorAngle > 0) {
                    this.doorAngle -= 5;
                }
            }
        }

        this.syncble(this);
    }
}
