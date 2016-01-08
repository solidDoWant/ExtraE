package com.solidDoWant.ExtraE.gameObjects.tiles;

import com.solidDoWant.ExtraE.utils.Constants;

import moze_intel.projecte.gameObjs.tiles.CollectorMK1Tile;

public class CollectorMK5Tile extends CollectorMK1Tile {
	public CollectorMK5Tile()
	{
		super(Constants.COLLECTOR_MK5_MAX, Constants.COLLECTOR_MK5_GEN, 17, 18);
	}

	@Override
	public String getInventoryName()
	{
		return "tile.ee_collector_MK5.name";
	}
}
