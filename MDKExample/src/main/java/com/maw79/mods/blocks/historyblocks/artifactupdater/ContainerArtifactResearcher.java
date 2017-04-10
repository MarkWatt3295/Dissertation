package com.maw79.mods.blocks.historyblocks.artifactupdater;



import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerArtifactResearcher extends Container {

	/**
	 * This tile entity and the item handler (inventory)
	 */
	private TileEntityArtifactResearcher te;
	public static IItemHandler handler;
	public static IInventory PlayeInveni;
	
	
	

	/**
	 * Tells the container where the slots are
	 * @param playerInv The player's inventory
	 * @param te The tile entity
	 */
	public ContainerArtifactResearcher(IInventory playerInv, TileEntityArtifactResearcher te) {
		this.te = te;
		
		EntityPlayer entity = Minecraft.getMinecraft().player;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null); //Gets the inventory from our tile entity

		
		//this.addSlotToContainer(new SlotItemHandler(handler, 0, 62, 17));
		//this.addSlotToContainer(new SlotItemHandler(handler, 1, 80, 17));
		//this.addSlotToContainer(new SlotItemHandler(handler, 2, 98, 17));
		//this.addSlotToContainer(new SlotItemHandler(handler, 3, 62, 35));
		this.addSlotToContainer(new SlotItemHandler(handler, 4, 80, 35));
		//this.addSlotToContainer(new SlotItemHandler(handler, 5, 98, 35));
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
		return this.te.isUseableByPlayer(player);
	}

}