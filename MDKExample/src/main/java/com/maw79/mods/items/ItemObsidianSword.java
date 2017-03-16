package com.maw79.mods.items;

import com.maw79.mods.main.Maw79Mod;
import com.maw79.mods.main.Reference;

import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

	public class ItemObsidianSword extends ItemSword {
		
		public ItemObsidianSword(ToolMaterial material) {
			super(material);
		
			setUnlocalizedName(Reference.MawItems.OBSIDIANSWORD.getUnlocalizedName());
			setRegistryName(Reference.MawItems.OBSIDIANSWORD.getRegistryName());
		
		}

	}


