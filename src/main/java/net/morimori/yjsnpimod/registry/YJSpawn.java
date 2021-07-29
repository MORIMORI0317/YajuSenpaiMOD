package net.morimori.yjsnpimod.registry;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.morimori.yjsnpimod.block.YJBlocks;
import net.morimori.yjsnpimod.item.YJItems;
import net.morimori.yjsnpimod.util.YJUtils;

import java.util.Random;

public class YJSpawn {
    public static void onSpawn(Mob mob) {

        boolean r = YJUtils.yjRandom(mob.getRandom());
        boolean y = YJUtils.isYJDim(mob.level);
        boolean yor = y || r;
        boolean yar = y && r;

        if (yor) {
            if (mob instanceof EnderMan enderMan)
                enderMan.setCarriedBlock(createInmItem(mob.getRandom()).defaultBlockState());
        }
        if (r) {
            if (mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin)
                mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(YJItems.CYCLOPS_SUNGLASSES));
        }

        if (y) {
            if (mob instanceof Vex || mob instanceof AbstractIllager || mob instanceof AbstractVillager || (!r && (mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin))) {
                mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(createInmItem(mob.getRandom())));
                mob.setDropChance(EquipmentSlot.HEAD, 1f);
            }
            if (mob instanceof Vindicator) {
                mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(YJItems.YJSNPI_AXE));
            }
        }

        if (YJUtils.veryYjRandom(mob.getRandom()) && (mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin)) {
            if (y)
                setFullArmor(mob, true, new ItemStack(YJItems.YJSNPI_HELMET), new ItemStack(YJItems.YJSNPI_CHESTPLATE), new ItemStack(YJItems.YJSNPI_LEGGINGS), new ItemStack(YJItems.YJSNPI_BOOTS), new ItemStack(YJItems.YJSNPI_SWORD), ItemStack.EMPTY);
            else
                setFullArmor(mob, true, new ItemStack(YJItems.YJNIUM_HELMET), new ItemStack(YJItems.YJNIUM_CHESTPLATE), new ItemStack(YJItems.YJNIUM_LEGGINGS), new ItemStack(YJItems.YJNIUM_BOOTS), new ItemStack(YJItems.YJNIUM_SWORD), ItemStack.EMPTY);
        }
    }

    private static Block createInmItem(Random random) {
        return YJBlocks.INM_BLOCKS.get(random.nextInt(YJBlocks.INM_BLOCKS.size()));
    }

    private static void setFullArmor(Mob mob, boolean override, ItemStack head, ItemStack chest, ItemStack leg, ItemStack feet, ItemStack main, ItemStack off) {
        if ((override || mob.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) && !head.isEmpty())
            mob.setItemSlot(EquipmentSlot.HEAD, head);
        if ((override || mob.getItemBySlot(EquipmentSlot.CHEST).isEmpty()) && !chest.isEmpty())
            mob.setItemSlot(EquipmentSlot.CHEST, chest);
        if ((override || mob.getItemBySlot(EquipmentSlot.LEGS).isEmpty()) && !leg.isEmpty())
            mob.setItemSlot(EquipmentSlot.LEGS, leg);
        if ((override || mob.getItemBySlot(EquipmentSlot.FEET).isEmpty()) && !feet.isEmpty())
            mob.setItemSlot(EquipmentSlot.FEET, feet);

        if ((override || mob.getItemBySlot(EquipmentSlot.MAINHAND).isEmpty()) && !main.isEmpty())
            mob.setItemSlot(EquipmentSlot.MAINHAND, main);
        if ((override || mob.getItemBySlot(EquipmentSlot.OFFHAND).isEmpty()) && !off.isEmpty())
            mob.setItemSlot(EquipmentSlot.OFFHAND, off);
    }

}
