package net.morimori0317.yajusenpai.entity;


import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Panda;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.morimori0317.yajusenpai.block.YJBlocks;
import net.morimori0317.yajusenpai.item.YJItems;
import net.morimori0317.yajusenpai.server.level.dimension.YJBiomeTags;
import net.morimori0317.yajusenpai.util.YJUtils;

import java.util.List;
import java.util.function.BooleanSupplier;

public class YJSpawn {
    public static void onSpawn(Mob mob) {
        Level level = mob.level();
        RandomSource rs = mob.getRandom();
        boolean y = YJUtils.isYJDim(level) || level.getBiome(mob.blockPosition()).is(YJBiomeTags.IS_YAJUSENPAI);

        BooleanSupplier r = () -> {
            if (y) {
                return YJUtils.legacyYjRandom(rs) && YJUtils.legacyYjRandom(rs);
            } else {
                return YJUtils.yjRandom(rs) && YJUtils.yjRandom(rs);
            }
        };
        BooleanSupplier yor = () -> (y || r.getAsBoolean());

        if (mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin) {
            boolean vf;
            if (y) {
                vf = YJUtils.yjRandom(rs) && YJUtils.yjRandom(rs) && YJUtils.yjRandom(rs);
            } else {
                vf = YJUtils.veryYjRandom(rs) && YJUtils.veryYjRandom(rs) && YJUtils.veryYjRandom(rs);
            }

            if (vf) {
                mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(YJItems.CYCLOPS_SUNGLASSES.get()));
                mob.setItemSlot(EquipmentSlot.LEGS, new ItemStack(YJItems.BRIEF.get()));
                mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(YJItems.JAKEN_YORUIKIMASYOUNE_SWORD.get()));
            }
        }

        if (yor.getAsBoolean()) {
            if (mob instanceof EnderMan enderMan) enderMan.setCarriedBlock(createInmItem(rs, y).defaultBlockState());
        }

        if (mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin) {
            if (!y && r.getAsBoolean()) {
                mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(YJItems.CYCLOPS_SUNGLASSES.get()));
            }

            if (r.getAsBoolean()) {
                mob.setItemSlot(EquipmentSlot.LEGS, new ItemStack(YJItems.BRIEF.get()));
            }

            if (rs.nextInt(110) == 0) {
                mob.setItemSlot(EquipmentSlot.LEGS, new ItemStack(YJItems.O_BACK.get()));
            }
        }

        if (y || rs.nextFloat() < 0.01919) {
            if (mob instanceof Vex || mob instanceof AbstractIllager || mob instanceof AbstractVillager || mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin) {
                mob.setItemSlot(EquipmentSlot.HEAD, new ItemStack(createInmItem(rs, y)));
                mob.setDropChance(EquipmentSlot.HEAD, 1f);
            }
            if (mob instanceof Vindicator) {
                mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(YJItems.YAJUSENPAI_AXE.get()));
            }
        }

        if (YJUtils.veryYjRandom(rs) && YJUtils.veryYjRandom(rs) && (mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin)) {
            if (y)
                setFullArmor(mob, true, new ItemStack(YJItems.YAJUSENPAI_HELMET.get()), new ItemStack(YJItems.YAJUSENPAI_CHESTPLATE.get()), new ItemStack(YJItems.YAJUSENPAI_LEGGINGS.get()), new ItemStack(YJItems.YAJUSENPAI_BOOTS.get()), new ItemStack(YJItems.YAJUSENPAI_SWORD.get()), ItemStack.EMPTY);
            else
                setFullArmor(mob, true, new ItemStack(YJItems.YJNIUM_HELMET.get()), new ItemStack(YJItems.YJNIUM_CHESTPLATE.get()), new ItemStack(YJItems.YJNIUM_LEGGINGS.get()), new ItemStack(YJItems.YJNIUM_BOOTS.get()), new ItemStack(YJItems.YJNIUM_SWORD.get()), ItemStack.EMPTY);
        }

        if (mob instanceof Zombie || mob instanceof AbstractSkeleton || mob instanceof Piglin || mob instanceof Fox || mob instanceof Villager || mob instanceof Panda || mob instanceof AbstractIllager || mob instanceof Vex || mob instanceof Witch) {
            if (r.getAsBoolean()) {
                mob.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(YJItems.ICE_TEA.get()));
                if (rs.nextFloat() <= 0.364f)
                    mob.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(YJItems.SOFT_SMARTPHONE.get()));
            }
        }
    }

    private static Block createInmItem(RandomSource random, boolean yjFlag) {
        List<RegistrySupplier<Block>> list;

        if (yjFlag) {
            if (random.nextFloat() < 0.810) {
                list = YJBlocks.YJ_BLOCKS;
            } else {
                list = YJBlocks.NON_YJ_BLOCKS;
            }
        } else {
            list = YJBlocks.INM_BLOCKS;
        }

        return list.get(random.nextInt(list.size())).get();
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