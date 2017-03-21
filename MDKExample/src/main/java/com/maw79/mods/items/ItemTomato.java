package com.maw79.mods.items;

import com.maw79.mods.main.Reference;

import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class ItemTomato extends ItemFood {

	public ItemTomato(String unlocalizedName) {
		super(4, 0.8F, true);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
			
	
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
