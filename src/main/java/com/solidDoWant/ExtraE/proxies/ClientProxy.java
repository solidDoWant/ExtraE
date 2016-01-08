package com.solidDoWant.ExtraE.proxies;

import com.solidDoWant.ExtraE.events.ToolTipEvent;

import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerClientOnlyEvents() 
	{
		MinecraftForge.EVENT_BUS.register(new ToolTipEvent());
	}
}
