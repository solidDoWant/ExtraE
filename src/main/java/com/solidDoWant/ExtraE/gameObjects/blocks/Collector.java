package com.solidDoWant.ExtraE.gameObjects.blocks;

import com.solidDoWant.ExtraE.ExtraECore;
import com.solidDoWant.ExtraE.gameObjects.ObjectHandler;
import com.solidDoWant.ExtraE.gameObjects.tiles.CollectorMK4Tile;
import com.solidDoWant.ExtraE.gameObjects.tiles.CollectorMK5Tile;
import com.solidDoWant.ExtraE.gameObjects.tiles.CollectorMK6Tile;
import com.solidDoWant.ExtraE.utils.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moze_intel.projecte.gameObjs.blocks.BlockDirection;
import moze_intel.projecte.gameObjs.tiles.TileEmc;
import moze_intel.projecte.utils.ComparatorHelper;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Collector extends BlockDirection{
	@SideOnly(Side.CLIENT)
	private IIcon front;
	@SideOnly(Side.CLIENT)
	private IIcon top;
	private int tier;
	
	public Collector(int tier) 
	{
		super(Material.glass);
		this.setBlockName("ee_collector_MK" + tier);
		this.setLightLevel(Constants.COLLECTOR_LIGHT_VALS);
		this.setHardness(0.3f);
		this.setCreativeTab(ObjectHandler.tab);
		this.tier = tier;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
			switch (tier)
			{
				case 4:
					player.openGui(ExtraECore.instance, Constants.COLLECTOR4_GUI, world, x, y, z);
					break;
				case 5:
					player.openGui(ExtraECore.instance, Constants.COLLECTOR5_GUI, world, x, y, z);
					break;
				case 6:
					player.openGui(ExtraECore.instance, Constants.COLLECTOR6_GUI, world, x, y, z);
					break;
			}
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entLiving, ItemStack stack)
	{
		setFacingMeta(world, x, y, z, ((EntityPlayer) entLiving));
		
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if (stack.hasTagCompound() && stack.stackTagCompound.getBoolean("ProjectEBlock") && tile instanceof TileEmc)
		{
			stack.stackTagCompound.setInteger("x", x);
			stack.stackTagCompound.setInteger("y", y);
			stack.stackTagCompound.setInteger("z", z);
			
			tile.readFromNBT(stack.stackTagCompound);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		this.blockIcon = register.registerIcon("projecte:collectors/other");
		this.front = register.registerIcon("projecte:collectors/front");
		this.top = register.registerIcon("extrae:collectors/top_" + Integer.toString(tier));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (meta == 0 && side == 3) 
		{
			return front;
		}
		
		if (side == 1) 
		{
			return top;
		}
		
		return side != meta ? this.blockIcon : front;
	}

	@Override
	public boolean hasTileEntity(int meta)
	{
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		switch (tier) {
			case 4:
				return new CollectorMK4Tile();
			case 5:
				return new CollectorMK5Tile();
			case 6:
				return new CollectorMK6Tile();
			default:
				return null;
		}
	}

	@Override
	public boolean hasComparatorInputOverride()
	{
		return true;
	}

	@Override
	public int getComparatorInputOverride(World world, int x, int y, int z, int meta)
	{
		return ComparatorHelper.getForCollector(world, x, y, z);
	}

	@Override
	public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side) {
		return true;
	}
}
