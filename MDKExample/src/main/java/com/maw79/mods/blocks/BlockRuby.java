package com.maw79.mods.blocks;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;

public class BlockRuby extends Block {

	public BlockRuby(String unlocalizedName) {
	super(Material.IRON);
	this.setUnlocalizedName(unlocalizedName);
	this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	setHardness(2.0F);
	setResistance(15.0F);
	setLightLevel(2.0F);
	
	}

}
