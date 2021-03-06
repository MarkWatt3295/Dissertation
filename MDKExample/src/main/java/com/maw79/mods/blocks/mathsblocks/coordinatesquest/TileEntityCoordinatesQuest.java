package com.maw79.mods.blocks.mathsblocks.coordinatesquest;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModNumberBlocks;
import com.maw79.mods.util.Utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityCoordinatesQuest extends TileEntity implements ITickable, ICapabilityProvider {

	public static String itemnotfound1 = "Item Not Yet Found";
	public static String itemnotfound2 = "Item Not Yet Found";
	public static String itemnotfound3 = "Item Not Yet Found";
	public static String itemnotfound4 = "Item Not Yet Found";
	public static String itemnotfound5 = "Item Not Yet Found";
	public static String itemnotfound6 = "Item Not Yet Found";
	public static String itemnotfound7 = "Item Not Yet Found";
	public static String itemnotfound8 = "Item Not Yet Found";
	public static String itemfound = "§a"+"Item Found";
	public ItemStackHandler handler;
	public static int itemsleft = 8;
	private  boolean founditem1 = false;
	private  boolean founditem2 = false;
	private  boolean founditem3 = false;
	private  boolean founditem4 = false;
	private  boolean founditem5 = false;
	private  boolean founditem6 = false;
	private  boolean founditem7 = false;
	private  boolean founditem8 = false;
	public static  boolean allfound = false;
	public static boolean xyzmanualgive = false;
	private boolean foundsound = false;
	

	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityCoordinatesQuest() {
		this.handler = new ItemStackHandler(10);

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

			if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_1))) {
				Utils.getLogger().info("Quest item 1 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_CHIME, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 50;
				itemnotfound1 = itemfound;
				founditem1 = true;
				itemsleft -=1;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_2))) {
				Utils.getLogger().info("Quest item 2 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_CHIME, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 50;
				itemnotfound2 = itemfound;
				founditem2 = true;
				itemsleft -=1;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_3))) {
				Utils.getLogger().info("Quest item 3 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_CHIME, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 50;
				itemnotfound3 = itemfound;
				founditem3 = true;
				itemsleft -=1;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_4))) {
				Utils.getLogger().info("Quest item 4 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_CHIME, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 50;
				itemnotfound4 = itemfound;
				founditem4 = true;
				itemsleft -=1;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_5))) {
				Utils.getLogger().info("Quest item 5 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_CHIME, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 50;
				itemnotfound5 = itemfound;
				founditem5 = true;
				itemsleft -=1;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_6))) {
				Utils.getLogger().info("Quest item 6 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_CHIME, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 50;
				itemnotfound6 = itemfound;
				founditem6 = true;
				itemsleft -=1;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_7))) {
				Utils.getLogger().info("Quest item 7 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_CHIME, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 50;
				itemnotfound7 = itemfound;
				founditem7 = true;
				itemsleft -=1;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_8))) {
				Utils.getLogger().info("Quest item 8 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_CHIME, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 50;
				itemnotfound8 = itemfound;
				founditem8 = true;
				itemsleft -=1;
			}
			
			if(founditem1 == true && founditem2 == true && founditem3 == true && founditem4 == true
					&& founditem5 == true && founditem6 == true && founditem7 == true && founditem8 == true){
				allfound = true;
			}
			
			if(allfound == true){
				if(foundsound==false){
				player.playSound(ModSoundHandler.MAWSOUND_TADA, 3.0F, 1.0F);
				foundsound=true;
				TileEntityPointsBlock.xyztitle = TileEntityPointsBlock.questcomplete;
				}
			}
		}
	}


}
