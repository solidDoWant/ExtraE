package com.solidDoWant.ExtraE.gameObjects.tiles;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyProvider;
import moze_intel.projecte.api.tile.IEmcAcceptor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class EngineEMCTile extends TileEntity implements IEnergyProvider, IEmcAcceptor{
	private EnergyStorage storageContainer = new EnergyStorage(50000, 1000);
	private double storedEMC = 0;
	private double maxEMC = 10000;
	private double emcToRFRatio = 500;	//Unit: EMC/RF
	private double maxRFProductionRate = 50;	//Unit: RF/tick
	private double maxEMCBurnRate = emcToRFRatio * maxRFProductionRate;	//Unit: EMC/tick
	
	@Override
	public void updateEntity(){
		if(!this.worldObj.isRemote){
			if(storageContainer.getEnergyStored() < storageContainer.getMaxEnergyStored()){
				double rfStorageLeft = storageContainer.getMaxEnergyStored() - storageContainer.getEnergyStored();
				if(rfStorageLeft > 0 && storedEMC != 0){
					if(maxRFProductionRate > (1 / emcToRFRatio) * storedEMC){
						if((int) ((1 / emcToRFRatio) * storedEMC) > 0){
							storageContainer.receiveEnergy((int) ((1 / emcToRFRatio) * storedEMC), false);	
							storedEMC = 0;
						}
					} else{
						storageContainer.receiveEnergy((int) maxRFProductionRate, false);
						storedEMC -= maxEMCBurnRate;
					}
				}
			}
		}
		//System.out.println("STORED: " + this.getEnergyStored(null));
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		storageContainer.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		storageContainer.writeToNBT(nbt);
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}
	
	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		int x = storageContainer.extractEnergy(maxExtract, simulate);
		System.out.println("CALLED: " + x);
		return x;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return storageContainer.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {

		return storageContainer.getMaxEnergyStored();
	}

	@Override
	public double getStoredEmc() {
		return storedEMC;
	}

	@Override
	public double getMaximumEmc() {
		return maxEMC;
	}

	@Override
	public double acceptEMC(ForgeDirection side, double toAccept) {
		double toAdd = Math.min(this.getMaximumEmc() - this.getStoredEmc(), toAccept);
		storedEMC += toAdd;
		return toAdd;
	}
}
