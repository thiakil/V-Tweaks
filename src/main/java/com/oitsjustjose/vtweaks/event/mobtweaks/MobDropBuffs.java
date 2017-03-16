package com.oitsjustjose.vtweaks.event.mobtweaks;

import java.util.Random;

import com.oitsjustjose.vtweaks.VTweaks;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MobDropBuffs
{
	@SubscribeEvent
	public void registerTweak(LivingDropsEvent event)
	{
		Random random = new Random();

		if (event.getEntity() == null)
			return;

		if (event.getEntity() instanceof EntityChicken && VTweaks.config.enableMobDropBuffsChickens)
		{
			ItemStack dropStack = new ItemStack(Items.FEATHER, 1 + random.nextInt(4));
			EntityItem dropEntity = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, dropStack);
			event.getDrops().add(dropEntity);
		}

		else if (event.getEntity() instanceof EntityCow && VTweaks.config.enableMobDropBuffsCows)
		{
			ItemStack dropStack = new ItemStack(Items.LEATHER, 1 + random.nextInt(3));
			EntityItem dropEntity = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, dropStack);
			event.getDrops().add(dropEntity);
		}

		else if (event.getEntity() instanceof EntitySkeleton && VTweaks.config.enableMobDropBuffsSkeletons)
		{
			ItemStack dropStack = new ItemStack(Items.BONE, 1 + random.nextInt(2));
			EntityItem dropEntity = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, dropStack);
			event.getDrops().add(dropEntity);
		}

		else if (event.getEntity() instanceof EntitySquid && VTweaks.config.enableMobDropBuffsSquids)
		{
			ItemStack dropStack = new ItemStack(Items.DYE, 1 + random.nextInt(3));
			EntityItem dropEntity = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, dropStack);
			event.getDrops().add(dropEntity);
		}

		else if (event.getEntity() instanceof EntityEnderman && VTweaks.config.enableMobDropBuffsEndermen)
		{
			ItemStack dropStack = new ItemStack(Items.ENDER_PEARL, 1 + random.nextInt(1));
			EntityItem dropEntity = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, dropStack);
			event.getDrops().add(dropEntity);
		}

		else if (event.getEntity() instanceof EntityHorse && VTweaks.config.enableHorseGlue && random.nextInt(4 - event.getLootingLevel()) == 0)
		{
			System.out.println("Got this far");
			if (event.getSource().getEntity() instanceof EntityPlayer && EnchantmentHelper.getFireAspectModifier((EntityPlayer) event.getSource().getEntity()) > 0)
			{
				ItemStack dropStack = new ItemStack(Items.SLIME_BALL);
				dropStack.setStackDisplayName(TextFormatting.RESET + "Glue Ball");
				EntityItem dropEntity = new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, dropStack);
				event.getDrops().add(dropEntity);
			}
		}
	}
}