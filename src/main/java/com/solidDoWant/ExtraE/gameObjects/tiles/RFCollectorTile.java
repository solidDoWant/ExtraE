package com.solidDoWant.ExtraE.gameObjects.tiles;

import java.util.Map;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.solidDoWant.ExtraE.network.PacketHandler;
import com.solidDoWant.ExtraE.network.packets.EMCRFSyncPacket;

import cofh.api.energy.IEnergyReceiver;
import moze_intel.projecte.api.tile.IEmcAcceptor;
import moze_intel.projecte.api.tile.IEmcProvider;
import moze_intel.projecte.utils.WorldHelper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class RFCollectorTile extends EMCRFTile implements IEnergyReceiver, IEmcProvider{
	public static double maxEMC = 1000000;
	public static int maxRF = 1000000;
	public static float RFToEMCRatio = 1/5000;
	public static double maxEMCProductionRate = 10000;
	public static double maxEMCOutputRate = 5000;
	
	public RFCollectorTile(){
		super(maxRF, Integer.MAX_VALUE - 1, maxEMC);
	}
	
	@Override
	public void updateEntity(){
		if(!worldObj.isRemote){
			PacketHandler.sendPacket(new EMCRFSyncPacket(this));
			
			if(this.getStoredEmc() < this.getMaximumEmc()){
				if(this.getMaximumEmc() - this.getStoredEmc() > 0 && this.getEnergyStored() != 0){
					if(maxEMCProductionRate > (1 / RFToEMCRatio) * this.getEnergyStored()){
						if((int) ((1 / RFToEMCRatio) * this.getEnergyStored()) > 0){
							this.setStoredEMC(this.getStoredEmc() +(int) ((1 / RFToEMCRatio) * this.getEnergyStored()) );
							this.setEnergyStored(0);
						}
					} else{
						this.setStoredEMC(this.getStoredEmc() +(int) maxEMCProductionRate );
						this.getEnergyStorage().extractEnergy((int) (RFToEMCRatio * maxEMCProductionRate), false);
					}
				}
			}
			
			this.sendEMC();
		}
	}
	
	private void sendEMC()
	{
		if (this.getStoredEmc() == 0){
			return;
		}
		this.sendToAllAcceptors();
	}
	
	public void sendToAllAcceptors()
	{
		Map<ForgeDirection, TileEntity> tiles = Maps.filterValues(WorldHelper.getAdjacentTileEntitiesMapped(worldObj, this), Predicates.instanceOf(IEmcAcceptor.class));

		double emcToGive = Math.min(maxEMCOutputRate, this.getStoredEmc());
		for (Map.Entry<ForgeDirection, TileEntity> entry : tiles.entrySet())
		{
			if(emcToGive > 0){
				double emcUsed = ((IEmcAcceptor) entry.getValue()).acceptEMC(entry.getKey().getOpposite(), emcToGive);
				this.setStoredEMC(this.getStoredEmc() - emcUsed);
				emcToGive -= emcUsed;
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
	public double provideEMC(ForgeDirection arg0, double requestedExtractAmount) {
		double toRemove = Math.min(this.getStoredEmc(), requestedExtractAmount);
		this.setStoredEMC(this.getStoredEmc() - toRemove);
		return toRemove;
	}

	@Override
	public int receiveEnergy(ForgeDirection arg0, int amount, boolean simulate) {
		return this.getEnergyStorage().receiveEnergy(amount, simulate);
	}
}
