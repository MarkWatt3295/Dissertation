package com.maw79.mods.blocks.scienceblocks.tileentityscience;



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

public class ContainerScience extends Container {

	/**
	 * This tile entity and the item handler (inventory)
	 */
	private TileEntityScience te;
	public static IItemHandler handler;
	public static IInventory PlayeInveni;

	/**
	 * Tells the container where the slots are
	 * @param playerInv The player's inventory
	 * @param te The tile entity
	 */
	public ContainerScience(IInventory playerInv, TileEntityScience te) {
		this.te = te;
		
		EntityPlayer entity = Minecraft.getMinecraft().player;
		this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null); //Gets the inventory from our tile entity

		
		
		//Our tile entity slots
		//this.addSlotToContainer(new SlotItemHandler(handler, 0, 62, 17));
		//this.addSlotToContainer(new SlotItemHandler(handler, 1, 80, 17));
		//this.addSlotToContainer(new SlotItemHandler(handler, 2, 98, 17));
		this.addSlotToContainer(new SlotItemHandler(handler, 3, 62, 35));
		this.addSlotToContainer(new SlotItemHandler(handler, 4, 80, 35));
		this.addSlotToContainer(new SlotItemHandler(handler, 5, 98, 35));
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
		
		
		
		
		//this.addSlotToContainer(new SlotItemHandler(handler, 3, 62, 35) {
			//public void onSlotChanged() {
			//	super.onSlotChanged();
				
				//if (getHasStack()) {
				//	EntityPlayer entity = Minecraft.getMinecraft().player;
				//	int i = (int) entity.posX;
				//	int j = (int) entity.posY;
				//	int k = (int) entity.posZ;
				//	MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
					//World world = server.worlds[0];

					
					//if (true) {
						//world.playSound((EntityPlayer) null, (double) i + 0.5D, (double) j + 0.5D, (double) k + 0.5D,
						//		(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
							//			("entity.chicken.egg"))), SoundCategory.NEUTRAL, 1.0F, 1.0F);
					//	System.out.println("Sound Pkayer");
						
						
						//}
								
					//}
				
				
				
			/*	if(handler.getStackInSlot(0).isItemEqual(new ItemStack(ModItems.obsidianingot)) 
						&& (handler.getStackInSlot(2).isItemEqual(new ItemStack(ModItems.bolt))))
						//&& (handler.getStackInSlot(7).isItemEqual(ItemStack.EMPTY)))
						{
					if(true){
						System.out.println("true test");
						//if (!world.isRemote)
							handler.insertItem(7, new ItemStack(Blocks.GOLD_BLOCK, 1), false);
						//handler.getStackInSlot(7).set;
					}
					else if(false){
						System.out.println("False Test / 7 isn't EMPTY");
						*/
					
					

				
				
				
			//}
			
		//});
		
		
		
		
	}
	

	

	/**
	 * Checks that the player can put items in and out of the container
	 */
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.isUseableByPlayer(player);
	}

	/**
	 * Called when the player presses shift and takes an item out of the container
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
	    ItemStack previous = ItemStack.EMPTY;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < this.handler.getSlots()) {
	            // From the block breaker inventory to player's inventory
	            if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
	                return ItemStack.EMPTY;
	        } else {
	            // From the player's inventory to block breaker's inventory
	        	if(current.getItem() == Items.ENCHANTED_BOOK) {
	        		if(!this.mergeItemStack(current, 9, handler.getSlots(), false))
	        			return ItemStack.EMPTY;
	        	}
	            if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
	                return ItemStack.EMPTY;
	        }

	        if (current.getCount() == 0) //Use func_190916_E() instead of stackSize 1.11 only 1.11.2 use getCount()
	            slot.putStack(ItemStack.EMPTY); //Use ItemStack.field_190927_a instead of (ItemStack)null for a blank item stack. In 1.11.2 use ItemStack.EMPTY
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return null;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}
	public static void removeItems(){
		handler.extractItem(3, 1, false);
		handler.extractItem(4, 1, false);
		handler.extractItem(5, 1, false);
	}

}
