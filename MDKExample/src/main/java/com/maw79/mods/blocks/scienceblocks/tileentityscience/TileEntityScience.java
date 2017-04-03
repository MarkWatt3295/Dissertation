package com.maw79.mods.blocks.scienceblocks.tileentityscience;

import java.util.ArrayList;
import java.util.Random;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.network.GuiInventoryPacketHandler;
import com.maw79.mods.util.Utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
import scala.sys.process.processInternal;

public class TileEntityScience extends TileEntity implements ITickable, ICapabilityProvider {

	/**
	 * New 1.9.4 onwards. Using forge capabilities instead of {@link IInventory}
	 */
	public  ItemStackHandler handler;
	private int cooldown;
	private int cooldownCap = 100;
	private Random random;
	
	public static boolean cangiveblocks = true;
	
	private boolean label1match = false;
	private boolean label2match = false;
	private boolean label3match = false;
	private boolean label4match = false;
	private boolean label5match = false;
	private boolean label6match = false;
	
	
	
	public ArrayList<ItemStack>itemsis = new ArrayList<ItemStack>();
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

	@Override
	public void update() {
		//Utils.getLogger().info("Below Update. Properties is : "+ correctproperties);
		//if (this.world != null) {
		if (!world.isRemote) {
		IBlockState currentState = this.world.getBlockState(pos);
		EntityPlayer player = Minecraft.getMinecraft().player;
		
		
		
		//Utils.getLogger().info("Under IS. Clicker is : "+ setClicker);
		
		itemsis.add(new ItemStack (ModItems.LABELOPAQUE));
		itemsis.add(new ItemStack (ModItems.LABELCHAIR));
		itemsis.add(new ItemStack (ModItems.LABELSTRONG));
		itemsis.add(new ItemStack (ModItems.LABELDURABLE));
		itemsis.add(new ItemStack (ModItems.LABELFLEXIBLE));
		itemsis.add(new ItemStack (ModItems.LABELTOUGH));
		
		itemsInArray();
		
			
		
		
		}
		//Utils.getLogger().info("Test Print: "+ correctproperties);
	
		
	}
	
	
	
	public  void removeItems(){
		ContainerScience.removeItems();
		//cs.removeItems();
		handler.extractItem(3, 1, false);
		handler.extractItem(4, 1, false);
		handler.extractItem(5, 1, false);
		
	}
	
	public void itemsInArray(){
		ItemStack slot1 = handler.getStackInSlot(3);
		ItemStack slot2 = handler.getStackInSlot(4);
		ItemStack slot3 = handler.getStackInSlot(5);
		ItemStack slot4 = handler.getStackInSlot(6);
		ItemStack slot5 = handler.getStackInSlot(7);
		ItemStack slot6 = handler.getStackInSlot(8);
		
		for (int i = 0; i < itemsis.size(); i++) {
		      
		if(slot1.isItemEqual(itemsis.get(0))
				||(slot1.isItemEqual(itemsis.get(1))
				||(slot1.isItemEqual(itemsis.get(2))
				||(slot1.isItemEqual(itemsis.get(3))
				||(slot1.isItemEqual(itemsis.get(4))
				||(slot1.isItemEqual(itemsis.get(5)))))))){
			//Utils.getLogger().info("Label 1 - Match Made " + slot1.getDisplayName());
			label1match = true;
	}
		
		if(slot2.isItemEqual(itemsis.get(0))
				||(slot2.isItemEqual(itemsis.get(1))
				||(slot2.isItemEqual(itemsis.get(2))
				||(slot2.isItemEqual(itemsis.get(3))
				||(slot2.isItemEqual(itemsis.get(4))
				||(slot2.isItemEqual(itemsis.get(5)))))))){
			//Utils.getLogger().info("Label 2 - Match Made " + slot2.getDisplayName());
			label2match = true;
	}
		if(slot3.isItemEqual(itemsis.get(0))
				||(slot3.isItemEqual(itemsis.get(1))
				||(slot3.isItemEqual(itemsis.get(2))
				||(slot3.isItemEqual(itemsis.get(3))
				||(slot3.isItemEqual(itemsis.get(4))
				||(slot3.isItemEqual(itemsis.get(5)))))))){
			//Utils.getLogger().info("Label 3 - Match Made " + slot3.getDisplayName());
			label3match = true;
	}
		if(slot4.isItemEqual(itemsis.get(0))
				||(slot4.isItemEqual(itemsis.get(1))
				||(slot4.isItemEqual(itemsis.get(2))
				||(slot4.isItemEqual(itemsis.get(3))
				||(slot4.isItemEqual(itemsis.get(4))
				||(slot4.isItemEqual(itemsis.get(5)))))))){
			//Utils.getLogger().info("Label 4 - Match Made " + slot4.getDisplayName());
			label4match = true;
	}
		if(slot5.isItemEqual(itemsis.get(0))
				||(slot5.isItemEqual(itemsis.get(1))
				||(slot5.isItemEqual(itemsis.get(2))
				||(slot5.isItemEqual(itemsis.get(3))
				||(slot5.isItemEqual(itemsis.get(4))
				||(slot5.isItemEqual(itemsis.get(5)))))))){
			//Utils.getLogger().info("Label 5 - Match Made " + slot5.getDisplayName());
			label5match = true;
	}
		if(slot6.isItemEqual(itemsis.get(0))
				||(slot6.isItemEqual(itemsis.get(1))
				||(slot6.isItemEqual(itemsis.get(2))
				||(slot6.isItemEqual(itemsis.get(3))
				||(slot6.isItemEqual(itemsis.get(4))
				||(slot6.isItemEqual(itemsis.get(5)))))))){
			//Utils.getLogger().info("Label 6 - Match Made " + slot6.getDisplayName());
			label6match = true;
			 
	}
		 
	
	else  {
		label1match = false;
		label2match = false;
		label3match = false;
		label4match = false;
		label5match = false;
		label6match = false;
		GuiScienceTe.correctlabels = false;
		
		//Utils.getLogger().info("Somethings not right");
		if(label1match ==  false){
			//Utils.getLogger().info("Label 1 is FALSE");
			GuiScienceTe.correctlabels = false;
		}
		if(label2match ==  false){
			//Utils.getLogger().info("Label 2 is FALSE");
			GuiScienceTe.correctlabels = false;
		}
		if(label3match ==  false){
			//Utils.getLogger().info("Label 3 is FALSE");
			GuiScienceTe.correctlabels = false;
		}
		if(label4match ==  false){
			//Utils.getLogger().info("Label 4 is FALSE");
			GuiScienceTe.correctlabels = false;
		}
		if(label5match ==  false){
			//Utils.getLogger().info("Label 5 is FALSE");
			GuiScienceTe.correctlabels = false;
		}
		if(label6match ==  false){
			//Utils.getLogger().info("Label 6 is FALSE");
			GuiScienceTe.correctlabels = false;
		}
		
	}
		if(label1match && label2match && label3match && label4match && label5match && label6match == true){
			//Utils.getLogger().info("All Labels Are TRUE ");
			GuiScienceTe.correctlabels = true;
		}
		else{
			GuiScienceTe.correctlabels = false;
		}
		
		
		
		}
	}

	

}
