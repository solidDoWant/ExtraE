package com.solidDoWant.ExtraE.gameObjects.tiles;

import com.solidDoWant.ExtraE.utils.Constants;

import moze_intel.projecte.gameObjs.tiles.CollectorMK1Tile;

public class CollectorMK6Tile extends CollectorMK1Tile {
	public CollectorMK6Tile()
	{
		super(Constants.COLLECTOR_MK6_MAX, Constants.COLLECTOR_MK6_GEN, 17, 18);
	}

	@Override
	public String getInventoryName()
	{
		return "tile.ee_collector_MK6.name";
	}
}
