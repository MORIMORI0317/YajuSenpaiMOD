package com.morimori.yjsnpimod.other;

import java.util.function.Supplier;

import com.morimori.yjsnpimod.blocks.MODBlocks;
import com.morimori.yjsnpimod.items.MODItems;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;

public enum MODItemTier implements IItemTier {
   YJ(1, 114514, 1.0F, 2.19F, 26, () -> {
	      return Ingredient.fromItems(MODBlocks.YJ_SNPAI_BLOCK);
   }),
	   DIAMOND_SENPAI(4, 1919, 8.0F, 3.0F, 10, () -> {
		      return Ingredient.fromItems(MODItems.DIAMOND_SENPAI);
	   }),
	   INFINITY_SENPAI(1919, 1151419119, 810.0F, 1919.0F, 931, () -> {
		      return Ingredient.fromItems(MODItems.INFINITY_SENPAI_INGOT);
	   });
   private final int harvestLevel;
   private final int maxUses;
   private final float efficiency;
   private final float attackDamage;
   private final int enchantability;
   private final LazyLoadBase<Ingredient> repairMaterial;

   private MODItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
      this.harvestLevel = harvestLevelIn;
      this.maxUses = maxUsesIn;
      this.efficiency = efficiencyIn;
      this.attackDamage = attackDamageIn;
      this.enchantability = enchantabilityIn;
      this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
   }

   public int getMaxUses() {
      return this.maxUses;
   }

   public float getEfficiency() {
      return this.efficiency;
   }

   public float getAttackDamage() {
      return this.attackDamage;
   }

   public int getHarvestLevel() {
      return this.harvestLevel;
   }

   public int getEnchantability() {
      return this.enchantability;
   }

   public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
   }
}