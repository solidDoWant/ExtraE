package com.solidDoWant.ExtraE.gameObjects;

import com.solidDoWant.ExtraE.config.ExtraEConfig;
import com.solidDoWant.ExtraE.gameObjects.blocks.*;
import com.solidDoWant.ExtraE.gameObjects.tiles.*;

import cpw.mods.fml.common.registry.GameRegistry;
import moze_intel.projecte.gameObjs.ObjHandler;
import moze_intel.projecte.gameObjs.items.itemBlocks.ItemCollectorBlock;
import moze_intel.projecte.gameObjs.items.itemBlocks.ItemRelayBlock;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ObjectHandler {
	public static final CreativeTabs tab = new CreativeTab();
	
	public static Block collectorMK4Block = new Collector(4);
	public static Block collectorMK5Block = new Collector(5);
	public static Block collectorMK6Block = new Collector(6);
	
	public static Block relayMK4Block = new Relay(4);
	public static Block relayMK5Block = new Relay(5);
	public static Block relayMK6Block = new Relay(6);
	
	public static Block EMCEngineBlock = new EMCEngine();
	
	public static void register()
	{

		GameRegistry.registerBlock(collectorMK4Block, ItemCollectorBlock.class, "collector_mk4");
		GameRegistry.registerBlock(collectorMK5Block, ItemCollectorBlock.class, "collector_mk5");
		GameRegistry.registerBlock(collectorMK6Block, ItemCollectorBlock.class, "collector_mk6");
		
		GameRegistry.registerTileEntityWithAlternatives(CollectorMK4Tile.class, "CollectorMK4Tile", "Energy Collector MK4 Tile");
		GameRegistry.registerTileEntityWithAlternatives(CollectorMK5Tile.class, "CollectorMK5Tile", "Energy Collector MK5 Tile");
		GameRegistry.registerTileEntityWithAlternatives(CollectorMK6Tile.class, "CollectorMK6Tile", "Energy Collector MK6 Tile");
		
		GameRegistry.registerBlock(relayMK4Block, ItemRelayBlock.class, "relay_mk4");
		GameRegistry.registerBlock(relayMK5Block, ItemRelayBlock.class, "relay_mk5");
		GameRegistry.registerBlock(relayMK6Block, ItemRelayBlock.class, "relay_mk6");
		
		GameRegistry.registerTileEntityWithAlternatives(RelayMK4Tile.class, "RelayMK4Tile", "Relay MK4 Tile");
		GameRegistry.registerTileEntityWithAlternatives(RelayMK5Tile.class, "RelayMK5Tile", "Relay MK5 Tile");
		GameRegistry.registerTileEntityWithAlternatives(RelayMK6Tile.class, "RelayMK6Tile", "Relay MK6 Tile");
		
		GameRegistry.registerBlock(EMCEngineBlock, ItemBlock.class, "emcengine");
		
		GameRegistry.registerTileEntityWithAlternatives(EngineEMCTile.class, "EngineEMCTile", "EMC Engine Tile");
	}

	public static void addRecipes() {
		ItemStack collectorMK4Stack = new ItemStack(collectorMK4Block);
		ItemStack collectorMK5Stack = new ItemStack(collectorMK5Block);
		ItemStack collectorMK6Stack = new ItemStack(collectorMK6Block);
		
		ItemStack relayMK4Stack = new ItemStack(relayMK4Block);
		ItemStack relayMK5Stack = new ItemStack(relayMK5Block);
		ItemStack relayMK6Stack = new ItemStack(relayMK6Block);

		//Collectors
		ItemStack collectorMK3Stack = new ItemStack(ObjHandler.collectorMK3);
		if(ExtraEConfig.enableCollector4){
			GameRegistry.addShapelessRecipe(collectorMK4Stack, collectorMK3Stack, collectorMK3Stack, collectorMK3Stack, collectorMK3Stack, collectorMK3Stack, collectorMK3Stack, collectorMK3Stack, collectorMK3Stack, collectorMK3Stack);
		}
		if(ExtraEConfig.enableCollector5)
		{
			GameRegistry.addShapelessRecipe(collectorMK5Stack, collectorMK4Stack, collectorMK4Stack, collectorMK4Stack, collectorMK4Stack, collectorMK4Stack, collectorMK4Stack, collectorMK4Stack, collectorMK4Stack, collectorMK4Stack);
		}
		if(ExtraEConfig.enableCollector6)
		{
			GameRegistry.addShapelessRecipe(collectorMK6Stack, collectorMK5Stack, collectorMK5Stack, collectorMK5Stack, collectorMK5Stack, collectorMK5Stack, collectorMK5Stack, collectorMK5Stack, collectorMK5Stack, collectorMK5Stack);
		}		
		
		//Relays
		ItemStack relayMK3Stack = new ItemStack(ObjHandler.relayMK3);
		if(ExtraEConfig.enableRelay4){
			GameRegistry.addShapelessRecipe(relayMK4Stack, relayMK3Stack, relayMK3Stack, relayMK3Stack, relayMK3Stack, relayMK3Stack, relayMK3Stack, relayMK3Stack, relayMK3Stack, relayMK3Stack);
		}
		if(ExtraEConfig.enableRelay5)
		{
			GameRegistry.addShapelessRecipe(relayMK5Stack, relayMK4Stack, relayMK4Stack, relayMK4Stack, relayMK4Stack, relayMK4Stack, relayMK4Stack, relayMK4Stack, relayMK4Stack, relayMK4Stack);
		}
		if(ExtraEConfig.enableRelay6)
		{
			GameRegistry.addShapelessRecipe(relayMK6Stack, relayMK5Stack, relayMK5Stack, relayMK5Stack, relayMK5Stack, relayMK5Stack, relayMK5Stack, relayMK5Stack, relayMK5Stack, relayMK5Stack);
		}	
	}
}
