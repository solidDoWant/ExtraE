package com.solidDoWant.ExtraE.config;

import java.io.File;

import com.solidDoWant.ExtraE.gameObjects.tiles.EMCEngineTile;
import com.solidDoWant.ExtraE.gameObjects.tiles.RFCollectorTile;
import com.solidDoWant.ExtraE.utils.EELogger;

import net.minecraftforge.common.config.Configuration;

public class ExtraEConfig {
	public static final String blocksCategoryName = "Blocks";
	public static final String EMCEngineCategoryName = "EMC Engine";
	public static final String RFCollectorCategoryName = "RF Collector";
	
	public static boolean enableCollector4;
	public static boolean enableCollector5;
	public static boolean enableCollector6;
	
	public static boolean enableRelay4;
	public static boolean enableRelay5;
	public static boolean enableRelay6;
	
	public static boolean enableEMCEngine;
	public static boolean enableRFCollector;
	
	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile, true);
		
		try
		{
			config.load();
			
			config.getCategory(blocksCategoryName).setComment("Enable/disable ExtraE blocks.");

			enableCollector4 = config.getBoolean("enableCollector4", blocksCategoryName, true, "Enable Energy Collector MK4 recipe");
			enableCollector5 = config.getBoolean("enableCollector5", blocksCategoryName, true, "Enable Energy Collector MK5 recipe");
			enableCollector6 = config.getBoolean("enableCollector6", blocksCategoryName, true, "Enable Energy Collector MK6 recipe");

			enableRelay4 = config.getBoolean("enableRelay4", blocksCategoryName, true, "Enable Energy Collector MK4 recipe");
			enableRelay5 = config.getBoolean("enableRelay5", blocksCategoryName, true, "Enable Energy Collector MK5 recipe");
			enableRelay6 = config.getBoolean("enableRelay6", blocksCategoryName, true, "Enable Energy Collector MK6 recipe");
			
			enableEMCEngine = config.getBoolean("enableEMCEngine", blocksCategoryName, true, "Enable EMC Engine recipe");
			enableRFCollector = config.getBoolean("enableRFCollector", blocksCategoryName, true, "Enable RF Collector recipe");
			
			config.getCategory(EMCEngineCategoryName).setComment("Set values for the EMC Engine.");
			
			EMCEngineTile.maxEMC = config.getFloat("maxEMC", EMCEngineCategoryName, 100000f, 1, (float) Double.MAX_VALUE, "The maximum EMC that can be stored");
			EMCEngineTile.maxRF = config.getInt("maxRF", EMCEngineCategoryName, 100000, 1, Integer.MAX_VALUE, "The maximum RF that can be stored");
			EMCEngineTile.emcToRFRatio = config.getFloat("emcToRFRatio", EMCEngineCategoryName, 50, 1, (float) Double.MAX_VALUE, "How many EMC it takes to produce 1 RF");
			EMCEngineTile.maxRFProductionRate = config.getFloat("maxRFProductionRate", EMCEngineCategoryName, 500000, 1, (float) Double.MAX_VALUE, "The maximum RF production rate per tick");
			EMCEngineTile.maxRFOutputRate = config.getInt("maxRFOutputRate", EMCEngineCategoryName, 500000, 1, Integer.MAX_VALUE, "The maximum RF output per tick");

			config.getCategory(RFCollectorCategoryName).setComment("Set values for the EMC Engine.");

			RFCollectorTile.maxEMC = config.getFloat("maxEMC", RFCollectorCategoryName, 100000f, 1, (float) Double.MAX_VALUE, "The maximum EMC that can be stored");
			RFCollectorTile.maxRF = config.getInt("maxRF", RFCollectorCategoryName, 100000, 1, Integer.MAX_VALUE, "The maximum RF that can be stored");
			RFCollectorTile.RFToEMCRatio = config.getFloat("RFToEMCRatio", RFCollectorCategoryName, 1 / 50, 1, (float) Double.MAX_VALUE, "How many RF it takes to produce 1 EMC. This number can be a decimal.");
			RFCollectorTile.maxEMCProductionRate = config.getFloat("maxEMCProductionRate", RFCollectorCategoryName, 500000, 1, (float) Double.MAX_VALUE, "The maximum EMC production rate per tick");
			RFCollectorTile.maxEMCOutputRate = config.getInt("maxEMCOutputRate", RFCollectorCategoryName, 500000, 1, Integer.MAX_VALUE, "The maximum EMC output per tick");
			
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
