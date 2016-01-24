package com.solidDoWant.ExtraE.utils;

import cpw.mods.fml.common.network.IGuiHandler;

import com.solidDoWant.ExtraE.gameObjects.container.BasicInventoryContainer;
import com.solidDoWant.ExtraE.gameObjects.container.CollectorMK4Container;
import com.solidDoWant.ExtraE.gameObjects.container.RelayMK4Container;
import com.solidDoWant.ExtraE.gameObjects.gui.GUICollectorMK4;
import com.solidDoWant.ExtraE.gameObjects.gui.GUIEMCEngine;
import com.solidDoWant.ExtraE.gameObjects.gui.GUIRFCollector;
import com.solidDoWant.ExtraE.gameObjects.gui.GUIRelayMK4;
import com.solidDoWant.ExtraE.gameObjects.tiles.CollectorMK4Tile;
import com.solidDoWant.ExtraE.gameObjects.tiles.CollectorMK5Tile;
import com.solidDoWant.ExtraE.gameObjects.tiles.CollectorMK6Tile;
import com.solidDoWant.ExtraE.gameObjects.tiles.EMCEngineTile;
import com.solidDoWant.ExtraE.gameObjects.tiles.RFCollectorTile;
import com.solidDoWant.ExtraE.gameObjects.tiles.RelayMK4Tile;
import com.solidDoWant.ExtraE.gameObjects.tiles.RelayMK5Tile;
import com.solidDoWant.ExtraE.gameObjects.tiles.RelayMK6Tile;
import com.solidDoWant.ExtraE.utils.Constants;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		
		switch (ID)
		{
			case Constants.COLLECTOR4_GUI:
				if (tile != null && tile instanceof CollectorMK4Tile)
					return new CollectorMK4Container(player.inventory, (CollectorMK4Tile) tile);
				break;
			case Constants.COLLECTOR5_GUI:
				if (tile != null && tile instanceof CollectorMK5Tile)
					return new CollectorMK4Container(player.inventory, (CollectorMK5Tile) tile);
				break;
			case Constants.COLLECTOR6_GUI:
				if (tile != null && tile instanceof CollectorMK6Tile)
					return new CollectorMK4Container(player.inventory, (CollectorMK6Tile) tile);
				break;
			case Constants.RELAY4_GUI:
				if (tile != null && tile instanceof RelayMK4Tile)
					return new RelayMK4Container(player.inventory, (RelayMK4Tile) tile);
				break;
			case Constants.RELAY5_GUI:
				if (tile != null && tile instanceof RelayMK5Tile)
					return new RelayMK4Container(player.inventory, (RelayMK5Tile) tile);
				break;
			case Constants.RELAY6_GUI:
				if (tile != null && tile instanceof RelayMK6Tile)
					return new RelayMK4Container(player.inventory, (RelayMK6Tile) tile);
				break;
			case Constants.EMCENGINE_GUI:
				if (tile != null && tile instanceof EMCEngineTile)
					return new BasicInventoryContainer(player.inventory);
				break;
			case Constants.RFCOLLECTOR_GUI:
				if (tile != null && tile instanceof RFCollectorTile)
					return new BasicInventoryContainer(player.inventory);
				break;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile = world.getTileEntity(x, y, z);
		
		switch (ID)
		{
			case Constants.COLLECTOR4_GUI:
				if (tile != null && tile instanceof CollectorMK4Tile)
					return new GUICollectorMK4(new CollectorMK4Container(player.inventory, (CollectorMK4Tile) tile), (CollectorMK4Tile) tile);
				break;
			case Constants.COLLECTOR5_GUI:
				if (tile != null && tile instanceof CollectorMK5Tile)
					return new GUICollectorMK4(new CollectorMK4Container(player.inventory, (CollectorMK5Tile) tile), (CollectorMK5Tile) tile);
				break;
			case Constants.COLLECTOR6_GUI:
				if (tile != null && tile instanceof CollectorMK6Tile)
					return new GUICollectorMK4(new CollectorMK4Container(player.inventory, (CollectorMK6Tile) tile), (CollectorMK6Tile) tile);
				break;
			case Constants.RELAY4_GUI:
				if (tile != null && tile instanceof RelayMK4Tile)
					return new GUIRelayMK4(new RelayMK4Container(player.inventory, (RelayMK4Tile) tile), (RelayMK4Tile) tile);
				break;
			case Constants.RELAY5_GUI:
				if (tile != null && tile instanceof RelayMK5Tile)
					return new GUIRelayMK4(new RelayMK4Container(player.inventory, (RelayMK5Tile) tile), (RelayMK5Tile) tile);
				break;
			case Constants.RELAY6_GUI:
				if (tile != null && tile instanceof RelayMK6Tile)
					return new GUIRelayMK4(new RelayMK4Container(player.inventory, (RelayMK6Tile) tile), (RelayMK6Tile) tile);
				break;
			case Constants.EMCENGINE_GUI:
				if (tile != null && tile instanceof EMCEngineTile)
					return new GUIEMCEngine(new BasicInventoryContainer(player.inventory), (EMCEngineTile) tile);
				break;
			case Constants.RFCOLLECTOR_GUI:
				if (tile != null && tile instanceof RFCollectorTile)
					return new GUIRFCollector(new BasicInventoryContainer(player.inventory), (RFCollectorTile) tile);
				break;
		}
		
		return null;
	}
}
