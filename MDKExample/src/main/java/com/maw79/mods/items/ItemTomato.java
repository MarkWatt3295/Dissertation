package com.maw79.mods.items;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.item.ItemFood;

public class ItemTomato extends ItemFood {

	public ItemTomato() {
		super(4, 0.8F, true);
		setUnlocalizedName(Reference.MawItems.TOMATO.getUnlocalizedName());
		setRegistryName(Reference.MawItems.TOMATO.getRegistryName());
		
	
	}

/*	
 * Default Constructor
 * public ItemTamato(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		Food is 2 x e.g 4 heals 2 health
		second is saturation level
		third is if its feedable to wolfs
	
	} */

}
