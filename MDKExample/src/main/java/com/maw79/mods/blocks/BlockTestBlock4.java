package com.maw79.mods.blocks;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utilities;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockTestBlock4 extends Block {
	
	/**
	 * Default constructor which sets the hardness and resistance
	 * @param unlocalizedName The unlocalized name
	 */
	public BlockTestBlock4(String unlocalizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.setLightLevel(10F);
		
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		//Testing Git
		
		worldIn.playSound(player, pos, ModSoundHandler.MAWSOUND_OPEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
       
	
		 if(!player.world.isRemote) player.sendMessage(new TextComponentString(Utilities.stringToRainbow("TestBlock 4 pressed", true)));
	
		
		
		return true; 
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		
		return true;
	}
	
	@Override
	public boolean canProvidePower(IBlockState state) {
		// TODO Auto-generated method stub
		return super.canProvidePower(state);
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		// TODO Auto-generated method stub
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
	}
	
	

}
