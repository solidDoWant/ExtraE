package com.solidDoWant.ExtraE.events;

import com.solidDoWant.ExtraE.gameObjects.ObjectHandler;
import com.solidDoWant.ExtraE.utils.Constants;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import moze_intel.projecte.api.item.IItemEmc;
import moze_intel.projecte.config.ProjectEConfig;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

@SideOnly(Side.CLIENT)
public class ToolTipEvent 
{
	@SuppressWarnings("unused")
	@SubscribeEvent
	public void tTipEvent(ItemTooltipEvent event)
	{
		ItemStack current = event.itemStack;
		Item currentItem = current.getItem();
		Block currentBlock = Block.getBlockFromItem(currentItem);

		if (current == null)
		{
			return;
		}
		
		if (ProjectEConfig.showStatTooltip)
		{
			/**
			 * Collector ToolTips
			 */
			String unit = StatCollector.translateToLocal("pe.emc.name");
			String rate = StatCollector.translateToLocal("pe.emc.rate");

			if (currentBlock == ObjectHandler.collectorMK4Block)
			{
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxgenrate_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + rate, Constants.COLLECTOR_MK4_GEN));
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxstorage_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + unit, Constants.COLLECTOR_MK4_MAX));
			}

			if (currentBlock == ObjectHandler.collectorMK5Block)
			{
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxgenrate_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + rate, Constants.COLLECTOR_MK5_GEN));
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxstorage_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + unit, Constants.COLLECTOR_MK5_MAX));
			}

			if (currentBlock == ObjectHandler.collectorMK6Block)
			{
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxgenrate_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + rate, Constants.COLLECTOR_MK6_GEN));
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxstorage_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + unit, Constants.COLLECTOR_MK6_MAX));
			}
			
			/**
			 * Relay ToolTips
			 */
			if (currentBlock == ObjectHandler.relayMK4Block)
			{
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxoutrate_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + rate, Constants.RELAY_MK4_OUTPUT));
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxstorage_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + unit, Constants.RELAY_MK4_MAX));
			}

			if (currentBlock == ObjectHandler.relayMK5Block)
			{
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxoutrate_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + rate, Constants.RELAY_MK5_OUTPUT));
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxstorage_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + unit, Constants.RELAY_MK5_MAX));
			}

			if (currentBlock == ObjectHandler.relayMK6Block)
			{
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxoutrate_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + rate, Constants.RELAY_MK6_OUTPUT));
				event.toolTip.add(EnumChatFormatting.DARK_PURPLE
						+ String.format(StatCollector.translateToLocal("pe.emc.maxstorage_tooltip")
						+ EnumChatFormatting.BLUE + " %d " + unit, Constants.RELAY_MK6_MAX));
			}
		}
		
		if (current.hasTagCompound())
		{
			if (current.stackTagCompound.getBoolean("ProjectEBlock"))
			{
				event.toolTip.add(EnumChatFormatting.GREEN + StatCollector.translateToLocal("pe.misc.wrenched_block"));
				
				if (current.stackTagCompound.getDouble("EMC") > 0)
				{
					event.toolTip.add(EnumChatFormatting.YELLOW + String.format(
							StatCollector.translateToLocal("pe.emc.storedemc_tooltip") + " " + EnumChatFormatting.RESET + "%,d", (int) current.stackTagCompound.getDouble("EMC")));
				}
			}
			if (current.getItem() instanceof IItemEmc || current.stackTagCompound.hasKey("StoredEMC"))
			{
				double value = 0;
				if (current.stackTagCompound.hasKey("StoredEMC"))
				{
					value = current.stackTagCompound.getDouble("StoredEMC");
				} else
				{
					value = ((IItemEmc) current.getItem()).getStoredEmc(current);
				}

				event.toolTip.add(EnumChatFormatting.YELLOW + StatCollector.translateToLocal("pe.emc.storedemc_tooltip") + " " + EnumChatFormatting.RESET + moze_intel.projecte.utils.Constants.EMC_FORMATTER.format(value));
			}

			if (current.stackTagCompound.hasKey("StoredXP"))
			{
				event.toolTip.add(String.format(EnumChatFormatting.DARK_GREEN + StatCollector.translateToLocal("pe.misc.storedxp_tooltip") + " " + EnumChatFormatting.GREEN + "%,d", current.stackTagCompound.getInteger("StoredXP")));
			}
		}
	}
}
