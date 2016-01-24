package com.solidDoWant.ExtraE.proxies;

import java.io.File;

import com.solidDoWant.ExtraE.ExtraECore;
import com.solidDoWant.ExtraE.config.ExtraEConfig;
import com.solidDoWant.ExtraE.gameObjects.ObjectHandler;
import com.solidDoWant.ExtraE.network.PacketHandler;
import com.solidDoWant.ExtraE.utils.AchievementHandler;
import com.solidDoWant.ExtraE.utils.GuiHandler;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public abstract class CommonProxy {
	public void preInit(FMLPreInitializationEvent event)
	{
		
		ExtraEConfig.init(new File(ExtraECore.CONFIG_DIR, "ExtraE.cfg"));
		
		ObjectHandler.register();
		ObjectHandler.addRecipes();
		
		registerClientOnlyEvents();
		
		NetworkRegistry.INSTANCE.registerGuiHandler(ExtraECore.instance, new GuiHandler());
		
		PacketHandler.registerPackets();
	}
	
	public abstract void registerClientOnlyEvents();
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		AchievementHandler.init();
	}
}
