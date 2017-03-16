package com.maw79.mods.blocks;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRuby extends Block {

	public BlockRuby() {
		
	super(Material.GLASS);
	setUnlocalizedName(Reference.MawBlocks.RUBYBLOCK.getUnlocalizedName());
	setRegistryName(Reference.MawBlocks.RUBYBLOCK.getRegistryName());
	setHardness(2.0F);
	setResistance(15.0F);
	setLightLevel(2.0F);
	
	}

}
