package com.maw79.mods.blocks;

import com.maw79.mods.main.Reference;

import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockSteelFence extends BlockFence {

	public BlockSteelFence(String unlocalizedName) {
		super(Material.IRON, Material.IRON.getMaterialMapColor()); //The block fence class wants us to also put in the materials map colour
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		this.setHardness(3);
		this.setResistance(20);
		this.useNeighborBrightness = true;
	}

}
