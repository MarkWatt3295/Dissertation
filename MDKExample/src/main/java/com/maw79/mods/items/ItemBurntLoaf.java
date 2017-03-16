package com.maw79.mods.items;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;

public class ItemBurntLoaf extends ItemFood{

	public ItemBurntLoaf(String unlocalizedName) {
		super(4, 0.8F, true);
		this.setUnlocalizedName(unlocalizedName);
		this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
		

}
}