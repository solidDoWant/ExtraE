package com.solidDoWant.ExtraE.gameObjects.tiles;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyConnection;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class EMCRFTile extends TileEntity implements IEnergyConnection{
	private EnergyStorage energyContainer;
	private double storedEMC;
	private double maximumEMC;
	
	public EMCRFTile(int maxRF, int maxRFInput, int maxRFOutput, double maximumEMC){
		energyContainer = new EnergyStorage(maxRF, maxRFInput, maxRFOutput);
		this.maximumEMC = maximumEMC;
	}
	
	public EMCRFTile(int maxRF, int maxRFTransferRate, double maximumEMC){
		this(maxRF, maxRFTransferRate, maxRFTransferRate, maximumEMC);
	}
	
	public double getStoredEmc(){
		return storedEMC;
	}
	
	public double getMaximumEmc(){
		return maximumEMC;
	}
	
	public int getEnergyStored(ForgeDirection from) {
		return energyContainer.getEnergyStored();
	}
	
	public int getEnergyStored() {
		return this.getEnergyStored(null);
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	
	public void setStoredEMC(double storedEMC){
		this.storedEMC = storedEMC;
	}
	public void setEnergyStored(int energy){
		this.energyContainer.setEnergyStored(energy);
	}

	public int getMaxEnergyStored(ForgeDirection from) {
		return energyContainer.getMaxEnergyStored();
	}
	
	public int getMaxEnergyStored() {
		return this.getMaxEnergyStored(null);
	}
	
	public EnergyStorage getEnergyStorage(){
		return this.energyContainer;
	}
}
