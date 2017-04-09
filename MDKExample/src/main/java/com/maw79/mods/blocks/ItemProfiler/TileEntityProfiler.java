package com.maw79.mods.blocks.ItemProfiler;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.maw79.mods.client.gui.GuiCalculator;
import com.maw79.mods.client.gui.GuiPlayerLevel;
import com.maw79.mods.client.gui.profilerpages.GuiProfilerObsidianIngot;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.util.Utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
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

public class TileEntityProfiler extends TileEntity implements ITickable, ICapabilityProvider {

	/**
	 * New 1.9.4 onwards. Using forge capabilities instead of {@link IInventory}
	 */
	public  ItemStackHandler handler;
	private TileEntityProfiler te;
	private IInventory playerInv;
	
	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityProfiler() {
		
		this.handler = new ItemStackHandler(10);
		
		
	}

	/**
	 * Reads data from nbt where data is stored
	 */
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
	
		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler")); 
		super.readFromNBT(nbt);
	}

	/**
	 * Writes data to nbt so it is stored
	 */
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt2) {
		
		nbt2.setTag("ItemStackHandler", this.handler.serializeNBT()); // We write our ItemStackHandler as a tag in a tag

		return super.writeToNBT(nbt2);
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
		NBTTagCompound nbt2 = new NBTTagCompound();
		this.writeToNBT(nbt2);
		return nbt2;
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
		NBTTagCompound nbt2 = new NBTTagCompound();
		this.writeToNBT(nbt2);
		return nbt2;
	}

	/**
	 * New 1.9.4 onwards. Capability system
	 */
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.handler;
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
		
		
		if (!world.isRemote) {
		IBlockState currentState = this.world.getBlockState(pos);
		EntityPlayer player = Minecraft.getMinecraft().player;
		ProfilerIndex();
		
		
		}
		
	
		
	}
	
	
		
	
	
	public void ProfilerIndex(){
		if(handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.obsidianingot))) {
			Utils.getLogger().info("Item is : "+ handler.getStackInSlot(4).getDisplayName());
			int i = 0;
			if(i == 0){
				handler.getStackInSlot(4).splitStack(1);
				handler.insertItem(7, new ItemStack(ModItems.obsidianingot), false);
				Minecraft.getMinecraft().displayGuiScreen(new GuiProfilerObsidianIngot());
			i = 1;
			}
			
		}
	
			if(handler.getStackInSlot(4).isItemEqual(new ItemStack(ModBlocks.plasticblock))) {
				
				Utils.getLogger().info("Minus Temp");
				
			}
		
		
		
				
	}
	
	

	
	}

	


