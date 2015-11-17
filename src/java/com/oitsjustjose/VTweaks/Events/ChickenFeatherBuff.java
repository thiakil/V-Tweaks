package com.oitsjustjose.VTweaks.Events;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ChickenFeatherBuff
{
	@SubscribeEvent
	public void registerEvent(LivingDropsEvent event)
	{
		if (event.entity != null && event.entity instanceof EntityChicken)
		{
			Random random = new Random();
			ItemStack featherStack = new ItemStack(Items.feather, 1 + random.nextInt(4));
			EntityItem feather = new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY,
					event.entity.posZ, featherStack);
			event.drops.add(feather);
		}
	}
}