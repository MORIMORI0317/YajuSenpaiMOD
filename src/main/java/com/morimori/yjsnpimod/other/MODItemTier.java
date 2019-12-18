package com.morimori.yjsnpimod.other;

import com.morimori.yjsnpimod.blocks.MODBlocks;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;

public class MODItemTier implements IItemTier {
	public static MODItemTier YJ = new MODItemTier(1, 114514, 1, 2, 26,
			new IItemProvider[] { MODBlocks.YJ_SNPAI_BLOCK });
	public static MODItemTier DIAMOND_SENPAI = new MODItemTier(4, 1919, 8, 3, 10,
			new IItemProvider[] { MODBlocks.YJ_SNPAI_BLOCK });

	public static MODItemTier INFINITY_SENPAI = new MODItemTier(1919, 1151419119, 810, 1919, 931,
			new IItemProvider[] { MODBlocks.YJ_SNPAI_BLOCK });

	private float AttackDamage;
	private float Efficiency;
	private int Enchantability;
	private int HarvestLevel;
	private int MaxUses;
	private IItemProvider[] RepairMaterial;

	public MODItemTier(float attackdamageIn, float efficiencyIn, int enchantabilityIn, int harvestlevelIn,
			int maxusesIn, IItemProvider[] repairmaterialIn) {
		this.AttackDamage = attackdamageIn;
		this.Efficiency = efficiencyIn;
		this.Enchantability = enchantabilityIn;
		this.HarvestLevel = harvestlevelIn;
		this.MaxUses = maxusesIn;
		this.RepairMaterial = repairmaterialIn;

	}

	@Override
	public float getAttackDamage() {

		return AttackDamage;
	}

	@Override
	public float getEfficiency() {

		return Efficiency;
	}

	@Override
	public int getEnchantability() {

		return Enchantability;
	}

	@Override
	public int getHarvestLevel() {

		return HarvestLevel;
	}

	@Override
	public int getMaxUses() {

		return MaxUses;
	}

	@Override
	public Ingredient getRepairMaterial() {

		return Ingredient.fromItems(RepairMaterial);
	}

}
