package com.maw79.mods.items;

import com.maw79.mods.main.Reference;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemObsidianingot extends Item {

	public ItemObsidianingot(String unlocalizedName) {
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	}
	
}
