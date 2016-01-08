package com.solidDoWant.ExtraE.gameObjects.tiles;

import com.solidDoWant.ExtraE.utils.Constants;

import moze_intel.projecte.gameObjs.tiles.CollectorMK1Tile;

public class CollectorMK4Tile extends CollectorMK1Tile{
	public CollectorMK4Tile()
	{
		super(Constants.COLLECTOR_MK4_MAX, Constants.COLLECTOR_MK4_GEN, 17, 18);
	}

	@Override
	public String getInventoryName()
	{
		return "tile.ee_collector_MK4.name";
	}
}
