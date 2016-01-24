package com.solidDoWant.ExtraE.network;

import com.solidDoWant.ExtraE.ExtraECore;
import com.solidDoWant.ExtraE.network.packets.EMCRFSyncPacket;
import com.solidDoWant.ExtraE.utils.Constants;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {
	private static final SimpleNetworkWrapper HANDLER = NetworkRegistry.INSTANCE.newSimpleChannel(ExtraECore.MODID);
	
	public static void registerPackets(){
		HANDLER.registerMessage(EMCRFSyncPacket.EMCRFSyncPacketHandler.class, EMCRFSyncPacket.class, Constants.EMCENGINE_PACKET_ID, Side.CLIENT);
	}
	
	public static void sendPacket(IMessage packet){
		HANDLER.sendToAll(packet);
	}
}
