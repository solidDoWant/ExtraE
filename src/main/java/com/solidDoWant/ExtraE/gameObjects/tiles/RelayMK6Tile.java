package com.solidDoWant.ExtraE.gameObjects.tiles;

import com.solidDoWant.ExtraE.utils.Constants;

import moze_intel.projecte.gameObjs.tiles.RelayMK1Tile;

public class RelayMK6Tile extends RelayMK1Tile{
	public RelayMK6Tile()
	{
		super(20, Constants.RELAY_MK6_MAX, Constants.RELAY_MK6_OUTPUT);
	}

	@Override
	public String getInventoryName()
	{
		return "ee.relay.mk6";
	}
}
