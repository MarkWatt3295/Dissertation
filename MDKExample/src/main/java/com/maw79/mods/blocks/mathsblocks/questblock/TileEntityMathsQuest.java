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
	public static int sequencenumstofind = 3;
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
	public static int primenumstofind = 8;
	public static boolean primeclaimed = false;

	//Even Checks
	private boolean even2 = false;
	private boolean even4 = false;
	private boolean even6 = false;
	private boolean even8 = false;
	private boolean even10 = false;
	private boolean even12 = false;
	private boolean even14 = false;
	private boolean even16 = false;
	private boolean even18 = false;
	private boolean even20 = false;
	public static int evennumstofind = 10;
	public static boolean evencomplete = false;
	public static boolean evenclaimed = false;

	//Odd Checks
	private boolean odd1 = false;
	private boolean odd3 = false;
	private boolean odd5 = false;
	private boolean odd7 = false;
	private boolean odd9 = false;
	private boolean odd11 = false;
	private boolean odd13 = false;
	private boolean odd15 = false;
	private boolean odd17 = false;
	private boolean odd19 = false;
	public static int oddnumstofind = 10;
	public static boolean oddcomplete = false;
	public static boolean oddclaimed = false;

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
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							sequence33 = true;
							sequencenumstofind -=1;
						}
					}
					if (sequence4 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number4))) {
							Utils.getLogger().info("Block 4 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							sequence4 = true;
							sequencenumstofind -=1;
						}
					}
					if (sequence19 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number19))) {
							Utils.getLogger().info("Block 19 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							sequence19 = true;
							sequencenumstofind -=1;
						}
					}

					if (sequence19 == true && sequence33 == true && sequence4 == true) {
						questNumberSequence = questcomplete;
						sequencecomplete = true;
						player.playSound(ModSoundHandler.MAWSOUND_TADA, 1.0F, 1.0F);
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
							Utils.getLogger().info("Prime: Block 2 Placed ");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							prime2 = true;
							primenumstofind -=1;
						}
					}
					if (prime3 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number3))) {
							Utils.getLogger().info("Prime: Block 3 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							prime3 = true;
							primenumstofind -=1;
						}
					}
					if (prime5 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number5))) {
							Utils.getLogger().info("Prime: Block 5 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							prime5 = true;
							primenumstofind -=1;
						}
					}
					if (prime7 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number7))) {
							Utils.getLogger().info("Prime: Block 7 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							prime7 = true;
							primenumstofind -=1;
						}
					}
					if (prime11 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number11))) {
							Utils.getLogger().info("Prime: Block 11 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							prime11 = true;
							primenumstofind -=1;
						}
					}
					if (prime13 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number13))) {
							Utils.getLogger().info("Prime: Block 13 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							prime13 = true;
							primenumstofind -=1;
						}
					}
					if (prime17 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number17))) {
							Utils.getLogger().info("Prime: Block 17 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							prime17 = true;
							primenumstofind -=1;
						}
					}
					if (prime19 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number19))) {
							Utils.getLogger().info("Prime: Block 19 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							prime19 = true;
							primenumstofind -=1;
						}
					}

					if (prime2 == true && prime3 == true && prime5 == true && prime7 == true
							&& prime11 == true && prime13 == true && prime17 == true
							&& prime19 == true) {
						questPrimeNumbers = questcomplete;
						primecomplete = true;
						primenumstofind = 0;
						player.playSound(ModSoundHandler.MAWSOUND_TADA, 1.0F, 1.0F);
					}


				}

			}
			//##########################################################################################################
			//##########################################################################################################

			//##########################################################################################################
			//##########################################################################################################
			// Even Numbers
			if (evencomplete == false) {
				if (GuiMathsQuestGive.questnumber == 2) {
					if (even2 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number2))) {
							Utils.getLogger().info("Even :Block 2 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even2 = true;
							evennumstofind -=1;
						}
					}
					if (even4 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number4))) {
							Utils.getLogger().info("Even :Block 4 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even4 = true;
							evennumstofind -=1;
						}
					}
					if (even6 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number6))) {
							Utils.getLogger().info("Even :Block 6 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even6 = true;
							evennumstofind -=1;
						}
					}
					if (even8 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number8))) {
							Utils.getLogger().info("Even :Block 8 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even8 = true;
							evennumstofind -=1;
						}
					}
					if (even10 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number10))) {
							Utils.getLogger().info("Even :Block 10 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even10 = true;
							evennumstofind -=1;
						}
					}
					if (even12 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number12))) {
							Utils.getLogger().info("Even :Block 12 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even12 = true;
							evennumstofind -=1;
						}
					}
					if (even14 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number14))) {
							Utils.getLogger().info("Even :Block 14 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even14 = true;
							evennumstofind -=1;
						}
					}
					if (even14 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number14))) {
							Utils.getLogger().info("Even :Block 14 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even14 = true;
							evennumstofind -=1;
						}
					}
					if (even16 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number16))) {
							Utils.getLogger().info("Even :Block 16 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even16 = true;
							evennumstofind -=1;
						}
					}
					if (even18 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number18))) {
							Utils.getLogger().info("Even :Block 18 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even18 = true;
							evennumstofind -=1;
						}
					}
					if (even20 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number20))) {
							Utils.getLogger().info("Even :Block 20 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							even20 = true;
							evennumstofind -=1;
						}
					}


					if (even2 == true && even4 == true && even6 == true && even8 == true &&
							even10 == true && even12 == true && even14 == true && even16 == true &&
							even18 == true && even20 == true) {
						player.playSound(ModSoundHandler.MAWSOUND_TADA, 1.0F, 1.0F);
						questEvenNumbers = questcomplete;
						evencomplete = true;
						evennumstofind =0;

					}
				}

			}
			//##########################################################################################################
			//##########################################################################################################

			//##########################################################################################################
			//##########################################################################################################
			// Odd Numbers
			if (oddcomplete == false) {
				if (GuiMathsQuestGive.questnumber == 3) {
					if (odd1 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number1))) {
							Utils.getLogger().info("Odd : Block 1 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd1 = true;
							oddnumstofind -=1;
						}
					}
					
					if (odd3 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number3))) {
							Utils.getLogger().info("Odd : Block 3 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd3 = true;
							oddnumstofind -=1;
						}
					}
					if (odd5 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number5))) {
							Utils.getLogger().info("Odd : Block 5 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd5 = true;
							oddnumstofind -=1;
						}
					}
					if (odd7 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number7))) {
							Utils.getLogger().info("Odd : Block 7 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd7 = true;
							oddnumstofind -=1;
						}
					}
					if (odd9 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number9))) {
							Utils.getLogger().info("Odd : Block 9 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd9 = true;
							oddnumstofind -=1;
						}
					}
					if (odd11 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number11))) {
							Utils.getLogger().info("Odd : Block 11 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd11 = true;
							oddnumstofind -=1;
						}
					}
					if (odd13 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number13))) {
							Utils.getLogger().info("Odd : Block 13 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd13 = true;
							oddnumstofind -=1;
						}
					}
					if (odd15 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number15))) {
							Utils.getLogger().info("Odd : Block 15 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd15 = true;
							oddnumstofind -=1;
						}
					}
					if (odd17 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number17))) {
							Utils.getLogger().info("Odd : Block 17 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd17 = true;
							oddnumstofind -=1;
						}
					}
					if (odd19 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number19))) {
							Utils.getLogger().info("Odd : Block 19 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							odd19 = true;
							oddnumstofind -=1;
						}
					}
					if (odd1 == true && odd3 == true && odd5 == true && odd7 == true && odd9 == true &&
							odd11 == true && odd13 == true && odd15 == true && odd17 == true && odd9 == true) {
						questOddNumbers = questcomplete;
						oddcomplete = true;
						oddnumstofind =0;
						player.playSound(ModSoundHandler.MAWSOUND_TADA, 1.0F, 1.0F);
					}
				}

			}
			//##########################################################################################################
			//##########################################################################################################

		}

	}

}
