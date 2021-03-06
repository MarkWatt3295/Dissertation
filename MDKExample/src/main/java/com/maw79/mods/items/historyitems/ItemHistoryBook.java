package com.maw79.mods.items.historyitems;

import java.util.List;

import com.maw79.mods.client.gui.GuiFamilyCow;
import com.maw79.mods.client.gui.GuiFirstBook;
import com.maw79.mods.client.gui.GuiTutorial;
import com.maw79.mods.client.gui.books.GuiHistoryBook;
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

public class ItemHistoryBook extends Item{
	
	public ItemHistoryBook(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		
	}
	
	/**
	 * Will Open the Book Gui
	 * @return 
	 */
	@Override
	public  ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(player.world.isRemote){
		Minecraft.getMinecraft().displayGuiScreen(new GuiHistoryBook());
		}
		
		return super.onItemRightClick(world, player, hand);
	}
	
	/**
	 * Adds a tool tip to the item
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		tooltip.add(TextFormatting.YELLOW + Utils.getLang().localize("historybook.tooltip"));
	}
}
