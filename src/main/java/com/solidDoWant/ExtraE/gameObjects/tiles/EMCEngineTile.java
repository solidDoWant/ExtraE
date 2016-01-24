package com.solidDoWant.ExtraE.gameObjects.tiles;

import java.util.Map;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.solidDoWant.ExtraE.network.PacketHandler;
import com.solidDoWant.ExtraE.network.packets.EMCRFSyncPacket;

import cofh.api.energy.IEnergyProvider;
import cofh.api.energy.IEnergyReceiver;
import moze_intel.projecte.api.tile.IEmcAcceptor;
import moze_intel.projecte.utils.WorldHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class EMCEngineTile extends EMCRFTile implements IEnergyProvider, IEmcAcceptor{
	public static double maxEMC = 10000;
	public static int maxRF = 50000;
	public static double emcToRFRatio = 5;	//Unit: EMC/RF
	public static double maxRFProductionRate = 5000;	//Unit: RF/tick
	public static int maxRFOutputRate = 1000;
		
	public EMCEngineTile(){
		super(maxRF, maxRFOutputRate, maxEMC);
	}
	
	@Override
	public void updateEntity(){
		if(!this.worldObj.isRemote){
			PacketHandler.sendPacket(new EMCRFSyncPacket(this));

			if(this.getEnergyStored() < this.getMaxEnergyStored()){
				if(this.getMaxEnergyStored() - this.getEnergyStored() > 0 && this.getStoredEmc() != 0){
					if(maxRFProductionRate > (1 / emcToRFRatio) * this.getStoredEmc()){
						if((int) ((1 / emcToRFRatio) * this.getStoredEmc()) > 0){
							this.getEnergyStorage().receiveEnergy((int) ((1 / emcToRFRatio) * this.getStoredEmc()), false);	
							this.setStoredEMC(0);
						}
					} else{
						this.getEnergyStorage().receiveEnergy((int) maxRFProductionRate, false);
						this.setStoredEMC(this.getStoredEmc() - emcToRFRatio * maxRFProductionRate);
					}
				}
			}
			
			this.sendRF();
		}
	}
	
	private void sendRF()
	{
		if (this.getEnergyStored(null) == 0){
			return;
		}
		this.sendToAllAcceptors();
	}
	
	public void sendToAllAcceptors()
	{
		Map<ForgeDirection, TileEntity> tiles = Maps.filterValues(WorldHelper.getAdjacentTileEntitiesMapped(worldObj, this), Predicates.instanceOf(IEnergyReceiver.class));

		double powerToGive = Math.min(this.getEnergyStorage().getMaxExtract(), this.getEnergyStored());
		for (Map.Entry<ForgeDirection, TileEntity> entry : tiles.entrySet())
		{
			if(powerToGive > 0){
				double powerUsed = ((IEnergyReceiver) entry.getValue()).receiveEnergy(entry.getKey().getOpposite(),(int) powerToGive, false);
				this.getEnergyStorage().extractEnergy((int) powerUsed, false);
				powerToGive -= powerUsed;
			} else{
				return;
			}
		}
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.getEnergyStorage().readFromNBT(nbt);
		this.setStoredEMC(nbt.getDouble("StoredEMC"));
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		this.getEnergyStorage().writeToNBT(nbt);
		nbt.setDouble("StoredEMC", this.getStoredEmc());
	}
	
	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		return this.getEnergyStorage().extractEnergy(maxExtract, simulate);
	}

	@Override
	public double acceptEMC(ForgeDirection side, double toAccept) {
		double toAdd = Math.min(this.getMaximumEmc() - this.getStoredEmc(), toAccept);
		this.setStoredEMC(this.getStoredEmc() + toAdd);
		return toAdd;
	}
}
