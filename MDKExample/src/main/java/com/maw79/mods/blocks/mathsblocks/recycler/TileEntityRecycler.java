package com.maw79.mods.blocks.mathsblocks.recycler;

import com.maw79.mods.blocks.pointsblocks.TileEntityPointsBlock;
import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.init.ModItems;
import com.maw79.mods.init.ModNumberBlocks;
import com.maw79.mods.init.ModTools;
import com.maw79.mods.util.Utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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

public class TileEntityRecycler extends TileEntity implements ITickable, ICapabilityProvider {

	
	public ItemStackHandler handler;
	

	
	/**
	 * Initializes our variables. MUST NOT HAVE ANY PARAMETERS
	 */
	public TileEntityRecycler() {
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
			//Items and blocks to be recycled
		
						if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.BOOSTER))) {
							Utils.getLogger().info("Booster");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.EVEN_BOOK))) {
							Utils.getLogger().info("Even Book");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.firstbook))) {
							Utils.getLogger().info("First Book");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(Blocks.SANDSTONE))) {
							Utils.getLogger().info("SandStone");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 5;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.HISTORYBOOK))) {
							Utils.getLogger().info("History Book");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.PRIME_BOOK))) {
							Utils.getLogger().info("Prime Book");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.NUMBER_SEQUENCE_BOOK))) {
							Utils.getLogger().info("Seq Book");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.FRACTIONS_BOOK))) {
							Utils.getLogger().info("Fractions Book");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.mathsbook))) {
							Utils.getLogger().info("Maths Book");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.ODD_BOOK))) {
							Utils.getLogger().info("Odd Book");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.questionwand))) {
							Utils.getLogger().info("Wand");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 5;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.fractionstamphalf))) {
							Utils.getLogger().info("fractions half");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 5;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.fractionstampquarter))) {
							Utils.getLogger().info("Fractions quart");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 5;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.fractionstampthird))) {
							Utils.getLogger().info("Fractions third");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 5;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.glassPickaxe))) {
							Utils.getLogger().info("Glass Pick");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 5;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.glassSpade))) {
							Utils.getLogger().info("Spade");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(Blocks.DIRT))) {
							Utils.getLogger().info("Dirt");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 5;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.mediumpaintbrush))) {
							Utils.getLogger().info("med pb");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.paintbrush))) {
							Utils.getLogger().info("pb");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 5;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModTools.rustypaintbrush))) {
							Utils.getLogger().info("Rusty PB");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.BUILDER_COIN))) {
							Utils.getLogger().info("Builder Coin");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 400;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.ENGLISH_TOKEN))) {
							Utils.getLogger().info("English Token");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.FREEPLAY_TOKEN))) {
							Utils.getLogger().info("FP Token");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 200;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.HISTORY_TOKEN))) {
							Utils.getLogger().info("History Token");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 50;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.MATHS_TOKEN))) {
							Utils.getLogger().info("Maths Token");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 50;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.SCIENCE_TOKEN))) {
							Utils.getLogger().info("Science Token");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 50;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.ARROW))) {
							Utils.getLogger().info("Arrow");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.PAINT_ARROW))) {
							Utils.getLogger().info("Paint Arrow");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.BOW))) {
							Utils.getLogger().info("Bow");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 50;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.COORDINATES_MANUAL))) {
							Utils.getLogger().info("Coords manual");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.xaxistool))) {
							Utils.getLogger().info("X axis tool");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.yaxistool))) {
							Utils.getLogger().info("y axis tool");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.zaxistool))) {
							Utils.getLogger().info("z axis tool");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LEVITATION_DUST))) {
							Utils.getLogger().info("Leveitation Dust 1");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LEVITATION_DUST2))) {
							Utils.getLogger().info("Lev dust 2");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.LEVITATION_DUST3))) {
							Utils.getLogger().info("lev dust 3");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.playerlevel))) {
							Utils.getLogger().info("Player level");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 20;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.GRAVITYBOOSTER))) {
							Utils.getLogger().info("Gravity Booster");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number1))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number2))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number3))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number4))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number5))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number5))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number6))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number7))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number8))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number9))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number10))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number11))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number12))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number13))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number14))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number15))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number16))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number17))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number18))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number19))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number20))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number21))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModNumberBlocks.number33))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.EGYPT_MANUAL ))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						else if (handler.getStackInSlot(4).isItemEqual(new ItemStack(ModItems.CHEAT_BOOK ))) {
							Utils.getLogger().info("Number Block");
							handler.extractItem(4, 1, false);
							player.playSound(ModSoundHandler.MAWSOUND_RUSTLE, 1.0F, 1.0F);
							TileEntityPointsBlock.playerScore += 10;
					}
						
						
	
	
	
	
	
	
	
	
	
	

	}

}
}

