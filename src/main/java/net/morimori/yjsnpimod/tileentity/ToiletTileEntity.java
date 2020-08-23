package net.morimori.yjsnpimod.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.morimori.yjsnpimod.block.ToiletBlock;
import net.morimori.yjsnpimod.item.YJItems;
import red.felnull.otyacraftengine.tileentity.IClientSyncbleTileEntity;
import red.felnull.otyacraftengine.tileentity.IkisugiTileEntity;

public class ToiletTileEntity extends IkisugiTileEntity implements ITickableTileEntity {
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

    public void bukkake() {
        setBukkakeItem(bukkaededItem(getBukkakeItem()));
    }

    public ItemStack bukkaededItem(ItemStack stack) {

        if (stack.getItem() == YJItems.YJNIUM_INGOT) {
            return new ItemStack(YJItems.YJSNPI_INGOT, stack.getCount());
        } else if (stack.getItem() == YJItems.YJSNPI_INGOT) {
            return stack;
        }

        CompoundNBT tag = stack.getOrCreateTag();
        tag.putBoolean("Bukkaked", true);
        if (!(stack.getDisplayName() instanceof TranslationTextComponent) || !((TranslationTextComponent) stack.getDisplayName()).getKey().equals("item.yjsnpimod.bukkaeditem")) {
            stack.setDisplayName(new TranslationTextComponent("item.yjsnpimod.bukkaeditem", stack.getDisplayName()).func_240699_a_(TextFormatting.GOLD));
        }
        return stack;
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

    @Override
    public CompoundNBT instructionFromClient(ServerPlayerEntity serverPlayerEntity, String s, CompoundNBT compoundNBT) {
        return null;
    }

    @Override
    public boolean canInteractWith(ServerPlayerEntity serverPlayerEntity, String s, CompoundNBT compoundNBT) {
        return false;
    }
}
