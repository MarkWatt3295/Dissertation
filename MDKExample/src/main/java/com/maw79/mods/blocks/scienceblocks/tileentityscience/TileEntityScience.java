package com.maw79.mods.blocks.scienceblocks.tileentityscience;

import java.util.ArrayList;
import java.util.Random;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.network.GuiInventoryPacketHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityScience extends TileEntity implements ITickable, ICapabilityProvider {

	/**
	 * New 1.9.4 onwards. Using forge capabilities instead of {@link IInventory}
	 */
	public ItemStackHandler handler;
	private int cooldown;
	private int cooldownCap = 100;
	private Random random;
	
	public boolean correctproperties = false;
	public boolean setremove = false;

	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityScience() {
		this.cooldown = 0;
		this.handler = new ItemStackHandler(10);
		this.random = new Random();
	}

	/**
	 * Reads data from nbt where data is stored
	 */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.cooldown = nbt.getInteger("Cooldown");
		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler")); 
		// Gets the ItemStackHandler from tag within a tag

		super.readFromNBT(nbt);
	}

	/**
	 * Writes data to nbt so it is stored
	 */
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("Cooldown", this.cooldown);
		nbt.setTag("ItemStackHandler", this.handler.serializeNBT()); // We write our ItemStackHandler as a tag in a tag

		return super.writeToNBT(nbt);
	}

	
	/**
	 * The packet which is used to update the tile entity which holds all of the
	 * tileentities data
	 */
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}

	/**
	 * Reads the nbt when it receives a packet
	 */
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	/**
	 * Gets the nbt for a new packet
	 */
	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	/**
	 * Handles when you get an update
	 */
	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

	/**
	 * Gets the tile entities nbt with all of the data stored in it
	 */
	@Override
	public NBTTagCompound getTileData() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	/**
	 * New 1.9.4 onwards. Capability system
	 */
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.handler; // Makes it so that you can get the
										// capability from our tile entity
		return super.getCapability(capability, facing);
	}

	/**
	 * Says what our block is capable of
	 */
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}

	/**
	 * Says whether the player can interact with the block - used for our
	 * {@link GuiBlockBreaker}
	 * 
	 * @param player
	 *            The player to test
	 * @return If the player can interact with the block
	 */
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.getPos()) == this
				&& player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	/**
	 * Says that if the block state updates, the tile entity shouldn't get
	 * destroyed but should not refresh
	 */
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		return false;
	}

	GuiScienceTe gte;
	public int max =0;
	@Override
	public void update() {
		if (this.world != null) {
		IBlockState currentState = this.world.getBlockState(pos);
		EntityPlayer player = Minecraft.getMinecraft().player;
		
		/*if(handler.getStackInSlot(3).isItemEqual(new ItemStack(ModItems.obsidianingot)) 
				&& (handler.getStackInSlot(5).isItemEqual(new ItemStack(ModItems.bolt))))
				//&& (handler.getStackInSlot(7).isItemEqual(ItemStack.EMPTY)))
				{
			if(true){
				System.out.println("true test");
				player.playSound(ModSoundHandler.MAWSOUND_COIN, 2, 4);
				//System.out.println(max);
				//if (!world.isRemote)
				handler.extractItem(3, 1, false);
				handler.extractItem(5, 1, false);
					//handler.insertItem(2, ItemStack.EMPTY, false);
				//handler.getStackInSlot(7).set;
				
			}
			//if(max !=1){
			handler.insertItem(4, new ItemStack(Blocks.GOLD_BLOCK), false);
			
		//	max++;
			//}
		
			//else if(false){
			//	System.out.println("False Test / 7 isn't EMPTY");
			//}
		
		}*/
		ItemStack slot1 = handler.getStackInSlot(3);
		ItemStack slot2 = handler.getStackInSlot(4);
		ItemStack slot3 = handler.getStackInSlot(5);
		
		ArrayList<ItemStack>itemsis = new ArrayList<ItemStack>();
		itemsis.add(new ItemStack (ModItems.LABELOPAQUE));
		itemsis.add(new ItemStack (ModItems.LABELCHAIR));
		itemsis.add(new ItemStack (ModItems.LABELSTRONG));
		
		//System.out.println("Out of Stack Loop --> Correct Properties = "+ correctproperties);
		for (int i = 0; i < itemsis.size(); i++) {
		       // System.out.println(itemsis.get(i));
			itemsis.get(i);
		    
		if(handler.getStackInSlot(3).isItemEqual(itemsis.get(i))||(handler.getStackInSlot(4).isItemEqual(itemsis.get(i))
				||(handler.getStackInSlot(5).isItemEqual(itemsis.get(i))))){
			//System.out.println("slot 1 is : " + slot1.getDisplayName());
			//System.out.println("slot 2 is : " + slot2.getDisplayName());
			//System.out.println("slot 3 is : " + slot3.getDisplayName());
			correctproperties = true;
			
			//System.out.println("In Stack Loop --> Correct Properties = "+ correctproperties);
			//removeItems();
		}
		
		
		
		}
		if (setremove = true){
			removeItems();
			setremove = false;
		}
		}
		
	
		
	}
	
	
	public void removeItems(){
		//ContainerScience cs;
		//cs.removeItems();
		handler.extractItem(3, 1, false);
		handler.extractItem(4, 1, false);
		handler.extractItem(5, 1, false);
		setremove = false;
	}

	

}

