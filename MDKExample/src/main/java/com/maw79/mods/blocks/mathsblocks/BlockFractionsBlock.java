package com.maw79.mods.blocks.mathsblocks;

import com.maw79.mods.handlers.ModSoundHandler;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockFractionsBlock extends Block {
	
	public BlockFractionsBlock(String unlocalizedName) {
		super(Material.CLOTH);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(1);
		this.setResistance(1);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
	
		player.sendMessage(new TextComponentString("I am :"+ this.getLocalizedName()));
		player.sendMessage(new TextComponentString("I am :"+ this.getUnlocalizedName()));
		player.sendMessage(new TextComponentString("I am :"+ this.getRegistryName()));
	
		return true; 
	}
}