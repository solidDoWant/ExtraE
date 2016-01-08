package com.solidDoWant.ExtraE;

import java.io.File;

import com.solidDoWant.ExtraE.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.SidedProxy;
import moze_intel.projecte.PECore;

@Mod(modid = ExtraECore.MODID, version = ExtraECore.VERSION, name = ExtraECore.MODNAME, dependencies = "required-after:" + PECore.MODID)
public class ExtraECore {
	public static final String MODID = "extrae";
	public static final String VERSION = "1.0";
	public static final String MODNAME = "ExtraE";
	
	public static File CONFIG_DIR;
	
	@Instance
	public static ExtraECore instance = new ExtraECore();
	
	@SidedProxy(clientSide="com.solidDoWant.ExtraE.proxies.ClientProxy", serverSide="com.solidDoWant.ExtraE.proxies.ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		CONFIG_DIR = new File(event.getModConfigurationDirectory(), "ProjectE");
		proxy.preInit(event);
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.load(event);
	}
}
