package com.maw79.mods.blocks.pointsblocks;

import com.maw79.mods.handlers.ModSoundHandler;

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

	
	public static int playerScore = 0;
	
	
	public static int halfscorrect = 5;
	public static int thirdscorrect = 5;
	public static int quarterscorrect = 5;
	
	public static boolean halfcomplete = false;
	public static boolean thirdscomplete = false;
	public static boolean quarterscomplete = false;
	
	public static boolean halfclaimed = false;
	public static boolean thirdsclaimed = false;
	public static boolean quartersclaimed = false;
	public static boolean xyzclaimed = false;
	
	
	public static String halfstitle = "Halfs";
	public static String thirdsstitle ="Thirds";
	public static String quarterstitle = "Quarter";
	public static String xyztitle = "Coordinates";
	public static String questcomplete = "§a" + "Completed";
	
	public static boolean fractionmanualgive = false;
	
	private boolean soundcheck1 = false;
	private boolean soundcheck2 = false;
	private boolean soundcheck3 = false;
	
	
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

	if(halfscorrect == 0){
		if(soundcheck1 == false){
		player.playSound(ModSoundHandler.MAWSOUND_TADA, 2.0F, 1.0F);
		soundcheck1 = true;
		}
		halfcomplete=true;
		halfstitle = questcomplete;
	}
	if(thirdscorrect == 0){
		if(soundcheck2 == false){
		player.playSound(ModSoundHandler.MAWSOUND_TADA, 2.0F, 1.0F);
		soundcheck2 = true;
		}
		thirdscomplete=true;
		thirdsstitle = questcomplete;
	}
	if(quarterscorrect == 0){
		if(soundcheck3 == false){
		player.playSound(ModSoundHandler.MAWSOUND_TADA, 2.0F, 1.0F);
		soundcheck3 = true;
		}
		quarterscomplete=true;
		quarterstitle = questcomplete;
	}
	
	

}
		}
	}
