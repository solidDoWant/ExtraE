package com.solidDoWant.ExtraE.gameObjects.gui;

import com.solidDoWant.ExtraE.gameObjects.tiles.EMCEngineTile;

import net.minecraft.inventory.Container;

public class GUIEMCEngine extends BasicInfoGuiContainer{
	private EMCEngineTile tile;
	
	public GUIEMCEngine(Container container, EMCEngineTile tile) {
		super(container);
		this.tile = tile;
	}
	
	@Override
	public void subclassDrawBackgroundLayer(float partialTick, int mouseX, int mouseY){
		int startX = (width - xSize) / 2;
		
		this.drawString(fontRendererObj, "Stored EMC: " + (int) Math.floor(tile.getStoredEmc()), (width / 2) - fontRendererObj.getStringWidth("Stored EMC: " + (int) Math.floor(tile.getStoredEmc())) / startX - 43, (height / 2) - 53, 0xFFFFFF);
		this.drawString(fontRendererObj, "Stored RF: " + tile.getEnergyStored(null), (width / 2) - fontRendererObj.getStringWidth("Stored RF: " + tile.getEnergyStored(null)) / startX - 43, (height / 2) - 38, 0xFFFFFF);
	}
}
