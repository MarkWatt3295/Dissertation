package com.maw79.mods.blocks.mathsblocks.questblock;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.maw79.mods.client.gui.GuiMathsQuestGive;
import com.maw79.mods.client.gui.GuiNotif;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModBlocks;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModNumberBlocks;
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

public class TileEntityMathsQuest extends TileEntity implements ITickable, ICapabilityProvider {

	// Sequence Checks
	private boolean sequence33 = false;
	private boolean sequence4 = false;
	private boolean sequence19 = false;
	public static boolean sequencecomplete = false;
	public static boolean sequenceclaimed = false;
	
	// Prime Checks
	private boolean prime2 = false;
	private boolean prime3 = false;
	private boolean prime5 = false;
	private boolean prime7 = false;
	private boolean prime11 = false;
	private boolean prime13 = false;
	private boolean prime17 = false;
	private boolean prime19 = false;
	public static boolean primecomplete = false;
	public static boolean primeclaimed = false;

	/**
	 * New 1.9.4 onwards. Using forge capabilities instead of {@link IInventory}
	 */
	public ItemStackHandler handler;
	public static String questPrimeNumbers = "Prime Numbers";
	public static String questEvenNumbers = "Even Numbers";
	public static String questOddNumbers = "Odd Numbers";
	public static String questNumberSequence = "Sequence";
	public static String questcomplete = "§a" + "Completed";

	public ArrayList<ItemStack> insulators = new ArrayList<ItemStack>();

	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityMathsQuest() {
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
			
//##########################################################################################################
//##########################################################################################################
			// Sequence Numbers
			if (sequencecomplete == false) {
				if (GuiMathsQuestGive.questnumber == 4) {
					if (sequence33 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number33))) {
							Utils.getLogger().info("Block 33 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							sequence33 = true;
						}
					}
					if (sequence4 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number4))) {
							Utils.getLogger().info("Block 4 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							sequence4 = true;
						}
					}
					if (sequence19 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number19))) {
							Utils.getLogger().info("Block 19 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							sequence19 = true;
						}
					}

					if (sequence19 == true && sequence33 == true && sequence4 == true) {
						questNumberSequence = questcomplete;
						sequencecomplete = true;
					}
				}

			}
//##########################################################################################################
//##########################################################################################################
			
			
//##########################################################################################################
//##########################################################################################################
						// Prime Numbers
						if (primecomplete == false) {
							if (GuiMathsQuestGive.questnumber == 1) {
								if (prime2 == false) {
									if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number2))) {
										Utils.getLogger().info("Prime: Block 2 Placed");
										handler.extractItem(4, 1, false);
										player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
										GuiNotif.playerScore += 10;
										prime2 = true;
									}
								}
								
								if (prime3 == false) {
									if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number3))) {
										Utils.getLogger().info("Prime: Block 3 Placed");
										handler.extractItem(4, 1, false);
										player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
										GuiNotif.playerScore += 10;
										prime3 = true;
									}
								}
								if (prime5 == false) {
									if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number5))) {
										Utils.getLogger().info("Prime: Block 5 Placed");
										handler.extractItem(4, 1, false);
										player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
										GuiNotif.playerScore += 10;
										prime5 = true;
									}
								}
								if (prime7 == false) {
									if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number7))) {
										Utils.getLogger().info("Prime: Block 7 Placed");
										handler.extractItem(4, 1, false);
										player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
										GuiNotif.playerScore += 10;
										prime7 = true;
									}
								}
								if (prime11 == false) {
									if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number11))) {
										Utils.getLogger().info("Prime: Block 11 Placed");
										handler.extractItem(4, 1, false);
										player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
										GuiNotif.playerScore += 10;
										prime11 = true;
									}
								}
								if (prime13 == false) {
									if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number13))) {
										Utils.getLogger().info("Prime: Block 13 Placed");
										handler.extractItem(4, 1, false);
										player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
										GuiNotif.playerScore += 10;
										prime13 = true;
									}
								}
								if (prime17 == false) {
									if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number17))) {
										Utils.getLogger().info("Prime: Block 17 Placed");
										handler.extractItem(4, 1, false);
										player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
										GuiNotif.playerScore += 10;
										prime17 = true;
									}
								}
								if (prime19 == false) {
									if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number19))) {
										Utils.getLogger().info("Prime: Block 19 Placed");
										handler.extractItem(4, 1, false);
										player.playSound(ModSoundHandler.MAWSOUND_SMRT, 1.0F, 1.0F);
										GuiNotif.playerScore += 10;
										prime19 = true;
									}
								}
								
								if (prime2 = true && prime3 == true && prime5 == true && prime7 == true
										&& prime11 == true && prime13 == true && prime17 == true
										&& prime19 == true) {
									questPrimeNumbers = questcomplete;
									primecomplete = true;
								}

								
							}

						}
//##########################################################################################################
//##########################################################################################################
		}

	}

}
