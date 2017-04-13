package com.maw79.mods.tileentity.storetileentity;



import com.maw79.mods.blocks.historyblocks.artifactupdater.TileEntityArtifactResearcher;
import com.maw79.mods.entity.passive.EntityTourGuide;
import com.maw79.mods.entity.passive.Test;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.tileentity.TileEntityBlockBreaker;
import com.maw79.mods.util.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerStore extends Container {

	/**
	 * This tile entity and the item handler (inventory)
	 */
	
	private TileEntityStore te;
	public static IItemHandler handler;
	public static IInventory PlayeInveni;
	/**
	 * Tells the container where the slots are
	 * @param playerInv The player's inventory
	 * @param te The tile entity
	 */
	public ContainerStore(IInventory playerInv, TileEntityStore te) {
		this.te = te;
		
		EntityPlayer entity = Minecraft.getMinecraft().player;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		
		//Our tile entity slots
		this.addSlotToContainer(new SlotItemHandler(handler, 0, 20, 15));
		this.addSlotToContainer(new SlotItemHandler(handler, 1, 20, 39));
		this.addSlotToContainer(new SlotItemHandler(handler, 2, 20, 63));
		this.addSlotToContainer(new SlotItemHandler(handler, 3, 100, 15));
		this.addSlotToContainer(new SlotItemHandler(handler, 4, 100, 39));
		this.addSlotToContainer(new SlotItemHandler(handler, 5, 100, 63));
		//this.addSlotToContainer(new SlotItemHandler(handler, 6, 62, 53));
		//this.addSlotToContainer(new SlotItemHandler(handler, 7, 80, 53));
		//this.addSlotToContainer(new SlotItemHandler(handler, 8, 98, 53));
	//	this.addSlotToContainer(new SlotEnchantedBook(handler, 9, 134, 17));

		
		//The player's inventory slots
		int xPos = 8; //The x position of the top left player inventory slot on our texture
		int yPos = 84; //The y position of the top left player inventory slot on our texture

		//Player slots
		for (int y = 1; y < 3; ++y) { //y < 3, y = 0
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
			}
		}

		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
		}
		
		
		
		
	}
	

	/**
	 * Checks that the player can put items in and out of the container
	 */
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		//return this.te.isUseableByPlayer(player);
	
		return !player.isSpectator();
	}

	
}
