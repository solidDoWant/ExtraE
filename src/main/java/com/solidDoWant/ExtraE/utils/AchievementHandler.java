package com.solidDoWant.ExtraE.utils;

import com.google.common.collect.ImmutableList;
import com.solidDoWant.ExtraE.gameObjects.ObjectHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class AchievementHandler {
	public final static Achievement SUPER_COLLECTOR = new Achievement("super_collector", "super_collector", -1, 0, ObjectHandler.collectorMK4Block, moze_intel.projecte.utils.AchievementHandler.COLLECTOR).setSpecial().registerStat();
	public final static Achievement SUPER_RELAY = new Achievement("super_relay", "super_relay", 1, 0, ObjectHandler.relayMK4Block, moze_intel.projecte.utils.AchievementHandler.RELAY).setSpecial().registerStat();

	public static ImmutableList<Achievement> list = ImmutableList.of(
			SUPER_COLLECTOR, SUPER_RELAY
	);
	
	public static void init()
	{
		AchievementPage.registerAchievementPage(new AchievementPage("ExtraE", list.toArray(new Achievement[list.size()])));
	}
	
	public static Achievement getAchievementForItem(ItemStack stack)
	{
		if (stack == null)
		{
			return null;
		}
		
		for (Achievement ach : list)
		{
			ItemStack s = ach.theItemStack;
			
			if (s.getItem() == stack.getItem() && s.getItemDamage() == stack.getItemDamage())
			{
				return ach;
			}
		}
		
		return null;
	}
}
