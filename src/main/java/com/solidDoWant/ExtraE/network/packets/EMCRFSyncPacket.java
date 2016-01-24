package com.solidDoWant.ExtraE.network.packets;

import com.solidDoWant.ExtraE.gameObjects.tiles.EMCRFTile;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;

public class EMCRFSyncPacket implements IMessage{
	private EMCRFTile tile;
	
	private int xCoord;
	private int yCoord;
	private int zCoord;
	private double storedEMC;
	private int energyStored;
	
	public EMCRFSyncPacket(EMCRFTile tile){
		this.tile = tile;
	}
	
	public EMCRFSyncPacket(){
		//Screw you Forge, I'm going home
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		xCoord = buf.readInt();
		yCoord = buf.readInt();
		zCoord = buf.readInt();
		storedEMC = buf.readDouble();
		energyStored = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(tile.xCoord);
		buf.writeInt(tile.yCoord);
		buf.writeInt(tile.zCoord);
		buf.writeDouble(tile.getStoredEmc());
		buf.writeInt(tile.getEnergyStored(null));
	}
	
	public static class EMCRFSyncPacketHandler implements IMessageHandler<EMCRFSyncPacket, IMessage>{

		@Override
		public IMessage onMessage(EMCRFSyncPacket message, MessageContext ctx) {
			EMCRFTile tile = (EMCRFTile) Minecraft.getMinecraft().theWorld.getTileEntity(message.xCoord, message.yCoord, message.zCoord);
			if(tile != null){
				tile.setStoredEMC(message.storedEMC);
				tile.setEnergyStored(message.energyStored);
			}
			return null;
		}
		
	}

}
