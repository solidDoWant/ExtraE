package com.solidDoWant.ExtraE.gameObjects.gui;

import org.lwjgl.opengl.GL11;

import com.solidDoWant.ExtraE.ExtraECore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class BasicInfoGuiContainer extends GuiContainer{
	private static final ResourceLocation texture = new ResourceLocation(ExtraECore.MODID.toLowerCase(), "textures/gui/BasicInfoGui.png");
	
	public BasicInfoGuiContainer(Container container) {
		super(container);
	}
	
	@Override
	protected final void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseY) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		
		int startX = (width - xSize) / 2;
		int startY = (height - ySize) / 2;
		
		this.drawTexturedModalRect(startX, startY, 0, 0, xSize, ySize);
		
		this.subclassDrawBackgroundLayer(partialTick, mouseX, mouseY);
	}
	
	public void subclassDrawBackgroundLayer(float partialTick, int mouseX, int mouseY){
		
	}
}
