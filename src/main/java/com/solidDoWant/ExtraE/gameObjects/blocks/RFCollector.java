package com.solidDoWant.ExtraE.gameObjects.blocks;

import com.solidDoWant.ExtraE.ExtraECore;
import com.solidDoWant.ExtraE.gameObjects.ObjectHandler;
import com.solidDoWant.ExtraE.gameObjects.tiles.RFCollectorTile;
import com.solidDoWant.ExtraE.utils.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class RFCollector extends Block{
	public RFCollector() {
		super(Material.rock);
		this.setBlockName("ee_rf_collector");
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
		return new RFCollectorTile();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote){
			player.openGui(ExtraECore.instance, Constants.RFCOLLECTOR_GUI, world, x, y, z);
		}
		return true;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		this.blockIcon = register.registerIcon("extrae:rfcollector/default");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return this.blockIcon;
	}
}
