package com.maw79.mods.items.historyitems;

import java.util.List;

import com.maw79.mods.client.gui.GuiFirstBook;
import com.maw79.mods.client.gui.books.GuiCoordinatesManual;
import com.maw79.mods.client.gui.books.GuiEgyptArtifactsManual;
import com.maw79.mods.client.gui.books.GuiEvenManual;
import com.maw79.mods.client.gui.books.GuiFractionsBook;
import com.maw79.mods.client.gui.books.GuiNumberSequence;
import com.maw79.mods.client.gui.books.GuiRomanArtifactsManual;
import com.maw79.mods.handlers.TickHandler;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemEgyptArtifactsManual extends Item{
	
	public ItemEgyptArtifactsManual(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		
	}
	
	/**
	 * Will Open the Coordinates Manual Gui
	 * @return 
	 */
	@Override
	public  ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(player.world.isRemote){
		Minecraft.getMinecraft().displayGuiScreen(new GuiEgyptArtifactsManual());
		}
		return super.onItemRightClick(world, player, hand);
	}
	
	/**
	 * Adds a tool tip to the item
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		tooltip.add(TextFormatting.LIGHT_PURPLE + Utils.getLang().localize("egyptartifactsmanual.tooltip"));
	}
}
