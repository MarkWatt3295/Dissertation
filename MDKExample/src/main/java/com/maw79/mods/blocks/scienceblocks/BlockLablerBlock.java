package com.maw79.mods.blocks.scienceblocks;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;
import com.maw79.mods.network.MathsMessage;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLablerBlock extends Block {
	
	
	/**
	 * Default constructor which sets the hardness and resistance
	 * @param unlocalizedName The unlocalized name
	 */
	public BlockLablerBlock(String unlocalizedName) {
		super(Material.WOOD);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.setLightLevel(2F);
		
		
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		worldIn.playSound(player, pos, ModSoundHandler.MAWSOUND_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
		 if(!player.world.isRemote)Maw79Mod.NETWORK.sendToServer(new MathsMessage(player));
  
		
		return true; 
	}
	
	
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		
		return true;
	}
	

	

}
