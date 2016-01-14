package com.solidDoWant.ExtraE.gameObjects.blocks;

import com.solidDoWant.ExtraE.gameObjects.ObjectHandler;
import com.solidDoWant.ExtraE.gameObjects.tiles.EngineEMCTile;
import com.solidDoWant.ExtraE.utils.Constants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EMCEngine extends Block{

	public EMCEngine() {
		super(Material.rock);
		this.setBlockName("ee_emc_engine");
		this.setLightLevel(Constants.COLLECTOR_LIGHT_VALS);
		this.setHardness(10.0f);
		this.setCreativeTab(ObjectHandler.tab);
	}
	
	@Override
	public boolean hasTileEntity(int meta)
	{
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int meta)
	{
		return new EngineEMCTile();
	}

}
