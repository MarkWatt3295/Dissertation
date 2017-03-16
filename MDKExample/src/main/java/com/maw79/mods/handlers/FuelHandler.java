package com.maw79.mods.handlers;

import com.maw79.mods.init.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler{

	
	//1 item is 200 ticks
	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == ModItems.burntloaf)
		return 100;
		if(fuel.getItem() == ModItems.customfuel)
		return 70000;
		return 0;
	}

}
