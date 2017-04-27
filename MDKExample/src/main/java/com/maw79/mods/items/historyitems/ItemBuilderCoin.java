package com.maw79.mods.items.historyitems;

import java.util.List;

import com.maw79.mods.client.gui.GuiFirstBook;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.client.gui.books.GuiNumberSequence;
import com.maw79.mods.client.gui.books.GuiOddManual;
import com.maw79.mods.handlers.ModEventHandler;
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

public class ItemBuilderCoin extends Item{
	
	public ItemBuilderCoin(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}
	
	
	@Override
	public  ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(!player.world.isRemote){
			ModEventHandler.romandomus = true;
			ModEventHandler.adminmode = false;
			player.inventory.getCurrentItem().damageItem(2, player );
			GuiNotif.xyztrack = "";
		}
		return super.onItemRightClick(world, player, hand);
	}
	
	/**
	 * Adds a tool tip to the item
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		tooltip.add(TextFormatting.GOLD + Utils.getLang().localize("buildercoin.tooltip"));
	}
}
