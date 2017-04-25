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

	// Sequence Checks
	private boolean sequence33 = false;
	private boolean sequence4 = false;
	private boolean sequence19 = false;
	public static int sequencenumstofind = 3;
	public static boolean sequencecomplete = false;
	public static boolean sequenceclaimed = false;
	public static String[] seqarray = new String[3];


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
	public static String[] primearray = new String[8];

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
	public static String[] evenarray = new String[10];

	public static boolean primeBookGive = false;
	public static boolean evenBookGive = false;
	public static boolean oddBookGive = false;
	public static boolean seqBookGive = false;

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
	public static String[] oddarray = new String[10];

	public ItemStackHandler handler;
	public static String questPrimeNumbers = "Prime Numbers";
	public static String questEvenNumbers = "Even Numbers";
	public static String questOddNumbers = "Odd Numbers";
	public static String questNumberSequence = "Sequence";
	public static String questcomplete = "§a" + "Completed";


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
				player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 10;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_2))) {
				Utils.getLogger().info("Quest item 2 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 10;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_3))) {
				Utils.getLogger().info("Quest item 3 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 10;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_4))) {
				Utils.getLogger().info("Quest item 4 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 10;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_5))) {
				Utils.getLogger().info("Quest item 5 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 10;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_6))) {
				Utils.getLogger().info("Quest item 6 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 10;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_7))) {
				Utils.getLogger().info("Quest item 7 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 10;
			}
			else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_QUEST_ITEM_8))) {
				Utils.getLogger().info("Quest item 8 detected");
				handler.extractItem(4, 1, false);
				player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
				TileEntityPointsBlock.playerScore += 10;
			}
		}
	}


}
