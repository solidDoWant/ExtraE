package com.solidDoWant.ExtraE.gameObjects.tiles;

import com.solidDoWant.ExtraE.utils.Constants;

import moze_intel.projecte.gameObjs.tiles.RelayMK1Tile;

public class RelayMK5Tile extends RelayMK1Tile{
	public RelayMK5Tile()
	{
		super(20, Constants.RELAY_MK5_MAX, Constants.RELAY_MK5_OUTPUT);
	}

	@Override
	public String getInventoryName()
	{
		return "ee.relay.mk5";
	}
}