package com.oitsjustjose.VTweaks.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentUnbreakable extends Enchantment
{
	public EnchantmentUnbreakable(int par1)
	{
		super(par1, 1, EnumEnchantmentType.breakable);
	}

	// Makes this enchantment compatible with any other enchants
	@Override
	public boolean canApplyTogether(Enchantment enchantment)
	{
		return true;
	}

	// Makes it so you cannot get this enchantment by standard enchanting
	@Override
	public int getMinEnchantability(int par1)
	{
		return 0;
	}

	// Makes it so you cannot get this enchantment by standard enchanting
	@Override
	public int getMaxEnchantability(int par1)
	{
		return 0;
	}
}