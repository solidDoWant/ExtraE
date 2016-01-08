package com.solidDoWant.ExtraE.gameObjects.items.itemBlocks;

import com.solidDoWant.ExtraE.utils.AchievementHandler;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCollectorBlock extends moze_intel.projecte.gameObjs.items.itemBlocks.ItemCollectorBlock{
	public ItemCollectorBlock(Block block)
	{
		super(block);
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) 
	{
		if (world != null)
		{
			player.addStat(AchievementHandler.SUPER_COLLECTOR, 1);
		}
	}
}
