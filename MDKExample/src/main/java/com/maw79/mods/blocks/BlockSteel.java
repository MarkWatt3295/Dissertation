package com.maw79.mods.blocks;

import com.maw79.mods.main.Reference;
import com.maw79.mods.util.Utils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSteel extends Block {
	
	/**
	 * Default constructor which sets the hardness and resistance
	 * @param unlocalizedName The unlocalized name
	 */
	public BlockSteel(String unlocalizedName) {
		super(Material.IRON);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
	
		
	}
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		Utils.getLogger().info("Block Pos 1 is: "+pos);
		
		BlockPos posi = new BlockPos(player.posX +2, pos.getY(), pos.getZ());
		this.canProvidePower(getDefaultState());
		
		world.setBlockState(posi, this.getDefaultState());
		
		Utils.getLogger().info("Block Pos 2 is: "+pos);
		
		return true;
	}
	

}
