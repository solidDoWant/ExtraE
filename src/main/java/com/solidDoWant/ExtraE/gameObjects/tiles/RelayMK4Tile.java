package com.solidDoWant.ExtraE.gameObjects.tiles;

import com.solidDoWant.ExtraE.utils.Constants;

import moze_intel.projecte.gameObjs.tiles.RelayMK1Tile;

public class RelayMK4Tile extends RelayMK1Tile{
	public RelayMK4Tile()
	{
		super(20, Constants.RELAY_MK4_MAX, Constants.RELAY_MK4_OUTPUT);
	}

	@Override
	public String getInventoryName()
	{
		return "ee.relay.mk4";
	}
}
