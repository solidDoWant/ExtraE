package com.solidDoWant.ExtraE.gameObjects;

import com.solidDoWant.ExtraE.ExtraECore;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs{
	public CreativeTab()
	{
		super(ExtraECore.MODID);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() 
	{
		return Item.getItemFromBlock(ObjectHandler.collectorMK6Block);
	}
}
