package com.maw79.mods.blocks;

import com.maw79.mods.main.Reference;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;

public class BlockSteelStairs extends BlockStairs{

	public BlockSteelStairs(String unlocalizedName, IBlockState state) {
		super(state);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.useNeighborBrightness = true;
		
	}

}
