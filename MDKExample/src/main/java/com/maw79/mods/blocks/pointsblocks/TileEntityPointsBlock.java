package com.maw79.mods.blocks.pointsblocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityPointsBlock extends TileEntity implements ITickable, ICapabilityProvider {

	//Recycler also used as a variable store as TileEntitys save both client and server side
	public static int halfscorrect = 5;
	public static int playerScore = 0;
	
	

	public ItemStackHandler handler;
	

	
	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityPointsBlock() {
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
		/*	if (sequencecomplete == false) {
				if (GuiMathsQuestGive.questnumber == 4) {
					if (sequence33 == false) {
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number33))) {
							Utils.getLogger().info("Block 33 Placed");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_POPCORK, 1.0F, 1.0F);
							GuiNotif.playerScore += 10;
							
							
						}
					}
					

	}
*/
}
		}
	}
