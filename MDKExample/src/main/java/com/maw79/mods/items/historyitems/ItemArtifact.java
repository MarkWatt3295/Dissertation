package com.maw79.mods.items.historyitems;

import com.maw79.mods.main.Reference;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ItemArtifact extends Item{
	
public  ItemArtifact (String unlocalizedName) {
	this.setUnlocalizedName(unlocalizedName);
	this.setRegistryName(new ResourceLocation(Reference.MOD_ID, unlocalizedName));
	
}
}