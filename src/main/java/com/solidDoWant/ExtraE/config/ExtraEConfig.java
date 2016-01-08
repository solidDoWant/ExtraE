package com.solidDoWant.ExtraE.config;

import java.io.File;

import com.solidDoWant.ExtraE.utils.EELogger;

import net.minecraftforge.common.config.Configuration;

public class ExtraEConfig {
	public static boolean enableCollector4;
	public static boolean enableCollector5;
	public static boolean enableCollector6;
	
	public static boolean enableRelay4;
	public static boolean enableRelay5;
	public static boolean enableRelay6;
	
	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile);
		
		try
		{
			config.load();
			
			config.getCategory("blocks").setComment("Enable/disable ExtraE blocks.");

			enableCollector4 = config.getBoolean("enableCollector4", "blocks", true, "Enable Energy Collector MK4 recipe");
			enableCollector5 = config.getBoolean("enableCollector5", "blocks", true, "Enable Energy Collector MK5 recipe");
			enableCollector6 = config.getBoolean("enableCollector6", "blocks", true, "Enable Energy Collector MK6 recipe");

			enableRelay4 = config.getBoolean("enableRelay4", "blocks", true, "Enable Energy Collector MK4 recipe");
			enableRelay5 = config.getBoolean("enableRelay5", "blocks", true, "Enable Energy Collector MK5 recipe");
			enableRelay6 = config.getBoolean("enableRelay6", "blocks", true, "Enable Energy Collector MK6 recipe");
			
			EELogger.logInfo("Loaded configuration file.");
		}
		catch (Exception e)
		{
			EELogger.logFatal("Caught exception while loading config file!");
			e.printStackTrace();
		}
		finally
		{
			if (config.hasChanged())
			{
				config.save();
			}
		}
	}
}
